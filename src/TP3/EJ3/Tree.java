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

        public Integer getRoot() {
            /*
            accede directamente a la raiz O(1);
            Si el arbol NO esta vacio,
            retorna un valor de la raiz del arbol
            */
            if (this.root == null)
                return null;

            return this.root.getValue();
        }

        public boolean hasElem(Integer value) {
            //evitamos romper encapsulamiento, solo damos el valor inicial
            //y no los nodos del arbol
            return hasElem(this.root, value);
        }
        private boolean hasElem(TreeNode node, Integer value) {
            //Complejidad O(n) (arbol sea lineal), caso promedio O(log n)
            if (node == null) { //no encontre
                return false;
            }else if (node.getValue().equals(value)) {
                return true; //lo encontre
            }else if (value < node.getValue()) { // si es menor -> busco a la izquierda
                return hasElem(node.getLeft(), value);
            }else //(value > node.getValue()
                return hasElem(node.getRight(), value);// sies mayor -> busco por derecha
        }

        public boolean isEmpty() {
            //un arbol vacio es un arbol sin raiz
            return this.root == null;
        }

        public void add(Integer value) {
            if (this.root == null)
                this.root = new TreeNode(value);
            else
                this.add(this.root,value);
        }
        private void add(TreeNode actual, Integer value) {
            if (actual.getValue() > value) {
                if (actual.getLeft() == null) {
                    TreeNode temp = new TreeNode(value);
                    actual.setLeft(temp);
                } else {
                    add(actual.getLeft(),value);
                }
            } else if (actual.getValue() < value) {
                if (actual.getRight() == null) {
                    TreeNode temp = new TreeNode(value);
                    actual.setRight(temp);
                } else {
                    add(actual.getRight(),value);
                }
            }
        }

        public int getHeight() {
            return getHeight(this.root);
        }
        private int getHeight(TreeNode node) {
            //Complejidad O(n) recorre todos los nodos del arbol
            if (node == null)
                return -1; //arbol vacio

            //recursividad para obtener la altura de los subarboles
            int alturaIzq = getHeight(node.getLeft());
            int alturaDer = getHeight(node.getRight());
            if (alturaIzq > alturaDer) //la altura mayor es la altura de sus hijos +1
                return alturaIzq + 1;
            else
                return alturaDer + 1;
        }

        /*
        Complejidad O(n), recorre todos los nodos
        Preorden → raíz primero, proceso el nodo antes de bajar
        Inorden → raíz en el medio, proceso el nodo entre izquierda y derecha
        Postorden → raíz al final, proceso el nodo después de recorrer hijos
         */
        public void printPosOrder() {
            printPosOrder(this.root);
        }
        private void printPosOrder(TreeNode node) {
            if (node == null)
                return;
            printPosOrder(node.getLeft());
            printPosOrder(node.getRight());
            System.out.print(node.getValue() + " ");
            /*
                    8
                   / \
                  3   10
                 / \
                1   6

                izquierda de 8 → 3
                izquierda de 3 → 1 → imprime
                derecha de 3 → 6 → imprime
                imprime 3
                derecha de 8 → 10 → imprime
                imprime 8
                1 6 3 10 8
             */
        }
        public void printPreOrder() {
            printPreOrder(this.root);
        }
        private void printPreOrder(TreeNode node) {
            if (node == null)
                return;
            System.out.print(node.getValue() + " ");
            printPreOrder(node.getLeft());
            printPreOrder(node.getRight());
            /*
                    8
                   / \
                  3   10
                 / \
                1   6

                imprime 8
                va a 3 → imprime
                va a 1 → imprime
                vuelve → va a 6 → imprime
                vuelve → va a 10 → imprime
                8 3 1 6 10
             */
        }
        public void printInOrder() {
            printInOrder(this.root);
        }
        private void printInOrder(TreeNode node) {
            if (node == null)
                return;
            printInOrder(node.getLeft());
            System.out.print(node.getValue() + " ");
            printInOrder(node.getRight());
            /*
                    8
                   / \
                  3   10
                 / \
                1   6

                baja hasta el más izquierdo → 1 → imprime
                vuelve a 3 → imprime
                va a 6 → imprime
                vuelve a 8 → imprime
                va a 10 → imprime
             */
        }

        public List<Integer> getLongestBranch() {
            return getLongestBranch(this.root);
        }
        private List<Integer> getLongestBranch(TreeNode node) {
            //O(n) recorro todo el arbol
            List<Integer> list = new ArrayList<>();
            if (node == null)
                return list; //root null, lista vacia
            //recurcion, me quedo con la rama mas larga derecha/izquieda
            List<Integer> izquierda = getLongestBranch(node.getLeft());
            List<Integer> derecha = getLongestBranch(node.getRight());

            if (izquierda.size() > derecha.size()) {
                list = izquierda;
            }else {
                list = derecha;
            }
            list.add(0, node.getValue());
            return list;
        }

        public List<Integer> getFrontera() {
            //crear lista vacia, llamar a metodo recursivo, devolver lista
            List<Integer> lista = new ArrayList<>();
            getFrontera(this.root, lista);
            return lista;
        }
        private void getFrontera(TreeNode node, List<Integer> list) {
            //O(n) visita todos los nodos
            if (node == null) {
                return;
            }
            if (node.getLeft() == null && node.getRight() == null) { //agrega si es una hoja
                list.add(node.getValue());
            }
            getFrontera(node.getLeft(), list);
            getFrontera(node.getRight(), list);
        }

        public Integer getMaxElem() {
            if (this.root == null) {
                return null;
            }
            return getMaxElem(this.root);
        }
        private Integer getMaxElem(TreeNode node) {
        if (node.getRight() == null) {
            return node.getValue();
        }
        return getMaxElem(node.getRight());
    }

        public List<Integer> getElemAtLevel(int level) {
            List<Integer> lista = new ArrayList<>();
            getElemAtLevel(this.root, level, lista);
            return lista;
        }
        private void getElemAtLevel(TreeNode node, int level, List<Integer> list) {
            if (node == null) {
                return;
            }
            if (level == 0) {
                list.add(node.getValue());
                return;
            }
            getElemAtLevel(node.getLeft(), level - 1, list);
            getElemAtLevel(node.getRight(), level - 1, list);
        }

}
