package br.com.controller;

import br.com.apolo.CadastrarTransportadoras;
import br.com.apolo.Gerencial;
import br.com.dao.TransportadorasDAO;
import br.com.model.Transportadoras;
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

public class CadastrarTransportadorasController implements Initializable {

    @FXML
    private TextField txNome;

    @FXML
    private TextField txDDD1;

    @FXML
    private TextField txTel1;

    @FXML
    private TextField txDDD2;

    @FXML
    private TextField txTel2;

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
            cadastrarClientes();
        });

        btCadastrar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                cadastrarClientes();
            }
        });

        txNome.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        txDDD1.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        txTel1.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        txDDD2.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        txTel2.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));
    }

    private void cadastrarClientes() {

        String Nome_Transportadoras = txNome.getText();
        String DDD1_Transportadoras = txDDD1.getText();
        String Tel1_Transportadoras = txTel1.getText();
        String DDD2_Transportadoras = txDDD2.getText();
        String Tel2_Transportadoras = txTel2.getText();

        Transportadoras transp = new Transportadoras(Nome_Transportadoras,DDD1_Transportadoras,Tel1_Transportadoras,DDD2_Transportadoras,Tel2_Transportadoras);
        TransportadorasDAO dao = new TransportadorasDAO();

        if (Nome_Transportadoras.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro no Cadastro de Nova Transportadora");
            alert.setContentText("Para o cadastro de uma nova transportadora, PELO MENOS o nome deve ser preenchido!");
            alert.showAndWait();
        } else {
            if (dao.cadastrarTransportadora(transp)) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Transportadora Cadastrada com Sucesso!");
                alert.showAndWait();
                logarTelaGerencial();
                fecharTelaCadastrarTransportadoras();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Transportadora NÃO Cadastrada!");
                alert.show();
            }
        }
    }

    private void fecharTelaCadastrarTransportadoras() {
        CadastrarTransportadoras.getStage().close();
    }

    private void logarTelaGerencial() {
        Gerencial gerencial = new Gerencial();
        fecharTelaCadastrarTransportadoras();
        try {
            gerencial.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(CadastrarTransportadorasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
