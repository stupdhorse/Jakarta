/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ola.jsf_licznikodwiedzin;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import jakarta.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author olaba
 */
@Named(value = "counterBean")
@SessionScoped
public class CounterBean implements Serializable {

    private int count = 0;

    public void increment() {
        count++;
    }
    
    public void reset(){
        count = -1;
    }
    
    public int getCount(){
        increment();
        return count;
    }
}
