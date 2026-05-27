import java.util.LinkedList;
import java.util.Queue;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자료구조및실습
 * @version 2024년도 2학기
 * @author 김상진
 * @file BinaryTree.java
 * 이진 트리: 일반 이진 트리
 * 학번:	2021136025	이름: 김영민
 */
@SuppressWarnings("unused")
public class BinaryTree {
    private static class TreeNode {
        private int v = -1;
        private TreeNode left = null;
        private TreeNode right = null;
        public TreeNode(int v) {
            this.v = v;
        }
    }

    private TreeNode root = null;
    private int numNodes = 0;

    public BinaryTree() {}
    public BinaryTree(String tree) {
        String[] values = tree.split("\\,");
        root = stringToBinaryTree(values, 0);
    }

    private TreeNode stringToBinaryTree(String[] values, int idx) {
        if(idx >= values.length) return null;
        if(values[idx].equals("null")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(values[idx]));
        ++numNodes;
        int left = 2 * idx + 1;
        int right = left + 1;
        node.left = stringToBinaryTree(values, left);
        node.right = stringToBinaryTree(values, right);
        return node;
    }

    public int size() {
        return numNodes;
    }

    // 1) (재귀적 구현) 주어진 이진 트리가 대칭적이면 true를 반환하고, 아니면 false를 반환함
    public boolean isSymmetric() {

        return false;
    }
    private boolean symmetric(){

        return false;
    }

    // 2) (비재귀적 구현) 모든 단말 노드의 합을 반환함
    public int sumOfLeaves() {
        int result = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr.left == null && curr.right == null) result += curr.v;
            else{
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
        return result;
    }
}