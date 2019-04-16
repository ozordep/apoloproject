package br.com.model;

public class Clientes {

    private String Id_Clientes;
    private String RazaoSocial_Clientes, NomeFantasia_Clientes, DDD_Clientes, Telefone_Clientes, Fax_Clientes, Contatos_Clientes, Cnpj_Clientes, Ie_Clientes, Email_Clientes;
    private String EndFat_Clientes, PaisFat_Clientes, BairroFat_Clientes, CidadeFat_Clientes, UfFat_Clientes, CepFat_Clientes;
    private String EndEnt_Clientes, PaisEnt_Clientes, BairroEnt_Clientes, CidadeEnt_Clientes, UfEnt_Clientes, CepEnt_Clientes;
    private String EndCob_Clientes, PaisCob_Clientes, BairroCob_Clientes, CidadeCob_Clientes, UfCob_Clientes, CepCob_Clientes;

    public Clientes() {
    }

    public Clientes(String RazaoSocial_Clientes, String NomeFantasia_Clientes, String DDD_Clientes, String Telefone_Clientes, String Fax_Clientes, String Contatos_Clientes, String Cnpj_Clientes, String Ie_Clientes, String Email_Clientes, String EndFat_Clientes, String PaisFat_Clientes, String BairroFat_Clientes, String CidadeFat_Clientes, String UfFat_Clientes, String CepFat_Clientes, String EndEnt_Clientes, String PaisEnt_Clientes, String BairroEnt_Clientes, String CidadeEnt_Clientes, String UfEnt_Clientes, String CepEnt_Clientes, String EndCob_Clientes, String PaisCob_Clientes, String BairroCob_Clientes, String CidadeCob_Clientes, String UfCob_Clientes, String CepCob_Clientes) {
        this.RazaoSocial_Clientes = RazaoSocial_Clientes;
        this.NomeFantasia_Clientes = NomeFantasia_Clientes;
        this.DDD_Clientes = DDD_Clientes;
        this.Telefone_Clientes = Telefone_Clientes;
        this.Fax_Clientes = Fax_Clientes;
        this.Contatos_Clientes = Contatos_Clientes;
        this.Cnpj_Clientes = Cnpj_Clientes;
        this.Ie_Clientes = Ie_Clientes;
        this.Email_Clientes = Email_Clientes;
        this.EndFat_Clientes = EndFat_Clientes;
        this.PaisFat_Clientes = PaisFat_Clientes;
        this.BairroFat_Clientes = BairroFat_Clientes;
        this.CidadeFat_Clientes = CidadeFat_Clientes;
        this.UfFat_Clientes = UfFat_Clientes;
        this.CepFat_Clientes = CepFat_Clientes;
        this.EndEnt_Clientes = EndEnt_Clientes;
        this.PaisEnt_Clientes = PaisEnt_Clientes;
        this.BairroEnt_Clientes = BairroEnt_Clientes;
        this.CidadeEnt_Clientes = CidadeEnt_Clientes;
        this.UfEnt_Clientes = UfEnt_Clientes;
        this.CepEnt_Clientes = CepEnt_Clientes;
        this.EndCob_Clientes = EndCob_Clientes;
        this.PaisCob_Clientes = PaisCob_Clientes;
        this.BairroCob_Clientes = BairroCob_Clientes;
        this.CidadeCob_Clientes = CidadeCob_Clientes;
        this.UfCob_Clientes = UfCob_Clientes;
        this.CepCob_Clientes = CepCob_Clientes;
    }

