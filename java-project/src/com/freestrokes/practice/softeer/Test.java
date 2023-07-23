package com.freestrokes.practice.softeer;

import java.util.*;
import java.io.*;

public class Test {

    // public static int value1;
    // public static int value2;
    // public static int value3;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int value1 = Integer.parseInt(st.nextToken());
        int value2 = Integer.parseInt(st.nextToken());
        int value3 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        int value4 = Integer.parseInt(st.nextToken());
        int value5 = Integer.parseInt(st.nextToken());

        System.out.println("value1: " + value1);
        System.out.println("value2: " + value2);
        System.out.println("value3: " + value3);

        System.out.println("value4: " + value4);
        System.out.println("value5: " + value5);

        int count = 10;

        System.out.println(recursiveCalc(count));

        double doubleValue = 0.00D;
        float floatValue = 0.00F;

        System.out.printf("%.2f\n", doubleValue);

        // Arrays.sort() 사용을 위해서는 wrapper 클래스를 사용해야 함.
        Integer[] sortArr = {1, 26, 17, 25, 99, 44, 303};

        Arrays.sort(sortArr);
        System.out.println(Arrays.toString(sortArr));

        Arrays.sort(sortArr, Collections.reverseOrder());
        System.out.println(Arrays.toString(sortArr));

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "value1");
        map.put(2, "value2");
        map.put(3, "value3");

        Iterator<Integer> keys = map.keySet().iterator();
        while( keys.hasNext() ){
            Integer key = keys.next();
            System.out.println("key: " + key + " / value: " + map.get(key));
        }

        for ( Integer key : map.keySet() ){
            System.out.println("key: " + key + " / value: " + map.get(key));
        }

        for( Map.Entry<Integer, String> element : map.entrySet() ){
            System.out.println("key: " + element.getKey() + " / value: " + element.getValue());
        }

    }

    public static long recursiveCalc(int count) {
        System.out.println("count: " + count);

        if (count == 0) {
            return count;
        } else {
            count--;
            return recursiveCalc(count);
        }
    }

}
