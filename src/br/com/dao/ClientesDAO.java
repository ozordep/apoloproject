package br.com.dao;

import br.com.model.Clientes;
import br.com.jdbc.ModuloDeConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientesDAO {

    public static boolean cadastrarCliente(Clientes clientes) {
        Connection conexao = ModuloDeConexao.conector();
        PreparedStatement cadastraSt = null;

        String sql = "insert into Clientes(RazaoSocial_Clientes, NomeFantasia_Clientes, DDD_Clientes, Telefone_Clientes, Fax_Clientes, Contatos_Clientes, Cnpj_Clientes, Ie_Clientes, Email_Clientes, EndFat_Clientes, PaisFat_Clientes, BairroFat_Clientes, CidadeFat_Clientes, UfFat_Clientes, CepFat_Clientes, EndEnt_Clientes, PaisEnt_Clientes, BairroEnt_Clientes, CidadeEnt_Clientes, UfEnt_Clientes, CepEnt_Clientes, EndCob_Clientes, PaisCob_Clientes, BairroCob_Clientes, CidadeCob_Clientes, UfCob_Clientes, CepCob_Clientes) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

        try {

            cadastraSt = conexao.prepareStatement(sql);
            //cadastraSt.setInt(1, clientes.getId_Clientes());
            cadastraSt.setString(1, clientes.getRazaoSocial_Clientes());
            cadastraSt.setString(2, clientes.getNomeFantasia_Clientes());
            cadastraSt.setString(3, clientes.getDDD_Clientes());
            cadastraSt.setString(4, clientes.getTelefone_Clientes());
            cadastraSt.setString(5, clientes.getFax_Clientes());
            cadastraSt.setString(6, clientes.getContatos_Clientes());
            cadastraSt.setString(7, clientes.getCnpj_Clientes());
            cadastraSt.setString(8, clientes.getIe_Clientes());
            cadastraSt.setString(9, clientes.getEmail_Clientes());
            cadastraSt.setString(10, clientes.getEndFat_Clientes());
            cadastraSt.setString(11, clientes.getPaisFat_Clientes());
            cadastraSt.setString(12, clientes.getBairroFat_Clientes());
            cadastraSt.setString(13, clientes.getCidadeFat_Clientes());
            cadastraSt.setString(14, clientes.getUfFat_Clientes());
            cadastraSt.setString(15, clientes.getCepFat_Clientes());
            cadastraSt.setString(16, clientes.getEndEnt_Clientes());
            cadastraSt.setString(17, clientes.getPaisEnt_Clientes());
            cadastraSt.setString(18, clientes.getBairroEnt_Clientes());
            cadastraSt.setString(19, clientes.getCidadeEnt_Clientes());
            cadastraSt.setString(20, clientes.getUfEnt_Clientes());
            cadastraSt.setString(21, clientes.getCepEnt_Clientes());
            cadastraSt.setString(22, clientes.getEndCob_Clientes());
            cadastraSt.setString(23, clientes.getPaisCob_Clientes());
            cadastraSt.setString(24, clientes.getBairroCob_Clientes());
            cadastraSt.setString(25, clientes.getCidadeCob_Clientes());
            cadastraSt.setString(26, clientes.getUfCob_Clientes());
            cadastraSt.setString(27, clientes.getCepCob_Clientes());
            cadastraSt.executeUpdate();
            System.out.println("Cliente cadastrado com sucesso!");
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar cliente. Mensagem:" + e.getMessage());
            return false;
        } finally {
            try {
                cadastraSt.close();
                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de cadastro de clientes. Mensagem:" + e.getMessage());
            }
        }
    }

    public static void deletarCliente(Clientes clientes) {
        Connection conexao = ModuloDeConexao.conector();
        PreparedStatement excluiSt = null;

        String sql = "Delete from Clientes where Id_Clientes=?;";

        try {
            excluiSt = conexao.prepareStatement(sql);
            //  excluiSt.setInt(1, clientes.getId_Clientes());
            excluiSt.executeUpdate();

            System.out.println("Cliente deletado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao deletar cliente. Mensagem:" + e.getMessage());
        } finally {
            try {
                excluiSt.close();
                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de exclusão de clientes. Mensagem:" + e.getMessage());
            }
        }
    }

    public static void atualizarCliente(Clientes clientes) {
        Connection conexao = ModuloDeConexao.conector();
        PreparedStatement atualizaSt = null;

        String sql = "Update Clientes set Nome_Clientes=?, Cidade_Clientes=? where Id_Clientes=?;";

        try {
            atualizaSt = conexao.prepareStatement(sql);
            //    atualizaSt.setString(1, clientes.getNome_Clientes());
            //    atualizaSt.setString(2, clientes.getCidade_Clientes());
            //    atualizaSt.setInt(3, clientes.getId_Clientes());
            atualizaSt.executeUpdate();

            System.out.println("Cliente atualizado com sucesso!");

        } catch (Exception e) {
        } finally {
            try {
                atualizaSt.close();
                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de atualização de clientes. Mensagem:" + e.getMessage());
            }
        }
    }

    public static List<Clientes> listarClientes() {
        Connection conexao = ModuloDeConexao.conector();
        List<Clientes> clientes = new ArrayList<>();

        String sql = "Select * from Clientes;";

        try {
            conexao.setAutoCommit(false);
            PreparedStatement consultaSt = conexao.prepareStatement(sql);
            consultaSt.setFetchSize(200);
            ResultSet resultado = consultaSt.executeQuery();
            while (resultado.next()) {
                Clientes cliente = new Clientes();
                cliente.setId_Clientes(resultado.getString("Id_Clientes"));
                cliente.setRazaoSocial_Clientes(resultado.getString("RazaoSocial_Clientes"));
                cliente.setNomeFantasia_Clientes(resultado.getString("NomeFantasia_Clientes"));
                cliente.setDDD_Clientes(resultado.getString("DDD_Clientes"));
                cliente.setTelefone_Clientes(resultado.getString("Telefone_Clientes"));
                cliente.setFax_Clientes(resultado.getString("Fax_Clientes"));
                cliente.setContatos_Clientes(resultado.getString("Contatos_Clientes"));
                cliente.setCnpj_Clientes(resultado.getString("Cnpj_Clientes"));
                cliente.setIe_Clientes(resultado.getString("Ie_Clientes"));
                cliente.setEmail_Clientes(resultado.getString("Email_Clientes"));
                cliente.setEndFat_Clientes(resultado.getString("EndFat_Clientes"));
                cliente.setPaisFat_Clientes(resultado.getString("PaisFat_Clientes"));
                cliente.setBairroFat_Clientes(resultado.getString("BairroFat_Clientes"));
                cliente.setCidadeFat_Clientes(resultado.getString("CidadeFat_Clientes"));
                cliente.setUfFat_Clientes(resultado.getString("UfFat_Clientes"));
                cliente.setCepFat_Clientes(resultado.getString("CepFat_Clientes"));
                cliente.setEndEnt_Clientes(resultado.getString("EndEnt_Clientes"));
                cliente.setPaisEnt_Clientes(resultado.getString("PaisEnt_Clientes"));
                cliente.setBairroEnt_Clientes(resultado.getString("BairroEnt_Clientes"));
                cliente.setCidadeEnt_Clientes(resultado.getString("CidadeEnt_Clientes"));
                cliente.setUfEnt_Clientes(resultado.getString("UfEnt_Clientes"));
                cliente.setCepEnt_Clientes(resultado.getString("CepEnt_Clientes"));
                cliente.setEndCob_Clientes(resultado.getString("EndCob_Clientes"));
                cliente.setPaisCob_Clientes(resultado.getString("PaisCob_Clientes"));
                cliente.setBairroCob_Clientes(resultado.getString("BairroCob_Clientes"));
                cliente.setCidadeCob_Clientes(resultado.getString("CidadeCob_Clientes"));
                cliente.setUfCob_Clientes(resultado.getString("UfCob_Clientes"));
                cliente.setCepCob_Clientes(resultado.getString("CepCob_Clientes"));
                clientes.add(cliente);
            }

            consultaSt.close();
            resultado.close();

        } catch (SQLException e) {
            return null;
        } finally {
            try {

                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de atualização de clientes. Mensagem:" + e.getMessage());
            }
        }
        return clientes;
    }

}
