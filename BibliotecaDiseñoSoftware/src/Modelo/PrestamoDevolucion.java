/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author val
 */
public class PrestamoDevolucion {
    
    public static final String PRESTADO = "Prestado";
    public static final String DEVUELTO = "Devuelto";
    
    private String estado;
    private String id;
    private String detallesLibro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaVencimiento;
    private LocalDate fechaEntrega;

    public PrestamoDevolucion(String id, String detallesLibro, LocalDate fechaPrestamo, LocalDate fechaVencimiento) {
        estado = PRESTADO;
        this.id = id;
        this.detallesLibro = detallesLibro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaVencimiento = fechaVencimiento;
        fechaEntrega = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDetallesLibro() {
        return detallesLibro;
    }

    public void setDetallesLibro(String detallesLibro) {
        this.detallesLibro = detallesLibro;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }    

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    
}
