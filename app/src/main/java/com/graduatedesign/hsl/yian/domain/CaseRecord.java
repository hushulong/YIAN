package com.graduatedesign.hsl.yian.domain;

import java.sql.Date;

/**
 * Created by Mesogene on 5/2/16.
 */
public class CaseRecord {
    private Long id;
    private Integer caseId;
    private String tempPatientId;
    private String tempDoctorId;
    private String tempDiseaseId;
    private String clinicalTime;
    private Date caseDate;
    private String patientTalk;
    private String medicalHistory;
    private String diagnosis;
    private String tempDoctorPrescriptionId;
    private String curativeEffect;
    private String caseRemark;
    private String tipsContent;
    private String tempPictureLocationId;
    private String tempSyndromeId;
    private String tempInquiryResultId;

    public CaseRecord() {
    }

    public CaseRecord(Integer caseId, String tempPatientId, String tempDoctorId, String tempDiseaseId, String clinicalTime, Date caseDate, String patientTalk, String medicalHistory, String diagnosis, String tempDoctorPrescriptionId, String curativeEffect, String caseRemark, String tipsContent, String tempPictureLocationId, String tempSyndromeId, String tempInquiryResultId) {

        this.caseId = caseId;
        this.tempPatientId = tempPatientId;
        this.tempDoctorId = tempDoctorId;
        this.tempDiseaseId = tempDiseaseId;
        this.clinicalTime = clinicalTime;
        this.caseDate = caseDate;
        this.patientTalk = patientTalk;
        this.medicalHistory = medicalHistory;
        this.diagnosis = diagnosis;
        this.tempDoctorPrescriptionId = tempDoctorPrescriptionId;
        this.curativeEffect = curativeEffect;
        this.caseRemark = caseRemark;
        this.tipsContent = tipsContent;
        this.tempPictureLocationId = tempPictureLocationId;
        this.tempSyndromeId = tempSyndromeId;
        this.tempInquiryResultId = tempInquiryResultId;
    }

    public CaseRecord(Integer caseId, String tipsContent, String patientTalk, String curativeEffect) {
        this.caseId = caseId;
        this.tipsContent = tipsContent;
        this.patientTalk = patientTalk;
        this.curativeEffect = curativeEffect;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public String getTempPatientId() {
        return tempPatientId;
    }

    public void setTempPatientId(String tempPatientId) {
        this.tempPatientId = tempPatientId;
    }

    public String getTempDoctorId() {
        return tempDoctorId;
    }

    public void setTempDoctorId(String tempDoctorId) {
        this.tempDoctorId = tempDoctorId;
    }

    public String getTempDiseaseId() {
        return tempDiseaseId;
    }

    public void setTempDiseaseId(String tempDiseaseId) {
        this.tempDiseaseId = tempDiseaseId;
    }

    public String getClinicalTime() {
        return clinicalTime;
    }

    public void setClinicalTime(String clinicalTime) {
        this.clinicalTime = clinicalTime;
    }

    public Date getCaseDate() {
        return caseDate;
    }

    public void setCaseDate(Date caseDate) {
        this.caseDate = caseDate;
    }

    public String getPatientTalk() {
        return patientTalk;
    }

    public void setPatientTalk(String patientTalk) {
        this.patientTalk = patientTalk;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTempDoctorPrescriptionId() {
        return tempDoctorPrescriptionId;
    }

    public void setTempDoctorPrescriptionId(String tempDoctorPrescriptionId) {
        this.tempDoctorPrescriptionId = tempDoctorPrescriptionId;
    }

    public String getCurativeEffect() {
        return curativeEffect;
    }

    public void setCurativeEffect(String curativeEffect) {
        this.curativeEffect = curativeEffect;
    }

    public String getCaseRemark() {
        return caseRemark;
    }

    public void setCaseRemark(String caseRemark) {
        this.caseRemark = caseRemark;
    }

    public String getTipsContent() {
        return tipsContent;
    }

    public void setTipsContent(String tipsContent) {
        this.tipsContent = tipsContent;
    }

    public String getTempPictureLocationId() {
        return tempPictureLocationId;
    }

    public void setTempPictureLocationId(String tempPictureLocationId) {
        this.tempPictureLocationId = tempPictureLocationId;
    }

    public String getTempSyndromeId() {
        return tempSyndromeId;
    }

    public void setTempSyndromeId(String tempSyndromeId) {
        this.tempSyndromeId = tempSyndromeId;
    }

    public String getTempInquiryResultId() {
        return tempInquiryResultId;
    }

    public void setTempInquiryResultId(String tempInquiryResultId) {
        this.tempInquiryResultId = tempInquiryResultId;
    }
}
