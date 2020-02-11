package com.project.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * test
 *
 * @author {zhulimin}
 * @date 2019/12/30 0030 上午 10:20
 */
public class test {
    public static void main(String[] args) {
        List<StringBuffer> stringBuffers = new ArrayList<>();
        List<StringBuffer> stringBuffers1 = new ArrayList<>();
        List<StringBuffer> stringBuffers2 = new ArrayList<>();

        //生成数据
        int many = 200;
        stringBuffers = aaa(many);
        stringBuffers1 = bbb(many);
        stringBuffers2 = ccc(many);
//        for (int i = 0; i < many; i++) {
//            System.out.println(stringBuffers.get(i) + "," + stringBuffers1.get(i));
//        }

//        for (int i = 0; i < many; i++) {
//            System.out.println(stringBuffers1.get(i));
//        }
        for (int i = 0; i < many; i++) {
            System.out.println(stringBuffers2.get(i));
        }

    }

    //创建几组字符串数据
    public static List<StringBuffer> aaa(int many) {
        String[] array = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "q", "w", "e", "r", "t",
                "y", "u", "i", "o", "p", "a", "s", "d", "f", "g", "h", "j", "k", "l", "z",
                "x", "c", "v", "b", "n", "m"};
        List<StringBuffer> stringBuffers = new ArrayList<>();
        Random random = new Random();
        //生成几位字符串随机数
        int length = 20;
        for (int j = 0; j < many; j++) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < length; i++) {
                stringBuffer.append(array[random.nextInt(36)]);
            }
            stringBuffers.add(stringBuffer);
        }
        return stringBuffers;
    }
    //创建几组字符串递增数字
    public static List<StringBuffer> bbb(int many) {
        String[] array = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "q", "w", "e", "r", "t",
                "y", "u", "i", "o", "p", "a", "s", "d", "f", "g", "h", "j", "k", "l", "z",
                "x", "c", "v", "b", "n", "m"};
        List<StringBuffer> stringBuffers = new ArrayList<>();
        Random random = new Random();
        //生成几位字符串随机数
        int length = 10;
        for (int j = 0; j < many; j++) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < length; i++) {
                stringBuffer.append(array[random.nextInt(36)]);
            }
            stringBuffer.append(j+1);
            stringBuffers.add(stringBuffer);
        }
        return stringBuffers;
    }
    //创建几组随机数字
    public static List<StringBuffer> ccc(int many) {
        String[] array = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "q", "w", "e", "r", "t",
                "y", "u", "i", "o", "p", "a", "s", "d", "f", "g", "h", "j", "k", "l", "z",
                "x", "c", "v", "b", "n", "m"};
        List<StringBuffer> stringBuffers = new ArrayList<>();
        Random random = new Random();
        //生成几位字符串随机数
        int length = 15;
        for (int j = 0; j < many; j++) {
            StringBuffer stringBuffer = new StringBuffer();
//            stringBuffer.append("记-");
//            stringBuffer.append("00001");
            for (int i = 0; i < length; i++) {
                stringBuffer.append(array[random.nextInt(10)]);
            }
            stringBuffers.add(stringBuffer);
        }
        return stringBuffers;
    }

}
