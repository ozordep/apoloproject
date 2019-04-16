package br.com.dao;

import br.com.jdbc.ModuloDeConexao;
import br.com.model.Grupos;
import br.com.model.Produtos;
import br.com.model.Representadas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GruposDAO {

    public static boolean cadastrarGrupo(Grupos grupos) {
        Connection conexao = ModuloDeConexao.conector();
        PreparedStatement cadastraSt = null;

        String sql = "insert into Grupos(Id_Representadas,Nome_Grupos) values (?,?);";

        try {

            cadastraSt = conexao.prepareStatement(sql);
            cadastraSt.setString(1, grupos.getId_Representadas());
            cadastraSt.setString(2, grupos.getNome_Grupos());
            cadastraSt.executeUpdate();

            System.out.println("Grupo cadastrado com sucesso!");
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar grupo. Mensagem:" + e.getMessage());
            return false;
        } finally {
            try {
                cadastraSt.close();
                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de cadastro de grupos. Mensagem:" + e.getMessage());
            }
        }
    }

    public static void deletarGrupo(Grupos grupos) {
        Connection conexao = ModuloDeConexao.conector();
        PreparedStatement excluiSt = null;

        String sql = "Delete from Grupos where Id_Grupos=?;";

        try {
            excluiSt = conexao.prepareStatement(sql);
            excluiSt.setString(1, grupos.getId_Grupos());
            excluiSt.executeUpdate();

            System.out.println("Grupo deletado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao deletar grupo. Mensagem:" + e.getMessage());
        } finally {
            try {
                excluiSt.close();
                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de exclusão de grupos. Mensagem:" + e.getMessage());
            }
        }
    }

    public static void atualizarGrupo(Grupos grupos) {
        Connection conexao = ModuloDeConexao.conector();
        PreparedStatement atualizaSt = null;

        String sql = "Update Grupos set Id_Representada=?, Nome_Grupos=? where Id_Grupos=?;";

        try {
            atualizaSt = conexao.prepareStatement(sql);
            atualizaSt.setString(1, grupos.getId_Representadas());
            atualizaSt.setString(2, grupos.getNome_Grupos());
            atualizaSt.executeUpdate();

            System.out.println("Grupo atualizado com sucesso!");

        } catch (Exception e) {
        } finally {
            try {
                atualizaSt.close();
                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de atualização de grupos. Mensagem:" + e.getMessage());
            }
        }
    }

    public static List<Grupos> listarGrupo() {
        Connection conexao = ModuloDeConexao.conector();
        List<Grupos> grupos = new ArrayList<>();

        String sql = "Select * from Grupos;";

        try {
            PreparedStatement consultaSt = conexao.prepareStatement(sql);
            ResultSet resultado = consultaSt.executeQuery();
            while (resultado.next()) {
                Grupos grupo = new Grupos();
                grupo.setId_Grupos(resultado.getString("Id_Grupos"));
                grupo.setNome_Grupos(resultado.getString("Nome_Grupos"));
                grupos.add(grupo);
            }

            consultaSt.close();
            resultado.close();

        } catch (SQLException e) {
            return null;
        } finally {
            try {

                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de atualização de grupos. Mensagem:" + e.getMessage());
            }
        }
        return grupos;
    }

    public static List<Grupos> listarGrupoComboBox() {
        Connection conexao = ModuloDeConexao.conector();
        List<Grupos> grupos = new ArrayList<>();

        String sql = "Select Id_Grupos, Nome_Grupos from Grupos;";

        try {
            PreparedStatement consultaSt = conexao.prepareStatement(sql);
            ResultSet resultado = consultaSt.executeQuery();
            while (resultado.next()) {
                Grupos grupo = new Grupos();
                grupo.setId_Grupos(resultado.getString("Id_Grupos"));
                grupo.setNome_Grupos(resultado.getString("Nome_Grupos"));
                grupos.add(grupo);
            }

            consultaSt.close();
            resultado.close();

        } catch (SQLException e) {
            return null;
        } finally {
            try {

                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de atualização de grupos no combobox. Mensagem:" + e.getMessage());
            }
        }
        return grupos;
    }

    public static List<Grupos> listarGrupoRepresentada(String representada) {
        Connection conexao = ModuloDeConexao.conector();
        ArrayList<Grupos> grupos = new ArrayList<>();

        String sql = "select * from Grupos where Id_Representadas=?;";

        try {
            PreparedStatement consultaSt = conexao.prepareStatement(sql);
            consultaSt.setInt(1, Integer.parseInt(representada));
            ResultSet resultado = consultaSt.executeQuery();
            while (resultado.next()) {
                Grupos grupo = new Grupos();
                grupo.setId_Grupos(resultado.getString("Id_Grupos"));
                grupo.setNome_Grupos(resultado.getString("Nome_Grupos"));
                grupos.add(grupo);
            }

            consultaSt.close();
            resultado.close();

        } catch (SQLException e) {
            return null;
        } finally {
            try {

                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de atualização de grupos no combobox do cadastro de produtos. Mensagem:" + e.getMessage());
            }
        }
        return grupos;
    }

    public static List<Grupos> listarGrupoCliente(String cliente) {
        Connection conexao = ModuloDeConexao.conector();
        ArrayList<Grupos> grupos = new ArrayList<>();

//        String sql = "SELECT * FROM `Clientes_Grupos` WHERE Id_Clientes=?;";
        String sql = "Select Grupos.Id_Grupos, Grupos.Nome_Grupos from Grupos join Clientes_Grupos where Grupos.Id_Grupos = Clientes_Grupos.Id_Grupos and "
                + "Clientes_Grupos.Id_Clientes =?;";

        try {
//            conexao.setAutoCommit(false);
            PreparedStatement consultaSt = conexao.prepareStatement(sql);
            consultaSt.setFetchSize(200);
            consultaSt.setInt(1, Integer.parseInt(cliente));
            ResultSet resultado = consultaSt.executeQuery();
            resultado.setFetchSize(100);
            while (resultado.next()) {
                Grupos grupo = new Grupos();
                grupo.setId_Grupos(resultado.getString("Id_Grupos"));
                grupo.setNome_Grupos(resultado.getString("Nome_Grupos"));
                grupos.add(grupo);
            }

            consultaSt.close();
            resultado.close();

        } catch (SQLException e) {
            return null;
        } finally {
            try {

                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de atualização de grupos na listagem de grupos cadastrados no cliente. Mensagem:" + e.getMessage());
            }
        }
        return grupos;
    }

}
