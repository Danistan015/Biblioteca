/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Conexion.Conexion_db;
import Controlador.ControladorUsuario;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author val
 */
public class DaoUsuarios {

    public void agregarUsuario(Usuario usuario) throws SQLException {
        try {
            PreparedStatement ps = null;
            Conexion_db conn = new Conexion_db();
            Connection con = conn.getConexion();

            String sql = "INSERT INTO usuarios (nombre, cedula, edad, telefono, correo, contrasenia) VALUES (?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setInt(2, usuario.getCedula());
            ps.setInt(3, usuario.getEdad());
            ps.setString(4, usuario.getTelefono());
            ps.setString(5, usuario.getCorreo());
            ps.setString(6, usuario.getContrasenia());
            ps.execute();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException();
        }
    }

    public Usuario buscarUsuarioCorreo(String correo) throws SQLException {
        // Declara las variables para preparar y ejecutar la consulta SQL
        Usuario usuarioEncontrado = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        // Crea un objeto de conexión a la base de datos usando la clase previamente definida: ConeccionDB
        Conexion_db conn = new Conexion_db();

        // Obtiene una conexión activa a la base de datos
        org.mariadb.jdbc.Connection con = conn.getConexion();

        // Definir la consulta SQL a ejecutar
        String where = " WHERE correo = '" + correo + "'";
        String sql = "SELECT * FROM usuarios" + where;

        // Preparar la consulta SQL para su ejecución, esto ayuda a prevenir la inyección SQL
        try {
            ps = con.prepareStatement(sql);
            // Ejecuta la consulta y guarda el resultado en la variable rs
            rs = ps.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int cedula = rs.getInt("cedula");
                int edad = rs.getInt("edad");
                String telefono = rs.getString("telefono");
                String contrasenia = rs.getString("contrasenia");

                usuarioEncontrado = new Usuario(nombre, cedula, edad, telefono, correo, contrasenia);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException();
        }
        return usuarioEncontrado;
    }

    public Usuario buscarUsuarioCedula(int cedula) throws SQLException {
        Usuario usuarioEncontrado = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        // Crea un objeto de conexión a la base de datos usando la clase previamente definida: ConeccionDB
        Conexion_db conn = new Conexion_db();

        // Obtiene una conexión activa a la base de datos
        org.mariadb.jdbc.Connection con = conn.getConexion();

        // Definir la consulta SQL a ejecutar
        String where = " WHERE cedula = '" + cedula + "'";
        String sql = "SELECT * FROM usuarios" + where;

        // Preparar la consulta SQL para su ejecución, esto ayuda a prevenir la inyección SQL
        try {
            ps = con.prepareStatement(sql);
            // Ejecuta la consulta y guarda el resultado en la variable rs
            rs = ps.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                String contrasenia = rs.getString("contrasenia");

                usuarioEncontrado = new Usuario(nombre, cedula, edad, telefono, correo, contrasenia);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException();
        }
        return usuarioEncontrado;
    }

    public void editarUsuario(String nombre, int cedula, int edad, String telefono, String correo, String contrasenia) throws SQLException {
        PreparedStatement ps = null;
        Conexion_db obConexion_db = new Conexion_db();
        Connection conn = obConexion_db.getConexion();
        try {
            ps = conn.prepareStatement("UPDATE usuarios SET nombre=?,edad=?,telefono=?, correo=?, contrasenia=? WHERE cedula=?");
            ps.setString(1, nombre);
            ps.setInt(2, edad);
            ps.setString(3, telefono);
            ps.setString(4, correo);
            ps.setString(5, contrasenia);
            ps.setInt(6, cedula);
            ps.execute();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException();
        }
    }

    public void eliminarUsuario(int cedula) throws SQLException {
        PreparedStatement ps = null;

        try {

            Conexion_db objCon = new Conexion_db();
            Connection conn = objCon.getConexion();
            ps = conn.prepareStatement("DELETE FROM usuarios WHERE cedula= '" + cedula + "'");
            ps.setInt(1, cedula);
            ps.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException();
        }
    }

    public ArrayList<Usuario> listaUsuarios() throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion_db conn = new Conexion_db();
            Connection con = conn.getConexion();
            String sql = "SELECT * FROM usuarios";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                String nombre = rs.getString("nombre");
                int cedula = rs.getInt("cedula");
                int edad = rs.getInt("edad");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                String contrasenia = rs.getString("contrasenia");

                Usuario usuario = new Usuario(nombre, cedula, edad, telefono, correo, contrasenia);
                usuarios.add(usuario);
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException();
        }
        
        return usuarios;
    }
}
