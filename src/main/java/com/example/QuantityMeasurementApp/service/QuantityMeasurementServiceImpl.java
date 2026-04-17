package com.example.QuantityMeasurementApp.service;

import com.example.QuantityMeasurementApp.core.Quantity;

import com.example.QuantityMeasurementApp.entity.OperationHistoryEntity;
import com.example.QuantityMeasurementApp.entity.QuantityMeasurementEntity;
import com.example.QuantityMeasurementApp.entity.UserEntity;
import com.example.QuantityMeasurementApp.repository.OperationHistoryRepository;
import com.example.QuantityMeasurementApp.repository.QuantityMeasurementRepository;
import com.example.QuantityMeasurementApp.repository.UserRepository;
import com.example.QuantityMeasurementApp.units.IMeasurable;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class QuantityMeasurementServiceImpl implements QuantityService{
    private final QuantityMeasurementRepository repo;

    private final OperationHistoryRepository historyRepo;
    private final UserRepository userRepository;


    public QuantityMeasurementServiceImpl(
            QuantityMeasurementRepository repo,
            OperationHistoryRepository historyRepo,
            UserRepository userRepository
    ) {
        this.repo = repo;
        this.historyRepo = historyRepo;
        this.userRepository = userRepository;
    }

    private void save(Quantity<?> q) {
        repo.save(new QuantityMeasurementEntity(
                q.getValue(),
                q.getUnit().getUnitName(),
                q.getUnit().getClass().getSimpleName()
        ));
    }
    private void saveHistory(String op, Quantity<?> q1, Quantity<?> q2, Object result, UserEntity user) {

        OperationHistoryEntity history = new OperationHistoryEntity(
                op,
                q1.toString(),
                q2 != null ? q2.toString() : null,
                result.toString(),
                user
        );

        historyRepo.save(history);
    }

    @Override
    public Quantity<?> add(Quantity<?> q1, Quantity<?> q2, String email) throws Exception {

        UserEntity user = userRepository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Quantity<?> result = q1.add(q2);

        save(q1);
        save(q2);
        saveHistory("ADD", q1, q2, result, user);

        return result;
    }

    @Override
    public Quantity<?> subtract(Quantity<?> q1, Quantity<?> q2, String email) throws Exception {

        UserEntity user = userRepository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Quantity<?> result = q1.subtract(q2);

        save(q1);
        save(q2);
        saveHistory("SUBTRACT", q1, q2, result, user);

        return result;
    }

    @Override
    public double divide(Quantity<?> q1, Quantity<?> q2, String email) throws Exception {

        UserEntity user = userRepository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        double result = q1.divide(q2);

        save(q1);
        save(q2);
        saveHistory("DIVIDE", q1, q2, result, user);

        return result;
    }

    @Override
    public boolean checkEquality(Quantity<?> q1, Quantity<?> q2, String email) throws Exception {

        UserEntity user = userRepository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        boolean result = q1.equals(q2);

        save(q1);
        save(q2);
        saveHistory("COMPARE", q1, q2, result, user);

        return result;
    }

//    @Override
//    public Quantity<?> convert(Quantity<?> quantity, IMeasurable targetUnit) {
//        Quantity<?> result = quantity.convertTo(targetUnit);
//        save(quantity);
//        saveHistory("CONVERT",quantity,null,result);
//        return result;
//    }
    
    @Override
    public Quantity<?> convert(Quantity<?> quantity, IMeasurable targetUnit, String email) {

        UserEntity user = userRepository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Quantity<?> result = quantity.convertTo(targetUnit);

        save(quantity);
        saveHistory("CONVERT", quantity, null, result, user);

        return result;
    }
    
    public List<OperationHistoryEntity> getUserHistory(String email) {

        UserEntity user = userRepository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return historyRepo.findByUser(user);
    }

}