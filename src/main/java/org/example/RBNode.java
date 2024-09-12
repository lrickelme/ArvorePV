package org.example;

public class RBNode {
    private Integer value;
    private RBNode left, right, parent;
    private boolean color;

    public RBNode(Integer value) {
        this.value = value;
        this.left = this.right = this.parent = null;
        this.color = true; //Novo nó inicia como vermelho, vermelho = true e preto = false
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public RBNode getLeft() {
        return left;
    }

    public void setLeft(RBNode left) {
        this.left = left;
    }

    public RBNode getRight() {
        return right;
    }

    public void setRight(RBNode right) {
        this.right = right;
    }

    public RBNode getParent() {
        return parent;
    }

    public void setParent(RBNode parent) {
        this.parent = parent;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }
}
