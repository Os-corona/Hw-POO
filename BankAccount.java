public class BankAccount {

    private long accountNumber;
    private double amount;
    private char type;

    public BankAccount(long accountNumber, double amount, char type) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.type = type;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void addMoney(double amount) {
        if (type == 'A' && amount < 50000){
            this.amount = amount;
        } else if (type == 'B' && amount <100000){
            this.amount = amount;
        } else {
            this.amount = amount;
        }
    }

    public void withdraw(double wd){
        amount -= wd;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        if (type == 'A' || type == 'B' || type == 'C') {
            this.type = type;
        } else {
            System.out.println("El tipo de cuenta no existe");
        }
    }

}
