public class BinaryTreeNode {

    private int value;
    private BinaryTreeNode leftNode;
    private BinaryTreeNode rightNode;

    public BinaryTreeNode(int value) {
        this.value = value;
        leftNode = null;
        rightNode = null;
    }

    public BinaryTreeNode(int value, BinaryTreeNode leftNode, BinaryTreeNode rightNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public void setElement(int element)
    {

    }
    public int getElement()
    {
        return value;
    }

    public void addLeftChild(BinaryTreeNode node)
    {

    }

    public void addRightChild(BinaryTreeNode node)
    {

    }

    public BinaryTreeNode getLeftChild()
    {
        return leftNode;
    }

    public BinaryTreeNode getRightChild()
    {
        return rightNode;
    }

}
