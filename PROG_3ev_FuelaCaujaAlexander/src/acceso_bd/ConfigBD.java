package acceso_bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.sqlite.SQLiteConfig;

public class ConfigBD {
	
	private static final String NOMBRE_DRIVER = "org.sqlite.JDBC";
	// TODO: URL de la base de datos transporte ferroviario, creada en SQLite
	private static final String URL_BD = "jdbc:sqlite:data/transporte_ferroviario.db";

	public static Connection abrirConexion() 
	throws ClassNotFoundException, SQLException {
		Class.forName(NOMBRE_DRIVER);
		SQLiteConfig config = new SQLiteConfig();
		config.enforceForeignKeys(true);
		Connection conexion = DriverManager.getConnection(URL_BD, config.toProperties());
		return conexion;
	}

	public static void cerrarConexion(Connection conexion) 
	throws SQLException {
		if (conexion != null && !conexion.isClosed()) {
			conexion.close();
		}
	}
	
}
