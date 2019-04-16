package br.com.controller;

import br.com.apolo.CadastrarCondPagamentos;
import br.com.apolo.Gerencial;
import br.com.dao.CondPagamentosDAO;
import br.com.dao.ProdutosDAO;
import br.com.model.CondPagamentos;
import br.com.model.Produtos;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CadastrarCondPagamentosController implements Initializable {

    @FXML
    private Button btCadastrar;

    @FXML
    private Button btDeletarCondPgto;

    @FXML
    private Button btAtualizar;

    @FXML
    private Button btCancelar;

    @FXML
    private TableView<CondPagamentos> tabelaCondPgto;

    @FXML
    private TableColumn<CondPagamentos, String> clmCodCondPgto;

    @FXML
    private TableColumn<CondPagamentos, String> clmCondPgts;

    @FXML
    private TextField txNomeCondPgto;

    private CondPagamentos selecionado;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        initTable();

        setarUppercase(txNomeCondPgto);

        setarBotaoMouseClickedCancelar(btCancelar);
        setarKeyPressedCancelar(btCancelar);
        setarBotaoMouseClickedDeletarCondPagamento(btDeletarCondPgto);
        setarKeyPressedDeletarCondPagamento(btDeletarCondPgto);
        setarBotaoMouseClickedAtualizar(btAtualizar);
        setarKeyPressedAtualizar(btAtualizar);
        setarBotaoMouseClickedCadastrar(btCadastrar);
        setarKeyPressedCadastrar(btCadastrar);

        tabelaCondPgto.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionado = (CondPagamentos) newValue;
            }
        });

    }

    private void cadastrarCondPagamentos() {
        String Nome_CondPgtos = txNomeCondPgto.getText();

        CondPagamentos condpgto = new CondPagamentos(Nome_CondPgtos);
        CondPagamentosDAO dao = new CondPagamentosDAO();

        if (Nome_CondPgtos.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro no Cadastro de Nova Cond. Pagamento");
            alert.setContentText("Para o cadastro de uma nova cond. pagamento, DEVE-SE preencher o nome da cond. pagamento!");
            alert.showAndWait();
        } else {
            if (dao.cadastrarCondPagamento(condpgto)) {
                tabelaCondPgto.setItems(atualizarTabela());
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Cond. Pagamento Cadastrada com Sucesso!");
                alert.showAndWait();
                //logarTelaGerencial();
                //fecharTelaCadastrarCondPagamentos();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Cond. Pagamento NÃO Cadastrada!");
                alert.show();
            }
        }
    }

    private void fecharTelaCadastrarCondPagamentos() {
        CadastrarCondPagamentos.getStage().close();
    }

    private void logarTelaGerencial() {
        Gerencial gerencial = new Gerencial();
        try {
            gerencial.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(CadastrarGeralController.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharTelaCadastrarCondPagamentos();
    }

    private void initTable() {
        clmCodCondPgto.setCellValueFactory(new PropertyValueFactory("Id_CondPgtos"));
        clmCondPgts.setCellValueFactory(new PropertyValueFactory("Nome_CondPgtos"));
        tabelaCondPgto.setItems(atualizarTabela());
    }

    private ObservableList<CondPagamentos> atualizarTabela() {
        CondPagamentosDAO condpgtodao = new CondPagamentosDAO();
        return FXCollections.observableArrayList(CondPagamentosDAO.listarCondPagamento());

    }

    private void deletarCondPagamento() {
        if (selecionado != null) {
            CondPagamentosDAO condpgtodao = new CondPagamentosDAO();
            condpgtodao.deletarCondPagamento(selecionado);
            tabelaCondPgto.setItems(atualizarTabela());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Cond. Pagamento Deletada com Sucesso!");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Selecione uma Cond. Pagamento para Deletar!");
            alert.show();
        }
    }

    private void setarUppercase(TextField textfield) {
        textfield.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));
    }

    private void setarBotaoMouseClickedCancelar(Button button) {
        button.setOnMouseClicked((MouseEvent e) -> {
            logarTelaGerencial();
        });
    }

    private void setarKeyPressedCancelar(Button button) {
        button.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                logarTelaGerencial();
            }
        });
    }

    private void setarBotaoMouseClickedDeletarCondPagamento(Button button) {
        button.setOnMouseClicked((MouseEvent e) -> {
            deletarCondPagamento();
        });
    }

    private void setarKeyPressedDeletarCondPagamento(Button button) {
        button.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                deletarCondPagamento();
            }
        });
    }

    private void setarBotaoMouseClickedAtualizar(Button button) {
        button.setOnMouseClicked((MouseEvent e) -> {
            tabelaCondPgto.setItems(atualizarTabela());
        });
    }

    private void setarKeyPressedAtualizar(Button button) {
        button.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                tabelaCondPgto.setItems(atualizarTabela());
            }
        });
    }

    private void setarBotaoMouseClickedCadastrar(Button button) {
        button.setOnMouseClicked((MouseEvent e) -> {
            cadastrarCondPagamentos();
        }
        );
    }

    private void setarKeyPressedCadastrar(Button button) {
        button.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                cadastrarCondPagamentos();
            }
        });
    }

}
