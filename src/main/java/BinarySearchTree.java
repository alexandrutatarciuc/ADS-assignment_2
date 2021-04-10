
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

    int currentMiddleIndex = getMiddleIndexInOrder(inOrderTraversal);

    BinaryTreeNode newRoot = new BinaryTreeNode(inOrderTraversal.get(currentMiddleIndex));

    newRoot = addChildrenRecursive(inOrderTraversal, newRoot);

    super.setRoot(newRoot);
  }


  private int getMiddleIndexInOrder(ArrayList<Integer> inOrder)
  {
    int middleIndex = inOrder.size()/2;
    return middleIndex;
  }

  private BinaryTreeNode addChildrenRecursive(ArrayList<Integer> list, BinaryTreeNode node)
  {
    int middleIndex = getMiddleIndexInOrder(list);
    int lowerIndex = 0;
    int upperIndex = list.size();

    ArrayList<Integer> lowerList;
    ArrayList<Integer> upperList;
    if (list.size() == 2)
    {
      node.addLeftChild(new BinaryTreeNode(list.get(lowerIndex)));
    }
    else if (list.size() == 3)
    {
      BinaryTreeNode leftChild = new BinaryTreeNode(list.get(lowerIndex));
      BinaryTreeNode rightChild = new BinaryTreeNode(list.get(upperIndex));

      node.addLeftChild(leftChild);
      node.addRightChild(rightChild);
    }
    else
    {
      lowerList = new ArrayList<Integer>(list.subList(lowerIndex, middleIndex));
      upperList = new ArrayList<Integer>(list.subList(++middleIndex, upperIndex));

      System.out.println(lowerList.get(getMiddleIndexInOrder(lowerList)));
      System.out.println(upperList.get(getMiddleIndexInOrder(upperList)));
      BinaryTreeNode leftChild = new BinaryTreeNode(lowerList.get(getMiddleIndexInOrder(lowerList)));
      BinaryTreeNode rightChild = new BinaryTreeNode(upperList.get(getMiddleIndexInOrder(upperList)));

      node.addLeftChild(addChildrenRecursive(lowerList, leftChild));
      node.addRightChild(addChildrenRecursive(upperList, rightChild));
    }

    return node;
  }

}
