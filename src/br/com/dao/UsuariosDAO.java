package br.com.dao;

import br.com.jdbc.ModuloDeConexao;
import br.com.model.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDAO {

public static boolean cadastrarUsuario(Usuarios usuarios) {
        Connection conexao = ModuloDeConexao.conector();
        PreparedStatement cadastraSt = null;

        String sql = "insert into Usuarios(Nome_Usuarios, Senha_Usuarios) values (?,?);";
        
        try {
           
            cadastraSt = conexao.prepareStatement(sql);
            cadastraSt.setString(1, usuarios.getNome_Usuarios());
            cadastraSt.setString(2, usuarios.getSenha_Usuarios());
            cadastraSt.executeUpdate();

            System.out.println("Usuário cadastrado com sucesso!");
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar usuário. Mensagem:" + e.getMessage());
            return false;
        } finally {
            try {
                cadastraSt.close();
                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de cadastro de usuários. Mensagem:" + e.getMessage());
            }
        }
    }
    
    public static void deletarUsuario(Usuarios usuarios){
        Connection conexao = ModuloDeConexao.conector();
        PreparedStatement excluiSt = null;
        
        String sql = "Delete from Usuarios where Id_Usuarios=?;";
        
        try {
            excluiSt = conexao.prepareStatement(sql);
            excluiSt.setInt(1, usuarios.getId_Usuarios());
            excluiSt.executeUpdate();
            
            System.out.println("Usuário deletado com sucesso!");
            
        } catch (SQLException e) {
            System.out.println("Erro ao deletar usuário. Mensagem:" + e.getMessage());
        } finally {
            try {
                excluiSt.close();
                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de exclusão de usuários. Mensagem:" + e.getMessage());
            }
        }
    }
    
    public static void atualizarUsuario(Usuarios usuarios){
        Connection conexao = ModuloDeConexao.conector();
        PreparedStatement atualizaSt = null;
        
        String sql = "Update Usuarios set Nome_Usuarios=?, Senha_Usuarios=? where Id_Usuarios=?;";
        
        try {
            atualizaSt = conexao.prepareStatement(sql);
            atualizaSt.setString(1, usuarios.getNome_Usuarios());
            atualizaSt.setString(2, usuarios.getSenha_Usuarios());
            atualizaSt.setInt(3, usuarios.getId_Usuarios());
            atualizaSt.executeUpdate();

            System.out.println("Usuário atualizado com sucesso!");
            
        } catch (Exception e) {
        } finally {
            try {
                atualizaSt.close();
                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de atualização de usuários. Mensagem:" + e.getMessage());
            }
        }
    }
    
    public static List<Usuarios> listarUsuario(){
        Connection conexao = ModuloDeConexao.conector();
        List<Usuarios> usuarios = new ArrayList<>();
        
        String sql = "Select * from Usuarios;";
        
        try {
            PreparedStatement consultaSt = conexao.prepareStatement(sql);
            ResultSet resultado = consultaSt.executeQuery();
            while(resultado.next()){
                Usuarios usuario = new Usuarios();
                usuario.setId_Usuarios(resultado.getInt("Id_Usuarios"));
                usuario.setNome_Usuarios(resultado.getString("Nome_Usuarios"));
                usuario.setSenha_Usuarios(resultado.getString("Senha_Usuarios"));
                usuarios.add(usuario);
            }
            
            consultaSt.close();
            resultado.close();
            
        } catch (SQLException e) {
            return null;
        } finally {
            try {
                
                conexao.close();
            } catch (Throwable e) {
                System.out.println("Erro ao fechar operação de atualização de usuários. Mensagem:" + e.getMessage());
            }
        }
        return usuarios;
    }

    
}