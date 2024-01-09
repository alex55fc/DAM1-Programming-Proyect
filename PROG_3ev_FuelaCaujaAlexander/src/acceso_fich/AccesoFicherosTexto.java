package acceso_fich;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.Billete;
import modelo.Clase;

public class AccesoFicherosTexto {
	public static final String NOMBRE_FICHERO = "data/clases.txt";
	public static final String NOMBRE_FICHERO2 = "data/fechas_y_horas.txt";

	public static boolean escribirEnFichero(List<Clase> listaAux) throws IOException {
		BufferedWriter flujoEscritura = null;
		Boolean booleano= false;
		try {
			flujoEscritura = new BufferedWriter(new FileWriter(NOMBRE_FICHERO));
			for(Clase x : listaAux) {
				flujoEscritura.write(x.toStringWithSeparators());
				flujoEscritura.newLine();
			}
			booleano = true;
		}

		finally {
			if(flujoEscritura != null) {
				flujoEscritura.close();
			}

		}
		return booleano;
	}
	public static List<Billete> importarFichero() throws IOException{
		List<Billete> listaAux = new ArrayList<>();
		BufferedReader flujoLectura = null;
		try {
			flujoLectura = new BufferedReader(new FileReader(NOMBRE_FICHERO2));
			String linea = flujoLectura.readLine();
			while(linea!= null) {
				Billete x = new Billete(linea);
				listaAux.add(x);
				linea = flujoLectura.readLine();
			}
		}
		finally {
			if(flujoLectura != null) {
				flujoLectura.close();
			}

		}
		return listaAux;
	}
}
