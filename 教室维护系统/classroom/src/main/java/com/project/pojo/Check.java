package com.project.pojo;

import java.util.Date;

public class Check {
    private Integer checkId;

    private String checkCode;

    private Date checkCreateTime;

    private Date checkUpdateTime;

    private Date checkTime;

    private Integer checkState;

    private Integer roomId;

    private String roomCode;

    private Integer roomIsDamageWindow;

    private Integer roomDamageWindowNumber;

    private Integer roomIsDamageChair;

    private Integer roomDamageChairNumber;

    private Integer roomIsNeedChalk;

    private Integer roomNeedChalkNumber;

    private Integer roomIsDamagePlatform;

    private String roomDamagePlatformReason;

    private Integer roomIsDamageBlackboard;

    private String roomDamageBlackboardReason;

    private Integer roomIsDamageMedia;

    private String roomDamageMediaReason;

    private Integer roomIsDamageMicrophone;

    private String roomDamageMicrophoneReason;

    private Integer roomIsDamageDoor;

    private Integer roomDamageDoorNumber;

    private String roomDamageDoorReason;

    private Integer roomIsDamageSound;

    private Integer roomDamageSoundNumber;

    private String roomDamageSoundReason;

    private Integer roomIsDamageCurtains;

    private Integer roomDamageCurtainsNumber;

    private String roomDamageCurtainsReason;

    public Check(Integer checkId, String checkCode, Date checkCreateTime, Date checkUpdateTime, Date checkTime, Integer checkState, Integer roomId, String roomCode, Integer roomIsDamageWindow, Integer roomDamageWindowNumber, Integer roomIsDamageChair, Integer roomDamageChairNumber, Integer roomIsNeedChalk, Integer roomNeedChalkNumber, Integer roomIsDamagePlatform, String roomDamagePlatformReason, Integer roomIsDamageBlackboard, String roomDamageBlackboardReason, Integer roomIsDamageMedia, String roomDamageMediaReason, Integer roomIsDamageMicrophone, String roomDamageMicrophoneReason, Integer roomIsDamageDoor, Integer roomDamageDoorNumber, String roomDamageDoorReason, Integer roomIsDamageSound, Integer roomDamageSoundNumber, String roomDamageSoundReason, Integer roomIsDamageCurtains, Integer roomDamageCurtainsNumber, String roomDamageCurtainsReason) {
        this.checkId = checkId;
        this.checkCode = checkCode;
        this.checkCreateTime = checkCreateTime;
        this.checkUpdateTime = checkUpdateTime;
        this.checkTime = checkTime;
        this.checkState = checkState;
        this.roomId = roomId;
        this.roomCode = roomCode;
        this.roomIsDamageWindow = roomIsDamageWindow;
        this.roomDamageWindowNumber = roomDamageWindowNumber;
        this.roomIsDamageChair = roomIsDamageChair;
        this.roomDamageChairNumber = roomDamageChairNumber;
        this.roomIsNeedChalk = roomIsNeedChalk;
        this.roomNeedChalkNumber = roomNeedChalkNumber;
        this.roomIsDamagePlatform = roomIsDamagePlatform;
        this.roomDamagePlatformReason = roomDamagePlatformReason;
        this.roomIsDamageBlackboard = roomIsDamageBlackboard;
        this.roomDamageBlackboardReason = roomDamageBlackboardReason;
        this.roomIsDamageMedia = roomIsDamageMedia;
        this.roomDamageMediaReason = roomDamageMediaReason;
        this.roomIsDamageMicrophone = roomIsDamageMicrophone;
        this.roomDamageMicrophoneReason = roomDamageMicrophoneReason;
        this.roomIsDamageDoor = roomIsDamageDoor;
        this.roomDamageDoorNumber = roomDamageDoorNumber;
        this.roomDamageDoorReason = roomDamageDoorReason;
        this.roomIsDamageSound = roomIsDamageSound;
        this.roomDamageSoundNumber = roomDamageSoundNumber;
        this.roomDamageSoundReason = roomDamageSoundReason;
        this.roomIsDamageCurtains = roomIsDamageCurtains;
        this.roomDamageCurtainsNumber = roomDamageCurtainsNumber;
        this.roomDamageCurtainsReason = roomDamageCurtainsReason;
    }

