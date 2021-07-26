package interview;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class solution2 {

    public static void main(String[] args) throws ParseException {
        String[][] data = new String[][]{
                {"2020-03-20", "2020-03-22"},
                {"2020-05-20", "2020-07-22"},
                {"2020-04-20", "2020-05-22"},
                {"2020-08-20", "2020-09-22"}};
        solve(data);
    }

    public static void solve(String[][] data) throws ParseException {
        Map<Date, Integer> map = new TreeMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (String[] str : data) {
            Date start = sdf.parse(str[0]);
            Date end = sdf.parse(str[1]);
            int result = dateReduce(start, end);
            map.put(start, result);
        }
        List<Date> dateList = new ArrayList(map.keySet());
        List<Integer> dayList = new ArrayList(map.values());
        Map<Date, Integer> spare = new TreeMap<>();
        Map<Date, Integer> cross = new TreeMap<>();
        for (int i = 0; i < dateList.size(); i++) {
            if (i > 0) {
                Date start = dateList.get(i - 1);
                start = addDayToDate(start, dayList.get(i - 1));
                Date end = dateList.get(i);
                int result = dateReduce(start, end);
                if (result > 0) spare.put(start, result - 2);
                else cross.put(start, result);
            }
        }
        print(spare, "空余时间段：");
        print(cross, "\n交叉时间段：");
    }

    public static int dateReduce(Date start, Date end) {
        return (int) ((end.getTime() - start.getTime()) / (24 * 60 * 60 * 1000));
    }

    public static void print(Map<Date, Integer> map, String info) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.print(info);
        for (Date date : map.keySet()) {
            Date to = (Date) date.clone();
            if (info.equals("空余时间段：")) date = addDayToDate(date, 1);
            to = addDayToDate((Date) date.clone(), map.get(to));
            String result;
            if (info.equals("空余时间段："))
                result = String.format("%s ~ %s，", simpleDateFormat.format(date), simpleDateFormat.format(to));
            else result = String.format("%s ~ %s，", simpleDateFormat.format(to), simpleDateFormat.format(date));
            System.out.print(result);
        }
    }

    public static Date addDayToDate(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_WEEK, day);
        return calendar.getTime();
    }
}
