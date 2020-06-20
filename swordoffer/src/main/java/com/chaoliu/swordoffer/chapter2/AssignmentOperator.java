package com.chaoliu.swordoffer.chapter2;

// todo 1、赋值运算符函数
public class AssignmentOperator {

    //拷贝
    public char[] strcpy(char[] chars) {
        if (chars == null) {
            chars = new char[1];
            chars[0] = '\0';
            return chars;
        }

        int length = chars.length;

        char[] tmp = new char[length + 1];

        //字符串拷贝
        for (int i = 0; i < length; i++) {
            tmp[i] = chars[i];
        }
        tmp[length] = '\0';
        return tmp;
    }
}
