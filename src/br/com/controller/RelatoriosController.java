/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.apolo.Gerencial;
import br.com.apolo.RelatorioClientes;
import br.com.apolo.Relatorios;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Preloader;
import javafx.application.Preloader.ProgressNotification;
import javafx.application.Preloader.StateChangeNotification;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 * Simple Preloader Using the ProgressBar Control
 *
 * @author Aluno
 */
public class RelatoriosController implements Initializable {

    Stage stage;

    @FXML
    private Button btnRelatorioProdutos;

    @FXML
    private Button btnRelatorioRepresentadas;

    @FXML
    private Button btnRelatorioClientes;

    @FXML
    private Button btnRelatorioTransportadoras;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        btnRelatorioClientes.setOnMouseClicked((MouseEvent e) -> {
            logarRelatorioClientes();

        });
    }

    private void logarRelatorioClientes() {
        System.out.println("a");
        RelatorioClientes rc = new RelatorioClientes();
        try {
            rc.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(RelatoriosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharTelaRelatorios();

    }

    private void fecharTelaRelatorios() {
        Relatorios.getStage().close();
    }

}
