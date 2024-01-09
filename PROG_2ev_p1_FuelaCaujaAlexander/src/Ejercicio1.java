import entrada.Teclado;

public class Ejercicio1 {
	public static void escribirMenu() {
		System.out.println();
		System.out.println("(0) salir programa");
		System.out.println("(1) Insertar un producto en la primera posicion del inventario");
		System.out.println("(2) Consultar todos los productos del inventario");
		System.out.println("(3) Consultar un producto por codigo de inventario");
		System.out.println("(4) Consultar los productos perecederos caducos del inventario");
		System.out.println();
		
	}

	public static void main(String[] args) {
		int opcion;
		int codigo;
		
		Producto producto = null;
		
		//caso 4 
		String productosPerecederosCaducados;
		Inventario inventario = new Inventario(50);
		do {
			escribirMenu();
			opcion = Teclado.leerEntero("¿opcion? ");
			switch(opcion) {
			case 0:
				break;
//----------------------------------------------------------------------------------
			case 1:
				
				
				break;
//----------------------------------------------------------------------------------
			case 2:
				if (inventario == null) {
					System.out.println("El inventario esta vacio");
				}
				else {
					System.out.println(inventario.toString());
				}
				
				break;
//----------------------------------------------------------------------------------
			case 3:
				codigo = Teclado.leerEntero("¿Codigo?");
				producto = inventario.consultar(codigo);
				if (producto == null) {
					System.out.println("No se ha encontrado ningun producto con ese codigo");
				}
				else {
					System.out.println(producto.toString());
				}
				break;
//----------------------------------------------------------------------------------
			case 4:
				productosPerecederosCaducados = inventario.cosunsultarPerecederosCaducados();
				if (productosPerecederosCaducados == null) {
					System.out.println("No se ha encontrado ningun producto perecedero caducado ");
				}
				else {
					System.out.println(productosPerecederosCaducados);
				}
				break;
//----------------------------------------------------------------------------------

			default:
				break;
			}
			
		}while(opcion != 0);
		System.out.println("Programa acabado");
		//----------------------------------------------------------------------------------
	}

}
