package br.com.dao;

import br.com.jdbc.ModuloDeConexao;
import br.com.model.Representadas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepresentadasDAO {

    public static boolean cadastrarRepresentada(Representadas representadas) {
        Connection conexao = ModuloDeConexao.conector();
        PreparedStatement cadastraSt = null;

        String sql = "insert into Representadas(Nome_Representadas, DDD_Representadas, Telefone_Representadas) values (?,?,?);";

        try {

            cadastraSt = conexao.prepareStatement(sql);
            cadastraSt.setString(1, representadas.getNome_Representadas());
            cadastraSt.setString(2, representadas.getDDD_Representadas());
            cadastraSt.setString(3, representadas.getTelefone_Representadas());
            cadastraSt.executeUpdate();

            System.out.println("Representada cadastrada com sucesso!");
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar representada. Mensagem:" + e.getMessage());
            return false;
        } finally {
            try {
                cadastraSt.close();
                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de cadastro de representadas. Mensagem:" + e.getMessage());
            }
        }
    }

    public static void deletarRepresentada(Representadas representadas) {
        Connection conexao = ModuloDeConexao.conector();
        PreparedStatement excluiSt = null;

        String sql = "Delete from Representadas where Id_Representadas=?;";

        try {
            excluiSt = conexao.prepareStatement(sql);
            excluiSt.setString(1, representadas.getId_Representadas());
            excluiSt.executeUpdate();

            System.out.println("Representada deletada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao deletar representada. Mensagem:" + e.getMessage());
        } finally {
            try {
                excluiSt.close();
                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de exclusão de representadas. Mensagem:" + e.getMessage());
            }
        }
    }

    public static void atualizarRepresentada(Representadas representadas) {
        Connection conexao = ModuloDeConexao.conector();
        PreparedStatement atualizaSt = null;

        String sql = "Update Representadas set Nome_Representadas=?, DDD_Representadas=?, Telefone_Representadas=? where Id_Representadas=?;";

        try {
            atualizaSt = conexao.prepareStatement(sql);
            atualizaSt.setString(1, representadas.getNome_Representadas());
            atualizaSt.setString(2, representadas.getDDD_Representadas());
            atualizaSt.setString(3, representadas.getTelefone_Representadas());
            atualizaSt.executeUpdate();

            System.out.println("Representada atualizada com sucesso!");

        } catch (Exception e) {
        } finally {
            try {
                atualizaSt.close();
                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de atualização de representadas. Mensagem:" + e.getMessage());
            }
        }
    }

    public static List<Representadas> listarRepresentada() {
        Connection conexao = ModuloDeConexao.conector();
        List<Representadas> representadas = new ArrayList<>();

        String sql = "Select * from Representadas;";

        try {
            PreparedStatement consultaSt = conexao.prepareStatement(sql);
            ResultSet resultado = consultaSt.executeQuery();
            while (resultado.next()) {
                Representadas representada = new Representadas();
                representada.setId_Representadas(resultado.getString("Id_Representadas"));
                representada.setNome_Representadas(resultado.getString("Nome_Representadas"));
                representada.setDDD_Representadas(resultado.getString("DDD_Representadas"));
                representada.setTelefone_Representadas(resultado.getString("Tel_Representadas"));
                representadas.add(representada);
            }

            consultaSt.close();
            resultado.close();

        } catch (SQLException e) {
            return null;
        } finally {
            try {

                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de atualização de representadas. Mensagem:" + e.getMessage());
            }
        }
        return representadas;
    }

    public static List<Representadas> listarRepresentadaComboBox() {
        Connection conexao = ModuloDeConexao.conector();
        List<Representadas> representadas = new ArrayList<>();

        String sql = "Select Id_Representadas, Nome_Representadas from Representadas;";

        try {
            PreparedStatement consultaSt = conexao.prepareStatement(sql);
            ResultSet resultado = consultaSt.executeQuery();
            while (resultado.next()) {
                Representadas representada = new Representadas();
                representada.setId_Representadas(resultado.getString("Id_Representadas"));
                representada.setNome_Representadas(resultado.getString("Nome_Representadas"));
                representadas.add(representada);
            }

            consultaSt.close();
            resultado.close();

        } catch (SQLException e) {
            return null;
        } finally {
            try {

                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de listagem de representadas no combobox. Mensagem:" + e.getMessage());
            }
        }
        return representadas;
    }

}
