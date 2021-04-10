
import java.util.ArrayList;

public class BinarySearchTree extends BinaryTree {

    public BinarySearchTree() {
    }

    public BinarySearchTree(BinaryTreeNode node) {
        super.setRoot(node);
    }
    
  public void insert(int element)
  {

    BinaryTreeNode tmpNode = null;

    if (super.getRoot() == null)
    {
      super.setRoot(new BinaryTreeNode(element, null, null));
    }

    if (!super.contains(element))
    {
      tmpNode = super.getRoot();
      while (true)
      {
        if (tmpNode.getElement() <= element)
        {
          if (tmpNode.getRightChild() != null)
          {
            tmpNode = tmpNode.getRightChild();
          }
          else
          {
            tmpNode.addRightChild(new BinaryTreeNode(element));
            break;
          }
        }

        else
        {
          if (tmpNode.getLeftChild() != null)
          {
            tmpNode = tmpNode.getLeftChild();
          }
          else
          {
            tmpNode.addLeftChild(new BinaryTreeNode(element));
            break;
          }

        }
      }

    }

  }

  public void removeElement(int element)
  {

    if (super.contains(element))
    {

        

    }

  }

  public int findMin()
  {
    BinaryTreeNode tmpNode = null;

    if (super.getRoot() != null)
    {
      tmpNode = super.getRoot();
      while (tmpNode.getLeftChild() != null)
      {
        tmpNode = tmpNode.getLeftChild();

      }

    }
    return tmpNode.getElement();
  }

  public int findMax()
  {
    BinaryTreeNode tmpNode = null;
    if (super.getRoot() != null)
    {


      tmpNode = super.getRoot();

      while (tmpNode.getRightChild() != null)
      {
        tmpNode = tmpNode.getRightChild();

      }

    }
    return tmpNode.getElement();
  }

  public void rebalance() {
    ArrayList<Integer> tree = inOrder();
    setRoot(null);
    int min = 0;
    int max = tree.size() - 1;
    rebalance(tree, min, max);
  }

  private void rebalance(ArrayList<Integer> tree, int min, int max) {
    if (max >= min) {
      int mid = min + (max - min) / 2;
      insert(tree.get(mid));
      rebalance(tree, min, mid - 1);
      rebalance(tree, mid + 1, max);
    }
  }

}
