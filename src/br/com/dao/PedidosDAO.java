package br.com.dao;

import br.com.jdbc.ModuloDeConexao;
import br.com.model.Clientes;
import br.com.model.Pedidos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidosDAO {

    public static boolean cadastrarPedido(Pedidos pedidos) {
        Connection conexao = ModuloDeConexao.conector();
        PreparedStatement cadastraSt = null;

        String sql = "insert into Pedidos(Data_Pedidos, Vendedor_Pedidos, Ordem_Compra_Pedidos, Obs_Pedidos) values (?,?,?,?,?);";

        try {

            cadastraSt = conexao.prepareStatement(sql);
            //cadastraSt.setString(1, pedidos.getLogo_Rep_Pedidos());
            cadastraSt.setString(2, pedidos.getData_Pedidos());
            cadastraSt.setString(3, pedidos.getVendedor_Pedidos());
            cadastraSt.setString(4, pedidos.getOrdem_Compra_Pedidos());
            cadastraSt.setString(5, pedidos.getObs_Pedidos());
            cadastraSt.executeUpdate();
            System.out.println("Pedido cadastrado com sucesso!");
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar pedido. Mensagem:" + e.getMessage());
            return false;
        } finally {
            try {
                cadastraSt.close();
                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de cadastro de pedidos. Mensagem:" + e.getMessage());
            }
        }
    }

    public static void deletarPedido(Pedidos pedidos) {
        Connection conexao = ModuloDeConexao.conector();
        PreparedStatement excluiSt = null;

        String sql = "Delete from Pedidos where Id_Pedidos=?;";

        try {
            excluiSt = conexao.prepareStatement(sql);
            //  excluiSt.setInt(1, clientes.getId_Pedidos());
            excluiSt.executeUpdate();

            System.out.println("Pedido deletado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao deletar pedido. Mensagem:" + e.getMessage());
        } finally {
            try {
                excluiSt.close();
                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de exclusão de pedidos. Mensagem:" + e.getMessage());
            }
        }
    }

    public static void atualizarPedido(Pedidos pedidos) {
        Connection conexao = ModuloDeConexao.conector();
        PreparedStatement atualizaSt = null;

        String sql = "Update Pedidos set =?, =? where Id_Pedidos=?;";

        try {
            atualizaSt = conexao.prepareStatement(sql);
            //    atualizaSt.setString(1, clientes.getNome_Clientes());
            //    atualizaSt.setString(2, clientes.getCidade_Clientes());
            //    atualizaSt.setInt(3, clientes.getId_Clientes());
            atualizaSt.executeUpdate();

            System.out.println("Pedido atualizado com sucesso!");

        } catch (Exception e) {
        } finally {
            try {
                atualizaSt.close();
                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de atualização de pedidos. Mensagem:" + e.getMessage());
            }
        }
    }

    public static List<Pedidos> listarPedidos() {
        Connection conexao = ModuloDeConexao.conector();
        List<Pedidos> pedidos = new ArrayList<>();

        String sql = "Select * from Pedidos;";

        try {
            PreparedStatement consultaSt = conexao.prepareStatement(sql);
            ResultSet resultado = consultaSt.executeQuery();
            while (resultado.next()) {
                Pedidos pedido = new Pedidos();
                pedido.setId_Pedidos(resultado.getString("Id_Pedidos"));
                pedido.setLogo_Rep_Pedidos(resultado.getString("Logo_Rep_Pedidos"));
                pedido.setData_Pedidos(resultado.getString("Data_Pedidos"));
                pedido.setVendedor_Pedidos(resultado.getString("Vendedor_Pedidos"));
                pedido.setOrdem_Compra_Pedidos(resultado.getString("Ordem_Compra_Pedidos"));
                pedido.setObs_Pedidos(resultado.getString("Obs_Pedidos"));
                pedidos.add(pedido);
            }

            consultaSt.close();
            resultado.close();

        } catch (SQLException e) {
            return null;
        } finally {
            try {

                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de atualização de pedidos. Mensagem:" + e.getMessage());
            }
        }
        return pedidos;
    }

}
