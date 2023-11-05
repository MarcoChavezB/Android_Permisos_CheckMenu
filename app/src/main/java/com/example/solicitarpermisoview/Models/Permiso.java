package com.example.solicitarpermisoview.Models;

public class Permiso {
    private String permiso;
    private String permisoBundle;

    public Permiso(String permiso, String permisoBundle){
        this.permiso = permiso;
        this.permisoBundle = permisoBundle;
    }

    public String getPermiso(){return permiso;}
    public String getPermisoBundle(){return permisoBundle;}
}
