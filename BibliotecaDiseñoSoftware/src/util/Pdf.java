/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import Controlador.ControladorGenero;
import Controlador.ControladorLibro;
import Controlador.ControladorPrestamoDevolucion;
import Controlador.ControladorUsuario;
import Modelo.Genero;
import Modelo.Libro;
import Modelo.PrestamoDevolucion;
import Modelo.Usuario;
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
    ControladorPrestamoDevolucion controladorPrestamoDevolucion;
    ControladorGenero controladorGenero;

    public Pdf() {
        controladorUsuario = new ControladorUsuario();
        controladorLibro = new ControladorLibro();
        controladorPrestamoDevolucion = new ControladorPrestamoDevolucion();
        controladorGenero = new ControladorGenero();
    }

    //pdfs de prestamos generales
    public void pdfPrestamoDevolucionGeneral(ArrayList<PrestamoDevolucion> lista, String tipo) {
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/pdf" + tipo + "General.pdf"));
            documento.open();
            PdfPTable tabla = new PdfPTable(5);

            tabla.addCell("Nombre Usuario");
            tabla.addCell("Cedula Usuario");
            tabla.addCell("Nombre libro");
            //cambia de columna en caso de que sea un prestamo o una devolución
            if (tipo.equals("Prestamo")) {
                tabla.addCell("Fecha Prestamo");
            } else {
                tabla.addCell("Fecha Devuelto");
            }
            tabla.addCell("Categoria");

            for (int i = 0; i < lista.size(); i++) {
                //id para buscar
                int cedulaUsuario = lista.get(i).getCedulaUsuario();
                int idLibro = lista.get(i).getDetallesLibro();
                int idPrestamoDevolucion = lista.get(i).getId();

                Usuario usuario = controladorUsuario.buscarUsuarioCedula(cedulaUsuario);
                Libro libro = controladorLibro.buscarLibro(idLibro);
                Genero genero = controladorGenero.buscarGenero(libro.getIdGenero());

                //variables necesarias para el registro
                String nombreUsuario = usuario.getNombre();
                String nombreLibro = libro.getNombre();
                String nombreGenero = genero.getNombre();

                tabla.addCell(nombreUsuario);
                tabla.addCell(String.valueOf(cedulaUsuario));
                tabla.addCell(nombreLibro);
                //en el caso de que sea un prestamo, muestra la fecha en que se prestó y en el caso de que sea una devolución, muestra la fecha en que se devolvió
                if (tipo.equals("Prestamo")) {
                    tabla.addCell(String.valueOf(lista.get(i).getFechaPrestamoActual()));
                } else {
                    tabla.addCell(controladorPrestamoDevolucion.buscarFechaDevuelto(idPrestamoDevolucion));
                }
                tabla.addCell(nombreGenero);
            }
            documento.add(tabla);
            documento.close();

            // Mostrar un mensaje emergente de notificación
            JOptionPane.showMessageDialog(null, "Reporte creado en el Escritorio con el nombre: pdf" + tipo + "General.pdf");

        } catch (DocumentException | HeadlessException | FileNotFoundException e) {

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void pdfPrestamoDevolucionIndividual(ArrayList<PrestamoDevolucion> lista, String tipo, int cedula) {
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/pdf" + tipo + "Individual" + cedula + ".pdf"));
            documento.open();
            PdfPTable tabla = new PdfPTable(5);

            tabla.addCell("Nombre Usuario");
            tabla.addCell("Cedula Usuario");
            tabla.addCell("Nombre libro");
            if (tipo.equals("Prestamo")) {
                tabla.addCell("Fecha Prestamo");
            } else {
                tabla.addCell("Fecha Devuelto");
            }
            tabla.addCell("Categoria");

            for (int i = 0; i < lista.size(); i++) {
                //id para buscar
                int cedulaUsuario = lista.get(i).getCedulaUsuario();
                int idLibro = lista.get(i).getDetallesLibro();
                int idPrestamoDevolucion = lista.get(i).getId();

                Usuario usuario = controladorUsuario.buscarUsuarioCedula(cedulaUsuario);
                Libro libro = controladorLibro.buscarLibro(idLibro);
                Genero genero = controladorGenero.buscarGenero(libro.getIdGenero());

                //variables necesarias para el registro
                String nombreUsuario = usuario.getNombre();
                String nombreLibro = libro.getNombre();
                String nombreGenero = genero.getNombre();

                tabla.addCell(nombreUsuario);
                tabla.addCell(String.valueOf(cedulaUsuario));
                tabla.addCell(nombreLibro);
                //en el caso de que sea un prestamo, muestra la fecha en que se prestó y en el caso de que sea una devolución, muestra la fecha en que se devolvió
                if (tipo.equals("Prestamo")) {
                    tabla.addCell(String.valueOf(lista.get(i).getFechaPrestamoActual()));
                } else {
                    tabla.addCell(controladorPrestamoDevolucion.buscarFechaDevuelto(idPrestamoDevolucion));
                }
                tabla.addCell(nombreGenero);
            }
            documento.add(tabla);
            documento.close();

            // Mostrar un mensaje emergente de notificación
            JOptionPane.showMessageDialog(null, "Reporte creado con el nombre: pdf" + tipo + "Individual" + cedula + ".pdf");

        } catch (DocumentException | HeadlessException | FileNotFoundException e) {

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
}
