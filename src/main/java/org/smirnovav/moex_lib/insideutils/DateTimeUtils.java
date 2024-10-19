package org.smirnovav.moex_lib.insideutils;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateTimeUtils {

    private DateTimeUtils() {
    }

    /**
     * Извлекает дату в строчном формате yyyy-MM-dd из объекта класса GregorianCalendar
     * @param date Объект класса GregorianCalendar
     * @return Дата в формате строки yyyy-MM-dd
     */
    public static String calendarToDateWithDash(Calendar date) {
        if (date == null) {
            return "null";
        }
        String day = String.valueOf(date.get(Calendar.DAY_OF_MONTH));
        if (day.length() < 2) {
            day = "0" + day;
        }
        String  month = String.valueOf(date.get(Calendar.MONTH) + 1);
        if (month.length() < 2) {
            month = "0" + month;
        }
        int year = date.get(Calendar.YEAR);

        return year + "-" + month + "-" + day;
    }

    /**
     * Извлекает дату и время в строчном формате yyyy-MM-dd_hh:mm:ss из объекта класса GregorianCalendar
     * @param date Объект класса GregorianCalendar
     * @return Дата и время в формате строки yyyy-MM-dd_hh:mm:ss
     */
    public static String calendarToDateTime(Calendar date) {
        if (date == null) {
            return "null";
        }
        String day = String.valueOf(date.get(Calendar.DAY_OF_MONTH));
        if (day.length() < 2) {
            day = "0" + day;
        }
        String  month = String.valueOf(date.get(Calendar.MONTH) + 1);
        if (month.length() < 2) {
            month = "0" + month;
        }
        int year = date.get(Calendar.YEAR);
        String hour = String.valueOf(date.get(Calendar.HOUR_OF_DAY));
        if (hour.length() < 2) {
            hour = "0" + hour;
        }
        String minute = String.valueOf(date.get(Calendar.MINUTE));
        if (minute.length() < 2) {
            minute = "0" + minute;
        }
        String second = String.valueOf(date.get(Calendar.SECOND));
        if (second.length() < 2) {
            second = "0" + second;
        }
        return year + "-" + month + "-" + day + "_" + hour + ":" + minute + ":" + second;
    }
    /**
     * Извлекает время в строчном формате hh:mm:ss из объекта класса GregorianCalendar
     * @param time Объект класса GregorianCalendar
     * @return Время в формате строки hhmmss
     */
    public static String calendarToFormattedTime(Calendar time) {
        String second = String.valueOf(time.get(Calendar.SECOND));
        if (second.length() < 2) {
            second = "0" + second;
        }
        String  minute = String.valueOf(time.get(Calendar.MINUTE));
        if (minute.length() < 2) {
            minute = "0" + minute;
        }
        String hour = String.valueOf(time.get(Calendar.HOUR_OF_DAY));
        if (hour.length() < 2) {
            hour = "0" + hour;
        }
        return hour + ":" + minute + ":" + second;
    }

    /**
     * Конвертирует строку с датой и временем в формате yyyy-MM-dd hh:mm:ss в объект класса GregorianCalendar
     * @param date Дата в формате строки yyyyMMdd
     * @return Объект класса GregorianCalendar
     */
    public static Calendar stringDateTimeWithDashesToCalendar(String date) {
        if (date == null) {
            return null;
        }
        if (date.length() == 19) {
            String yyyy = date.substring(0, 4);
            String mM = date.substring(5, 7);
            String dd = date.substring(8, 10);
            String hh = date.substring(11, 13);
            String mm = date.substring(14, 16);
            String ss = date.substring(17, 19);
            try {
                int iyyyy = Integer.parseInt(yyyy);
                int iMM = Integer.parseInt(mM);
                int idd = Integer.parseInt(dd);
                int ihh = Integer.parseInt(hh);
                int imm = Integer.parseInt(mm);
                int iss = Integer.parseInt(ss);
                return new GregorianCalendar(iyyyy, iMM - 1, idd, ihh, imm, iss);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return new GregorianCalendar();
            }
        }
        return new GregorianCalendar();
    }

    /**
     * Конвертирует строку с датой в формате yyyy-MM-dd из котировки в формате finam в объект класса GregorianCalendar
     * @param date Дата в формате строки yyyy-MM-dd
     * @return Объект класса GregorianCalendar
     */
    public static Calendar dateWithDashToCalendar(String date) {
        if (date.length() == 10) {
            String yyyy = date.substring(0, 4);
            String mM = date.substring(5, 7);
            String dd = date.substring(8, 10);
            try {
                int iyyyy = Integer.parseInt(yyyy);
                int iMM = Integer.parseInt(mM);
                int idd = Integer.parseInt(dd);
                return new GregorianCalendar(iyyyy, iMM - 1, idd);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return new GregorianCalendar();
                //TODO Создать вывод записи в лог
            }
        }
        return new GregorianCalendar();
    }

    /**
     * Возвращает объект класс Calendar с датой 0001-01-01 и нужным временем
     * @param time Время в формате hh:mm:ss
     * @return Объект класс Calendar с датой 0001-01-01 и нужным временем
     */
    public static Calendar stringTimeToCalendar(String time) {
        if (time.length() == 8) {
            String hh = time.substring(0, 2);
            String mm = time.substring(3, 5);
            String ss = time.substring(6, 8);
            try {
                int ihh = Integer.parseInt(hh);
                int imm = Integer.parseInt(mm);
                int iss = Integer.parseInt(ss);
                return new GregorianCalendar(1, 0, 1, ihh, imm, iss);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return new GregorianCalendar();
                //TODO Создать вывод записи в лог
            }
        }
        return new GregorianCalendar();
    }



    /**
     * Извлекает дату в строчном формате yyyyMMdd из объекта класса GregorianCalendar
     * @param date Объект класса GregorianCalendar
     * @return Дата в формате строки yyyyMMdd
     */
    public static String calendarToDate(Calendar date) {
        String day = String.valueOf(date.get(Calendar.DAY_OF_MONTH));
        if (day.length() < 2) {
            day = "0" + day;
        }
        String  month = String.valueOf(date.get(Calendar.MONTH) + 1);
        if (month.length() < 2) {
            month = "0" + month;
        }
        int year = date.get(Calendar.YEAR);

        return year + month + day;
    }

    /**
     * Извлекает время в строчном формате hhmmss из объекта класса GregorianCalendar
     * @param time Объект класса GregorianCalendar
     * @return Время в формате строки hhmmss
     */
    public static String calendarToTime(Calendar time) {
        String second = String.valueOf(time.get(Calendar.SECOND));
        if (second.length() < 2) {
            second = "0" + second;
        }
        String  minute = String.valueOf(time.get(Calendar.MINUTE));
        if (minute.length() < 2) {
            minute = "0" + minute;
        }
        String hour = String.valueOf(time.get(Calendar.HOUR_OF_DAY));
        if (hour.length() < 2) {
            hour = "0" + hour;
        }
        return hour + minute + second;
    }



}
