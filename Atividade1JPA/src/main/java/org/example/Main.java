package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int i;
        EntityManager em = JPAUtil.getEntityManager();
        AlunoDAO dao=new AlunoDAO(em);
        Scanner scan=new Scanner(System.in);
        do {
            String nome;
            BigDecimal n1;
            BigDecimal n2;
            BigDecimal n3;
            System.out.println("*Cadastro de alunos\n" +
                    "selecione uma opção\n" +
                    "1---Cadastrar Aluno\n" +
                    "2---Excluir Aluno\n" +
                    "3---Alterar Dados\n" +
                    "4---Buscar Aluno Pelo Nome" +
                    "5---Listar Alunos" +
                    "0---sair");
            i=scan.nextInt();
            switch (i){
                case 1:

            }



        }while(i!=0);




    }
}