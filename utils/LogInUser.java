package utils;

import usuarios.User;

public class LogInUser{
    private static LogInUser instancia;
    private User usuarioActual;

    private LogInUser(){}

    public static LogInUser getInstancia(){
        if(instancia==null){
            instancia = new LogInUser();
        }
        return instancia;
    }

    public User getUsuarioActual(){
        return usuarioActual;
    }

    public void setUsuario(User usuarioActual){
        this.usuarioActual = usuarioActual;
    }

    public boolean usuarioEnSesion(){
        return usuarioActual != null;
    }

    public void cerrarSesion(){
        instancia = null;
        usuarioActual = null;
    }
}