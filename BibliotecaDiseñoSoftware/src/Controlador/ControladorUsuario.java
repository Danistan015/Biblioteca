/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion_db;
import Modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author val
 */
public class ControladorUsuario {

    public ControladorUsuario() {
    }

    public Usuario buscarCorreo(String correo){
            // Declara las variables para preparar y ejecutar la consulta SQL
            Usuario usuarioEncontrado = null;
            PreparedStatement ps = null;
            ResultSet rs = null;

            // Crea un objeto de conexión a la base de datos usando la clase previamente definida: ConeccionDB
            Conexion_db conn = new Conexion_db();

            // Obtiene una conexión activa a la base de datos
            Connection con = conn.getConexion();

            // Definir la consulta SQL a ejecutar
            String where = " WHERE correo = '" + correo + "'";
            String sql = "SELECT * FROM usuario" + where;

            // Preparar la consulta SQL para su ejecución, esto ayuda a prevenir la inyección SQL
            try{
                ps = con.prepareStatement(sql);
            // Ejecuta la consulta y guarda el resultado en la variable rs
                rs = ps.executeQuery();
                while(rs.next()){
                    String nombre = rs.getString("nombre");
                    String cedula = rs.getString("cedula");
                    int edad = rs.getInt("edad");
                    String telefono = rs.getString("telefono");
                    String contrasenia = rs.getString("contrasenia");
                    
                    usuarioEncontrado = new Usuario(nombre, cedula, edad, telefono, correo, contrasenia);
                }
            } catch (SQLException ex) {
            Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
            return usuarioEncontrado;
        }
    }

