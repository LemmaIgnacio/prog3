package TP1.EJ3;

class Node <T>{
    private T info; //dato
    private Node<T> next; //ref siguiente elemento

    public Node(){
        this.info = null;
        this.next = null;
    }
    public Node(T info, Node<T> next){
        this.setInfo(info);
        this.setNext(next);
    }

    public Node<T> getNext(){
        return next;
    }
    public void setNext(Node<T> next){
        this.next = next;
    }

    public T getInfo() {
        return info;
    }
    public void setInfo(T info) {
        this.info = info;
    }
}

