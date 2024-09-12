package org.example;

public class Main {
    public static void main(String[] args) {
        RBTree rbTree = new RBTree();
        rbTree.insert(30);
        rbTree.insert(15);
        rbTree.insert(70);
        rbTree.insert(85);
        rbTree.insert(10);
        rbTree.insert(50);
        rbTree.insert(65);
        System.out.println("Árvore Rubro-Negra em Ordem:");
        rbTree.printInOrder();
    }
}