package TP1.EJ6;

import java.util.Iterator;

public class MySimpleLinkedList<T extends Comparable<T>> implements Iterable<T> {

    private Node<T> first;
    private int size;

    public MySimpleLinkedList() {
        this.first = null;
        this.size = 0;
    }

    public MySimpleLinkedList<T> diferencia(MySimpleLinkedList<T> list1, MySimpleLinkedList<T> list2) {
        MySimpleLinkedList<T> res = new MySimpleLinkedList<>();
        for (T e : list1) {
            //verifica que el elmento NO este en list2 ni este repetido
            if (list2.indexOf(e) == -1 && res.indexOf(e) == -1) {
                res.insertOrdered(e);
            }
        }
        return res;
    }

    public MySimpleLinkedList<T> ordenada(MySimpleLinkedList<T> list1, MySimpleLinkedList<T> list2) {
        MySimpleLinkedList<T> res = new MySimpleLinkedList<>();
        Iterator<T> it1 = list1.iterator();
        Iterator<T> it2 = list2.iterator();
        if (!it1.hasNext() || !it2.hasNext()) {
            return res;
        }
        T e1 = it1.next();
        T e2 = it2.next();
        //mientras existan recorro
        while (e1 != null && e2 != null) {
            //comparo e1 con e2
            int comp = e1.compareTo(e2);
            //si los elementos son iguales, agrego elemento a la lista y avanzo en ambos
            if (comp == 0) {
                if (res.indexOf(e1) == -1) {
                    res.insertOrdered(e1);
                }
                if (it1.hasNext()) {
                    e1 = it1.next();
                } else {
                    e1 = null;
                }
                if (it2.hasNext()) {
                    e2 = it2.next();
                } else {
                    e2 = null;
                }
            }
            // el elemento de list1 no sirve
            //porque en list2 el elemento es mas grande
            else if (comp < 0) {
                if (it1.hasNext()) {
                    e1 = it1.next();
                } else {
                    e1 = null;
                }
            }
            //el elemento de list2 no sirve
            //porque en list1 el elemento es mas grande (comparador > 0)
            else {
                if (it2.hasNext()) {
                    e2 = it2.next();
                } else {
                    e2 = null;
                }
            }
        }
        return res;
    }

    public MySimpleLinkedList<T> desordenada(MySimpleLinkedList<T> list1, MySimpleLinkedList<T> list2) {
        MySimpleLinkedList<T> res = new MySimpleLinkedList<>();
        for (T e : list1) {
            if (list2.indexOf(e) != -1 && res.indexOf(e) == -1) {
                res.insertOrdered(e);
            }
        }
        return res;
    }

    public void insertOrdered(T info) {
        Node<T> nuevo = new Node<>(info, null);
        if (this.first == null || info.compareTo(this.first.getInfo()) < 0) {
            nuevo.setNext(this.first);
            this.first = nuevo;
            this.size++;
            return;
        }
        Node<T> cursor = this.first;
        while (cursor.getNext() != null &&
                cursor.getNext().getInfo().compareTo(info) < 0) {
            cursor = cursor.getNext();
        }
        nuevo.setNext(cursor.getNext());
        cursor.setNext(nuevo);
        this.size++;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>(this.first);
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