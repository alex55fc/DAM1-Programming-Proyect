
public class SocioPremium extends Socio{

	//atributos 
	private boolean carnetEstudiante;
	
	//constructor 
	public SocioPremium(String dni, String nombre, int edad, int horasEntreador, 
			boolean carnetEstudiante) {
		super(dni, nombre, edad, horasEntreador);
		this.carnetEstudiante = carnetEstudiante;
	}
	//toString 
	@Override
	public String toString() {
		return "SocioPremium [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + ", horasEntreador="
				+ horasEntreador + ", carnetEstudiante=" + carnetEstudiante + ",Cuota mensual "+calcularCuotaMensual() +"]";
				
	}
	
	//get y set 
	public boolean isCarnetEstudiante() {
		return carnetEstudiante;
	}
	//el descuetno del 10 por ciento salio mal
	 
	@Override
	public double calcularCuotaMensual() {
		double precio = 0;
		if (edad > 65) {
			precio = precio + 40.00;
			if (horasEntreador > 0) {
				precio = precio + (horasEntreador * 35.00);
			}
			if (carnetEstudiante == true) {
				double descuento = precio * 0.01;
				precio = precio - descuento;
			}
		}
		else {
			precio = precio + 60.00;
			if (horasEntreador > 0) {
				precio = precio + (horasEntreador * 35.00);
			}
			if (carnetEstudiante == true) {
				double descuento = precio * 0.01;
				precio = precio - descuento;
			}
		}
		return precio;
	}
}
