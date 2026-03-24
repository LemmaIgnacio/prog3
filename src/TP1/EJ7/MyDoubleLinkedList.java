package TP1.EJ7;

public class MyDoubleLinkedList<T> {

    private NodoDoble<T> first;
    private NodoDoble<T> last;
    private int size;

    public MyDoubleLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public void insertFront(T info) {
        NodoDoble<T> nuevo = new NodoDoble<>(info, this.first, null);
        if (this.first != null) {
            this.first.setPrev(nuevo);
        } else {
            this.last = nuevo;
        }
        this.first = nuevo;
        this.size++;
    }

    public T extractFront() {
        if (this.first == null) {
            return null;
        }
        T info = this.first.getInfo();
        this.first = this.first.getNext();
        if (this.first != null) {
            this.first.setPrev(null);
        } else {
            this.last = null;
        }
        this.size--;
        return info;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public int size() {
        return this.size;
    }

    //Cosas O(n) que puede hacer O(1) la lsita doble
    public void insertBack(T info) {
        NodoDoble<T> nuevo = new NodoDoble<>(info, null, this.last);

        if (this.last != null) {
            this.last.setNext(nuevo);
        } else {
            this.first = nuevo;
        }

        this.last = nuevo;
        this.size++;
    }

    public T extractBack() {
        T info = this.last.getInfo();
        this.last = this.last.getPrev();
        if (this.last != null) {
            this.last.setNext(null);
        } else {
            this.first = null;
        }
        this.size--;
        return info;
    }
    /*

     */
}
