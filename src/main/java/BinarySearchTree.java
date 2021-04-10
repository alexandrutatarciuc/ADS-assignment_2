
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
