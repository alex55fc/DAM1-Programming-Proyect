package acceso_bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Clase;

public class AccesoClase {
		
	//caso 1 
	public static List<Clase> consultarTodasClases() throws ClassNotFoundException, SQLException{
		Connection conexion = null;
		List<Clase> listaAux = new ArrayList<>();
		Clase clase;
		 try {
			 conexion = ConfigBD.abrirConexion();
			 String sentenciaSql = "SELECT codigo, nombre, consumo_minimo_anual, porcentaje_adicional FROM clase";
			 PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSql);
			 ResultSet resultadoClase = sentenciaPreparada.executeQuery();
			 
			 while(resultadoClase.next()) {
				 int codigo = resultadoClase.getInt("codigo");
				 String nombre = resultadoClase.getString("nombre");
				 double consumo = resultadoClase.getDouble("consumo_minimo_anual");
				 int porcentaje = resultadoClase.getInt("porcentaje_adicional");
				 clase = new Clase(codigo,nombre,consumo,porcentaje );
				 listaAux.add(clase);
			 }
			 return listaAux;
		 }
		 finally {
			 ConfigBD.cerrarConexion(conexion);
		 }
	}
}
