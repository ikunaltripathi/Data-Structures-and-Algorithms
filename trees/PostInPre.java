package trees;

public class PostInPre {
}

/*
class Pair {
    TreeNode t1;
    int num;
    Pair(TreeNode temp, int x) {
        t1= temp;
        num = x;
    }
}
func (TreeNode root) {
    Stack<Pair> st = new Stack<>();
    st.push(new Pair(root,1));
    List<Integer> pre = new ArrayList<>();
    List<Integer> in = new ArrayList<>();
    List<Integer> post = new ArrayList<>();
    while (!st.isEmpty()) {
        Pair  p = st.pop();
        if (p.num == 1) {
            pre.add(p.t1.val);
            st.push(new Pair(p.t1, p.num+1));
            if (p.t1.left != null) st.push(new Pair(p.t1.left, 1));
        }
        else if (p.num == 2){
            in.add(p.t1.val);
            st.push(new Pair(p.t1, p.num+1));
            if (p.t1.right != null) st.push(new Pair(p.t1.right, 1));
        }
        else {
            post.add(p.t1.val);
        }f
    }
}
*/
