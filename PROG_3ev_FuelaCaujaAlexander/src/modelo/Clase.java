package modelo;

public class Clase {
	//para el toStringWithSepartor
	private static final String SEPARADOR = ";";
	

	private int codigo;
	private String nombre;
	private double consumoMinimoAnual;
	private int porcentajeAdicional;

	public Clase(int codigo, String nombre, double consumoMinimoAnual, int porcentajeAdicional) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.consumoMinimoAnual = consumoMinimoAnual;
		this.porcentajeAdicional = porcentajeAdicional;
	}
	
	public Clase(int codigo) {
		this.codigo = codigo;	
	}

	@Override
	public String toString() {
		return 
			"Clase [C�digo = " + codigo + 
			", Nombre = " + nombre + 
			", ConsumoM�nimoAnual = " + String.format("%.2f", consumoMinimoAnual) + 
			", PorcentajeAdicional = " + porcentajeAdicional + 
			"]";
	}
	//TOSTRING WITH SEPARATORS
	public String toStringWithSeparators() {
		return this.codigo + SEPARADOR + this.nombre + SEPARADOR + this.consumoMinimoAnual + SEPARADOR 
				+ this.porcentajeAdicional + SEPARADOR;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getConsumoMinimoAnual() {
		return consumoMinimoAnual;
	}

	public void setConsumoMinimoAnual(double consumoMinimoAnual) {
		this.consumoMinimoAnual = consumoMinimoAnual;
	}

	public int getPorcentajeAdicional() {
		return porcentajeAdicional;
	}

	public void setPorcentajeAdicional(int porcentajeAdicional) {
		this.porcentajeAdicional = porcentajeAdicional;
	}

}
