package Practico_3_2;

class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        // Inicializar todos los elementos como conjuntos individuales
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int element) {

        // Comprimir la ruta mientras se busca el representante raíz
        if (parent[element] != element) {
            parent[element] = find(parent[element]);
        }
        return parent[element];
    }

    public void union(int element1, int element2) {
        int root1 = find(element1);
        int root2 = find(element2);
        if (root1 != root2) {
            // Unir los conjuntos por rango
            if (rank[root1] < rank[root2]) {
                parent[root1] = root2;
            } else if (rank[root1] > rank[root2]) {
                parent[root2] = root1;
            } else {
                parent[root2] = root1;
                rank[root1]++;
            }
        }
    }
}
