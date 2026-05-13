/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.dao.generic;
import br.com.ifba.curso.dao.JPAUtil; // importa a classe que cria o EntityManager

import jakarta.persistence.EntityManager; // importa o gerenciador de entidades

import java.util.List; // importa lista

/**
 *
 * @author Davi
 */
    
    public class GenericDAO<T> implements GenericIDAO<T> { // classe genérica que implementa a interface genérica

    private Class<T> classeEntidade; // guarda a classe da entidade que será usada no DAO

    public GenericDAO(Class<T> classeEntidade) { // construtor que recebe a classe da entidade

        this.classeEntidade = classeEntidade; // armazena a classe recebida

    } // fim do construtor

    @Override // indica que o método vem da interface
    public void salvar(T objeto) { // método para salvar objeto

        EntityManager em = JPAUtil.getEntityManager(); // cria o EntityManager

        try { // inicia tentativa

            em.getTransaction().begin(); // inicia transação

            em.persist(objeto); // salva objeto no banco

            em.getTransaction().commit(); // confirma transação

        } catch (Exception e) { // captura erro

            em.getTransaction().rollback(); // desfaz transação

            throw e; // joga erro para a camada superior tratar

        } finally { // sempre executa

            em.close(); // fecha EntityManager

        } // fim do finally

    } // fim do método salvar

    @Override // indica que o método vem da interface
    public void atualizar(T objeto) { // método para atualizar objeto

        EntityManager em = JPAUtil.getEntityManager(); // cria EntityManager

        try { // inicia tentativa

            em.getTransaction().begin(); // inicia transação

            em.merge(objeto); // atualiza objeto no banco

            em.getTransaction().commit(); // confirma transação

        } catch (Exception e) { // captura erro

            em.getTransaction().rollback(); // desfaz transação

            throw e; // joga erro para cima

        } finally { // sempre executa

            em.close(); // fecha EntityManager

        } // fim do finally

    } // fim do método atualizar

    @Override // indica que o método vem da interface
    public void deletar(T objeto) { // método para deletar objeto

        EntityManager em = JPAUtil.getEntityManager(); // cria EntityManager

        try { // inicia tentativa

            em.getTransaction().begin(); // inicia transação

            T objetoGerenciado = em.merge(objeto); // garante que o objeto está gerenciado pelo JPA

            em.remove(objetoGerenciado); // remove objeto do banco

            em.getTransaction().commit(); // confirma transação

        } catch (Exception e) { // captura erro

            em.getTransaction().rollback(); // desfaz transação

            throw e; // joga erro para cima

        } finally { // sempre executa

            em.close(); // fecha EntityManager

        } // fim do finally

    } // fim do método deletar

    @Override // indica que o método vem da interface
    public T buscarPorId(Long id) { // método para buscar por id

        EntityManager em = JPAUtil.getEntityManager(); // cria EntityManager

        try { // inicia tentativa

            return em.find(classeEntidade, id); // busca objeto pela chave primária

        } finally { // sempre executa

            em.close(); // fecha EntityManager

        } // fim do finally

    } // fim do método buscarPorId

    @Override // indica que o método vem da interface
    public List<T> listarTodos() { // método para listar todos

        EntityManager em = JPAUtil.getEntityManager(); // cria EntityManager

        try { // inicia tentativa

            return em.createQuery("from " + classeEntidade.getSimpleName(), classeEntidade).getResultList(); // consulta todos os registros

        } finally { // sempre executa

            em.close(); // fecha EntityManager

        } // fim do finally

    } // fim do método listarTodos

} // fim da classe
    

