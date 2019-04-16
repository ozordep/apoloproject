package br.com.controller;

import br.com.apolo.CadastrarUsuarios;
import br.com.apolo.Gerencial;
import br.com.dao.UsuariosDAO;
import br.com.model.Usuarios;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CadastrarUsuariosController implements Initializable {

    @FXML
    private TextField txNome;

    @FXML
    private PasswordField txSenha;

    @FXML
    private PasswordField txConfSenha;

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
            cadastrarUsuarios();
        });

        btCadastrar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                cadastrarUsuarios();
            }
        });
        
        txNome.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toLowerCase());
            return change;
        }));
    }

    private void cadastrarUsuarios() {

        String Nome_Usuarios = txNome.getText();
        String Senha_Usuarios = txSenha.getText();
        String Conf_Senha_Usuarios = txConfSenha.getText();

        Usuarios usuario = new Usuarios(Nome_Usuarios, Senha_Usuarios);
        UsuariosDAO dao = new UsuariosDAO();

        if ((Nome_Usuarios.length() == 0) || (!Senha_Usuarios.equals(Conf_Senha_Usuarios))) {
            if (Nome_Usuarios.length() == 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Erro no Cadastro de Novo Usuário");
                alert.setContentText("Para o cadastro de um novo usuário, PELO MENOS o nome deve ser preenchido!");
                alert.showAndWait();
            }
            if (!Senha_Usuarios.equals(Conf_Senha_Usuarios)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Erro no Cadastro de Novo Usuário");
                alert.setContentText("Para o correto cadastro da senha de um novo usuário, a Senha e a Confirmação de Senha DEVEM SER IGUAIS!");
                alert.showAndWait();
            }
        } else {
            if (dao.cadastrarUsuario(usuario)) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Usuário Cadastrado com Sucesso!");
                alert.showAndWait();
                logarTelaGerencial();
                fecharTelaCadastrarUsuarios();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Usuário NÃO Cadastrado!");
                alert.show();
            }
        }
    }

    private void fecharTelaCadastrarUsuarios() {
        CadastrarUsuarios.getStage().close();
    }

    private void logarTelaGerencial() {
        Gerencial gerencial = new Gerencial();
        try {
            gerencial.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(CadastrarUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharTelaCadastrarUsuarios();
    }

}
