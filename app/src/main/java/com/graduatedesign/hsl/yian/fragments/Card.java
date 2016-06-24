package com.graduatedesign.hsl.yian.fragments;

import com.graduatedesign.hsl.yian.R;

/**
 * Created by Mesogene on 3/31/16.
 */
public class Card {
    public int img1,img2;
    public String disease,date_time,user_name,summary,summary_content;

    public Card(int img1,int img2,String disease,String date_time,String user_name,String summary,String summary_content){
        this.img1 = img1;
        this.img2 = img2;
        this.disease = disease;
        this.date_time = date_time;
        this.user_name = user_name;
        this.summary = summary;
        this.summary_content = summary_content;

    }

    public int getImg1() {
        return img1;
    }

    public void setImg1(int img1) {
        this.img1 = img1;
    }

    public int getImg2() {
        return img2;
    }

    public void setImg2(int img2) {
        this.img2 = img2;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getSummary_content() {
        return summary_content;
    }

    public void setSummary_content(String summary_content) {
        this.summary_content = summary_content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

}
