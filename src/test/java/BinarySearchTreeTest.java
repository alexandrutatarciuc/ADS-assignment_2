import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTreeTest {
    private BinarySearchTree tree;
    private BinaryTreePrint print = new BinaryTreePrint();

    @BeforeEach
    void setup() {
        tree = new BinarySearchTree();
    }

    @AfterEach
    void tearDown() {
        tree = null;
    }

    private void buildTreeSmall() {
        tree.insert(4);
        tree.insert(6);
        tree.insert(2);
        tree.insert(7);
        tree.insert(10);
        print.printTree(tree.getRoot());
    }

    private void buildTreeBig() {
        tree.insert(4);
        tree.insert(6);
        tree.insert(2);
        tree.insert(7);
        tree.insert(10);
        tree.insert(8);
        tree.insert(9);
        tree.insert(3);
        tree.insert(5);
        tree.insert(1);
        print.printTree(tree.getRoot());
    }

    @Test
    void addFirstNode() {
        tree.insert(5);
        assertEquals(5, tree.getRoot().getElement());
    }

    @Test
    void insertNoDuplicates() {
        buildTreeSmall();
        assertEquals(5, tree.size());
    }

    @Test
    void insertNDuplicates() {
        buildTreeSmall();
        buildTreeSmall();
        assertEquals(5, tree.size());
    }

    @Test
    void removeExisting() {
        buildTreeSmall();
        tree.removeElement(2);
        assertEquals(4, tree.size());
    }

    @Test
    void removeNonExisting() {
        buildTreeSmall();
        tree.removeElement(420);
        assertEquals(5, tree.size());
    }

    @Test
    void findMin() {
        buildTreeBig();
        assertEquals(1, tree.findMin());
    }

    @Test
    void findMax() {
        buildTreeBig();
        assertEquals(10, tree.findMax());
    }

    @Test
    void rebalance() {
        buildTreeBig();
        tree.rebalance();
        /*ArrayList<Integer> test = new ArrayList<>();
        test.add(4);
        test.add(2);
        test.add(8);
        test.add(1);
        test.add(3);
        test.add(6);
        test.add(9);
        test.add(5);
        test.add(7);
        test.add(10);
        assertArrayEquals(test.toArray(), tree.levelOrder().toArray());*/
        assertEquals(3, tree.height());
        print.printTree(tree.getRoot());
    }
}
