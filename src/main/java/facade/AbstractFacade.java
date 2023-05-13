package facade;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import utility.JpaEntityManagerFactory;

import java.util.List;

public abstract class AbstractFacade<T> {

    protected EntityManager em = JpaEntityManagerFactory.getEntityManager();
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void create(T entity) {
        EntityManager em = JpaEntityManagerFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void edit(T entity) {
        EntityManager em = JpaEntityManagerFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void remove(T entity) {
        EntityManager em = JpaEntityManagerFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.merge(entity));
            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }

    public T find(Object id) {
        return em.find(entityClass, id);
    }

    public List<T> findAll() {
        EntityManager em = JpaEntityManagerFactory.getEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<T> cq = cb.createQuery(entityClass);
            Root<T> rootEntry = cq.from(entityClass);
            CriteriaQuery<T> all = cq.select(rootEntry);
            return em.createQuery(all).getResultList();
        } finally {
            em.close();
        }
    }

    public List<T> findRange(int[] range) {
        EntityManager em = JpaEntityManagerFactory.getEntityManager();
        try {
            CriteriaQuery<T> cq = em.getCriteriaBuilder().createQuery(entityClass);
            cq.select(cq.from(entityClass));
            jakarta.persistence.Query q = em.createQuery(cq);
            q.setMaxResults(range[1] - range[0]);
            q.setFirstResult(range[0]);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public int count() {
        EntityManager em = JpaEntityManagerFactory.getEntityManager();
        try {
            CriteriaQuery<Long> cq = em.getCriteriaBuilder().createQuery(Long.class);
            Root<T> rt = cq.from(entityClass);
            cq.select(em.getCriteriaBuilder().count(rt));
            jakarta.persistence.Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}