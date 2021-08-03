import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Ejemplo de como crear una interfaz gráfica usando JavaFX.
 */
public class App extends Application {
    
    public static void main(String[] args) throws Exception {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Prueba");
        Button boton1 = new Button("Saludar");
        boton1.setLayoutX(50);
        boton1.setLayoutY(100);

        boton1.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent evento) {
                System.out.println("Hola");
            }
            
        });

        Button boton2 = new Button("Despedirse");
        boton2.setLayoutX(150);
        boton2.setLayoutY(100);
        boton2.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent evento) {
                System.out.println("Adios!");
            }
            
        });

        Pane panel = new Pane();
        panel.getChildren().addAll(boton1, boton2);
        stage.setScene(new Scene(panel, 300, 250));
        stage.show();
    }
}
