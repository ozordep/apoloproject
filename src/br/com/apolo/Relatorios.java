package br.com.apolo;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jfxtras.styles.jmetro8.JMetro;

public class Relatorios extends Application {
    
    private static Stage stage;
    
    public static void main (String[] args){
        launch(args);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage aStage) {
        stage = aStage;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent painel = FXMLLoader.load(getClass().getResource("/br/com/view/Relatorios.fxml"));
        Scene scene = new Scene(painel);
                        new JMetro(JMetro.Style.LIGHT).applyTheme(scene);
        //painel.setStyle("-fx-background-color: linear-gradient( from 0% 0% to 100% 100%, blue 0%, silver 100%);");
        stage.setScene(scene);
        stage.setMaximized(true);//janela inteira
        stage.setTitle("Éter 7 - Relatorios");
        stage.show();
        setStage(stage);
    }
   
    
   
    
}
