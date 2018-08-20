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

import Joaninha.Interface.EntidadeBase;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rafael
 */
@Entity
@Table(name = "tb_grupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groups.findAll", query = "SELECT g FROM Grupo g"),
    @NamedQuery(name = "Groups.findId", query = "SELECT g FROM Grupo g WHERE g.id = :id"),
    @NamedQuery(name = "Groups.findByGrupoNome", query = "SELECT g FROM Grupo g WHERE g.grupoNome = :grupoNome"),
    @NamedQuery(name = "Groups.findByGrupoTipo", query = "SELECT g FROM Grupo g WHERE g.grupoTipo = :grupoTipo")})
public class Grupo implements EntidadeBase, Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "grupo_nome", nullable = false, length = 250, unique = true)
    @NotNull(message = "O nome do grupo não poder ser nulo")
    private String grupoNome;
    
    @Column(name = "grupo_tipo", nullable = false, length = 250)
    @NotNull(message = "A sigla do grupo não poder ser nula")
    private String grupoTipo;

    @Version
    private Integer version;
        
    public Grupo() {
    }

    public Grupo(Integer id) {
        this.id = id;
    }

    public Grupo(String grupoNome, String grupoTipo) {
        this.grupoNome = grupoNome;
        this.grupoTipo = grupoTipo;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGrupoNome() {
        return grupoNome;
    }

    public void setGrupoNome(String grupoNome) {
        this.grupoNome = grupoNome;
    }

    public String getGrupoTipo() {
        return grupoTipo;
    }

    public void setGrupoTipo(String grupoTipo) {
        this.grupoTipo = grupoTipo;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Grupo other = (Grupo) obj;
        return Objects.equals(this.id, other.id);
    }
   
}
