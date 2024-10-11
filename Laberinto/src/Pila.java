import java.util.Stack;

public class Pila <E>{
    public Stack<E> data;

    public Pila(){
        this.data = new Stack<>();
    }

    public boolean estaVacia(){
        return this.data.empty();
    }

    public E peek(){
        return this.data.peek();
    }

    public E pop(){
        return this.data.pop();
    }

    public void push(E objeto){
        this.data.push(objeto);
    }

    public int buscar(E object){
        return this.data.search(object);
    }
}