    public Clientes(String Id_Clientes, String RazaoSocial_Clientes, String NomeFantasia_Clientes, String DDD_Clientes, String Telefone_Clientes, String Fax_Clientes, String Contatos_Clientes, String Cnpj_Clientes, String Ie_Clientes, String Email_Clientes, String EndFat_Clientes, String PaisFat_Clientes, String BairroFat_Clientes, String CidadeFat_Clientes, String UfFat_Clientes, String CepFat_Clientes, String EndEnt_Clientes, String PaisEnt_Clientes, String BairroEnt_Clientes, String CidadeEnt_Clientes, String UfEnt_Clientes, String CepEnt_Clientes, String EndCob_Clientes, String PaisCob_Clientes, String BairroCob_Clientes, String CidadeCob_Clientes, String UfCob_Clientes, String CepCob_Clientes) {
        this.Id_Clientes = Id_Clientes;
        this.RazaoSocial_Clientes = RazaoSocial_Clientes;
        this.NomeFantasia_Clientes = NomeFantasia_Clientes;
        this.DDD_Clientes = DDD_Clientes;
        this.Telefone_Clientes = Telefone_Clientes;
        this.Fax_Clientes = Fax_Clientes;
        this.Contatos_Clientes = Contatos_Clientes;
        this.Cnpj_Clientes = Cnpj_Clientes;
        this.Ie_Clientes = Ie_Clientes;
        this.Email_Clientes = Email_Clientes;
        this.EndFat_Clientes = EndFat_Clientes;
        this.PaisFat_Clientes = PaisFat_Clientes;
        this.BairroFat_Clientes = BairroFat_Clientes;
        this.CidadeFat_Clientes = CidadeFat_Clientes;
        this.UfFat_Clientes = UfFat_Clientes;
        this.CepFat_Clientes = CepFat_Clientes;
        this.EndEnt_Clientes = EndEnt_Clientes;
        this.PaisEnt_Clientes = PaisEnt_Clientes;
        this.BairroEnt_Clientes = BairroEnt_Clientes;
        this.CidadeEnt_Clientes = CidadeEnt_Clientes;
        this.UfEnt_Clientes = UfEnt_Clientes;
        this.CepEnt_Clientes = CepEnt_Clientes;
        this.EndCob_Clientes = EndCob_Clientes;
        this.PaisCob_Clientes = PaisCob_Clientes;
        this.BairroCob_Clientes = BairroCob_Clientes;
        this.CidadeCob_Clientes = CidadeCob_Clientes;
        this.UfCob_Clientes = UfCob_Clientes;
        this.CepCob_Clientes = CepCob_Clientes;
    }

    public void listarClientes() {
        System.out.println("ID: " + getId_Clientes());
        System.out.println("Nome: " + getRazaoSocial_Clientes());
        System.out.println("Cidade: " + getCidadeFat_Clientes());
        System.out.println("U.F.: " + getUfFat_Clientes());
        System.out.println("Telefone: " + getTelefone_Clientes());
    }

    public String getId_Clientes(Clientes clientes) {
//        System.out.println("ID 2: " + clientes.getId_Clientes());
        return clientes.Id_Clientes;
    }

    public String getId_Clientes() {
        return Id_Clientes;
    }

    public void setId_Clientes(String Id_Clientes) {
        this.Id_Clientes = Id_Clientes;
    }

    public String getDDD_Clientes() {
        return DDD_Clientes;
    }

    public void setDDD_Clientes(String DDD_Clientes) {
        this.DDD_Clientes = DDD_Clientes;
    }

    public String getTelefone_Clientes() {
        return Telefone_Clientes;
    }

    public void setTelefone_Clientes(String Telefone_Clientes) {
        this.Telefone_Clientes = Telefone_Clientes;
    }

    public String getFax_Clientes() {
        return Fax_Clientes;
    }

    public void setFax_Clientes(String Fax_Clientes) {
        this.Fax_Clientes = Fax_Clientes;
    }

    public String getRazaoSocial_Clientes() {
        return RazaoSocial_Clientes;
    }

    public void setRazaoSocial_Clientes(String RazaoSocial_Clientes) {
        this.RazaoSocial_Clientes = RazaoSocial_Clientes;
    }

    public String getNomeFantasia_Clientes() {
        return NomeFantasia_Clientes;
    }

    public void setNomeFantasia_Clientes(String NomeFantasia_Clientes) {
        this.NomeFantasia_Clientes = NomeFantasia_Clientes;
    }

    public String getContatos_Clientes() {
        return Contatos_Clientes;
    }

    public void setContatos_Clientes(String Contatos_Clientes) {
        this.Contatos_Clientes = Contatos_Clientes;
    }

    public String getCnpj_Clientes() {
        return Cnpj_Clientes;
    }

    public void setCnpj_Clientes(String Cnpj_Clientes) {
        this.Cnpj_Clientes = Cnpj_Clientes;
    }

    public String getIe_Clientes() {
        return Ie_Clientes;
    }

    public void setIe_Clientes(String Ie_Clientes) {
        this.Ie_Clientes = Ie_Clientes;
    }

    public String getEmail_Clientes() {
        return Email_Clientes;
    }

