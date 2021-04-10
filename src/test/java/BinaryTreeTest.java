import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {
    private BinaryTree tree;
    private BinaryTreePrint print = new BinaryTreePrint();

    @BeforeEach
    void setup() {
        tree = new BinaryTree();
    }

    @AfterEach
    void tearDown() {
        tree = null;
    }

    private void buildTreeSmall() {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        tree.setRoot(node1);
        node1.addLeftChild(node2);
        node1.addRightChild(node3);
        node2.addLeftChild(node4);
        node3.addRightChild(node5);
        print.printTree(tree.getRoot());
    }

    private void buildTreeBig() {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node9 = new BinaryTreeNode(9);
        BinaryTreeNode node10 = new BinaryTreeNode(10);
        tree.setRoot(node1);
        node1.addLeftChild(node2);
        node1.addRightChild(node3);
        node2.addLeftChild(node4);
        node2.addRightChild(node6);
        node3.addLeftChild(node5);
        node3.addRightChild(node7);
        node7.addLeftChild(node8);
        node7.addRightChild(node9);
        node8.addRightChild(node10);
        print.printTree(tree.getRoot());
    }

    @Test
    void testRoot() {
        BinaryTreeNode rootNode = new BinaryTreeNode(5);
        tree.setRoot(rootNode);
        assertEquals(rootNode, tree.getRoot());
    }

    @Test
    void testEmpty() {
        assertNull(tree.getRoot());
    }

    @Test
    void testSizeSmall() {
        buildTreeSmall();
        assertEquals(5, tree.size());
    }

    @Test
    void testSizeBig() {
        buildTreeBig();
        assertEquals(10, tree.size());
    }

    @Test
    void testContains() {
        buildTreeSmall();
        assertTrue(tree.contains(3));
    }

    @Test
    void testNotContains() {
        buildTreeSmall();
        assertFalse(tree.contains(6));
    }

    @Test
    void testEmptyInOrder() {
        assertNull(tree.inOrder());
    }

    @Test
    void testEmptyPreOrder() {
        assertNull(tree.preOrder());
    }

    @Test
    void testEmptyPostOrder() {
        assertNull(tree.postOrder());
    }

    @Test
    void testEmptyLevelOrder() {
        assertNull(tree.levelOrder());
    }

    @Test
    void testInOrder() {
        buildTreeBig();
        ArrayList<Integer> test = new ArrayList<>();
        test.add(4);
        test.add(2);
        test.add(6);
        test.add(1);
        test.add(5);
        test.add(3);
        test.add(8);
        test.add(10);
        test.add(7);
        test.add(9);
        assertArrayEquals(test.toArray(), tree.inOrder().toArray());
    }

    @Test
    void testPreOrder() {
        buildTreeBig();
        ArrayList<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(4);
        test.add(6);
        test.add(3);
        test.add(5);
        test.add(7);
        test.add(8);
        test.add(10);
        test.add(9);
        assertArrayEquals(test.toArray(), tree.preOrder().toArray());
    }

    @Test
    void testPostOrder() {
        buildTreeBig();
        ArrayList<Integer> test = new ArrayList<>();
/*        test.add(4);
        test.add(6);
        test.add(2);
        test.add(10);
        test.add(8);
        test.add(9);
        test.add(5); // or 7
        test.add(7); // or 5
        test.add(3);
        test.add(1);*/
        test.add(4);
        test.add(6);
        test.add(2);
        test.add(5);
        test.add(10);
        test.add(8);
        test.add(9);
        test.add(7);
        test.add(3);
        test.add(1);
        assertArrayEquals(test.toArray(), tree.postOrder().toArray());
    }

    @Test
    void testLevelOrder() {
        buildTreeBig();
        ArrayList<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(6);
        test.add(5);
        test.add(7);
        test.add(8);
        test.add(9);
        test.add(10);
        assertArrayEquals(test.toArray(), tree.levelOrder().toArray());
    }

    @Test
    void testHeightSmall() {
        buildTreeSmall();
        assertEquals(2, tree.height());
    }

    @Test
    void testHeightBig() {
        buildTreeBig();
        assertEquals(4, tree.height());
    }
}
