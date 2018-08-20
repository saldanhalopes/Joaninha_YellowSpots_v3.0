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
package Joaninha.Connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author rafael
 */
public class ConnectionFactory {

    private static final ThreadLocal<EntityManager> threadLocal = new ThreadLocal<>();
    private static EntityManagerFactory factory;

    /**
     * Cria uma entity manager factory Ãºnica e o retorna em todas as demais
     * chamadas
     *
     * @return
     */
    public static EntityManagerFactory getFactory() {
        if (factory == null || !factory.isOpen()) {
            factory = Persistence.createEntityManagerFactory("JoaninhaPU");
        }
        return factory;
    }

    /**
     * Cria um entity manager unico (se criar = true) para a thread e o retorna
     * em todas as demais chamadas
     *
     * @param criar
     * @return
     */
    public static EntityManager em(boolean criar) {
        EntityManager em = (EntityManager) threadLocal.get();
        if (em == null || !em.isOpen()) {
            if (criar) {
                em = getFactory().createEntityManager();
                threadLocal.set(em);
            }
        } else {
            if (!criar) {
                em.close();
                factory.close();
            }
        }
        return em;
    }

    /**
     * Cria um entity manager Ãºnico para a thread e o retorna em todas as
     * demais chamadas
     *
     * @return
     */
    public static EntityManager em() {
        return em(true);
    }

}
