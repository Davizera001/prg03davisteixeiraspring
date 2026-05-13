/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.dao;

import br.com.ifba.curso.dao.generic.GenericDAO; // importa o DAO genérico

import br.com.ifba.curso.entity.Curso; // importa a entidade Curso

import java.util.List; // importa listas

public class CursoDAO extends GenericDAO<Curso> { // CursoDAO herda operações genéricas de Curso

    public CursoDAO() { // construtor do CursoDAO

        super(Curso.class); // informa ao GenericDAO que essa classe trabalha com Curso

    } // fim do construtor

    public void salvar(Curso curso) { // método usado para salvar ou atualizar curso

        if (curso.getId() == null) { // verifica se o curso ainda não tem ID

            super.salvar(curso); // salva um novo curso no banco

        } else { // caso o curso já tenha ID

            super.atualizar(curso); // atualiza o curso existente no banco

        } // fim do if/else

    } // fim do método salvar

    public List<Curso> listar() { // método usado pela tela para listar cursos

        return super.listarTodos(); // chama o método genérico que lista todos

    } // fim do método listar

    public void remover(Long id) { // método usado pela tela para remover curso por ID

        Curso curso = super.buscarPorId(id); // busca o curso pelo ID

        if (curso != null) { // verifica se encontrou o curso

            super.deletar(curso); // remove o curso do banco

        } // fim do if

    } // fim do método remover

    public Curso buscarPorId(Long id) { // método usado para buscar curso pelo ID

        return super.buscarPorId(id); // chama a busca genérica por ID

    } // fim do método buscarPorId

    public List<Curso> buscarPorNome(String nome) { // método específico para buscar curso pelo nome

        jakarta.persistence.EntityManager em = JPAUtil.getEntityManager(); // cria EntityManager

        try { // inicia tentativa

            return em.createQuery( // cria consulta JPQL
                    "from Curso c where lower(c.nome) like :nome", // consulta pelo nome
                    Curso.class // define retorno como Curso
            ).setParameter( // define parâmetro da consulta
                    "nome", // nome do parâmetro
                    "%" + nome.toLowerCase() + "%" // valor pesquisado
            ).getResultList(); // executa consulta e retorna lista

        } finally { // sempre executa

            em.close(); // fecha EntityManager

        } // fim do finally

    } // fim do método buscarPorNome

} // fim da classe
