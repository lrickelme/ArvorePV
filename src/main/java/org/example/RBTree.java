package org.example;

public class RBTree {
    private RBNode root;
    private RBNode newNode;

    public RBTree() {
        this.newNode = new RBNode(0);
        this.newNode.setColor(false);
        this.root = this.newNode;
    }

    public void insert(int value) {
        RBNode newNode = new RBNode(value);
        this.root = insertRecursively(this.root, newNode);
        balanceTree(newNode);
    }

    private RBNode insertRecursively(RBNode current, RBNode newNode) {
        if (current == null || current == this.newNode) {
            return newNode;
        }

        if (newNode.getValue() < current.getValue()) {
            current.setLeft(insertRecursively(current.getLeft(), newNode));
            if (current.getLeft() != null) {
                current.getLeft().setParent(current);
            }
        } else {
            current.setRight(insertRecursively(current.getRight(), newNode));
            if (current.getRight() != null) {
                current.getRight().setParent(current);
            }
        }

        return current;
    }

    private void balanceTree(RBNode insertedNode) {
        while (insertedNode != this.root && insertedNode.getParent().isColor()) {

            RBNode parent = insertedNode.getParent();
            RBNode grandparent = parent.getParent();

            if (parent == grandparent.getRight()) {
                RBNode uncle = grandparent.getLeft();

                if ((uncle != this.newNode && uncle != null) && uncle.isColor()) {
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
                RBNode uncle = grandparent.getRight();

                if ((uncle != this.newNode && uncle != null) && uncle.isColor()) {
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

    private void rotateLeft(RBNode node) {
        RBNode rightChild = node.getRight();

        if (rightChild == null) {
            return;
        }

        node.setRight(rightChild.getLeft());

        if (rightChild.getLeft() != null && rightChild.getLeft() != this.newNode) {
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

    private void rotateRight(RBNode node) {
        RBNode leftChild = node.getLeft();

        if (leftChild == null) {
            return;
        }

        node.setLeft(leftChild.getRight());

        if (leftChild.getRight() != null && leftChild.getRight() != this.newNode) {
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

    private void printInOrderHelper(RBNode node) {
        if (node != newNode && node != null) {
            printInOrderHelper(node.getLeft());
            String color = node.isColor() ? "\033[31m" : "\033[30m";
            System.out.print("(" + color + node.getValue() + "\033[0m), ");
            printInOrderHelper(node.getRight());
        }
    }

    public RBNode getRoot() {
        return root;
    }

    public void setRoot(RBNode root) {
        this.root = root;
    }

    public RBNode getnewNode() {
        return newNode;
    }

    public void setnewNode(RBNode newNode) {
        this.newNode = newNode;
    }
}