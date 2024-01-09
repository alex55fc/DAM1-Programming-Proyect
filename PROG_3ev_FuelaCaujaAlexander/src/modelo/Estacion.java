package modelo;

public class Estacion {
	
	private int codigo;
	private String nombre;
	private String ubicacion;
	private int agnoInauguracion;
	private int vias;
	
	public Estacion(String nombre, String ubicacion, 
	                int agnoInauguracion, int vias) {
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.agnoInauguracion = agnoInauguracion;
		this.vias = vias;
	}
	
	public Estacion(int codigo, String nombre, String ubicacion, 
	                int agnoInauguracion, int vias) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.ubicacion = ubicacion;
		this.agnoInauguracion = agnoInauguracion;
		this.vias = vias;
	}
	
	public Estacion(int codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public String toString() {
		return 
			"Estación [Código = " + codigo + 
			", Nombre = " + nombre + 
			", Ubicación = " + ubicacion + 
			", AñoInauguración = " + agnoInauguracion + 
			", Vías = " + vias + 
			"]";
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

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getAgnoInauguracion() {
		return agnoInauguracion;
	}

	public void setAgnoInauguracion(int agnoInauguracion) {
		this.agnoInauguracion = agnoInauguracion;
	}

	public int getVias() {
		return vias;
	}

	public void setVias(int vias) {
		this.vias = vias;
	}
	
}
