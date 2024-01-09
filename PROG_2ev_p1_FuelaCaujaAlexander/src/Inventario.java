
public class Inventario {

	//atributos
	private Producto[] vectorProducto;
	private int indice;

	//constructor
	public Inventario(int capacidad) {
		this.vectorProducto = new Producto[capacidad];
		this.indice = 0;
	}

	//toString
	public String toString() {
		String cadena = "";
		if(indice == 0) {
			System.out.println("El inventario esta vacio");
		}
		else {
			Producto x;
			for (int pos = 0; pos < indice ; pos++) {
				x = vectorProducto[pos];
				cadena = cadena + "("+ pos + ")"+ x.toString() + "\n";
			}
		}
		return cadena;
	}

	//insertar al principio
	//desplazamos todos los objetos hacia la derecha y luego en la pos 0 insertamos el Producto x
	public boolean insertarAlPrincipio(Producto x) {
		if (indice < vectorProducto.length) {
			int pos = indice;
			while (pos > 0) {
				vectorProducto[pos] = vectorProducto[pos -1];
				pos--;
			}
			vectorProducto[0] = x;
			indice++;
			return true;
		}
		else {
			return false;
		}
	}

	// consultar por codigo, tenemos que comparar codigos para ver donde esta el codigo
	public Producto consultar (int codigo) {
		/*Producto x = null;
		if(codigo >= 0 && codigo < indice) {
			x = vectorProducto[codigo];
		}
		return x;
		 */
		for (int pos = 0; pos < indice ; pos++){
			Producto producto = vectorProducto[pos];
			if(producto.getCodigo() == codigo) {
				return producto;
			}
		}
		return null;
	}

	// consultar perecederos
	public String cosunsultarPerecederosCaducados() {
		String cadena = "";
		int cosunsultarPerecederosCaducados = 0;
		for (int pos = 0; pos > indice ; pos++) {
			Producto producto = vectorProducto[pos];
			if (producto.haCaducado()) {
				cadena = cadena + "("+ pos + ")" + producto.toString() + "\n" + cosunsultarPerecederosCaducados++;
			}
		}
		if (cosunsultarPerecederosCaducados == 0) {
			cadena = null;
		}
		return cadena;
	}



}
