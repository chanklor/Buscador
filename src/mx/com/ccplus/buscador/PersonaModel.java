package mx.com.ccplus.buscador;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author chanklor
 */
public class PersonaModel {
    
    private final StringProperty cuenta;
    private final StringProperty nombre;
    
    public PersonaModel(){
        this.cuenta = null;
        this.nombre = null;
    }
    
    public PersonaModel(String cuenta, String nombre){
        this.cuenta = new SimpleStringProperty(cuenta);
        this.nombre = new SimpleStringProperty(nombre);
    }
    
    public String getCuenta(){
        return cuenta.get();
    }
    
    public String getNombre(){
        return nombre.get();
    }
    
    public void setCuenta(String cuenta){
        this.cuenta.set(cuenta);
    }
    
    public void setNombre(String nombre){
        this.nombre.set(nombre);
    }
    
}
