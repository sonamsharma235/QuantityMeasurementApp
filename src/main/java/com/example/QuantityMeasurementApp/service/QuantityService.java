package com.example.QuantityMeasurementApp.service;

import com.example.QuantityMeasurementApp.core.Quantity;
import com.example.QuantityMeasurementApp.entity.OperationHistoryEntity;
import com.example.QuantityMeasurementApp.units.IMeasurable;

import java.util.List;

import org.springframework.stereotype.Service;

//@Service
//public interface QuantityService {
//    Quantity<?> add(Quantity<?> q1, Quantity<?> q2) throws Exception;
//
//    Quantity<?> subtract(Quantity<?> q1, Quantity<?> q2) throws Exception;
//
//    double divide(Quantity<?> q1, Quantity<?> q2) throws Exception;
//
//    boolean checkEquality(Quantity<?> q1, Quantity<?> q2) throws Exception;
//
//    Quantity<?> convert(Quantity<?> quantity, IMeasurable targetUnit, String email);
//
//    List<OperationHistoryEntity> getUserHistory(String email);
//}

public interface QuantityService {

    Quantity<?> add(Quantity<?> q1, Quantity<?> q2, String email) throws Exception;

    Quantity<?> subtract(Quantity<?> q1, Quantity<?> q2, String email) throws Exception;

    double divide(Quantity<?> q1, Quantity<?> q2, String email) throws Exception;

    boolean checkEquality(Quantity<?> q1, Quantity<?> q2, String email) throws Exception;

    Quantity<?> convert(Quantity<?> quantity, IMeasurable targetUnit, String email);

    List<OperationHistoryEntity> getUserHistory(String email);
}