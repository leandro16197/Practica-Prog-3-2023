package practico_1;

public class pila<T> {
    private  MySimpleLinkedList list;

    public pila() {
        list=new MySimpleLinkedList();
    }
    public void push(T info){
        list.insertFront(info);
    }
    public T pop(){
       return (T) list.extractFront();
    }
    public T top(){
        return (T) list.toString();
    }
    public void reverse(){
        MySimpleLinkedList aux=this.list;
        while(this.list!=null){
            aux.insertFront(this.list.extractFront());
        }
        this.list=aux;
    }


}
