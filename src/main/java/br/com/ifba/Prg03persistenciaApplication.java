/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba;
import br.com.ifba.curso.view.CursoListar; // importa a tela principal

import org.springframework.boot.autoconfigure.SpringBootApplication; // importa anotação principal do Spring Boot

import org.springframework.boot.builder.SpringApplicationBuilder; // importa inicializador do Spring para aplicação desktop

import org.springframework.context.ConfigurableApplicationContext; // importa o contexto do Spring

/**
 *
 * @author Davi
 */
@SpringBootApplication // indica que essa é a classe principal do Spring Boot
public class Prg03persistenciaApplication { // início da classe principal

    public static ConfigurableApplicationContext contexto; // guarda o contexto do Spring para acessar beans

    public static void main(String[] args) { // método principal da aplicação

        contexto = new SpringApplicationBuilder(Prg03persistenciaApplication.class) // cria inicializador do Spring
                .headless(false) // permite abrir interface gráfica Swing
                .run(args); // inicia o Spring

        java.awt.EventQueue.invokeLater(() -> { // executa a tela na thread correta do Swing

            new CursoListar().setVisible(true); // abre a tela principal

        }); // fim do invokeLater

    } // fim do main

}
