package br.com.controller;

import br.com.apolo.ClienteCadastrado;
import br.com.apolo.Gerencial;
import br.com.apolo.ListarClientes;
import br.com.dao.ClientesDAO;
import br.com.model.Clientes;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ListarClientesController implements Initializable {

    @FXML
    private TableView<Clientes> tabelaListaClientes;

    @FXML
    private TableColumn<Clientes, String> clmId;

    @FXML
    private TableColumn<Clientes, String> clmRazaoSocial;

    @FXML
    private TableColumn<Clientes, String> clmNomeFantasia;

    @FXML
    private TableColumn<Clientes, String> clmCidade;

    @FXML
    private TableColumn<Clientes, String> clmUf;

    @FXML
    private TableColumn<Clientes, String> clmTelefone;

    @FXML
    private Button btCancelar;

    private Clientes selecionado;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Task task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                initTable();
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

        Thread t = new Thread(task);
        t.setDaemon(true);
        t.start();

        Thread u = new Thread(() -> {
            atualizarTabela();
        });
        u.setDaemon(true);
        u.start();

        tabelaListaClientes.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    logarTelaClienteCadastrado();
                }
            }
        });

        tabelaListaClientes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionado = (Clientes) newValue;
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

    private void fecharTelaListarClientes() {
        ListarClientes.getStage().close();
    }

    private void initTable() {
        clmId.setCellValueFactory(new PropertyValueFactory("Id_Clientes"));
        clmRazaoSocial.setCellValueFactory(new PropertyValueFactory("RazaoSocial_Clientes"));
        clmNomeFantasia.setCellValueFactory(new PropertyValueFactory("NomeFantasia_Clientes"));
        clmCidade.setCellValueFactory(new PropertyValueFactory("CidadeFat_Clientes"));
        clmUf.setCellValueFactory(new PropertyValueFactory("UfFat_Clientes"));
        clmTelefone.setCellValueFactory(new PropertyValueFactory("Telefone_Clientes"));
        tabelaListaClientes.setItems(atualizarTabela());
    }

    private ObservableList<Clientes> atualizarTabela() {
        ClientesDAO clidao = new ClientesDAO();
        return FXCollections.observableArrayList(clidao.listarClientes());
    }

    private void logarTelaGerencial() {
        Gerencial gerencial = new Gerencial();
        fecharTelaListarClientes();
        try {
            gerencial.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(ListarClientesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void logarTelaClienteCadastrado() {
        ClienteCadastrado clientecadastrado = new ClienteCadastrado(selecionado);
        try {
            clientecadastrado.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(ListarClientesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharTelaListarClientes();
    }
}
