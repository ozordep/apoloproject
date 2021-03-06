package br.com.controller;

import br.com.apolo.CadastrarGeral;
import br.com.apolo.Estoque;
import br.com.apolo.Gerencial;
import br.com.apolo.ListarAgenda;
import br.com.apolo.ListarClientes;
import br.com.apolo.Relatorios;
import static br.com.jdbc.ModuloDeConexao.conector;
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
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

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
            logarRelatorios();
        });
        
        btEstoque.setOnMouseClicked((MouseEvent e) -> {
            logarEstoque();
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
    
    private void logarRelatorios(){
    Relatorios relatorios = new Relatorios();
        try {
            relatorios.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(GerencialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    fecharTelaGerencial();
    }
 
    private void logarEstoque(){
    
        Estoque estoque = new Estoque();
        
   
        
            try {
                estoque.start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(GerencialController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            fecharTelaGerencial();
        
        
        
    
    }
   
        
    
    


}
