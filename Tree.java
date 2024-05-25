public class Tree<E extends Comparable<E>> {
    private TreeNode<E> root;


    // konstruktor menginisialisasi pohon bilangan bulat kosong
    public Tree() {
        root = null;
    }


    // masukkan node baru ke dalam pohon pencarian biner
    public void insertNode(E insertValue) {
        System.out.print(insertValue + " ");      // additional method
        if (root == null) {
            root = new TreeNode<E>(insertValue);    // membuat root node
            // System.out.print(insertValue + " ");      // metode ilave | jika dimasukkan ke dalam pernyataan if ini hanya akan mencetak elemen pertama yang dimasukkan
        } else {
            root.insert(insertValue);
            // System.out.print(insertValue + " ");
        }
    }

    // =================================================================================================

    // metode rekursif untuk melakukan traversal preorder
    private void preorderHelper(TreeNode<E> node) {
        if (node == null) {
            return;     // keluar dari metode ini
        }

        System.out.printf("%s ", node.getData());   // output node data
        preorderHelper(node.getLeftNode());     // traverse left subtree
        preorderHelper(node.getRightNode());    // traverse right subtree
    }

    // memulai preorder traversal
    public void preorderTraversal() {
        preorderHelper(root);
    }

    // =================================================================================================

    // metode rekursif untuk melakukan inorder traversal
    private void inorderHelper(TreeNode<E> node) {
        if (node == null) {
            return;
        }

        inorderHelper(node.getLeftNode());      // melintasi subtree kiri
        System.out.printf("%s ", node.getData());       // output node data
        inorderHelper(node.getRightNode());     // melintasi subtree kanan
    }

    // memulai inorder traversal
    public void inorderTraversal() {
        inorderHelper(root);
    }

    // =================================================================================================
   
    // metode rekursif untuk melakukan traversal postorder
    private void postorderHelper(TreeNode<E> node) {
        if (node == null) {
            return;
        }

        postorderHelper(node.getLeftNode());    // melintasi subtree kiri
        postorderHelper(node.getRightNode());   // melintasi subtree kanan
        System.out.printf("%s ", node.getData());       // output node data
    }

    // memulai postorder traversal
    public void postorderTraversal() {
        postorderHelper(root);
    }

    // =================================================================================================

    private boolean searchBSTHelper(TreeNode<E> node, E key) {
        boolean result = false;

        if (node != null) {
            if (key.equals(node.getData())) {
                result = true;
            } else if (key.compareTo(node.getData()) < 0) {
                result = searchBSTHelper(node.getLeftNode(), key);
            } else {
                result = searchBSTHelper(node.getRightNode(), key);
            }
        }
        return result;
    }

    public void searchBST(E key) {
        boolean hasil = searchBSTHelper(root, key);

        if (hasil) {
            System.out.println("Data " + key + " ditemukan pada tree");
        } else {
            System.out.println("Data "+ key + " tidak ditemukan pada tree");
        }
    }
}
