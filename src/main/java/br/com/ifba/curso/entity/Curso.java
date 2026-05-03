/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.entity; // define o pacote da classe

import jakarta.persistence.Entity; // importa anotação de entidade
import jakarta.persistence.GeneratedValue; // importa geração automática de ID
import jakarta.persistence.GenerationType; // define tipo de geração do ID
import jakarta.persistence.Id; // define chave primária

@Entity // indica que essa classe representa uma tabela no banco
public class Curso { // início da classe Curso

    @Id // define o atributo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto incrementado
    private Long id; // atributo id do curso

    private String nome; // atributo nome do curso
    private String descricao; // atributo descrição do curso
    private int cargaHoraria; // atributo carga horária

    public Curso() { // construtor vazio obrigatório
    }

    public Long getId() { // método getter do id
        return id; // retorna o id
    }

    public void setId(Long id) { // método setter do id
        this.id = id; // atribui valor ao id
    }

    public String getNome() { // método getter do nome
        return nome; // retorna o nome
    }

    public void setNome(String nome) { // método setter do nome
        this.nome = nome; // atribui valor ao nome
    }

    public String getDescricao() { // método getter da descrição
        return descricao; // retorna a descrição
    }

    public void setDescricao(String descricao) { // método setter da descrição
        this.descricao = descricao; // atribui valor à descrição
    }

    public int getCargaHoraria() { // método getter da carga horária
        return cargaHoraria; // retorna a carga horária
    }

    public void setCargaHoraria(int cargaHoraria) { // método setter da carga horária
        this.cargaHoraria = cargaHoraria; // atribui valor à carga horária
    }
}
