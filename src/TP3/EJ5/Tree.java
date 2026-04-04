package TP3.EJ5;

import java.util.ArrayList;
import java.util.List;

public class Tree {
        private TreeNode root;

        public Tree() {
            this.root = null;
        }

        public List<String> getPalabra(int n){
            List<String> list = new ArrayList<>();
            getPalabra(list, this.root, n, 0,"");
            return list;
        }

        private void getPalabra(List<String> list, TreeNode node,
                                int n, int cantVocales, String palabraActual){
            if(node == null){
                return;
            }
            //agrego la letra
            palabraActual += node.getValue();

            if (isVocal(node.getValue())){
                cantVocales++;
            }
            //vuelvo si ya me pase
            if (cantVocales > n){
                return;
            }
            //si la palabra esta completa la agrego a la lista
            if (node.getLeft() == null && node.getRight() == null){
                if (cantVocales == n){
                    list.add(palabraActual);
                }
                return;
            }
            //contirunar buscando
            getPalabra(list, node.getLeft(),n,cantVocales,palabraActual);
            getPalabra(list, node.getRight(),n,cantVocales,palabraActual);
        }

        private boolean isVocal(Character c){
            return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
        }
}