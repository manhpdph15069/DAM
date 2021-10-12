/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author phamd
 */
public class XDate {
    static SimpleDateFormat formater = new SimpleDateFormat();
//    public static Date toDate(String date,String pattern){
//        try {
//            formater.applyPattern(pattern);
//            return formater.parse(date);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
    
        public static Date toDate(String date,String...pattern){
        try {
            if(pattern.length>0)formater.applyPattern(pattern[0]);
            if(date==null)return XDate.now();
            return formater.parse(date);
        } catch (ParseException ex) {
            throw new RuntimeException(ex); 
        }
    }
    public static String toString(Date date, String...pattern){
        if(pattern.length>0)formater.applyPattern(pattern[0]);
        if(date==null)date=XDate.now();
        return formater.format(date);
    }
    public static Date addDays(Date date,long days){
        date.setTime(date.getTime()+days*24*60*60*1000);
        return date;
    }
        public static Date now() {
        return new Date();   //new Date lấy giờ hiện tại
    }
        
            public static Date add(int days){
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH,days);
        return cal.getTime();
    }
}
