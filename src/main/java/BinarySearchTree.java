import java.util.ArrayList;

public class BinarySearchTree extends BinaryTree {

    public BinarySearchTree() {
    }

    public BinarySearchTree(BinaryTreeNode node) {
        super.setRoot(node);
    }

    public void insert(int element)
    {

    }

    public void removeElement(int element)
    {

    }

    public int findMin()
    {
        return 0;   //TODO
    }

    public int findMax()
    {
        return 0;   //TODO
    }

    public void rebalance()
    {
        ArrayList<Integer> inOrderTraversal = super.inOrder();
        int middleElement = inOrderTraversal.size()/2;
        BinaryTreeNode newRoot = new BinaryTreeNode(middleElement);
        super.setRoot(newRoot);

        boolean reachedMiddle = false;
        for (int i: inOrderTraversal) {
            if (i == middleElement && !reachedMiddle)
            {
                reachedMiddle = true;
                continue;
            }

            insert(i);
        }
    }
}
