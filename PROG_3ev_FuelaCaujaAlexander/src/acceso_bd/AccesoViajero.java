package acceso_bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Clase;
import modelo.Viajero;

public class AccesoViajero {
	//caso 2 
	public static List<Viajero> consultarTodasClases() throws ClassNotFoundException, SQLException{
		Connection conexion = null;
		List<Viajero> listaAux = new ArrayList<>();
		Viajero viajero;
		Clase claseAux;
		try {
			conexion = ConfigBD.abrirConexion();
			String sentenciaSql = "SELECT codigo, codigo_clase, nombre, fecha_nacimiento, lugar_residencia, "
					+ " correo, puntos FROM viajero";
			PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSql);
			ResultSet resultadoClase = sentenciaPreparada.executeQuery();

			while(resultadoClase.next()) {
				int codigo = resultadoClase.getInt("codigo");
				int codigoClase = resultadoClase.getInt("codigo_clase");
				String nombre = resultadoClase.getString("nombre");
				String fechaNac = resultadoClase.getString("fecha_nacimiento");
				String lugarResidencia = resultadoClase.getString("lugar_residencia");
				String correo = resultadoClase.getString("correo");
				int puntos = resultadoClase.getInt("puntos");

				claseAux = new Clase(codigoClase);
				viajero = new Viajero(codigo,claseAux,nombre,fechaNac,lugarResidencia, correo, puntos);
				listaAux.add(viajero);
			}
			return listaAux;
		}
		finally {
			ConfigBD.cerrarConexion(conexion);
		}
	}
	public static boolean viajeroCodigo(int codigo) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		try {
			conexion = ConfigBD.abrirConexion();
			String sentenciaSQL = "SELECT * FROM viajero WHERE codigo = (?) ";
			PreparedStatement sentenciaPreparada= conexion.prepareStatement(sentenciaSQL);
			sentenciaPreparada.setInt(1, codigo);
			ResultSet resultadoDepartamento =  sentenciaPreparada.executeQuery();

			if(resultadoDepartamento.next()){
				return true;
			}
			else {
				return false;
			}
		}
		finally {
			ConfigBD.cerrarConexion(conexion);
		}
	}
	public static int actualizarPuntos0(int codigo) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		try {
			conexion = ConfigBD.abrirConexion();
			String sentenciaSQL = "UPDATE viajero set puntos = 0 WHERE codigo = ?";
			PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL);
			sentenciaPreparada.setInt(1, codigo);
			return sentenciaPreparada.executeUpdate();
		}
		finally {
			ConfigBD.cerrarConexion(conexion);
			
		}
	}
	public static Viajero consultarViajero(int codigoAux) throws ClassNotFoundException, SQLException{
		Connection conexion = null;
		Viajero viajero = null;
		Clase claseAux;
		try {
			conexion = ConfigBD.abrirConexion();
			String sentenciaSql = "SELECT codigo, codigo_clase, nombre, fecha_nacimiento, lugar_residencia, "
					+ " correo, puntos FROM viajero WHERE codigo = ? ";
			PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSql);
			sentenciaPreparada.setInt(1, codigoAux);
			ResultSet resultadoClase = sentenciaPreparada.executeQuery();

			while(resultadoClase.next()) {
				int codigo = resultadoClase.getInt("codigo");
				int codigoClase = resultadoClase.getInt("codigo_clase");
				String nombre = resultadoClase.getString("nombre");
				String fechaNac = resultadoClase.getString("fecha_nacimiento");
				String lugarResidencia = resultadoClase.getString("lugar_residencia");
				String correo = resultadoClase.getString("correo");
				int puntos = resultadoClase.getInt("puntos");

				claseAux = new Clase(codigoClase);
				viajero = new Viajero(codigo,claseAux,nombre,fechaNac,lugarResidencia, correo, puntos);
			}
		}
		finally {
			ConfigBD.cerrarConexion(conexion);
		}
		return viajero;
	}
}
