package br.edu.fateczl.cadastroprofessor.model;

import androidx.annotation.NonNull;

import java.time.LocalDate;

public class ProfessorTitular extends Professor {
    private int anosInstituicao;
    private double salario;

    public ProfessorTitular() {
        super();
    }

    public int getAnosInstituicao() {
        return anosInstituicao;
    }

    public void setAnosInstituicao(int anosInstituicao) {
        if (anosInstituicao < 1980) {
            this.anosInstituicao = 1980;
        }else if (anosInstituicao >= LocalDate.now().getYear()){
            this.anosInstituicao = LocalDate.now().getYear();
        }else {
            this.anosInstituicao = anosInstituicao;
        }
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public double calcSalario() {
        int anoDiff = LocalDate.now().getYear() - anosInstituicao;

        setSalario(this.salario * Math.pow(1.05d, (anoDiff / 5d)));

        return getSalario();
    }

    @NonNull
    @Override
    public String toString() {
        return getNomeProfessor() + ", " + getCodProfessor() + ", " + getIdade() + ", " +
                getAnosInstituicao();
    }
}
