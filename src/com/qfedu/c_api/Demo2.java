package com.qfedu.c_api;

public class Demo2 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("0123456789");

        System.out.println(stringBuilder.toString());
        System.out.println(stringBuilder.indexOf("123"));
        System.out.println(stringBuilder.substring(5));
        System.out.println(stringBuilder.substring(5, 9));

        stringBuilder.replace(5,9, "清水白菜");

        System.out.println(stringBuilder.toString());

        int capacity = stringBuilder.capacity();
        stringBuilder.setCharAt(3, '吃');
        System.out.println(stringBuilder);

        stringBuilder.delete(0, 2);
        System.out.println(stringBuilder);

        stringBuilder.deleteCharAt(2);
        System.out.println(stringBuilder);

        StringBuilder stringBuilder1 = new StringBuilder("四大名著");
        System.out.println(stringBuilder1.reverse());
    }
}
