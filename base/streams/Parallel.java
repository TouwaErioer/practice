package base.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @description: 顺序流和并行流比较
 * @author: chobit
 * @created: 2021/07/30 11:01
 */
public class Parallel {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            list.add(UUID.randomUUID().toString());
        }
        long startA = System.nanoTime();
        list.stream().sorted(String::compareTo);
        long endA = System.nanoTime();
        System.out.println(TimeUnit.NANOSECONDS.toMillis(endA - startA));

        long startB = System.nanoTime();
        list.parallelStream().sorted(String::compareTo);
        long end1B = System.nanoTime();
        System.out.println( TimeUnit.NANOSECONDS.toMillis(end1B - startB));
    }

}