package org.example;

public class RBTree {
    private RedBlackNode root;
    private final RedBlackNode child; // Nó sentinela para folhas nulas

    public RBTree() {
        this.child = new RedBlackNode(0);  // Nó sentinela com valor 0
        this.child.setColor(false);        // Definir como preto
        this.child.setLeft(null);
        this.child.setRight(null);
        this.root = this.child;            // Inicializar a raiz como nó sentinela
    }

    public void insert(int value) {
        RedBlackNode newNode = new RedBlackNode(value);
        newNode.setLeft(child);
        newNode.setRight(child);
        this.root = insertRecursively(this.root, newNode);
        balanceTree(newNode);
    }

    private RedBlackNode insertRecursively(RedBlackNode current, RedBlackNode newNode) {
        if (current == child) {
            return newNode;
        }

        if (newNode.getValue() < current.getValue()) {
            current.setLeft(insertRecursively(current.getLeft(), newNode));
            current.getLeft().setParent(current);
        } else {
            current.setRight(insertRecursively(current.getRight(), newNode));
            current.getRight().setParent(current);
        }

        return current;
    }

    private void balanceTree(RedBlackNode insertedNode) {
        while (insertedNode != this.root && insertedNode.getParent().isColor()) {
            RedBlackNode parent = insertedNode.getParent();
            RedBlackNode grandparent = insertedNode.getParent().getParent();

            if (parent == grandparent.getRight()) {
                RedBlackNode uncle = grandparent.getLeft();

                if (uncle.isColor()) {
                    uncle.setColor(false);
                    parent.setColor(false);
                    grandparent.setColor(true);
                    insertedNode = grandparent;
                } else {
                    if (insertedNode == parent.getLeft()) {
                        insertedNode = parent;
                        rotateRight(insertedNode);
                    }
                    parent.setColor(false);
                    grandparent.setColor(true);
                    rotateLeft(grandparent);
                }
            } else {
                RedBlackNode uncle = grandparent.getRight();

                if (uncle.isColor()) {
                    uncle.setColor(false);
                    parent.setColor(false);
                    grandparent.setColor(true);
                    insertedNode = grandparent;
                } else {
                    if (insertedNode == parent.getRight()) {
                        insertedNode = parent;
                        rotateLeft(insertedNode);
                    }
                    parent.setColor(false);
                    grandparent.setColor(true);
                    rotateRight(grandparent);
                }
            }
        }
        this.root.setColor(false);
    }

    private void rotateLeft(RedBlackNode node) {
        RedBlackNode rightChild = node.getRight();
        node.setRight(rightChild.getLeft());

        if (rightChild.getLeft() != this.child) {
            rightChild.getLeft().setParent(node);
        }

        rightChild.setParent(node.getParent());

        if (node.getParent() == null) {
            this.root = rightChild;
        } else if (node == node.getParent().getLeft()) {
            node.getParent().setLeft(rightChild);
        } else {
            node.getParent().setRight(rightChild);
        }
        rightChild.setLeft(node);
        node.setParent(rightChild);
    }

    private void rotateRight(RedBlackNode node) {
        RedBlackNode leftChild = node.getLeft();
        node.setLeft(leftChild.getRight());

        if (leftChild.getRight() != this.child) {
            leftChild.getRight().setParent(node);
        }

        leftChild.setParent(node.getParent());

        if (node.getParent() == null) {
            this.root = leftChild;
        } else if (node == node.getParent().getRight()) {
            node.getParent().setRight(leftChild);
        } else {
            node.getParent().setLeft(leftChild);
        }
        leftChild.setRight(node);
        node.setParent(leftChild);
    }

    public void printInOrder() {
        printInOrderHelper(root);
        System.out.println();
    }

    private void printInOrderHelper(RedBlackNode node) {
        if (node != child) {
            printInOrderHelper(node.getLeft());
            String sColor = node.isColor() ? "\033[31m" : "\033[30m";
            System.out.print("(" + sColor + node.getValue() + "\033[0m), ");
            printInOrderHelper(node.getRight());
        }
    }

    public RedBlackNode getRoot() {
        return root;
    }

    public void setRoot(RedBlackNode root) {
        this.root = root;
    }

    public RedBlackNode getChild() {
        return child;
    }
}
