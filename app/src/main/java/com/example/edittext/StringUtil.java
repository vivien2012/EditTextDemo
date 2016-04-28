package com.example.edittext;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created on 16/4/28.
 * 字符串工具类
 */
public class StringUtil {

    /**
     * 验证是否是手机号码
     *
     * @param phoneNumber
     * @return
     */
    public static boolean isPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) return false;
        if (TextUtils.isEmpty(phoneNumber)) return false;
        Pattern pattern = Pattern.compile("^(86|\\+86)?[1][3,4,5,8][0-9]{9}$");
        Matcher m = pattern.matcher(phoneNumber);
        return m.matches();
    }

    /**
     * 。是否是纯数字字符串
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        return isNum.matches();
    }

    /**
     * 全英或全数字或英数混合
     *
     * @param str
     * @return
     */
    public static boolean isOnlyLetterOrNumber(String str) {
        String regular = "[a-zA-Z0-9]+";
        return match(regular, str);
    }

    /**
     * @param regex 正则表达式字符串
     * @param str   要匹配的字符串
     * @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false;
     */
    private static boolean match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
