package com.hogan.designmode;

import lombok.extern.slf4j.Slf4j;

/**
 * Hello world!
 */
@Slf4j
public class App {

    public static void main(String[] args) {
        /*Farm farm = new ChongQingFarm();
        Animal cow = farm.produceAnimal();
        Fruit apple = farm.produceFruit();
        cow.show();
        apple.show();*/
        /*MDC.put("user", "wujun");
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println(MDC.get("user"));
            }
        };
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MDC.put("user", "wuxing");
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                System.out.println(MDC.get("user"));
                new Thread() {
                    @Override
                    public void run() {
                        System.out.println(MDC.get("user"));
                    }
                }.start();
            }
        };
        thread1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();*/
        /*String[] arr = new String[]{"chengdu", "chongqing", "xian", "shenzheng", "xian"};
        List<String> lists = new ArrayList<String>();
        lists.add("chengdu");
        lists.add("chongqing");
        String first = lists.stream()
                .parallel()
                .distinct()
                .map(String::toUpperCase)
                .findFirst()
                .orElse("demo");
        System.out.println(first);*/
        /*Stream.of(lists)
                .parallel()
                .distinct()
                .map(String::toUpperCase)
                .collect(Collectors.toList())
                .forEach(System.out::println);*/
        /*Stream.generate(() ->{
            Random random = new Random(47);
            return random.nextInt();
        }).limit(10).forEach(System.out::println);*/
        /*Integer[] arr = new Integer[]{1, 2, 4, 1000, 1, 2342, 12321123};
        Arrays.stream(arr).max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? 1 : -1;
            }
        }).ifPresent(System.out::println);*/

    }
}
