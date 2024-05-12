package br.edu.fateczl.cadastroprofessor.controller;

import br.edu.fateczl.cadastroprofessor.model.Professor;

public interface ICadastroFactory {
    Professor cadastrarProf(String nome, String mat, int idade, int hora_ano, double valorHora_salario);
}
