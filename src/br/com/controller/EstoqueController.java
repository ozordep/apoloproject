package br.com.controller;

import br.com.apolo.CadastrarClientes;
import br.com.apolo.CadastrarProdutos;
import br.com.apolo.Gerencial;
import br.com.dao.GruposDAO;
import br.com.dao.ProdutosDAO;
import br.com.dao.RepresentadasDAO;
import br.com.model.Grupos;
import br.com.model.Produtos;
import br.com.model.Representadas;
import java.net.URL;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EstoqueController implements Initializable {

    @FXML
    private TableView<Produtos> tabelaProdutos;

    @FXML
    private TableColumn<Produtos, String> clmCodProdutos;

    @FXML
    private TableColumn<Produtos, String> clmNomeProdutos;

    @FXML
    private TableColumn<Produtos, String> clmUnProdutos;

    @FXML
    private TableColumn<Produtos, String> clmQtdeProdutos;

    @FXML
    private TableColumn<Produtos, String> clmSaldoProdutos;

    @FXML
    private Button btnAdicionarSaldo;

    @FXML
    private Button btnSubtrairSaldo;

    private Produtos selecionado;
    private String representada, id_repres, validarepres, validagrupo;

    public void initialize(URL url, ResourceBundle rb) {

        initThreads();
        tabelaProdutos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionado = (Produtos) newValue;
            }
        });

        setarBotaoAdicionarSaldo();
        setarBotaoSubtrairSaldo();
    }

    private void initThreads() {
        Thread r = new Thread(() -> {

        });
        r.setDaemon(true);
        r.start();

        Thread s = new Thread(() -> {

        });
        s.setDaemon(true);
        s.start();

        Thread t = new Thread(() -> {
            initTable();
        });
        t.setDaemon(true);
        t.start();

        Thread u = new Thread(() -> {
            atualizarTabela();
        });
        u.setDaemon(true);
        u.start();

        r.interrupt();
        s.interrupt();
        t.interrupt();
        u.interrupt();
    }

    private void fecharTelaCadastrarProdutos() {
        CadastrarProdutos.getStage().close();
    }

    private void initTable() {

        clmCodProdutos.setCellValueFactory(new PropertyValueFactory("Cod_Produtos"));
        clmNomeProdutos.setCellValueFactory(new PropertyValueFactory("Nome_Produtos"));
        clmUnProdutos.setCellValueFactory(new PropertyValueFactory("Un_Produtos"));
        clmQtdeProdutos.setCellValueFactory(new PropertyValueFactory("Qtde_Cx_Produtos"));
        clmSaldoProdutos.setCellValueFactory(new PropertyValueFactory("Saldo_Produtos"));
//        clmIcmsProdutos.setCellValueFactory(new PropertyValueFactory("Icms_Produtos"));
        Thread t = new Thread(() -> {
            tabelaProdutos.setItems(atualizarTabela());
        });
        t.setDaemon(true);
        t.start();
        t.interrupt();
        tabelaProdutos.getSelectionModel().setCellSelectionEnabled(true);
    }

    private ObservableList<Produtos> atualizarTabela() {
        ProdutosDAO proddao = new ProdutosDAO();
        if (id_repres == null) {
            return FXCollections.observableArrayList(ProdutosDAO.listarProduto());
        } else {
            return FXCollections.observableArrayList(ProdutosDAO.listarProdutoRepresentada(id_repres));
        }
    }

    private void logarTelaGerencial() {
        Gerencial gerencial = new Gerencial();
        try {
            gerencial.start(new Stage());

        } catch (Exception ex) {
            Logger.getLogger(CadastrarGeralController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        fecharTelaCadastrarProdutos();
    }

    private void setarBotaoAdicionarSaldo() {

        btnAdicionarSaldo.setOnMouseClicked((MouseEvent e) -> {

            if (selecionado == null) {

                Alert alert = new Alert(AlertType.WARNING);

                alert.setTitle("Erro ao adicionar saldo");
                alert.setHeaderText("Não foi possível realizar uma ação.");
                alert.setContentText("Nenhum produto foi selecionado, por favor tente novamente.");

                alert.showAndWait();

            } else {

                Double num = 0.0;

                TextInputDialog alertDigitarEstoque = new TextInputDialog();
                alertDigitarEstoque.setTitle("Gerenciamento de estoque");
                alertDigitarEstoque.setHeaderText("Adicionar Saldo");
                alertDigitarEstoque.setContentText("Insira a quantidade que deseja adicionar ao saldo deste produto:");
                DialogPane dialogPane = alertDigitarEstoque.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/br/com/styles/JMetroLightTheme.css").toExternalForm());

                Optional<String> result = alertDigitarEstoque.showAndWait();
                if (result.isPresent()) { // Se o cara clicou em OK
                    boolean ehNumero = true;
                    boolean ehInteiro = true;
                    boolean ehMaiorQueZero = false;

                    try {
                        num = Double.parseDouble(result.get()); // Converte o valor do campo em um numero
                    } catch (NumberFormatException ex) {
                        ehNumero = false;
                    }

                    try {

                        int verificainteiro = Integer.parseInt(result.get());

                        if (verificainteiro > 0) {
                            ehMaiorQueZero = true;
                        }

                    } catch (NumberFormatException ex) {

                        ehInteiro = false;

                    }

                    if (ehNumero == true && ehInteiro == true && ehMaiorQueZero) {

                        ProdutosDAO proddao = new ProdutosDAO();
                        proddao.adicionarSaldo(selecionado, (int) Math.round(num));

                        Alert alert = new Alert(AlertType.INFORMATION);
//                        DialogPane dialogPane = alert.getDialogPane();
//                        dialogPane.getStylesheets().add(
//                                getClass().getResource("/br/com/styles/JMetroLightTheme.css").toExternalForm());
                        alert.setTitle("Saldo atualizado");
                        alert.setHeaderText(null);
                        alert.setContentText("O saldo do produto selecionado foi atualizado com sucesso.");
                        alert.showAndWait();

                        tabelaProdutos.setItems(atualizarTabela());

                    } else {

                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Erro");
                        alert.setHeaderText("Não foi possível realizar uma ação");
                        alert.setContentText("Não foi possível atualizar o estoque, o valor inserido é inválido.");
//                        DialogPane dialogPane = alert.getDialogPane();
//                        dialogPane.getStylesheets().add(
//                                getClass().getResource("/br/com/styles/JMetroLightTheme.css").toExternalForm());

                        alert.showAndWait();

                    }

                }

            }

        });

    }

    private void setarBotaoSubtrairSaldo() {

        btnSubtrairSaldo.setOnMouseClicked((MouseEvent e) -> {

            if (selecionado == null) {

                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Erro ao subtrair saldo");
                alert.setHeaderText("Não foi possível realizar uma ação.");
                alert.setContentText("Nenhum produto foi selecionado, por favor tente novamente.");

                alert.showAndWait();

            } else {

                Double num = 0.0;

                TextInputDialog alertDigitarEstoque = new TextInputDialog();
                alertDigitarEstoque.setTitle("Gerenciamento de estoque");
                alertDigitarEstoque.setHeaderText("Subtrair Saldo");
                alertDigitarEstoque.setContentText("Insira a quantidade que deseja subtrair do saldo deste produto:");
                Optional<String> result = alertDigitarEstoque.showAndWait();
                if (result.isPresent()) { // Se o cara clicou em OK
                    boolean ehNumero = true;
                    boolean ehInteiro = true;
                    boolean ehMaiorQueZero = false;

                    try {
                        num = Double.parseDouble(result.get()); // Converte o valor do campo em um numero
                    } catch (NumberFormatException ex) {
                        ehNumero = false;
                    }

                    try {

                        int verificainteiro = Integer.parseInt(result.get());

                        if (verificainteiro > 0) {
                            ehMaiorQueZero = true;
                        }

                    } catch (NumberFormatException ex) {

                        ehInteiro = false;

                    }

                    if (ehNumero == true && ehInteiro == true && ehMaiorQueZero) {

                        ProdutosDAO proddao = new ProdutosDAO();
                        proddao.diminuirSaldo(selecionado, (int) Math.round(num));

                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Saldo atualizado");
                        alert.setHeaderText(null);
                        alert.setContentText("O saldo do produto selecionado foi atualizado com sucesso.");

                        alert.showAndWait();

                        tabelaProdutos.setItems(atualizarTabela());

                    } else {

                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Erro");
                        alert.setHeaderText("Não foi possível realizar uma ação");
                        alert.setContentText("Não foi possível atualizar o estoque, o valor inserido é inválido.");

                        alert.showAndWait();

                    }

                }

            }

        });

    }

}
