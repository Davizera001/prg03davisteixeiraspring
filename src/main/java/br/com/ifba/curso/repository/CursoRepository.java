/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.curso.repository;
import br.com.ifba.curso.entity.Curso; // importa a entidade Curso
import java.util.List; // importa lista
import org.springframework.data.jpa.repository.JpaRepository; // importa JpaRepository do Spring Data JPA
import org.springframework.stereotype.Repository; // importa anotação Repository

/**
 *
 * @author Davi
 */
@Repository // indica que essa interface é um repositório gerenciado pelo Spring
public interface CursoRepository extends JpaRepository<Curso, Long> { // cria repository de Curso com ID Long

    public List<Curso> findByNomeContainingIgnoreCase(String nome); // busca cursos pelo nome ignorando maiúsculas/minúsculas

}
