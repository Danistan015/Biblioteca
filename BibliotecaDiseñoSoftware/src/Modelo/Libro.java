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
    private int id;
    private String nombre;
    private String autor;
    private int anioPublicacion;
    private int cantidadCopias;
    private int idGenero;
    private String nombreGenero;

    public Libro(int id, String nombre, String autor, int anioPublicacion, int cantidadCopias,  int idGenero) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.cantidadCopias = cantidadCopias;
        this.idGenero = idGenero;
    }

    public Libro(int id, String nombre, String autor, int anioPublicacion, int cantidadCopias, String nombreGenero) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.cantidadCopias = cantidadCopias;
        this.nombreGenero = nombreGenero;
    }

    public Libro(int id, String nombre, String autor, int anioPublicacion, int cantidadCopias) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.cantidadCopias = cantidadCopias;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
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

    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }
    
    
}
