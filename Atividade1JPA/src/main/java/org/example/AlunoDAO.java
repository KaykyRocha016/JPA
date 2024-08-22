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
    public Aluno findOne(Long id){
        return em.find(Aluno.class,id);

    }
    public void delete(Long id){
        Aluno aluno = findOne(id);
        if(aluno!=null) {
            em.remove(aluno);
        }


    }
    public List<Aluno> findAll() {

        String jpql = "SELECT a FROM Aluno a";
        return em.createQuery(jpql, Aluno.class).getResultList();
    }
    public void update(Aluno a){
        String jpql="UPDATE Aluno a set a.nome=:nome, a.nota1=:nt1, nota2=:nt2, nota3=:nt3 where a.nome= :n";
        em.createQuery(jpql,Aluno.class).setParameter("nome",a.getNome()).setParameter("nt1",a.getNota1()).setParameter("nt2",a.getNota2())
                .setParameter("nt3",a.getNota3()).setParameter("n",a.getNome());

    }
    
}
