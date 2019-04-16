package br.com.model;

public class ClientesGrupos {

    private String Id_Grupos, Id_Clientes;
    
    public ClientesGrupos() {
    }

    public ClientesGrupos(String Id_Grupos, String Id_Clientes) {
        this.Id_Grupos = Id_Grupos;
        this.Id_Clientes = Id_Clientes;
    }

    public String getId_Grupos() {
        return Id_Grupos;
    }

    public void setId_Grupos(String Id_Grupos) {
        this.Id_Grupos = Id_Grupos;
    }

    public String getId_Clientes() {
        return Id_Clientes;
    }

    public void setId_Clientes(String Id_Clientes) {
        this.Id_Clientes = Id_Clientes;
    }
    
    
    
}
