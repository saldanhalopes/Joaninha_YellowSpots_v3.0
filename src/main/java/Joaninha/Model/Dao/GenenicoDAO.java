/*
 * Copyright (C) 2018 rafael
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package Joaninha.Model.Dao;

import Joaninha.Model.Bean.EntidadeBase;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author rafael
 * @param <T>
 */
public class GenenicoDAO<T extends EntidadeBase> {

    public EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JoaninhaPU");
        return emf.createEntityManager();
    }

    public T salvar(T t) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            if (t.getId() == null) {
                em.persist(t);
            } else {
                if (!em.contains(t)) {
                    if (em.find(t.getClass(), t.getId()) == null) {
                        throw new Exception("Erro ao Atualizar!");
                    }
                }
                t = em.merge(t);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return t;
    }

    public void remover(Class<T> cls, Integer id) throws Exception {
        EntityManager em = getEntityManager();
        T t = em.find(cls, id);
        try {
            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(ex);
        } finally {
            em.close();
        }
    }

    public T findById(Class<T> cls, Integer id) throws Exception {
        EntityManager em = getEntityManager();
        T t = null;
        try {
            t = em.find(cls, id);
        } catch (Exception ex) {
            throw new Exception(ex);
        } finally {
            em.close();
        }
        return t;
    }

    public List<T> findEntities(Class<T> cls) {
        return findEntities(cls, true, -1, -1);
    }

    public List<T> findEntities(Class<T> cls, int maxResults, int firstResult) {
        return findEntities(cls, false, maxResults, firstResult);
    }

    private List<T> findEntities(Class<T> cls, boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(cls));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public int getCount(Class<T> cls) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<T> rt = cq.from(cls);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
