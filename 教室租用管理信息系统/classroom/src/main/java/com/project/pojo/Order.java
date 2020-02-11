package com.project.pojo;

import java.util.Date;

public class Order {
    private Integer orderId;

    private String orderCode;

    private Integer orderState;

    private Integer orderExamineState;

    private Date orderAppointmentTime;

    private String orderPurpose;

    private String orderSelection;

    private String orderRemark;

    private String orderResult;

    private Date orderCreateTime;

    private Date orderUpdateTime;

    private String roomCode;

    private String roomBuilding;

    private String roomNumber;

    private String studentCode;

    private String studentName;

    private String studentCollege;

    private String studentClass;

    private String tercherCode;

    private String tercherName;

    public Order(Integer orderId, String orderCode, Integer orderState, Integer orderExamineState, Date orderAppointmentTime, String orderPurpose, String orderSelection, String orderRemark, String orderResult, Date orderCreateTime, Date orderUpdateTime, String roomCode, String roomBuilding, String roomNumber, String studentCode, String studentName, String studentCollege, String studentClass, String tercherCode, String tercherName) {
        this.orderId = orderId;
        this.orderCode = orderCode;
        this.orderState = orderState;
        this.orderExamineState = orderExamineState;
        this.orderAppointmentTime = orderAppointmentTime;
        this.orderPurpose = orderPurpose;
        this.orderSelection = orderSelection;
        this.orderRemark = orderRemark;
        this.orderResult = orderResult;
        this.orderCreateTime = orderCreateTime;
        this.orderUpdateTime = orderUpdateTime;
        this.roomCode = roomCode;
        this.roomBuilding = roomBuilding;
        this.roomNumber = roomNumber;
        this.studentCode = studentCode;
        this.studentName = studentName;
        this.studentCollege = studentCollege;
        this.studentClass = studentClass;
        this.tercherCode = tercherCode;
        this.tercherName = tercherName;
    }

    public Order() {
        super();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public Integer getOrderExamineState() {
        return orderExamineState;
    }

    public void setOrderExamineState(Integer orderExamineState) {
        this.orderExamineState = orderExamineState;
    }

    public Date getOrderAppointmentTime() {
        return orderAppointmentTime;
    }

    public void setOrderAppointmentTime(Date orderAppointmentTime) {
        this.orderAppointmentTime = orderAppointmentTime;
    }

    public String getOrderPurpose() {
        return orderPurpose;
    }

    public void setOrderPurpose(String orderPurpose) {
        this.orderPurpose = orderPurpose == null ? null : orderPurpose.trim();
    }

    public String getOrderSelection() {
        return orderSelection;
    }

    public void setOrderSelection(String orderSelection) {
        this.orderSelection = orderSelection == null ? null : orderSelection.trim();
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark == null ? null : orderRemark.trim();
    }

    public String getOrderResult() {
        return orderResult;
    }

    public void setOrderResult(String orderResult) {
        this.orderResult = orderResult == null ? null : orderResult.trim();
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public Date getOrderUpdateTime() {
        return orderUpdateTime;
    }

    public void setOrderUpdateTime(Date orderUpdateTime) {
        this.orderUpdateTime = orderUpdateTime;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode == null ? null : roomCode.trim();
    }

    public String getRoomBuilding() {
        return roomBuilding;
    }

    public void setRoomBuilding(String roomBuilding) {
        this.roomBuilding = roomBuilding == null ? null : roomBuilding.trim();
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber == null ? null : roomNumber.trim();
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode == null ? null : studentCode.trim();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getStudentCollege() {
        return studentCollege;
    }

    public void setStudentCollege(String studentCollege) {
        this.studentCollege = studentCollege == null ? null : studentCollege.trim();
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass == null ? null : studentClass.trim();
    }

    public String getTercherCode() {
        return tercherCode;
    }

    public void setTercherCode(String tercherCode) {
        this.tercherCode = tercherCode == null ? null : tercherCode.trim();
    }

    public String getTercherName() {
        return tercherName;
    }

    public void setTercherName(String tercherName) {
        this.tercherName = tercherName == null ? null : tercherName.trim();
    }
}