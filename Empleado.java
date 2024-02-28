public class Empleado {
    double sueldo;

    public Empleado(double sueldo){
        this.sueldo = sueldo;
    }

    public double calcularSalario(){
        return sueldo;
    }

    public double calcularSalario(double bonificacion){
        return sueldo + bonificacion;
    }

    public double calcularSalario(double bonificacion, int horasExtra){
        return sueldo + bonificacion + (horasExtra * 20);
    }
}
