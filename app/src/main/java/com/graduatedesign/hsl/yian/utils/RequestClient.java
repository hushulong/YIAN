package com.graduatedesign.hsl.yian.utils;
import android.util.TypedValue;

import com.graduatedesign.hsl.yian.domain.CaseRecord;
import com.graduatedesign.hsl.yian.domain.ChineseMedicineInfo;
import com.graduatedesign.hsl.yian.domain.DoctorInfo;
import com.graduatedesign.hsl.yian.domain.Note;
import com.graduatedesign.hsl.yian.domain.PatientInfo;
import com.njucm.cmdh.viewpager.indicator.Indicator;
import com.squareup.okhttp.Response;

import java.util.List;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * Created by Mesogene on 5/2/16.
 */
public interface RequestClient {
    //病人信息URL
    @GET("{requestGoal}")
    Call<List<PatientInfo>> getPatientInfoList(@Path("requestGoal") String requestGoal);

    @GET("{requestGoal}")
    Call<List<PatientInfo>> getPatientinfo(@Path("requestGoal") String requestGoal,@Query("patientName") String patientName);

    @POST("saveorupdate")
    Call<List<PatientInfo>> addPatientinfo(@Body List<PatientInfo> patientInfos);

    @POST("saveorupdate")
    Call<List<PatientInfo>> updatePatientinfo(@Body List<PatientInfo> patientInfo);

    @DELETE("deletebyid/{patientId}")
     Call<PatientInfo>deletePatient(@Path("patientId") Integer patientId);
    //医生信息URL
    @GET("{requestGoal}")
    Call<List<DoctorInfo>> getDoctorinfo(@Path("requestGoal") String requestGoal,@Query("doctorName") String doctorName);

    @POST("saveorupdate")
    Call<List<DoctorInfo>> updateDoctorinfo(@Body List<DoctorInfo> doctorInfos);

    //医生登录
    @POST("saveorupdate")
    Call<List<DoctorInfo>> UserLogin(@Body List<DoctorInfo> doctorInfo);

    @POST("saveorupdate")
    Call<List<DoctorInfo>> addDoctorinfo(@Body List<DoctorInfo> doctorInfo);

    //病案URL
    @POST("saveorupdate")
    Call<CaseRecord> addCaserecord(@Body CaseRecord caseRecord);

    @POST("caserecord/saveorupdate")
    Call<List<CaseRecord>> updateCaseRecord(@Body List<CaseRecord> caseRecords);

    @GET("{requestGoal}")
    Call<List<CaseRecord>> getCaseRecordsList(@Path("requestGoal") String requestGoal);

    @GET("caserecord/findbytemppatientid/{tempPatientId}")
    Call<List<CaseRecord>> getCaseRecordsByPatientId(@Path("tempPatientId") Integer tempPatientId);

    @GET("caserecord/findbytempdiseaseid/{tempDiseaseId}")
    Call<List<CaseRecord>> getCaseRecordByDiseaseId(@Path("tempDiseaseId") Integer tempDiseaseId);

    @GET("caserecord/findbycaseid/{caseId}")
    Call<List<CaseRecord>> getCaseRecordByCaseId(@Path("caseId") Integer caseId);

    //中药信息URL
    @GET("{requestGoal}")
    Call<List<ChineseMedicineInfo>> getChineseMedicineInfo(@Path("requestGoal") String requestGoal);

    @GET("{requestGoal}")
    Call<List<Note>> getNoteList(@Path("requestGoal") String requestGoal);

    @POST("saveorupdate")
    Call<List<Note>> addNote (@Body List<Note> note);

}
