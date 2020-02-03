package paquetetienda;

import java.util.ArrayList;
import java.util.Scanner;

public class EntradaSalida {

	public static final int SALIR = 4;
	public static final int COMPRAR = 1;
	public static final int VER_CARRITO = 3;
	public static final int VER_SALDO = 2;

	public static int mostrarMenu() {
		System.out.println(COMPRAR+"- Comprar");
		System.out.println(VER_SALDO+"- Ver saldo");
		System.out.println(VER_CARRITO+"- Ver carrito");
		System.out.println(SALIR+"- Salir");
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		
		return id;
	}

	public static int mostrarProductos(ArrayList<Producto> lista_productos) {
		// TODO Auto-generated method stub
		for(Producto p: lista_productos)
		{
			System.out.println(p);
		}
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		
		return id;
	}

	public static void mostrarCarrito(ArrayList<Producto> lista_productos) {
		System.out.println("Productos comprados:");
		for(Producto p: lista_productos)
		{
			System.out.println(p);
		}
		// TODO Auto-generated method stub
		
	}

	public static void mostrarSaldo(float saldo) {
		System.out.println("Saldo: "+saldo);
		
	}

}
