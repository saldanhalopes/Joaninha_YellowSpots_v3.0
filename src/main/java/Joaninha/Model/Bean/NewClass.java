package Joaninha.Model.Bean;

import Joaninha.Model.Dao.UsuarioDAO;

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
        
        UsuarioDAO uDAO = new UsuarioDAO();
        Usuario u = new Usuario();
        u.setUser("teste2");
        
        try {
            uDAO.salvar(u);
            for(Usuario user : uDAO.findEntities(Usuario.class)){
                System.out.println("Usuario: " + user.getUser());
            }
            //System.out.println(uDAO.findById(Usuario.class, 1L));


        } catch (Exception e) {
        }
        

    }
}
