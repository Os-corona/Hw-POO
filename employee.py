from bankAccount import BankAccount

class Employee:

    def __init__(self, name, lastName):
        self.__name = name
        self.__lastName = lastName
        self.__accountList = []

    def withdraw(self, wd, number):
        for account in self.__accountList:
            if number == account.getAccountNumber():
                 account.withdraw(wd)
                 return
        print("Cuenta no encontrada")                             

    def addAccount(self):
        type = ''
        while type != 'A' and type != 'B' and type != 'C' :
            type = input("Ingrese el tipo de cuenta: ")
            if type != 'A' and type != 'B' and type != 'C' :
                print("Tipo de cuenta erroneo")

        accountNumber = int(input("Ingrese el Numero de Cuenta: "))
        while True:
            amount = float(input("Ingrese la cantidad de dinero inicial: "))
            if type == 'A' and amount < 10000:
                   break
            elif type == 'B' and amount < 50000:
                   break
            elif type == 'C':
                   break
            else: 
                 print("Cantidad inicial es mayor a la posible en el tipo de cuenta")

        newAccount = BankAccount(accountNumber,type, amount)
        self.__accountList.append(newAccount)

    def addAccount1(self, accountNumber, type, amount):
        newAccount = BankAccount(accountNumber,type, amount)
        self.__accountList.append(newAccount)

    def showEmployee(self):
        return self.__name,self.__lastName

    def showAccounts(self):
        i = 1
        if not self.__accountList:
            print("No hay listas para mostrar")
        else : 
            print("\t\t||Cuentas de "+self.__name+" "+self.__lastName+"||")
            for account in self.__accountList:
                account_number = account.getAccountNumber()
                account_type = account.getType()
                account_amount = account.getAmount()
                print(" ",i,".--Numero de cuenta: ",account_number,"|| Tipo de cuenta: ",account_type,"|| Dinero en cuenta: ",account_amount)
                i += 1        
            print()            
