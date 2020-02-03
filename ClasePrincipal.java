package paquetetienda;

import java.util.ArrayList;

public class ClasePrincipal {

	public static void main(String[] args) {
		int saldo=2000;//En la v2, el saldo está en bd
		String nombre_usuario="Pepe";
		Cliente c=new Cliente(nombre_usuario,saldo, new ArrayList<Producto>() );
		int opcion=EntradaSalida.mostrarMenu();
		while(opcion!=EntradaSalida.SALIR)
		{
			switch(opcion)
			{
			case EntradaSalida.COMPRAR:
				ArrayList<Producto> lista_productos=AccesoBD.recuperarProductos();
				int id_producto=EntradaSalida.mostrarProductos(lista_productos);
				//1-Añadir producto al carrito del Cliente
				Producto p=obtenerProductoPorId(lista_productos, id_producto);
				//2-Retar el precio al saldo del Cliente
				c.comprar(p);
				break;
			case EntradaSalida.VER_CARRITO:
				EntradaSalida.mostrarCarrito(c.getLista_productos());
				break;
				
			case EntradaSalida.VER_SALDO:
				EntradaSalida.mostrarSaldo(c.getSaldo());
				break;
			}
			opcion=EntradaSalida.mostrarMenu();
		}

	}

	private static Producto obtenerProductoPorId(ArrayList<Producto> lista_productos, int id_producto) {
		// TODO Auto-generated method stub
		for(Producto p: lista_productos)
		{
			if(p.getId()==id_producto)
			{
				return p;
			}
		}
		return null;
	}

}
