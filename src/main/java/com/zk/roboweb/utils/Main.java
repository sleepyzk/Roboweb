package com.zk.roboweb.utils;

import java.util.Scanner;
import java.lang.StringBuffer;

/**
 * 2021.5.17 阿里巴巴第一题
 * 数对26取模怎么求逆运算
 * NMD
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int x = in.nextInt();
        solution(str, x);
    }

    private static void solution(String str, int x) {
        char[] array = str.toCharArray();
        int len = array.length;
        int[] list = new int[len];
        for (int i = 0; i < len; i++) {
            list[i] = (int) array[i] - (int) ('a');
        }
        for (int i = 0; i < len; i++) {
            if (list[i] >= 26) {
                list[i] = list[i] + 26;
            }
        }
        for (int j = len - 1; j > 0; j--) {
            list[j] = list[j] - list[j - 1];
        }
        list[0] = list[0] - x;
        int a = (int) ('a');
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            list[i] = list[i] + a;
            sb.append((char) list[i]);
        }
        String res = new String(sb);
        System.out.println(res);
    }
}