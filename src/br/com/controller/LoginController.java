package br.com.controller;

import br.com.apolo.Gerencial;
import br.com.apolo.Login;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class LoginController implements Initializable {

    @FXML
    private AnchorPane imgLogo;

    @FXML
    private TextField txLogin;

    @FXML
    private PasswordField txSenha;

    @FXML
    private Button btEntrar;

    @FXML
    private Button btSair;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        btSair.setOnMouseClicked((MouseEvent event) -> {
            fecharAplicacao();
        });

        btSair.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                fecharAplicacao();
            }
        });

        btEntrar.setOnMouseClicked((MouseEvent e) -> {
            logarAplicacao();
        });

        btEntrar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                logarAplicacao();
            }
        });

        txSenha.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                logarAplicacao();
            }
        });
    }

    private void fecharAplicacao() {
        Login.getStage().close();
        //System.exit(0);        
    }

    private void logarAplicacao() {

        if (txLogin.getText().equals("admin") && txSenha.getText().equals("admin")) {
            Gerencial gerencial = new Gerencial();
            fecharAplicacao();
            try {
                gerencial.start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro ao Logar no Sistema:");
            alert.setContentText("Verificar seu Nome de Usuário e Senha. Confira também o CAPS LOCK!");
            alert.showAndWait();
        }

    }

}
