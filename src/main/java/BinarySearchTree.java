
import java.util.ArrayList;

public class BinarySearchTree extends BinaryTree {

    public BinarySearchTree() {
    }

    public BinarySearchTree(BinaryTreeNode node) {
        super.setRoot(node);
    }

    public void insert(int element) {

        BinaryTreeNode tmpNode = null;

        if (super.getRoot() == null) {
            super.setRoot(new BinaryTreeNode(element, null, null));
        }

        if (!super.contains(element)) {
            tmpNode = super.getRoot();
            while (true) {
                if (tmpNode.getElement() <= element) {
                    if (tmpNode.getRightChild() != null) {
                        tmpNode = tmpNode.getRightChild();
                    } else {
                        tmpNode.addRightChild(new BinaryTreeNode(element));
                        break;
                    }
                } else {
                    if (tmpNode.getLeftChild() != null) {
                        tmpNode = tmpNode.getLeftChild();
                    } else {
                        tmpNode.addLeftChild(new BinaryTreeNode(element));
                        break;
                    }

                }
            }

        }

    }

    public void removeElement(int element) {
        BinaryTreeNode tmpNode = null;
        BinaryTreeNode foundNode = null;
        BinaryTreeNode parentNode = null;

        if (super.contains(element)) {

            tmpNode = super.getRoot();
            foundNode = Search(tmpNode, element); // this need to return the parent of the element that needs to be deleted
            parentNode = Parent(tmpNode, element);

            // check if the element has kids

            //case 1

            if (foundNode.getLeftChild() == null && foundNode.getRightChild() == null) {
                removeNodeWithNoKids(foundNode, parentNode);
            } else if (foundNode.getLeftChild() == null || foundNode.getRightChild() == null) {
                //case 2
                removeNodeWith1Kid(foundNode, parentNode);
            }

            //case 3

            else {

                ArrayList<Integer> tempArray = super.inOrder();
                int i = tempArray.indexOf(foundNode.getElement());
                BinaryTreeNode replacementNode = Search(super.getRoot(), tempArray.get(i + 1));
                BinaryTreeNode replacementParent = Parent(super.getRoot(), tempArray.get(i + 1));
                removeNodeWith1Kid(replacementNode, replacementParent);
                removeNodeWithNoKids(replacementNode, replacementParent);
                foundNode.setElement(replacementNode.getElement());
            }

        }

    }

    private void removeNodeWithNoKids(BinaryTreeNode foundNode, BinaryTreeNode parentNode) {
        if (foundNode.getLeftChild() == null && foundNode.getRightChild() == null) {
            if (foundNode.getElement() < parentNode.getElement()) {
                parentNode.addLeftChild(null);
            } else {
                parentNode.addRightChild(null);
            }
        }
    }

    private void removeNodeWith1Kid(BinaryTreeNode foundNode, BinaryTreeNode parentNode) {
        if (foundNode.getLeftChild() != null) {
            if (foundNode.getElement() < parentNode.getElement()) {
                parentNode.addLeftChild(foundNode.getLeftChild());
            } else {
                parentNode.addRightChild(foundNode.getLeftChild());
            }

        } else if (foundNode.getRightChild() != null) {
            if (foundNode.getElement() < parentNode.getElement()) {
                parentNode.addLeftChild(foundNode.getRightChild());
            } else {
                parentNode.addRightChild(foundNode.getRightChild());
            }
        }
    }

    public int findMin() {
        BinaryTreeNode tmpNode = null;

        if (super.getRoot() != null) {
            tmpNode = super.getRoot();
            while (tmpNode.getLeftChild() != null) {
                tmpNode = tmpNode.getLeftChild();

            }

        }
        return tmpNode.getElement();
    }

    public int findMax() {
        BinaryTreeNode tmpNode = null;
        if (super.getRoot() != null) {


            tmpNode = super.getRoot();

            while (tmpNode.getRightChild() != null) {
                tmpNode = tmpNode.getRightChild();

            }

        }
        return tmpNode.getElement();
    }

    public void rebalance() {
        ArrayList<Integer> inOrderTraversal = super.inOrder();
        int currentMiddleIndex = getMiddleIndexInOrder(inOrderTraversal);
        BinaryTreeNode newRoot = new BinaryTreeNode(inOrderTraversal.get(currentMiddleIndex));
        super.setRoot(newRoot);
        addChildrenRecursive(inOrderTraversal);
    }


    private int getMiddleIndexInOrder(ArrayList<Integer> inOrder) {
        int middleIndex = inOrder.size() / 2;
        return middleIndex;
    }

    private void addChildrenRecursive(ArrayList<Integer> list)
    {
        int middleIndex = getMiddleIndexInOrder(list);
        int lowerIndex = 0;
        int upperIndex = list.size();

        ArrayList<Integer> lowerList;
        ArrayList<Integer> upperList;

        if (list.size() > 2)
        {
            lowerList = new ArrayList<Integer>(list.subList(lowerIndex, middleIndex));
            upperList = new ArrayList<Integer>(list.subList(++middleIndex, upperIndex));
            int leftChild = lowerList.get(getMiddleIndexInOrder(lowerList));
            int rightChild = upperList.get(getMiddleIndexInOrder(upperList));

            insert(leftChild);
            insert(rightChild);

            addChildrenRecursive(lowerList);
            addChildrenRecursive(upperList);
        }
        else
        {
            insert(list.get(0));
        }
    }

    private BinaryTreeNode Search(BinaryTreeNode node, int element) {
        if (node == null || node.getElement() == element) {
            return node;
        }
        if (node.getElement() < element) {
            return Search(node.getRightChild(), element);
        }
        return Search(node.getLeftChild(), element);
    }

    private BinaryTreeNode Parent(BinaryTreeNode node, int element) {
        if(node == null)
            return null;
        if (node.getLeftChild() != null) {
            if(node.getLeftChild().getElement() == element)
                return node;
        }
        if(node.getRightChild() != null) {
            if(node.getRightChild().getElement() == element)
                return node;
        }
        BinaryTreeNode temp = Parent(node.getLeftChild(), element);
        if (temp != null) {
            return temp;
        }
        temp = Parent(node.getRightChild(), element);
        return temp;
    }

}
