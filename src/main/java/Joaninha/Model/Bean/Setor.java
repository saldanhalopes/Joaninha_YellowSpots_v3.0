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

/**
 *
 * @author rafael
 */
@Entity
@Table(name = "tb_setor")
@NamedQueries({
    @NamedQuery(name = "Setor.findAll", query = "SELECT s FROM Setor s"),
    @NamedQuery(name = "Setor.findBySetorId", query = "SELECT s FROM Setor s WHERE s.id = :id"),
    @NamedQuery(name = "Setor.findBySetor", query = "SELECT s FROM Setor s WHERE s.setor = :setor"),
    @NamedQuery(name = "Setor.findBySiglaSetor", query = "SELECT s FROM Setor s WHERE s.siglaSetor = :siglaSetor"),
    @NamedQuery(name = "Setor.findByDescricaoSetor", query = "SELECT s FROM Setor s WHERE s.descricaoSetor = :descricaoSetor")})
public class Setor implements EntidadeBase, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "setor", nullable = false, length = 250, unique = true)
    @NotNull(message = "O nome do setor não poder ser nulo")
    private String setor;

    @Column(name = "sigla_setor", nullable = false, length = 250)
    @NotNull(message = "A sigla do setor não poder ser nula")
    private String siglaSetor;

    @Column(name = "descricao_setor", nullable = true, length = 250)
    private String descricaoSetor;

    @Version
    private Integer version;

    public Setor() {
    }
    
    public Setor(String setor, String siglaSetor, String descricaoSetor) {
        this.setor = setor;
        this.siglaSetor = siglaSetor;
        this.descricaoSetor = descricaoSetor;
    }
    

    public Setor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getSiglaSetor() {
        return siglaSetor;
    }

    public void setSiglaSetor(String siglaSetor) {
        this.siglaSetor = siglaSetor;
    }

    public String getDescricaoSetor() {
        return descricaoSetor;
    }

    public void setDescricaoSetor(String descricaoSetor) {
        this.descricaoSetor = descricaoSetor;
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
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Setor other = (Setor) obj;
        return Objects.equals(this.id, other.id);
    }


}
