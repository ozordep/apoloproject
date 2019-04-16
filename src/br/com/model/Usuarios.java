package br.com.model;

public class Usuarios {

private int Id_Usuarios;
private String Nome_Usuarios;
private String Senha_Usuarios;
private String Conf_Senha_Usuarios;

    public Usuarios() {
    }

    public Usuarios(int Id_Usuarios, String Nome_Usuarios, String Senha_Usuarios) {
        this.Id_Usuarios = Id_Usuarios;
        this.Nome_Usuarios = Nome_Usuarios;
        this.Senha_Usuarios = Senha_Usuarios;
    }

    public Usuarios(String Nome_Usuarios, String Senha_Usuarios) {
        this.Nome_Usuarios = Nome_Usuarios;
        this.Senha_Usuarios = Senha_Usuarios;
    }

    public int getId_Usuarios() {
        return Id_Usuarios;
    }

    public String getConf_Senha_Usuarios() {
        return Conf_Senha_Usuarios;
    }

    public void setConf_Senha_Usuarios(String Conf_Senha_Usuarios) {
        this.Conf_Senha_Usuarios = Conf_Senha_Usuarios;
    }

    public void setId_Usuarios(int Id_Usuarios) {
        this.Id_Usuarios = Id_Usuarios;
    }

    public String getNome_Usuarios() {
        return Nome_Usuarios;
    }

    public void setNome_Usuarios(String Nome_Usuarios) {
        this.Nome_Usuarios = Nome_Usuarios;
    }

    public String getSenha_Usuarios() {
        return Senha_Usuarios;
    }

    public void setSenha_Usuarios(String Senha_Usuarios) {
        this.Senha_Usuarios = Senha_Usuarios;
    }

    public void mostrarUsuarios(){
        System.out.println("ID: " + getId_Usuarios());
        System.out.println("Nome: " + getNome_Usuarios());
        System.out.println("Senha: " + getSenha_Usuarios());
    }
    
}
