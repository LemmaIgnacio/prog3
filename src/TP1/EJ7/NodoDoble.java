package TP1.EJ7;

public class NodoDoble <T>{
    private T info;
    private NodoDoble<T> next;
    private NodoDoble<T> prev;

    public NodoDoble(T info, NodoDoble<T> next, NodoDoble<T> prev) {
        this.info = info;
        this.next = next;
        this.prev = prev;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NodoDoble<T> getNext() {
        return next;
    }

    public void setNext(NodoDoble<T> next) {
        this.next = next;
    }

    public NodoDoble<T> getPrev() {
        return prev;
    }

    public void setPrev(NodoDoble<T> prev) {
        this.prev = prev;
    }
}
