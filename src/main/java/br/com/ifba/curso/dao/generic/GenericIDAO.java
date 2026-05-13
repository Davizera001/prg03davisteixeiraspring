/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.curso.dao.generic;
import java.util.List; // importa a classe List para trabalhar com listas

/**
 *
 * @author Davi
 */
public interface GenericIDAO<T> { // cria uma interface genérica que funciona para qualquer entidade

    public void salvar(T objeto); // método para salvar um objeto no banco

    public void atualizar(T objeto); // método para atualizar um objeto no banco

    public void deletar(T objeto); // método para deletar um objeto do banco

    public T buscarPorId(Long id); // método para buscar um objeto pelo id

    public List<T> listarTodos(); // método para listar todos os objetos
}
