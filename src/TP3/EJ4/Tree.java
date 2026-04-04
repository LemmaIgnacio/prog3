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
                //sino hay hijo el valor se reemplaza por 0
                return 0;
            }
            if (node.getLeft() == null && node.getRight() == null) {
                //si encontre una hoja devuelvo su valor
                return node.getValue();
            }
            //recursividad para bajar por los nodos
            int left = addVoidNodes(node.getLeft());
            int right = addVoidNodes(node.getRight());
            //seteo el valor del nodo vacio
            node.setValue(right - left);
            return node.getValue();
        }
}
