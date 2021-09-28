package com.example.sistemaabc;

import POJO.Estudiante;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ConsultarController implements Initializable {
    public Label label_PrimerNombre;
    public Label label_SegundoNombre;
    public Label label_PrimerApellido;
    public Label label_SegundoApellido;
    public Button button_Aceptar;

    Estudiante estudiante;

    public ConsultarController(Estudiante estudiante){
        this.estudiante = estudiante;
    }

    public void clickAceptar(ActionEvent actionEvent) {
        Stage estaVentana = (Stage)button_Aceptar.getScene().getWindow();
        estaVentana.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        label_PrimerNombre.setText(estudiante.getPrimerNombre());
        label_SegundoNombre.setText(estudiante.getSegundoNombre());
        label_PrimerApellido.setText(estudiante.getPrimerApellido());
        label_SegundoApellido.setText(estudiante.getSegundoApellido());
    }
}
