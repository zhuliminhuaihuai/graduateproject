package com.project.pojo;

import junit.framework.TestResult;

import java.util.ArrayList;

public class test {


    public static void main(String[] args) {

      /*  int[] str = {6,3,7,2,9};//官式冒泡

        for(int i =0;i<str.length;i++){
            for(int j=0;j<str.length-1;j++){
                if(str[i]>str[j]){
                    int temp = str[j];
                    str[j] = str[i];
                    str[i] = temp;
                }
            }
        }

        for(int i =0;i<str.length;i++){
            System.out.println(str[i]);
        }
*/
         String a = "java";
         String b = "java";
         String c = new String("java");
         String d = new String("java");
         String e = c;

        System.out.println(a==b);
        System.out.println(c==d);
        System.out.println(c==e);
    }

}
