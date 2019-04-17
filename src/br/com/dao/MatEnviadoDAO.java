package br.com.dao;

import br.com.jdbc.ModuloDeConexao;
import br.com.model.Clientes;
import br.com.model.MatEnviado;
import br.com.model.Produtos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import static java.time.ZoneOffset.UTC;
import java.time.format.DateTimeFormatter;
import static java.time.format.DateTimeFormatter.ofPattern;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javax.swing.text.DateFormatter;

public class MatEnviadoDAO {

    public static boolean cadastrarClienteMatEnviado(MatEnviado matenviado) {
        Connection conexao = ModuloDeConexao.conector();
        PreparedStatement cadastraSt = null;

        String sql = "insert into Clientes_Mat_Enviados(Id_Clientes, Mat_Env_Data, Mat_Env_Desc) values (?,?,?);";

        try {

            cadastraSt = conexao.prepareStatement(sql);
            cadastraSt.setString(1, matenviado.getId_Clientes());
            cadastraSt.setString(2, ((TextField) matenviado.getMat_Env_Data().getEditor()).getText());
            cadastraSt.setString(3, matenviado.getMat_Env_Desc());
            cadastraSt.executeUpdate();
            System.out.println("Envio de material cadastrado com sucesso!");
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar envio de material. Mensagem:" + e.getMessage());
            return false;
        } finally {
            try {
                cadastraSt.close();
                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de cadastro de envio de materiais. Mensagem:" + e.getMessage());
            }
        }
    }

    public static List<MatEnviado> listarClientesMatEnviado(String cliente) {
        Connection conexao = ModuloDeConexao.conector();
        ArrayList<MatEnviado> matenviado = new ArrayList<>();

        String sql = "SELECT * FROM `Clientes_Mat_Enviados` WHERE Id_Clientes=?;";

        try {
//            conexao.setAutoCommit(false);
            PreparedStatement consultaSt = conexao.prepareStatement(sql);
            consultaSt.setFetchSize(200);
            consultaSt.setInt(1, Integer.parseInt(cliente));
            ResultSet resultado = consultaSt.executeQuery();
            resultado.setFetchSize(100);
            while (resultado.next()) {
                MatEnviado matenv = new MatEnviado();
//                DateTimeFormatter dtformatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
//                LocalDate dt = LocalDate.parse(resultado.getString("Mat_Env_Data"), dtformatter);
//                Date date = Date.valueOf(dt);
//                matenv.setMat_Env_Data2(date);
                matenv.setMat_Env_Data3(resultado.getString("Mat_Env_Data"));
                matenv.setMat_Env_Desc(resultado.getString("Mat_Env_Desc"));
                matenviado.add(matenv);
            }

            consultaSt.close();
            resultado.close();

        } catch (SQLException e) {
            return null;
        } finally {
            try {

                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de atualização de envio de materiais. Mensagem:" + e.getMessage());
            }
        }
        return matenviado;
    }

}
