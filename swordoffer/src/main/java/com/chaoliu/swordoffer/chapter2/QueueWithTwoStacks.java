package com.chaoliu.swordoffer.chapter2;


//todo 9、用两个栈来实现队列
// 题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail
// 和deleteHead，分别完成在队列尾部插入结点和在队列头部删除结点的功能。

import java.util.Stack;

public class QueueWithTwoStacks<T> {

    private Stack<T> stackTail = new Stack<T>();
    private Stack<T> stackHead = new Stack<T>();

    public void appendTail(T item) {
        stackTail.push( item );
    }

    public T deleteHead() throws Exception {

        if (stackHead.size() == 0) {
            while (stackTail.size() > 0) {
                T item = stackTail.pop();
                stackHead.push( item );
            }
        }

        if (stackHead.size() == 0) {
            throw new Exception( "queue is empty" );
        }

        T item = stackHead.pop();
        return item;
    }

}
