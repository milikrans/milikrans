import javax.swing.*;
import java.util.Objects;

public class Producto implements Comparable<Producto> {
    private String nombre;
    private int idProducto;
    private int precio;
    private int cantidad;

    public Producto(String nombre, int idProducto, int precio, int cantidad) {
        this.nombre = nombre;
        this.idProducto = idProducto;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    public Producto(int idProducto) {
        this.idProducto = idProducto;
    }
    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto that = (Producto) o;
        if (Objects.equals(idProducto, that.idProducto)){
            return true;
        }
        if (Objects.equals(nombre, that.nombre)){
            return true;
        }
        return false;
    }
    @Override
    public int compareTo(Producto o) {
       if(this.idProducto == o.getIdProducto() /*|| this.nombre.equals(o.nombre)*/){
           return 0;
       }
       if(this.idProducto < o.getIdProducto()){
           return -1;
       }
       if(this.idProducto > o.getIdProducto()){
           return 1;
       }
       return 0;
    }

    @Override
    public String toString() {
        return "nombre = '" + nombre + '\'' +
                ", idProducto = " + idProducto +
                ", precio = "  + precio +
                ", cantidad = " + cantidad;
    }
}

