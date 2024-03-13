from bank import Bank
from employee import Employee

bank = Bank()

e1 = Employee("Oscar","Corona")
e1.addAccount1(1221, 'A' , 28500.50)
e1.addAccount1(1222, 'C', 64500.99)
bank.addEmployee(e1)

e2 = Employee("Diego", "Emilio")
e2.addAccount1(2111, 'C', 19900)
bank.addEmployee(e2)

e3 = Employee("Samuel","Villegas")
bank.addEmployee(e3)

print("Bienvenido al menu del Banco!")
while True:
    opt = int(input("Que desea realizar: 1/ Iniciar Sesion 2/ Ver empleados 3/ Cerrar programa \n"))

    if opt == 1:
        opt2 = int(input("Quien es usted: 1/ Oscar Corona /2 Diego Emilio /3 Samuel Villegas "))

        while opt2 == 1:
            opt3 = int(input("Que desea realizar: 1/Ver cuentas bancarias /2 Retirar dinero 3/ Agregar Cuenta /4 Cerrar Sesion "))
            if opt3 == 1 :
                e1.showAccounts()
            elif opt3 == 2 :
                e1.showAccounts()
                number = int(input("De que numero de cuenta desea retirar dinero: "))
                amount = float(input("Cuanto desea retirar: "))
                e1.withdraw(amount, number)
            elif opt3 == 3:
                e1.addAccount()
            elif opt3 == 4:
                break
            else: print("Opcion erronea, intente de nuevo") 
        while opt2 == 2:
            opt3 = int(input("Que desea realizar: 1/Ver cuentas bancarias /2 Retirar dinero 3/ Agregar Cuenta /4 Cerrar Sesion "))
            if opt3 == 1 :
                e2.showAccounts()
            elif opt3 == 2 :
                e2.showAccounts()
                number = int(input("De que numero de cuenta desea retirar dinero: "))
                amount = float(input("Cuanto desea retirar: "))
                e2.withdraw(amount, number)
            elif opt3 == 3:
                e2.addAccount()
            elif opt3 == 4:
                break
            else: print("Opcion erronea, intente de nuevo")
        while opt2 == 3:
            opt3 = int(input("Que desea realizar: 1/Ver cuentas bancarias /2 Retirar dinero 3/ Agregar Cuenta /4 Cerrar Sesion "))
            if opt3 == 1 :
                e3.showAccounts()
            elif opt3 == 2 :
                e3.showAccounts()
                number = int(input("De que numero de cuenta desea retirar dinero: "))
                amount = float(input("Cuanto desea retirar: "))
                e3.withdraw(amount, number)
            elif opt3 == 3:
                e3.addAccount()
            elif opt3 == 4:
                break
            else: print("Opcion erronea, intente de nuevo")
        if opt3 != 1 and opt3 != 2 and opt3 != 3:
            print("Opcion erronea intente de nuevo")                                   
    elif opt == 2:
        bank.showEmployees()
    elif opt == 3:
        print("Adios! ")
        break
    else:
        print("Opcion erronea intente de nuevo")

