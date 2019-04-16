package br.com.controller;

import br.com.apolo.CadastrarRepresentadas;
import br.com.apolo.Gerencial;
import br.com.dao.RepresentadasDAO;
import br.com.model.Representadas;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CadastrarRepresentadasController implements Initializable {

    @FXML
    private TextField txNome;

    @FXML
    private TextField txDDD;

    @FXML
    private TextField txTel;

    @FXML
    private Button btCadastrar;

    @FXML
    private Button btCancelar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        btCancelar.setOnMouseClicked((MouseEvent e) -> {
            logarTelaGerencial();
        });

        btCancelar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                logarTelaGerencial();
            }
        });

        btCadastrar.setOnMouseClicked((MouseEvent e) -> {
            cadastrarRepresentadas();
        });

        btCadastrar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                cadastrarRepresentadas();
            }
        });

        txNome.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        txDDD.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        txTel.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));        
    }    
    
    private void cadastrarRepresentadas() {

        String Nome_Representadas = txNome.getText();
        String DDD_Representadas = txDDD.getText();
        String Telefone_Representadas = txTel.getText();
        
        Representadas representada = new Representadas(Nome_Representadas,DDD_Representadas,Telefone_Representadas);
        RepresentadasDAO dao = new RepresentadasDAO();

        if (Nome_Representadas.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro no Cadastro de Nova Representada");
            alert.setContentText("Para o cadastro de uma nova representada, PELO MENOS o nome deve ser preenchido!");
            alert.showAndWait();
        } else {
            if (dao.cadastrarRepresentada(representada)) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Representada Cadastrada com Sucesso!");
                alert.showAndWait();
                logarTelaGerencial();
                fecharTelaCadastrarRepresentadas();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Representada NÃO Cadastrada!");
                alert.show();
            }
        }
    }
    
    private void fecharTelaCadastrarRepresentadas(){
        CadastrarRepresentadas.getStage().close();
    }
    
    private void logarTelaGerencial() {
        Gerencial gerencial = new Gerencial();
        fecharTelaCadastrarRepresentadas();
        try {
            gerencial.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(CadastrarRepresentadasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
