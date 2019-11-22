package com.qfedu.c_api;

public class Demo1 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("我想吃烤羊排");

        stringBuilder.append("热干面");
        stringBuilder.append(1);
        stringBuilder.append('吃');
        stringBuilder.append(new Demo1());
        stringBuilder.append("油泼面，擀面皮，肉夹馍~~~".toCharArray(), 0, 5);

        System.out.println(stringBuilder);

        StringBuilder stringBuilder1 = new StringBuilder("01234567890");

        stringBuilder1.insert(8, 3);
        System.out.println(stringBuilder1);
    }
}
