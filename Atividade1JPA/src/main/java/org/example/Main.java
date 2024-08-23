package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int i;
        EntityManager em = JPAUtil.getEntityManager();
        AlunoDAO dao=new AlunoDAO(em);
        Scanner scan=new Scanner(System.in);
        Aluno aluno;
        do {
            String nome;
            String email;
            BigDecimal n1;
            BigDecimal n2;
            BigDecimal n3;
            System.out.println("*Cadastro de alunos\n" +
                    "selecione uma opção\n" +
                    "1---Cadastrar Aluno\n" +
                    "2---Excluir Aluno\n" +
                    "3---Alterar Dados\n" +
                    "4---Buscar Aluno Pelo Nome\n" +
                    "5---Listar Alunos\n" +
                    "6---Apagar Todos Os Alunos\n"+
                    "0---sair\n");
            i=Integer.parseInt(scan.nextLine());
            switch (i){
                case 1:
                    aluno = setData(scan);

                    em.getTransaction().begin();
                    dao.insert(aluno);
                    em.getTransaction().commit();

                    break;


                case 2:
                    System.out.println("digite o nome do aluno que será deletado");
                    nome=scan.nextLine();
                    em.getTransaction().begin();
                    dao.delete(nome);
                    em.getTransaction().commit();
                    break;
                case 3:

                    System.out.println("Digite o nome do aluno que deseja atualizar:");
                    nome = scan.nextLine();

                    // Recupere o aluno existente
                    aluno = dao.findOne(nome);

                    if (aluno != null) {
                        // Atualize os dados
                        System.out.println("Digite o novo email:");
                        email = scan.nextLine();
                        System.out.println("Digite a primeira nota:");
                        n1 = BigDecimal.valueOf(Float.parseFloat(scan.nextLine()));
                        System.out.println("Digite a segunda nota:");
                        n2 = BigDecimal.valueOf(Float.parseFloat(scan.nextLine()));
                        System.out.println("Digite a terceira nota:");
                        n3 = BigDecimal.valueOf(Float.parseFloat(scan.nextLine()));

                        aluno.setEmail(email);
                        aluno.setNota1(n1);
                        aluno.setNota2(n2);
                        aluno.setNota3(n3);

                        em.getTransaction().begin();
                        dao.update(aluno);
                        em.getTransaction().commit();
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("digite o nome do aluno");
                    nome=scan.nextLine();
                    System.out.println(dao.findOne(nome));
                    break;

                case 5:
                    System.out.println("listando alunos");
                    System.out.println(dao.findAll());
                    break;
                case 6:
                    em.getTransaction().begin();
                    dao.deleteAll();
                    em.getTransaction().commit();

                    break;
                case 0:
                    System.out.println("encerrando programa");
                    em.close();
                    break;
                default:
                    System.out.println("opção invalida, tente novamente");
                    break;










            }



        }while(i!=0);




    }

    private static Aluno setData(Scanner scan) {
        String email;
        String nome;
        BigDecimal n3;
        BigDecimal n1;
        BigDecimal n2;
        Aluno aluno;
        System.out.println("digite o nome");
        nome= scan.nextLine();
        System.out.println("digite o email");
        email= scan.nextLine();
        System.out.println("Digite a primeira nota");
        n1= new BigDecimal(scan.nextLine());
        System.out.println("Digite a segunda nota");
        n2=new BigDecimal(scan.nextLine());
        System.out.println("Digite a terceira nota");
        n3= new BigDecimal(scan.nextLine());

        aluno=new Aluno();

        aluno.setNome(nome);
        aluno.setEmail(email);
        aluno.setNota1(n1);
        aluno.setNota2(n2);
        aluno.setNota3(n3);
        return aluno;
    }
}