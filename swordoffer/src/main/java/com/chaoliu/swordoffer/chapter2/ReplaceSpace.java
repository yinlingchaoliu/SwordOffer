package com.chaoliu.swordoffer.chapter2;


//todo 5 替换空格
// 时间复杂度O(n2) 不足以拿到offer
public class ReplaceSpace {


    //先计算char中空空格数量 指定分配恰当字符串
    static char[] replaceBlank(char[] str) {

        if (str == null) return null;

        char[] replace = {'%', '2', '0', '\0'};
        int repLength = 3;

        int length = str.length - 1;

        int count = 0;

        //先计算空格次数，来分配空间
        for (int i = 0; i < length; i++) {

            if (str[i] == ' ') {
                count++;
            }
        }

        int extLength = count * (repLength - 1);

        char[] newStr = new char[length + extLength + 1];

        int j = 0;
        for (int i = 0; i < length; i++) {
            if (str[i] == ' ') {
                newStr[j] = '%';
                newStr[j + 1] = '2';
                newStr[j + 2] = '0';
                j = j + 3;
            } else {
                newStr[j] = str[i];
                j++;
            }
        }

        newStr[length + extLength] = '\0';
        return newStr;
    }

    //方法2、从尾端计算



    public static void main(String[] args) {
        char[] str = {'W', 'e', ' ', 'a', 'r', 'e', ' ', 'h', 'a', 'p', 'p', 'y', '\0'};
        System.out.println( String.valueOf( str ) );

        char[] result = replaceBlank( str );
        System.out.println( String.valueOf( result ) );
    }

}
