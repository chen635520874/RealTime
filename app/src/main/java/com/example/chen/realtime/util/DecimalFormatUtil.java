package com.example.chen.realtime.util;

import com.king.base.util.LogUtils;

import java.text.DecimalFormat;

/**
 * Created by chen on 2017/10/18.
 */

public class DecimalFormatUtil {

    public static final DecimalFormat deciamalFormat = new DecimalFormat();

    public static String formatW(int value){
        if (value >=10000){
            float w = value/10000.0f;
            return format(w,"#.#'w'");//w是value ,"#.#'w'"是形式（pattern）
        }
        return String.valueOf(value);
    }

    public static String format(float value,String pattern){
        LogUtils.d("value" + value);
        deciamalFormat.applyPattern(pattern);
        return deciamalFormat.format(value);
    }
}
