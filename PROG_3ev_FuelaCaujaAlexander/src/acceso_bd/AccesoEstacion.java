package acceso_bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Estacion;

public class AccesoEstacion {

	public static List<Estacion> consultarTodasEstaciones() throws ClassNotFoundException, SQLException{
		Connection conexion = null;
		List<Estacion> listaAux = new ArrayList<>();
		Estacion estacion;
		try {
			 conexion = ConfigBD.abrirConexion();
			 String sentenciaSql = "SELECT codigo, nombre, ubicacion, agno_inauguracion , vias FROM estacion";
			 PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSql);
			 ResultSet resultadoClase = sentenciaPreparada.executeQuery();
			 
			 while(resultadoClase.next()) {
				 int codigo = resultadoClase.getInt("codigo");
				 String nombre = resultadoClase.getString("nombre");
				 String ubicacion = resultadoClase.getString("ubicacion");
				 int agnoInaugura = resultadoClase.getInt("agno_inauguracion");
				 int vias = resultadoClase.getInt("vias");

				 estacion = new Estacion(codigo,nombre,ubicacion,agnoInaugura,vias );
				 listaAux.add(estacion);
			 }
			 return listaAux;
		 }
		 finally {
			 ConfigBD.cerrarConexion(conexion);
		 }
	}
}
