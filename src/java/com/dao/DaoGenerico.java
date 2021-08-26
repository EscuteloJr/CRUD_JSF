/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author escutelo
 */
public class DaoGenerico <Tipo> implements Serializable{
    
    private List<Tipo> listaObjectos;
    private List<Tipo> listaTodos;
    @PersistenceContext(unitName = "PROJECTOPU")
    protected EntityManager em;
    protected Class classPersistente;
    private String SQL;

    public DaoGenerico() {
    }
    
    

    /**
     * @return the listaObjectos
     */
    public List<Tipo> getListaObjectos() {
        SQL = "FROM " + classPersistente.getCanonicalName();
        return em.createQuery(SQL).getResultList();
    }
    
     public List<Tipo> getListaTodos() {
        SQL = "FROM " + classPersistente.getCanonicalName();
        return em.createQuery(SQL).getResultList();
    }
     
    public void adicionar(Tipo t) throws Exception{
        em.persist(t);
    } 
    
    public void remover(Tipo t) throws Exception{
        em.merge(t);
        em.remove(t);
    }
    
    public void merge(Tipo t)throws Exception{
        em.merge(t);
    }
    
    public List<Tipo> get3Ultimos(){
        List <Tipo> lista = getListaTodos();
        List <Tipo> listaAux = null;
        int size = lista.size();
        
        for(int i = lista.size() - 3; i < size; i ++){
            listaAux.add(lista.get(i));
        }
        return listaAux;
    }
     
    /**
     * @param listaObjectos the listaObjectos to set
     */
    public void setListaObjectos(List<Tipo> listaObjectos) {
        this.listaObjectos = listaObjectos;
    }

    /**
     * @return the listaTodos
     */
   

    /**
     * @param listaTodos the listaTodos to set
     */
    public void setListaTodos(List<Tipo> listaTodos) {
        this.listaTodos = listaTodos;
    }

    /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }

    /**
     * @param em the em to set
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }

    /**
     * @return the classPersistente
     */
    public Class getClassPersistente() {
        return classPersistente;
    }

    /**
     * @param classPersistente the classPersistente to set
     */
    public void setClassPersistente(Class classPersistente) {
        this.classPersistente = classPersistente;
    }
    
    
    
}
