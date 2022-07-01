package dao.dao;

import dao.conexion.Conexion;
import dao.dto.Materia;
import listas.Lista;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Implementation of the DAO pattern for the Materia entity.
 */
public class MateriaDao extends AbstractDao<Materia> {
    public MateriaDao() {
    }

    @Override
    public Materia get(int id) {
        Conexion conexion = Conexion.getInstance();

        String sql = "SELECT id, nombre, creditos, fechaexamen FROM materia WHERE id = " + id;

        Materia materia = null;

        try {
            conexion.conectar();
            Statement sentencia = conexion.getConexion().createStatement();
            ResultSet rs = conexion.consulta(sentencia, sql);

            if (rs.next()) {
                materia = new Materia(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("creditos"),
                        rs.getDate("fechaexamen"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.desconectar();
        }

        return materia;
    }

    public Lista<Materia> buscar(String criterio) {
        Conexion conexion = Conexion.getInstance();

        String sql = "SELECT id, nombre, creditos, fechaexamen FROM materia ORDER BY nombre DESC";
        if (criterio != null && !criterio.isEmpty()) {
            sql = "SELECT id, nombre, creditos, fechaexamen FROM materia WHERE nombre like '%" + criterio + "%' ORDER BY nombre DESC";
        }

        Lista<Materia> materias = new Lista<>();

        try {
            conexion.conectar();
            Statement sentencia = conexion.getConexion().createStatement();
            ResultSet rs = conexion.consulta(sentencia, sql);

            while (rs.next()) {
                Materia materia = new Materia(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("creditos"),
                        rs.getDate("fechaexamen"));
                materias.insertar(materia);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.desconectar();
        }

        return materias;
    }

    public void update(Materia materia) {
        Conexion conexion = Conexion.getInstance();

        String sql = "UPDATE materia SET nombre = '" + materia.nombre() + "', creditos = " + materia.creditos() + " WHERE id = " + materia.id();

        try {
            conexion.conectar();
            Statement sentencia = conexion.getConexion().createStatement();
            conexion.ejecutar(sentencia, sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.desconectar();
        }
    }
}
