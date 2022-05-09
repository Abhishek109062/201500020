class BiTree {
    class Node {
        String data;
        Node right, left;

        public Node(String data) {
            this.data = data;
        }
    }

    Node root;

    public BiTree() {
        root = null;
    }

    public void insert(String data) {
        root = insertnode(root, data);
    }

    public Node insertnode(Node root, String data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data.compareTo(root.data)<0)
            root.left = insertnode(root.left, data);
        else
            root.right = insertnode(root.right, data);

        return root;
    }

    public void inorder() {
        inorder(root);
    }

    public void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    public static void main(String[] args) {
        BiTree obj = new BiTree();
        obj.insert("Abhishek");
        obj.insert("Rahul");
        obj.insert("Abhinav");
        obj.insert("Satyam");
        obj.insert("Neeraj");
        obj.insert("Shreya");
        obj.inorder();
    }
}