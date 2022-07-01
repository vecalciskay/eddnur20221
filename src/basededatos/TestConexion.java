package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * mysql> create table materia (id int primary key,
 *     -> nombre varchar(200),
 *     -> creditos int,
 *     -> fechaexamen datetime);
 * Query OK, 0 rows affected (0.84 sec)
 *
 * mysql> show tables;
 * +------------------+
 * | Tables_in_eddnur |
 * +------------------+
 * | materia          |
 * +------------------+
 * 1 row in set (0.01 sec)
 *
 * mysql> select * from materia;
 * Empty set (0.09 sec)
 *
 * mysql> insert into materia (id, nombre, creditos, fechaexamen)
 *     -> values (1, 'Estructura de Datos',4,'2022-07-07');
 * Query OK, 1 row affected (0.13 sec)
 *
 * mysql> select * from materia;
 * +----+---------------------+----------+---------------------+
 * | id | nombre              | creditos | fechaexamen         |
 * +----+---------------------+----------+---------------------+
 * |  1 | Estructura de Datos |        4 | 2022-07-07 00:00:00 |
 * +----+---------------------+----------+---------------------+
 * 1 row in set (0.00 sec)
 */
public class TestConexion {
    public static void main(String[] args) {

        Connection conn1 = null;

        try {
            // connect way #1
            String url1 = "jdbc:mysql://localhost:3306/eddnur";
            String user = "root";
            String password = "root";

            conn1 = DriverManager.getConnection(url1, user, password);
            if (conn1 != null) {
                System.out.println("Connected to the database test1");
            }

            String query = "select id, nombre, creditos, fechaexamen from materia";

            Statement stmt = conn1.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int creditos = rs.getInt("creditos");
                String fechaexamen = rs.getString("fechaexamen");

                System.out.println("id: " + id + ", nombre: " + nombre + ", creditos: " + creditos + ", fechaexamen: " + fechaexamen);
            }
        } catch(Exception q) {
            System.out.println("Error: " + q.getMessage());
        } finally {
            if (conn1 != null) {
                try {
                    conn1.close();
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }
}
