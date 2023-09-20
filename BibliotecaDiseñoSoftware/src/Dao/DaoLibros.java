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
                int ID_Genero = rs.getInt("ID_Generos");

                libroEncontrado = new Libro(ID, nombre, autor, anioPublicacion, cantidadCopias, ID_Genero);
            }

        } catch (SQLException ex) {
            throw new SQLException();
        }
        return libroEncontrado;

    }

    public void editarLibro(int id, String nombre, String autor, int anioPublicacion, int cantidadCopias, int ID_Genero) throws SQLException {
    PreparedStatement ps = null;
    Conexion_db obConexion_db = new Conexion_db();
    Connection conn = obConexion_db.getConexion();
    try {
        String sql = "UPDATE libros SET nombre=?, autor=?, anioPublicacion=?, cantidadCopias=?, ID_Generos=? WHERE ID=?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, nombre);
        ps.setString(2, autor);
        ps.setInt(3, anioPublicacion);
        ps.setInt(4, cantidadCopias);
        ps.setInt(5, ID_Genero);
        ps.setInt(6, id);
        ps.executeUpdate(); 
    } catch (SQLException ex) {
        ex.printStackTrace(); // 
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
            String sql = "SELECT l.ID, l.nombre, l.autor, l.anioPublicacion, l.cantidadCopias, g.nombre as Nombre_generos " +
                     "FROM libros l " +
                     "INNER JOIN generos as g ON l.ID_Generos = g.ID";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nombre = rs.getString("nombre");
                String autor = rs.getString("autor");
                int anioPublicacion = rs.getInt("anioPublicacion");
                int cantidadCopias = rs.getInt("cantidadCopias");
                String nombreGenero = rs.getString("Nombre_generos");

                Libro libro = new Libro(id, nombre, autor, anioPublicacion, cantidadCopias, nombreGenero);
                libros.add(libro);
            }
            
            
        } catch (SQLException ex) {
            throw new SQLException();
        }
        System.out.println(libros);
        return libros;
    }
}
