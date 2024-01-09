package principal;

import java.util.List;

import acceso_bd.AccesoBillete;
import acceso_bd.AccesoClase;
import acceso_bd.AccesoEstacion;
import acceso_bd.AccesoViajero;
import acceso_fich.AccesoFicherosTexto;
import entrada.Teclado;
import modelo.Billete;
import modelo.Clase;
import modelo.Estacion;
import modelo.Viajero;


public class GestionPrincipal {


	public static void escribirMenuOpcionesPrincipal() {
		System.out.println();
		System.out.println("*********** MENښ PRINCIPAL ***********");
		System.out.println("(0) Salir del programa.");
		System.out.println("(1) Exportar todas las CLASES a un fichero."); 
		System.out.println("(2) Reiniciar los puntos de un VIAJERO a 0, por c�digo."); 
		System.out.println("(3) Sacar un BILLETE a un VIAJERO."); 
		System.out.println("(4) Anular los BILLETES seg�n fechas y horas de salida indicadas en un fichero.");
		System.out.println();
	}
	
	public static void main(String[] args) {
		int opcion;
		Estacion estacion2;
		//caso 1
		List<Clase> listaAux;
		//caso 2
		List<Viajero> listaAux2;
		Viajero viajero;
		int codigo, filas;
		//caso 3
		List<Estacion> listaAux3;
		int estacionOrigen, estacionDestino;
		String fecha, horaSalida, horaLlegada;
		double importe;
		Estacion estacion;
		Billete billete;
		//caso 4
		List<Billete> listaAux4;
		do {
			escribirMenuOpcionesPrincipal();
			opcion = Teclado.leerEntero("�Opci�n? ");
			try {
				switch (opcion) {
				// Salir del programa.
				case 0:
					System.out.println("Programa finalizado.");
					break;
					
				// TODO: Exportar todas las CLASES a un fichero.
				case 1:
					listaAux = AccesoClase.consultarTodasClases();
					if(AccesoFicherosTexto.escribirEnFichero(listaAux)) {
						System.out.println("Se han exportado " + listaAux.size()+ " clases al fichero");
					}
					else {
						System.out.println("Error no se pudo insertar los datos al fichero");
					}
					
					break;
							
				// TODO: Reiniciar los puntos de un VIAJERO a 0, por c�digo.
				case 2:
					System.out.println("\n*********** REINICIAR PUNTOS DE VIAJERO ***********");
					listaAux2 = AccesoViajero.consultarTodasClases();
					for(Viajero x : listaAux2) {
						System.out.println(x.toString());
					}
					codigo = Teclado.leerEntero("Elige un viajero al que reiniciar los puntos ");
					if(AccesoViajero.viajeroCodigo(codigo)) {
						filas = AccesoViajero.actualizarPuntos0(codigo);
						if(filas > 0) {
							System.out.println("Se han actualizado los puntos de un viajero");
						}
						else {
							System.out.println("No se ha encontrado ningun viajero con ese codigo");
						}
					}
					else {
						System.out.println("No se ha encontrado ningun viajero con ese codigo");
					}
					break;
					
				// TODO: Sacar un BILLETE a un VIAJERO.
				case 3:
					System.out.println("\n*********** SACAR BILLETE A VIAJERO ***********");
					codigo = Teclado.leerEntero("Elige un viajero ");
					if(AccesoViajero.viajeroCodigo(codigo)) {
						viajero = AccesoViajero.consultarViajero(codigo);
						System.out.println(viajero.toString());
						listaAux3 = AccesoEstacion.consultarTodasEstaciones();
						for(Estacion x : listaAux3) {
							System.out.println(x.toString());
						}
						estacionOrigen = Teclado.leerEntero("Escoge tu estacion de origen ");
						estacionDestino = Teclado.leerEntero("Escoge tu estacion de destino ");
						fecha = Teclado.leerCadena("Fecha en formato dd/mm/yyyy ");
						horaSalida = Teclado.leerCadena("Hora salida en formato HH:MM ");
						horaLlegada = Teclado.leerCadena("Hora llegada en formato HH:MM ");
						importe = Teclado.leerReal("Importe ");
						
						viajero = new Viajero(codigo);
						estacion = new Estacion(estacionOrigen);
						estacion2 = new Estacion(estacionDestino);
						
						billete = new Billete(viajero,estacion, estacion2, fecha,horaSalida, horaLlegada, importe );
						if(AccesoBillete.insertarBillete(billete)) {
							System.out.println("Se ha insertado un billete con codigo ");
						}
						else {
							System.out.println("Error al sacar un billete para el viajero. ");
						}
					}
					else {
						System.out.println("No se ha encontrado ningun viajero con ese codigo");
					}
					break;
					
				// TODO: Anular los BILLETES seg�n fechas y horas de salida indicadas en un fichero.
				case 4:
					System.out.println("\n*********** ANULAR BILLETES SEG�N FECHAS Y HORAS DE SALIDA DE FICHERO ***********");
					listaAux4 = AccesoFicherosTexto.importarFichero();
					//esto es de prueba 
					for(Billete x : listaAux4) {
						System.out.println(x.toString2());
					}
					filas = AccesoBillete.anularBilletes(listaAux4);
					if (filas >= 0) {
						System.out.println("Se han eliminado "+ filas + " billetes");
					}
					break;
					
				default:
					System.out.println("La opci�n de men� debe estar comprendida entre 0 y 4.");
				}
			}
			catch (Exception e) {
				System.out.println("Error al acceder al fichero de texto o a la base de datos.");
				e.printStackTrace();
			}
		}
		while (opcion != 0);
	}
	
}
