package com.siyuan.base.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class IDCardUtil {
    // 权重值
    private final static int[] wi = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 };
    private final static int[] vi = { 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 };
    private static int[] ai = new int[17];

    /**
     * 验证提供的字符串是否为一个合法的身份证号
     * @param idNo
     * @return boolean
     */
    public static boolean verifyIDCard(String idNo) {
        idNo = upIdNo(idNo);
        if (idNo.length() == 18 && idNo.substring(17, 18).equals(getVerifyCode(idNo))) {
            return true;
        }
        return false;
    }

    /**
     * 将一代身份证升位为二代
     * @param idNo
     * @return idNo2
     */
    private static String upIdNo(String idNo) {
        if (idNo.length() == 15) {
            String localNo = idNo.substring(0, 6);
            String birthNo  = "19" + idNo.substring(6, 15);
            String verityNo = getVerifyCode(localNo + birthNo);
            return localNo + birthNo + verityNo;
        }
        return idNo;
    }

    /**
     * 算法获取身份证末尾的验证码值
     * @param idNo
     * @return verifyCode 身份证末尾验证码
     */
    private static String getVerifyCode(String idNo) {
        int sum = 0;
        // 转换字符为int数组
        for (int i = 0; i < idNo.substring(0,17).length(); i++) {
            String str = idNo.substring(i, i + 1);
            ai[i] = Integer.parseInt(str);
        }
        for (int i = 0; i < 17; i++) {
            sum += wi[i] * ai[i];
        }
        int verifyCode = sum % 11;
        return verifyCode == 2 ? "X" : String.valueOf(vi[verifyCode]);
    }

    /**
     * 根据身份证计算周岁
     * @param idNo
     * @return
     * @throws ParseException
     */
    public static Object getAge(String idNo) throws ParseException {
        if(verifyIDCard(idNo)){
            upIdNo(idNo);
            Date birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(
                    idNo.substring(6, 10) + "-" + idNo.substring(10, 12) + "-" + idNo.substring(12, 14));
            Calendar now = Calendar.getInstance();
            Calendar born = Calendar.getInstance();
            now.setTime(new Date());
            born.setTime(birthDate);
            int age = now.get(Calendar.YEAR)-born.get(Calendar.YEAR);
            if(now.get(Calendar.DAY_OF_YEAR) < born.get(Calendar.DAY_OF_YEAR)) {
                age -= 1;
            }
            return age;
        }
        return null;
    }

    /**
     * 获取性
     * @param idcard
     * @return
     */
    public static String getSex(String idcard) {
        String inputStr = idcard.toString();
        int sex;
        if (inputStr.length() == 18) {
            sex = inputStr.charAt(16);
            if (sex % 2 == 0) {
                return "女";
            } else {
                return "男";
            }
        } else {
            sex = inputStr.charAt(14);
            if (sex % 2 == 0) {
                return "女";
            } else {
                return "男";
            }
        }
    }

}
