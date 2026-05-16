/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service; 

import br.com.ifba.curso.entity.Curso; // importa a entidade Curso

import br.com.ifba.curso.repository.CursoRepository; // importa o repositório de Curso

import br.com.ifba.infrastructure.util.StringUtil; // importa utilitário de String

import java.util.List; // importa lista

import org.springframework.beans.factory.annotation.Autowired; // importa injeção automática

import org.springframework.stereotype.Service; // importa anotação Service



/**
 *
 * @author Davi
 */

@Service // indica que esta classe pertence à camada de serviço do Spring
public class CursoService { // início da classe CursoService

    @Autowired // pede para o Spring injetar automaticamente o repositório
    private CursoRepository cursoRepository; // repositório usado para acessar o banco

    public void salvar(Curso curso) { // método para salvar ou atualizar curso

        if (curso == null) { // verifica se o curso está nulo

            throw new RuntimeException("Curso inválido!"); // lança erro se estiver nulo

        } // fim do if

        if (StringUtil.isNullOrEmpty(curso.getNome())) { // verifica se o nome está vazio

            throw new RuntimeException("O nome do curso é obrigatório!"); // lança erro de validação

        } // fim do if

        if (StringUtil.isNullOrEmpty(curso.getDescricao())) { // verifica se a descrição está vazia

            throw new RuntimeException("A descrição do curso é obrigatória!"); // lança erro de validação

        } // fim do if

        if (curso.getCargaHoraria() <= 0) { // verifica se a carga horária é inválida

            throw new RuntimeException("A carga horária deve ser maior que zero!"); // lança erro de validação

        } // fim do if

        cursoRepository.save(curso); // salva ou atualiza o curso usando Spring Data JPA

    } // fim do método salvar

    public List<Curso> listar() { // método para listar todos os cursos

        return cursoRepository.findAll(); // retorna todos os cursos

    } // fim do método listar

    public void remover(Long id) { // método para remover curso

        if (id == null) { // verifica se o ID está nulo

            throw new RuntimeException("ID inválido para remoção!"); // lança erro de validação

        } // fim do if

        cursoRepository.deleteById(id); // remove o curso pelo ID

    } // fim do método remover

    public Curso buscarPorId(Long id) { // método para buscar curso por ID

        if (id == null) { // verifica se o ID está nulo

            throw new RuntimeException("ID inválido para busca!"); // lança erro de validação

        } // fim do if

        return cursoRepository.findById(id).orElse(null); // busca por ID ou retorna nulo

    } // fim do método buscarPorId

    public List<Curso> buscarPorNome(String nome) { // método para buscar cursos por nome

        if (StringUtil.isNullOrEmpty(nome)) { // verifica se o texto está vazio

            return cursoRepository.findAll(); // retorna todos se busca estiver vazia

        } // fim do if

        return cursoRepository.findByNomeContainingIgnoreCase(nome); // busca pelo nome ignorando maiúsculas/minúsculas

    } // fim do método buscarPorNome

} // fim da classe