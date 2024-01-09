package modelo;

public class Viajero {

	private int codigo;
	private Clase clase;
	private String nombre;
	private String fechaNacimiento;
	private String lugarResidencia;
	private String correo;
	private int puntos;

	public Viajero(Clase clase, String nombre, String fechaNacimiento, 
			String lugarResidencia, String correo, int puntos) {
		this.clase = clase;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.lugarResidencia = lugarResidencia;
		this.correo = correo;
		this.puntos = puntos;
	}

	public Viajero(int codigo, Clase clase, String nombre, String fechaNacimiento, 
			String lugarResidencia, String correo, int puntos) {
		this.codigo = codigo;
		this.clase = clase;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.lugarResidencia = lugarResidencia;
		this.correo = correo;
		this.puntos = puntos;
	}

	//necesario caso 3
	public Viajero(int codigo) {
		this.codigo = codigo;
		
	}
	@Override
	public String toString() {
		return 
				"Viajero [C�digo = " + codigo + ",\n" +
				"         Clase = " + clase.getCodigo() + ",\n" + 
				"         Nombre = " + nombre + 
				", FechaNacimiento = " + fechaNacimiento + 
				", LugarResidencia = " + lugarResidencia + 
				", Correo = " + correo + 
				", Puntos = " + puntos	+ 
				"]";
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Clase getClase() {
		return clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getLugarResidencia() {
		return lugarResidencia;
	}

	public void setLugarResidencia(String lugarResidencia) {
		this.lugarResidencia = lugarResidencia;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

}
