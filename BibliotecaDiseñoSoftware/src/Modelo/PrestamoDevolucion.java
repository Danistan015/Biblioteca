/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author val
 */
public class PrestamoDevolucion {

    public static final String PRESTADO = "Prestado";
    public static final String DEVUELTO = "Devuelto";

    private String estado;
    private int id;
    private int detallesLibro;
    private Date fechaPrestamo;
    private Date fechaVencimiento;
    private Date fechaEntrega;
    private int cedulaUsuario;

    public PrestamoDevolucion(int id, int detallesLibro, Date fechaPrestamo, Date fechaVencimiento, int idLibro, int cedulaUsuario) {
        estado = PRESTADO;
        this.id = id;
        this.detallesLibro = detallesLibro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaVencimiento = fechaVencimiento;
        fechaEntrega = null;
        this.cedulaUsuario = cedulaUsuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDetallesLibro() {
        return detallesLibro;
    }

    public void setDetallesLibro(int detallesLibro) {
        this.detallesLibro = detallesLibro;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getCedulaUsuario() {
        return cedulaUsuario;
    }

    public void setCedulaUsuario(int cedulaUsuario) {
        this.cedulaUsuario = cedulaUsuario;
    }
}
