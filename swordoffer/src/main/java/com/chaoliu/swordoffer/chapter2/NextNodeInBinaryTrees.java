package com.chaoliu.swordoffer.chapter2;

//todo 8、 二叉树的下一个节点
// 面试题8：二叉树的下一个结点
// 题目：给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点
// 树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。

// @author chentong
public class NextNodeInBinaryTrees {

    //中序遍历下一个节点
    static TreeNode getNext(TreeNode node){

        //中序遍历 下一个右节点不为空
        if (node.right!=null){
            TreeNode tmpNode = node.right;

            //左节点不为空 一直遍历到最左节点为空，为下一个节点
            if (tmpNode.left!=null){
                while (tmpNode.left!=null){
                    tmpNode = tmpNode.left;
                }
                return tmpNode;
            }

            //左节点为空，那么当前节点为下一个节点
            return node.right;
        }else{ //为空 返回父节点
            return node.parent;
        }
    }



    private static class TreeNode{
        int value;
        TreeNode parent;
        TreeNode left;
        TreeNode right;
    }




}
