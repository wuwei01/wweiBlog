package com.ylzsh.cloudpay.api.utils;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2016/2/25.
 */
public class IdCard {
    /**
     * 中国公民身份证号码最小长度。
     */
    public final int CHINA_ID_MIN_LENGTH = 15;

    /**
     * 中国公民身份证号码最大长度。
     */
    public final int CHINA_ID_MAX_LENGTH = 18;


    /**
     * 根据身份编号获取生日
     *
     * @param idCard 身份编号
     * @return 生日(yyyyMMdd)
     */
    public static String getBirthByIdCard(String idCard) {
        return idCard.substring(6, 14);
    }

    /**
     * 根据身份编号获取生日年
     *
     * @param idCard 身份编号
     * @return 生日(yyyy)
     */
    public static Short getYearByIdCard(String idCard) {
        return Short.valueOf(idCard.substring(6, 10));
    }

    /**
     * 根据身份编号获取生日月
     *
     * @param idCard 身份编号
     * @return 生日(MM)
     */
    public static Short getMonthByIdCard(String idCard) {
        return Short.valueOf(idCard.substring(10, 12));
    }

    /**
     * 根据身份编号获取生日天
     *
     * @param idCard 身份编号
     * @return 生日(dd)
     */
    public static Short getDateByIdCard(String idCard) {
        return Short.valueOf(idCard.substring(12, 14));
    }

    /**
     * 根据身份编号获取性别
     *
     * @param idCard 身份编号
     * @return 性别(M - 男 ， F - 女 ， N - 未知)
     */
    public static String getGenderByIdCard(String idCard) {
        String sGender = "未知";

        String sCardNum = idCard.substring(16, 17);
        if (Integer.parseInt(sCardNum) % 2 != 0) {
            sGender = "男";//男
        } else {
            sGender = "女";//女
        }
        return sGender;
    }

    /**
     * 邮储用
     * 1-男；2-女，
     *
     * @param value
     * @return
     */
    public static String getSexCode(String value) {
        value = value.trim();
        if (value == null || (value.length() != 15 && value.length() != 18)) {
            return "";
        }
        if (value.length() == 15 || value.length() == 18) {
            String lastValue = value.substring(value.length() - 1, value.length());
            int sex;
            if (lastValue.trim().toLowerCase().equals("x") || lastValue.trim().toLowerCase().equals("e")) {
                return "1";
            } else {
                sex = Integer.parseInt(lastValue) % 2;
                return sex == 0 ? "1" : "2";
            }
        } else {
            return "";
        }
    }

    /**
     * 根据身份证号计算年龄
     *
     * @param pensonnelIdCard
     * @return
     */
    public static Integer getPersonAgeFromIdCard(String pensonnelIdCard) {

        //截取身份证中出行人出生日期中的年、月、日
        Integer personYear = Integer.parseInt(pensonnelIdCard.substring(6, 10));
        Integer personMonth = Integer.parseInt(pensonnelIdCard.substring(10, 12));
        Integer personDay = Integer.parseInt(pensonnelIdCard.substring(12, 14));

        Calendar cal = Calendar.getInstance();
        // 得到当前时间的年、月、日
        Integer yearNow = cal.get(Calendar.YEAR);
        Integer monthNow = cal.get(Calendar.MONTH) + 1;
        Integer dayNow = cal.get(Calendar.DATE);

        // 用当前年月日减去生日年月日
        Integer yearMinus = yearNow - personYear;
        Integer monthMinus = monthNow - personMonth;
        Integer dayMinus = dayNow - personDay;

        Integer age = yearMinus; //先大致赋值

        if (yearMinus == 0) { //出生年份为当前年份
            age = 0;
        } else { //出生年份大于当前年份
            if (monthMinus < 0) {//出生月份小于当前月份时，还没满周岁
                age = age - 1;
            }
            if (monthMinus == 0) {//当前月份为出生月份时，判断日期
                if (dayMinus < 0) {//出生日期小于当前月份时，没满周岁
                    age = age - 1;
                }
            }
        }
        return age;
    }


    public static void main(String[] a) {

        System.out.println(getPersonAgeFromIdCard("210181199308204019"));

//        String idcard = "210103199104063319";
//        String sex = getGenderByIdCard(idcard);
//        System.out.println("性别:" + sex);
//
//        Short nian = getYearByIdCard(idcard);
//        Short yue = getMonthByIdCard(idcard);
//        Short ri = getDateByIdCard(idcard);
//        System.out.print(nian + "年" + yue + "月" + ri + "日");
//
//        String sr = getBirthByIdCard(idcard);
//        System.out.println("生日:" + sr);
    }
}