public class Hw5 {
    public static void main(String[] args) {
        System.out.println("===================================================");
        System.out.println("\t\tClase Rectangulo: ");
        Rectangulo r1 = new Rectangulo();
        System.out.println("Area de enteros: "+r1.area(11, 2));
        System.out.println("Perimetro de enteros: "+r1.perimetro(11, 2));

        Rectangulo r2 = new Rectangulo();
        System.out.println("Area de doubles: "+r2.area(9.54, 8.13));
        System.out.println("Perimetro de doubles: "+r2.perimetro(9.54, 8.13));
        System.out.println("===================================================");
        System.out.println("\t\tClase Empleado: ");
        Empleado e1 = new Empleado(1500);
        System.out.println("Salario: "+e1.calcularSalario());
        System.out.println("Salario + bonificacion: "+e1.calcularSalario(155.50));
        System.out.println("Salario + bono + horas Extra: "+e1.calcularSalario(155.50, 18));
        System.out.println("===================================================");
        System.out.println("\t\tClase Impuestos:");
        CalculadoraImpuestos calc1 = new CalculadoraImpuestos();
        System.out.println("Ingresos: "+calc1.calcularImpuestos(18000));
        System.out.println("Ingresos + porcentaje: "+calc1.calcularImpuestos(18000, 14.32));
        System.out.printf("Dividendos + porcentaje + exencion: %.2f",calc1.calcularImpuestos(18000, 14.32, 2000));
        System.out.println("\nExencion > Impuestos: "+calc1.calcularImpuestos(18000, 14.32, 17500));
        System.out.println("===================================================");
    }
}

