package br.com.dao;

import br.com.jdbc.ModuloDeConexao;
import br.com.model.ClientesGrupos;
import br.com.model.Grupos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientesGruposDAO {

    public static boolean cadastrarClienteGrupo(ClientesGrupos cligru) {
        Connection conexao = ModuloDeConexao.conector();
        PreparedStatement cadastraSt = null;

        String sql = "INSERT INTO Clientes_Grupos(Id_Grupos,Id_Clientes) values (?,?);";

        try {

            cadastraSt = conexao.prepareStatement(sql);
            cadastraSt.setString(1, cligru.getId_Clientes());
            cadastraSt.setString(2, cligru.getId_Grupos());
            cadastraSt.executeUpdate();
            System.out.println("Grupo cadastrado em cliente com sucesso!");
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar grupo em cliente. Mensagem:" + e.getMessage());
            return false;
        } finally {
            try {
                cadastraSt.close();
                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de cadastro de grupo em cliente. Mensagem:" + e.getMessage());
            }
        }
    }

}
