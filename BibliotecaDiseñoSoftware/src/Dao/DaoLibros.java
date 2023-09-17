/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Conexion.Conexion_db;
import Modelo.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author val
 */
public class DaoLibros {

    public void agregarLibro(Libro libro) throws SQLException {
        try {
            PreparedStatement ps = null;
            Conexion_db conn = new Conexion_db();
            Connection con = conn.getConexion();

            String sql = "INSERT INTO libros (ID, nombre, autor, anioPublicacion, cantidadCopias, ID_Generos) VALUES (?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, libro.getId());
            ps.setString(2, libro.getNombre());
            ps.setString(3, libro.getAutor());
            ps.setInt(4, libro.getAnioPublicacion());
            ps.setInt(5, libro.getCantidadCopias());
            ps.setInt(6, libro.getIdGenero());
            ps.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException();
        }
    }

    public Libro buscarLibro(int ID) throws SQLException {
        Libro libroEncontrado = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Conexion_db conn = new Conexion_db();
        org.mariadb.jdbc.Connection con = conn.getConexion();

        String where = " WHERE ID = '" + ID + "'";
        String sql = "SELECT * FROM libros" + where;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String autor = rs.getString("autor");
                int anioPublicacion = rs.getInt("anioPublicacion");
                int cantidadCopias = rs.getInt("cantidadCopias");
                int ID_Genero = rs.getInt("ID_Genero");

                libroEncontrado = new Libro(ID, nombre, autor, anioPublicacion, cantidadCopias, ID_Genero);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException();
        }
        return libroEncontrado;

    }

    public void editarLibro(int id, String nombre, String autor, int anioPublicacion, int cantidadCopias, int ID_Genero) throws SQLException {
        PreparedStatement ps = null;
        Conexion_db obConexion_db = new Conexion_db();
        Connection conn = obConexion_db.getConexion();
        try {
            String sql = "UPDATE libros SET ID=?, nombre=?, autor=?, anioPublicacion=?, cantidadCopias=?, ID_Generos=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.setString(3, autor);
            ps.setInt(4, anioPublicacion);
            ps.setInt(5, cantidadCopias);
            ps.setInt(6, ID_Genero);

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException();
        }
    }

    public void eliminarLibro(int id) throws SQLException {
        PreparedStatement ps = null;

        try {

            Conexion_db objCon = new Conexion_db();
            Connection conn = objCon.getConexion();
            ps = conn.prepareStatement("DELETE FROM libros WHERE ID= '" + id + "'");
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException();
        }
    }

    public ArrayList<Libro> listaLibros() throws SQLException {
        ArrayList<Libro> libros = new ArrayList<>();

        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion_db conn = new Conexion_db();
            Connection con = conn.getConexion();
            String sql = "SELECT * FROM libros";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nombre = rs.getString("nombre");
                String autor = rs.getString("autor");
                int anioPublicacion = rs.getInt("anioPublicacion");
                int cantidadCopias = rs.getInt("cantidadCopias");
                int ID_Genero = rs.getInt("ID_Genero");

                Libro libro = new Libro(id, nombre, autor, anioPublicacion, cantidadCopias, ID_Genero);
                libros.add(libro);
            }
            
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException();
        }
        return libros;
    }
}
