import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClubDeportivo {

	//atributos 
	private String nombre;
	private List<Socio> listaSocios;
	
	//constructor
	public ClubDeportivo(String nombre) {
		this.nombre = nombre;
		this.listaSocios = new ArrayList<Socio>();
	}
	//toString 
	@Override 
	public String toString() {
		String cadena = ""+ nombre + "\n";
		if(listaSocios.isEmpty()) {
			System.out.println("El club esta vacia.");
		}
		else {
			for(int pos = 0 ; pos < listaSocios.size(); pos++) {
				Socio socio = listaSocios.get(pos);
				cadena = cadena + "("+pos+")"+ socio.toString()	+ "\n";
			}
			cadena = cadena + "Socios consultados"+ listaSocios.size();
		}
		return cadena;
	}
	//consultar por dni si hay algun dni repetido 
	public Socio consultar (String dni) {
		for(Socio socio : listaSocios) {
			if(socio.getDni().equals(dni)) {
				return socio;
			}
		}
		return null;
	}
	//1-insertar socio 
	public boolean insertarSocio(Socio socio) {
		return listaSocios.add(socio);
	}
	
	//2-consultar todos socios ordenador por DNi asc
	public List<Socio> ordenPorDniAsc(){
		List<Socio> listaAux = new ArrayList<>();
		listaAux.addAll(listaSocios);
		Collections.sort(listaAux, new OrdenSociosDniAsc());
		return listaAux;
	}
	//5- lista con los DNI unicamente de los socios premium con carnet de estudiantes 
	public List<Socio> socioPremCarnet(){
		List<Socio> listaAux = new ArrayList<>();
		for (Socio socio : listaSocios) {
			if (socio instanceof SocioPremium) {
				SocioPremium socioPremium = (SocioPremium)socio;
				if(socioPremium.isCarnetEstudiante() == true) {
					listaAux.add(socioPremium);
				}
			}
		}
		return listaAux;
	}
	//6-socios con ola cuto mensual mas alta 
	public List<Socio> cuotaMensualMasAlta(){
		List<Socio> listaAux = new ArrayList<>();
		double cuotaMax = 0.00;
		for (Socio socio : listaSocios) {
			double cuotaSocio = socio.calcularCuotaMensual();
			if(cuotaSocio > cuotaMax) {
				cuotaMax = cuotaSocio;
			}
		}
		for (Socio socio : listaSocios) {
			double cuotaSocio = socio.calcularCuotaMensual();
			if(cuotaSocio == cuotaMax) {
				listaAux.add(socio);
			}
		}
		return listaAux;
	}
	//7-eliminar socio basico 
		
}
