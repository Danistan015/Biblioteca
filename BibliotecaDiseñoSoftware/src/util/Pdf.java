/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import Controlador.ControladorLibro;
import Controlador.ControladorPrestamoDevolucion;
import Controlador.ControladorUsuario;
import Modelo.PrestamoDevolucion;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author val
 */
public class Pdf {

    ControladorUsuario controladorUsuario;
    ControladorLibro controladorLibro;
    public Pdf() {
        controladorUsuario = new ControladorUsuario();
        controladorLibro = new ControladorLibro();
    }
    
    //pdfs de prestamos generales
    public void pdfPrestamoGeneral (ArrayList<PrestamoDevolucion> lista) {
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/pdfPrestamoGeneral.pdf"));
            documento.open();
            PdfPTable tabla = new PdfPTable(5);
        
            tabla.addCell("Nombre Usuario");
            tabla.addCell("Cedula Usuario");
            tabla.addCell("Nombre libro");
            tabla.addCell("Fecha Prestamo");
            tabla.addCell("Categoria");
            
            for (int i = 0; i < lista.size(); i++) {
                int cedulaUsuario = lista.get(i).getCedulaUsuario();
                int idLibro = lista.get(i).getDetallesLibro();
                
                String nombreUsuario = controladorUsuario.buscarUsuarioCedula(cedulaUsuario).getNombre();
                String nombreLibro = controladorLibro.buscarLibro(idLibro).getNombre();
                String nombreGenero = controladorLibro.buscarLibro(idLibro).getNombreGenero();
                
                tabla.addCell(nombreUsuario);
                tabla.addCell(String.valueOf(cedulaUsuario));
                tabla.addCell(nombreLibro);
                tabla.addCell(String.valueOf(lista.get(i).getFechaPrestamoActual()));
                tabla.addCell(nombreGenero);
            }
            documento.add(tabla);
            documento.close();

            // Mostrar un mensaje emergente de notificación
            JOptionPane.showMessageDialog(null, "Reporte creado.");

        } catch (DocumentException | HeadlessException | FileNotFoundException e) {

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void pdfPrestamoIndividual (ArrayList<PrestamoDevolucion> lista) {
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/pdfPrestamo.pdf"));
            documento.open();
            PdfPTable tabla = new PdfPTable(5);
        
            tabla.addCell("Nombre Usuario");
            tabla.addCell("Cedula Usuario");
            tabla.addCell("Nombre libro");
            tabla.addCell("Fecha Prestamo");
            tabla.addCell("Categoria");
            
            for (int i = 0; i < lista.size(); i++) {
                int cedulaUsuario = lista.get(i).getCedulaUsuario();
                int idLibro = lista.get(i).getDetallesLibro();
                
                String nombreUsuario = controladorUsuario.buscarUsuarioCedula(cedulaUsuario).getNombre();
                String nombreLibro = controladorLibro.buscarLibro(idLibro).getNombre();
                String nombreGenero = controladorLibro.buscarLibro(idLibro).getNombreGenero();
                
                tabla.addCell(nombreUsuario);
                tabla.addCell(String.valueOf(cedulaUsuario));
                tabla.addCell(nombreLibro);
                tabla.addCell(String.valueOf(lista.get(i).getFechaPrestamoActual()));
                tabla.addCell(nombreGenero);
            }
            documento.add(tabla);
            documento.close();

            // Mostrar un mensaje emergente de notificación
            JOptionPane.showMessageDialog(null, "Reporte creado.");

        } catch (DocumentException | HeadlessException | FileNotFoundException e) {

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void pdfPrestamoRangoFechas (ArrayList<PrestamoDevolucion> lista) {
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/pdfPrestamoFechas.pdf"));
            documento.open();
            PdfPTable tabla = new PdfPTable(5);
        
            tabla.addCell("Nombre Usuario");
            tabla.addCell("Cedula Usuario");
            tabla.addCell("Nombre libro");
            tabla.addCell("Fecha Prestamo");
            tabla.addCell("Categoria");
            
            for (int i = 0; i < lista.size(); i++) {
                int cedulaUsuario = lista.get(i).getCedulaUsuario();
                int idLibro = lista.get(i).getDetallesLibro();
                
                String nombreUsuario = controladorUsuario.buscarUsuarioCedula(cedulaUsuario).getNombre();
                String nombreLibro = controladorLibro.buscarLibro(idLibro).getNombre();
                String nombreGenero = controladorLibro.buscarLibro(idLibro).getNombreGenero();
                
                tabla.addCell(nombreUsuario);
                tabla.addCell(String.valueOf(cedulaUsuario));
                tabla.addCell(nombreLibro);
                tabla.addCell(String.valueOf(lista.get(i).getFechaPrestamoActual()));
                tabla.addCell(nombreGenero);
            }
            documento.add(tabla);
            documento.close();

            // Mostrar un mensaje emergente de notificación
            JOptionPane.showMessageDialog(null, "Reporte creado.");

        } catch (DocumentException | HeadlessException | FileNotFoundException e) {

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
