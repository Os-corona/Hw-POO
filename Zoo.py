import Employee
import Client
import FindID
import Employee
import Animal
import Visit
import Order    

class Zoologic:
    employees=[]
    animals=[]
    clients=[]
    orders=[]
    visits=[]

    def register_employee(self):
        print("==Ha seleccionado registrar un empleado==")
        print("Ingrese el nombre del empleado (sin apellidos)")
        name=input()
        print("Ingrese el apellido del empleado")
        Last_name=input()
        print("Ingrese la fecha de nacimiento del empleado(DD-MM-YYYY)")
        Birthday=input()
        birthday=Birthday[:5]
        print("Ingrese el RFC del empleado")
        rfc=input()
        print("Ingrese la CURP del empleado")
        curp=input()
        print("Ingrese el salario del empleado")
        salary=input()
        print("Ingrese el horario del empleado(XX:XX - XX:XX)")
        schedule=input()
        rols=["administracion","Administracion","guia","Guia","mantenimiento","Mantenimiento","veterinario","Veterinario"]
        flag=True
        while flag==True:
            print("Ingrese el rol del empleado(Administracion,Guia,Mantenimiento,Veterinario)")
            rol=input()
            if rol in rols:
                rol=rol
                flag=False
            else:
                print("Rol no reconocido")

        employee=Employee.Employee(name,Last_name,curp,birthday,salary,schedule,rol,rfc)
        Zoologic.employees.append(employee)
        print("==Se ha registrado correctamente a: ",name,"==")

    def register_animal(self):
        print("==Ha seleccionado registrar un animal==")
        print("Ingrese la especie del animal: ")
        animal_Type=input()
        print("Ingrese el peso del animal: ")
        weight=input()
        print("Ingrese la fecha de nacimiento del animal(DD-MM-YYYY): ")
        birthday=input()
        print("El animal tiene enfermedades?(S/N)")
        Sick=input()
        diseases=[]
        if Sick== 'S' or Sick=='s':
            print("Con que enermedades cuenta el animal?")
            disease=input()
            diseases.append(disease)
        elif Sick=='N' or Sick=='n':
            disease="Sin enfermedades"
            diseases.append(disease)
        print("Cada cuanto de alimentara al animal?")
        feeding_schedule=input()
        types=["herbivoro","carnivoro","omnivoro"]
        flag=True
        while flag==True:
            print("Ingrese el tipo de alimentacion(herbivoro,carnivoro,omnivoro):")
            food_type=input()
            if food_type in types:
                food_type=food_type
                flag=False
            else:
                print("Tipo invalido")

        print("EL animal esta vacunado?")
        is_vaccinated=input()

        animal=Animal.Animal(animal_Type,birthday,weight,diseases,feeding_schedule,food_type,is_vaccinated)
        Zoologic.animals.append(animal)
        print("NUEVO ANIMAL REGISTRADO")

    def register_client(self):
        print("==Ha seleccionado: registrar un cliente")
        print("Ingrese el nombre del cliente (sin apellidos)")
        name= input()
        print("Ingrese los apellidos del cliente")
        Last_name= input()
        print("Ingrese la curp del cliente")
        curp=input()
        print("Ingrese el cumpleaños del cliente (DD-MM-YYYY)")
        birthday=input()
        print("Ingrese la edad del cliente")
        age=input()

        client=Client.Client(name,Last_name,curp,birthday,age)
        Zoologic.clients.append(client)

        print("Se ha registrado al cliente: ",name, "correctamente")

    def register_visit(self):
        visitants=[]
        Clients_in_visit=[]
        print("==Ha seleccionado: registrar una visita==")
        Zoologic.print_employees(self)
        flag= True
        while flag== True:
            print("Que empleado sera el guia en la visita? (ingrese el ID del empleado)")
            In_charge=input()
            employee=FindID.FindID.employeeID(Zoologic.employees,In_charge)
            if employee != "incorrect":
                break

        Zoologic.print_clients(self)
        print("A continuacion ingrese los visitantes que entraran a la visita. (ingrese el ID de los vistantes)")
        total_price=0
        adults=0
        children=0
        client=" "
        while client != "-1":
            client_name=FindID.FindID.clientName(Zoologic.clients,client)
            if client_name== "incorrect" or client in Clients_in_visit:
                print("ID inexistente o ya ingresado. Ingrese otro ID:")
                client =input()
            else:
                print("Cliente: " ,client_name, " se ha agregado a la visita")
                visitants.append(FindID.FindID.clientName(Zoologic.clients, client))
                Clients_in_visit.append(client)
                if FindID.FindID.age_valid(Zoologic.clients,client) >= 18:
                    if FindID.FindID.visits_client(Zoologic.clients,client) <=5:
                        total_price+=80
                    else:
                        total_price+=100
                    adults+=1
                else:
                    if FindID.FindID.clientVisits(Zoologic.clients,client) >=5:
                        total_price+=40
                    else:
                        total_price+=50
                    children+=1
                print("Si desea agregar otro visitante, ingrese el ID de otro visitante,sino, ingrese -1")
                client=input()
        visit= Visit.Visit(employee,visitants,total_price,adults,children)
        Zoologic.visits.append(visit)

        print("==VISITA REGISTRADA EN EL SISTEMA==")

    def print_employees(self,rol):
        print("==LISTA DE EMPLEADOS CON EL ROL DE: ", rol," ==")
        for employee in Zoologic.employees:
            if employee.rol().equalsIgnoreCase(rol):
                print("Empleado: ",employee.ID(), " Nombre: ", employee.name(),employee.Last_name(), " Horario: ", employee.schedule())
                print("==========")
    
    def print_clients(self):
        print("==LISTA DE VISITANTES REGISTRADOS==")
        for client in Zoologic.clients:
            Client.Client.Client_Info(client)
            print("==========")
            #print("Cliente: ",client, " Nombre: ",client.name(),client.Last_name()," Dia de nacimiento: ",client.birthday()," Num. de visitas: ",client.visits()," Dia de registro: ",client.registration_date())
    
    def print_employees(self):
        print("==LISTA DE EMPLEADOS==")
        for employee in Zoologic.employees:
          Employee.Employee.Employee_Info(employee)
          print("==========")
            #print("Empleado: ",employee.ID()," Nombre: ",employee.name(),employee.Last_name()," Edad: ",employee.age())
            #print("Horario: ",employee.schedule()," Rol: ",employee.rol()," Salario: ",employee.salary())
            #print(" RFC: ",employee.rfc()," CURP: ",employee.curp()," Dia de contratacion: ",employee.First_Day_As_Worker())
    
    def print_animals(self):
        print("==LISTA DE ANIMALES EN EL ZOOLOGICO==")
        for animal in Zoologic.animals:
            vacunado=Animal.Animal.is_vaccinated
            Animal.Animal.Data(animal)
            #print("Animal: ",animal.ID()," Tipo: ",animal.animal_Type()," Nacio el: ",animal.birthday())
            #print("Esta vacunado: ",vacunado," Peso: ",animal.weight(), " Se alimenta cada: ",animal.feeding_schedule())
            Animal.Animal.print_diseases(animal)
            print("==========")
    
    def print_visits(self):
        print("==LISTA DE VISITAS==")
        for visit in Zoologic.visits:
            Visit.Visit.visit_id(visit)
            Visit.Visit.visits_info(visit)
            print("==========")
           # print("Empleado a cargo: ",visit.employee_in_charge()," Precio total: ",visit.total_price()," Dia: ",visit.day_of_visit())

    def print_orders(self):
        print("==LISTA DE ORDENES==")
        for order in Zoologic.orders:
            Order.Order.orders_info(order)
            print("==========")
            #print("Empleado que ejecuto la orden: ",order.employee()," Animal al que se realizo la orden: ",order.animal_ID())
            #print("Proceso realizado: ", order.process()," Observaciones: ", order.observations()," Dia en que se realizo la orden: ",order.date())

    def create_maintenance_order(self):
        print("\n\t== HA SELECCIONADO CREAR UNA ORDEN DE MANTENIMIENTO ==\n")
        Zoologic.print_employees("mantenimiento")

        while True:
            id = input("Que empleado desea asignar: (Ingrese el ID)")
            employee = FindID.FindID.employeeID(Zoologic.employees,id)
            if employee != "incorrect":
                break
            else:
                print("ID no reconocido")

        Zoologic.print_animals(self)

        while True:
            animal_id = input("A que animal se le hara el mantenimiento: ")
            if FindID.FindID.animalExists(Zoologic.animals, animal_id):
                break
            else:
                print("ID no reconocido")

        process = input("Que proceso realizara el empleado (Alimentar, Limpiar, Cuidar)")
        ob = input("El empleado desea realizar observaciones: (S/N)")
        if ob == 'S' or ob == 's':
            observation = input("Que observaciones tuvo el empleado: ")
            order = Order.Order(employee, animal_id, process, observation)
            Zoologic.orders.append(order)
        else:
            order = Order.Order(employee, animal_id, process,"ninguna")
            Zoologic.orders.append(order)
        
        print("\n\t== SE HA REGISTRADO LA ORDEN CORRECTAMENTE ==")

    def modify_client(self):
        flag=True
        print("==Ha seleccionado: Modificar un cliente==")
        Zoologic.print_clients(self)

        while flag==True:
            print("Que cliente desea modificar? (Ingrese el ID del cliente)")
            id=input()
            if FindID.FindID.clientName(Zoologic.clients,id)!= "incorrect":
                print("Ha seleccionado a: ",FindID.FindID.clientName(Zoologic.clients,id))
            else:
                print("ID ingresado no reconocido")
            while flag:
                print("Que desea modificar ")
                print("1. Nombre ")
                print("2. Apellido")
                print("3. CURP")
                print("4. Numero de visitas")
                print("5. Salir")
                opt=int(input())

                if opt==1:
                    print("Ingrese el nombre del cliente: ")
                    Client.Client.name=input()
                   
                elif opt==2:
                    print("Ingrese el apellido del cliente: ")
                    Client.Client.Last_name=input()
                
                elif opt==3:
                    print("Ingrese la CURP del cliente: ")
                    Client.Client.curp=input()
                
                elif opt==4:
                    print("Ingrese la cantidad de visitas del cliente: ")
                    Client.Client.visits=int(input())
                
                elif opt==5:
                    flag=False
                
                else:
                    print("Opcion invalida")

    def modify_employee(self):
        flag=True
        print("==Ha seleccionado: Modificar un empleado==")
        Zoologic.print_employees(self)

        while flag==True:
            print("Que empleado desea modificar? (Ingrese el ID del empleado)")
            id=input()
            if FindID.FindID.employeeID(Zoologic.employees,id)!= "incorrect":
                print("Ha seleccionado a: ",FindID.FindID.employeeID(Zoologic.employees,id))
            else:
                print("ID ingresado no reconocido")
            while flag:
                print("Que desea modificar ")
                print("1. Nombre ")
                print("2. Apellido")
                print("3. Rol")
                print("4. Salario")
                print("5. Horario")
                print("6. Salir")
                opt=int(input())

                if opt==1:
                    print("Ingrese el nombre del empleado: ")
                    Employee.Employee.name=input()
                   
                elif opt==2:
                    print("Ingrese el apellido del empleado: ")
                    Employee.Employee.Last_name=input()
                
                elif opt==3:
                    print("Ingrese el rol del empleado: ")
                    Employee.Employee.curp=input()
                
                elif opt==4:
                    print("Ingrese el salario del empleado: ")
                    Employee.Employee.salary=input()
                
                elif opt==5:
                    print("Ingrese el horario del empleado: ")
                    Employee.Employee.schedule=input()

                elif opt==6:
                    flag=False
                
                else:
                    print("Opcion invalida")

    def modify_animal(self):
        flag=True
        print("==Ha seleccionado: Modificar un animal==")
        Zoologic.print_animals(self)

        while flag==True:
            print("Que animal desea modificar? (Ingrese el ID del animal)")
            id=input()
            if FindID.FindID.animalExists(Zoologic.animals,id)!= "incorrect":
                print("Ha seleccionado al animal con el ID: ",id)
            else:
                print("ID ingresado no reconocido")
            while flag:
                print("Que desea modificar ")
                print("1. Peso ")
                print("2. Horario de alimentacion")
                print("3. Vacunas del animal")
                print("4. Salir")
                opt=int(input())

                if opt==1:
                    print("Ingrese el peso del animal: ")
                    Animal.Animal.weight=input()
                   
                elif opt==2:
                    print("Ingrese el horario de alimentacion del animal: ")
                    Animal.Animal.feeding_schedule=input()
                
                elif opt==3:
                    print("Ingrese la actualizacion de vacunas del animal: ")
                    Animal.Animal.is_vaccinated=input()
                
                elif opt==4:
                    flag=False
                
                else:
                    print("Opcion invalida")
    
    def delete_client(self):
        print("==Ha seleccionado: eliminar un cliente==")
        Zoologic.print_clients(self)
        flag=True
        while flag==True:
            print("Que cliente desea eliminar? (Ingrese el ID del cliente a eliminar)")
            id=input()
            
            if FindID.FindID.clientName(Zoologic.clients,id)!= "incorrect":
                print("Ha seleccionado a: ",FindID.FindID.clientName(Zoologic.clients,id))
            else:
                print("ID no reconocido")
            print("Esta seguro? (S/N)")
            delete=input()
            if delete=='S' or delet=='s':
                print("Se ha eliminado a: ",FindID.FindID.clientName(Zoologic.clients,id))
                Zoologic.clients.remove(FindID.FindID.clientName(Zoologic.clients,id))
            else:
                print("No se elimino ningun cliente del sistema ")

    def delete_employee(self):
        print("==Ha seleccionado: eliminar un empleado==")
        Zoologic.print_employees(self)
        flag=True
        while flag==True:
            print("Que empleado desea eliminar? (Ingrese el ID del empleado a eliminar)")
            id=input()
            
            if FindID.FindID.employeeID(Zoologic.employees,id)!= "incorrect":
                print("Ha seleccionado a: ",FindID.FindID.employeeID(Zoologic.employees,id))
            else:
                print("ID no reconocido")
            print("Esta seguro? (S/N)")
            delete=input()
            if delete=='S' or delet=='s':
                print("Se ha eliminado a: ",FindID.FindID.employeeID(Zoologic.employees,id))
                Zoologic.employees.remove(FindID.FindID.employeeID(Zoologic.employees,id))
            else:
                print("No se elimino ningun empleado del sistema ")
    def delete_animal(self):
        print("==Ha seleccionado: eliminar un animal==")
        Zoologic.print_animals(self)
        flag=True
        while flag==True:
            print("Que animal desea eliminar? (Ingrese el ID del animal a eliminar)")
            id=input()
            
            if FindID.FindID.animalExists(Zoologic.animals,id)!= "incorrect":
                print("Ha seleccionado al animal: ",FindID.FindID.animalExists(Zoologic.animals,id))
            else:
                print("ID no reconocido")
            print("Esta seguro? (S/N)")
            delete=input()
            if delete=='S' or delet=='s':
                print("Se ha eliminado al animal: ",FindID.FindID.animalExists(Zoologic.animals,id))
                self.animals.remove(FindID.FindID.animalExists(Zoologic.animals,id))
            else:
                print("No se elimino ningun animal del sistema ")

