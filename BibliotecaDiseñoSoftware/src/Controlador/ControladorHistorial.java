/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Dao.DaoHistoriales;
import Modelo.Historiales;
import Modelo.Libro;
import Modelo.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sotog
 */

public class ControladorHistorial {

    DaoHistoriales daoHistorial;

    public ControladorHistorial() {
        this.daoHistorial = new DaoHistoriales();
    }

    public void agregarRegistroHistorial(Historiales historial) throws SQLException {
        daoHistorial.agregarRegistroHistorial(historial);
    }

    public ArrayList<Historiales> listaH() throws SQLException {
        return daoHistorial.listarHistorialCompleto();
    }

    public String buscarNombreUsuarioPorCedula(int cedula) throws SQLException {
        return daoHistorial.buscarNombreUsuarioPorCedula(cedula);

    }

    public Usuario buscarUsuarioPorCedula(int cedula) throws SQLException {
        return daoHistorial.buscarUsuarioPorCedula(cedula);
    }

    public ArrayList<Historiales> listaUsuariosCreados() throws SQLException {
        return daoHistorial.listaUsuariosCreados();
    }
}
