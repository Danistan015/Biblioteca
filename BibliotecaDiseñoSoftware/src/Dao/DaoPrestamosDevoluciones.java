/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Conexion.Conexion_db;
import Controlador.ControladorLibro;
import Modelo.Libro;
import Modelo.PrestamoDevolucion;
import static Modelo.PrestamoDevolucion.DEVUELTO;
import static Modelo.PrestamoDevolucion.PRESTADO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author val
 */
public class DaoPrestamosDevoluciones {

    ControladorLibro controlador;

    public DaoPrestamosDevoluciones() {
        controlador = new ControladorLibro();
    }

    public void generarPrestamo(PrestamoDevolucion prestamo) throws SQLException {
        try {
            PreparedStatement ps = null;
            Conexion_db conn = new Conexion_db();
            Connection con = conn.getConexion();
            prestamo.setEstado(PRESTADO);
            String sql = "INSERT INTO pestamosDevoluciones (estado, ID, idLibro, fechaPrestamo, fechaVencimiento, idUsuario) VALUES (?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, prestamo.getEstado());
            ps.setInt(2, prestamo.getId());
            ps.setInt(3, prestamo.getDetallesLibro());
            ps.setDate(4, prestamo.getFechaPrestamo());
            ps.setDate(5, prestamo.getFechaVencimiento());
            ps.setInt(7, prestamo.getCedulaUsuario());
            ps.execute();
        } catch (SQLException ex) {
            throw new SQLException();
        }
    }

    public void devolverLibro(PrestamoDevolucion prestamo) throws SQLException {
        try {
            PreparedStatement ps = null;
            Conexion_db conn = new Conexion_db();
            Connection con = conn.getConexion();
            prestamo.setEstado(DEVUELTO);
            String sql = "UPDATE pestamosDevoluciones SET estado=?, fechaEntregado=? WHERE ID=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, prestamo.getEstado());
            ps.setDate(2, prestamo.getFechaEntrega());
            ps.execute();
        } catch (SQLException ex) {
            throw new SQLException();
        }
    }

    public ArrayList<PrestamoDevolucion> listaPrestamosDevoluciones() throws SQLException {
        ArrayList<PrestamoDevolucion> lista = new ArrayList<>();
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion_db conn = new Conexion_db();
            Connection con = conn.getConexion();
            String sql = "SELECT * FROM generos";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String estado = rs.getString("estado");
                int idLibro = rs.getInt("idLibro");
                int idUsuario = rs.getInt("idUsuario");
                Date fechaPrestamo = rs.getDate("fechaPrestamo");
                Date fechaVencimiento = rs.getDate("fechaVencimiento");
                PrestamoDevolucion prestamoDevolucion = new PrestamoDevolucion(id, idLibro, fechaPrestamo, fechaVencimiento, idLibro, idUsuario);
                lista.add(prestamoDevolucion);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException();
        }

        return lista;
    }
}
