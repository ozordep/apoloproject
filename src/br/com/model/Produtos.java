package br.com.model;

public class Produtos {

    private int Id_Produtos;
    private String Id_Representadas, Id_Grupos;
    private String Cod_Produtos;
    private String Nome_Produtos;
    private String Un_Produtos;
    private String Qtde_Cx_Produtos;
    private String Saldo_Produtos;
    private String Preco_Cliente_Produtos;
    private String Preco_Revendedor_Produtos;
    private String Icms_Produtos;
    private String Ipi_Produtos;

    public Produtos() {
    }

    public Produtos(int Id_Produtos, String Id_Representadas, String Id_Grupos, String Cod_Produtos, String Nome_Produtos, String Un_Produtos, String Qtde_Cx_Produtos, String Saldo_Produtos, String Preco_Cliente_Produtos, String Preco_Revendedor_Produtos, String Icms_Produtos, String Ipi_Produtos) {
        this.Id_Produtos = Id_Produtos;
        this.Id_Representadas = Id_Representadas;
        this.Id_Grupos = Id_Grupos;
        this.Cod_Produtos = Cod_Produtos;
        this.Nome_Produtos = Nome_Produtos;
        this.Un_Produtos = Un_Produtos;
        this.Qtde_Cx_Produtos = Qtde_Cx_Produtos;
        this.Saldo_Produtos = Saldo_Produtos;
        this.Preco_Cliente_Produtos = Preco_Cliente_Produtos;
        this.Preco_Revendedor_Produtos = Preco_Revendedor_Produtos;
        this.Icms_Produtos = Icms_Produtos;
        this.Ipi_Produtos = Ipi_Produtos;
    }

    public Produtos(String Cod_Produtos, String Nome_Produtos, String Un_Produtos, String Qtde_Cx_Produtos, String Saldo_Produtos, String Preco_Cliente_Produtos, String Preco_Revendedor_Produtos, String Icms_Produtos, String Ipi_Produtos) {
        this.Cod_Produtos = Cod_Produtos;
        this.Nome_Produtos = Nome_Produtos;
        this.Un_Produtos = Un_Produtos;
        this.Qtde_Cx_Produtos = Qtde_Cx_Produtos;
        this.Saldo_Produtos = Saldo_Produtos;
        this.Preco_Cliente_Produtos = Preco_Cliente_Produtos;
        this.Preco_Revendedor_Produtos = Preco_Revendedor_Produtos;
        this.Icms_Produtos = Icms_Produtos;
        this.Ipi_Produtos = Ipi_Produtos;
    }

    public Produtos(String Id_Representadas, String Id_Grupos, String Cod_Produtos, String Nome_Produtos, String Un_Produtos, String Qtde_Cx_Produtos, String Saldo_Produtos, String Preco_Cliente_Produtos, String Preco_Revendedor_Produtos, String Icms_Produtos, String Ipi_Produtos) {
        this.Id_Representadas = Id_Representadas;
        this.Id_Grupos = Id_Grupos;
        this.Cod_Produtos = Cod_Produtos;
        this.Nome_Produtos = Nome_Produtos;
        this.Un_Produtos = Un_Produtos;
        this.Qtde_Cx_Produtos = Qtde_Cx_Produtos;
        this.Saldo_Produtos = Saldo_Produtos;
        this.Preco_Cliente_Produtos = Preco_Cliente_Produtos;
        this.Preco_Revendedor_Produtos = Preco_Revendedor_Produtos;
        this.Icms_Produtos = Icms_Produtos;
        this.Ipi_Produtos = Ipi_Produtos;
    }

    public int getId_Produtos() {
        return Id_Produtos;
    }

    public void setId_Produtos(int Id_Produtos) {
        this.Id_Produtos = Id_Produtos;
    }

    public String getNome_Produtos() {
        return Nome_Produtos;
    }

    public void setNome_Produtos(String Nome_Produtos) {
        this.Nome_Produtos = Nome_Produtos;
    }

    public String getUn_Produtos() {
        return Un_Produtos;
    }

    public void setUn_Produtos(String Un_Produtos) {
        this.Un_Produtos = Un_Produtos;
    }

    public String getQtde_Cx_Produtos() {
        return Qtde_Cx_Produtos;
    }

    public void setQtde_Cx_Produtos(String Qtde_Cx_Produtos) {
        this.Qtde_Cx_Produtos = Qtde_Cx_Produtos;
    }

    public String getSaldo_Produtos() {
        return Saldo_Produtos;
    }

    public void setSaldo_Produtos(String Saldo_Produtos) {
        this.Saldo_Produtos = Saldo_Produtos;
    }

    public String getPreco_Cliente_Produtos() {
        return Preco_Cliente_Produtos;
    }

    public void setPreco_Cliente_Produtos(String Preco_Cliente_Produtos) {
        this.Preco_Cliente_Produtos = Preco_Cliente_Produtos;
    }

    public String getPreco_Revendedor_Produtos() {
        return Preco_Revendedor_Produtos;
    }

    public void setPreco_Revendedor_Produtos(String Preco_Revendedor_Produtos) {
        this.Preco_Revendedor_Produtos = Preco_Revendedor_Produtos;
    }

    public String getIcms_Produtos() {
        return Icms_Produtos;
    }

    public void setIcms_Produtos(String Icms_Produtos) {
        this.Icms_Produtos = Icms_Produtos;
    }

    public String getIpi_Produtos() {
        return Ipi_Produtos;
    }

    public void setIpi_Produtos(String Ipi_Produtos) {
        this.Ipi_Produtos = Ipi_Produtos;
    }

    public String getCod_Produtos() {
        return Cod_Produtos;
    }

    public void setCod_Produtos(String Cod_Produtos) {
        this.Cod_Produtos = Cod_Produtos;
    }

    public String getId_Representadas() {
        return Id_Representadas;
    }

    public void setId_Representadas(String Id_Representadas) {
        this.Id_Representadas = Id_Representadas;
    }

    public String getId_Grupos() {
        return Id_Grupos;
    }

    public void setId_Grupos(String Id_Grupos) {
        this.Id_Grupos = Id_Grupos;
    }  
    

}
