package br.com.controller;

import br.com.apolo.CadastrarClientes;
import br.com.apolo.CadastrarCondPagamentos;
import br.com.apolo.CadastrarGeral;
import br.com.apolo.CadastrarGrupos;
import br.com.apolo.CadastrarProdutos;
import br.com.apolo.CadastrarRepresentadas;
import br.com.apolo.CadastrarTransportadoras;
import br.com.apolo.CadastrarUsuarios;
import br.com.apolo.Gerencial;
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

public class CadastrarGeralController implements Initializable {

    @FXML
    private Button btCadCli;

    @FXML
    private Button btCadRepresentadas;

    @FXML
    private Button btCadRepresentantes;

    @FXML
    private Button btCadProd;

    @FXML
    private Button btCadCondPgto;

    @FXML
    private Button btCadTransp;

    @FXML
    private Button btCadGrup;

    @FXML
    private Button btCadUsu;

    @FXML
    private Button btCancelar;

    public void initialize(URL url, ResourceBundle rb) {

        btCadCli.setOnMouseClicked((MouseEvent e) -> {
            logarTelaCadastrarClientes();
        });

        btCadCli.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                logarTelaCadastrarClientes();
            }
        });

        btCadRepresentadas.setOnMouseClicked((MouseEvent e) -> {
            logarTelaCadastrarRepresentadas();
        });

        btCadRepresentadas.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                logarTelaCadastrarRepresentadas();
            }
        });

        btCadRepresentantes.setOnMouseClicked((MouseEvent e) -> {
            //logarTelaCadastroClientes();
        });

        btCadRepresentantes.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                //logarTelaCadastroClientes();
            }
        });

        btCadProd.setOnMouseClicked((MouseEvent e) -> {
            logarTelaCadastrarProdutos();
        });

        btCadProd.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                logarTelaCadastrarProdutos();
            }
        });

        btCadCondPgto.setOnMouseClicked((MouseEvent e) -> {
            logarTelaCadastrarCondPagamentos();
        });

        btCadCondPgto.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                logarTelaCadastrarCondPagamentos();
            }
        });

        btCadTransp.setOnMouseClicked((MouseEvent e) -> {
            logarTelaCadastrarTransportadoras();
        });

        btCadTransp.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                logarTelaCadastrarTransportadoras();
            }
        });

        btCadGrup.setOnMouseClicked((MouseEvent e) -> {
            logarTelaCadastrarGrupos();
        });

        btCadGrup.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                logarTelaCadastrarGrupos();
            }
        });

        btCadUsu.setOnMouseClicked((MouseEvent e) -> {
            logarTelaCadastrarUsuarios();
        });

        btCadUsu.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                logarTelaCadastrarUsuarios();
            }
        });

        btCancelar.setOnMouseClicked((MouseEvent e) -> {
            logarTelaGerencial();
        });

        btCancelar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                logarTelaGerencial();
            }
        });

    }

    private void fecharTelaCadastrarGeral() {
        CadastrarGeral.getStage().close();
    }

    private void logarTelaCadastrarClientes() {
        CadastrarClientes cadcli = new CadastrarClientes();
        //fecharTelaCadastrarGeral();
        try {
            cadcli.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(CadastrarGeralController.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharTelaCadastrarGeral();
    }

    private void logarTelaCadastrarRepresentadas() {
        CadastrarRepresentadas cadrep = new CadastrarRepresentadas();
        try {
            cadrep.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(CadastrarGeralController.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharTelaCadastrarGeral();
    }

    private void logarTelaCadastrarUsuarios() {
        CadastrarUsuarios cadusu = new CadastrarUsuarios();
        try {
            cadusu.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(CadastrarGeralController.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharTelaCadastrarGeral();
    }

    private void logarTelaCadastrarTransportadoras() {
        CadastrarTransportadoras cadtransp = new CadastrarTransportadoras();
        try {
            cadtransp.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(CadastrarGeralController.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharTelaCadastrarGeral();
    }

    private void logarTelaCadastrarProdutos() {
        CadastrarProdutos cadprod = new CadastrarProdutos();
        try {
            cadprod.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(CadastrarGeralController.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharTelaCadastrarGeral();
    }

    private void logarTelaGerencial() {
        Gerencial gerencial = new Gerencial();
        fecharTelaCadastrarGeral();
        try {
            gerencial.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(CadastrarGeralController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void logarTelaCadastrarGrupos() {
        CadastrarGrupos cadgrup = new CadastrarGrupos();
        try {
            cadgrup.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(CadastrarGeralController.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharTelaCadastrarGeral();
    }

    private void logarTelaCadastrarCondPagamentos() {
        CadastrarCondPagamentos cadcondpgto = new CadastrarCondPagamentos();
        try {
            cadcondpgto.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(CadastrarGeralController.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharTelaCadastrarGeral();
    }
}
