package br.com.model;

public class Representadas {

String Id_Representadas;
String Nome_Representadas;
String DDD_Representadas;
String Telefone_Representadas;

    public Representadas() {
    }

    public Representadas(String Id_Representadas, String Nome_Representadas, String DDD_Representadas, String Telefone_Representadas) {
        this.Id_Representadas = Id_Representadas;
        this.Nome_Representadas = Nome_Representadas;
        this.DDD_Representadas = DDD_Representadas;
        this.Telefone_Representadas = Telefone_Representadas;
    }

    public Representadas(String Nome_Representadas, String DDD_Representadas, String Telefone_Representadas) {
        this.Nome_Representadas = Nome_Representadas;
        this.DDD_Representadas = DDD_Representadas;
        this.Telefone_Representadas = Telefone_Representadas;
    }

    public String getId_Representadas() {
        return Id_Representadas;
    }

    public void setId_Representadas(String Id_Representadas) {
        this.Id_Representadas = Id_Representadas;
    }

    public String getNome_Representadas() {
        return Nome_Representadas;
    }

    public void setNome_Representadas(String Nome_Representadas) {
        this.Nome_Representadas = Nome_Representadas;
    }

    public String getDDD_Representadas() {
        return DDD_Representadas;
    }

    public void setDDD_Representadas(String DDD_Representadas) {
        this.DDD_Representadas = DDD_Representadas;
    }
    
    public String getTelefone_Representadas() {
        return Telefone_Representadas;
    }

    public void setTelefone_Representadas(String Telefone_Representadas) {
        this.Telefone_Representadas = Telefone_Representadas;
    }

    @Override
    public String toString() {
        return getNome_Representadas();
    }

    

public void mostrarRepresentadas(){
        System.out.println("ID: " + getId_Representadas());
        System.out.println("Nome: " + getNome_Representadas());
        System.out.println("DDD: " + getDDD_Representadas());
        System.out.println("Telefone: " + getTelefone_Representadas());
    }
    
}
