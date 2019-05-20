package br.com.dao;

import br.com.jdbc.ModuloDeConexao;
import br.com.model.Grupos;
import br.com.model.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.concurrent.Task;

public class ProdutosDAO {

    public static boolean cadastrarProduto(Produtos produtos) {
        Connection conexao = ModuloDeConexao.conector();
        PreparedStatement cadastraSt = null;

        String sql = "insert into Produtos(Id_Representadas, Id_Grupos, Cod_Produtos, Nome_Produtos, Un_Produtos, Qtde_Cx_Produtos, Saldo_Produtos, Preco_Cliente_Produtos, Preco_Revendedor_Produtos, Icms_Produtos, Ipi_Produtos) values (?,?,?,?,?,?,?,?,?,?,?);";

        try {

            cadastraSt = conexao.prepareStatement(sql);
            cadastraSt.setString(1, produtos.getId_Representadas());
            cadastraSt.setString(2, produtos.getId_Grupos());
            cadastraSt.setString(3, produtos.getCod_Produtos());
            cadastraSt.setString(4, produtos.getNome_Produtos());
            cadastraSt.setString(5, produtos.getUn_Produtos());
            cadastraSt.setString(6, produtos.getQtde_Cx_Produtos());
            cadastraSt.setString(7, produtos.getSaldo_Produtos());
            cadastraSt.setString(8, produtos.getPreco_Cliente_Produtos());
            cadastraSt.setString(9, produtos.getPreco_Revendedor_Produtos());
            cadastraSt.setString(10, produtos.getIcms_Produtos());
            cadastraSt.setString(11, produtos.getIpi_Produtos());
            cadastraSt.executeUpdate();

            System.out.println("Produto cadastrado com sucesso!");
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar produto. Mensagem:" + e.getMessage());
            return false;
        } finally {
            try {
                cadastraSt.close();
                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de cadastro de produtos. Mensagem:" + e.getMessage());
            }
        }
    }

    public static void deletarProduto(Produtos produtos) {
        Connection conexao = ModuloDeConexao.conector();
        PreparedStatement excluiSt = null;

        String sql = "Delete from Produtos where Id_Produtos=?;";

        try {
            excluiSt = conexao.prepareStatement(sql);
            excluiSt.setInt(1, produtos.getId_Produtos());
            excluiSt.executeUpdate();

            System.out.println("Produto deletado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao deletar produto. Mensagem:" + e.getMessage());
        } finally {
            try {
                excluiSt.close();
                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de exclusão de produtos. Mensagem:" + e.getMessage());
            }
        }
    }
    
    public static void diminuirSaldo(Produtos produtos, int qtde){
    
        Connection conexao = ModuloDeConexao.conector();
        PreparedStatement diminuiSaldoSt = null;
        
        String sql = "UPDATE Produtos set Produtos.Saldo_Produtos = (Produtos.Saldo_Produtos - ?) WHERE Produtos.Id_Produtos = ?;";
        
         try {
            diminuiSaldoSt = conexao.prepareStatement(sql);
            diminuiSaldoSt.setInt(1, qtde);
            diminuiSaldoSt.setInt(2, produtos.getId_Produtos());
            diminuiSaldoSt.executeUpdate();

            System.out.println("Saldo ajustado com sucesso");

        } catch (SQLException e) {
            System.out.println("Erro ao ajustar saldo. Mensagem:" + e.getMessage());
        } finally {
            try {
                diminuiSaldoSt.close();
                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro Mensagem:" + e.getMessage());
            }
        }
    
    }
    
    public static void adicionarSaldo(Produtos produtos, int qtde){
    
        Connection conexao = ModuloDeConexao.conector();
        PreparedStatement diminuiSaldoSt = null;
        
        String sql = "UPDATE Produtos set Produtos.Saldo_Produtos = (Produtos.Saldo_Produtos + ?) WHERE Produtos.Id_Produtos = ?;";
        
         try {
            diminuiSaldoSt = conexao.prepareStatement(sql);
            diminuiSaldoSt.setInt(1, qtde);
            diminuiSaldoSt.setInt(2, produtos.getId_Produtos());
            diminuiSaldoSt.executeUpdate();

            System.out.println("Saldo ajustado com sucesso");

        } catch (SQLException e) {
            System.out.println("Erro ao ajustar saldo. Mensagem:" + e.getMessage());
        } finally {
            try {
                diminuiSaldoSt.close();
                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro Mensagem:" + e.getMessage());
            }
        }
    
    }

    public static void atualizarProduto(Produtos produtos) {
        Connection conexao = ModuloDeConexao.conector();
        PreparedStatement atualizaSt = null;

        String sql = "Update Produtos set Id_Representadas=?, Id_Grupos=?, Cod_Produtos=?, Nome_Produtos=?, Un_Produtos=?, Qtde_Cx_Produtos=?, Saldo_Produtos=?, Preco_Cliente_Produtos=?, Preco_Revendedor_Produtos=?, Icms_Produtos=?, Ipi_Produtos=? where Id_Produtos=?;";

        try {
            atualizaSt = conexao.prepareStatement(sql);
            atualizaSt.setString(1, produtos.getId_Representadas());
            atualizaSt.setString(2, produtos.getId_Grupos());
            atualizaSt.setString(3, produtos.getCod_Produtos());
            atualizaSt.setString(4, produtos.getNome_Produtos());
            atualizaSt.setString(6, produtos.getUn_Produtos());
            atualizaSt.setString(7, produtos.getQtde_Cx_Produtos());
            atualizaSt.setString(8, produtos.getSaldo_Produtos());
            atualizaSt.setString(9, produtos.getPreco_Cliente_Produtos());
            atualizaSt.setString(10, produtos.getPreco_Revendedor_Produtos());
            atualizaSt.setString(11, produtos.getIcms_Produtos());
            atualizaSt.setString(12, produtos.getIpi_Produtos());
            atualizaSt.executeUpdate();

            System.out.println("Produto atualizado com sucesso!");

        } catch (Exception e) {
        } finally {
            try {
                atualizaSt.close();
                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de atualização de produtos. Mensagem:" + e.getMessage());
            }
        }
    }

