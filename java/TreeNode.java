public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

class TreeService {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}

class Service {
    public static void main(String[] args) {

        TreeNode newnode = new TreeNode(10);
        newnode.right = new TreeNode(25);
        newnode.left = new TreeNode(23);

        System.out.println("Root -> " + newnode.val + " Left -> " + newnode.left.val + " Right " + newnode.right.val);

        TreeService ts = new TreeService();

        ts.invertTree(newnode);
        System.out.println("Root -> " + newnode.val + " Left -> " + newnode.left.val + " Right " + newnode.right.val);

    }
}