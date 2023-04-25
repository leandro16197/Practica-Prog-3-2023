package practico_1;

import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterable {

        private Node<T> first;
        private int cant;

        public MySimpleLinkedList() {
            this.first = null;
        }

        public void insertFront(T info) {
            Node<T> tmp = new Node<T>(info,null);
            tmp.setNext(this.first);
            this.first = tmp;
            this.cant++;
        }

        public T extractFront() {
            if(this.first!= null){
                Node<T> temp=this.first.getNext();
                this.first=temp;
                this.cant--;
                return temp.getInfo();

            }
            return null;
        }

        public boolean isEmpty() {
            if(this.first==null){
                return true;
            }
            return false;
        }

        public T get(int index) {
            return this.Buscarnodo(this.first,0,index);
        }

        public int size() {
            return this.cant;
        }

        @Override
        public String toString() {
            return "el primer nodo es :"+this.first;
        }

        public T Buscarnodo(Node<T>nodo, int inicio,int index){
            if(inicio != index){
                inicio++;
                return this.Buscarnodo(nodo.getNext(),inicio,index);
            }else{
                return nodo.getInfo();
            }
        }

       public int indexOf(Node<T>nodo){
            Node<T>aux=this.first;
            int cant =-1;
            while(aux!=null){
                if(aux.getInfo()==nodo.getInfo()){
                    return cant;
                }
                cant++;
            }
            return -1;
       }


    @Override
    public Iterator iterator() {
        return new MyIterato(this.first);
    }
}
