/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterpriseapplication.utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase de utilidades.
 * @author Stalin
 * @version 1.0
 */
public class Utilidades {

    private Utilidades() {
    }

    /**
     * Nombre de la unidad de persitencia de JPA.
     */
    public static final String JPA_PERSIST_UNIT_NAME = "PizzasPU";
    
    /**
     * Una cadena vacía.
     */
    public static final String EMPTY_STRING = "";
    
    /**
     * ID del perfil de administrador.
     */
    public static final Integer ID_PERFIL_ADMINISTRADOR = 1;

    /**
     * Método para encriptar una cadena con el algoritmo MD5.
     * @param cadena
     * @return cadena encriptada.
     */
    public static String obtenerCadenaEncriptadaConMD5(String cadena) {
        final byte[] defaultBytes = cadena.getBytes();
        try {
            final MessageDigest md5MsgDigest = MessageDigest.getInstance("MD5");
            md5MsgDigest.reset();
            md5MsgDigest.update(defaultBytes);
            final byte messageDigest[] = md5MsgDigest.digest();
            final StringBuffer hexString = new StringBuffer();
            for (final byte element : messageDigest) {
                final String hex = Integer.toHexString(0xFF & element);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            cadena = hexString + "";
        } catch (final NoSuchAlgorithmException nsae) {
            cadena = "Cadena '" + cadena + "' no encriptada";
        }
        return cadena;
    }

    /**
     * Método para validar un correo.
     * @param correo
     * @return true si el correo es válido, false si no es válido.
     */
    public static boolean validarCorreo(String correo) {

        // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(correo);

        return mather.matches();
    }

    /**
     * Método para validar una cédula.
     * @param cedula
     * @return true si la cédula es válida, false si no es válida.
     */
    public static boolean validarCedula(String cedula) {

        boolean cedulaValida;

        try {
            if (cedula.length() == 10 || cedula.length() == 13) {

                cedula = cedula.substring(0, 10);
                String[] array = cedula.split("");
                Integer num = array.length;

                Double total = 0.0;
                Integer digito = Integer.parseInt(array[9]) * 1;
                for (int i = 0; i < (num - 1); i++) {
                    Integer mult;
                    if ((i % 2) != 0) {
                        total = total + (Integer.parseInt(array[i]) * 1);
                    } else {
                        mult = Integer.parseInt(array[i]) * 2;
                        if (mult > 9) {
                            total = total + (mult - 9);
                        } else {
                            total = total + mult;
                        }
                    }
                }
                Double decena = total / 10;
                decena = Math.floor(decena);
                decena = (decena + 1) * 10;
                Double finale = (decena - total);
                if ((finale.intValue() == 10 && digito == 0) || (finale.intValue() == digito)) {
                    System.out.println("TRUE");
                    cedulaValida = true;
                } else {
                    System.out.println("FALSE");
                    cedulaValida = false;
                }

            } else {
                System.out.println("FALSE");
                cedulaValida = false;

            }

        } catch (NumberFormatException e) {
            System.out.println("FALSE");
            cedulaValida = false;
        }

        return cedulaValida;
    }    
}
