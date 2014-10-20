package mx.com.ccplus.buscador.tabla;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import mx.com.ccplus.buscador.BuscadorInit;

public class Buscador_FXMLController implements Initializable {
    
    @FXML
    TextField campo;

    @FXML
    TableView<PersonaModel> tabla;
    
    @FXML
    TableColumn<PersonaModel, String> colCuenta;
    
    @FXML
    TableColumn<PersonaModel, String> colNombre;
    
    private ObservableList<PersonaModel> lista = FXCollections.observableArrayList();
    private FilteredList<PersonaModel> filteredData;
    private SortedList<PersonaModel> sortedData;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BuscadorInit.flagTabla = false;
        assignColumns();
        populateData();
        applyFilter();
        tabla.setItems(sortedData);
    }    
    
    public void assignColumns(){
        colCuenta.setCellValueFactory( new PropertyValueFactory<PersonaModel, String>("cuenta"));
        colNombre.setCellValueFactory( new PropertyValueFactory<PersonaModel, String>("nombre"));
        
        colCuenta.setCellFactory(new Callback<TableColumn<PersonaModel, String>, TableCell<PersonaModel, String>>() {
            
            public TableCell call(TableColumn p) {
                                
                TableCell cell = new TableCell<PersonaModel, String>() {
                    
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
                        setGraphic(null);
                    }

                    private String getString() {
                        return getItem() == null ? "" : getItem().toString();
                    }
                };
                
                cell.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (event.getClickCount() > 1) {
                            TableCell c = (TableCell) event.getSource();
                            BuscadorInit.res1 = c.getText();
                            BuscadorInit.flagTabla = true;
                            ((Node)(event.getSource())).getScene().getWindow().hide();
                        }
                    }
                });
                
                return cell;
                
            }
            
        });
                        
                            
    }
    
    public void populateData(){
        
        for (String[] alumno : BuscadorInit.lista) {
            this.lista.add(new PersonaModel(alumno[0], alumno[1]));
        }
        
    }
    
    public void applyFilter(){
        filteredData = new FilteredList<>(lista, p -> true);
        campo.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(personaModel -> {
                
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                
                String texto = newValue.toLowerCase();
                
                if(personaModel.getCuenta().toLowerCase().indexOf(texto) != -1) return true;
                if(personaModel.getNombre().toLowerCase().indexOf(texto) != -1) return true;
                
                return false;
                
            });
        });
        sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tabla.comparatorProperty());
    }
    
}
