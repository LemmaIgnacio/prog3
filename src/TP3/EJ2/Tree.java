package TP3.EJ2;

import java.util.ArrayList;
import java.util.List;

public class Tree {
        private TreeNode root;

        public Tree() {
            this.root = null;
        }

        public Integer getSuma (){
            return getSuma(this.root);
        }
        private Integer getSuma(TreeNode node){
            if (node == null){
                return 0;
            }
            if (node.getLeft() == null && node.getRight() == null ){
                return 0;
            }
            //valor actual + valor de mi derecha + valor de mi izquierda
            return node.getValue() + getSuma(node.getLeft()) + getSuma(node.getRight());
        }


}
