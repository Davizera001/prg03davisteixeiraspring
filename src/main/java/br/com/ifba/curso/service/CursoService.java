/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service; 

import br.com.ifba.curso.dao.CursoDAO; // importa o DAO de curso

import br.com.ifba.curso.entity.Curso; // importa a entidade Curso

import java.util.List; // importa lista


/**
 *
 * @author Davi
 */
public class CursoService { // classe responsável pelas regras de negócio de Curso

    private CursoDAO cursoDAO = new CursoDAO(); // cria o DAO para acessar o banco

    public void salvar(Curso curso) { // método para salvar ou atualizar curso

        if (curso == null) { // verifica se o objeto curso está nulo

            throw new RuntimeException("Curso inválido!"); // lança erro se o curso for nulo

        } // fim do if

        if (br.com.ifba.infrastructure.util.StringUtil.isNullOrEmpty(curso.getNome())) { // verifica se o nome está vazio

            throw new RuntimeException("O nome do curso é obrigatório!"); // lança erro de validação

        } // fim do if

        if (br.com.ifba.infrastructure.util.StringUtil.isNullOrEmpty(curso.getDescricao())) { // verifica se a descrição está vazia

            throw new RuntimeException("A descrição do curso é obrigatória!"); // lança erro de validação

        } // fim do if

        if (curso.getCargaHoraria() <= 0) { // verifica se carga horária é inválida

            throw new RuntimeException("A carga horária deve ser maior que zero!"); // lança erro de validação

        } // fim do if

        cursoDAO.salvar(curso); // chama o DAO para salvar ou atualizar no banco

    } // fim do método salvar

    public List<Curso> listar() { // método para listar todos os cursos

        return cursoDAO.listar(); // retorna a lista vinda do DAO

    } // fim do método listar

    public void remover(Long id) { // método para remover curso

        if (id == null) { // verifica se o ID está nulo

            throw new RuntimeException("ID inválido para remoção!"); // lança erro de validação

        } // fim do if

        cursoDAO.remover(id); // chama o DAO para remover

    } // fim do método remover

    public Curso buscarPorId(Long id) { // método para buscar curso por ID

        if (id == null) { // verifica se o ID está nulo

            throw new RuntimeException("ID inválido para busca!"); // lança erro de validação

        } // fim do if

        return cursoDAO.buscarPorId(id); // busca o curso no DAO

    } // fim do método buscarPorId

    public List<Curso> buscarPorNome(String nome) { // método para buscar cursos por nome

        if (nome == null || nome.trim().isEmpty()) { // verifica se o nome está vazio

            return cursoDAO.listar(); // se vazio, lista todos

        } // fim do if

        return cursoDAO.buscarPorNome(nome); // busca pelo nome no DAO

    } // fim do método buscarPorNome

} // fim da classe
