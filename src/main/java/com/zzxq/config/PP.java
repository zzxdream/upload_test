package com.zzxq.config;

/**
 * @Author: ZZXQ
 * @Date: 2022/7/17 12:13
 * @Describe:
 */
public class PP {

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                UU uu = new UU();
                uu.test();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
