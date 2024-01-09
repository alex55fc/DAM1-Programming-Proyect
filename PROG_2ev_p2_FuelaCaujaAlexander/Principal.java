import java.util.List;

import entrada.Teclado;

public class Principal {
	//unicos errores 1- hacer mal el 10% de socio premium. No esta arreglado
	//2-No actualizo el el socio basico a socio Premium. No esta arreglado hacerlo con las instrucciones 
	//3-las clases tienen que empezar con MAYUSCULAS
	public static void escribirMenu() {
		System.out.println();
		System.out.println("(0) Salir del programa");
		System.out.println("(1) Dar de alta un socio premium en el club");
		System.out.println("(2) Dar de alta un socio basico en el club ");
		System.out.println("(3) Consultar todos los socios del club ordenados por DNI de forma ascendente" );
		System.out.println("(4) Cambia el turno a un socio basico, por Dni, del club");
		System.out.println("(5) Consultar los DNI de los socios premium del club que tienen carnet de estudiante");
		System.out.println("(6) Consultar los socios que pagan la cuota mensual mas alta del club");
		System.out.println("(7) Cambiar un socio basico, por DNI, a socio premium");
		System.out.println();
	}
	
	public static void escribirListaSocios(List<Socio> listaSocios ) {
		for (int pos = 0; pos < listaSocios.size(); pos++) {
			Socio socio = listaSocios.get(pos);
			System.out.println("("+pos+")" + socio.toString());
		}
		System.out.println("Se han consultado "+ listaSocios.size()+ " socios en el club");
	}
	public static void escribirListaSociosDnis(List<Socio> listaSocios ) {
		for (int pos = 0; pos < listaSocios.size(); pos++) {
			Socio socio = listaSocios.get(pos);
			String frase = socio.getDni();
			System.out.println("("+pos+")" + frase);
		}
		System.out.println("Se han consultado "+ listaSocios.size()+ " socios premium con carnet de estudiante en el club");
	}
	
	public static void main(String[] args) {
		int opcion;
		List<Socio> listaAux;
		Socio socio;
		ClubDeportivo clubDeportivo = new ClubDeportivo("club ALEX");
		//caso 1
		String dni, nombre;
		int edad, horasEntreador;
		boolean carnetEstudiante;
		//caso 2
		boolean taquilla;
		int turno;
		//caso 4
		SocioBasico socioBasico;
		
		do {
			escribirMenu();
			opcion = Teclado.leerEntero("Elige una opcion.");
			switch(opcion) {
			case 0:
				break;
				//----------------
			case -1:
				System.out.println(clubDeportivo.toString());
				break;
			case 1:
				//Dar de alta un socio premium en el club
				dni = Teclado.leerCadena("dni ");
				socio = clubDeportivo.consultar(dni);
				if (socio == null) {
					nombre = Teclado.leerCadena("nombre ");
					edad = Teclado.leerEntero("edad ");
					horasEntreador = Teclado.leerEntero("horas del entrenador ");
					carnetEstudiante = Teclado.leerBooleano("tiene carnet de estudiantne?");
					socio = new SocioPremium(dni, nombre, edad, horasEntreador,carnetEstudiante );
					if(clubDeportivo.insertarSocio(socio)) {
						System.out.println("Se ha insertado en el club un socio premium");
					}
					else {
						System.out.println("No se pude insertar el socio premim");
					}
				}
				else {
					System.out.println("Socio encontrado con ese DNI");
				}
				break;
				//----------------
			case 2:
				// Dar de alta un socio basico en el club 
				dni = Teclado.leerCadena("dni ");
				socio = clubDeportivo.consultar(dni);
				if (socio == null) {
					nombre = Teclado.leerCadena("nombre ");
					edad = Teclado.leerEntero("edad ");
					horasEntreador = Teclado.leerEntero("horas del entrenador ");
					taquilla = Teclado.leerBooleano("tiene taquilla ?");
					turno = Teclado.leerEntero("Elige un turno 1-mañanas, 2-tardes o 3-mediodia");
					socio = new SocioBasico(dni, nombre, edad, horasEntreador,taquilla, turno);
					if(clubDeportivo.insertarSocio(socio)) {
						System.out.println("Se ha insertado en el club un socio basico");
					}
					else {
						System.out.println("No se pude insertar el socio basico");
					}
				}
				else {
					System.out.println("Socio encontrado con ese DNI");
				}
				break;
				//----------------
			case 3:
				//Consultar todos los socios del club ordenados por DNI de forma ascendente
				listaAux = clubDeportivo.ordenPorDniAsc();
				if (listaAux.isEmpty()) {
					System.out.println("No hay ningun socio en el club");
				}
				else {
					escribirListaSocios(listaAux);
				}
				break;
				//----------------
			case 4:
				dni = Teclado.leerCadena("Dni del socio ");
				socio = clubDeportivo.consultar(dni);
				if (socio == null) {
					System.out.println("No se encontro un socio con ese Dni");
				}
				else if (socio instanceof SocioBasico) {
					turno = Teclado.leerEntero("Elige el turno al que cambiaras al socio 1-mañanas, 2-tardes o 3-mediodia");
					socioBasico = (SocioBasico) socio;
					if(socioBasico.cambiarTurno(turno)) {
						System.out.println("Se ha actualizado el turno de un socio basico del club");
					}
					else {
						System.out.println("No se pudo cambiar el turno del socio basico");
					}
					
				}
				else {
					System.out.println("El socio no es un socio basico");
				}
				break;
				//----------------
			case 5:
				listaAux = clubDeportivo.socioPremCarnet();
				if (listaAux.isEmpty()) {
					System.out.println("No hay socios premium que tengan carnets de estudiantes");
				}
				else {
					escribirListaSociosDnis(listaAux);
				}
				break;
				//----------------
			case 6:
				listaAux = clubDeportivo.cuotaMensualMasAlta();
				if (listaAux.isEmpty()) {
					System.out.println("No hay ningun socio en la lista");
				}
				else {
					escribirListaSocios(listaAux);
				}
				break;
				//----------------
			case 7:
				dni = Teclado.leerCadena("dni ");
				socio = clubDeportivo.consultar(dni);
				if (socio != null) {
					if(socio instanceof SocioBasico){
						carnetEstudiante = Teclado.leerBooleano("tiene carnet de estudiantne?");
						socio = new SocioPremium(dni, socio.getNombre(), socio.getEdad(), socio.getHorasEntreador(),carnetEstudiante );
						//hacer un metodo remover donde buscamos el socio por dni y luego simplemente lo eliminamos
						if (clubDeportivo.insertarSocio(socio)) {
							System.out.println("se ha actualizado el socio basico a socio premium");
						}
					}
					else {
						System.out.println("El dni pertenece a un socio que no es SocioBasico");
					}
				}
				else {
					System.out.println("No se encontro ningun socio con ese dni");
				}
				break;
				//----------------
			default:
				System.out.println("Elige una opcion correcta");
				break;
				
			}
		}while (opcion != 0);
	}


}