    public void setEmail_Clientes(String Email_Clientes) {
        this.Email_Clientes = Email_Clientes;
    }

    public String getEndFat_Clientes() {
        return EndFat_Clientes;
    }

    public void setEndFat_Clientes(String EndFat_Clientes) {
        this.EndFat_Clientes = EndFat_Clientes;
    }

    public String getPaisFat_Clientes() {
        return PaisFat_Clientes;
    }

    public void setPaisFat_Clientes(String PaisFat_Clientes) {
        this.PaisFat_Clientes = PaisFat_Clientes;
    }

    public String getBairroFat_Clientes() {
        return BairroFat_Clientes;
    }

    public void setBairroFat_Clientes(String BairroFat_Clientes) {
        this.BairroFat_Clientes = BairroFat_Clientes;
    }

    public String getCidadeFat_Clientes() {
        return CidadeFat_Clientes;
    }

    public void setCidadeFat_Clientes(String CidadeFat_Clientes) {
        this.CidadeFat_Clientes = CidadeFat_Clientes;
    }

    public String getUfFat_Clientes() {
        return UfFat_Clientes;
    }

    public void setUfFat_Clientes(String UfFat_Clientes) {
        this.UfFat_Clientes = UfFat_Clientes;
    }

    public String getCepFat_Clientes() {
        return CepFat_Clientes;
    }

    public void setCepFat_Clientes(String CepFat_Clientes) {
        this.CepFat_Clientes = CepFat_Clientes;
    }

    public String getEndEnt_Clientes() {
        return EndEnt_Clientes;
    }

    public void setEndEnt_Clientes(String EndEnt_Clientes) {
        this.EndEnt_Clientes = EndEnt_Clientes;
    }

    public String getPaisEnt_Clientes() {
        return PaisEnt_Clientes;
    }

    public void setPaisEnt_Clientes(String PaisEnt_Clientes) {
        this.PaisEnt_Clientes = PaisEnt_Clientes;
    }

    public String getBairroEnt_Clientes() {
        return BairroEnt_Clientes;
    }

    public void setBairroEnt_Clientes(String BairroEnt_Clientes) {
        this.BairroEnt_Clientes = BairroEnt_Clientes;
    }

    public String getCidadeEnt_Clientes() {
        return CidadeEnt_Clientes;
    }

    public void setCidadeEnt_Clientes(String CidadeEnt_Clientes) {
        this.CidadeEnt_Clientes = CidadeEnt_Clientes;
    }

    public String getUfEnt_Clientes() {
        return UfEnt_Clientes;
    }

    public void setUfEnt_Clientes(String UfEnt_Clientes) {
        this.UfEnt_Clientes = UfEnt_Clientes;
    }

    public String getCepEnt_Clientes() {
        return CepEnt_Clientes;
    }

    public void setCepEnt_Clientes(String CepEnt_Clientes) {
        this.CepEnt_Clientes = CepEnt_Clientes;
    }

    public String getEndCob_Clientes() {
        return EndCob_Clientes;
    }

    public void setEndCob_Clientes(String EndCob_Clientes) {
        this.EndCob_Clientes = EndCob_Clientes;
    }

    public String getPaisCob_Clientes() {
        return PaisCob_Clientes;
    }

    public void setPaisCob_Clientes(String PaisCob_Clientes) {
        this.PaisCob_Clientes = PaisCob_Clientes;
    }

    public String getBairroCob_Clientes() {
        return BairroCob_Clientes;
    }

    public void setBairroCob_Clientes(String BairroCob_Clientes) {
        this.BairroCob_Clientes = BairroCob_Clientes;
    }

    public String getCidadeCob_Clientes() {
        return CidadeCob_Clientes;
    }

    public void setCidadeCob_Clientes(String CidadeCob_Clientes) {
        this.CidadeCob_Clientes = CidadeCob_Clientes;
    }

    public String getUfCob_Clientes() {
        return UfCob_Clientes;
    }

    public void setUfCob_Clientes(String UfCob_Clientes) {
        this.UfCob_Clientes = UfCob_Clientes;
    }

    public String getCepCob_Clientes() {
        return CepCob_Clientes;
    }

    public void setCepCob_Clientes(String CepCob_Clientes) {
        this.CepCob_Clientes = CepCob_Clientes;
    }

    @Override
    public String toString() {
        return Id_Clientes;
    }

}
