/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import clases.Perfil;
import clases.Producto;
import clases.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Informatica
 */
@Stateless
public class Servicio implements ServicioLocal {

    @PersistenceContext(unitName = "pets_3331PU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    //Use EntityManager
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Perfil> getPerfiles() {
        return em.createQuery("select p from Perfil p").getResultList();
    }

    @Override
    public List<Producto> getProductos() {
        return em.createQuery("select p from Producto p").getResultList();
    }

    @Override
    public Usuario iniciarSesion(String rut, String clave) {
        try{
            return (Usuario)em.createNamedQuery("Usuario.iniciarSesion",Usuario.class)
                    .setParameter("rutUser",rut).setParameter("clave",clave).getSingleResult();
            
        }
        catch(Exception e)
        {
            return null;
        }
    }

    @Override
    public Usuario buscarUsuario(String rut) {
        return em.find(Usuario.class,rut);
    }

    @Override
    public void guardar(Object object) {
        em.persist(object);
    }
    
    
    
    
    
    
    
    
}
