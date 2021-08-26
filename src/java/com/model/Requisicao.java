/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author escutelo
 */
@Entity
@Table(name = "tb_requisicao")
public class Requisicao implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_requisica", sequenceName = "seq_requisicao_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_requisica", strategy = GenerationType.SEQUENCE)
    private Integer pk_requisicao;
    @Column(name = "descricao", nullable = false, length = 250)
    private String descricao;

    /**
     * @return the pk_requisicao
     */
    public Integer getPk_requisicao() {
        return pk_requisicao;
    }

    /**
     * @param pk_requisicao the pk_requisicao to set
     */
    public void setPk_requisicao(Integer pk_requisicao) {
        this.pk_requisicao = pk_requisicao;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Requisicao other = (Requisicao) obj;
        if (!Objects.equals(this.pk_requisicao, other.pk_requisicao)) {
            return false;
        }
        return true;
    }
    
    
     
}
