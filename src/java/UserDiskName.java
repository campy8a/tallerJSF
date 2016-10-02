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
@Named(value = "UserDiskName")
@SessionScoped
public class UserDiskName implements Serializable {

    
        String nombre;
    
    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }
    
    /**
     * Creates a new instance of UserDiskName
     */
    public UserDiskName() 
    {
        
    }
    
    
}
