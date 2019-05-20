/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import static br.com.jdbc.ModuloDeConexao.conector;
import java.awt.Desktop;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author jpped
 */
public class RelatorioClientesController implements Initializable {

    @FXML
    private TextField txtInicial;

    @FXML
    private TextField txtFinal;

    @FXML
    private Button btnGerar;

    @FXML
    private TextField txtCidades;

    @FXML
    private Button btnVoltar;

    final ObservableList optionsRepresentadas = FXCollections.observableArrayList();

    final ObservableList optionsOrdenar = FXCollections.observableArrayList();

    final ObservableList optionsGrupos = FXCollections.observableArrayList();

    final ObservableList optionsProdutos = FXCollections.observableArrayList();

    List<String> sugestoesCidades = new ArrayList<String>();

    @FXML
    private ComboBox cbRepresentadas = new ComboBox(optionsRepresentadas);

    @FXML
    private ComboBox cbOrdenando = new ComboBox(optionsOrdenar);

    @FXML
    private ComboBox cbGrupos = new ComboBox(optionsGrupos);

    @FXML
    private ComboBox cbProdutos = new ComboBox(optionsProdutos);

    PreparedStatement pst = null;
    ResultSet rs = null;
    Connection conn = conector();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarCombosBoxes();
        btnGerar.setOnMouseClicked((MouseEvent e) -> {
            gerarRelatorioClientes();
        });

    }

    public void gerarRelatorioClientes() {

        try {
            // Carregando o arquivo jrxml do Relatório
            JasperDesign jd = JRXmlLoader.load("E:\\TCC Desktop - oficial\\apolo\\src\\br\\com\\reports\\apoloteste.jrxml");
            String sql
                    = "SELECT"
                    + "     Clientes.Id_Clientes AS Clientes_Id_Clientes,"
                    + "     Clientes.RazaoSocial_Clientes AS Clientes_RazaoSocial_Clientes,"
                    + "     Clientes.NomeFantasia_Clientes AS Clientes_NomeFantasia_Clientes,"
                    + "     Clientes.Telefone_Clientes AS Clientes_Telefone_Clientes,"
                    + "     Clientes.CidadeFat_Clientes AS Clientes_CidadeFat_Clientes,"
                    + "     Clientes.UfFat_Clientes AS Clientes_UfFat_Clientes "
                    + "FROM Clientes join Clientes_Grupos,Grupos,Representadas,Produtos WHERE 1=1 and " // Where que sempre resulta em true, para fazer as filtragens somente com AND
                    + " (Clientes.Id_Clientes = Clientes_Grupos.Id_Clientes) and "
                    + " (Clientes_Grupos.Id_Grupos = Grupos.Id_Grupos) "
                    + filtrarPorRepresentada()
                    + filtrarPorCidade()
                    + filtrarPorGrupos()
                    + filtrarPorProdutos()
                    + definirOrdenacao();

            //Imprimindo query no log da IDE
            System.out.println(sql);

            try {

                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();

                if (!rs.next()) {
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setTitle("Erro ao gerar relatório");
                    alerta.setHeaderText("Não foram achadas informações conforme os dados fornecidos.");
                    alerta.setContentText("Por favor, reveja as informações e tente novamente.");
                    alerta.showAndWait();
                } else {

                    // Atribuindo a query para o report
                    JRDesignQuery newQuery = new JRDesignQuery();
                    newQuery.setText(sql);
                    jd.setQuery(newQuery);
                    // Compilando a query
                    JasperReport jr = JasperCompileManager.compileReport(jd);
                    // Preparando o relatório para visualização
                    JasperPrint jp = JasperFillManager.fillReport(jr, null, conector());

//                    // Importando para pdf o relatório
//                    JasperExportManager.exportReportToPdfFile(jp, "E:\\TCC Desktop - oficial\\apolo\\src\\br\\com\\reports\\relpdf.pdf");
//                    // Abrindo o relatório no desktop em pdf
//                    File file = new File("E:\\TCC Desktop - oficial\\apolo\\src\\br\\com\\reports\\relpdf.pdf");
//                    try {
//                        Desktop.getDesktop().open(file);
//                    } catch (Exception e) {
//                        System.out.println(e);
//                    }
//                    file.deleteOnExit();
                    JasperViewer.viewReport(jp, false);

                }

                pst.close();
                rs.close();

            } catch (Exception e) {

                System.out.println(e);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public String filtrarPorRepresentada() {

        if (cbRepresentadas.getValue() == null || cbRepresentadas.getValue() == "-- Nenhuma --") {
            return "";
        } else {

            return " and (Grupos.Id_Representadas = Representadas.Id_Representadas) and ( Representadas.Nome_Representadas = \""
                    + (cbRepresentadas.getValue() + "\""
                    + ")");

        }

    }

    public String definirOrdenacao() {

        if (cbOrdenando.getValue() == "Código Cliente") {
            return " GROUP BY Clientes.Id_Clientes ORDER BY Clientes.Id_Clientes; ";
        } else if (cbOrdenando.getValue() == "Razão Social") {
            return " GROUP BY Clientes.Id_Clientes ORDER BY Clientes.RazaoSocial_Clientes; ";
        } else if (cbOrdenando.getValue() == "Nome Fantasia") {
            return " GROUP BY Clientes.Id_Clientes ORDER BY  Clientes.NomeFantasia_Clientes; ";
        } else if (cbOrdenando.getValue() == "Telefone") {
            return " GROUP BY Clientes.Id_Clientes ORDER BY  Clientes.Telefone_Clientes; ";
        } else if (cbOrdenando.getValue() == "Cidade") {
            return " GROUP BY Clientes.Id_Clientes ORDER BY  Clientes.CidadeFat_Clientes; ";
        } else if (cbOrdenando.getValue() == "U.F") {
            return " GROUP BY Clientes.Id_Clientes ORDER BY  Clientes.UfFat_Clientes; ";
        } else {
            return " GROUP BY Clientes.RazaoSocial_Clientes";
        }

    }

    public String filtrarPorCidade() {

        if (txtCidades.getText().isEmpty()) {
            return "";
        } else {

            return " and Clientes.CidadeFat_Clientes = " + "\"" + txtCidades.getText() + "\"" + " ";

        }

    }

    public String filtrarPorGrupos() {

        if (cbGrupos.getValue() == null || cbGrupos.getValue() == "-- Nenhum -- ") {
            return "";
        } else {

            return " and Grupos.Nome_Grupos = " + "\"" + cbGrupos.getValue() + "\"" + " ";

        }

    }

    public String filtrarPorProdutos() {

        if (cbProdutos.getValue() == null || cbProdutos.getValue() == "-- Nenhum -- ") {
            return "";
        } else {

            return " and Produtos.Nome_Produtos = " + "\"" + cbProdutos.getValue() + "\"" + " and "
                    + " (Produtos.Id_Grupos = Clientes_Grupos.Id_Grupos) and "
                    + " (Clientes_Grupos.Id_Clientes = Clientes.Id_Clientes) ";

        }

    }

    public void preencherComboBoxOrdenacao() {

        // ComboBox de ordenação
        optionsOrdenar.add("Código Cliente");
        optionsOrdenar.add("Razão Social");
        optionsOrdenar.add("Nome Fantasia");
        optionsOrdenar.add("Telefone");
        optionsOrdenar.add("Cidade");
        optionsOrdenar.add("U.F");
        cbOrdenando.setItems(optionsOrdenar);
        cbOrdenando.getSelectionModel().select(2);

    }

    public void preencherComboBoxRepresentadas() {

        //ComboBox de Representadas
        optionsRepresentadas.add("-- Nenhuma --");
        try {
            String query = "select Nome_Representadas from Representadas";

            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                optionsRepresentadas.add(rs.getString("Nome_Representadas"));
                cbRepresentadas.setItems(optionsRepresentadas);
            }
            pst.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioClientesController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void preencherComboBoxGrupos() {

        //ComboBox de Grupos
        optionsGrupos.add("-- Nenhum -- ");
        try {
            String query = "SELECT Grupos.Nome_Grupos from Grupos ORDER BY Grupos.Nome_Grupos ;";

            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                optionsGrupos.add(rs.getString("Grupos.Nome_Grupos"));
                cbGrupos.setItems(optionsGrupos);
            }
            pst.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioClientesController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void preencherComboBoxProdutos() {

        //ComboBox de produtos
        optionsProdutos.add("-- Nenhum -- ");
        try {
            String query = "SELECT Produtos.Nome_Produtos from Produtos ORDER BY Produtos.Nome_Produtos;";

            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                optionsProdutos.add(rs.getString("Produtos.Nome_Produtos"));
                cbProdutos.setItems(optionsProdutos);
            }
            pst.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioClientesController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void preencherSugestoesCidades() {

        try {

            // Definindo query que irá buscar no banco o preenchimento das sugestões.
            String query = "SELECT Cidades.Nome_Cidades FROM Cidades;";
            //Preparando conexão.
            pst = conn.prepareStatement(query);
            // Executando a query.
            rs = pst.executeQuery();

            while (rs.next()) {
                // Atribuindo os valores do banco
                sugestoesCidades.add(rs.getString("Cidades.Nome_Cidades"));
            }

            TextFields.bindAutoCompletion(txtCidades, sugestoesCidades);

        } catch (Exception e) {

            System.out.println(e);
        }

    }

    public void carregarCombosBoxes() {

        preencherComboBoxOrdenacao();
        preencherComboBoxRepresentadas();
        preencherSugestoesCidades();
        preencherComboBoxGrupos();
        preencherComboBoxProdutos();

    }

}
