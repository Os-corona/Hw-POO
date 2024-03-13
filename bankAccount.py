class BankAccount:

    def getType(self):
        return self.__type
    
    def getAccountNumber(self):
        return self.__accountNumber
    
    def getAmount(self):
        return self.__amount

    def __init__(self, accountNumber, type, amount):
        self.__type = type
        self.__accountNumber = accountNumber
        self.__amount = amount
        

    def withdraw(self, wd):
        if wd > self.__amount:
            print("Retiro mayor al saldo de la cuenta")
        elif self.__type == 'A' and wd >= 1000 : 
            self.__amount -= wd
        elif self.__type == 'B' and wd >= 5000:   
            self.__amount -= wd  
        elif self.__type == 'C' and wd >= 10000:   
            self.__amount -= wd
        else: 
            print("Retiro menor al minimo de la cuenta")                                       