package br.edu.fateczl.cadastroprofessor.model;

import androidx.annotation.NonNull;

public abstract class Professor {
    private String nomeProfessor;
    private String codProfessor;
    private int idade;

    public Professor() {
        super();
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getCodProfessor() {
        return codProfessor;
    }

    public void setCodProfessor(String codProfessor) {
        this.codProfessor = codProfessor;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public abstract double calcSalario();

    @NonNull
    @Override
    public String toString() {
        return "Professor{" +
                "nomeProfessor='" + nomeProfessor + '\'' +
                ", codProfessor='" + codProfessor + '\'' +
                ", idade=" + idade +
                '}';
    }
}
