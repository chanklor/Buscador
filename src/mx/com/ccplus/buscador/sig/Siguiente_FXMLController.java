/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.ccplus.buscador.sig;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import mx.com.ccplus.buscador.BuscadorInit;

/**
 * FXML Controller class
 *
 * @author chanklor
 */
public class Siguiente_FXMLController implements Initializable {
    
    

    @FXML
    Parent root;
    
    @FXML
    TextField campo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        campo.setText(BuscadorInit.sigMemo);
        BuscadorInit.flagSigAnt = false;
        
    }  
    
    @FXML
    private void botonSiguiente(MouseEvent event){
                
        String busqueda = campo.getText();
        
        if(!busqueda.equals("")){
            
            String cuenta = null;
            
            int id_actual = -1;
            if(!BuscadorInit.campo.getText().equals("")){
                try{
                    id_actual = Integer.parseInt(BuscadorInit.campo.getText()); 
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            
            System.out.println("id_actual: " + id_actual);
            
            int indice_actual = 0;
            for (int i = 0; i < BuscadorInit.lista.size(); i++) {
                System.out.println("for: " + i);
                if(BuscadorInit.lista.get(i)[0].equals(Integer.toString(id_actual))){
                    indice_actual = i;
                    System.out.println("entro if");
                }
            }
            
            System.out.println("indice_actual: " + indice_actual);
            
            for (int i = (indice_actual+1); i < BuscadorInit.lista.size(); i++) {
                
                if(BuscadorInit.lista.get(i)[0].toLowerCase().indexOf(busqueda) != -1 || BuscadorInit.lista.get(i)[1].toLowerCase().indexOf(busqueda) != -1){
                    cuenta = BuscadorInit.lista.get(i)[0];
                    break;
                }
            }
            if(cuenta == null){
                for (int i = 0; i <= indice_actual; i++) {
                    if(BuscadorInit.lista.get(i)[0].toLowerCase().indexOf(busqueda) != -1 || BuscadorInit.lista.get(i)[1].toLowerCase().indexOf(busqueda) != -1){
                        cuenta = BuscadorInit.lista.get(i)[0];
                        break;
                    }
                }
            }
            
            if(cuenta != null){
                BuscadorInit.res1 = cuenta;
                BuscadorInit.sigMemo = campo.getText();
                BuscadorInit.flagSigAnt = true;
                ((Node)(event.getSource())).getScene().getWindow().hide();
            }else{
                campo.setText("");
            }
        }
    }
    
    @FXML
    private void botonAnterior(MouseEvent event){
        String busqueda = campo.getText();
        
        if(!busqueda.equals("")){
            
            String cuenta = null;
            
            int id_actual = -1;
            if(!BuscadorInit.campo.getText().equals("")){
                try{
                    id_actual = Integer.parseInt(BuscadorInit.campo.getText()); 
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            
            System.out.println("id_actual: " + id_actual);
            
            int indice_actual = 0;
            for (int i = 0; i < BuscadorInit.lista.size(); i++) {
                System.out.println("for: " + i);
                if(BuscadorInit.lista.get(i)[0].equals(Integer.toString(id_actual))){
                    indice_actual = i;
                    System.out.println("entro if");
                }
            }
            
            System.out.println("indice_actual: " + indice_actual);
            
            for (int i = (indice_actual-1); i >= 0; i--) {
                
                if(BuscadorInit.lista.get(i)[0].toLowerCase().indexOf(busqueda) != -1 || BuscadorInit.lista.get(i)[1].toLowerCase().indexOf(busqueda) != -1){
                    cuenta = BuscadorInit.lista.get(i)[0];
                    break;
                }
            }
            if(cuenta == null){
                for (int i = BuscadorInit.lista.size()-1; i >= indice_actual; i--) {
                    if(BuscadorInit.lista.get(i)[0].toLowerCase().indexOf(busqueda) != -1 || BuscadorInit.lista.get(i)[1].toLowerCase().indexOf(busqueda) != -1){
                        cuenta = BuscadorInit.lista.get(i)[0];
                        break;
                    }
                }
            }
            
            if(cuenta != null){
                BuscadorInit.res1 = cuenta;
                BuscadorInit.sigMemo = campo.getText();
                BuscadorInit.flagSigAnt = true;
                ((Node)(event.getSource())).getScene().getWindow().hide();
            }else{
                campo.setText("");
            }
        }
    }
    
    @FXML
    private void botonSalir(MouseEvent event){
        
    }
    
    
    
}
