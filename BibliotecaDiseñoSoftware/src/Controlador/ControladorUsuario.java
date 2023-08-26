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
import org.mariadb.jdbc.Connection;

/**
 *
 * @author val
 */
public class ControladorUsuario {

    public ControladorUsuario() {
    }

    public Usuario buscarCorreo (String correo) throws SQLException {
        // Declara las variables para preparar y ejecutar la consulta SQL
        PreparedStatement ps = null;
        ResultSet rs = null;

        // Crea un objeto de conexión a la base de datos usando la clase previamente definida: ConeccionDB
        Conexion_db conn = new Conexion_db();

        // Obtiene una conexión activa a la base de datos
        Connection con = conn.getConexion();

        // Definir la consulta SQL a ejecutar
        String where = " WHERE correo = '" + correo + "'";
        String sql = "SELECT FROM usuario" + where;

        // Preparar la consulta SQL para su ejecución, esto ayuda a prevenir la inyección SQL
        ps = con.prepareStatement(sql);
        // Ejecuta la consulta y guarda el resultado en la variable rs

        rs = ps.executeQuery();
        return (Usuario) rs;
    }
    
    
    public Usuario insertarUsuario(String cedula){
        
    }
}
