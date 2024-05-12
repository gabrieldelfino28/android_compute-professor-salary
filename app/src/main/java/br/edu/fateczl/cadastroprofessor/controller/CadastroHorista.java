package br.edu.fateczl.cadastroprofessor.controller;

import br.edu.fateczl.cadastroprofessor.model.Professor;
import br.edu.fateczl.cadastroprofessor.model.ProfessorHorista;

public class CadastroHorista implements ICadastroFactory{

    @Override
    public Professor cadastrarProf(String nome, String mat, int idade, int horasTrabalhadas, double valorHora) {
        ProfessorHorista prof = new ProfessorHorista();
        prof.setNomeProfessor(nome);
        prof.setCodProfessor(mat);
        prof.setIdade(idade);
        prof.setHorasAula(horasTrabalhadas);
        prof.setValorHoraAula(valorHora);
        return prof;
    }
}
