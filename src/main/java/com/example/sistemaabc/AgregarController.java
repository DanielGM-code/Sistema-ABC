package com.example.sistemaabc;

import DBConections.Estudiante_DAO;
import POJO.Estudiante;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

public class AgregarController implements Initializable {
    @FXML
    public Button button_Aceptar;
    @FXML
    public Button button_Cancelar;
    @FXML
    public TextField txtField_PrimerNombre;
    @FXML
    public TextField txtField_SegundoNombre;
    @FXML
    public TextField txtField_PrimerApellido;
    @FXML
    public TextField txtField_SegundoApellido;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UnaryOperator<TextFormatter.Change> characterFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("[a-zA-Z ]*")) {
                return change;
            } else {
                return null;
            }
        };

        txtField_PrimerNombre.setTextFormatter(new TextFormatter<String>(characterFilter));
        txtField_SegundoNombre.setTextFormatter(new TextFormatter<String>(characterFilter));
        txtField_PrimerApellido.setTextFormatter(new TextFormatter<String>(characterFilter));
        txtField_SegundoApellido.setTextFormatter(new TextFormatter<String>(characterFilter));
    }

    public void clickAceptar(ActionEvent actionEvent) throws SQLException {
        if(this.txtField_PrimerNombre.getText().isEmpty() || this.txtField_SegundoNombre.getText().isEmpty() ||
                this.txtField_PrimerApellido.getText().isEmpty() || this.txtField_SegundoApellido.getText().isEmpty()){
            Alert alertaConfirmacion = new Alert(Alert.AlertType.WARNING);
            alertaConfirmacion.setHeaderText(null);
            alertaConfirmacion.setTitle("Alerta");
            alertaConfirmacion.setContentText("Aegúrese de llenar todos los campos.");
            alertaConfirmacion.showAndWait();
        }else{
            Estudiante estudiante = new Estudiante();
            estudiante.setPrimerNombre(this.txtField_PrimerNombre.getText());
            estudiante.setSegundoNombre(this.txtField_SegundoNombre.getText());
            estudiante.setPrimerApellido(this.txtField_PrimerApellido.getText());
            estudiante.setSegundoApellido(this.txtField_SegundoApellido.getText());
            estudiante.setActivation(true);

            try{
                Estudiante_DAO estudiante_dao = new Estudiante_DAO();
                estudiante_dao.guardar(estudiante);

                Alert alertaConfirmacion = new Alert(Alert.AlertType.CONFIRMATION);
                alertaConfirmacion.setHeaderText(null);
                alertaConfirmacion.setTitle("Información");
                alertaConfirmacion.setContentText("Registro exitoso.");
                alertaConfirmacion.showAndWait();
            }catch (Exception ex){
                Alert alertaConfirmacion = new Alert(Alert.AlertType.WARNING);
                alertaConfirmacion.setHeaderText(null);
                alertaConfirmacion.setTitle("Alerta");
                alertaConfirmacion.setContentText("Error en la conexión." + ex);
                alertaConfirmacion.showAndWait();
            }

            limpiarCampos();
        }
    }

    public void clickCancelar(ActionEvent actionEvent) {
        Stage estaVentana = (Stage)button_Cancelar.getScene().getWindow();
        estaVentana.close();
    }

    public void limpiarCampos(){
        this.txtField_PrimerNombre.setText("");
        this.txtField_SegundoNombre.setText("");
        this.txtField_PrimerApellido.setText("");
        this.txtField_SegundoApellido.setText("");
    }
}
