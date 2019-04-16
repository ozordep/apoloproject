package br.com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ModuloDeConexao {

    public static Connection conector() {

        java.sql.Connection conexao = null;
        String driver = "com.mysql.jdbc.Driver"; // destinada a carregar a biblioteca do java
        String url = "jdbc:mysql://207.246.118.218:3306/apolodb";
        String user = "apolouser";
        String password = "ApoloApolo";
        /*String url = "jdbc:mysql://localhost:3306/apoloDB";
        String user = "root";
        String password = "";*/

        try {
            Class.forName(driver); //executa o Driver sql
            conexao = DriverManager.getConnection(url, user, password); //receber como retorno o gerenciamento da execução do driver com os parametros informados

            return conexao;
        } catch (Exception e) {
            return null;
        }
    }

}
