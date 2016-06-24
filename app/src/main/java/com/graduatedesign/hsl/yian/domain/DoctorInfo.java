package com.graduatedesign.hsl.yian.domain;

/**
 * Created by Mesogene on 6/1/16.
 */
public class DoctorInfo {
    private Long id;
    private Integer doctorId;
    private String doctorName;
    private String doctorSex;
    private Integer doctorAge;
    private String doctorPhoneNumber;
    private String doctorIdentity;
    private String doctorPassword;
    private String doctorUnitName;
    private String doctorDepartmentName;
    private String doctorAddress;
    private Integer doctorState;
    private String doctorRemark;
    private String doctorWechat;
    private String doctorIntroduction;
    private String tempPictureLocationId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DoctorInfo(Integer doctorId, String doctorSex, String doctorName, Integer doctorAge, String doctorPhoneNumber, String doctorIdentity, String doctorPassword, String doctorUnitName, Integer doctorState, String doctorAddress, String doctorDepartmentName, String doctorRemark, String doctorIntroduction, String doctorWechat, String tempPictureLocationId) {
        this.doctorId = doctorId;
        this.doctorSex = doctorSex;
        this.doctorName = doctorName;
        this.doctorAge = doctorAge;
        this.doctorPhoneNumber = doctorPhoneNumber;
        this.doctorIdentity = doctorIdentity;
        this.doctorPassword = doctorPassword;
        this.doctorUnitName = doctorUnitName;
        this.doctorState = doctorState;
        this.doctorAddress = doctorAddress;
        this.doctorDepartmentName = doctorDepartmentName;
        this.doctorRemark = doctorRemark;
        this.doctorIntroduction = doctorIntroduction;
        this.doctorWechat = doctorWechat;
        this.tempPictureLocationId = tempPictureLocationId;
    }

    public DoctorInfo(Integer doctorId, String doctorName, String doctorSex, String doctorPhoneNumber, String doctorIdentity, String doctorWechat, String doctorAddress) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorSex = doctorSex;
        this.doctorPhoneNumber = doctorPhoneNumber;
        this.doctorIdentity = doctorIdentity;
        this.doctorWechat = doctorWechat;
        this.doctorAddress = doctorAddress;
    }

    public DoctorInfo(String doctorName, String doctorPassword) {
        this.doctorName = doctorName;
        this.doctorPassword = doctorPassword;
    }

    public DoctorInfo() {
    }

    public DoctorInfo(Integer doctorId, String doctorName, String doctorSex, String doctorPhoneNumber, String doctorIdentity, String doctorAddress, String doctorWechat, String tempPictureLocationId) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorSex = doctorSex;
        this.doctorPhoneNumber = doctorPhoneNumber;
        this.doctorIdentity = doctorIdentity;
        this.doctorAddress = doctorAddress;
        this.doctorWechat = doctorWechat;
        this.tempPictureLocationId = tempPictureLocationId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Integer getDoctorAge() {
        return doctorAge;
    }

    public void setDoctorAge(Integer doctorAge) {
        this.doctorAge = doctorAge;
    }

    public String getDoctorSex() {
        return doctorSex;
    }

    public void setDoctorSex(String doctorSex) {
        this.doctorSex = doctorSex;
    }

    public String getDoctorPhoneNumber() {
        return doctorPhoneNumber;
    }

    public void setDoctorPhoneNumber(String doctorPhoneNumber) {
        this.doctorPhoneNumber = doctorPhoneNumber;
    }

    public String getDoctorIdentity() {
        return doctorIdentity;
    }

    public void setDoctorIdentity(String doctorIdentity) {
        this.doctorIdentity = doctorIdentity;
    }

    public String getDoctorPassword() {
        return doctorPassword;
    }

    public void setDoctorPassword(String doctorPassword) {
        this.doctorPassword = doctorPassword;
    }

    public String getDoctorUnitName() {
        return doctorUnitName;
    }

    public void setDoctorUnitName(String doctorUnitName) {
        this.doctorUnitName = doctorUnitName;
    }

    public String getDoctorDepartmentName() {
        return doctorDepartmentName;
    }

    public void setDoctorDepartmentName(String doctorDepartmentName) {
        this.doctorDepartmentName = doctorDepartmentName;
    }

    public Integer getDoctorState() {
        return doctorState;
    }

    public void setDoctorState(Integer doctorState) {
        this.doctorState = doctorState;
    }

    public String getDoctorAddress() {
        return doctorAddress;
    }

    public void setDoctorAddress(String doctorAddress) {
        this.doctorAddress = doctorAddress;
    }

    public String getDoctorRemark() {
        return doctorRemark;
    }

    public void setDoctorRemark(String doctorRemark) {
        this.doctorRemark = doctorRemark;
    }

    public String getDoctorWechat() {
        return doctorWechat;
    }

    public void setDoctorWechat(String doctorWechat) {
        this.doctorWechat = doctorWechat;
    }

    public String getDoctorIntroduction() {
        return doctorIntroduction;
    }

    public void setDoctorIntroduction(String doctorIntroduction) {
        this.doctorIntroduction = doctorIntroduction;
    }

    public String getTempPictureLocationId() {
        return tempPictureLocationId;
    }

    public void setTempPictureLocationId(String tempPictureLocationId) {
        this.tempPictureLocationId = tempPictureLocationId;
    }
}
