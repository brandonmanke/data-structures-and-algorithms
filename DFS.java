import java.util.Stack;

// Recursive vs. Iterative
// Call Stack -> Stack Data Structure
class DFS {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) { this.val = val; }
    }

    // Print inorder traversal [recursive]
    static void inorderR(TreeNode root) {
        if (root == null) return;
        inorderR(root.left);
        System.out.print(root.val + " "); // add to list etc.
        inorderR(root.right);
    }

    static void inorder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> s = new Stack<>();

        TreeNode curr = root;
        while (curr != null || !s.isEmpty()) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }

            curr = s.pop();
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
        System.out.println();
    }

    // Print preorder traversal [recursive]
    static void preorderR(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " "); // add to list etc.
        preorderR(root.left);
        preorderR(root.right);
    }

    static void preorder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> s = new Stack<>();

        TreeNode curr = root;
        while (curr != null || !s.isEmpty()) {
            while (curr != null) {
                System.out.print(curr.val + " ");
                s.push(curr);
                curr = curr.left;
            }

            curr = s.pop();
            curr = curr.right;
        }
        System.out.println();
    }

    // Print postorder traversal [recursive]
    static void postorderR(TreeNode root) {
        if (root == null) return;
        postorderR(root.left);
        postorderR(root.right);
        System.out.print(root.val + " "); // add to list etc.
    }

    static void postorder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> s = new Stack<>();

        TreeNode curr = root;
        while (curr != null || !s.isEmpty()) {
            while (curr != null) { // left
                s.push(curr);
                curr = curr.left;
            }

            curr = s.pop();
            System.out.print(curr.val + " "); // prints left & right

            while (!s.isEmpty() && curr == s.peek().right) {
                curr = s.pop();
                System.out.print(curr.val + " "); // prints root
            }
            
            if (s.isEmpty()) {
                curr = null;
            } else {
                curr = s.peek().right;
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(10);

        System.out.println("inorder (L,Root,R) (recursive then iterative):");
        inorderR(root);
        System.out.println();
        inorder(root);

        System.out.println("preorder (Root,L,R) (recursive then iterative):");
        preorderR(root);
        System.out.println();
        preorder(root);

        System.out.println("postorder (L,R,Root) (recursive then iterative):");
        postorderR(root);
        System.out.println();
        postorder(root); // definitely most complicated, can also reverse pre order
    }
}