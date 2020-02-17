package paquetetienda;

import java.util.ArrayList;

public class ClasePrincipal {

	public static void main(String[] args) {
		
		
		Cliente c=null;
		/*do {
			///instrucciones se ejeuutaln al menos una vez
			String nombre_cliente=EntradaSalida.pedirNombreCliente();
			c=AccesoBD.recuperarCliente(nombre_cliente);
		}while(c.getSaldo()==0);
		*/
		
		
		int opcion=EntradaSalida.mostrarMenu();
		while(opcion!=EntradaSalida.SALIR)
		{
			switch(opcion)
			{
			case EntradaSalida.ADMIN:
				boolean admin=false;
				int n_intentos=0;
				while(admin==false && n_intentos<2)
				{
				//Pedir datos del administrador
					//Aumentar n_intentos cada vez que pida datos
					//Darle valor a admin cada vez que pida datos.
				Administrador a=EntradaSalida.pedirDatosAdmin();//Pide usr y pwd
				n_intentos++;
				admin=AccesoDatos.comnprobarAdmin(a);
				
				}
				
				
				break;
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
		AccesoBD.actualizarSaldo(c);

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
