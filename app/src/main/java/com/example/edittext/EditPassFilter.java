package com.example.edittext;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;

/**
 * Created on 16/4/28.
 * 密码过滤器
 */
public class EditPassFilter implements InputFilter {

    private int MAX_LENGTH = 8;

    public EditPassFilter() {
    }

    /**
     * @param source 新输入的字符串
     * @param start  新输入的字符串起始下标，一般为0
     * @param end    新输入的字符串终点下标，一般为source长度-1
     * @param dest   输入之前文本框内容
     * @param dstart 原内容起始坐标，一般为0
     * @param dend   原内容终点坐标，一般为dest长度-1
     * @return 输入内容
     */
    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        String sourceText = source.toString();
        String destText = dest.toString();

        if (TextUtils.isEmpty(sourceText)) {
            return "";
        }

        if ((destText + sourceText).length() > MAX_LENGTH) {
            return "";
        }

        if (!StringUtil.isOnlyLetterOrNumber(destText + sourceText)) {
            return "";
        }

        return dest.subSequence(dstart, dend) + sourceText;
    }
}
