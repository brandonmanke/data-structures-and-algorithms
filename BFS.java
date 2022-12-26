import java.util.LinkedList;
import java.util.Queue;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class BFS {

    Map<Character, Set<Character>> graph = new HashMap<>();
    Set<Character> visited = new HashSet<>();

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) { this.val = val; }
    }

    public static void breadthFirstSearch(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            System.out.print(curr.val + " ");
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
        System.out.println();
    }

    public static void breadthFirstSearch(Map<Character, Set<Character>> graph, char start) {
        Set<Character> visited = new HashSet<>();
        Queue<Character> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            char curr = q.poll();
            if (visited.add(curr)) {
                System.out.println("visited: " + curr);
            }
            for (char c : graph.get(curr)) {
                if (!visited.contains(c)) {
                    q.add(c);
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(10);

        System.out.println("BFS order of BST:");
        breadthFirstSearch(root);

        // build graph
        Map<Character, Set<Character>> g = new HashMap<>();
        Set<Character> sa = new HashSet<>();
        sa.add('b');
        sa.add('d');
        sa.add('f');
        g.put('a', sa);
        Set<Character> sb = new HashSet<>();
        sb.add('a');
        sb.add('d');
        g.put('b', sb);
        Set<Character> sd = new HashSet<>();
        sd.add('c');
        sd.add('a');
        sd.add('b');
        sd.add('f');
        g.put('d', sd);
        Set<Character> sc = new HashSet<>();
        sc.add('e');
        sc.add('d');
        g.put('c', sc);
        Set<Character> se = new HashSet<>();
        se.add('c');
        g.put('e', se);
        Set<Character> sf = new HashSet<>();
        sf.add('a');
        sf.add('d');
        g.put('f', sf);

        breadthFirstSearch(g, 'a');

    }
}