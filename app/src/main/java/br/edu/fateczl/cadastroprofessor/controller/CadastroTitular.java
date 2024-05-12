package br.edu.fateczl.cadastroprofessor.controller;

import br.edu.fateczl.cadastroprofessor.model.Professor;
import br.edu.fateczl.cadastroprofessor.model.ProfessorTitular;

public class CadastroTitular implements ICadastroFactory{
    @Override
    public Professor cadastrarProf(String nome, String mat, int idade, int anosInstituicao, double salarioAtual) {
        ProfessorTitular prof = new ProfessorTitular();
        prof.setNomeProfessor(nome);
        prof.setCodProfessor(mat);
        prof.setIdade(idade);
        prof.setAnosInstituicao(anosInstituicao);
        prof.setSalario(salarioAtual);
        return prof;
    }
}
