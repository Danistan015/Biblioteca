/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author val
 */
public class Libro {
    private String id;
    private String nombre;
    private int idGenero;
    private int anioPublicacion;
    private int cantidadCopias;

    public Libro(String id, String nombre, int idGenero, int anioPublicacion, int cantidadCopias) {
        this.id = id;
        this.nombre = nombre;
        this.idGenero = idGenero;
        this.anioPublicacion = anioPublicacion;
        this.cantidadCopias = cantidadCopias;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public int getCantidadCopias() {
        return cantidadCopias;
    }

    public void setCantidadCopias(int cantidadCopias) {
        this.cantidadCopias = cantidadCopias;
    }
}
