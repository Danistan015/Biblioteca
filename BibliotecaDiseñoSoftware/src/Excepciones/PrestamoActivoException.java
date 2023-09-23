/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

import javax.swing.JOptionPane;
import jdk.nashorn.internal.runtime.regexp.joni.Warnings;

/**
 *
 * @author val
 */
public class PrestamoActivoException extends RuntimeException {
    public PrestamoActivoException() {
        super("Usted ya tiene un préstamo activo");
    }
}
