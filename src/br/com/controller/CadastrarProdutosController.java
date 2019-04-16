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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CadastrarProdutosController implements Initializable {

    @FXML
    private ComboBox<Representadas> cbRepresentadas;

    @FXML
    private ComboBox<Grupos> cbGrupos;

    @FXML
    private TableView<Produtos> tabelaProdutos;

    @FXML
    private TableColumn<Produtos, String> clmGrupos;

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
    private TableColumn<Produtos, String> clmPrecoClienteProdutos;

    @FXML
    private TableColumn<Produtos, String> clmPrecoRevendedorProdutos;

    @FXML
    private TableColumn<Produtos, String> clmIcmsProdutos;

    @FXML
    private TableColumn<Produtos, String> clmIpiProdutos;

    @FXML
    private TextField txCodProd;

    @FXML
    private TextField txProd;

    @FXML
    private TextField txCxProd;

    @FXML
    private TextField txQtdeProd;

    @FXML
    private TextField txSaldoProd;

    @FXML
    private TextField txPrecoCliente;

    @FXML
    private TextField txPrecoRevend;

    @FXML
    private TextField txIcmsProd;

    @FXML
    private TextField txIpiProd;

    @FXML
    private Button btCadastrar;

    @FXML
    private Button btDeletar;

    @FXML
    private Button btAtualizar;

    @FXML
    private Button btCancelar;

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

        cbRepresentadas.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                representadaSelecionada();
                cbGrupos.setItems(atualizarGruposRepresentadaSelecionada());
                validarepres = getComboBoxRepresentadaSelecionada();
                //validagrupo = null; // Caso ter selecionado primeiro Grupo antes de Representada, setar variável validagrupo para novo cadastro de produto.
                verificaRepresentadaDisponibilidadeGrupo(); // Setar Visibilidade do ComboBox Grupos em função de Representada Selecionada.
            }
        });

        cbGrupos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (id_repres == null) {
                    validagrupo = null;
                } else {
                    validagrupo = getComboBoxGrupoSelecionado();
                }
            }
        });

        setarBotaoMouseClickedCancelar(btCancelar);
        setarKeyPressedCancelar(btCancelar);
        setarBotaoMouseClickedDeletarProduto(btDeletar);
        setarKeyPressedDeletarProduto(btDeletar);
        setarBotaoMouseClickedAtualizar(btAtualizar);
        setarKeyPressedAtualizar(btAtualizar);
        setarBotaoMouseClickedCadastrar(btCadastrar);
        setarKeyPressedCadastrar(btCadastrar);

        setarUppercase(txCodProd);
        setarUppercase(txProd);
        setarUppercase(txCxProd);
        setarUppercase(txQtdeProd);
        setarUppercase(txSaldoProd);

    }

    private void initThreads() {
        Thread r = new Thread(() -> {
            initComboBoxRepresentadas();
        });
        r.setDaemon(true);
        r.start();

        Thread s = new Thread(() -> {
            initComboBoxGrupos();
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

    private void cadastrarProdutos() {
        String Id_Representadas = getComboBoxRepresentadaSelecionada();
        validarepres = Id_Representadas;
        String Id_Grupos = getComboBoxGrupoSelecionado();
        validagrupo = Id_Grupos;
        String Cod_Produtos = txCodProd.getText();
        String Nome_Produtos = txProd.getText();
        String Un_Produtos = txCxProd.getText();
        String Qtde_Cx_Produtos = txQtdeProd.getText();
        String Saldo_Produtos = txSaldoProd.getText();
        String Preco_Cliente_Produtos = txPrecoCliente.getText();
        String Preco_Revendedor_Produtos = txPrecoRevend.getText();
        String Icms_Produtos = txIcmsProd.getText();
        String Ipi_Produtos = txIpiProd.getText();

        Produtos produto = new Produtos(Id_Representadas, Id_Grupos, Cod_Produtos, Nome_Produtos, Un_Produtos, Qtde_Cx_Produtos, Saldo_Produtos, Preco_Cliente_Produtos, Preco_Revendedor_Produtos, Icms_Produtos, Ipi_Produtos);
        ProdutosDAO dao = new ProdutosDAO();

        if ((Nome_Produtos.isEmpty()) || (Cod_Produtos.isEmpty())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro no Cadastro de Novo Produto");
            alert.setContentText("Para o cadastro de um novo produto, PELO MENOS o nome e o código do produto devem ser preenchidos!");
            alert.showAndWait();
        } else {
            if (dao.cadastrarProduto(produto)) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Produto Cadastrado com Sucesso!");
                alert.showAndWait();
                logarTelaGerencial();
                fecharTelaCadastrarProdutos();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Produto NÃO Cadastrado!");
                alert.show();
            }
        }
    }

    private void fecharTelaCadastrarProdutos() {
        CadastrarProdutos.getStage().close();
    }

    private void initTable() {

        clmGrupos.setCellValueFactory(new PropertyValueFactory("Nome_Grupos"));
        clmCodProdutos.setCellValueFactory(new PropertyValueFactory("Cod_Produtos"));
        clmNomeProdutos.setCellValueFactory(new PropertyValueFactory("Nome_Produtos"));
        clmUnProdutos.setCellValueFactory(new PropertyValueFactory("Un_Produtos"));
        clmQtdeProdutos.setCellValueFactory(new PropertyValueFactory("Qtde_Cx_Produtos"));
        clmSaldoProdutos.setCellValueFactory(new PropertyValueFactory("Saldo_Produtos"));
        clmPrecoClienteProdutos.setCellValueFactory(new PropertyValueFactory("Preco_Cliente_Produtos"));
        clmPrecoRevendedorProdutos.setCellValueFactory(new PropertyValueFactory("Preco_Revendedor_Produtos"));
        clmIcmsProdutos.setCellValueFactory(new PropertyValueFactory("Icms_Produtos"));
        clmIpiProdutos.setCellValueFactory(new PropertyValueFactory("Ipi_Produtos"));
        Thread t = new Thread(() -> {
            tabelaProdutos.setItems(atualizarTabela());
        });
        t.setDaemon(true);
        t.start();
        t.interrupt();
    }

    private ObservableList<Produtos> atualizarTabela() {
        ProdutosDAO proddao = new ProdutosDAO();
        if (id_repres == null) {
            return FXCollections.observableArrayList(ProdutosDAO.listarProduto());
        } else {
            return FXCollections.observableArrayList(ProdutosDAO.listarProdutoRepresentada(id_repres));
        }
    }

    private void representadaSelecionada() {
        Representadas representada = cbRepresentadas.getSelectionModel().getSelectedItem();
        id_repres = representada.getId_Representadas();
        System.out.println(id_repres);
        if (id_repres == null) {
            tabelaProdutos.setItems(atualizarTabela());
        } else {
            atualizarGruposRepresentadaSelecionada();
            tabelaProdutos.setItems(atualizarTabela());
        }
    }

    private ObservableList<Grupos> atualizarGruposRepresentadaSelecionada() {
        if (id_repres == null) {
            return FXCollections.observableArrayList(GruposDAO.listarGrupo());
        } else {
            return FXCollections.observableArrayList(GruposDAO.listarGrupoRepresentada(id_repres));
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

    private void deletarProduto() {
        if (selecionado != null) {
            ProdutosDAO proddao = new ProdutosDAO();
            proddao.deletarProduto(selecionado);
            tabelaProdutos.setItems(atualizarTabela());
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setHeaderText("Produto Deletado com Sucesso!");
            alert.show();
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText("Selecione um Produto para Deletar!");
            alert.show();
        }
    }

    private void initComboBoxRepresentadas() {
        Representadas r = new Representadas();
        r.setId_Representadas(null);
        r.setNome_Representadas("TODAS");
        cbRepresentadas.setPromptText("TODAS");
        ObservableList<Representadas> re = comboboxRepresentadas();
        re.add(r);
        verificaRepresentadaDisponibilidadeGrupo();
        cbRepresentadas.setItems(re);
//        cbRepresentadas.setItems(comboboxRepresentadas());
    }

    private ObservableList<Representadas> comboboxRepresentadas() {
        RepresentadasDAO repredao = new RepresentadasDAO();
        return FXCollections.observableArrayList(RepresentadasDAO.listarRepresentadaComboBox());
    }

    private String getComboBoxRepresentadaSelecionada() {
        Representadas representada = cbRepresentadas.getSelectionModel().getSelectedItem();
        String id_repres = representada.getId_Representadas();
        return id_repres;
    }

    private void initComboBoxGrupos() {
        cbGrupos.setItems(comboboxGrupos());
    }

    private ObservableList<Grupos> comboboxGrupos() {
        GruposDAO grupdao = new GruposDAO();
        verificaRepresentadaDisponibilidadeGrupo();
        return FXCollections.observableArrayList(grupdao.listarGrupoComboBox());
    }

    private void verificaRepresentadaDisponibilidadeGrupo() {
        GruposDAO grupdao = new GruposDAO();
        if (validarepres == null) {
            cbGrupos.setVisible(false);
        } else {
            cbGrupos.setVisible(true);
        }
    }

    private String getComboBoxGrupoSelecionado() {
        Grupos grupo = cbGrupos.getSelectionModel().getSelectedItem();
        String id_grupo = grupo.getId_Grupos();
        System.out.println(id_grupo);
        return id_grupo;
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

    private void setarBotaoMouseClickedDeletarProduto(Button button) {
        button.setOnMouseClicked((MouseEvent e) -> {
            deletarProduto();
        });
    }

    private void setarKeyPressedDeletarProduto(Button button) {
        button.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                deletarProduto();
            }
        });
    }

    private void setarBotaoMouseClickedAtualizar(Button button) {
        button.setOnMouseClicked((MouseEvent e) -> {
            atualizarTabela();
        });
    }

    private void setarKeyPressedAtualizar(Button button) {
        button.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                atualizarTabela();
            }
        });
    }

    private void setarBotaoMouseClickedCadastrar(Button button) {
        button.setOnMouseClicked((MouseEvent e) -> {
            if (validarepres == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Erro no Cadastro de Novo Produto");
                alert.setContentText("Para o cadastro de um novo produto, DEVE-SE SELECIONAR uma representada!");
                alert.show();
            } else {
                if ((validagrupo == null) || (validarepres == null)) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setHeaderText("Erro no Cadastro de Novo Produto");
                    alert.setContentText("Para o cadastro de um novo produto, DEVE-SE TAMBÉM SELECIONAR um grupo!");
                    alert.show();
                } else {
                    cadastrarProdutos();
                }
            }
        });
    }

    private void setarKeyPressedCadastrar(Button button) {
        button.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                if (validarepres == null) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setHeaderText("Erro no Cadastro de Novo Produto");
                    alert.setContentText("Para o cadastro de um novo produto, DEVE-SE SELECIONAR uma representada!");
                    alert.show();
                } else {
                    if ((validagrupo == null) || (validarepres == null)) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Erro");
                        alert.setHeaderText("Erro no Cadastro de Novo Produto");
                        alert.setContentText("Para o cadastro de um novo produto, DEVE-SE TAMBÉM SELECIONAR um grupo!");
                        alert.show();
                    } else {
                        cadastrarProdutos();
                    }
                }
            }
        });
    }

}
