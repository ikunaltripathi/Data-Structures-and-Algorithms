//package Graph;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class DisjointSet {
//   List<Integer> rank, size, par;
//   DisjointSet(int n) {
//       rank = new ArrayList<>();
//       size = new ArrayList<>();
//       par = new ArrayList<>();
//       for (int i=0; i<=n; i++) {
//          rank.add(0);
//          size.add(1);
//          par.add(i);
//       }
//   }
//   int findUparent (int node) {
//      if (par.get(node) == node) {
//         return node;
//      }
//      int num = findUparent(par.get(node));
//      par.set(node, num);
//      return num;
//   }
//
//   void findUnionRank (int x, int y) {
//      int uP1 = findUparent(x);
//      int uP2 = findUparent(y);
//      if (uP1 == uP2) return;
//      if (rank.get(uP1) < rank.get(uP2)) {
//         par.set(uP1, uP2);
//      } else if (rank.get(uP1) > rank.get(uP2)) {
//         par.set(uP2, uP1);
//      } else {
//         par.set(uP2, uP1);
//         int rank1 = rank.get(uP1);
//         rank.set(uP1, rank1 + 1);
//      }
//   }
//   void findUnionSize (int x, int y) {
//         int uP1 = findUparent(x);
//         int uP2 = findUparent(y);
//         if (uP1 == uP2) return;
//         if (size.get(x) < size.get(y)) {
//            par.set(uP1, uP2);
//            size.set(uP2, size.get(uP1) + size.get(uP2));
//         }
//         else {
//            par.set(uP2, uP1);
//            size.set(uP1, size.get(uP1) + size.get(uP2));
//         }
//
//   }
//}
//class Main {
//   public static void main(String[] args) {
//      DisjointSet ds = new DisjointSet(7);
//      ds.findUnionRank(1,2);
//      ds.findUnionRank(2,3);
//      ds.findUnionRank(4,5);
//      ds.findUnionRank(6,7);
//      ds.findUnionRank(5,6);
//      if (ds.findUparent(3) == ds.findUparent(7)) System.out.println("Same");
//      else System.out.println("Not same");
//      ds.findUnionRank(3,7);
//      if (ds.findUparent(3) == ds.findUparent(7)) System.out.println("Same");
//      else System.out.println("Not same");
//   }
//}
