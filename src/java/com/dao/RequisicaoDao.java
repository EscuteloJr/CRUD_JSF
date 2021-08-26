/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Requisicao;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author escutelo
 */
@Stateful
public class RequisicaoDao<Tipo> extends DaoGenerico<Tipo> implements Serializable{

    public RequisicaoDao() {
        super();
        classPersistente = Requisicao.class;
    }
    
}
