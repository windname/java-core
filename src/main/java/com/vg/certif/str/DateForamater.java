/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.certif.str;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;

/**
 *
 * @author vladimir
 */
public class DateForamater {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 'as' HH:mm:ss");
        System.out.println(sdf.format(new Date())); // 2015-05-14 as 17:20:27

        Formatter formatter = new Formatter();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.FEBRUARY, 1);        
        System.out.println(formatter.format("%tY / %<tm / %<td", calendar));
        System.out.println(String.format("%1$tY / %1$tm / %1$td", calendar));
        System.out.println(String.format("%1$tm %1$te,%1$tY", calendar));
        System.out.println(String.format("%1$tm %<te,%<tY", calendar));
        System.out.println(String.format("%tF %<tR", new Date()));
        
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        System.out.println(df.format(new Date()));

//formatter.format("%tY/%<tB/%<td", calendar);
    }
}
