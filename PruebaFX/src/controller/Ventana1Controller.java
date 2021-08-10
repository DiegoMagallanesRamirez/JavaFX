package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import readFile.LeerArchivo;

public class Ventana1Controller {

    @FXML
    private TextField tf_cp;

    @FXML
    private Button buscar;

    @FXML
    private Label l_cp;

    @FXML
    private Label l_alcaldia;

    @FXML
    private Label l_colonia;

    @FXML
    private Label l_estado;

    @FXML
    private Label l_ciudad;

    @FXML
    void buscar(ActionEvent event) {
        LeerArchivo readFile = new LeerArchivo("../PruebaFX/src/resources/CP_CDMX.csv");
        String [] datos = readFile.buscar(tf_cp.getText());

        if(datos != null) {
            l_cp.setText(datos[0]);
            l_colonia.setText(datos[1]);
            l_alcaldia.setText(datos[2]);
            l_estado.setText(datos[3]);
            l_ciudad.setText(datos[4]);
        }
    }

}
