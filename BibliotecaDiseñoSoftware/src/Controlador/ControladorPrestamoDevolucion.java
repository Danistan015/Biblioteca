/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Dao.DaoPrestamosDevoluciones;
import Modelo.PrestamoDevolucion;
import java.sql.SQLException;

/**
 *
 * @author val
 */
public class ControladorPrestamoDevolucion {
    DaoPrestamosDevoluciones dao;

    public ControladorPrestamoDevolucion() {
        dao = new DaoPrestamosDevoluciones();
    }
    
     public void generarPrestamo(PrestamoDevolucion prestamo) throws SQLException{
         dao.generarPrestamo(prestamo);
     }
}
