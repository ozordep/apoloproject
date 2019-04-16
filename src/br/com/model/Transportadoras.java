package br.com.model;

public class Transportadoras {

private String Id_Transportadoras;
private String Nome_Transportadoras;
private String DDD1_Transportadoras, Tel1_Transportadoras;
private String DDD2_Transportadoras, Tel2_Transportadoras;

    public Transportadoras() {
    }

    public Transportadoras(String Id_Transportadoras, String Nome_Transportadoras, String DDD1_Transportadoras, String Tel1_Transportadoras, String DDD2_Transportadoras, String Tel2_Transportadoras) {
        this.Id_Transportadoras = Id_Transportadoras;
        this.Nome_Transportadoras = Nome_Transportadoras;
        this.DDD1_Transportadoras = DDD1_Transportadoras;
        this.Tel1_Transportadoras = Tel1_Transportadoras;
        this.DDD2_Transportadoras = DDD2_Transportadoras;
        this.Tel2_Transportadoras = Tel2_Transportadoras;
    }

    public Transportadoras(String Nome_Transportadoras, String DDD1_Transportadoras, String Tel1_Transportadoras, String DDD2_Transportadoras, String Tel2_Transportadoras) {
        this.Nome_Transportadoras = Nome_Transportadoras;
        this.DDD1_Transportadoras = DDD1_Transportadoras;
        this.Tel1_Transportadoras = Tel1_Transportadoras;
        this.DDD2_Transportadoras = DDD2_Transportadoras;
        this.Tel2_Transportadoras = Tel2_Transportadoras;
    }
    
    

    public String getId_Transportadoras() {
        return Id_Transportadoras;
    }

    public void setId_Transportadoras(String Id_Transportadoras) {
        this.Id_Transportadoras = Id_Transportadoras;
    }

    public String getNome_Transportadoras() {
        return Nome_Transportadoras;
    }

    public void setNome_Transportadoras(String Nome_Transportadoras) {
        this.Nome_Transportadoras = Nome_Transportadoras;
    }

    public String getDDD1_Transportadoras() {
        return DDD1_Transportadoras;
    }

    public void setDDD1_Transportadoras(String DDD1_Transportadoras) {
        this.DDD1_Transportadoras = DDD1_Transportadoras;
    }

    public String getTel1_Transportadoras() {
        return Tel1_Transportadoras;
    }

    public void setTel1_Transportadoras(String Tel1_Transportadoras) {
        this.Tel1_Transportadoras = Tel1_Transportadoras;
    }

    public String getDDD2_Transportadoras() {
        return DDD2_Transportadoras;
    }

    public void setDDD2_Transportadoras(String DDD2_Transportadoras) {
        this.DDD2_Transportadoras = DDD2_Transportadoras;
    }

    public String getTel2_Transportadoras() {
        return Tel2_Transportadoras;
    }

    public void setTel2_Transportadoras(String Tel2_Transportadoras) {
        this.Tel2_Transportadoras = Tel2_Transportadoras;
    }

    public void mostrarTransportadoras(){
        System.out.println("ID: " + getId_Transportadoras());
        System.out.println("Nome: " + getNome_Transportadoras());
        System.out.println("DDD: " + getDDD1_Transportadoras());
        System.out.println("Telefone: " + getTel1_Transportadoras());
        System.out.println("DDD: " + getDDD2_Transportadoras());
        System.out.println("Telefone: " + getTel2_Transportadoras());
    }

    
}
