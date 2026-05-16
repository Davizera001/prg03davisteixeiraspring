/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso; // importa a entidade Curso

import br.com.ifba.curso.service.CursoService; // importa a camada de serviço

import java.util.List; // importa lista

import org.springframework.beans.factory.annotation.Autowired; // importa injeção automática

import org.springframework.stereotype.Controller; // importa anotação Controller


/**
 *
 * @author Davi
 */
@Controller // indica que esta classe é gerenciada pelo Spring como controller
public class CursoController { // início da classe CursoController

    @Autowired // pede para o Spring injetar automaticamente o service
    private CursoService cursoService; // service usado pelo controller

    public void salvar(Curso curso) { // método responsável por salvar ou atualizar curso

        cursoService.salvar(curso); // chama o método salvar da camada service

    } // fim do método salvar

    public List<Curso> listar() { // método responsável por listar cursos

        return cursoService.listar(); // retorna a lista da camada service

    } // fim do método listar

    public void remover(Long id) { // método responsável por remover curso

        cursoService.remover(id); // chama remoção na camada service

    } // fim do método remover

    public Curso buscarPorId(Long id) { // método responsável por buscar curso por ID

        return cursoService.buscarPorId(id); // retorna curso encontrado

    } // fim do método buscarPorId

    public List<Curso> buscarPorNome(String nome) { // método responsável por buscar cursos por nome

        return cursoService.buscarPorNome(nome); // retorna lista filtrada

    } // fim do método buscarPorNome

} // fim da classe
