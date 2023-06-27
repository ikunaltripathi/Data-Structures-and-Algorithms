package trees;
import java.util.*;
    class BstIterator {
        Stack<TreeNode> s = new Stack<>();
        BstIterator(TreeNode root) {
            updateStack(root);
        }

        public boolean hasNext() {
            return !s.isEmpty();
        }

        public TreeNode next() {
            TreeNode temp = s.pop();
            updateStack(temp.right);
            return temp;
        }
        public int see() {
            if (!s.isEmpty()) return s.peek().val;
            return -1;
        }

        public void updateStack(TreeNode root) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
        }
    }

    public class RecoverBST {
        public static void recoverTree(TreeNode root) {
            BstIterator l = new BstIterator(root);
            TreeNode i = l.next();
            TreeNode j = null;
            while (l.hasNext()) {
                if (i.val > l.see()) {
                    if (j != null) {
                        if (j.val < l.see() || l.see() == -1) {
                            int temp = j.val;
                            j.val = i.val;
                            i.val = temp;
                            break;
                        }
                    } else j = i;
                }
                i = l.next();
            }
        }

        public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            TreeNode left = new TreeNode(3);
            root.left = left;
            TreeNode s = new TreeNode(2);
            root.left.right = s;
            recoverTree(root);
            System.out.println(inorderTraversal(root));
        }

        public static List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> al = new ArrayList<>();
         if (root == null) return al;
         al.addAll(inorderTraversal(root.left));
         al.add(root.val);
         al.addAll(inorderTraversal(root.right));
         return al;
     }
}
