package Joaninha.Model.Bean;

import Joaninha.Connection.ConnectionFactory;
import javax.persistence.EntityManager;

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
/**
 *
 * @author rafael
 */
public class NewClass {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        Usuario u = new Usuario();
        u.setUser("teste");

        EntityManager em = new ConnectionFactory().getConnection();

        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();

        em.close();


    }
}
