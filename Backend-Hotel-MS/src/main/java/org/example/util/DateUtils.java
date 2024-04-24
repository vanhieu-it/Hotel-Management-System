package org.example.util;

//import org.example.exception.BadRequestException;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtils {


  public final static Integer countFromDateToDate(Date firstDate, Date secondDate) {
    int count = 0;
    try {
      long t1 = firstDate.getTime();
      long t2 = secondDate.getTime();
      SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

      if (t1 < t2) {
        //1 = 1000
        for (long i = t1; i <= t2; i += 86400000) {
          Date date = new SimpleDateFormat("yyyy-MM-dd").parse(f.format(i));
          count++;
        }
      }
    } catch (Exception e) {
      //throw new BadRequestException("invalid-date");
    }
    return count - 1;
  }

  public final static List<Date> getDatesFromTo(String dateFrom, String dateTo) {
    List<Date> listDayFromTo = new ArrayList<>();
    try {
      Date d_from = new SimpleDateFormat("yyyy-MM-dd").parse(dateFrom);
      Date d_to = new SimpleDateFormat("yyyy-MM-dd").parse(dateTo);

      long t1 = d_from.getTime();
      long t2 = d_to.getTime();

      SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

      if (t1 < t2) {
        //1 = 1000
        for (long i = t1; i <= t2; i += 86400000) {
          Date date = new SimpleDateFormat("yyyy-MM-dd").parse(f.format(i));
          listDayFromTo.add(date);
        }
      }
    } catch (Exception e) {
      //throw new BadRequestException("invalid-date");
    }
    return listDayFromTo;
  }

  public final static DateTimeFormatter dateTimeFormatter =
      DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");

  public final static DateTimeFormatter dateFormatter =
      DateTimeFormatter.ofPattern("yyyy-MM-dd");

  public static Long now() {
    return currentDate().getTime();
  }

  public static Date currentDate() {
    return new Date();
  }

  public static ZonedDateTime longToZonedDateTime(Long date) {
    Instant instant = Instant.ofEpochMilli(date);
    return ZonedDateTime.ofInstant(instant, ZoneOffset.UTC);
  }

  public static LocalDate stringToZonedDateTime(String date) {
    return LocalDate.parse(date, dateFormatter);
  }

  public static String zonedDateTimeToString(LocalDate localDate) {
    return LocalDate.now().format(dateFormatter);
  }

  public static Date plusDay(Date date, int day) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.DATE, day);
    return calendar.getTime();
  }

  public static boolean isSameDay(Date date1, Date date2) {
    Calendar cal1 = Calendar.getInstance();
    Calendar cal2 = Calendar.getInstance();
    cal1.setTime(date1);
    cal2.setTime(date2);
    return cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR) &&
        cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
  }

  public static boolean isBefore(Date date1, Date date2) {
    Calendar cal1 = Calendar.getInstance();
    Calendar cal2 = Calendar.getInstance();
    cal1.setTime(date1);
    cal2.setTime(date2);
    return cal1.get(Calendar.DAY_OF_YEAR) < cal2.get(Calendar.DAY_OF_YEAR) &&
        cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
  }

  /**
   * return 0 if equal. return -1 if param 1 before param 2. return 1 if param 1 after param 2.
   *
   * @param date1
   * @param date2
   * @return int
   */
  public static int compareTo(Date date1, Date date2) {
    if (isSameDay(date1, date2)) {
      return 0;
    }
    if (isBefore(date1, date2)) {
      return -1;
    }
    return 1;
  }

  public static LocalDate toLocalDate(Date dateToConvert) {
    return dateToConvert.toInstant()
        .atZone(ZoneId.systemDefault())
        .toLocalDate();
  }

  public static LocalTime toLocalTime(Date dateToConvert) {
    return dateToConvert.toInstant()
        .atZone(ZoneId.systemDefault())
        .toLocalTime();
  }

  public static Date toDate(LocalDate dateToConvert) {
    return Date.from(dateToConvert.atStartOfDay()
        .atZone(ZoneId.systemDefault())
        .toInstant());
  }

}
