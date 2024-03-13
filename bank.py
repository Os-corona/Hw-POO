from bankAccount import BankAccount
from employee import Employee
class Bank:
    
    def __init__(self):
        self.__employeeList = []

    def addEmployee(self, employee):
        self.__employeeList.append(employee)

    def showEmployees(self):
        i = 1
        if not self.__employeeList:
            print("No hay empleados para mostrar")
        print("\tLISTA DE EMPLEADOS: ")
        for employee in self.__employeeList:
            name, lastName = employee.showEmployee()
            print("Empleado ",i," : Nombre:", name,lastName)
            i += 1
            employee.showAccounts()            
    