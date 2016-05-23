package com.pythoncat.styleapp;

import android.content.Context;

/**
 * Created by pythonCat on 2016/5/23.
 */
public class SystemHelper {

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
