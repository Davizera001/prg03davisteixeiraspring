/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.dao;

import br.com.ifba.curso.entity.Curso; // importa a classe Curso
import jakarta.persistence.EntityManager; // importa o gerenciador
import java.util.List; // importa lista

public class CursoDAO { // classe responsável pelas operações no banco
    
    public java.util.List<br.com.ifba.curso.entity.Curso> buscarPorNome(String nome) { // método que busca cursos pelo nome

    jakarta.persistence.EntityManager em = JPAUtil.getEntityManager(); // cria conexão com banco

    java.util.List<br.com.ifba.curso.entity.Curso> lista = em.createQuery( // cria consulta JPQL
            "from Curso c where lower(c.nome) like :nome", // consulta filtrando pelo nome
            br.com.ifba.curso.entity.Curso.class // define o tipo de retorno
    )
    .setParameter("nome", "%" + nome.toLowerCase() + "%") // define o parâmetro com LIKE
    .getResultList(); // executa a consulta

    em.close(); // fecha conexão

    return lista; // retorna lista filtrada
}

    public void salvar(Curso curso) { // método para salvar curso

        EntityManager em = JPAUtil.getEntityManager();

    try {

        em.getTransaction().begin();

        if (curso.getId() == null) { // novo
            em.persist(curso);
        } else { // edição
            em.merge(curso);
        }

        em.getTransaction().commit();

    } catch (Exception e) {

        em.getTransaction().rollback();
        e.printStackTrace();

    } finally {

        em.close();
    }
    }

    public List<Curso> listar() { // método para listar cursos

        EntityManager em = JPAUtil.getEntityManager(); // cria conexão

        List<Curso> lista = em.createQuery("from Curso", Curso.class).getResultList(); // consulta todos cursos

        em.close(); // fecha conexão

        return lista; // retorna lista
    }

    public void remover(Long id) { // método para remover curso

        EntityManager em = JPAUtil.getEntityManager(); // cria conexão

        try { // tenta executar

            Curso curso = em.find(Curso.class, id); // busca curso pelo id

            em.getTransaction().begin(); // inicia transação

            em.remove(curso); // remove do banco

            em.getTransaction().commit(); // confirma

        } catch (Exception e) { // erro

            em.getTransaction().rollback(); // desfaz

            e.printStackTrace(); // mostra erro

        } finally {

            em.close(); // fecha conexão

        }
    }
}
