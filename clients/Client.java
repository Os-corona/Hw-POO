package clients;

import java.util.Scanner;

public class Client {
    static int cont = 1;
    double wallet;
    String name;
    String lastName;
    String address;
    int age;
    int timesBought;
    String id;

    public Client(String name, String lastName, String address, int age, double wallet) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.age = age;
        this.wallet = wallet;
        this.timesBought = 0;
        this.id = String.format("%03d", cont);
        cont++;
    }

    public Client(String name, String lastName, String address, int age, int timesBought, double wallet) {
        this.name = name;
        this.wallet = wallet;
        this.lastName = lastName;
        this.address = address;
        this.age = age;
        this.timesBought = timesBought;
        this.id = String.format("%03d", cont);
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nuevo nombre del cliente: ");
        String name = sc.next();

        System.out.println("Ingrese el nuevo apellido del cliente: ");
        String lastName = sc.next();

        this.name = name;
        this.lastName = lastName;

        System.out.println("\n= SE HA MODIFICADO EL NOMBRE CORRECTAMENTE =");
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTimesBought() {
        return timesBought;
    }

    public void setTimesBought() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero de compras del cliente: ");
        int buys = sc.nextInt();

        this.timesBought = buys;
        System.out.println("\n= SE HAN MODIFICADO LAS COMPRAS CORRECTAMENTE =");
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nuevo saldo del cliente: ");
        double wallet = sc.nextDouble();

        this.wallet = wallet;

        System.out.println("\n= SE HA MODIFICADO EL SALDO CORRECTAMENTE =");
    }

    public void reduceWallet(double wallet) {
        this.wallet -= wallet;
    }
}
