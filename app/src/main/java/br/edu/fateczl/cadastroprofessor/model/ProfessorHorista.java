package br.edu.fateczl.cadastroprofessor.model;

import androidx.annotation.NonNull;

import java.time.LocalDate;
import java.time.Month;

public class ProfessorHorista extends Professor {
    private int horasAula;
    private double valorHoraAula;

    public ProfessorHorista() {
        super();
    }

    public int getHorasAula() {
        return horasAula;
    }

    public void setHorasAula(int horasAula) {
        if (horasAula < 1) {
            this.horasAula = 1;
        } else {
            this.horasAula = horasAula;
        }
    }

    public double getValorHoraAula() {
        return valorHoraAula;
    }

    public void setValorHoraAula(double valorHoraAula) {
        this.valorHoraAula = valorHoraAula;
    }

    @Override
    public double calcSalario() {
        return this.valorHoraAula * this.horasAula;
    }

    @NonNull
    @Override
    public String toString() {
        return getNomeProfessor() + ", " + getCodProfessor() + ", " + getIdade() + ", " +
                getHorasAula() + ", " + getValorHoraAula();
    }
}
