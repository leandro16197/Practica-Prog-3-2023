package Pracico_2;

public class Ejercicio_1 {
    private int[ ] numbers;
    private int[ ] helper;
    private int size;

    public void ordenamienoBurbujeo(int array[]){
        for(int i=0;i<array.length-1;i++){
           for(int j=0;i<array.length-i-1;i++){
               if(array[j]>array[j+1]){
                   int aux =array[j+1];
                   array[j+1]=array[j];
                   array[j]=aux;
               }
           }
        }
    }

    public void ordenamientoSeleccion(int array[]){
        for(int i=0;i<array.length-1;i++){
            for(int j=0;i<array.length-i-1;i++){
                if(array[j]>array[j+1]){
                    int aux=array[i];
                    array[i]=array[j];
                    array[j]=aux;
                }
            }
        }
    }
    public void sort(int[ ] values) {
        this.numbers = values;
        size = values.length;
        this.helper = new int[size];
        mergesort(0, size - 1);
    }
    private void mergesort(int low, int high) {
        // si low es menor que high continua el ordenamiento
        // si low no es menor que high entonces el array está ordenado
        // ya que es el caso base donde el array tiene un solo elemento.
        if (low < high) {
    // obtener el indice del elemento que se encuentra en la mitad
    // al ser int redondea el resultado al entero menor
            int middle = (low + high) / 2;
    // ordenar la mitad izquierda del array – llamada recursiva
            mergesort(low, middle);
    // ordenar la mitad derecha del array – llamada recursiva
            mergesort(middle + 1, high);
    // combinar ambas mitades ordenadas
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {
        for(int i=low;i<high;i++){
            this.helper[i]=this.numbers[i];
        }
        int i=low;
        int j=middle+1;
        int k=low;
        // copiar de manera ordenada al array original los valores de la
        // mitad izquierda o de la derecha
        while (i <= middle && j <= high) {
            if (helper[ i ] <= helper[ j ]) {
                numbers[ k ] = helper[ i ];
                i++;
            } else {
                numbers[ k ] = helper[ j ];
                j++;
            }
            k++;
        }
        // si quedaron elementos copiarlos al array original
        while (i <= middle) {
            numbers[ k ] = helper[ i ];
            k++;
            i++;
        }
        while (j <= high) {
            numbers[ k ] = helper[ j ];
            k++;
            j++;
        }
    }
    public static void quicksort(int A[], int izq, int der) {

        int pivote=A[izq]; // tomamos primer elemento como pivote
        int i=izq;         // i realiza la búsqueda de izquierda a derecha
        int j=der;         // j realiza la búsqueda de derecha a izquierda
        int aux;

        while(i < j){                          // mientras no se crucen las búsquedas
            while(A[i] <= pivote && i < j) i++; // busca elemento mayor que pivote
            while(A[j] > pivote) j--;           // busca elemento menor que pivote
            if (i < j) {                        // si no se han cruzado
                aux= A[i];                      // los intercambia
                A[i]=A[j];
                A[j]=aux;
            }
        }

        A[izq]=A[j];      // se coloca el pivote en su lugar de forma que tendremos
        A[j]=pivote;      // los menores a su izquierda y los mayores a su derecha

        if(izq < j-1)
            quicksort(A,izq,j-1);          // ordenamos subarray izquierdo
        if(j+1 < der)
            quicksort(A,j+1,der);          // ordenamos subarray derecho

    }

}
