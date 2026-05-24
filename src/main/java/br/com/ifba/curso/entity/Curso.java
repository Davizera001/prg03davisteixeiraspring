/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.entity; // define o pacote da classe

import lombok.Getter; // cria automaticamente os métodos getters
import lombok.Setter; // cria automaticamente os métodos setters
import lombok.NoArgsConstructor; // cria construtor vazio
import lombok.AllArgsConstructor; // cria construtor com todos os atributos

import jakarta.persistence.Entity; // importa anotação de entidade
import jakarta.persistence.GeneratedValue; // importa geração automática de ID
import jakarta.persistence.GenerationType; // define tipo de geração do ID
import jakarta.persistence.Id; // define chave primária

@Getter // gera getters automaticamente
@Setter // gera setters automaticamente
@NoArgsConstructor // gera construtor vazio
@AllArgsConstructor // gera construtor com todos os atributos
@Entity // indica que essa classe representa uma tabela no banco
public class Curso { // início da classe Curso

    @Id // define o atributo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto incrementado
    private Long id; // atributo id do curso

    private String nome; // atributo nome do curso
    private String descricao; // atributo descrição do curso
    private int cargaHoraria; // atributo carga horária

}
