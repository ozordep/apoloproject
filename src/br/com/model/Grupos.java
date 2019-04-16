package br.com.model;

public class Grupos {

    private String Id_Grupos, Id_Clientes;
    private String Id_Representadas;
    private String Nome_Grupos;

    public Grupos() {
    }

    public Grupos(String Id_Grupos, String Id_Representadas, String Nome_Grupos) {
        this.Id_Grupos = Id_Grupos;
        this.Id_Representadas = Id_Representadas;
        this.Nome_Grupos = Nome_Grupos;
    }

    public Grupos(String Id_Representadas, String Nome_Grupos) {
        this.Id_Representadas = Id_Representadas;
        this.Nome_Grupos = Nome_Grupos;
    }

    public String getId_Grupos() {
        return Id_Grupos;
    }

    public void setId_Grupos(String Id_Grupos) {
        this.Id_Grupos = Id_Grupos;
    }

    public String getId_Representadas() {
        return Id_Representadas;
    }

    public void setId_Representadas(String Id_Representadas) {
        this.Id_Representadas = Id_Representadas;
    }

    public String getNome_Grupos() {
        return Nome_Grupos;
    }

    public void setNome_Grupos(String Nome_Grupos) {
        this.Nome_Grupos = Nome_Grupos;
    }

    @Override
    public String toString() {
        return getNome_Grupos();
    }

    
    
    
}
