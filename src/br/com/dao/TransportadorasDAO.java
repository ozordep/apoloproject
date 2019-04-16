package br.com.dao;

import br.com.jdbc.ModuloDeConexao;
import br.com.model.Transportadoras;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransportadorasDAO {

    public static boolean cadastrarTransportadora(Transportadoras transportadoras) {
        Connection conexao = ModuloDeConexao.conector();
        PreparedStatement cadastraSt = null;

        String sql = "insert into Transportadoras(Nome_Transportadoras, DDD1_Transportadoras, Tel1_Transportadoras, DDD2_Transportadoras, Tel2_Transportadoras) values (?,?,?,?,?);";

        try {

            cadastraSt = conexao.prepareStatement(sql);
            cadastraSt.setString(1, transportadoras.getNome_Transportadoras());
            cadastraSt.setString(2, transportadoras.getDDD1_Transportadoras());
            cadastraSt.setString(3, transportadoras.getTel1_Transportadoras());
            cadastraSt.setString(4, transportadoras.getDDD2_Transportadoras());
            cadastraSt.setString(5, transportadoras.getTel2_Transportadoras());
            cadastraSt.executeUpdate();

            System.out.println("Transportadora cadastrada com sucesso!");
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar transportadora. Mensagem:" + e.getMessage());
            return false;
        } finally {
            try {
                cadastraSt.close();
                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de cadastro de transportadoras. Mensagem:" + e.getMessage());
            }
        }
    }

    public static void deletarTransportadora(Transportadoras transportadoras) {
        Connection conexao = ModuloDeConexao.conector();
        PreparedStatement excluiSt = null;

        String sql = "Delete from Transportadoras where Id_Transportadoras=?;";

        try {
            excluiSt = conexao.prepareStatement(sql);
            excluiSt.setString(1, transportadoras.getId_Transportadoras());
            excluiSt.executeUpdate();

            System.out.println("Transportadora deletada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao deletar transportadora. Mensagem:" + e.getMessage());
        } finally {
            try {
                excluiSt.close();
                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de exclusão de transportadoras. Mensagem:" + e.getMessage());
            }
        }
    }

    public static void atualizarTransportadora(Transportadoras transportadoras) {
        Connection conexao = ModuloDeConexao.conector();
        PreparedStatement atualizaSt = null;

        String sql = "Update Transportadoras set Nome_Transportadoras=?, DDD1_Transportadoras=?, Tel1_Transportadoras=?, DDD2_Transportadoras=?, Tel2_Transportadoras=? where Id_Transportadoras=?;";

        try {
            atualizaSt = conexao.prepareStatement(sql);
            atualizaSt.setString(1, transportadoras.getNome_Transportadoras());
            atualizaSt.setString(2, transportadoras.getDDD1_Transportadoras());
            atualizaSt.setString(3, transportadoras.getTel1_Transportadoras());
            atualizaSt.setString(4, transportadoras.getDDD2_Transportadoras());
            atualizaSt.setString(5, transportadoras.getTel2_Transportadoras());
            atualizaSt.setString(6, transportadoras.getId_Transportadoras());
            atualizaSt.executeUpdate();

            System.out.println("Transportadora atualizada com sucesso!");

        } catch (Exception e) {
        } finally {
            try {
                atualizaSt.close();
                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de atualização de transportadoras. Mensagem:" + e.getMessage());
            }
        }
    }

    public static List<Transportadoras> listarTransportadora() {
        Connection conexao = ModuloDeConexao.conector();
        List<Transportadoras> transportadoras = new ArrayList<>();

        String sql = "Select * from Transportadoras;";

        try {
            PreparedStatement consultaSt = conexao.prepareStatement(sql);
            ResultSet resultado = consultaSt.executeQuery();
            while(resultado.next()){
                Transportadoras transportadora = new Transportadoras();
                transportadora.setId_Transportadoras(resultado.getString("Id_Transportadoras"));
                transportadora.setNome_Transportadoras(resultado.getString("Nome_Transportadoras"));
                transportadora.setDDD1_Transportadoras(resultado.getString("DDD1_Transportadoras"));
                transportadora.setTel1_Transportadoras(resultado.getString("Tel1_Transportadoras"));
                transportadora.setDDD2_Transportadoras(resultado.getString("DDD2_Transportadoras"));
                transportadora.setTel2_Transportadoras(resultado.getString("Tel2_Transportadoras"));                
                transportadoras.add(transportadora);
            }

            consultaSt.close();
            resultado.close();

        } catch (SQLException e) {
            return null;
        } finally {
            try {

                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de atualização de transportadoras. Mensagem:" + e.getMessage());
            }
        }
        return transportadoras;
    }

}
