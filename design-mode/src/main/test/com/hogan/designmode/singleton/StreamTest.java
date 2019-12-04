package com.hogan.designmode.singleton;

import com.hogan.designmode.StreamDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * wujun
 * 2019/12/04 15:39
 */
public class StreamTest {

    public static void main(String[] args) {
        StreamDemo demo1 = new StreamDemo(1, "11");
        StreamDemo demo2 = new StreamDemo(1, "111");
        StreamDemo demo3 = new StreamDemo(1, "1111");
        StreamDemo demo4 = new StreamDemo(1, "11111");
        StreamDemo demo5 = new StreamDemo(2, "2");
        StreamDemo demo6 = new StreamDemo(3, "3");
        StreamDemo demo7 = new StreamDemo(4, "4");
        List<StreamDemo> lists = new ArrayList<>();
        lists.add(demo1);
        lists.add(demo2);
        lists.add(demo3);
        lists.add(demo4);
        lists.add(demo5);
        lists.add(demo6);
        lists.add(demo7);

        //lists.stream().collect(Collectors.toMap(StreamDemo::getNum, Function.identity(), (key1, key2) -> key2));
        //Map map = lists.stream().collect(Collectors.counting());
        //Long l = lists.stream().reduce((r1, r2) -> r1.getNum() + r2.getNum()).ifPresent(System.out::println);
        //Double i = lists.stream().collect(Collectors.averagingInt(StreamDemo::getNum));
        //int i = lists.stream().collect(Collectors.summarizingInt(StreamDemo::getNum)).getMax();

        //System.out.println(i);
        /*LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime firstDayOfMonth = localDateTime.withDayOfYear(1);
        LocalDateTime l = localDateTime.with(TemporalAdjusters.dayOfWeekInMonth(1, DayOfWeek.MONDAY));

        System.out.println(l.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));*/
    }
}
