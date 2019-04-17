package br.com.model;

import java.time.LocalDate;
import java.util.Date;
import javafx.scene.control.DatePicker;

public class MatEnviado {

    private String Id_Mat_Env, Id_Clientes;
    private DatePicker Mat_Env_Data;
    private Date Mat_Env_Data2;
    private String Mat_Env_Desc;
    private String Mat_Env_Data3;

    public MatEnviado() {
    }

    public MatEnviado(String Id_Clientes, DatePicker Mat_Env_Data, String Mat_Env_Desc) {
        this.Id_Clientes = Id_Clientes;
        this.Mat_Env_Data = Mat_Env_Data;
        this.Mat_Env_Desc = Mat_Env_Desc;
    }

    public MatEnviado(String Id_Mat_Env, String Id_Clientes, DatePicker Mat_Env_Data, String Mat_Env_Desc) {
        this.Id_Mat_Env = Id_Mat_Env;
        this.Id_Clientes = Id_Clientes;
        this.Mat_Env_Data = Mat_Env_Data;
        this.Mat_Env_Desc = Mat_Env_Desc;
    }

    public String getId_Mat_Env() {
        return Id_Mat_Env;
    }

    public void setId_Mat_Env(String Id_Mat_Env) {
        this.Id_Mat_Env = Id_Mat_Env;
    }

    public String getId_Clientes() {
        return Id_Clientes;
    }

    public void setId_Clientes(String Id_Clientes) {
        this.Id_Clientes = Id_Clientes;
    }

    public DatePicker getMat_Env_Data() {
        return Mat_Env_Data;
    }

    public void setMat_Env_Data(DatePicker Mat_Env_Data) {
        this.Mat_Env_Data = Mat_Env_Data;
    }

    public Date getMat_Env_Data2() {
        return Mat_Env_Data2;
    }

    public void setMat_Env_Data2(Date Mat_Env_Data2) {
        this.Mat_Env_Data2 = Mat_Env_Data2;
    }

    public String getMat_Env_Desc() {
        return Mat_Env_Desc;
    }

    public void setMat_Env_Desc(String Mat_Env_Desc) {
        this.Mat_Env_Desc = Mat_Env_Desc;
    }

    public String getMat_Env_Data3() {
        return Mat_Env_Data3;
    }

    public void setMat_Env_Data3(String Mat_Env_Data3) {
        this.Mat_Env_Data3 = Mat_Env_Data3;
    }

    
}
