package com.example.sistemaabc;

import DBConections.Estudiante_DAO;
import POJO.Estudiante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class ListaEstudiantesController implements Initializable {
    @FXML
    public TableView <Estudiante> tb_Estudiantes;
    @FXML
    public TableColumn <Estudiante, String> clmn_primerNom;
    @FXML
    public  TableColumn <Estudiante, String> clmn_segundoNom;
    @FXML
    public TableColumn <Estudiante, String> clmn_apellidoPat;
    @FXML
    public TableColumn <Estudiante, String> clmn_apellidoMat;
    @FXML
    private Button button_Visualizar;
    @FXML
    private Button button_Agregar;
    @FXML
    private Button button_Borrar;

    ObservableList<Estudiante> observableEstudiante;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            llenarTablaEstudiantes();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    protected void agregar(ActionEvent actionEvent){
        Ventana.iniciarVentana(button_Agregar, new AgregarController(), "agregar-view.fxml", Ventana.NO_CERRAR);
    }

    @FXML
    protected void consultarPorBtn(ActionEvent actionEvent){
        Estudiante estudiante = this.tb_Estudiantes.getSelectionModel().getSelectedItem();
        if(estudiante != null){
            Ventana.iniciarVentana(button_Visualizar, new ConsultarController(estudiante), "consultar-view.fxml", Ventana.NO_CERRAR);
        }
    }

    @FXML
    protected void borrar(ActionEvent actionEvent){
        Estudiante estudiante = this.tb_Estudiantes.getSelectionModel().getSelectedItem();
        if(estudiante != null){
            try{
                Estudiante_DAO estudiante_dao = new Estudiante_DAO();
                estudiante_dao.borrar(estudiante);

                Alert alertaConfirmacion = new Alert(Alert.AlertType.CONFIRMATION);
                alertaConfirmacion.setHeaderText(null);
                alertaConfirmacion.setTitle("Información");
                alertaConfirmacion.setContentText("Se ha elimado el estudiante.");
                alertaConfirmacion.showAndWait();
            }catch (Exception ex){
                Alert alertaConfirmacion = new Alert(Alert.AlertType.WARNING);
                alertaConfirmacion.setHeaderText(null);
                alertaConfirmacion.setTitle("Alerta");
                alertaConfirmacion.setContentText("Error en la conexión." + ex);
                alertaConfirmacion.showAndWait();
            }
        }
    }

    private void llenarTablaEstudiantes() throws SQLException {
        this.clmn_primerNom.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("primerNombre"));
        this.clmn_segundoNom.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("segundoNombre"));
        this.clmn_apellidoPat.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("primerApellido"));
        this.clmn_apellidoMat.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("segundoApellido"));

        Estudiante_DAO estudiante_dao = new Estudiante_DAO();
        List<Estudiante> listaEstudiante = Estudiante_DAO.getEstudiantesActivos();

        observableEstudiante = FXCollections.observableArrayList(listaEstudiante);
        this.tb_Estudiantes.setItems(observableEstudiante);
    }
}