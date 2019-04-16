package br.com.controller;

import br.com.apolo.CadastrarClientes;
import br.com.apolo.Gerencial;
import br.com.dao.ClientesDAO;
import br.com.model.Clientes;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CadastrarClientesController implements Initializable {

    @FXML
    private TextField txRazaoSocial;

    @FXML
    private TextField txNomeFantasia;

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
    private Button btRepetir1;

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
    private Button btRepetir2;

    @FXML
    private Button btCadastrar;

    @FXML
    private Button btCancelar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        btCancelar.setOnMouseClicked((MouseEvent e) -> {
            logarTelaGerencial();
        });

        btCancelar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                logarTelaGerencial();
            }
        });

        btCadastrar.setOnMouseClicked((MouseEvent e) -> {
            cadastrarClientes();
        });

        btCadastrar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                cadastrarClientes();
            }
        });

        txRazaoSocial.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        txNomeFantasia.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        txDDD.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        txTelefone.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        txFax.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        txContatos.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        txCnpj.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        txIe.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        txEmail.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        txEndFat.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        txPaisFat.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        txBairroFat.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        txCidadeFat.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        txUfFat.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        txCepFat.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        txEndEnt.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        txPaisEnt.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        txBairroEnt.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        txCidadeEnt.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        txUfEnt.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        txCepEnt.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        txEndCob.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        txPaisCob.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        txBairroCob.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        txCidadeCob.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        txUfCob.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        txCepCob.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        btRepetir1.setOnMouseClicked((MouseEvent e) -> {
            txEndEnt.setText(txEndFat.getText());
            txPaisEnt.setText(txPaisFat.getText());
            txBairroEnt.setText(txBairroFat.getText());
            txCidadeEnt.setText(txCidadeFat.getText());
            txUfEnt.setText(txUfFat.getText());
            txCepEnt.setText(txCepFat.getText());
        });

        btRepetir2.setOnMouseClicked((MouseEvent e) -> {
            txEndCob.setText(txEndFat.getText());
            txPaisCob.setText(txPaisFat.getText());
            txBairroCob.setText(txBairroFat.getText());
            txCidadeCob.setText(txCidadeFat.getText());
            txUfCob.setText(txUfFat.getText());
            txCepCob.setText(txCepFat.getText());
        });

        btRepetir1.setOnKeyPressed((KeyEvent e) -> {
            txEndEnt.setText(txEndFat.getText());
            txPaisEnt.setText(txPaisFat.getText());
            txBairroEnt.setText(txBairroFat.getText());
            txCidadeEnt.setText(txCidadeFat.getText());
            txUfEnt.setText(txUfFat.getText());
            txCepEnt.setText(txCepFat.getText());
        });

        btRepetir2.setOnKeyPressed((KeyEvent e) -> {
            txEndCob.setText(txEndFat.getText());
            txPaisCob.setText(txPaisFat.getText());
            txBairroCob.setText(txBairroFat.getText());
            txCidadeCob.setText(txCidadeFat.getText());
            txUfCob.setText(txUfFat.getText());
            txCepCob.setText(txCepFat.getText());
        });

    }

    private void cadastrarClientes() {
        
        String DDD_Clientes = txDDD.getText(), Telefone_Clientes = txTelefone.getText(), Fax_Clientes = txFax.getText();
        String RazaoSocial_Clientes = txRazaoSocial.getText(), NomeFantasia_Clientes = txNomeFantasia.getText(), Contatos_Clientes = txContatos.getText(), Cnpj_Clientes = txCnpj.getText(), Ie_Clientes = txIe.getText(), Email_Clientes = txEmail.getText();
        String EndFat_Clientes = txEndFat.getText(), PaisFat_Clientes = txPaisFat.getText(), BairroFat_Clientes = txBairroFat.getText(), CidadeFat_Clientes = txCidadeFat.getText(), UfFat_Clientes = txUfFat.getText(), CepFat_Clientes = txCepFat.getText();
        String EndEnt_Clientes = txEndEnt.getText(), PaisEnt_Clientes = txPaisEnt.getText(), BairroEnt_Clientes = txBairroEnt.getText(), CidadeEnt_Clientes = txCidadeEnt.getText(), UfEnt_Clientes = txUfEnt.getText(), CepEnt_Clientes = txCepEnt.getText();
        String EndCob_Clientes = txEndCob.getText(), PaisCob_Clientes = txPaisCob.getText(), BairroCob_Clientes = txBairroCob.getText(), CidadeCob_Clientes = txCidadeCob.getText(), UfCob_Clientes = txUfCob.getText(), CepCob_Clientes = txCepCob.getText();

        Clientes cli = new Clientes(RazaoSocial_Clientes, NomeFantasia_Clientes, DDD_Clientes, Telefone_Clientes, Fax_Clientes, Contatos_Clientes, Cnpj_Clientes, Ie_Clientes, Email_Clientes, EndFat_Clientes, PaisFat_Clientes, BairroFat_Clientes, CidadeFat_Clientes, UfFat_Clientes, CepFat_Clientes, EndEnt_Clientes, PaisEnt_Clientes, BairroEnt_Clientes, CidadeEnt_Clientes, UfEnt_Clientes, CepEnt_Clientes, EndCob_Clientes, PaisCob_Clientes, BairroCob_Clientes, CidadeCob_Clientes, UfCob_Clientes, CepCob_Clientes);
        ClientesDAO dao = new ClientesDAO();

        if (RazaoSocial_Clientes.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro no Cadastro de Novo Cliente");
            alert.setContentText("Para o cadastro de um novo cliente, PELO MENOS o nome deve ser preenchido!");
            alert.showAndWait();
        } else {
            if (dao.cadastrarCliente(cli)) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Cliente Cadastrado com Sucesso!");
                alert.showAndWait();
                logarTelaGerencial();
                fecharTelaCadastrarClientes();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Cliente NÃO Cadastrado!");
                alert.show();
            }
        }
    }

    private void fecharTelaCadastrarClientes() {
        CadastrarClientes.getStage().close();
    }

    private void logarTelaGerencial() {
        Gerencial gerencial = new Gerencial();
        fecharTelaCadastrarClientes();
        try {
            gerencial.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(CadastrarClientesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
