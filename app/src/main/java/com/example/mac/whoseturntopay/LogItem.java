package com.example.mac.whoseturntopay;

import java.util.Date;

/**
 * Created by mac on 6/11/2016.
 */
public class LogItem implements Comparable<LogItem> {
    public LogItem(){}
    String restaurant;
    String amount;
    String date;
    String whoPaid;
    Date dateObject;

    @Override
    public int compareTo(LogItem another) {
        return dateObject.compareTo(another.dateObject);
    }
}