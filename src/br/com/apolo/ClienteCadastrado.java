package br.com.apolo;

import br.com.controller.ClienteCadastradoController;
import br.com.model.Clientes;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClienteCadastrado extends Application {
    
    private static Stage stage;
        
    public static void main (String[] args){
        launch(args);
    }

    public ClienteCadastrado(Clientes c1) {
        ClienteCadastradoController.setC2(c1);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent painel = FXMLLoader.load(getClass().getResource("/br/com/view/clientecadastrado.fxml"));
        Scene scene = new Scene(painel);
        //painel.setStyle("-fx-background-color: linear-gradient( from 0% 0% to 100% 100%, blue 0%, silver 100%);");
        stage.setScene(scene);
        stage.setMaximized(true);//janela inteira
        stage.setTitle("Éter 7 - Cliente Cadastrado");
        stage.show();
        setStage(stage);
    }
    
    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        ClienteCadastrado.stage = stage;
    }
    
}
