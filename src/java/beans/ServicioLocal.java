/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import clases.Perfil;
import clases.Producto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Informatica
 */
@Local
public interface ServicioLocal {

    List<Perfil> getPerfiles();

    List<Producto> getProductos();
    
}
