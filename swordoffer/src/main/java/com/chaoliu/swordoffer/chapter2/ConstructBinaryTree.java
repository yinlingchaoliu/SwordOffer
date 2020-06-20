package com.chaoliu.swordoffer.chapter2;

import java.util.Arrays;

// todo 7、重建二叉树
// author chentong
// 输入前序遍历 {1,2,4,7,3,5,6,8}
// 输入中序遍历 {4,7,2,1,5,3,8,6}
// 重建节点
// Arrays.copyOfRange( arr, from, to) from 游标开始 to 游标结束
public class ConstructBinaryTree {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0 || inorder.length == 0) return null;

        //根节点
        TreeNode root = new TreeNode( preorder[0], null, null );
        int length = preorder.length;

        //从中序寻找根节点
        int pos = 0;
        for (; pos < length; pos++) {
            if (inorder[pos] == preorder[0]) {
                break;
            }
        }

        //创建左子树
        if (pos > 0) {
            int[] leftPreorder = Arrays.copyOfRange( preorder, 1, pos+1 );
            int[] leftInorder = Arrays.copyOfRange( inorder, 0, pos );
            System.out.println( "left-pre" + Arrays.toString( leftPreorder ) );
            System.out.println( "left-in" + Arrays.toString( leftInorder ) );
            root.left = buildTree( leftPreorder, leftInorder );
        } else {
            root.left = null;
        }


        //创建右子树
        if (length - pos - 1 > 0) {
            int[] rightPreorder = Arrays.copyOfRange( preorder, 1 + pos, length );
            int[] rightInorder = Arrays.copyOfRange( inorder, 1 + pos, length);
            System.out.println( "right-pre" + Arrays.toString( rightPreorder ) );
            System.out.println( "right-in" + Arrays.toString( rightInorder ) );

            root.right = buildTree( rightPreorder, rightInorder );
        } else {
            root.right = null;
        }

        return root;
    }

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    static void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.print( root.value );
        preOrder( root.left );
        preOrder( root.right );
    }

    static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder( root.left );
        System.out.print( root.value );
        inOrder( root.right );
    }


    static void aftOrder(TreeNode root) {
        if (root == null) return;
        aftOrder( root.left );
        aftOrder( root.right );
        System.out.print( root.value );
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};

        TreeNode root = buildTree( preorder, inorder );

        //前序遍历
        preOrder( root );
        System.out.println();

        //中序遍历
        inOrder( root );
        System.out.println();

        //后续遍历
        aftOrder( root );
    }

}