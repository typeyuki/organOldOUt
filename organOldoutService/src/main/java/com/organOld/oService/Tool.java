package com.organOld.oService;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class Tool {

    /**
     * date转字符串
     * @param date
     * @param format
     * @return
     */
    public static String dateToString(Date date,String format){
        if(date==null) return "";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    public static Date stringToDate(String str){
        if(str==null || str.equals(""))
            return null;
        if(str.contains(".")){
            str=str.replace(".","-");
        }
        if(str.contains("\\")){
            str=str.replace("\\\\","-");
        }
        if(str.contains("年")){
            str=str.replace("年","-");
        }
        if(str.contains("月")){
            str=str.replace("月","-");
        }
        if(str.contains("日")){
            str=str.replace("日","-");
        }

        if(!str.contains("-"))
            return null;

        if(str.split("-").length<3){
            //年月
            str+="-01";
        }
        String pattern = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
        boolean isMatch = Pattern.matches(pattern, str);
        if(!isMatch){
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
