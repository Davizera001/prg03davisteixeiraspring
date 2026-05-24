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

import lombok.RequiredArgsConstructor; // cria construtor com atributos final
import lombok.extern.slf4j.Slf4j; // cria objeto de log automaticamente

/**
 *
 * @author Davi
 */

@Slf4j // cria logger automático
@RequiredArgsConstructor // Lombok gera construtor com atributos final para injeção de dependência
@Service // indica que esta classe pertence à camada de serviço do Spring
public class CursoService { // início da classe CursoService

     // pede para o Spring injetar automaticamente o repositório
    private final CursoRepository cursoRepository; // repositório usado para acessar o banco

    public void salvar(Curso curso) {
        // método para salvar ou atualizar curso
    log.info("Iniciando operação de salvamento de curso"); // registra início da operação

    if (curso == null) { // verifica se o objeto curso está nulo

        log.error("Falha ao salvar: objeto Curso está nulo"); // registra erro grave
        throw new RuntimeException("Curso inválido!"); // lança exceção de validação

    } // fim do if

    if (StringUtil.isNullOrEmpty(curso.getNome())) { // verifica se o nome está vazio

        log.warn("Falha ao salvar: nome do curso não informado"); // registra aviso de validação
        throw new RuntimeException("O nome do curso é obrigatório!"); // lança erro de validação

    } // fim do if

    if (StringUtil.isNullOrEmpty(curso.getDescricao())) { // verifica se a descrição está vazia

        log.warn("Falha ao salvar: descrição do curso não informada"); // registra aviso de validação
        throw new RuntimeException("A descrição do curso é obrigatória!"); // lança erro de validação

    } // fim do if

    if (curso.getCargaHoraria() <= 0) { // verifica se a carga horária é inválida

        log.warn("Falha ao salvar: carga horária inválida ({})", curso.getCargaHoraria()); // registra aviso com valor inválido
        throw new RuntimeException("A carga horária deve ser maior que zero!"); // lança erro de validação

    } // fim do if

    log.info("Salvando curso: {}", curso.getNome()); // registra o nome do curso que será salvo
    cursoRepository.save(curso); // salva ou atualiza o curso no banco de dados
    log.info("Curso salvo com sucesso: {}", curso.getNome()); // registra sucesso da operação

    } // fim do método salvar
    

    public List<Curso> listar() { // método para listar todos os cursos

        log.info("Listando todos os cursos"); // registra operação de listagem
        return cursoRepository.findAll(); // retorna todos os cursos

    } // fim do método listar

    public void remover(Long id) { // método para remover curso

        log.info("Iniciando remoção de curso"); // registra início da operação
        if (id == null) { // verifica se o ID está nulo

        log.error("Falha ao remover: ID nulo"); // registra erro
        throw new RuntimeException("ID inválido para remoção!"); // lança erro de validação
        } // fim do if
        
        log.info("Removendo curso ID: {}", id); // registra ID removido
        cursoRepository.deleteById(id); // remove o curso pelo ID
        log.info("Curso removido com sucesso"); // registra sucesso da operação

    } // fim do método remover

    public Curso buscarPorId(Long id) { // método para buscar curso por ID

        log.info("Buscando curso por ID"); // registra início da busca
        if (id == null) { // verifica se o ID está nulo
        log.error("Falha na busca: ID nulo"); // registra erro

        throw new RuntimeException("ID inválido para busca!"); // lança erro de validação
        } // fim do if

        log.info("Buscando curso ID: {}", id); // registra ID buscado
        return cursoRepository.findById(id).orElse(null); // busca por ID ou retorna nulo

    } //fim do método buscarPorId

    public List<Curso> buscarPorNome(String nome) { // método para buscar cursos por nome

        log.info("Iniciando busca de cursos por nome"); // registra início da operação

        if (StringUtil.isNullOrEmpty(nome)) { // verifica se o texto está vazio
        log.warn("Busca sem nome informado, retornando todos os cursos"); // registra aviso
        return cursoRepository.findAll(); // retorna todos se busca estiver vazia
        
        } // fim do if
        
        log.info("Buscando cursos pelo nome: {}", nome); // registra nome pesquisado
        return cursoRepository.findByNomeContainingIgnoreCase(nome); // busca pelo nome ignorando maiúsculas/minúsculas
        
    } // fim do método buscarPorNome

} // fim da classe