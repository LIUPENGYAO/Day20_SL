package com.qfedu.c_api;

import java.io.IOException;

public class Demo5 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();

        System.out.println(runtime.totalMemory());
        System.out.println(runtime.freeMemory());
        System.out.println(runtime.maxMemory());

        Process exec = runtime.exec("D:\\Program Files\\Tencent\\QQ\\Bin\\QQ.exe");
        Thread.sleep(10000);
        exec.destroy();
    }
}
