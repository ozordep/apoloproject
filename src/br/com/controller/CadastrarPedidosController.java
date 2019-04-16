package br.com.controller;

import br.com.apolo.CadastrarPedidos;
import br.com.apolo.Gerencial;
import br.com.dao.PedidosDAO;
import br.com.model.Clientes;
import br.com.model.Pedidos;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class CadastrarPedidosController implements Initializable {

    @FXML
    private TextField txOrdCompra;

    @FXML
    private TextField txCliente;

    @FXML
    private TextField txComprador;

    @FXML
    private TextField txEndEnt;

    @FXML
    private TextField txEndCob;

    @FXML
    private TextArea txObs;

    @FXML
    private DatePicker dtDataPed;

    private static Clientes c2;
    private Clientes selecionado;
    private static String Id_Grupos;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initCampos();

        String padrao = "dd/MM/yyyy";
        dtDataPed = new DatePicker(LocalDate.now());

    }

    private void initCampos() {

        txCliente.setText(c2.getRazaoSocial_Clientes());
        txComprador.setText(c2.getContatos_Clientes());
        txEndEnt.setText(c2.getEndEnt_Clientes() + " - " + c2.getBairroEnt_Clientes() + " - "
                + c2.getCidadeEnt_Clientes() + " - " + c2.getUfEnt_Clientes() + " - " + c2.getPaisEnt_Clientes() + " - CEP: "
                + c2.getCepEnt_Clientes());
        txEndCob.setText(c2.getEndCob_Clientes() + " - " + c2.getBairroCob_Clientes() + " - "
                + c2.getCidadeCob_Clientes() + " - " + c2.getUfCob_Clientes() + " - " + c2.getPaisCob_Clientes() + " - CEP: "
                + c2.getCepCob_Clientes());
        txObs.getText();

        /*
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
         */
    }

    private void cadastrarProdutos() {
//        String String Id_Representadas = getComboBoxRepresentadaSelecionada();
//        validarepres = Id_Representadas;
//        String Id_Grupos = getComboBoxGrupoSelecionado();
//        validagrupo = Id_Grupos;
//        String Cod_Produtos = txCodProd.getText();
//        String Nome_Produtos = txProd.getText();
//        String Un_Produtos = txCxProd.getText();
//        String Qtde_Cx_Produtos = txQtdeProd.getText();
//        String Saldo_Produtos = txSaldoProd.getText();
//        String Preco_Cliente_Produtos = txPrecoCliente.getText();
//        String Preco_Revendedor_Produtos = txPrecoRevend.getText();
//        String Icms_Produtos = txIcmsProd.getText();
//        String Ipi_Produtos = txIpiProd.getText();

//        Pedidos pedido = new Pedidos();
//        PedidosDAO dao = new PedidosDAO();
//
//        if ((Nome_Produtos.isEmpty()) || (Cod_Produtos.isEmpty())) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Erro");
//            alert.setHeaderText("Erro no Cadastro de Novo Pedido");
//            alert.setContentText("????Para o cadastro de um novo produto, PELO MENOS o nome e o código do produto devem ser preenchidos!");
//            alert.showAndWait();
//        } else {
//            if (dao.cadastrarPedido(pedido)) {
//                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//                alert.setHeaderText("Pedido Cadastrado com Sucesso!");
//                alert.showAndWait();
//                logarTelaGerencial();
//                fecharTelaCadastrarPedidos();
//            } else {
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setHeaderText("Pedido NÃO Cadastrado!");
//                alert.show();
//            }
//        }
    }

    private void fecharTelaCadastrarPedidos() {
        CadastrarPedidos.getStage().close();
    }

    private void logarTelaGerencial() {
        Gerencial gerencial = new Gerencial();
        try {
            gerencial.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(CadastrarGeralController.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecharTelaCadastrarPedidos();
    }

    private static void getGrupoCliente(String id_grupo) {
        Id_Grupos = id_grupo;
    }

    public static Clientes getC2() {
        return c2;
    }

    public static void setC2(Clientes c1) {
        CadastrarPedidosController.c2 = c1;
    }

}
