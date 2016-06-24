package com.graduatedesign.hsl.yian.domain;

import java.util.Date;

/**
 * Created by Mesogene on 6/6/16.
 */
public class Note {
    private Long id;
    private Integer myNoteId;
    private Integer tempDoctorId;
    private Integer tempNoteTypeId;
    private Date noteDate;
    private String noteContent;
    private Integer tempChinese_medicine_id;
    private Integer tempFoodMaterialId;
    private Integer temePatentMedicineId;
    private Integer tempPrescriptionId;
    private String noteRemark;

    public Note(Long id, Integer myNoteId, Integer tempDoctorId, Integer tempNoteTypeId, Date noteDate, String noteContent, Integer tempChinese_medicine_id, Integer tempFoodMaterialId, Integer temePatentMedicineId, Integer tempPrescriptionId, String noteRemark) {
        this.id = id;
        this.myNoteId = myNoteId;
        this.tempDoctorId = tempDoctorId;
        this.tempNoteTypeId = tempNoteTypeId;
        this.noteDate = noteDate;
        this.noteContent = noteContent;
        this.tempChinese_medicine_id = tempChinese_medicine_id;
        this.tempFoodMaterialId = tempFoodMaterialId;
        this.temePatentMedicineId = temePatentMedicineId;
        this.tempPrescriptionId = tempPrescriptionId;
        this.noteRemark = noteRemark;
    }

    public Note() {
    }

    public Note(Integer temePatentMedicineId, String noteContent, Integer tempNoteTypeId) {
        this.temePatentMedicineId = temePatentMedicineId;
        this.noteContent = noteContent;
        this.tempNoteTypeId = tempNoteTypeId;
    }

    public Note(Integer myNoteId, Integer tempChinese_medicine_id, String noteContent, Integer tempNoteTypeId) {
        this.myNoteId = myNoteId;
        this.tempChinese_medicine_id = tempChinese_medicine_id;
        this.noteContent = noteContent;
        this.tempNoteTypeId = tempNoteTypeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMyNoteId() {
        return myNoteId;
    }

    public void setMyNoteId(Integer myNoteId) {
        this.myNoteId = myNoteId;
    }

    public Integer getTempDoctorId() {
        return tempDoctorId;
    }

    public void setTempDoctorId(Integer tempDoctorId) {
        this.tempDoctorId = tempDoctorId;
    }

    public Integer getTempNoteTypeId() {
        return tempNoteTypeId;
    }

    public void setTempNoteTypeId(Integer tempNoteTypeId) {
        this.tempNoteTypeId = tempNoteTypeId;
    }

    public Date getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(Date noteDate) {
        this.noteDate = noteDate;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public Integer getTempChinese_medicine_id() {
        return tempChinese_medicine_id;
    }

    public void setTempChinese_medicine_id(Integer tempChinese_medicine_id) {
        this.tempChinese_medicine_id = tempChinese_medicine_id;
    }

    public Integer getTempFoodMaterialId() {
        return tempFoodMaterialId;
    }

    public void setTempFoodMaterialId(Integer tempFoodMaterialId) {
        this.tempFoodMaterialId = tempFoodMaterialId;
    }

    public Integer getTemePatentMedicineId() {
        return temePatentMedicineId;
    }

    public void setTemePatentMedicineId(Integer temePatentMedicineId) {
        this.temePatentMedicineId = temePatentMedicineId;
    }

    public Integer getTempPrescriptionId() {
        return tempPrescriptionId;
    }

    public void setTempPrescriptionId(Integer tempPrescriptionId) {
        this.tempPrescriptionId = tempPrescriptionId;
    }

    public String getNoteRemark() {
        return noteRemark;
    }

    public void setNoteRemark(String noteRemark) {
        this.noteRemark = noteRemark;
    }
}
