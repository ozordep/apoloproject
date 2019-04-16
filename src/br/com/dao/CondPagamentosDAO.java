package br.com.dao;

import br.com.jdbc.ModuloDeConexao;
import br.com.model.CondPagamentos;
import br.com.model.Representadas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CondPagamentosDAO {

    public static boolean cadastrarCondPagamento(CondPagamentos condpagamentos) {
        Connection conexao = ModuloDeConexao.conector();
        PreparedStatement cadastraSt = null;

        String sql = "insert into CondPagamentos(Nome_CondPgtos) values (?);";

        try {

            cadastraSt = conexao.prepareStatement(sql);
            cadastraSt.setString(1, condpagamentos.getNome_CondPgtos());
            cadastraSt.executeUpdate();

            System.out.println("Cond. Pagamento cadastrada com sucesso!");
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar cond. pagamento. Mensagem:" + e.getMessage());
            return false;
        } finally {
            try {
                cadastraSt.close();
                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de cadastro de cond. pagamentos. Mensagem:" + e.getMessage());
            }
        }
    }

    public static void deletarCondPagamento(CondPagamentos condpagamentos) {
        Connection conexao = ModuloDeConexao.conector();
        PreparedStatement excluiSt = null;

        String sql = "Delete from CondPagamentos where Id_CondPgtos=?;";

        try {
            excluiSt = conexao.prepareStatement(sql);
            excluiSt.setString(1, condpagamentos.getId_CondPgtos());
            excluiSt.executeUpdate();

            System.out.println("Cond. Pagamento deletada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao deletar cond. pagamento. Mensagem:" + e.getMessage());
        } finally {
            try {
                excluiSt.close();
                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de exclusão de cond. pagamento. Mensagem:" + e.getMessage());
            }
        }
    }

    public static void atualizarCondPagamento(CondPagamentos condpagamentos) {
        Connection conexao = ModuloDeConexao.conector();
        PreparedStatement atualizaSt = null;

        String sql = "Update CondPagamentos set Nome_CondPgtos=? where Id_CondPgtos=?;";

        try {
            atualizaSt = conexao.prepareStatement(sql);
            atualizaSt.setString(1, condpagamentos.getNome_CondPgtos());
            atualizaSt.executeUpdate();

            System.out.println("Cond. Pagamento atualizada com sucesso!");

        } catch (Exception e) {
        } finally {
            try {
                atualizaSt.close();
                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de atualização de cond. pagamento. Mensagem:" + e.getMessage());
            }
        }
    }

    public static List<CondPagamentos> listarCondPagamento() {
        Connection conexao = ModuloDeConexao.conector();
        List<CondPagamentos> condpagamentos = new ArrayList<>();

        String sql = "Select * from CondPagamentos;";

        try {
            PreparedStatement consultaSt = conexao.prepareStatement(sql);
            ResultSet resultado = consultaSt.executeQuery();
            while (resultado.next()) {
                CondPagamentos condpagamento = new CondPagamentos();
                condpagamento.setId_CondPgtos(resultado.getString("Id_CondPgtos"));
                condpagamento.setNome_CondPgtos(resultado.getString("Nome_CondPgtos"));
                condpagamentos.add(condpagamento);
            }

            consultaSt.close();
            resultado.close();

        } catch (SQLException e) {
            return null;
        } finally {
            try {

                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de atualização de cond. pagamentos. Mensagem:" + e.getMessage());
            }
        }
        return condpagamentos;
    }

    public static List<CondPagamentos> listarCondPagamentosComboBox() {
        Connection conexao = ModuloDeConexao.conector();
        List<CondPagamentos> condpagamentos = new ArrayList<>();

        String sql = "Select Id_CondPgtos, Nome_CondPgtos from CondPagamentos;";

        try {
            PreparedStatement consultaSt = conexao.prepareStatement(sql);
            ResultSet resultado = consultaSt.executeQuery();
            while (resultado.next()) {
                CondPagamentos condpagamento = new CondPagamentos();
                condpagamento.setId_CondPgtos(resultado.getString("Id_CondPgtos"));
                condpagamento.setNome_CondPgtos(resultado.getString("Nome_CondPgtos"));
                condpagamentos.add(condpagamento);
            }

            consultaSt.close();
            resultado.close();

        } catch (SQLException e) {
            return null;
        } finally {
            try {

                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de listagem de cond. pagamentos no combobox. Mensagem:" + e.getMessage());
            }
        }
        return condpagamentos;
    }

}
