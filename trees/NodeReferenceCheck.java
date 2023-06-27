package trees;


import java.util.ArrayList;
import java.util.List;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {
     }
     TreeNode(int val) {
         this.val = val;
     }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

//public class NodeReferenceCheck {
//    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        helper (root, 2);
//        while (root.left != null) {
//            System.out.println(root.left.val);
//            root = root.left;
//        }
//    }
//    public static void helper (TreeNode root, int num) {
//        if (num == 0) return;
//        root.left = new TreeNode(7);
//        helper (root.left, num-1);
//    }
//}


public class NodeReferenceCheck {
        static int index = 0;
    public static void main(String[] args) {
        int[] preorder = {1,3};
        TreeNode x = bstFromPreorder(preorder);
        System.out.println(inorderTraversal(x));
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> al = new ArrayList<>();
         if (root == null) return al;
         al.addAll(inorderTraversal(root.left));
         al.add(root.val);
         al.addAll(inorderTraversal(root.right));
         return al;
     }
    public static TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode();
        helper(root, preorder, Integer.MAX_VALUE);
        return root.left;
    }
    public static  void helper (TreeNode root, int[] preorder, int upperBound) {
        if (index == preorder.length) return;
        if (preorder[index] < upperBound) {
            TreeNode temp = new TreeNode(preorder[index]);
            root.left = temp;
            index++;
            helper(root.left, preorder, temp.val);
        }
        if (preorder[index]<upperBound) {
            TreeNode temp = new TreeNode(preorder[index]);
            root.right = temp;
            index++;
            helper (root.right, preorder, upperBound);
        }
    }
}
