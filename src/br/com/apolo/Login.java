
package br.com.apolo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jfxtras.styles.jmetro8.JMetro;

public class Login extends Application {
    
    private static Stage stage;
    
    public static void main (String[] args){
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent painel = FXMLLoader.load(getClass().getResource("/br/com/view/login.fxml"));
        Scene scene = new Scene(painel);
                        new JMetro(JMetro.Style.LIGHT).applyTheme(scene);
        //painel.setStyle("-fx-background-color: linear-gradient( from 0% 0% to 100% 100%, blue 0%, silver 100%);");
        stage.setScene(scene);
        stage.setMaximized(false);//janela inteira
        stage.setTitle("Éter 7 - Login");
        stage.show();
        setStage(stage);
    }
   
    
    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Login.stage = stage;
    }
    
}
