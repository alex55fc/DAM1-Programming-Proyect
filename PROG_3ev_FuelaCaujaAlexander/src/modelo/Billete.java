package modelo;

public class Billete {
	private static final String SEPARADOR = " ";
	
	private int codigo;
	private Viajero viajero;
	private Estacion estacionOrigen;
	private Estacion estacionDestino;
	private String fecha;
	private String horaSalida;
	private String horaLlegada;
	private double importe;
	
	public Billete(Viajero viajero, Estacion estacionOrigen, Estacion estacionDestino, 
	               String fecha, String horaSalida, String horaLlegada, double importe) {
		this.viajero = viajero;
		this.estacionOrigen = estacionOrigen;
		this.estacionDestino = estacionDestino;
		this.fecha = fecha;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.importe = importe;
	}
	
	public Billete(int codigo, Viajero viajero, Estacion estacionOrigen, Estacion estacionDestino, 
	               String fecha, String horaSalida, String horaLlegada, double importe) {
		this.codigo = codigo;
		this.viajero = viajero;
		this.estacionOrigen = estacionOrigen;
		this.estacionDestino = estacionDestino;
		this.fecha = fecha;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.importe = importe;
	}

	public String toString2() {
		String cadena = "";
		cadena =  cadena + "Fecha "+ this.fecha + ", Hora salida "+ this.horaSalida;
		return cadena;
	}
	@Override
	public String toString() {
		return 
			"Billete [C�digo = " + codigo + ",\n" +
			"         Viajero = " + viajero.toString() + ",\n" + 
			"         Estaci�nOrigen = " + estacionOrigen.toString() + ",\n" + 
			"         Estaci�nDestino = " + estacionDestino.toString() + ",\n" +
			"         Fecha = " + fecha + 
			", HoraSalida = " + horaSalida + 
			", HoraLlegada = " + horaLlegada + 
			", Importe = " + String.format("%.2f", importe) + 
			"]";
	}
	public Billete(String linea) {
		String[] datos = linea.split(SEPARADOR);
		this.fecha = datos[0];
		this.horaSalida = datos[1];
		
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Viajero getViajero() {
		return viajero;
	}

	public void setViajero(Viajero viajero) {
		this.viajero = viajero;
	}

	public Estacion getEstacionOrigen() {
		return estacionOrigen;
	}

	public void setEstacionOrigen(Estacion estacionOrigen) {
		this.estacionOrigen = estacionOrigen;
	}

	public Estacion getEstacionDestino() {
		return estacionDestino;
	}

	public void setEstacionDestino(Estacion estacionDestino) {
		this.estacionDestino = estacionDestino;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public String getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}
	
}
