package com.graduatedesign.hsl.yian.domain;

/**
 * Created by Mesogene on 5/2/16.
 */
public class PatientInfo {
    private Long id;
    private Integer patientId;
    private String patientName;
    private String patientSex;
    private Integer patientAge;
    private String patientPhoneNumber;
    private String patientIdentityCard;
    private Integer patientHeight;
    private Double patientWeight;
    private String patientPosture;
    private String patientProfessional;
    private String patientAddress;
    private String patientRemark;

    public PatientInfo() {
    }

    public PatientInfo(Integer patientId, String patientName, String patientSex, Integer patientAge, String patientPhoneNumber, String patientRemark, Integer patientHeight, Double patientWeight, String patientPosture, String patientProfessional, String patientIdentityCard, String patientAddress) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientSex = patientSex;
        this.patientAge = patientAge;
        this.patientPhoneNumber = patientPhoneNumber;
        this.patientIdentityCard = patientIdentityCard;
        this.patientHeight = patientHeight;
        this.patientWeight = patientWeight;
        this.patientPosture = patientPosture;
        this.patientProfessional = patientProfessional;
        this.patientAddress = patientAddress;
        this.patientRemark = patientRemark;
    }

    public PatientInfo(Integer patientId, Long id, String patientRemark, String patientAddress, String patientProfessional) {
        this.patientId = patientId;
        this.id = id;
        this.patientRemark = patientRemark;
        this.patientAddress = patientAddress;

        this.patientProfessional = patientProfessional;
    }

    public PatientInfo(Long id) {
        this.id = id;
    }

    public PatientInfo( String patientName, String patientSex, Integer patientAge, String patientPhoneNumber, String patientRemark, Integer patientHeight, Double patientWeight, String patientPosture, String patientProfessional, String patientIdentityCard, String patientAddress) {
        this.patientName = patientName;
        this.patientRemark = patientRemark;
        this.patientAddress = patientAddress;
        this.patientProfessional = patientProfessional;
        this.patientPosture = patientPosture;
        this.patientWeight = patientWeight;
        this.patientHeight = patientHeight;
        this.patientIdentityCard = patientIdentityCard;
        this.patientPhoneNumber = patientPhoneNumber;
        this.patientAge = patientAge;
        this.patientSex = patientSex;
    }
    public PatientInfo( String patientName,String patientSex, Integer patientAge, String patientPhoneNumber,String patientRemark ) {
        this.patientName = patientName;
        this.patientRemark = patientRemark;
        this.patientPhoneNumber = patientPhoneNumber;
        this.patientAge = patientAge;
        this.patientSex = patientSex;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getpatientAddress() {
        return patientAddress;
    }

    public void setpatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public Integer getpatientAge() {
        return patientAge;
    }

    public void setpatientAge(Integer patientAge) {
        this.patientAge = patientAge;
    }

    public Integer getpatientHeight() {
        return patientHeight;
    }

    public void setpatientHeight(Integer patientHeight) {
        this.patientHeight = patientHeight;
    }

    public Integer getpatientId() {
        return patientId;
    }

    public void setpatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getpatientIdentityCard() {
        return patientIdentityCard;
    }

    public void setpatientIdentityCard(String patientIdentityCard) {
        this.patientIdentityCard = patientIdentityCard;
    }

    public String getpatientName() {
        return patientName;
    }

    public void setpatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getpatientPhoneNumber() {
        return patientPhoneNumber;
    }

    public void setpatientPhoneNumber(String patientPhoneNumber) {
        this.patientPhoneNumber = patientPhoneNumber;
    }

    public String getpatientPosture() {
        return patientPosture;
    }

    public void setpatientPosture(String patientPosture) {
        this.patientPosture = patientPosture;
    }

    public String getpatientProfessional() {
        return patientProfessional;
    }

    public void setpatientProfessional(String patientProfessional) {
        this.patientProfessional = patientProfessional;
    }

    public String getpatientRemark() {
        return patientRemark;
    }

    public void setpatientRemark(String patientRemark) {
        this.patientRemark = patientRemark;
    }

    public String getpatientSex() {
        return patientSex;
    }

    public void setpatientSex(String patientSex) {
        this.patientSex = patientSex;
    }

    public Double getpatientWeight() {
        return patientWeight;
    }

    public void setpatientWeight(Double patientWeight) {
        this.patientWeight = patientWeight;
    }
}
