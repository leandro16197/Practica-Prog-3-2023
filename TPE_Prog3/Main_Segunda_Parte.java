package Practico_3_2;

import java.util.ArrayList;

public class Main_Segunda_Parte {

    public static void main(String []args){
        CSVReader reader= new CSVReader("TPE_Prog3\\dataset\\dataset1.txt");
        GrafoNoDirigido g= (GrafoNoDirigido) reader.read();
        Backtracking back=new Backtracking();
        ArrayList<Arco> tunel=new ArrayList<>();
        back.backTracking(g,tunel,0);
        back.informeBacktracking();

    }
}
