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
package Joaninha.Model.Bean;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author rafael
 */
@Entity
@Table(name = "tb_users")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer user_id;
    
    @Column(name = "usuario")
    private String user_name;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "pass")
    private String pass;
    
    @Column(name = "created")
    private Timestamp created;
    
    @Column(name = "change_pass")
    private Boolean change_pass;
    
    @Column(name = "lock")
    private Boolean lock;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "acesso")
    private String acesso;
    
    @Column(name = "lastlogin")
    private Timestamp lastlogin;
    
    @Column(name = "lastlogout")
    private Timestamp lastlogout;
    
    @Column(name = "cracha")
    private String cracha;
    
    @Column(name = "computador")
    private String computador;
    
    @Column(name = "user_computador")
    private String user_computador;
    
    @Column(name = "failed_access_count")
    private Integer failed_access_count;
    
    @Column(name = "turno")
    private String turno;

    public Usuario() {
    }

    public Usuario(String user_name, String pass) {
        this.user_name = user_name;
        this.pass = pass;
    }

    public Usuario(Integer user_id, String pass, Boolean change_pass, Boolean lock, Integer failed_access_count) {
        this.user_id = user_id;
        this.pass = pass;
        this.change_pass = change_pass;
        this.lock = lock;
        this.failed_access_count = failed_access_count;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser() {
        return user_name;
    }

    public void setUser(String user) {
        this.user_name = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Boolean getChange_pass() {
        return change_pass;
    }

    public void setChange_pass(Boolean change_pass) {
        this.change_pass = change_pass;
    }

    public Boolean getLock() {
        return lock;
    }

    public void setLock(Boolean lock) {
        this.lock = lock;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAcesso() {
        return acesso;
    }

    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }

    public Timestamp getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Timestamp lastlogin) {
        this.lastlogin = lastlogin;
    }

    public Timestamp getLastlogout() {
        return lastlogout;
    }

    public void setLastlogout(Timestamp lastlogout) {
        this.lastlogout = lastlogout;
    }

    public String getCracha() {
        return cracha;
    }

    public void setCracha(String cracha) {
        this.cracha = cracha;
    }

    public String getComputador() {
        return computador;
    }

    public void setComputador(String computador) {
        this.computador = computador;
    }

    public String getUser_computador() {
        return user_computador;
    }

    public void setUser_computador(String user_computador) {
        this.user_computador = user_computador;
    }

    public Integer getFailed_access_count() {
        return failed_access_count;
    }

    public void setFailed_access_count(Integer failed_access_count) {
        this.failed_access_count = failed_access_count;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    

    
    
    
}