package pl.surecase.eu;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MyDaoGenerator {

    public static void main(String args[]) throws Exception {
        Schema schema = new Schema(1, "ChinaMedicalRecordDao");
        addCaseRecord(schema);
        new DaoGenerator().generateAll(schema, args[2]);
    }

    public static void addUser(Schema schema) {
        /**
         * *医生信息表
         */
        Entity DoctorInfo = schema.addEntity("DoctorInfo");
        DoctorInfo.addIdProperty().primaryKey().autoincrement();
        DoctorInfo.addIntProperty("doctor_id");
        DoctorInfo.addStringProperty("doctor_name");
        DoctorInfo.addStringProperty("doctor_sex");
        DoctorInfo.addIntProperty("doctor_age");
        DoctorInfo.addStringProperty("doctor_phone_number");
        DoctorInfo.addStringProperty("doctor_identity");
        DoctorInfo.addStringProperty("doctor_password");
        DoctorInfo.addStringProperty("doctor_unit_name");
        DoctorInfo.addStringProperty("doctor_department_name");
        DoctorInfo.addStringProperty("doctor_address");
        DoctorInfo.addIntProperty("check_state");    
        DoctorInfo.addStringProperty("doctor_remark");
        DoctorInfo.addStringProperty("doctor_wechat");
        DoctorInfo.addStringProperty("doctor_introduction");
        DoctorInfo.addIntProperty("temp_picture_location_id");


        /**
         **病人表
         */
        Entity PatientInfo = schema.addEntity("PatientInfo");
        PatientInfo.addIdProperty().primaryKey().autoincrement();
        PatientInfo.addIntProperty("patient_id");
        PatientInfo.addStringProperty("patient_name");
        PatientInfo.addStringProperty("patient_sex");
        PatientInfo.addIntProperty("patient_age");
        PatientInfo.addStringProperty("patient_phone_number");
        PatientInfo.addStringProperty("patient_identity_card");
        PatientInfo.addDoubleProperty("patient_height");
        PatientInfo.addDoubleProperty("patient_weight");
        PatientInfo.addStringProperty("patient_posture");
        PatientInfo.addStringProperty("patient_professional");
        PatientInfo.addStringProperty("patient_address");
        PatientInfo.addStringProperty("patient_remark");
        /**
         **医案信息表
         */
        Entity CaseRecord = schema.addEntity("CaseRecord");
        CaseRecord.addIdProperty().primaryKey().autoincrement();
        CaseRecord.addIntProperty("case_id");
        CaseRecord.addIntProperty("temp_patient_id");
        CaseRecord.addIntProperty("temp_doctor_id");
        CaseRecord.addIntProperty("temp_disease_id");
        CaseRecord.addIntProperty("clinical_time");
        CaseRecord.addDateProperty("case_date");
        CaseRecord.addStringProperty("patient_talk");
        CaseRecord.addStringProperty("medical_history");
        CaseRecord.addStringProperty("diagnosis");
        CaseRecord.addIntProperty("temp_doctor_prescription_id");
        CaseRecord.addStringProperty("curative_effect");
        CaseRecord.addStringProperty("case_remark");
        CaseRecord.addStringProperty("tips_content");
        CaseRecord.addIntProperty("temp_picture_location_id");
        CaseRecord.addIntProperty("temp_syndrome_id");
        CaseRecord.addIntProperty("temp_inquiry_result_id");

        /**
         **中成药信息表
         */
        Entity PatentMedicineInfo = schema.addEntity("PatentMedicineInfo");
        PatentMedicineInfo.addIdProperty().primaryKey().autoincrement();
        PatentMedicineInfo.addIntProperty("patent_medicine_id");
        PatentMedicineInfo.addStringProperty("patent_medicine_name");
        PatentMedicineInfo.addStringProperty("patent_medicine_content");
        PatentMedicineInfo.addStringProperty("indications_function");
        PatentMedicineInfo.addStringProperty("shape");
        PatentMedicineInfo.addStringProperty("usage_dosage");
        PatentMedicineInfo.addStringProperty("specifications");
        PatentMedicineInfo.addStringProperty("saute");
        PatentMedicineInfo.addStringProperty("attention");
        PatentMedicineInfo.addStringProperty("storage_method");
        PatentMedicineInfo.addStringProperty("patent_medicine_remark");

        /**
         **中成药笔记映射表
         */
        Entity PatentMedicineNoteMapp = schema.addEntity("PatentMedicineNoteMapp");
        PatentMedicineNoteMapp.addIdProperty().primaryKey().autoincrement();
        PatentMedicineNoteMapp.addIntProperty("patent_medicine_note_mapp_id");
        PatentMedicineNoteMapp.addIntProperty("temp_note_id");
        PatentMedicineNoteMapp.addIntProperty("temp_chinese_medicine_id ");
        PatentMedicineNoteMapp.addStringProperty("note_remark");

        /**
         **中药信息表
         */
        Entity ChineseMedicineInfo = schema.addEntity("ChineseMedicineInfo");
        ChineseMedicineInfo.addIdProperty().primaryKey().autoincrement();
        ChineseMedicineInfo.addIntProperty("chinese_medicine_id");
        ChineseMedicineInfo.addStringProperty("medicine_name");
        ChineseMedicineInfo.addStringProperty("medicine_property");
        ChineseMedicineInfo.addStringProperty("medicine_taste");
        ChineseMedicineInfo.addStringProperty("effect_type");
        ChineseMedicineInfo.addStringProperty("medicine_grade");
        ChineseMedicineInfo.addStringProperty("channel_tropism");
        ChineseMedicineInfo.addStringProperty("indications_function");
        ChineseMedicineInfo.addIntProperty("temp_picture_location_id");
        ChineseMedicineInfo.addStringProperty("chinese_medicine_remark");
        ChineseMedicineInfo.addStringProperty("another_name");
        ChineseMedicineInfo.addStringProperty("producing_area");
        ChineseMedicineInfo.addStringProperty("common_used_prescription");
        ChineseMedicineInfo.addStringProperty("machining_processing");
        ChineseMedicineInfo.addStringProperty("use_precaution");

        /**
         **中药处方映射表
         */
        Entity ChineseMedPreMapp = schema.addEntity("ChineseMedPreMapp");
        ChineseMedPreMapp.addIdProperty().primaryKey().autoincrement();
        ChineseMedPreMapp.addIntProperty("chinese_med_prescript_mapp_id");
        ChineseMedPreMapp.addIntProperty("temp_chinese_medicine_id");
        ChineseMedPreMapp.addIntProperty("temp_doctor_prescription_id");
        ChineseMedPreMapp.addIntProperty("temp_unit_id");
        ChineseMedPreMapp.addIntProperty("chinese_medicine_dose");
        ChineseMedPreMapp.addStringProperty("decoction_method");

        /**
         **中药方剂映射表
         */
        Entity MedPrescriptMapp = schema.addEntity("MedPrescriptMapp");
        MedPrescriptMapp.addIdProperty().primaryKey().autoincrement();
        MedPrescriptMapp.addIntProperty("chinese_med_prescript_mapp_id");
        MedPrescriptMapp.addIntProperty("temp_chinese_medicine_id");
        MedPrescriptMapp.addIntProperty("temp_prescription_id");
        MedPrescriptMapp.addStringProperty("medicine_amount");
        MedPrescriptMapp.addIntProperty("temp_unit_id");
        MedPrescriptMapp.addStringProperty("decoction_method");
        MedPrescriptMapp.addStringProperty("med_prescript_mapp_remarks");

        /**
         **中药笔记映射表
         */
        Entity ChineseMedicineNoteMapp = schema.addEntity("ChineseMedicineNoteMapp");
        ChineseMedicineNoteMapp.addIdProperty().primaryKey().autoincrement();
        ChineseMedicineNoteMapp.addIntProperty("chinese_med_note_mapp_id");
        ChineseMedicineNoteMapp.addIntProperty("temp_note_id");
        ChineseMedicineNoteMapp.addIntProperty("temp_chinese_medicine_id");
        ChineseMedicineNoteMapp.addStringProperty("note_remark");
        /**
         **图片列表
         */
        Entity PictureList = schema.addEntity("PictureList");
        PictureList.addIdProperty().primaryKey().autoincrement();
        PictureList.addIntProperty("picture_location_id");
        PictureList.addStringProperty("original_picture_path");
        PictureList.addStringProperty("small_picture_path");
        PictureList.addStringProperty("picture_class");
        PictureList.addStringProperty("picture_name");
        PictureList.addStringProperty("picture_title");
        PictureList.addStringProperty("picture_remarks");
        /**
         **地理位置信息表
         */
        Entity LocationInfo = schema.addEntity("LocationInfo");
        LocationInfo.addIdProperty().primaryKey().autoincrement();
        LocationInfo.addIntProperty("location_info_id");
        LocationInfo.addDoubleProperty("location_longitude");
        LocationInfo.addDoubleProperty("location_latitude");
        LocationInfo.addStringProperty("real_location");
        LocationInfo.addStringProperty("location_province");
        LocationInfo.addStringProperty("location_city");
        LocationInfo.addStringProperty("location_classify");
        LocationInfo.addStringProperty("location_county");
        LocationInfo.addStringProperty("location_remarks");

        /**
         **处方表
         */
        Entity DoctorPrescription = schema.addEntity("DoctorPrescription");
        DoctorPrescription.addIdProperty().primaryKey().autoincrement();
        DoctorPrescription.addIntProperty("doctor_prescription_id");
        DoctorPrescription.addStringProperty("prescription_name");
        DoctorPrescription.addStringProperty("prescription_instructions");
        DoctorPrescription.addIntProperty("oral_doses");
        DoctorPrescription.addStringProperty("doctor_prescription_remark");
        DoctorPrescription.addStringProperty("prescription_type");
        DoctorPrescription.addDateProperty("prescription_date");

        /**
         **常见疾病信息表
         */
        Entity CommonDiseaseInfo = schema.addEntity("CommonDiseaseInfo");
        CommonDiseaseInfo.addIdProperty().primaryKey().autoincrement();
        CommonDiseaseInfo.addIntProperty("common_disease_id");
        CommonDiseaseInfo.addIntProperty("temp_common_disease_type_id");
        CommonDiseaseInfo.addStringProperty("common_disease_name");
        CommonDiseaseInfo.addStringProperty("common_disease_explain");
        /**
         **常见疾病类别表
         */
        Entity CommonDiseaseType = schema.addEntity("CommonDiseaseType");
        CommonDiseaseType.addIdProperty().primaryKey().autoincrement();
        CommonDiseaseType.addIntProperty("common_disease_type_id");
        CommonDiseaseType.addStringProperty("common_disease_type_name");
        CommonDiseaseType.addIntProperty("common_disease_type_code");
        CommonDiseaseType.addStringProperty("common_disease_type_explain");

        /**
         **方剂信息表
         */
        Entity PrescriptionsInfo = schema.addEntity("PrescriptionsInfo");
        PrescriptionsInfo.addIdProperty().primaryKey().autoincrement();
        PrescriptionsInfo.addIntProperty("prescription_id");
        PrescriptionsInfo.addStringProperty("prescription_name");
        PrescriptionsInfo.addStringProperty("prescription_origin");
        PrescriptionsInfo.addStringProperty("prescription_effect");
        PrescriptionsInfo.addStringProperty("prescription_class");
        PrescriptionsInfo.addStringProperty("prescription_function");
        PrescriptionsInfo.addStringProperty("prescription_summary");
        PrescriptionsInfo.addStringProperty("prescription_instructions");
        PrescriptionsInfo.addStringProperty("prescription_remark");

        /**
         **方剂笔记映射表
        */
        Entity PrescriptionsNoteMapp = schema.addEntity("PrescriptionsNoteMapp");
        PrescriptionsNoteMapp.addIdProperty().primaryKey().autoincrement();
        PrescriptionsNoteMapp.addIntProperty("prescription_note_mapp_id");
        PrescriptionsNoteMapp.addIntProperty("temp_note_id");
        PrescriptionsNoteMapp.addIntProperty("temp_prescription_id");
        PrescriptionsNoteMapp.addStringProperty("note_remark");

        /**
         **病人问诊单答题表
         */
        Entity PatientInquiryAnswerRecords = schema.addEntity("PatientInquiryAnswerRecords");
        PatientInquiryAnswerRecords.addIdProperty().primaryKey().autoincrement();
        PatientInquiryAnswerRecords.addIntProperty("answer_records_id");
        PatientInquiryAnswerRecords.addIntProperty("temp_inquiry_question_id");
        PatientInquiryAnswerRecords.addIntProperty("temp_patient_id");
        PatientInquiryAnswerRecords.addStringProperty("inquiry_question_answer");

        /**
         **笔记类别表
         */
        Entity NoteType = schema.addEntity("NoteType");
        NoteType.addIdProperty().primaryKey().autoincrement();
        NoteType.addIntProperty("note_type_id");
        NoteType.addStringProperty("note_type_name");

        /**
         **笔记表
         */
        Entity Note = schema.addEntity("Note");
        Note.addIdProperty().primaryKey().autoincrement();
        Note.addIntProperty("my_note_id");
        Note.addIntProperty("temp_doctor_id");
        Note.addIntProperty("temp_note_type_id");
        Note.addDateProperty("note_date");
        Note.addStringProperty("note_content");

        /**
         **西医检查项目表
         */
        Entity WestMedicineExamItem = schema.addEntity("WestMedicineExamItem");
        WestMedicineExamItem.addIdProperty().primaryKey().autoincrement();
        WestMedicineExamItem.addIntProperty("west_medicine_exam_id");
        WestMedicineExamItem.addStringProperty("west_medicine_item_name");
        WestMedicineExamItem.addStringProperty("west_medicine_item_expl");
        /**
         **西医诊疗记录表
         */
        Entity WTreatmentRecords = schema.addEntity("WTreatmentRecords");
        WTreatmentRecords.addIdProperty().primaryKey().autoincrement();
        WTreatmentRecords.addIntProperty("west_treatment_record_id");
        WTreatmentRecords.addIntProperty("temp_west_medicine_exam_id");
        WTreatmentRecords.addDoubleProperty("west_exam_result_value");
        WTreatmentRecords.addIntProperty("temp_patient_id");

        /**
         **剂量单位表
         */
        Entity MeasurementUnit = schema.addEntity("MeasurementUnit");
        MeasurementUnit.addIdProperty().primaryKey().autoincrement();
        MeasurementUnit.addIntProperty("unit_id");
        MeasurementUnit.addStringProperty("unit_name");
        MeasurementUnit.addIntProperty("hexadecimal");
        MeasurementUnit.addStringProperty("unit_remarks");

        /**
         **证型表
         */
        Entity SyndromeTypes = schema.addEntity("SyndromeTypes");
        SyndromeTypes.addIdProperty().primaryKey().autoincrement();
        SyndromeTypes.addIntProperty("syndrome_type_id");
        SyndromeTypes.addStringProperty("syndrome_type_name");
        SyndromeTypes.addStringProperty("dialectical_method");
        SyndromeTypes.addStringProperty("syndrome_remark");
        SyndromeTypes.addStringProperty("syndrome_system_type");
        SyndromeTypes.addStringProperty("syndrome_level_type");
        /**
         **问诊单项目表
         */

        Entity InquiryIssuess = schema.addEntity("InquiryIssuess");
        InquiryIssuess.addIdProperty().primaryKey().autoincrement();
        InquiryIssuess.addIntProperty("inquiry_question_id");
        InquiryIssuess.addStringProperty("inquiry_question_content");
        InquiryIssuess.addStringProperty("inquiry_question_remarks");
        /**
         **问诊结果记录表
         */
        Entity InquiryResult = schema.addEntity("InquiryResult");
        InquiryResult.addIdProperty().primaryKey().autoincrement();
        InquiryResult.addIntProperty("inquiry_result_id");
        InquiryResult.addIntProperty("temp_patient_id");
        InquiryResult.addDateProperty("inquiry_date");
        InquiryResult.addStringProperty("inquiry_remarks");
        InquiryResult.addStringProperty("inquiry_result");
        InquiryResult.addIntProperty("inquiry_flag");

        /**
         **食材信息表
         */
        Entity FoodMaterialInfo = schema.addEntity("FoodMaterialInfo");
        FoodMaterialInfo.addIdProperty().primaryKey().autoincrement();
        FoodMaterialInfo.addIntProperty("food_material_id");
        FoodMaterialInfo.addStringProperty("food_material_name");
        FoodMaterialInfo.addStringProperty("food_material_property");
        FoodMaterialInfo.addStringProperty("food_material_taste");
        FoodMaterialInfo.addStringProperty("food_material_content");
        FoodMaterialInfo.addIntProperty("temp_picture_location_id");
        FoodMaterialInfo.addStringProperty("food_material_remark");
        FoodMaterialInfo.addStringProperty("food_material_effect");

        /**
         **食材笔记映射表
         */
        Entity FoodMaterialNoteMapp = schema.addEntity("FoodMaterialNoteMapp");
        FoodMaterialNoteMapp.addIdProperty().primaryKey().autoincrement();
        FoodMaterialNoteMapp.addIntProperty("food_material_note_mapp_id");
        FoodMaterialNoteMapp.addIntProperty("temp_note_id");
        FoodMaterialNoteMapp.addIntProperty("temp_food_material_id");
        FoodMaterialNoteMapp.addStringProperty("note_remark");

    }
    public static void addCaseRecord(Schema schema){
        Entity CaseRecord = schema.addEntity("CaseRecord");
        CaseRecord.addIdProperty().primaryKey().autoincrement();
        CaseRecord.addIntProperty("case_id");
        CaseRecord.addIntProperty("temp_patient_id");
        CaseRecord.addIntProperty("temp_doctor_id");
        CaseRecord.addIntProperty("temp_disease_id");
        CaseRecord.addIntProperty("clinical_time");
        CaseRecord.addDateProperty("case_date");
        CaseRecord.addStringProperty("patient_talk");
        CaseRecord.addStringProperty("medical_history");
        CaseRecord.addStringProperty("diagnosis");
        CaseRecord.addIntProperty("temp_doctor_prescription_id");
        CaseRecord.addStringProperty("curative_effect");
        CaseRecord.addStringProperty("case_remark");
        CaseRecord.addStringProperty("tips_content");
        CaseRecord.addIntProperty("temp_picture_location_id");
        CaseRecord.addIntProperty("temp_syndrome_id");
        CaseRecord.addIntProperty("temp_inquiry_result_id");
    }
}
