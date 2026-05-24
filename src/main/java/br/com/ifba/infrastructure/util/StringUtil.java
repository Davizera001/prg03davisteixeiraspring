/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.util;

/**
 *
 * @author Davi
 */
public class StringUtil {
    
    public static boolean isNullOrEmpty(String texto) { // método que verifica se texto é nulo ou vazio

        return texto == null || texto.trim().isEmpty(); // retorna verdadeiro se for nulo, vazio ou só espaços

    } // fim do método
}
