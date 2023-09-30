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
import java.util.ArrayList;

/**
 *
 * @author val
 */
public class DaoPrestamosDevoluciones {
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
            ps.setString(5, String. valueOf(prestamo.getFechaVencimiento()));
            ps.setInt(6, prestamo.getCedulaUsuario());
            ps.execute();
        } catch (SQLException ex) {
            throw new SQLException();
        }
    }

    public void devolverLibro(PrestamoDevolucion prestamo) throws SQLException {
        try {
            PreparedStatement ps = null;
           
            prestamo.setEstado(DEVUELTO);
            String sql = "UPDATE pestamosDevoluciones SET estado=?, fechaEntregado=? WHERE ID=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, prestamo.getEstado());
            ps.setString(2, String.valueOf(prestamo.getFechaEntrega()));
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
            
            String sql = "SELECT * FROM generos";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String estado = rs.getString("estado");
                int idLibro = rs.getInt("idLibro");
                int idUsuario = rs.getInt("idUsuario");
                String fechaPrestamo = rs.getString("fechaPrestamo");
                String fechaVencimiento = rs.getString("fechaVencimiento");
                
                
                //PrestamoDevolucion prestamoDevolucion = new PrestamoDevolucion(id, idLibro, fechaPrestamo, fechaVencimiento, idLibro, idUsuario);
                //lista.add(prestamoDevolucion);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException();
        }

        return lista;
    }
}
