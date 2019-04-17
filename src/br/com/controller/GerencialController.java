package br.com.controller;

import br.com.apolo.CadastrarGeral;
import br.com.apolo.Gerencial;
import br.com.apolo.ListarAgenda;
import br.com.apolo.ListarClientes;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class GerencialController implements Initializable {

    @FXML
    private Button btCadastros;

    @FXML
    private Button btFinanceiro;

    @FXML
    private Button btClientes;

    @FXML
    private Button btAgenda;

    @FXML
    private Button btRelatorios;

    @FXML
    private Button btEstoque;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        btClientes.setOnMouseClicked((MouseEvent e) -> {
            logarListarClientes();
        });

        btClientes.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                logarListarClientes();
            }
        });

        btCadastros.setOnMouseClicked((MouseEvent e) -> {
            logarTelaCadastrarGeral();
        });

        btCadastros.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                logarTelaCadastrarGeral();
            }
        });

        btAgenda.setOnMouseClicked((MouseEvent e) -> {
            logarListarAgenda();
        });

        btAgenda.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                logarListarAgenda();
            }
        });
        
        btRelatorios.setOnMouseClicked((MouseEvent e) -> {
            gerarRelatorio();
        });
        
        
        
        
        
    }
    private void fecharTelaGerencial() {
        Gerencial.getStage().close();
    }

    private void logarTelaCadastrarGeral() {
        CadastrarGeral cadgeral = new CadastrarGeral();
        try {
            cadgeral.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(GerencialController.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharTelaGerencial();
    }

    private void logarListarClientes() {
        ListarClientes listcli = new ListarClientes();
        try {
            listcli.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(GerencialController.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharTelaGerencial();
    }

    private void logarListarAgenda() {
        ListarAgenda lisage = new ListarAgenda();
        try {
            lisage.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(GerencialController.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharTelaGerencial();
    }
    
    private void gerarRelatorio(){
    
       
        
    }

    /*
    public void listarClientes() {
        //ClientesDAO clidao = new ClientesDAO();
        List<Clientes> clientes = new ClientesDAO().listarClientes();
        for (int x = 0; x < clientes.size(); x++) {
            clientes.get(x).listarClientes();
        }
    }*/
}
