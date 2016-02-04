package org.ivan.villa.util;

import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Util {

private static final Logger logger = LogManager.getLogger(Util.class);

public Date setFirstHour(String startDate) throws ParseException{
  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
  Calendar calendar = Calendar.getInstance();
    calendar.setTime(format.parse(startDate));
    calendar.set( Calendar.HOUR, 0 );
    calendar.set( Calendar.MINUTE, 0 );
  return calendar.getTime();
}

public Date setLastHour(String endDate) throws ParseException{
  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
  Calendar calendar = Calendar.getInstance();
    calendar.setTime(format.parse(endDate));
    calendar.set( Calendar.HOUR, 23 );
    calendar.set( Calendar.MINUTE, 59 );
  return calendar.getTime();
}

public Date getTodayFirstHour(){
  Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Chicago"));
    calendar.set( Calendar.HOUR_OF_DAY, 0 );
    calendar.set( Calendar.MINUTE, 0 );
  return calendar.getTime();
}

public Date getTodayLastHour(){
  Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Chicago"));
    calendar.set( Calendar.HOUR_OF_DAY, 23 );
    calendar.set( Calendar.MINUTE, 59 );
  return calendar.getTime();
}

}
