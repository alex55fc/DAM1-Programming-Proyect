package acceso;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import modelos.Album;
import modelos.MultiTablaAlbum;

public class ConsultasMultiTabla {
	public static final String NOMBRE_FICHERO3 = "src/FicherosTXT/importarMultitablaAlbum.txt";

    /*Devuelve una lista con la consulta multitabla*/
    public static List<MultiTablaAlbum> consultaMultiTabla() throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        List<MultiTablaAlbum> listaMultiTabla = new LinkedList<>();
        MultiTablaAlbum multiTablaCancion = null;

        try{	
        	conexion = ConfigBD.abrirConexion();
            String sentenciaSQL = "SELECT a.titulo as Album, a.año_publicacion as Fecha_Album, c.titulo as Cancion, c.duracion as Duracion_Cancion " +
                                                "FROM album a " +
                                                "JOIN cancion c ON a.codigo = c.codigo_album " +
                                                "ORDER BY a.año_publicacion asc";
			PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL);
			ResultSet resultadoAlbum = sentenciaPreparada.executeQuery();

            while (resultadoAlbum.next()){
                String tituloAlbum = resultadoAlbum.getString("Album");
                int anioPublicacionAlbum = resultadoAlbum.getInt("Fecha_Album");
                String tituloCancion = resultadoAlbum.getString("Cancion");
                String duracionCancion = resultadoAlbum.getString("Duracion_Cancion");
                multiTablaCancion = new MultiTablaAlbum(tituloAlbum, anioPublicacionAlbum, tituloCancion, duracionCancion);
                listaMultiTabla.add(multiTablaCancion);
            }
            return listaMultiTabla;
        }
        finally {
            ConfigBD.cerrarConexion(conexion);
        }
    } 	
    /*Devuleve verdadero si se escriben los datos la lista de la multitabla en el fichero*/
	public static boolean escribirEnFichero(List<MultiTablaAlbum> listaAux) throws IOException {
		BufferedWriter flujoEscritura = null;
		Boolean booleano= false;
		try {
			flujoEscritura = new BufferedWriter(new FileWriter(NOMBRE_FICHERO3));
			for(MultiTablaAlbum x : listaAux) {
				flujoEscritura.write(x.toString());
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
}
