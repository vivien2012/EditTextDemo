package com.example.edittext;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Created on 16/4/28.
 * 手机号过滤器
 */
public class EditPhoneFilter implements InputFilter {

    private int MAX_LENGTH = 11;

    public EditPhoneFilter() {
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

        if (!StringUtil.isNumeric(destText + sourceText)) {
            return "";
        }

        if ((destText + sourceText).length() > MAX_LENGTH) {
            return "";
        }

        if ((destText + sourceText).length() == MAX_LENGTH && !StringUtil.isPhoneNumber(destText + sourceText)) {
            Toast.makeText(MyApplication.context, "手机号格式不正确！", Toast.LENGTH_SHORT).show();
        }

        return dest.subSequence(dstart, dend) + sourceText;
    }
}