    public static List<Produtos> listarProduto() {
        Connection conexao = ModuloDeConexao.conector();

        List<Produtos> produtos = new ArrayList<>();

        String sql = "SELECT * FROM `Produtos`;";

        try {
            //     conexao.setAutoCommit(false);
            PreparedStatement consultaSt = conexao.prepareStatement(sql);
            consultaSt.setFetchSize(200);
            ResultSet resultado = consultaSt.executeQuery();
            while (resultado.next()) {
                Produtos produto = new Produtos();
                produto.setCod_Produtos(resultado.getString("Cod_Produtos"));
                produto.setId_Produtos(resultado.getInt("Id_Produtos"));
                produto.setNome_Produtos(resultado.getString("Nome_Produtos"));
                produto.setUn_Produtos(resultado.getString("Un_Produtos"));
                produto.setQtde_Cx_Produtos(resultado.getString("Qtde_Cx_Produtos"));
                produto.setSaldo_Produtos(resultado.getString("Saldo_Produtos"));
                produto.setPreco_Cliente_Produtos(resultado.getString("Preco_Cliente_Produtos"));
                produto.setPreco_Revendedor_Produtos(resultado.getString("Preco_Revendedor_Produtos"));
                produto.setIcms_Produtos(resultado.getString("Icms_Produtos"));
                produto.setIpi_Produtos(resultado.getString("Ipi_Produtos"));
                produtos.add(produto);
            }

            consultaSt.close();
            resultado.close();

        } catch (SQLException e) {
            return null;
        } finally {
            try {

                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de atualização de produtos. Mensagem:" + e.getMessage());
            }
        }
        return produtos;
    }

    public static List<Produtos> listarProdutoRepresentada(String representada) {
        Connection conexao = ModuloDeConexao.conector();
        ArrayList<Produtos> produtos = new ArrayList<>();

        //String sql = "Call Consulta_Produtos_Id(?);";
        String sql = "SELECT * FROM `Produtos` WHERE Id_Representadas=?;";

        try {
//            conexao.setAutoCommit(false);
            PreparedStatement consultaSt = conexao.prepareStatement(sql);
            consultaSt.setFetchSize(200);
            consultaSt.setInt(1, Integer.parseInt(representada));
            ResultSet resultado = consultaSt.executeQuery();
            resultado.setFetchSize(100);
            while (resultado.next()) {
                Produtos produto = new Produtos();
                produto.setCod_Produtos(resultado.getString("Cod_Produtos"));
                produto.setId_Produtos(resultado.getInt("Id_Produtos"));
                produto.setNome_Produtos(resultado.getString("Nome_Produtos"));
                produto.setUn_Produtos(resultado.getString("Un_Produtos"));
                produto.setQtde_Cx_Produtos(resultado.getString("Qtde_Cx_Produtos"));
                produto.setSaldo_Produtos(resultado.getString("Saldo_Produtos"));
                produto.setPreco_Cliente_Produtos(resultado.getString("Preco_Cliente_Produtos"));
                produto.setPreco_Revendedor_Produtos(resultado.getString("Preco_Revendedor_Produtos"));
                produto.setIcms_Produtos(resultado.getString("Icms_Produtos"));
                produto.setIpi_Produtos(resultado.getString("Ipi_Produtos"));
                produtos.add(produto);
            }

            consultaSt.close();
            resultado.close();

        } catch (SQLException e) {
            return null;
        } finally {
            try {

                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de atualização de produtos. Mensagem:" + e.getMessage());
            }
        }
        return produtos;
    }

    public static List<Produtos> listarProdutoEstoque() {
        Connection conexao = ModuloDeConexao.conector();

        List<Produtos> produtos = new ArrayList<>();

        String sql = "SELECT Produtos.Cod_Produtos, Produtos.Nome_Produtos, Produtos.Id_Representadas,"
                + " Produtos.Qtde_Cx_Produtos, Produtos.Saldo_Produtos from Produtos;";

        try {
            //     conexao.setAutoCommit(false);
            PreparedStatement consultaSt = conexao.prepareStatement(sql);
            consultaSt.setFetchSize(200);
            ResultSet resultado = consultaSt.executeQuery();
            while (resultado.next()) {
                Produtos produto = new Produtos();
                produto.setCod_Produtos(resultado.getString("Cod_Produtos"));
                produto.setNome_Produtos(resultado.getString("Nome_Produtos"));
                produto.setQtde_Cx_Produtos(resultado.getString("Qtde_Cx_Produtos"));
                produto.setSaldo_Produtos(resultado.getString("Saldo_Produtos"));
                produto.setId_Representadas(resultado.getString("Id_Representadas"));
                produtos.add(produto);
            }

            consultaSt.close();
            resultado.close();

        } catch (SQLException e) {
            return null;
        } finally {
            try {

                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de atualização de produtos. Mensagem:" + e.getMessage());
            }
        }
        return produtos;
    }

}
