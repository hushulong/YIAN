package com.graduatedesign.hsl.yian.misc;

import android.support.v4.app.Fragment;

import com.graduatedesign.hsl.yian.fragments.ChineseMedicineListFragment;
import com.graduatedesign.hsl.yian.fragments.ChinesePatentMedicineFragment;
import com.graduatedesign.hsl.yian.fragments.ClassicBookFragment;
import com.graduatedesign.hsl.yian.fragments.ClassicalFragment;
import com.graduatedesign.hsl.yian.fragments.DoseConversionFragment;
import com.graduatedesign.hsl.yian.fragments.FamousBiographyFragment;
import com.graduatedesign.hsl.yian.fragments.FamousMedicalRecordFragment;
import com.graduatedesign.hsl.yian.fragments.IngredientFragment;
import com.graduatedesign.hsl.yian.fragments.MedicalCardFragment;
import com.graduatedesign.hsl.yian.fragments.MerdianPointFragment;
import com.graduatedesign.hsl.yian.fragments.PersonalFragment;
import com.graduatedesign.hsl.yian.fragments.CaseRecordFragment;
import com.graduatedesign.hsl.yian.fragments.PrescriptionFragment;


/**
 * Created by Michal Bialas on 19/07/14.
 */
public enum Fragments {  //枚举类型在枚举类中直接实例化实例

    ONE(ClassicalFragment.class),
    TWO(CaseRecordFragment.class),
    THREE(PersonalFragment.class),
    ChineseMedicine(ChineseMedicineListFragment.class),
    ChinesePatentMedicine(ChinesePatentMedicineFragment.class),
    ClassicBook(ClassicBookFragment.class),
    DoseConversion(DoseConversionFragment.class),
    FamousBiography(FamousBiographyFragment.class),
    FamousMedicalRecord(FamousMedicalRecordFragment.class),
    Ingredient(IngredientFragment.class),
    MerdianPoint(MerdianPointFragment.class),
    Prescription(PrescriptionFragment.class);




    final Class<? extends Fragment> fragment;

    private Fragments(Class<? extends Fragment> fragment) {
        this.fragment = fragment;
    }   //构造方法

    public String getFragment() {
        return fragment.getName();  //每个类自带getName()方法
    }
}
