import java.util.Random;

import entrada.Teclado;

public class Ejercicio3 {

	public static void escribirMenuOpciones() {
		System.out.println();
		System.out.println("(0) Salir del programa ");
		System.out.println("(1) Leer por teclado uma ficha de dominó valida. ");
		System.out.println("(2) Escrribir em consola la ficha de domino ");
		System.out.println("(3) Calcular la puntuacion de la ficha de dominó y determinar si la ficha de dominó es doble ");
		System.out.println("(4) Determinar si la ficha de dominó puede colocarse al lado de otra ficha de dominó ");
		System.out.println("(5) Generar todas las fichas de dominó posibles sin repeticiones. ");
		System.out.println();
	}

	public static void main(String[] args) {
		int extremo1, extremo2;
		int opcion;
		FichaDomino ficha1 = null;
		FichaDomino fichaTeclado = null;
		FichaDomino fichaAleatoria = null,
		ficha;
		Random aleatorio = new Random();

		do {
			escribirMenuOpciones();
			opcion = Teclado.leerEntero("Escribe la opccion: ");
			switch(opcion) {

			// salir del programa
			case 0:
				break;

				//Leer por teclado uma ficha de dominó valida.
			case 1:
				extremo1 = Teclado.leerEntero("¿Extremo 1? ");
				extremo2 = Teclado.leerEntero("¿Extremo 2? ");
				while(!FichaDomino.esValida(extremo1, extremo2)) {
					System.out.println("Los datos de la ficha de domino no son validos.");
					System.out.println("El primer extremo debe estar comprendido entre 0 y 6");
					System.out.println("El segundo extremo debe estar comprendido entre 0 y 6.");
					extremo1 = Teclado.leerEntero("¿Extremo 1? ");
					extremo2 = Teclado.leerEntero("¿Extremo 2? ");
				}
				ficha1 = new FichaDomino(extremo1, extremo2);
				System.out.println("Se ha creado una ficha de dominó valida.");
				break;
				//Escrribir em consola la ficha de domino
			case 2:
				if (ficha1 == null) {
					System.out.println("No existe ninguna ficha de dominó");
				}
				else {
					System.out.println("FichaDominó " +ficha1.obtenerEstado());
				}
				break;
				// Calcular la puntuacion de la ficha de dominó y determinar si la ficha de dominó es doble
			case 3:
				if (ficha1 == null) {
					System.out.println("No existe ninguna ficha de domino valida creada");
				}
				else {
					if (ficha1.esdoble()) {
						System.out.println("Es doble: true" );
					}
					else {
						System.out.println("Es doble: false");
					}
				System.out.println("Puntuacion: "+ ficha1.calcularPuntuacion());
				}
				break;				
				//Determinar si la ficha de dominó puede colocarse al lado de otra ficha de dominó
			case 4:
				if (ficha1 == null) {
					System.out.println("No existe ninguna ficha de dominó válida creada");
				}
				else {
					extremo1 = aleatorio.nextInt(7);
					extremo2 = aleatorio.nextInt(7);
					fichaAleatoria = new FichaDomino(extremo1, extremo2);
					System.out.print(fichaTeclado.obtenerEstado());
					
					if (fichaTeclado.puedeColocarseAlLado(fichaAleatoria)) {
						System.out.println("no puede");
					}
					else {
						System.out.println("puede ");
					}
				}
				break;
				
				//Generar todas las fichas de dominó posibles sin repeticiones
			case 5:
				for (extremo2 = 0 ; extremo2 <= 6 ; extremo2++) {
					for (extremo1 = 0 ; extremo1 <= extremo2 ; extremo1++) {
						ficha = new FichaDomino(extremo1, extremo2);
						System.out.println(ficha.obtenerEstado() + " ");
					}
					System.out.println();
				}
				break;
				
			default:
				System.out.println("La opcion de menú debe estar comprendida entre 0 y 5.");
				break;

			}

		}while(opcion != 0);
		System.out.println("Programa finalizado.");

	}

}
/*errores:
 * 	clase FichaDomino:
 * suma de los extremos no bien definida
 *  programa principal:
 *  generar de manera aleatoria las fichas
 */

