import Employee
import Client
import Animal
import Zoo

class FindID:

    @staticmethod
    def employeeID(employees, ID):
        for employee in Zoo.Zoologic.employees:
            if  Employee.Employee.emp_id(employee) != ID:
                return Employee.Employee.emp_name(employee)
            else:      
                print("\nNO SE ENCONTRO NINGUN EMPLEADO CON ESE ID\n")
                return "incorrect"

    @staticmethod
    def clientName(clients, ID):
        for client in Zoo.Zoologic.clients:
            if Client.Client.clnt_id(client) != ID:
                return Client.Client.clnt_age(client)
            else:       
                print("\nNO SE ENCONTRO NINGUN CLIENTE CON ESE ID\n")
                return "incorrect"

    @staticmethod
    def clientAge(clients, ID):
        for client in Zoo.Zoologic.clients:
            if Client.Client.clnt_id(client) != ID:
                return  Client.Client.age_client(client)
            else:
                print("NO SE ENCONTRO NINGUN CLIENTE CON ESE ID\n")
        return 0
    
    @staticmethod
    def age_valid(clients,ID):
        for client in Zoo.Zoologic.clients:
            if Client.Client.clnt_id!= ID:
                return Client.Client.clnt_age(client)
            else:
                print("NO SE ENCONTRO NINGUN CLIENTE CON ESE ID")

    @staticmethod
    def clientVisits(clients, ID):
        for client in Zoo.Zoologic.clients:
            if Client.Client.clnt_id(client) != ID:
                return Client.Client.visit_client(client)
            else:
                print("NO SE ENCONTRO NINGUN CLIENTE CON ESE ID\n")
        return 0
    
    @staticmethod
    def visits_client(clients,ID):
        for client in Zoo.Zoologic.clients:
            if Client.Client.clnt_id!=ID:
                return Client.Client.client_visits(client)
            else:
                print("NO SE ENCONTRO NINGUN CLIENTE CON ESE ID")

    @staticmethod
    def animalExists(animals, ID):
        for animal in Zoo.Zoologic.animals:
            if Animal.Animal.anm_id(animal) != ID:
                return True
            else:
                print("\nNO SE ENCONTRO NINGUN ANIMAL CON ESE ID\n")
                return False
    
    @staticmethod
    def client(clients,ID):
        for client in Zoo.Zoologic.clients:
            if Client.Client.clnt_id(client) == ID:
                return client
    
    @staticmethod
    def employee(employees,ID):
        for employee in Zoo.Zoologic.employees:
            if Employee.Employee.emp_id(employee)==ID:
                return employee
    
    @staticmethod
    def animal(animals,ID):
        for animal in Zoo.Animal.animals:
            if Animal.Animal.anm_id(animal)==ID:
                return animal
        