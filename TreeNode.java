public class TreeNode<E extends Comparable<E>> {
    private TreeNode<E> leftNode;
    private E data;                 // node value
    private TreeNode<E> rightNode;


    // konstruktor menginisialisasi data dan menjadikannya simpul daun
    public TreeNode(E nodeData) {
        data = nodeData;
        leftNode = rightNode = null;    // simpul yang tidak memiliki anak
    }

    public E getData() {
        return data;
    }

    public TreeNode<E> getLeftNode() {
        return leftNode;
    }

    public TreeNode<E> getRightNode() {
        return rightNode;
    }


    // temukan titik penyisipan dan masukkan simpul baru; abaikan nilai duplikat
    public void insert(E insertValue) {
        // masukkan di subpohon kiri
        if (insertValue.compareTo(data) < 0) {
            // masukkan TreeNode yang baru
            if (leftNode == null) {
                leftNode = new TreeNode<E>(insertValue);
            } else {
                leftNode.insert(insertValue);   // terus melintasi subpohon kiri secara rekursif
            }
        }
        // masukkan di subpohon kanan
        else if (insertValue.compareTo(data) > 0) {
            // masukkan TreeNode yang baru
            if (rightNode == null) {
                rightNode = new TreeNode<E>(insertValue);
            } else {
                rightNode.insert(insertValue);  // terus melintasi subpohon kanan secara rekursif
            }
        }

        // else if (insertValue.compareTo(data) == 0) {
        //     // masukkan TreeNode yang baru
        //     if (leftNode == null) {
        //         leftNode = new TreeNode<E>(insertValue);
        //     } else {
        //         leftNode.insert(insertValue);   // terus melintasi subpohon kiri secara rekursif
        //     }
        // }

        else {      // Jika nilai node yang akan ditambahkan sama dengan nilai root, kirimkan ke kiri
            // masukkan TreeNode yang baru
            if (leftNode == null) {
                leftNode = new TreeNode<E>(insertValue);
            } else {
                leftNode.insert(insertValue);   // terus melintasi subpohon kiri secara rekursif
            }
        }
    }

    @Override
    public String toString() {
        return "TreeNode [leftNode=" + leftNode + ", data=" + data + ", rightNode=" + rightNode + "]";
    } 
}
