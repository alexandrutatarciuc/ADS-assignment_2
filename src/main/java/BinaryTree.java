
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    private BinaryTreeNode root;

    public BinaryTree() {

    }

    public BinaryTreeNode getRoot() {
        return this.root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    public boolean isEmpty()
    {
        if(root == null){
            return true;
        } else return false;
    }

    public int size()
    {
        return size(root);
    }

    //HOPEFULLY THIS IS ALLOWED :)
    private int size(BinaryTreeNode node){
        if(node == null) return 0;
        else{
            return (size(node.getLeftChild()) + 1 + size(node.getRightChild()));
        }
    }

    public boolean contains(int value)
    {
        BinaryTreeNode currentNode = root;
        if(currentNode.getElement() == value || currentNode.getLeftChild().getElement() == value || currentNode.getRightChild().getElement() == value)
            return true;
        else{
            while (currentNode.getElement() != value){
                if (currentNode.getElement() < value && currentNode.getRightChild() != null){
                    currentNode = currentNode.getRightChild();
                }

                if (currentNode.getElement() > value && currentNode.getLeftChild() != null){
                    currentNode = currentNode.getLeftChild();
                }

                if (currentNode.getRightChild() != null && currentNode.getRightChild().getElement() == value){
                    return true;
                }

                if (currentNode.getLeftChild() != null && currentNode.getLeftChild().getElement() == value){
                    return true;
                }

                if (currentNode.getElement() != value && currentNode.getRightChild() == null && currentNode.getLeftChild() == null){
                    return false;
                }
            }
            return true;
        }
    }

    //IN-ORDER

    public ArrayList<Integer> inOrder()
    {
        //left-node-right
        BinaryTreeNode currentNode = root;
        if (isEmpty()) {
            return null;
        }
        return inOrder(currentNode, new ArrayList<>());
    }

    private ArrayList<Integer> inOrder(BinaryTreeNode node, ArrayList<Integer> res){
        if (node == null){
            return null;
        }
        inOrder(node.getLeftChild(), res);
        res.add(node.getElement());
        inOrder(node.getRightChild(), res);
        return res;
    }


    // PRE-ORDER

    public ArrayList<Integer> preOrder()
    {
        BinaryTreeNode currentNode = root;
        //node-left-right
        if (isEmpty()) {
            return null;
        } else {
            return preOrder(currentNode, new ArrayList<>());
        }
    }

    private ArrayList<Integer> preOrder(BinaryTreeNode node, ArrayList<Integer> res){
        if (node == null){
            return null;
        }
        res.add(node.getElement());
        preOrder(node.getLeftChild(), res);
        preOrder(node.getRightChild(), res);

        return res;
    }

    //POST-ORDER

    public ArrayList<Integer> postOrder()
    {
        BinaryTreeNode currentNode = root;
        //left-right-node TODO
        if (isEmpty()) {
            return null;
        } else {
            return postOrder(currentNode, new ArrayList<>());
        }
    }

    private ArrayList<Integer> postOrder(BinaryTreeNode node, ArrayList<Integer> res){
        if (node == null){
            return null;
        }
        postOrder(node.getLeftChild(), res);
        postOrder(node.getRightChild(), res);
        res.add(node.getElement());

        return res;
    }

    // LEVEL-ORDER

    public ArrayList<Integer> levelOrder()
    {
        ArrayList<Integer> toReturn = new ArrayList<Integer>();
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        BinaryTreeNode currentNode = root;

        if (isEmpty()) {
            return null;
        }
        //TODO
        queue.add(root);

        while(!queue.isEmpty()){
            currentNode = queue.remove();
            if (currentNode.getLeftChild() != null)
                queue.add(currentNode.getLeftChild());
            if (currentNode.getRightChild() != null)
                queue.add(currentNode.getRightChild());
            toReturn.add(currentNode.getElement());
        }
        return toReturn;
    }

    //HEIGHT

    public int height()
    {
        BinaryTreeNode currentNode = root;
        if (isEmpty()) {
            return -1;
        }

        Integer max = 0;
        height(max, 0, currentNode);

        return max;
    }

    private void height(Integer max, int height, BinaryTreeNode node){
        if (node != null){
            if (height > max){
                max = height;
            }
            height(max, height + 1, node.getLeftChild());
            height(max, height + 1, node.getRightChild());
        }
    }

}
