package mx.com.ccplus.buscador;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class BuscadorInit {
    
    public static String res1;
    public static boolean flagTabla = false;
    public static ArrayList<String[]> lista;
    public static boolean flagSigAnt = false;
    public static String sigMemo = "";
        
    private Parent root;
    public static TextField campo;
    
    public BuscadorInit(Parent root, TextField campo, ResultSet rs){
        sigMemo = "";
        flagSigAnt = false;
        this.campo = campo;
        this.root = root;
        lista = new ArrayList<String[]>();
        try{
            while(rs.next()){
                String[] alumno = {rs.getString(1), rs.getString(2)};
                lista.add(alumno);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public String buscarAlumnoTabla(){
        
        String resultado = campo.getText();
        
        try {
            FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("tabla/Buscador_FXML.fxml"));
            root = (Parent) fXMLLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            System.out.println("error al abrir buscador");
            e.printStackTrace();
        }
        
        return (flagTabla ? res1 : resultado);
        
    }
    
    public String buscarAlumnoSiguiente(){
        
        String resultado = campo.getText();
        
        try {
            FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("sig/Siguiente_FXML.fxml"));
            root = (Parent) fXMLLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            System.out.println("error al abrir buscador");
            e.printStackTrace();
        }

        return (flagSigAnt ? res1 : resultado);
    }
    
}
