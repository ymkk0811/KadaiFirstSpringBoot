package com.techacademy;

import java.util.Calendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {

    @GetMapping("/dayofweek/{value}")
    public String dispDayOfWeek(@PathVariable String value) {
        String yyyymmdd = value;
        try {
            int year = Integer.parseInt(yyyymmdd.substring(0, 4));
            int month = Integer.parseInt(yyyymmdd.substring(4, 6))-1;
            int date = Integer.parseInt(yyyymmdd.substring(6, 8));

            Calendar cl = Calendar.getInstance();
            cl.set(Calendar.YEAR, year);
            cl.set(Calendar.MONTH, month);
            cl.set(Calendar.DATE, date);

            int dayOfWeek = cl.get(Calendar.DAY_OF_WEEK);
            String result = null;
            switch (dayOfWeek) {
            case Calendar.SUNDAY:
                return "Sunday";
            case Calendar.MONDAY:
                return "Monday";
            case Calendar.TUESDAY:
                return "Tuesday";
            case Calendar.WEDNESDAY:
                return "Wednesday";
            case Calendar.THURSDAY:
                return "Thursday";
            case Calendar.FRIDAY:
                return "Friday";
            case Calendar.SATURDAY:
                return "Saturday";
            }
            return result;
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            return "";

        }
    }

    // 日付文字列から年・月・日を取得するメソッド
    public void substring(int beginIndex, int endIndex) {

    }

    //年・月・日から曜日を取得するメソッド//


    // 以下仕様２//

    // 足し算//
    @GetMapping("/plus/{val1}/{val2}")
    public int calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 + val2;
        return res;
    }

    // 引き算//
    @GetMapping("/minus/{val1}/{val2}")
    public int calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 - val2;
        return res;
    }

    // 掛け算//
    @GetMapping("/times/{val1}/{val2}")
    public int calcTimes(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 * val2;
        return res;
    }

    // 割り算//
    @GetMapping("/divide/{val1}/{val2}")
    public int calcDivide(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 / val2;
        return res;
    }

}
