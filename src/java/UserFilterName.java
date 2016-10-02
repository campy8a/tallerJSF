/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author FCampy
 */
@Named(value = "userFilterName")
@SessionScoped
public class UserFilterName implements Serializable {
    
    String textoFiltro;

    public String getTextoFiltro() {
        return textoFiltro;
    }

    public void setTextoFiltro(String textoFiltro) {
        this.textoFiltro = textoFiltro;
    }

    /**
     * Creates a new instance of UserFilterName
     */
    public UserFilterName() {
    }
    
}
