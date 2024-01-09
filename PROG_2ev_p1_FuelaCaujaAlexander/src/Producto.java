import java.util.Random;

public class Producto {
	//atributo static
	private static int codigoAutogenerado = 0;

	//private static Random aleatorio;

	//atributo 
	private int codigo;
	private String nombre;
	private int caducidad; // para productos perecederos
	private double precio;

	//constructor
	public Producto() {
		Random aleatorio = new Random();
		String categoria, durabilidad;
		codigoAutogenerado++;
		this.codigo = codigoAutogenerado;
		int numero = aleatorio.nextInt(3);// entre 0 y 3 creo 
		if (numero == 0) {
			categoria = "A";
		}
		else if (numero == 1) {
			categoria = "B";
		}
		else {
			categoria = "C";
		}

		if(aleatorio.nextBoolean()) {
			durabilidad = "PER";
		}
		else {
			durabilidad = "NOP";
		}
		numero = aleatorio.nextInt(9999) + 1;
		this.nombre = categoria + durabilidad + String.format("%04d", numero);
		this.caducidad = aleatorio.nextInt(365 + 50 + 1) -50;
		this.precio = aleatorio.nextDouble()* 19 +1;//num entre 1 y 20
	}

	public int getCaducidad() {
		return caducidad;
	}

	/*private static final String[] ABC = {"A", "B", "C"};
	private static final String[] PERNOP = {"PER", "NOP"};
	public Producto() {
		Random aleatorio = new Random();
		double a = 1.00;
		double b = 9999.00;
		double dato = aleatorio.nextDouble() * (b-a) + a;
		double c = 1.00;
		double d = 20.00;
		double dat = aleatorio.nextDouble() * (d-c) + c;
		codigoAutogenerado++;
		this.codigo = codigoAutogenerado;
		this.nombre = ABC[aleatorio.nextInt(ABC.length)] + PERNOP[aleatorio.nextInt(PERNOP.length)]+ dato ;
		this.precio = dat;
	}
	 */

	//metodo toString
	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + 
				", caducidad=" + caducidad + ", precio=" + String.format("%2.2f", precio)
				+ "]";
	}


	public int getCodigo() {
		return codigo;
	}

	//ha caducado 
	public boolean haCaducado() {
		String durablidad = nombre.substring(1,4);
		if (durablidad.equals ("PER") && caducidad <= 0 ) {
			return true;
		}
		else {
			return false;
		}

	}
}
