
public class SocioBasico extends Socio {
	//atributos 
	private boolean taquilla;
	private int turno;
	
	//constructor 
	public SocioBasico(String dni, String nombre, int edad, int horasEntreador,
			boolean taquilla, int turno) {
		super(dni, nombre, edad, horasEntreador);
		this.taquilla = taquilla;
		this.turno = turno;
	}
	
	
	
	@Override
	public String toString() {
		return "SocioBasico [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + ", horasEntreador="
				+ horasEntreador + ", taquilla=" + taquilla + ", turno=" + turno() + ", Cuota mensual "+calcularCuotaMensual() +"]";
	}

	public String turno() {
		String turnos = "";
		if (turno == 1) {
			turnos = "mañanas";
			return turnos;
		}
		else if(turno == 2) {
			turnos = "tardes";
			return turnos;
		}
		else {
			turnos = "mediodia";
			return turnos;
		}
	}
	@Override
	public double calcularCuotaMensual() {
		double precio = 0.00;
		if (edad > 65) {
			if (turno == 1) {
				 precio = 25.00;
			}
			else if (turno == 2) {
				 precio = 30.00;
			}
			else if (turno == 3){
				 precio = 20.00;
			}
			if (taquilla == true) {
				precio = precio + 2.00;
			}
			if (horasEntreador > 0) {
				precio = precio + (horasEntreador * 40.00);
			}
		}
		else {
			if (turno == 1) {
				precio = 35.00;
			}
			else if (turno == 2) {
				precio =  40.00;
			}
			else if (turno == 3){
				precio = 30.00;
			}
			if (taquilla == true) {
				precio = precio + 2.00;
			}
			if (horasEntreador > 0) {
				precio = precio + (horasEntreador * 40.00);
			}
			
		}
		return precio;
	}
	/*metodo calcularPrecio() de manera mas sencilla 
	 @Override
	public double calcularCuotaMensual() {
		double precio = 0.00;
		if (edad > 65) {
			if (turno == 1) {
				 precio = 25.00;
			}
			else if (turno == 2) {
				 precio = 30.00;
			}
			else if (turno == 3){
				 precio = 20.00;
			}
		}
		else {
			if (turno == 1) {
				precio = 35.00;
			}
			else if (turno == 2) {
				precio =  40.00;
			}
			else if (turno == 3){
				precio = 30.00;
			}
			if (taquilla == true) {
				precio = precio + 2.00;
			}
			if (horasEntreador > 0) {
				precio = precio + (horasEntreador * 40.00);
			}
			
		}
		return precio;
	} */

	public boolean cambiarTurno(int turnoNuevo) {
		turno = turnoNuevo;
		return true;
	}
	
}
