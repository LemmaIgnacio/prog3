package TP3.EJ3;

import java.util.ArrayList;
import java.util.List;

public class Tree {
        private TreeNode root;

        public Tree() {
            this.root = null;
        }

        public List<Integer> hojasSuperiores(int k){
            List<Integer> list = new ArrayList<>();
            hojasSuperiores(this.root, k, list);
            return list;
        }

        private void hojasSuperiores(TreeNode node, int k, List<Integer> list){
            if (node == null){
                return;
            }
            if (node.getLeft() == null && node.getRight() == null){
                if (node.getValue() > k){
                    list.add(node.getValue());
                }
                return;
            }
            hojasSuperiores(node.getLeft(),k,list);
            hojasSuperiores(node.getRight(),k,list);
        }

}
