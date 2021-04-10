import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BinaryTreeNodeTest {
    private BinaryTreeNode node;

    @BeforeEach
    void setUp() {
        node = new BinaryTreeNode(5);
    }

    @AfterEach
    void tearDown() {
        node = null;
    }

    @Test
    void testSimpleConstructor() {
        assertEquals(5, node.getElement());
    }

    @Test
    void testNodeConstructor() {
        BinaryTreeNode leftNode = new BinaryTreeNode(2);
        BinaryTreeNode rightNode = new BinaryTreeNode(3);
        node = new BinaryTreeNode(5, leftNode, rightNode);
        assertEquals(5, node.getElement());
        assertEquals(2, node.getLeftChild().getElement());
        assertEquals(3, node.getRightChild().getElement());
    }

    @Test
    void testNodeAdding() {
        BinaryTreeNode leftNode = new BinaryTreeNode(2);
        BinaryTreeNode rightNode = new BinaryTreeNode(3);
        node.addLeftChild(leftNode);
        node.addRightChild(rightNode);
        assertEquals(5, node.getElement());
        assertEquals(2, node.getLeftChild().getElement());
        assertEquals(3, node.getRightChild().getElement());
    }
}
