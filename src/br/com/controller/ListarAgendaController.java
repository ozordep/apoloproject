package br.com.controller;

import br.com.apolo.Gerencial;
import br.com.apolo.ListarAgenda;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class ListarAgendaController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {  
        
        
    }   
    
    private void fecharTelaListarAgenda() {
        ListarAgenda.getStage().close();
    }
    
    private void logarTelaGerencial() {
        Gerencial gerencial = new Gerencial();
        try {
            gerencial.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(CadastrarGeralController.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharTelaListarAgenda();
    }
    
}
