/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Controlador.ControladorLibro;
import Modelo.PrestamoDevolucion;
import static Modelo.PrestamoDevolucion.DEVUELTO;
import static Modelo.PrestamoDevolucion.PRESTADO;
import Singleton.DatabaseSingleton;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import static javax.swing.UIManager.getString;

/**
 *
 * @author val
 */
public class DaoPrestamosDevoluciones {

    //esa es esa es
    private Connection con;
    ControladorLibro controlador;

    public DaoPrestamosDevoluciones() {
        controlador = new ControladorLibro();
        con = DatabaseSingleton.getInstance().getConnection();
    }

    public void generarPrestamo(PrestamoDevolucion prestamo) throws SQLException {
        try {
            PreparedStatement ps = null;
            prestamo.setEstado(PRESTADO);
            String sql = "INSERT INTO prestamosDevoluciones (estado, ID, idLibro, fechaPrestamo, fechaVencimiento, idUsuario) VALUES (?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, prestamo.getEstado());
            ps.setInt(2, prestamo.getId());
            ps.setInt(3, prestamo.getDetallesLibro());
            ps.setString(4, String.valueOf(prestamo.getFechaPrestamoActual()));
            ps.setString(5, String.valueOf(prestamo.getFechaVencimiento()));
            ps.setInt(6, prestamo.getCedulaUsuario());
            ps.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException();
        }
    }

    public PrestamoDevolucion buscarPrestamo(int id) throws SQLException {
        PrestamoDevolucion prestamo = null;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        ResultSet rs = null;
        PreparedStatement ps = null;
        String where = " WHERE ID = '" + id + "'";
        String sql = "SELECT * FROM prestamosDevoluciones" + where;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String estado = rs.getString("estado");
                int idLibro = rs.getInt("idLibro");
                int idUsuario = rs.getInt("idUsuario");
                LocalDate fechaPrestamo = LocalDate.parse(rs.getString("fechaPrestamo"), formato);
                LocalDate fechaVencimiento = LocalDate.parse(rs.getString("fechaVencimiento"), formato);
                prestamo = new PrestamoDevolucion(estado, id, idLibro, fechaPrestamo, fechaVencimiento, idUsuario);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException();
        }

        return prestamo;

    }

    public void devolverLibro(PrestamoDevolucion prestamo) throws SQLException {
        try {
            PreparedStatement ps = null;

            prestamo.setEstado(DEVUELTO);
            LocalDate fechaEntregado = LocalDate.now();
            String sql = "UPDATE prestamosDevoluciones SET estado=?, fechaEntrega=? WHERE ID=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, prestamo.getEstado());
            ps.setString(2, String.valueOf(fechaEntregado));
            ps.setInt(3, prestamo.getId());
            ps.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException();
        }
    }

    public ArrayList<PrestamoDevolucion> listaPrestamosDevoluciones(int cedula) throws SQLException {
        ArrayList<PrestamoDevolucion> lista = new ArrayList<>();
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String sql = "SELECT * FROM prestamosDevoluciones WHERE idUsuario = " + cedula;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String estado = rs.getString("estado");
                int idLibro = rs.getInt("idLibro");
                int idUsuario = rs.getInt("idUsuario");
                LocalDate fechaPrestamo = LocalDate.parse(rs.getString("fechaPrestamo"), formato);
                LocalDate fechaVencimiento = LocalDate.parse(rs.getString("fechaVencimiento"), formato);

                PrestamoDevolucion prestamo = new PrestamoDevolucion(estado, id, idLibro, fechaPrestamo, fechaVencimiento, idUsuario);
                lista.add(prestamo);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException();
        }

        return lista;
    }

}
