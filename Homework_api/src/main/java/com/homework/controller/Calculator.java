package com.homework.controller;


import com.homework.common.DateCalculator;
import com.homework.common.MathCalculator;
import com.homework.common.StringCalculator;
import com.homework.dto.FoodShop;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class Calculator implements DateCalculator, StringCalculator, MathCalculator {
    @Override
    public void printNowDateTime() {
        LocalDateTime ldt = LocalDateTime.now();
        String nowTime = ldt.toString();
        nowTime.replace(nowTime.charAt(9), ' ');
        nowTime.substring(0, 19);
        System.out.println(nowTime);
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-DD HH:mm:ss");
//        System.out.println(dtf.format(ldt));;
    }

    @Override
    public Calendar makeCalendar(String year, String month, String date) {
        Calendar c = new GregorianCalendar(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(date));
        return null;
    }

    @Override
    public void printFormat(Calendar calc) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD E요일");
        System.out.println(simpleDateFormat.format(calc.getTimeInMillis()));
    }

    @Override
    public boolean isLeapYear(int year) {
        return year % 4 == 0 ? true : false;
    }

    @Override
    public long leapDate(int startYear, int endYear) {
        int answer = 0;
        for (int i = startYear; i <= endYear ; i++) {
            if (isLeapYear(i)) {
                answer += 366;
            }
            else {
                answer += 365;
            }
        }
        return answer;
    }

    // 해당 클래스안에 정의해야되는 메소드들은 현재
    // StringCalculator, MathCalculator, DateCalculator 인터페이스에 추상메소드로 정의되어있다.
    // 세 인터페이스를 구현하는 클래스로 완성하시오. 즉, implements 하여 해당 각 메소드를 완성하시오.
    @Override
    public int sumString(String num1, String num2) {
        if (num1.contains(".")) {
            return (int) (Math.round(Double.parseDouble(num1) + Double.parseDouble(num2)));
        }
        return Integer.parseInt(num1) + Integer.parseInt(num2);
    }

    @Override
    public int minusString(String num1, String num2) {
        if (num1.contains(".")) {
            return -1;
        }
        return Math.abs(Integer.parseInt(num1)) - Math.abs(Integer.parseInt(num2));
    }

    @Override
    public int findCharCount(String str, char ch) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                cnt++;
            }
        }
        return cnt;
    }

    @Override
    public int selectTokenCount(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, " ");

        return stringTokenizer.countTokens();
    }

    @Override
    public String toSpaceUpper(String str) {
        String[] arr = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(Character.toUpperCase(arr[i].charAt(0)) + arr[i].substring(1));
            if (i == arr.length - 1) {
                break;
            }
            sb.append(" ");
        }
        return sb.toString();
    }

    @Override
    public FoodShop[] csvFormat() {
        String str = "1,맘스쿡,광주광역시 동구 동계천로143,062-233-1233,향토맛집,2022-01-11\n"
                + "2,옛날밥상,광주광역시 남구 용대로119번길 6,062-653-7337,향토맛집,2022-01-11\n"
                + "3,송정떡갈비,광주광역시 광산구 광산로29번길 1,062-944-1439,향토맛집,2022-01-11\n"
                + "4,홍춘이,광주광역시 북구 무등로180번길 9-18,062-521-7733,향토맛집,2022-01-11\n"
                + "5,종가집떡갈비,광주광역시 광산구 상무대로 226,062-943-8282,향토맛집,2022-01-11\n"
                + "6,광신보리밥,광주광역시 북구 두리봉길 2-1(두암동),062-264-1811,향토맛집,2022-01-11\n"
                + "7,조선옥,광주광역시 남구 효덕로 103,062-654-3322,한상맛집,2022-01-11\n"
                + "8,송원회관,광주광역시 북구 경양로135번길 29(신안동),062-529-3250,한상맛집,2022-01-11\n"
                + "9,만선당어부의밥상,광주광역시 광산구 수완로11번길 3,062-955-5595,한상맛집,2022-01-11\n"
                + "10,백년미가(유촌점),광주광역시 서구 유덕로28번길 18,062-946-3392,한상맛집,2022-01-11";
        String[] each = str.split("\n");
        FoodShop[] fs = new FoodShop[10];
        for (int i = 0; i < each.length; i++) {
            String[] store = each[i].split(",");
            int year = Integer.parseInt(store[5].substring(0, 4));
            int month = Integer.parseInt(store[5].substring(5, 7));
            int date = Integer.parseInt(store[5].substring(8, 10));
            LocalDate ld = LocalDate.of(year, month, date);
            FoodShop fShop = new FoodShop(Integer.parseInt(store[0]), store[1], store[2], store[3], store[4], ld);
        }
        return new FoodShop[0];
    }

}
