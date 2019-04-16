package br.com.model;

public class Pedidos {

    private String Id_Pedidos;
    private String Logo_Rep_Pedidos;
    private String Data_Pedidos;
    private String Vendedor_Pedidos;
    private String Ordem_Compra_Pedidos;
    private String Obs_Pedidos;

    public Pedidos() {
    }

    public Pedidos(String Id_Pedidos, String Logo_Rep_Pedidos, String Data_Pedidos, String Vendedor_Pedidos, String Ordem_Compra_Pedidos, String Obs_Pedidos) {
        this.Id_Pedidos = Id_Pedidos;
        this.Logo_Rep_Pedidos = Logo_Rep_Pedidos;
        this.Data_Pedidos = Data_Pedidos;
        this.Vendedor_Pedidos = Vendedor_Pedidos;
        this.Ordem_Compra_Pedidos = Ordem_Compra_Pedidos;
        this.Obs_Pedidos = Obs_Pedidos;
    }

    public Pedidos(String Logo_Rep_Pedidos, String Data_Pedidos, String Vendedor_Pedidos, String Ordem_Compra_Pedidos, String Obs_Pedidos) {
        this.Logo_Rep_Pedidos = Logo_Rep_Pedidos;
        this.Data_Pedidos = Data_Pedidos;
        this.Vendedor_Pedidos = Vendedor_Pedidos;
        this.Ordem_Compra_Pedidos = Ordem_Compra_Pedidos;
        this.Obs_Pedidos = Obs_Pedidos;
    }

    public String getId_Pedidos() {
        return Id_Pedidos;
    }

    public void setId_Pedidos(String Id_Pedidos) {
        this.Id_Pedidos = Id_Pedidos;
    }

    public String getLogo_Rep_Pedidos() {
        return Logo_Rep_Pedidos;
    }

    public void setLogo_Rep_Pedidos(String Logo_Rep_Pedidos) {
        this.Logo_Rep_Pedidos = Logo_Rep_Pedidos;
    }

    public String getData_Pedidos() {
        return Data_Pedidos;
    }

    public void setData_Pedidos(String Data_Pedidos) {
        this.Data_Pedidos = Data_Pedidos;
    }

    public String getVendedor_Pedidos() {
        return Vendedor_Pedidos;
    }

    public void setVendedor_Pedidos(String Vendedor_Pedidos) {
        this.Vendedor_Pedidos = Vendedor_Pedidos;
    }

    public String getOrdem_Compra_Pedidos() {
        return Ordem_Compra_Pedidos;
    }

    public void setOrdem_Compra_Pedidos(String Ordem_Compra_Pedidos) {
        this.Ordem_Compra_Pedidos = Ordem_Compra_Pedidos;
    }

    public String getObs_Pedidos() {
        return Obs_Pedidos;
    }

    public void setObs_Pedidos(String Obs_Pedidos) {
        this.Obs_Pedidos = Obs_Pedidos;
    }

}
