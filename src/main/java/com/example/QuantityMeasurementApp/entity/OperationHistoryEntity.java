package com.example.QuantityMeasurementApp.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class OperationHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String operation;
    private String operand1;
    private String operand2;
    private String result;

    // 🔥 ADD THIS (VERY IMPORTANT)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    // 🔥 ADD TIMESTAMP
    private LocalDateTime createdAt;

    // Constructors
    public OperationHistoryEntity() {}

    public OperationHistoryEntity(String operation, String operand1, String operand2, String result, UserEntity user) {
        this.operation = operation;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.result = result;
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }

    // Getters & Setters

    public Long getId() { return id; }

    public String getOperation() { return operation; }
    public void setOperation(String operation) { this.operation = operation; }

    public String getOperand1() { return operand1; }
    public void setOperand1(String operand1) { this.operand1 = operand1; }

    public String getOperand2() { return operand2; }
    public void setOperand2(String operand2) { this.operand2 = operand2; }

    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }

    public UserEntity getUser() { return user; }
    public void setUser(UserEntity user) { this.user = user; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}