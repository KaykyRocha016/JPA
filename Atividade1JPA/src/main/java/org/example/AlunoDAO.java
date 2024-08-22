package org.example;

import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Objects;

public class AlunoDAO {
    private EntityManager em;

    public AlunoDAO(EntityManager em) {
        this.em = em;
    }
    public void insert(Aluno aluno){
        em.persist(aluno);

    }
    public Aluno findOne(String nome){
        return (Aluno) em.createQuery("select a from Aluno a  where a.nome=:n").setParameter("n",nome).getSingleResult();

    }
    public void delete(String nome){
        String jpql="Delete from Aluno a where a.nome=:n";
        em.createQuery(jpql).setParameter("n", nome).executeUpdate();




    }
    public List<Aluno> findAll() {

        String jpql = "SELECT a FROM Aluno a";
        return em.createQuery(jpql, Aluno.class).getResultList();
    }
    public void update(Aluno aluno) {
        // Primeiro, encontre o aluno existente pelo nome (ou ID, se disponível)
        Aluno existingAluno = findOne(aluno.getNome());

        if (existingAluno != null) {
            // Atualize os campos necessários
            existingAluno.setNota1(aluno.getNota1());
            existingAluno.setNota2(aluno.getNota2());
            existingAluno.setNota3(aluno.getNota3());
            existingAluno.setEmail(aluno.getEmail());

            // Não é necessário uma consulta de update manual, apenas faça merge
            em.merge(existingAluno);
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public void deleteAll(){
        String jpql="delete from Aluno a";
        em.createQuery(jpql).executeUpdate();


    }
    
}
