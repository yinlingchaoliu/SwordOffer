package com.chaoliu.swordoffer.chapter2;

//todo 3 数组中重复数字
//一个长度为n的数组里所有数字都在0-n-1的范围内，数组中某些数字是重复的，但不知道有几个数字重复了，也不知道数字重复了几次，
//请找出任意重复的数字
public class DuplicationInArray {


    //O(n)辅助空间
    String[] dup(int[] arr) {
        if (arr == null) {
            throw new NullPointerException( "空指针" );
        }

        int length = arr.length;
        int[] tmp = new int[length];

        //找到重复数值计数
        for (int i = 0; i < length; i++) {
            int j = arr[i];
            if (j >= length) throw new IllegalArgumentException( "数字范围越界" );
            tmp[j] = tmp[j] + 1;
        }

        //找到计数大于1的值
        String[] strs = new String[length];
        int l = 0;
        for (int k = 0; k < length; k++) {

            if (tmp[k] > 1) {
                strs[l] = String.valueOf( k );
                l++;
            }
        }

        return strs;
    }

    //判断是否重复
    boolean isDup(int[] arr) {

        if (arr == null) {
            throw new NullPointerException( "空指针" );
        }

        int length = arr.length;
        int[] tmp = new int[length];

        //找到重复数值计数
        for (int i = 0; i < length; i++) {
            int j = arr[i];
            if (j >= length) throw new IllegalArgumentException( "数字范围越界" );
            if (tmp[j] == 0) {
                tmp[j] = 1;
            } else {
                return true;
            }
        }
        return false;
    }


    //swap方式
    boolean isDupData(int[] arr) {

        if (arr == null) {
            throw new NullPointerException( "空指针" );
        }

        int length = arr.length;

        for (int i = 0; i < length; i++) {
            while (arr[i] != i) {
                int num = arr[i];
                if (arr[i] == arr[num]) return true;
                arr[i] = arr[num];
                arr[num] = num;
            }
        }

        return false;
    }

    //二分查找
    //时间优先，效率优先

    //不修改数组找出重复数字 使用辅助空间的方法
    //在一个长度n+1数组里所有商户自都在1~n的范围内。所以数组中至少有一个数字是重复的
    //请找出任意一个重复的数字，但不能修改输入数组

}
