package TP3.EJ6;

import java.util.ArrayList;
import java.util.List;

public class Tree {
        TreeNode root;

        public Tree() {
            this.root = null;
        }

        public Integer qtyBooks(int id){
           return qtyBooks(this.root, id);
        }
        private Integer qtyBooks(TreeNode node, int id) {
            if (node == null) {
                return -1;
            }
            if (node.getValue() == id) {
                return node.getQtyBooks();
            }
            if (id < node.getValue()) {
                return qtyBooks(node.getLeft(), id);
            } else {
                return qtyBooks(node.getRight(), id);
            }
        }

    public List<Book> findBookByGender(String gender){
        List<Book> books = new ArrayList<>();
        findBookByGender(books, root, gender);
        return books;
    }

    private void findBookByGender(List<Book> books, TreeNode node, String gender) {
        if (node == null){
            return;
        }
        if(node.getBook().getGender().equals(gender)){
            books.add(node.getBook());
        }
        findBookByGender(books, node.getLeft(), gender);
        findBookByGender(books, node.getRight(), gender);
    }

    public List<Book> findBookbyDate(int date1, int date2){
            List<Book> books = new ArrayList<>();
            findBookbyDate(books, root, date1,date2);
            return books;
    }

    private void findBookbyDate(List<Book> books, TreeNode node, int date1, int date2) {
            if(node == null){
                return;
            }
            if(node.getBook().getPublicationDate() >= date1 && node.getBook().getPublicationDate() <= date2){
                books.add(node.getBook());
            }
            findBookbyDate(books, node.getLeft(), date1,date2);
            findBookbyDate(books, node.getRight(), date1,date2);

    }

}