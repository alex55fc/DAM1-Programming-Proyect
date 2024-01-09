package acceso_bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import modelo.Billete;

public class AccesoBillete {
	public static boolean insertarBillete(Billete billete) throws SQLException, ClassNotFoundException {
		Connection conexion = null;
		boolean booleano = false;
		try {
			conexion = ConfigBD.abrirConexion();
			String sentenciaSQL ="INSERT INTO billete (codigo_viajero, codigo_estacion_origen, codigo_estacion_destino, fecha, hora_salida, hora_llegada, importe) "
					+"VALUES (?, ?, ?, ?, ? ,? , ?)";
			PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL);
			sentenciaPreparada.setInt(1, billete.getViajero().getCodigo());
			sentenciaPreparada.setInt(2,billete.getEstacionOrigen().getCodigo());
			sentenciaPreparada.setInt(3,billete.getEstacionDestino().getCodigo());
			sentenciaPreparada.setString(4,billete.getFecha());
			sentenciaPreparada.setString(5,billete.getHoraSalida());
			sentenciaPreparada.setString(6,billete.getHoraLlegada());
			sentenciaPreparada.setDouble(7, billete.getImporte());
			sentenciaPreparada.executeUpdate();
			booleano = true;
		}
		finally {
			ConfigBD.cerrarConexion(conexion);
		}
		return booleano;
	}
	public static int anularBilletes(List<Billete> listaAux) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		try {
			int lineasEliminadas = 0;
			conexion = ConfigBD.abrirConexion();
			for(Billete x : listaAux) {
				String sentenciaSql = "DELETE FROM billete WHERE fecha = ? AND hora_salida = ?";
				PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSql);
				sentenciaPreparada.setString(1, x.getFecha());
				sentenciaPreparada.setString(2, x.getHoraSalida());
				if(sentenciaPreparada.executeUpdate() == 1) {
					lineasEliminadas ++;

				}
			}
			return lineasEliminadas;
		}
		finally {
			ConfigBD.cerrarConexion(conexion);
		}
	}
}
