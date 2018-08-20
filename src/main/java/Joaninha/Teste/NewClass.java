package Joaninha.Teste;

import Joaninha.Model.Bean.Grupo;
import Joaninha.Model.Bean.Setor;
import Joaninha.Model.Bean.Usuario;
import Joaninha.Model.Dao.GrupoDAO;
import Joaninha.Model.Dao.SetorDAO;
import Joaninha.Model.Dao.UsuarioDAO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import static jdk.nashorn.internal.objects.NativeError.printStackTrace;
import joaninha.util.DataHora;

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
        SetorDAO sDAO = new SetorDAO();
        Setor s = new Setor(1);

        GrupoDAO gDAO = new GrupoDAO();
        Grupo g = new Grupo(1);

        Usuario u = new Usuario();
        u.setUsuario("rlopes");
        u.setNome("Rafael");
        u.setPass("123");
        u.setCracha("123");
        u.setEmail("123");
        u.setTurno("1T");
        u.setCreated(DataHora.getTimestampDate(new Date()));
        u.setLastlogin(DataHora.getTimestampDate(new Date()));
        u.setGrupo(g);
        u.setSetor(s);
        u.setChange_pass(true);
        u.setComputador_nome("pc");
        u.setComputador_usuario("rsl");
        u.setVersion(1);

        System.out.println(u.toString());

        try {
            System.out.println(new java.sql.Date(new Date().getTime()));
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            //sDAO.salvar(s);
            //gDAO.salvar(g);
            // uDAO.salvar(u);

//              
//            for(Grupo grupo : gDAO.findEntities(Grupo.class)){
//                System.out.println("Grupo: " + grupo.getGrupoNome());
//            }
            //           System.out.println(gDAO.findById(Grupo.class, 1).getGrupoNome());
        } catch (Exception e) {
            //printStackTrace(e.toString());
            System.out.println(e.toString());
        }

    }
}
