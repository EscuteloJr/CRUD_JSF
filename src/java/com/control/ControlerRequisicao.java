/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.control;

import com.dao.RequisicaoDao;
import com.model.Requisicao;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author escutelo
 */
@Named(value = "controleRequisicao")
@ViewScoped
public class ControlerRequisicao implements Serializable{
    
      @EJB
      private Requisicao requisicao = new Requisicao();
      private RequisicaoDao<Requisicao> RDao;

    public ControlerRequisicao() {
    }
    
    public void nova() throws Exception{
        requisicao = new Requisicao();
    }
    
    public void salvar(){
       
            try {
               if(requisicao.getPk_requisicao() == null)
                    RDao.adicionar(requisicao);
               else
                   RDao.merge(requisicao);
                
        } catch (Exception ex) {
            Logger.getLogger(ControlerRequisicao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Requisicao> listar(){
        return RDao.get3Ultimos();
    }
    
    
    public Requisicao getRequisicao() {
        return requisicao;
    }

    public void setRequisicao(Requisicao requisicao) {
        this.requisicao = requisicao;
    }

    public RequisicaoDao<Requisicao> getRDao() {
        return RDao;
    }

    public void setRDao(RequisicaoDao<Requisicao> RDao) {
        this.RDao = RDao;
    }
      
       

 
}
