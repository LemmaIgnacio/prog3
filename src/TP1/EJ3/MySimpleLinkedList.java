package TP1.EJ3;

public class MySimpleLinkedList<T> {

    private Node<T> first;
    private int size;

    public MySimpleLinkedList() {
        this.first = null;
        this.size = 0;
    }

    public int indexOf(T elemento) {
        Node<T> cursor = this.first;
        int index = 0;

        while (cursor != null) { //O(n)
            if (cursor.getInfo().equals(elemento)) {
                return index;
            }
            cursor = cursor.getNext();
            index++;
        }
        return -1;
    }

    public void insertFront(T info) {
        Node<T> tmp = new Node<T>(info,null);
        tmp.setNext(this.first);
        this.first = tmp;
        this.size++;
    }

    public T extractFront() { // O(1)
        T info = this.first.getInfo(); // guardo el valor del primer nodo
        this.first = this.first.getNext(); // el segundo pasa a ser el primero
        this.size--;
        return info; // devuelvo el elemento extraído
    }

    public boolean isEmpty() { // O(1)
        return this.first == null; //sino existe primer nodo, la lista esta vacia
    }

    public T get(int index) { // O(n)
        Node<T> cursor = this.first;
        int i = 0;
        while (i < index){
            cursor = cursor.getNext();
            i++;
        }
        return cursor.getInfo();
    }

    public int size() { // O(1)
        return this.size;
    }

    @Override
    public String toString() {
        String res = " ";
        Node<T> cursor = this.first;
        //  O(n)
        while (cursor != null) { //Avanzar nodo por nodo hasta llegar a null.
            res += cursor.getInfo() + " ";
            cursor = cursor.getNext();
        }

        return res;
    }
}