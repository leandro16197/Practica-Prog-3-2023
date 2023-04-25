package practico_1;

import java.util.Iterator;

public class MyIterato<T> implements Iterator {
    private Node<T>nodo;

    public MyIterato(Node<T> nodo) {
        this.nodo = nodo;
    }



    @Override
    public boolean hasNext() {
        if(nodo.getNext()!=null){
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        return nodo.getNext();
    }
}
