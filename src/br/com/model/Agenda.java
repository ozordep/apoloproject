package br.com.model;

public class Agenda {

    private String Id_Agenda;
    private String Data_Ini_Agenda, Data_Fim_Agenda;
    private String Data_Agenda, Hora_Agenda, Obs_Agenda, Id_Contato, Id_Grupo, Follow_Up_Agenda, Id_Vendedor;

    public Agenda() {
    }

    public Agenda(String Id_Agenda, String Data_Ini_Agenda, String Data_Fim_Agenda, String Data_Agenda, String Hora_Agenda, String Obs_Agenda, String Id_Contato, String Id_Grupo, String Follow_Up_Agenda, String Id_Vendedor) {
        this.Id_Agenda = Id_Agenda;
        this.Data_Ini_Agenda = Data_Ini_Agenda;
        this.Data_Fim_Agenda = Data_Fim_Agenda;
        this.Data_Agenda = Data_Agenda;
        this.Hora_Agenda = Hora_Agenda;
        this.Obs_Agenda = Obs_Agenda;
        this.Id_Contato = Id_Contato;
        this.Id_Grupo = Id_Grupo;
        this.Follow_Up_Agenda = Follow_Up_Agenda;
        this.Id_Vendedor = Id_Vendedor;
    }

    public String getId_Agenda() {
        return Id_Agenda;
    }

    public void setId_Agenda(String Id_Agenda) {
        this.Id_Agenda = Id_Agenda;
    }

    public String getData_Ini_Agenda() {
        return Data_Ini_Agenda;
    }

    public void setData_Ini_Agenda(String Data_Ini_Agenda) {
        this.Data_Ini_Agenda = Data_Ini_Agenda;
    }

    public String getData_Fim_Agenda() {
        return Data_Fim_Agenda;
    }

    public void setData_Fim_Agenda(String Data_Fim_Agenda) {
        this.Data_Fim_Agenda = Data_Fim_Agenda;
    }

    @Override
    public String toString() {
        return Id_Agenda;
    }

    public String getData_Agenda() {
        return Data_Agenda;
    }

    public void setData_Agenda(String Data_Agenda) {
        this.Data_Agenda = Data_Agenda;
    }

    public String getHora_Agenda() {
        return Hora_Agenda;
    }

    public void setHora_Agenda(String Hora_Agenda) {
        this.Hora_Agenda = Hora_Agenda;
    }

    public String getObs_Agenda() {
        return Obs_Agenda;
    }

    public void setObs_Agenda(String Obs_Agenda) {
        this.Obs_Agenda = Obs_Agenda;
    }

    public String getId_Contato() {
        return Id_Contato;
    }

    public void setId_Contato(String Id_Contato) {
        this.Id_Contato = Id_Contato;
    }

    public String getId_Grupo() {
        return Id_Grupo;
    }

    public void setId_Grupo(String Id_Grupo) {
        this.Id_Grupo = Id_Grupo;
    }

    public String getFollow_Up_Agenda() {
        return Follow_Up_Agenda;
    }

    public void setFollow_Up_Agenda(String Follow_Up_Agenda) {
        this.Follow_Up_Agenda = Follow_Up_Agenda;
    }

    public String getId_Vendedor() {
        return Id_Vendedor;
    }

    public void setId_Vendedor(String Id_Vendedor) {
        this.Id_Vendedor = Id_Vendedor;
    }

}
