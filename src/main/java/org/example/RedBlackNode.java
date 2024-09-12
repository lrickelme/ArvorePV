package org.example;

public class RedBlackNode {
    private Integer value;
    private RedBlackNode left, right, parent;
    private boolean color;

    public RedBlackNode(Integer value) {
        this.value = value;
        this.left = this.right = this.parent = null;
        this.color = true;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public RedBlackNode getLeft() {
        return left;
    }

    public void setLeft(RedBlackNode left) {
        this.left = left;
    }

    public RedBlackNode getRight() {
        return right;
    }

    public void setRight(RedBlackNode right) {
        this.right = right;
    }

    public RedBlackNode getParent() {
        return parent;
    }

    public void setParent(RedBlackNode parent) {
        this.parent = parent;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }
}