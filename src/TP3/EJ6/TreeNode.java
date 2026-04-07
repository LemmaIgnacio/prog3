package TP3.EJ6;

public class TreeNode {

    private Book value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(Book value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public Integer getValue() {
        return value.getId();
    }

    public void setValue(Book value) {
        this.value = value;
    }

    //rompe encapsulamiento
    public int getQtyBooks(){
        return value.getQtyBooks();
    }


    public Book getBook(){
        return this.value;
    }
}