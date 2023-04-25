package Practico_2_1;


import java.util.ArrayList;
import java.util.List;

public class Arbol {

    private Integer value;
    private Arbol left;
    private Arbol right;

    public Arbol(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Integer getValue() {
        return value;
    }

    public void add(Integer arbol) {
        if (arbol < this.value) {
            if (this.left == null) {
                this.left = new Arbol(arbol);
            } else{
                this.left.add(arbol);}

        } else if (arbol > this.value) {
            if (this.right == null){
                this.right = new Arbol(arbol);
            } else {
                this.right.add(arbol);
            }
        }
    }
    public Integer getRoot(){
        return this.value;
    }
    public boolean hasElement(Integer numero){
       if(this.value!=null){
           if(this.value==numero){
               return true;
           }else{
               if(this.value>numero){
                   if(this.right!=null){
                       this.right.hasElement(numero);
                   }
               }
               if(this.value<numero){
                   if(this.left!=null){
                       this.left.hasElement(numero);
                   }
               }
           }
       }
        return false;
    }
    public boolean isEmpty(){
       if(this.value==null){
          return true;
       }
        return false;
    }
   public void printPreOrden(){
        if(this.value!=null){
            System.out.print(this.value);
            this.left.printPreOrden();
            this.right.printPreOrden();
        }
   }
   public void printInOrden(){
       if(this.value!=null){
           this.left.printInOrden();
           System.out.print(this.value);
           this.right.printInOrden();;
       }
   }
   public void printPostOrden(){
       if(this.value!=null){
           this.left.printPostOrden();
           this.right.printPostOrden();
           System.out.print(this.value);
       }

   }
  public boolean delete(Integer e){
        if(this.isEmpty()){
            return false;
        }else if(this.value<e){
            return this.right.delete(e);
        }else if(this.value>e){
            return this.left.delete(e);
        }else if(this.value.equals(e)){
                if(this.right==null && this.left==null){
                    this.value=null;
                }else if(this.right!=null && this.left!=null){
                    return this.right.deleteConDosHijos();
                }
        }

        return false;
  }

    private boolean deleteConDosHijos() {
        if(this.isEmpty()){
            return false;
        }else if(this.right!=null){
            Integer aux=this.right.maxIzquirda();
            this.value=aux;
            return true;
        }
        return false;
    }

    private Integer maxIzquirda() {
        Integer temp=null;
        if(this.value!=null){
            while(this.left!=null){
                temp=this.left.maxIzquirda();

            }
        }
        return temp;
    }
    public List<Integer> getLongestBranch(){
        if(this.left==null && this.right==null){
            List<Integer>hoja=new ArrayList<>();
            hoja.add(this.value);
            return hoja;
        }
        List<Integer>ramaleft=new ArrayList<>();
        List<Integer>ramaright=new ArrayList<>();
        if(this.left!=null){
            ramaleft.add(this.value);
            ramaleft.addAll(getLongestBranch());
        }
        if(this.right!=null){
            ramaright.add(this.value);
            ramaright.addAll(getLongestBranch());
        }
        if(ramaright.size()>ramaleft.size()){
            return ramaright;
        }else {
            return ramaleft;
        }

    }
    public int getHeight(){
        int sumaR=0,sumaD=0;
        if(this.right==null && this.left==null){
            return 0;
        }
        if(this.right!=null){
            sumaR+=right.getHeight()+1;
        }
        if(this.left!=null){
            sumaD+=left.getHeight()+1;
        }
        if(sumaR>sumaD){
            return sumaR;
        }else {
            return sumaD;
        }
    }
    public List<Integer> getElemAtLeven(Integer e){
        int contador=0;
        return buscarElementos(contador,e);
    }

    private List<Integer> buscarElementos(int contador, Integer e) {
        ArrayList temporal=new ArrayList();
        if(contador==e){
            temporal.add(this.left);
            temporal.add(this.right);
            return temporal;
        }else{
            if(this.right!=null && this.left!=null){
                contador++;
                temporal.addAll(this.right.buscarElementos(contador,e));
                temporal.addAll(this.right.buscarElementos(contador,e));
                return temporal;
            }
            if(this.right!=null && this.left==null){
                contador++;
                temporal.addAll(this.right.buscarElementos(contador,e));
                return temporal;
            }
            if(this.left!=null && this.right==null){
                contador++;
                temporal.addAll(this.left.buscarElementos(contador,e));
                return temporal;
            }
        }
        return temporal;
    }
    public int getMaxElements(){
        if(this.right==null){
            return this.getValue();
        }else {
            return this.right.getMaxElements();
        }
    }

    public int sumaTotal(){
        int total=0;
        return suma(total);
    }

    private int suma(int total) {
        if(this.right==null && this.left==null){
            return this.getValue();
        }else {
            if(this.right!=null && this.left!=null){
                total+=this.right.suma(total);
                total+=this.left.suma(total);
                return total;
            }
            if(this.right!=null && this.left==null){
                total+=this.right.suma(total);
                return total;
            }
            if(this.left!=null && this.right==null){
                total+=this.left.suma(total);
                return total;
            }
        }
        return total;
    }

    public List getSuperarNumero(Integer valor){ //ejercicio 3
        ArrayList <Integer> list=new ArrayList<>();
        if(this.value>valor && this.left==null && this.right==null){
            list.add(this.value);
            return list;
        }else {
            if(this.left!=null && this.right!=null){
                list.addAll(this.right.getSuperarNumero(valor));
                list.addAll(this.left.getSuperarNumero(valor));
                return list;
            }
            if(this.left!=null & this.right==null){
                list.addAll(this.left.getSuperarNumero(valor));
                return list;
            }
            if(this.right!=null && this.left==null){
                list.addAll(this.right.getSuperarNumero(valor));
                return list;
            }
            return list;
        }
    }
    public void completarArbolNoOrdenado(){//ejercicio 4
        if(this.right!=null && this.left!=null){
            this.left.completarArbolNoOrdenado();
            this.right.completarArbolNoOrdenado();
            this.value=this.right.getValue()-this.left.getValue();
        }
        if(this.right!=null && this.left==null){
            this.right.completarArbolNoOrdenado();
            this.value=this.right.getValue()-0;
        }
        if(this.right==null && this.left!=null){
            this.left.completarArbolNoOrdenado();
            this.value=0-this.left.getValue();
        }
    }
}