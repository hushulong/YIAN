/*
 * Copyright 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.graduatedesign.hsl.yian.fragments;

import com.graduatedesign.hsl.yian.R;

/**
 * This represents a sample data.
 */
public class Meat {

    public int resourceId;
    public String title;

    public Meat(int resourceId, String title) {
        this.resourceId = resourceId;
        this.title = title;
    }

    public static final Meat[] MEATS = {
            new Meat(R.drawable.iconfont_shicai, "天花粉"),
            new Meat(R.drawable.iconfont_shicai, "紫苏梗"),
            new Meat(R.drawable.iconfont_shicai, "桑叶"),
            new Meat(R.drawable.iconfont_shicai, "龙胆"),
            new Meat(R.drawable.iconfont_shicai, "红花"),
            new Meat(R.drawable.iconfont_shicai, "五味子"),
            new Meat(R.drawable.iconfont_shicai, "槟榔"),
            new Meat(R.drawable.iconfont_shicai, "半夏"),
            new Meat(R.drawable.iconfont_shicai, "甘草"),
            new Meat(R.drawable.iconfont_shicai, "白术"),
            new Meat(R.drawable.iconfont_shicai, "牛黄"),
    };


}
