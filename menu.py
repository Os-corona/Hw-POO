
class Menu:
    @staticmethod
    def logIn(store):
        print("|| BIENVENIDO AL SISTEMA DE LA TIENDA! ||")
        print("\nPorfavor ingrese la contrasena para acceder al sistema: ")
        password = input()

        while password != "tienda123":
            print("\n|| Contrasena incorrecta, intente de nuevo: ||")
            password = input()

        print("\n|| Ha ingresado la contrasena correcta!! ||")
        Menu.firstMenu(store)

    @staticmethod
    def firstMenu(store):
        flag = True

        while flag:
            print("\n== QUE DESEA HACER EL DIA DE HOY ==")
            print("1. Registrar")
            print("2. Imprimir datos")
            print("3. Modificar productos")
            print("4. Eliminar")
            print("5. Realizar compra")
            print("6. Cerrar programa")

            opt = int(input())

            if opt == 1:
                Menu.register(store)
            elif opt == 2:
                Menu.prints(store)
            elif opt == 3:
                Menu.modify(store)
            elif opt == 4:
                Menu.delete(store)
            elif opt == 5:
                Menu.buyOrder(store)
            elif opt == 6:
                flag = False
                print("\n== GRACIAS POR USAR EL SISTEMA ==")
            else:
                print("Opcion ingresada incorrecta!")

    @staticmethod
    def register(store):
        flag = True

        while flag:
            print("\n== QUE DESEA REGISTRAR: ==")
            print("1. Producto")
            print("2. Cliente")
            print("3. Volver")

            opt = int(input())

            if opt == 1:
                store.registerProduct()
            elif opt == 2:
                store.registerClient()
            elif opt == 3:
                flag = False
            else:
                print("Opcion ingresada incorrecta!")

    @staticmethod
    def prints(store):
        flag = True

        while flag:
            print("\n== QUE DESEA IMPRIMIR: ==")
            print("1. Productos maquillaje")
            print("2. Productos comida")
            print("3. Productos limpieza")
            print("4. Productos electrodomesticos")
            print("5. Clientes")
            print("6. Compras")
            print("7. Volver al menu")

            opt = int(input())

            if opt == 1:
                store.printMakeup()
            elif opt == 2:
                store.printFood()
            elif opt == 3:
                store.printCleaning()
            elif opt == 4:
                store.printElectrodomestico()
            elif opt == 5:
                store.printClients()
            elif opt == 6:
                store.printOrder()
            elif opt == 7:
                flag = False
            else:
                print("Opcion ingresada incorrecta!")

    @staticmethod
    def modify(store):
        flag = True

        while flag:
            print("\n== QUE DESEA MODIFICAR ==")
            print("1. Productos")
            print("2. Clientes")
            print("3. Volver al menu")

            opt = int(input())

            if opt == 1:
                store.modifyProduct()
            elif opt == 2:
                store.modifyClient()
            elif opt == 3:
                flag = False
            else:
                print("Opcion ingresada incorrecta!")

    @staticmethod
    def delete(store):
        flag = True

        while flag:
            print("\n== QUE DESEA ELIMINAR ==")
            print("1. Productos")
            print("2. Clientes")
            print("3. Volver al menu")

            opt = int(input())

            if opt == 1:
                store.deleteProduct()
            elif opt == 2:
                store.deleteClient()
            elif opt == 3:
                flag = False
            else:
                print("Opcion ingresada incorrecta!")

    @staticmethod
    def buyOrder(store):
        print("\n== INGRESE LOS DATOS DE LA COMPRA ==")
        store.buyOrder()