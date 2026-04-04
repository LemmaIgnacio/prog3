package TP3.EJ4;

import java.util.ArrayList;
import java.util.List;

public class Tree {
        private TreeNode root;

        public Tree() {
            this.root = null;
        }

        public void addVoidNodes(){
            addVoidNodes(this.root);
        }

        private int addVoidNodes(TreeNode node){
            if (node == null){
                return 0;
            }
            if (node.getLeft() == null && node.getRight() == null) {
                return node.getValue();
            }

            int left = addVoidNodes(node.getLeft());
            int right = addVoidNodes(node.getRight());
            node.setValue(right - left);
            return node.getValue();
        }
}
