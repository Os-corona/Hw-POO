import getpass
import Zoo
class Systm:

    Zoo.Zoologic.employees
    Zoo.Zoologic.animals
    Zoo.Zoologic.clients
    Zoo.Zoologic.orders
    Zoo.Zoologic.visits

    password="ZOO/1"

    def system(self):
        c=0
        print("=====BIENVENIDO AL SISTEMA DEL ZOOLOGICO=====")
        print("Ingrese la contraseña del sistema")
        pass_input =input()
        while pass_input != self.password:
            c+=1
            if c==5:
                print("Demasiados intentos fallidos")
                break
            else:
                print("Contraseña incorrecta, intente de nuevo")
                pass_input= getpass.getpass("Ingresa la contraseña del sistema")

        print("Contraseña correcta, bienvenido!!")
        self.first_menu()

    def first_menu(self):
        flag= True
        while flag:
            print("==Que accion quiere realizar?==")
            print("1. Registrar")
            print("2. Consultar")
            print("3. Dirigir")
            print("4. Modificar")
            print("5. Cerrar programa")
            opt=int(input())

            if opt==1:
                self.register()
            elif opt==2:
                self.check()
            elif opt==3:
                self.manage()
            elif opt==4:
                self.modify()
            elif opt==5:
                flag= False
            else:
                print("Has ingresado un numero invalido")

    def register(self):
        flag=True
        print ("==SELLECIONASTE: REGISTRAR==")

        while flag:
            print("Que quieres registrar?")
            print ("1. Nuevo empleado")
            print("2. Nuevo animal")
            print("3. Nuevo cliente")
            print("4. Registrar visita")
            print("5. Regresar al menu")

            opt=int(input())

            if opt==1:
                Zoo.Zoologic.register_employee(self)
            elif opt==2:
                Zoo.Zoologic.register_animal(self)
            elif opt==3:
                Zoo.Zoologic.register_client(self)
            elif opt==4:
                Zoo.Zoologic.register_visit(self)
            elif opt==5:
                flag= False
            else:
                print(" Ingresaste un numero invalido")

    def check(self):
        flag =True

        print ("==SELLECIONASTE: REVISAR==")

        while flag:
            print("Que quieres revisar?")
            print ("1. Empleados")
            print("2. Animales")
            print("3. Visitantes")
            print("4. Visitas")
            print("5. Ordenes")
            print("6. Regresar al menu")

            opt=int(input())

            if opt==1:
                Zoo.Zoologic.print_employees(self)
            elif opt==2:
                Zoo.Zoologic.print_animals(self)
            elif opt==3:
                Zoo.Zoologic.print_clients(self)
            elif opt==4:
                Zoo.Zoologic.print_visits(self)
            elif opt==5:
                Zoo.Zoologic.print_orders(self)
            elif opt==6:
                flag= False
            else:
                print(" Ingresaste un numero invalido")

    def manage(self):
        print("==Seleccionaste: DIRIGIR==")
        Zoo.Zoologic.create_maintenance_order(self)

    def modify(zoologic):
        flag=True
        while flag:
            print("Que desea modificar: ")
            print("1. Cliente")
            print("2. Empleado")
            print("3. Animal")
            print("4. Volver al menu")

            opt=int(input())
            
            if opt==1:
                Zoo.Zoologic.modify_client(zoologic)
            elif opt==2:
                Zoo.Zoologic.modify_employee(zoologic)
            elif opt==3:
                Zoo.Zoologic.modify_animal(zoologic)
            elif opt==4:
                flag=False
            else:
                print("Opcion invalida")
                
    def delete(zoologic):
        flag=True
        while flag:
            print("Que desea eliminar: ")
            print("1. Cliente")
            print("2. Empleado")
            print("3. Animal")
            print("4. Volver al menu")
            opt=input()
            if opt==1:
                Zoo.Zoologic.delete_client(zoologic)
            elif opt==2:
                Zoo.Zoologic.delete_employee(zoologic)
            elif opt==3:
                Zoo.Zoologic.delete_animal(zoologic)
            elif opt==4:
                flag=False
            else:
                print("Opcion invalida")
    