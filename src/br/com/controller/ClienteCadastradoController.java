package br.com.controller;

import br.com.apolo.CadastrarPedidos;
import br.com.apolo.ClienteCadastrado;
import br.com.apolo.Gerencial;
import br.com.dao.ClientesDAO;
import br.com.dao.ClientesGruposDAO;
import br.com.dao.GruposDAO;
import br.com.dao.MatEnviadoDAO;
import br.com.model.Clientes;
import br.com.model.ClientesGrupos;
import br.com.model.Grupos;
import br.com.model.MatEnviado;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ClienteCadastradoController implements Initializable {

    @FXML
    private TabPane tabPaneCliente;

    @FXML
    private TextField txRazaoSocial;

    @FXML
    private TextField txNomeFantasia;

    @FXML
    private ComboBox<Grupos> cbEmitirPedido;

    @FXML
    private TextField txDDD;

    @FXML
    private TextField txTelefone;

    @FXML
    private TextField txFax;

    @FXML
    private TextField txContatos;

    @FXML
    private TextField txCnpj;

    @FXML
    private TextField txIe;

    @FXML
    private TextField txEmail;

    @FXML
    private TextField txEndFat;

    @FXML
    private TextField txPaisFat;

    @FXML
    private TextField txBairroFat;

    @FXML
    private TextField txCidadeFat;

    @FXML
    private TextField txUfFat;

    @FXML
    private TextField txCepFat;

    @FXML
    private TextField txEndEnt;

    @FXML
    private TextField txPaisEnt;

    @FXML
    private TextField txBairroEnt;

    @FXML
    private TextField txCidadeEnt;

    @FXML
    private TextField txUfEnt;

    @FXML
    private TextField txCepEnt;

    @FXML
    private TextField txEndCob;

    @FXML
    private TextField txPaisCob;

    @FXML
    private TextField txBairroCob;

    @FXML
    private TextField txCidadeCob;

    @FXML
    private TextField txUfCob;

    @FXML
    private TextField txCepCob;

    @FXML
    private Button btCancelar;

    @FXML
    private Button btRepetir1;

    @FXML
    private Button btRepetir2;

    @FXML
    private DatePicker dtDataMatEnv;

    @FXML
    private TextField txMatEnv;

    @FXML
    private Button btIncluirMatEnv;

    @FXML
    private TableView<MatEnviado> tabelaMatEnv;

    @FXML
    private TableColumn<MatEnviado, DatePicker> clmData;

    @FXML
    private TableColumn<MatEnviado, String> clmMatEnv;

    @FXML
    private ComboBox<Grupos> cbGrupos;

    @FXML
    private Button btIncluirGrupo;

    @FXML
    private TableColumn<Grupos, String> clmGrupos;

    @FXML
    private TableView<Grupos> tabelaCliGrupo;
    
    @FXML
    private TextField txNomeRefCom;

    @FXML
    private TextField txDDDRefCom;

    @FXML
    private TextField txTelRefCom;

    @FXML
    private Button btIncluirRefCom;

    @FXML
    private Button btAltRefCom;

    @FXML
    private Button btDelRefCom;

    @FXML
    private TableView<?> tabelaRefCom;

    private static Clientes c2;
    private Clientes selecionado;
    private static String grupselecionado;
    private String id_grupo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Thread s = new Thread(() -> {
            initComboBoxGrupos();
        });
        s.setDaemon(true);
        s.start();

        Thread u = new Thread(() -> {
            initComboBoxClientesGrupos();
        });
        u.setDaemon(true);
        u.start();

        Thread r = new Thread(() -> {
            initCampos();
        });
        r.setDaemon(true);
        r.start();

        Thread t = new Thread(() -> {
            initTableMatEnviado();
        });
        t.setDaemon(true);
        t.start();

        Thread v = new Thread(() -> {
            initTableClienteGrupo();
        });
        v.setDaemon(true);
        v.start();

        r.interrupt();
        s.interrupt();
        t.interrupt();
        u.interrupt();
        v.interrupt();

        cbEmitirPedido.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                grupselecionado = getComboBoxGrupoSelecionado();
                logarTelaCadastrarPedidos();
            }
        });

        btIncluirMatEnv.setOnMouseClicked((MouseEvent e) -> {
            cadastrarMatEnviado();
        });

        btIncluirGrupo.setOnMouseClicked((MouseEvent e) -> {
            getComboBoxClienteGrupoSelecionado();
            cadastrarClienteGrupo();
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

    private void fecharTelaClienteCadastrado() {
        ClienteCadastrado.getStage().close();
    }

    private void logarTelaGerencial() {
        Gerencial gerencial = new Gerencial();
        try {
            gerencial.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(CadastrarGeralController.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharTelaClienteCadastrado();
    }

    private void initComboBoxGrupos() {
        cbEmitirPedido.setItems(comboboxGrupos());
    }

    private void initComboBoxClientesGrupos() {
        cbGrupos.setItems(comboboxGrupos());
    }

    private void initTableClienteGrupo() {
        clmGrupos.setCellValueFactory(new PropertyValueFactory("Nome_Grupos"));
        tabelaCliGrupo.setItems(atualizarTabelaClienteGrupo());
    }

    private ObservableList<Grupos> atualizarTabelaClienteGrupo() {
        GruposDAO cligru = new GruposDAO();
        return FXCollections.observableArrayList(cligru.listarGrupoCliente(c2.getId_Clientes()));
    }

    private ObservableList<Grupos> comboboxGrupos() {
        GruposDAO grupdao = new GruposDAO();
        return FXCollections.observableArrayList(grupdao.listarGrupo());
    }

    private void initCampos() {
        txRazaoSocial.setText(c2.getRazaoSocial_Clientes());
        txNomeFantasia.setText(c2.getNomeFantasia_Clientes());
        txDDD.setText(c2.getDDD_Clientes());
        txTelefone.setText(c2.getTelefone_Clientes());
        txFax.setText(c2.getFax_Clientes());
        txContatos.setText(c2.getContatos_Clientes());
        txCnpj.setText(c2.getCnpj_Clientes());
        txIe.setText(c2.getIe_Clientes());
        txEmail.setText(c2.getEmail_Clientes());
        txEndFat.setText(c2.getEndFat_Clientes());
        txPaisFat.setText(c2.getPaisFat_Clientes());
        txBairroFat.setText(c2.getBairroFat_Clientes());
        txCidadeFat.setText(c2.getCidadeFat_Clientes());
        txUfFat.setText(c2.getUfFat_Clientes());
        txCepFat.setText(c2.getCepFat_Clientes());
        txEndEnt.setText(c2.getEndEnt_Clientes());
        txPaisEnt.setText(c2.getPaisEnt_Clientes());
        txBairroEnt.setText(c2.getBairroEnt_Clientes());
        txCidadeEnt.setText(c2.getCidadeEnt_Clientes());
        txUfEnt.setText(c2.getUfEnt_Clientes());
        txCepEnt.setText(c2.getCepEnt_Clientes());
        txEndCob.setText(c2.getEndCob_Clientes());
        txPaisCob.setText(c2.getPaisCob_Clientes());
        txBairroCob.setText(c2.getBairroCob_Clientes());
        txCidadeCob.setText(c2.getCidadeCob_Clientes());
        txUfCob.setText(c2.getUfCob_Clientes());
        txCepCob.setText(c2.getCepCob_Clientes());
    }

    private void cadastrarMatEnviado() {

        DatePicker datepicker = dtDataMatEnv;
        String Id_Clientes = c2.getId_Clientes();
        String Mat_Env_Desc = txMatEnv.getText();

        MatEnviado matenv = new MatEnviado(Id_Clientes, datepicker, Mat_Env_Desc);
        MatEnviadoDAO dao = new MatEnviadoDAO();

        if (Mat_Env_Desc.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro no Cadastro de Material Enviado");
            alert.setContentText("Para o cadastro de um novo material enviado, PELO MENOS o material enviado deve ser preenchido!");
            alert.showAndWait();
        } else {
            if (dao.cadastrarClienteMatEnviado(matenv)) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Envio de Material Cadastrado com Sucesso!");
                alert.showAndWait();
                initTableMatEnviado();
                dtDataMatEnv.setValue(null);
                txMatEnv.clear();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Envio de Material NÃO Cadastrado!");
                alert.show();
            }
        }
    }

    private void cadastrarClienteGrupo() {

        String Id_Clientes = c2.getId_Clientes();
        String Id_Grupos = getComboBoxClienteGrupoSelecionado();

        ClientesGrupos cligru = new ClientesGrupos(Id_Clientes, Id_Grupos);
        ClientesGruposDAO dao = new ClientesGruposDAO();

        if (Id_Grupos.equals(null)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro no Cadastro de Grupo em Cliente");
            alert.setContentText("Para o cadastro de um novo grupo em um cliente, PELO MENOS o grupo deve ser preenchido!");
            alert.showAndWait();
        } else {
            if (dao.cadastrarClienteGrupo(cligru)) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Cadastro de Grupo em cliente realizado com Sucesso!");
                alert.showAndWait();
                initTableClienteGrupo();
                initComboBoxClientesGrupos();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Cadastro de Grupo em cliente NÃO Realizado!");
                alert.show();
            }
        }
    }
    
//    private void cadastrarClienteRefCom() {
//
//        String Id_Clientes = c2.getId_Clientes();
//        String Nome_Ref_Com = txNomeRefCom.getText();
//        String DDD_Ref_Com = txDDDRefCom.getText();
//        String Tel_Ref_Com = txTelRefCom.getText();
//
//        ClientesGrupos cligru = new ClientesGrupos(Id_Clientes, Id_Grupos);
//        ClientesGruposDAO dao = new ClientesGruposDAO();
//
//        if (Id_Grupos.equals(null)) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Erro");
//            alert.setHeaderText("Erro no Cadastro de Grupo em Cliente");
//            alert.setContentText("Para o cadastro de um novo grupo em um cliente, PELO MENOS o grupo deve ser preenchido!");
//            alert.showAndWait();
//        } else {
//            if (dao.cadastrarClienteGrupo(cligru)) {
//                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//                alert.setHeaderText("Cadastro de Grupo em cliente realizado com Sucesso!");
//                alert.showAndWait();
//                initTableClienteGrupo();
//                initComboBoxClientesGrupos();
//            } else {
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setHeaderText("Cadastro de Grupo em cliente NÃO Realizado!");
//                alert.show();
//            }
//        }
//    }

    private void initTableMatEnviado() {
        clmData.setCellValueFactory(new PropertyValueFactory("Mat_Env_Data3"));
        clmMatEnv.setCellValueFactory(new PropertyValueFactory("Mat_Env_Desc"));
        tabelaMatEnv.setItems(atualizarTabela());
    }

    private ObservableList<MatEnviado> atualizarTabela() {
        MatEnviadoDAO matenv = new MatEnviadoDAO();
        return FXCollections.observableArrayList(matenv.listarClientesMatEnviado(c2.getId_Clientes()));
    }

    private void logarTelaCadastrarPedidos() {
        CadastrarPedidos cadped = new CadastrarPedidos(c2);
        try {
            cadped.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(ListarClientesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharTelaClienteCadastrado();
    }

    private String getComboBoxGrupoSelecionado() {
        Grupos grupo = cbEmitirPedido.getSelectionModel().getSelectedItem();
        String id_grupo = grupo.getId_Grupos();
        return id_grupo;
    }

    private String getComboBoxClienteGrupoSelecionado() {
        Grupos grupo = cbGrupos.getSelectionModel().getSelectedItem();
        String id_grupo = grupo.getId_Grupos();
        return id_grupo;
    }

    public String getGrupselecionado() {
        return grupselecionado;
    }

    public void setGrupselecionado(String grupselecionado) {
        this.grupselecionado = grupselecionado;
    }

    public static Clientes getC2() {
        return c2;
    }

    public static void setC2(Clientes c1) {
        ClienteCadastradoController.c2 = c1;
    }

}
