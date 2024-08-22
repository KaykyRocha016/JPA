package org.example;

import jakarta.persistence.*;

import java.math.BigDecimal;
@Entity
@Table(name="alunos")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private BigDecimal nota1;
    private BigDecimal nota2;
    private BigDecimal nota3;
    public void setId(Long id){
        this.id=id;


    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNota1(BigDecimal nota1) {
        this.nota1 = nota1;
    }

    public void setNota2(BigDecimal nota2) {
        this.nota2 = nota2;
    }

    public void setNota3(BigDecimal nota3) {
        this.nota3 = nota3;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public BigDecimal getNota1() {
        return nota1;
    }

    public BigDecimal getNota2() {
        return nota2;
    }

    public BigDecimal getNota3() {
        return nota3;
    }

    public Aluno ( String nome, String email, BigDecimal nota1, BigDecimal nota2, BigDecimal nota3){

        this.nome = nome;
        this.email = email;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }
    public Aluno(){};

    @Override
    public String toString() {
        return "\nAluno{" +
                "\n id=" + id +
                "\n nome='" + nome + '\'' +
                "\n email='" + email + '\'' +
                "\n nota1=" + nota1 +
                "\n nota2=" + nota2 +
                "\n nota3=" + nota3 +
                '}';
    }
}
