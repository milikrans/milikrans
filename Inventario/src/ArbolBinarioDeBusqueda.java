import java.util.ArrayList;

public class ArbolBinarioDeBusqueda<T extends Comparable<T>> {

    private NodoArbolBinario<T> raiz;
    //constructor sobrecargado
    public ArbolBinarioDeBusqueda() {
        this.raiz = null;
    }

    //llama a insertar recursivo
    public void insertar(T valor) {
        raiz = insertarRecursivo(raiz, valor);
    }
    //inserta un nodo nuevo o lo ignora si su dato esta repetido
    private NodoArbolBinario<T> insertarRecursivo(NodoArbolBinario<T> nodo, T valor) {
        if (nodo == null) {
            return new NodoArbolBinario<>(valor);
        }
        if(valor.compareTo(nodo.getData()) == 0) return  nodo;
        if (valor.compareTo(nodo.getData()) < 0) {
            nodo.setHijoIzquierdo(insertarRecursivo(nodo.getHijoIzquierdo(), valor));
        } else if (valor.compareTo(nodo.getData()) > 0) {
            nodo.setHijoDerecho(insertarRecursivo(nodo.getHijoDerecho(), valor));
        }
        return nodo; // No duplicados
    }

    //returns true if id is on the tree
    public boolean buscar(T valor) {
        return buscarRecursivo(raiz, valor);
    }
    //searchs the tree for the value
    private boolean buscarRecursivo(NodoArbolBinario<T> nodo, T valor) {
        if (nodo == null) {
            return false;
        }
        if (valor.compareTo(nodo.getData()) == 0) {
            return true;
        }
        return valor.compareTo(nodo.getData()) < 0
                ? buscarRecursivo(nodo.getHijoIzquierdo(), valor)
                : buscarRecursivo(nodo.getHijoDerecho(), valor);
    }

    public String buscar2(T valor) {return buscar2Recursivo(raiz,valor);}

    private String buscar2Recursivo(NodoArbolBinario<T> nodo, T valor) {
        if (nodo == null) {
            return "no se encontro el elemento";
        }
        if (valor.compareTo(nodo.getData()) < 0) {
            buscar2Recursivo(nodo.getHijoIzquierdo(), valor);
        }
        if (valor.compareTo(nodo.getData()) > 0) {
            buscar2Recursivo(nodo.getHijoDerecho(), valor);
        }
        return nodo.getData().toString();
    }

    // recorre en orden
    public String recorrerEnOrden() {
        String listString = String.join(", ", recorrerEnOrdenRecursivo(raiz));
        return listString;
        //System.out.println();
    }

    private ArrayList recorrerEnOrdenRecursivo(NodoArbolBinario<T> nodo) {
        ArrayList lista = new ArrayList();
        if (nodo != null) {
            recorrerEnOrdenRecursivo(nodo.getHijoIzquierdo());
            //System.out.print(nodo.getData() + "\n");
            lista.add(nodo.getData().toString());
            recorrerEnOrdenRecursivo(nodo.getHijoDerecho());
        }
        return lista;
    }

    public String recorrerPreOrden() {
        String listString = String.join(", ", recorrerPreOrdenRecursivo(raiz));
        return listString;
    }

    private ArrayList recorrerPreOrdenRecursivo(NodoArbolBinario<T> nodo) {
        ArrayList lista = new ArrayList();
        if (nodo != null) {
            //System.out.print(nodo.getData() + "\n");
            lista.add(nodo.getData().toString());
            recorrerPreOrdenRecursivo(nodo.getHijoIzquierdo());
            recorrerPreOrdenRecursivo(nodo.getHijoDerecho());
        }
        return lista;
    }

    public String recorrerPosOrden() {
        String listString = String.join(", ", recorrerPreOrdenRecursivo(raiz));
        return listString;
        //System.out.println();

    }

    private ArrayList recorrerPosOrdenRecursivo(NodoArbolBinario<T> nodo) {
        ArrayList lista = new ArrayList();
        if (nodo != null) {
            recorrerPosOrdenRecursivo(nodo.getHijoIzquierdo());
            recorrerPosOrdenRecursivo(nodo.getHijoDerecho());
            //System.out.print(nodo.getData() + "\n");
            lista.add(nodo.getData().toString());

        }
        return lista;
    }

    public void eliminar(T valor) {
        raiz = eliminarRecursivo(raiz, valor);
    }

    private NodoArbolBinario<T> eliminarRecursivo(NodoArbolBinario<T> nodo, T valor) {
        if (nodo == null) {
            return null;
        }

        if (valor.compareTo(nodo.getData()) < 0) {
            nodo.setHijoIzquierdo(eliminarRecursivo(nodo.getHijoIzquierdo(), valor));
        } else if (valor.compareTo(nodo.getData()) > 0) {
            nodo.setHijoDerecho(eliminarRecursivo(nodo.getHijoDerecho(), valor));
        } else {
            //encontrado
            if (nodo.getHijoIzquierdo() == null) {
                return nodo.getHijoDerecho();
            } else if (nodo.getHijoDerecho() == null) {
                return nodo.getHijoIzquierdo();
            }

            T minValue = encontrarMinimo(nodo.getHijoDerecho());
            nodo.setData(minValue);
            nodo.setHijoDerecho(eliminarRecursivo(nodo.getHijoDerecho(), minValue));
        }
        return nodo;
    }

    private T encontrarMinimo(NodoArbolBinario<T> nodo) {
        T minValue = nodo.getData();
        while (nodo.getHijoIzquierdo() != null) {
            nodo = nodo.getHijoIzquierdo();
            minValue = nodo.getData();
        }
        return minValue;
    }

    @Override
    public String toString() {
        return "{" +
                "raiz=" + raiz +
                '}';
    }
}