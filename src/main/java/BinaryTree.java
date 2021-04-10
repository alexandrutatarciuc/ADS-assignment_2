import java.util.ArrayList;

public abstract class BinaryTree {

    private BinaryTreeNode root;

    public BinaryTree() {
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    public boolean isEmpty()
    {
        return false;    //TODO
    }

    public int size()
    {
        return 0;    //TODO
    }

    public boolean contains(int value)
    {
        return false;    //TODO
    }

    public ArrayList<Integer> inOrder()
    {
        return null;    //TODO
    }

    public ArrayList<Integer> preOrder()
    {
        return null;    //TODO
    }
    public ArrayList<Integer> postOrder()
    {
        return null;    //TODO
    }
    public ArrayList<Integer> levelOrder()
    {
        return null;     //TODO
    }

    public int height()
    {
        return 0;     //TODO
    }

}
