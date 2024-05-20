package Sistema.json.model;

import java.util.ArrayList;

import usuarios.*;

public class UsuariosModel {
    private ArrayList<User> CLIENTE;
    private ArrayList<User> TRABAJADOR;
    private ArrayList<User> GERENTE;
    
    public ArrayList<User> getCLIENTE() {
        return CLIENTE;
    }
    public ArrayList<User> getTRABAJADOR() {
        return TRABAJADOR;
    }
    public ArrayList<User> getGERENTE() {
        return GERENTE;
    }

    
}