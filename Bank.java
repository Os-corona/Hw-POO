import java.util.ArrayList;

public class Bank {
    private ArrayList<BankAccount> accountList = new ArrayList<>();

    public ArrayList<BankAccount> getAccountList() {
        return accountList;
    }

    public void setAccountList(BankAccount newAccount) {
        this.accountList.add(newAccount);
    }

    public void printList(){
        int c=0;
        System.out.println("==========================================");
        for (BankAccount bankAccount : accountList) {
            System.out.println("Cuenta "+(c+1)+" Numero de Cuenta: "+bankAccount.getAccountNumber()+" Tipo: "+bankAccount.getType()+" Dinero: "+bankAccount.getAmount());
            c++;
        }
        System.out.println("==========================================");
    }

    public void printIndexList(int i){
        if (i-1 > accountList.size()){
            System.out.println("Cuenta no existente");
        } else {
            for (BankAccount bankAccount : accountList.subList(i-1,i)){
                System.out.println("Cuenta "+(i)+" || Numero de Cuenta: "+bankAccount.getAccountNumber()+" Tipo: "+bankAccount.getType()+" Dinero: "+bankAccount.getAmount());
            }
        }
    }
}

