package br.com.model;

public class CondPagamentos {

    private String Id_CondPgtos;
    private String Nome_CondPgtos;

    public CondPagamentos() {
    }

    public CondPagamentos(String Id_CondPgtos, String Nome_CondPgtos) {
        this.Id_CondPgtos = Id_CondPgtos;
        this.Nome_CondPgtos = Nome_CondPgtos;
    }

    public CondPagamentos(String Nome_CondPgtos) {
        this.Nome_CondPgtos = Nome_CondPgtos;
    }

    public String getId_CondPgtos() {
        return Id_CondPgtos;
    }

    public void setId_CondPgtos(String Id_CondPgtos) {
        this.Id_CondPgtos = Id_CondPgtos;
    }

    public String getNome_CondPgtos() {
        return Nome_CondPgtos;
    }

    public void setNome_CondPgtos(String Nome_CondPgtos) {
        this.Nome_CondPgtos = Nome_CondPgtos;
    }

    @Override
    public String toString() {
        return getNome_CondPgtos();
    }

}
