/*
 * Decompiled with CFR 0.152.
 */
package com.ntu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static java.sql.Date convertStringIntoSqlDate(String dateIn) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date dateInUtil = format.parse(dateIn);
            java.sql.Date dateOut = new java.sql.Date(dateInUtil.getTime());
            return dateOut;
        }
        catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
