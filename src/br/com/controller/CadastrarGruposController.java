package br.com.controller;

import br.com.apolo.CadastrarGrupos;
import br.com.apolo.Gerencial;
import br.com.dao.GruposDAO;
import br.com.dao.ProdutosDAO;
import br.com.dao.RepresentadasDAO;
import br.com.model.Grupos;
import br.com.model.Produtos;
import br.com.model.Representadas;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CadastrarGruposController implements Initializable {

    @FXML
    private ComboBox<Representadas> cbRepresentadas;

    @FXML
    private TextField txNomeGrupo;

    @FXML
    private Button btCadastrar;

    @FXML
    private Button btDeletar;

    @FXML
    private Button btAtualizar;

    @FXML
    private Button btCancelar;

    @FXML
    private TableView<Grupos> tabelaGrupos;

    @FXML
    private TableColumn<Grupos, String> clmGrupo;

    private Grupos selecionado;
    private String id_repres;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        initTable();
        initComboBoxRepresentadas();

        btCancelar.setOnMouseClicked((MouseEvent e) -> {
            logarTelaGerencial();
        });

        btCancelar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                logarTelaGerencial();
            }
        });

        btCadastrar.setOnMouseClicked((MouseEvent e) -> {
            cadastrarGrupos();
        });

        btCadastrar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                cadastrarGrupos();
            }
        });

        btDeletar.setOnMouseClicked((MouseEvent e) -> {
            deletarGrupo();
        });

        btDeletar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                deletarGrupo();
            }
        });

        txNomeGrupo.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        btAtualizar.setOnMouseClicked((MouseEvent e) -> {
            tabelaGrupos.setItems(atualizarTabela());
            cbRepresentadas.getSelectionModel().clearSelection();
            cbRepresentadas.setValue(null);
        });

        btAtualizar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                tabelaGrupos.setItems(atualizarTabela());
                cbRepresentadas.getSelectionModel().clearSelection();
                cbRepresentadas.setValue(null);
            }
        });

        tabelaGrupos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionado = (Grupos) newValue;
            }
        });

        cbRepresentadas.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                representadaSelecionada();
                tabelaGrupos.setItems(atualizarGruposRepresentadaSelecionada());
            }
        });
    }

    private void cadastrarGrupos() {
        String Id_Representadas = getComboBoxRepresentadaSelecionada();
        String Nome_Grupos = txNomeGrupo.getText();

        Grupos grupo = new Grupos(Id_Representadas, Nome_Grupos);
        GruposDAO dao = new GruposDAO();

        if (Nome_Grupos.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro no Cadastro de Novo Grupo");
            alert.setContentText("Para o cadastro de um novo grupo, PELO MENOS o nome deve ser preenchido!");
            alert.showAndWait();
        } else {
            if (dao.cadastrarGrupo(grupo)) {
                txNomeGrupo.clear();
                tabelaGrupos.setItems(atualizarTabela());
                cbRepresentadas.getSelectionModel().clearSelection();
                cbRepresentadas.setValue(null);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Grupo Cadastrado com Sucesso!");
                alert.showAndWait();
                // logarTelaGerencial();
                // fecharTelaCadastrarGrupos();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Grupo NÃO Cadastrado!");
                alert.show();
            }
        }
    }

    private void fecharTelaCadastrarGrupos() {
        CadastrarGrupos.getStage().close();
    }

    private void initTable() {
        clmGrupo.setCellValueFactory(new PropertyValueFactory("Nome_Grupos"));
        tabelaGrupos.setItems(atualizarTabela());
    }

    private ObservableList<Grupos> atualizarTabela() {
        GruposDAO grupdao = new GruposDAO();
        return FXCollections.observableArrayList(grupdao.listarGrupo());
    }

    private void logarTelaGerencial() {
        Gerencial gerencial = new Gerencial();
        try {
            gerencial.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(CadastrarUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharTelaCadastrarGrupos();
    }

    private void initComboBoxRepresentadas() {
        cbRepresentadas.setItems(comboboxRepresentadas());
    }

    private ObservableList<Representadas> comboboxRepresentadas() {
        RepresentadasDAO repredao = new RepresentadasDAO();
        return FXCollections.observableArrayList(repredao.listarRepresentadaComboBox());
    }

    private String getComboBoxRepresentadaSelecionada() {
        Representadas representada = cbRepresentadas.getSelectionModel().getSelectedItem();
        String id_repres = representada.getId_Representadas();
        return id_repres;
    }

    private void representadaSelecionada() {
        Representadas representada = cbRepresentadas.getSelectionModel().getSelectedItem();
        id_repres = representada.getId_Representadas();

        tabelaGrupos.setItems(atualizarTabela());
    }

    private ObservableList<Grupos> atualizarGruposRepresentadaSelecionada() {
        return FXCollections.observableArrayList(GruposDAO.listarGrupoRepresentada(id_repres));
    }

    private void deletarGrupo() {
        if (selecionado != null) {
            GruposDAO grupdao = new GruposDAO();
            grupdao.deletarGrupo(selecionado);
            cbRepresentadas.getSelectionModel().clearSelection();
            cbRepresentadas.setValue(null);
            //representadaSelecionada();
            tabelaGrupos.setItems(atualizarTabela());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Grupo Deletado com Sucesso!");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Selecione um Grupo para Deletar!");
            alert.show();
        }
    }
}
