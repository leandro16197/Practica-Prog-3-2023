package Practico_2_1;

public class Main {
    public static void main(String[] args) {
        Arbol a=new Arbol(2);
        a.add(6);
        a.add(2);
        a.add(1);
        a.add(4);
        a.add(10);
        a.add(8);
        a.add(11);
        a.add(7);
        a.add(9);
        System.out.print(a.sumaTotal());

    }
}
