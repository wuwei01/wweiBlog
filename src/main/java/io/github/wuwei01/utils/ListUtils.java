package io.github.wuwei01.utils;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;

import java.util.*;
import java.util.stream.Collectors;

public class ListUtils {

    public static void main(String[] args) {
        // 如何把list集合拼接成以逗号分隔的字符串 a,b,c
        List<String> list = Arrays.asList("a", "b", "c");
        // 第一种方法，可以用stream流
        String join = list.stream().collect(Collectors.joining(","));
        System.out.println(join); // 输出 a,b,c
        // 第二种方法，其实String也有join方法可以实现这个功能
        //String join = String.join(",", list);
        System.out.println(join); // 输出 a,b,c


//        if (strA.equalsIgnoreCase(strB)) {
//            System.out.println("相等");
//        }

//        Objects.equals(strA, strB);

        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        List<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("b");
        list2.add("d");
        list1.retainAll(list2);
        System.out.println(list1); // 输出[a, b]


    String str = "yideng";
    String capitalize = StringUtils.capitalize(str);
    System.out.println(capitalize); // 输出Yideng

        String str1 = StringUtils.repeat("ab", 2);
        System.out.println(str1); // 输出abab

        // Date类型转String类型
        String date = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        System.out.println(date); // 输出 2021-05-01 01:01:01

        // String类型转Date类型
        Date date1 = DateUtils.parseDate("2021-05-01 01:01:01", "yyyy-MM-dd HH:mm:ss");

        // 计算一个小时后的日期
        Date date2 = DateUtils.addHours(new Date(), 1);

        // 返回两个字段
        ImmutablePair<Integer, String> pair = ImmutablePair.of(1, "yideng");
        System.out.println(pair.getLeft() + "," + pair.getRight()); // 输出 1,yideng
        // 返回三个字段
        ImmutableTriple<Integer, String, Date> triple = ImmutableTriple.of(1, "yideng", new Date());
        System.out.println(triple.getLeft() + "," + triple.getMiddle() + "," + triple.getRight()); // 输出 1,yideng,Wed Apr 07 23:30:00 CST 2021


//        // 两个集合取交集
//        Collection<String> collection = CollectionUtils.retainAll(listA, listB);
//        // 两个集合取并集
//        Collection<String> collection1 = CollectionUtils.union(listA, listB);
//        // 两个集合取差集
//        Collection<String> collection2 = CollectionUtils.subtract(listA, listB);
    }
}
