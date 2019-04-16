/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.apolo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Aluno
 */
public class CadastrarTransportadoras extends Application {
    
    private static Stage stage;
    
    public static void main (String[] args){
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent painel = FXMLLoader.load(getClass().getResource("/br/com/view/cadastrartransportadoras.fxml"));
        Scene scene = new Scene(painel);
        //painel.setStyle("-fx-background-color: linear-gradient( from 0% 0% to 100% 100%, blue 0%, silver 100%);");
        stage.setScene(scene);
        stage.setMaximized(true);//janela inteira
        stage.setTitle("Éter 7 - Cadastro de Transportadoras");
        stage.show();
        setStage(stage);
    }
   
    
    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        CadastrarTransportadoras.stage = stage;
    }
    
}
