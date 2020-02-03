package paquetetienda;

import java.util.ArrayList;

public class Cliente {
private String nombre;
private float saldo;
private ArrayList<Producto> lista_productos;
public Cliente(String nombre, float saldo, ArrayList<Producto> lista_productos) {
	super();
	this.nombre = nombre;
	this.saldo = saldo;
	this.lista_productos = lista_productos;
}
public void comprar(Producto p)
{
lista_productos.add(p);
saldo=saldo-p.getPrecio();
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public float getSaldo() {
	return saldo;
}
public void setSaldo(float saldo) {
	this.saldo = saldo;
}
public ArrayList<Producto> getLista_productos() {
	return lista_productos;
}
public void setLista_productos(ArrayList<Producto> lista_productos) {
	this.lista_productos = lista_productos;
}

}
