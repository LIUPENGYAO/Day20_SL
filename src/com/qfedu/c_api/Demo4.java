package com.qfedu.c_api;

import java.util.Properties;

public class Demo4 {
    public static void main(String[] args) {
        Properties properties = System.getProperties();

        properties.list(System.out);

        String property = properties.getProperty("os.name");
        System.out.println(property);
    }
}
