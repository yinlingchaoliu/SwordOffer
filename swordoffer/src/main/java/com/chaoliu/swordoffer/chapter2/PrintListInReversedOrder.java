package com.chaoliu.swordoffer.chapter2;


import java.util.Stack;

//
// todo 6、从未到头打印链表
//
//
public class PrintListInReversedOrder {


    //不修改链表结构
    //stack
    static void printReversedLinkNode(Node head){


        if (head == null) return;

        Stack<Node> stack = new Stack<>();


        Node node = head;

        while (node!=null){
            stack.push( node );
            node = node.next;
        }

        while(!stack.empty()){
            System.out.println(stack.pop().key);
        }

    }

    static class Node {
        int key;
        Node next;
        public Node(int key,Node next){
            this.key = key;
            this.next = next;
        }
    }


    //2、修改链表的方式翻转

    public static void main(String[] args){
        Node node3 = new Node(3,null);
        Node node2 = new Node(2,node3);
        Node node1 = new Node(1,node2);

        printReversedLinkNode(node1);

    }

}
