import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Bank bank = new Bank();
    public static void main(String[] args) {
        Employee e1 = new Employee("Diego", "Garcia");
        Employee e2 = new Employee("Oscar", "Corona");
        e2.addAccount(111,58500.50,'C');
        e2.addAccount(121,11322,'A');
        Employee e3 = new Employee("Samuel", "Villegas");

        System.out.println("=======================================");
        System.out.println("\t\tBienvenido al menu del Banco");
        while (true) {
            System.out.println("¿Que accion desea realizar?");
            System.out.println("/1. Iniciar Sesion /2. Ver todas las cuentas de banco /3. Cerrar programa ");
            System.out.println();
            int opt = sc.nextInt();
            if (opt == 1){
                System.out.println("Que usuario es: /1 Diego Garcia /2 Oscar Corona /3 Samuel Villegas");
                int opt2 = sc.nextInt();
                while (opt2 == 1){
                    System.out.println("Que desea realizar Diego Garcia: /1 Ver Cuentas /2 Agregar Cuenta /3 Retirar Dinero /4 Cerrar Sesion ");
                    int opt3 = sc.nextInt();
                    if (opt3 == 1){
                        e1.getAccountList();
                    } else if (opt3 == 2 ){
                        e1.addAccount();
                    } else if (opt3 == 3){
                        if (e1.getEmployeeAccountList().size() <= 0) {
                            System.out.println("No tiene cuentas de donde retirar");
                        } else {
                            e1.getAccountList();
                            System.out.println("De que cuenta desea retirar: ");
                            int index = sc.nextInt();
                            System.out.println("Cuanto va a retirar: ");
                            double wd = sc.nextDouble();
                            e1.withdraw(index, wd);
                        }
                    } else if (opt3 == 4){
                        break;
                    }
                } while (opt2 == 2){
                    System.out.println("Que desea realizar Oscar Corona: /1 Ver Cuentas /2 Agregar Cuenta /3 Retirar Dinero /4 Cerrar Sesion ");
                    int opt3 = sc.nextInt();
                    if (opt3 == 1){
                        e2.getAccountList();
                    } else if (opt3 == 2 ){
                        e2.addAccount();
                    } else if (opt3 == 3){
                        if (e2.getEmployeeAccountList().size() <= 0) {
                            System.out.println("No tiene cuentas de donde retirar");
                        } else {
                            e2.getAccountList();
                            System.out.println("De que cuenta desea retirar: ");
                            int index = sc.nextInt();
                            System.out.println("Cuanto va a retirar: ");
                            double wd = sc.nextDouble();
                            e2.withdraw(index, wd);
                        }
                    } else if (opt3 == 4){
                        break;
                    }
                } while (opt2 == 3){
                    System.out.println("Que desea realizar Samuel Villegas: /1 Ver Cuentas /2 Agregar Cuenta /3 Retirar Dinero /4 Cerrar Sesion ");
                    int opt3 = sc.nextInt();
                    if (opt3 == 1){
                        e3.getAccountList();
                    } else if (opt3 == 2 ){
                        e3.addAccount();
                    } else if (opt3 == 3){
                        if (e3.getEmployeeAccountList().size() <= 0) {
                            System.out.println("No tiene cuentas de donde retirar");
                        } else {
                            e3.getAccountList();
                            System.out.println("De que cuenta desea retirar: ");
                            int index = sc.nextInt();
                            System.out.println("Cuanto va a retirar: ");
                            double wd = sc.nextDouble();
                            e3.withdraw(index, wd);
                        }
                    } else if (opt3 == 4){
                        break;
                    }
                }
            } else if (opt == 2){
                System.out.println("Cual cuenta quiere ver: (0 : TODAS) ");
                int cuentas = sc.nextInt();
                if (cuentas == 0){
                    bank.printList();
                } else  {
                    bank.printIndexList(cuentas);
                }

            } else if (opt == 3){
                System.out.println("\t\tAdios!");
                break;
            }
        }
    }
}