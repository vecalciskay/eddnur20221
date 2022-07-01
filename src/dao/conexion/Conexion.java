package dao.conexion;

import java.sql.*;

public class Conexion {
    public static final String URL = "jdbc:mysql://localhost:3306/eddnur";
    public static final String USUARIO = "root";
    public static final String PASSWORD = "root";

    private static Conexion instance;

    private Connection conexion;

    private Conexion() {
    }

    public static Conexion getInstance() {
        if (instance == null) {
            instance = new Conexion();
        }
        return instance;
    }

    public void conectar() throws SQLException {
        conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }

    public Connection getConexion() {
        return conexion;
    }

    public void desconectar()  {
        try {
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet consulta(Statement sentencia, String sql) throws SQLException {
        return sentencia.executeQuery(sql);
    }

    public void ejecutar(Statement sentencia, String sql) throws SQLException {
        sentencia.execute(sql);
    }
}
