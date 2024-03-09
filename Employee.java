import java.util.ArrayList;
import java.util.Scanner;
public class Employee{
    private String name;
    private String lastName;
    private ArrayList<BankAccount> employeeAccountList = new ArrayList<>();

    public Employee(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public ArrayList<BankAccount> getEmployeeAccountList() {
        return employeeAccountList;
    }

    public void addAccount(){
        char type='Q';
        Scanner sc = new Scanner(System.in);
        while(type != 'A' && type != 'B' && type != 'C') {
            System.out.println("Ingrese el tipo de la cuenta: ");
            type = sc.nextLine().charAt(0);
            if (type != 'A' && type != 'B' && type != 'C'){
                System.out.println("Tipo de cuenta no existe");
            }
        }
        System.out.println("Ingrese el numero de cuenta: ");
        long num = sc.nextLong();
        System.out.println("Ingrese la cantidad de dinero inicial: ");
        double amount = sc.nextDouble();
        BankAccount newAccount = new BankAccount(num, amount, type);
        employeeAccountList.add(newAccount);
        Main.bank.setAccountList(newAccount);
    }

    public void addAccount(long num, double amount, char type){
        BankAccount newAccount = new BankAccount(num, amount, type);
        employeeAccountList.add(newAccount);
        Main.bank.setAccountList(newAccount);
    }

    public void getAccountList(){
        int c = 0;
        System.out.println("====\tCuentas de: "+name+" "+lastName+"\t====");
        for (BankAccount bankAccount : employeeAccountList) {
            System.out.println("Cuenta "+(c+1)+" || Numero de Cuenta: "+bankAccount.getAccountNumber()+" Tipo: "+bankAccount.getType()+" Cantidad: "+bankAccount.getAmount());
            c++;
        }
        System.out.println("=============================================================");
    }

    public void withdraw(int index, double wd){
        for (BankAccount bankAccount : employeeAccountList.subList(index-1,index)) {
            if (bankAccount.getType() == 'A' && wd >= 1000) {
                if (bankAccount.getAmount() < wd) {
                    System.out.println("Retiro demasiado grande");
                } else {
                   bankAccount.withdraw(wd);
                }
            } else if (bankAccount.getType() == 'B' && wd >= 5000) {
                if (bankAccount.getAmount() < wd) {
                    System.out.println("Retiro demasiado grande");
                } else {
                    bankAccount.withdraw(wd);
                }
            } else if (bankAccount.getType() == 'C' && wd >= 10000) {
                if (bankAccount.getAmount() < wd) {
                    System.out.println("Retiro demasiado grande");
                } else {
                    bankAccount.withdraw(wd);
                }
            } else {
                System.out.println("Cantidad a retirar imposible de retirar");
            }
        }
        for (BankAccount bankAccount : Main.bank.getAccountList().subList(index-1,index)) {
            if (bankAccount.getType() == 'A' && wd >= 1000) {
                if (bankAccount.getAmount() < wd) {
                    System.out.println("Retiro demasiado grande");
                } else {
                    bankAccount.withdraw(wd);
                }
            } else if (bankAccount.getType() == 'B' && wd >= 5000) {
                if (bankAccount.getAmount() < wd) {
                    System.out.println("Retiro demasiado grande");
                } else {
                    bankAccount.withdraw(wd);
                }
            } else if (bankAccount.getType() == 'C' && wd >= 10000) {
                if (bankAccount.getAmount() < wd) {
                    System.out.println("Retiro demasiado grande");
                } else {
                    bankAccount.withdraw(wd);
                }
            } else {
                System.out.println("Cantidad a retirar imposible de retirar");
            }
        }
    }

}
