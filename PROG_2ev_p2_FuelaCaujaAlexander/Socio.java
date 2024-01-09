import java.util.Objects;

public abstract class Socio {
	//atributps 
	protected String dni; //unico
	protected String nombre;
	protected int edad;
	protected int horasEntreador;
	
	//constructor 
	public Socio(String dni, String nombre, int edad, int horasEntreador) {
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.horasEntreador = horasEntreador;
	}
	//toString 

	@Override
	public String toString() {
		return "Socio [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + ", horasEntreador=" + horasEntreador
				+ calcularCuotaMensual()+ "]";
	}
	
	//
	public abstract double calcularCuotaMensual();

	//get y set 
	
	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public int getHorasEntreador() {
		return horasEntreador;
	}

	public String getDni() {
		return dni;
	}
	
	//para consultar por dni
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Socio)) {
			return false;
		}
		Socio other = (Socio) obj;
		return Objects.equals(dni, other.dni);
	}
			
}
