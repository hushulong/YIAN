package com.graduatedesign.hsl.yian.domain;

/**
 * Created by Mesogene on 6/5/16.
 */
public class ChineseMedicineInfo {
    private Long id;
    private Integer chineseMedicineId;
    private String medicineName;
    private String medicineProperty;
    private String medicineTaste;
    private String effectType;
    private String medicineGrade;
    private String channelTropism;
    private String indicationsFunction;
    private String tempPictureLocationId;
    private String chineseMedicineRemark;
    private String anotherName;
    private String producingArea;
    private String commonUsedPrescription;
    private String machiningProcessing;
    private String usePrecaution;

    public ChineseMedicineInfo() {
    }

    public ChineseMedicineInfo(Long id, Integer chineseMedicineId, String medicineName, String medicineProperty, String medicineTaste, String effectType, String medicineGrade, String channelTropism, String indicationsFunction, String tempPictureLocationId, String chineseMedicineRemark, String anotherName, String producingArea, String commonUsedPrescription, String machiningProcessing, String usePrecaution) {
        this.id = id;
        this.chineseMedicineId = chineseMedicineId;
        this.medicineName = medicineName;
        this.medicineProperty = medicineProperty;
        this.medicineTaste = medicineTaste;
        this.effectType = effectType;
        this.medicineGrade = medicineGrade;
        this.channelTropism = channelTropism;
        this.indicationsFunction = indicationsFunction;
        this.tempPictureLocationId = tempPictureLocationId;
        this.chineseMedicineRemark = chineseMedicineRemark;
        this.anotherName = anotherName;
        this.producingArea = producingArea;
        this.commonUsedPrescription = commonUsedPrescription;
        this.machiningProcessing = machiningProcessing;
        this.usePrecaution = usePrecaution;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getChineseMedicineId() {
        return chineseMedicineId;
    }

    public void setChineseMedicineId(Integer chineseMedicineId) {
        this.chineseMedicineId = chineseMedicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineProperty() {
        return medicineProperty;
    }

    public void setMedicineProperty(String medicineProperty) {
        this.medicineProperty = medicineProperty;
    }

    public String getMedicineTaste() {
        return medicineTaste;
    }

    public void setMedicineTaste(String medicineTaste) {
        this.medicineTaste = medicineTaste;
    }

    public String getEffectType() {
        return effectType;
    }

    public void setEffectType(String effectType) {
        this.effectType = effectType;
    }

    public String getMedicineGrade() {
        return medicineGrade;
    }

    public void setMedicineGrade(String medicineGrade) {
        this.medicineGrade = medicineGrade;
    }

    public String getChannelTropism() {
        return channelTropism;
    }

    public void setChannelTropism(String channelTropism) {
        this.channelTropism = channelTropism;
    }

    public String getIndicationsFunction() {
        return indicationsFunction;
    }

    public void setIndicationsFunction(String indicationsFunction) {
        this.indicationsFunction = indicationsFunction;
    }

    public String getTempPictureLocationId() {
        return tempPictureLocationId;
    }

    public void setTempPictureLocationId(String tempPictureLocationId) {
        this.tempPictureLocationId = tempPictureLocationId;
    }

    public String getChineseMedicineRemark() {
        return chineseMedicineRemark;
    }

    public void setChineseMedicineRemark(String chineseMedicineRemark) {
        this.chineseMedicineRemark = chineseMedicineRemark;
    }

    public String getAnotherName() {
        return anotherName;
    }

    public void setAnotherName(String anotherName) {
        this.anotherName = anotherName;
    }

    public String getProducingArea() {
        return producingArea;
    }

    public void setProducingArea(String producingArea) {
        this.producingArea = producingArea;
    }

    public String getCommonUsedPrescription() {
        return commonUsedPrescription;
    }

    public void setCommonUsedPrescription(String commonUsedPrescription) {
        this.commonUsedPrescription = commonUsedPrescription;
    }

    public String getMachiningProcessing() {
        return machiningProcessing;
    }

    public void setMachiningProcessing(String machiningProcessing) {
        this.machiningProcessing = machiningProcessing;
    }

    public String getUsePrecaution() {
        return usePrecaution;
    }

    public void setUsePrecaution(String usePrecaution) {
        this.usePrecaution = usePrecaution;
    }
}
