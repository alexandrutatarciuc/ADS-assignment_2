
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
