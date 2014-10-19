package mx.com.ccplus.buscador;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class BuscadorInit {
    
    public static String res1;
    public static ArrayList<String[]> lista;
    public static boolean flag = false;
    public static String query;
    public static ResultSet rs;
    
    private Parent root;
    private TextField campo;
    
//    public BuscadorInit(Parent root, TextField campo, ArrayList<String[]> lista){
//        this.campo = campo;
//        this.root = root;
//        this.lista = lista;
//    }
    
    public BuscadorInit(Parent root, TextField campo, ResultSet rs){
        this.campo = campo;
        this.root = root;
        this.rs = rs;
    }
    
    public String buscarAlumnoString(){
        
        String resultado = campo.getText();
        
        try {
            FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("Buscador_FXML.fxml"));
            root = (Parent) fXMLLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            System.out.println("error al abrir buscador");
            e.printStackTrace();
        }
        
        return (flag ? res1 : resultado);
        
    }
    
}
