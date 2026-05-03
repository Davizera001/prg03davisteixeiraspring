/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.dao;
import jakarta.persistence.EntityManager; // importa o gerenciador de entidades
import jakarta.persistence.EntityManagerFactory; // importa fábrica de gerenciadores
import jakarta.persistence.Persistence; // classe para criar a conexão

/**
 *
 * @author Davi
 */
public class JPAUtil {
    
     private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("prg03PU"); // cria a fábrica usando o persistence.xml

    public static EntityManager getEntityManager() { // método que retorna um EntityManager
        return emf.createEntityManager(); // cria e retorna um novo EntityManager
    }
    
}
