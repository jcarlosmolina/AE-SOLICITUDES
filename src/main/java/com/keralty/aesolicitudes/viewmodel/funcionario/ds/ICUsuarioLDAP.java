package com.keralty.aesolicitudes.viewmodel.funcionario.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aesolicitudes.persistence.Funcionario;
import com.keralty.aesolicitudes.persistence.Admin;
import com.keralty.aesolicitudes.persistence.SuperAdmin;
import com.keralty.aesolicitudes.persistence.Asesor;
import com.keralty.aesolicitudes.persistence.AreaMedica;
import com.keralty.aesolicitudes.persistence.Afiliaciones;
import com.keralty.aesolicitudes.persistence.RespRegional;
import com.keralty.aesolicitudes.persistence.Gestor;
import com.keralty.aesolicitudes.persistence.MesaDeApoyo;
public class ICUsuarioLDAP {

    @JsonProperty("usuarioldap")
    private String iCUsuarioLDAPUsuarioLDAP;

    public ICUsuarioLDAP() {
    
    }

    public ICUsuarioLDAP(Funcionario instance) {
        if (instance != null) {
            this.iCUsuarioLDAPUsuarioLDAP = instance.getFuncionarioUsuarioLDAP();
        }
    }

    public ICUsuarioLDAP(Admin instance) {
        if (instance != null) {
            this.iCUsuarioLDAPUsuarioLDAP = instance.getFuncionarioUsuarioLDAP();
        }
    }

    public ICUsuarioLDAP(SuperAdmin instance) {
        if (instance != null) {
            this.iCUsuarioLDAPUsuarioLDAP = instance.getFuncionarioUsuarioLDAP();
        }
    }

    public ICUsuarioLDAP(Asesor instance) {
        if (instance != null) {
            this.iCUsuarioLDAPUsuarioLDAP = instance.getFuncionarioUsuarioLDAP();
        }
    }

    public ICUsuarioLDAP(AreaMedica instance) {
        if (instance != null) {
            this.iCUsuarioLDAPUsuarioLDAP = instance.getFuncionarioUsuarioLDAP();
        }
    }

    public ICUsuarioLDAP(Afiliaciones instance) {
        if (instance != null) {
            this.iCUsuarioLDAPUsuarioLDAP = instance.getFuncionarioUsuarioLDAP();
        }
    }

    public ICUsuarioLDAP(RespRegional instance) {
        if (instance != null) {
            this.iCUsuarioLDAPUsuarioLDAP = instance.getFuncionarioUsuarioLDAP();
        }
    }

    public ICUsuarioLDAP(Gestor instance) {
        if (instance != null) {
            this.iCUsuarioLDAPUsuarioLDAP = instance.getFuncionarioUsuarioLDAP();
        }
    }

    public ICUsuarioLDAP(MesaDeApoyo instance) {
        if (instance != null) {
            this.iCUsuarioLDAPUsuarioLDAP = instance.getFuncionarioUsuarioLDAP();
        }
    }

    @JsonIgnore
    public String getICUsuarioLDAPUsuarioLDAP() {
        return this.iCUsuarioLDAPUsuarioLDAP;
    }
    
    public void setICUsuarioLDAPUsuarioLDAP(String iCUsuarioLDAPUsuarioLDAP) {
        this.iCUsuarioLDAPUsuarioLDAP = iCUsuarioLDAPUsuarioLDAP;
    }
}