    public Check() {
        super();
    }

    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode == null ? null : checkCode.trim();
    }

    public Date getCheckCreateTime() {
        return checkCreateTime;
    }

    public void setCheckCreateTime(Date checkCreateTime) {
        this.checkCreateTime = checkCreateTime;
    }

    public Date getCheckUpdateTime() {
        return checkUpdateTime;
    }

    public void setCheckUpdateTime(Date checkUpdateTime) {
        this.checkUpdateTime = checkUpdateTime;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Integer getCheckState() {
        return checkState;
    }

    public void setCheckState(Integer checkState) {
        this.checkState = checkState;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode == null ? null : roomCode.trim();
    }

    public Integer getRoomIsDamageWindow() {
        return roomIsDamageWindow;
    }

    public void setRoomIsDamageWindow(Integer roomIsDamageWindow) {
        this.roomIsDamageWindow = roomIsDamageWindow;
    }

    public Integer getRoomDamageWindowNumber() {
        return roomDamageWindowNumber;
    }

    public void setRoomDamageWindowNumber(Integer roomDamageWindowNumber) {
        this.roomDamageWindowNumber = roomDamageWindowNumber;
    }

    public Integer getRoomIsDamageChair() {
        return roomIsDamageChair;
    }

    public void setRoomIsDamageChair(Integer roomIsDamageChair) {
        this.roomIsDamageChair = roomIsDamageChair;
    }

    public Integer getRoomDamageChairNumber() {
        return roomDamageChairNumber;
    }

    public void setRoomDamageChairNumber(Integer roomDamageChairNumber) {
        this.roomDamageChairNumber = roomDamageChairNumber;
    }

    public Integer getRoomIsNeedChalk() {
        return roomIsNeedChalk;
    }

    public void setRoomIsNeedChalk(Integer roomIsNeedChalk) {
        this.roomIsNeedChalk = roomIsNeedChalk;
    }

    public Integer getRoomNeedChalkNumber() {
        return roomNeedChalkNumber;
    }

    public void setRoomNeedChalkNumber(Integer roomNeedChalkNumber) {
        this.roomNeedChalkNumber = roomNeedChalkNumber;
    }

    public Integer getRoomIsDamagePlatform() {
        return roomIsDamagePlatform;
    }

    public void setRoomIsDamagePlatform(Integer roomIsDamagePlatform) {
        this.roomIsDamagePlatform = roomIsDamagePlatform;
    }

    public String getRoomDamagePlatformReason() {
        return roomDamagePlatformReason;
    }

    public void setRoomDamagePlatformReason(String roomDamagePlatformReason) {
        this.roomDamagePlatformReason = roomDamagePlatformReason == null ? null : roomDamagePlatformReason.trim();
    }

    public Integer getRoomIsDamageBlackboard() {
        return roomIsDamageBlackboard;
    }

    public void setRoomIsDamageBlackboard(Integer roomIsDamageBlackboard) {
        this.roomIsDamageBlackboard = roomIsDamageBlackboard;
    }

    public String getRoomDamageBlackboardReason() {
        return roomDamageBlackboardReason;
    }

    public void setRoomDamageBlackboardReason(String roomDamageBlackboardReason) {
        this.roomDamageBlackboardReason = roomDamageBlackboardReason == null ? null : roomDamageBlackboardReason.trim();
    }

    public Integer getRoomIsDamageMedia() {
        return roomIsDamageMedia;
    }

    public void setRoomIsDamageMedia(Integer roomIsDamageMedia) {
        this.roomIsDamageMedia = roomIsDamageMedia;
    }

    public String getRoomDamageMediaReason() {
        return roomDamageMediaReason;
    }

    public void setRoomDamageMediaReason(String roomDamageMediaReason) {
        this.roomDamageMediaReason = roomDamageMediaReason == null ? null : roomDamageMediaReason.trim();
    }

    public Integer getRoomIsDamageMicrophone() {
        return roomIsDamageMicrophone;
    }

    public void setRoomIsDamageMicrophone(Integer roomIsDamageMicrophone) {
        this.roomIsDamageMicrophone = roomIsDamageMicrophone;
    }

    public String getRoomDamageMicrophoneReason() {
        return roomDamageMicrophoneReason;
    }

    public void setRoomDamageMicrophoneReason(String roomDamageMicrophoneReason) {
        this.roomDamageMicrophoneReason = roomDamageMicrophoneReason == null ? null : roomDamageMicrophoneReason.trim();
    }

    public Integer getRoomIsDamageDoor() {
        return roomIsDamageDoor;
    }

    public void setRoomIsDamageDoor(Integer roomIsDamageDoor) {
        this.roomIsDamageDoor = roomIsDamageDoor;
    }

    public Integer getRoomDamageDoorNumber() {
        return roomDamageDoorNumber;
    }

    public void setRoomDamageDoorNumber(Integer roomDamageDoorNumber) {
        this.roomDamageDoorNumber = roomDamageDoorNumber;
    }

    public String getRoomDamageDoorReason() {
        return roomDamageDoorReason;
    }

    public void setRoomDamageDoorReason(String roomDamageDoorReason) {
        this.roomDamageDoorReason = roomDamageDoorReason == null ? null : roomDamageDoorReason.trim();
    }

    public Integer getRoomIsDamageSound() {
        return roomIsDamageSound;
    }

    public void setRoomIsDamageSound(Integer roomIsDamageSound) {
        this.roomIsDamageSound = roomIsDamageSound;
    }

    public Integer getRoomDamageSoundNumber() {
        return roomDamageSoundNumber;
    }

    public void setRoomDamageSoundNumber(Integer roomDamageSoundNumber) {
        this.roomDamageSoundNumber = roomDamageSoundNumber;
    }

    public String getRoomDamageSoundReason() {
        return roomDamageSoundReason;
    }

    public void setRoomDamageSoundReason(String roomDamageSoundReason) {
        this.roomDamageSoundReason = roomDamageSoundReason == null ? null : roomDamageSoundReason.trim();
    }

    public Integer getRoomIsDamageCurtains() {
        return roomIsDamageCurtains;
    }

    public void setRoomIsDamageCurtains(Integer roomIsDamageCurtains) {
        this.roomIsDamageCurtains = roomIsDamageCurtains;
    }

    public Integer getRoomDamageCurtainsNumber() {
        return roomDamageCurtainsNumber;
    }

    public void setRoomDamageCurtainsNumber(Integer roomDamageCurtainsNumber) {
        this.roomDamageCurtainsNumber = roomDamageCurtainsNumber;
    }

    public String getRoomDamageCurtainsReason() {
        return roomDamageCurtainsReason;
    }

    public void setRoomDamageCurtainsReason(String roomDamageCurtainsReason) {
        this.roomDamageCurtainsReason = roomDamageCurtainsReason == null ? null : roomDamageCurtainsReason.trim();
    }
}