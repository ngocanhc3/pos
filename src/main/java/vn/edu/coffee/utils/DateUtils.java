/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.edu.coffee.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 *
 * @author thuandv
 */
public class DateUtils {

    private static final String DATE_FORMAT = "dd/MM/yyyy";
    private static final String DATE_FORMAT_VN_FULL = "hh:mm dd/MM/yyyy";
    private static final String DATE_FORMAT_SQL = "yyyy-MM-dd";

    public static String toDateSql(LocalDate val, String format) {
        return val.format(DateTimeFormatter.ofPattern(format));
    }

    public static String toDateSql(LocalDate val) {
        return toDateSql(val, DATE_FORMAT_SQL);
    }

    public static LocalDateTime firstDayOfMonth(LocalDateTime val) {
        return val.with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MIN);
    }

    public static LocalDateTime lastDayOfMonth(LocalDateTime val) {
        return val.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX);
    }

    public static LocalDate convertString2LocalDate(String val, String format) {
        return LocalDate.parse(val, DateTimeFormatter.ofPattern(format));
    }

    public static LocalDate convertString2LocalDate(String val) {
        return convertString2LocalDate(val, DATE_FORMAT);
    }

    public static String formatLocalDateTime(LocalDateTime val, String format) {
        return val.format(DateTimeFormatter.ofPattern(format));
    }

    public static String formatLocalDateTime(LocalDateTime val) {
        if (val == null) return "";
        return formatLocalDateTime(val, DATE_FORMAT_VN_FULL);
    }
}
