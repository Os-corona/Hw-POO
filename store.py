import datetime
from cleaning import Cleaning
from food import Food
from makeup import Makeup
from electrodomestico import Electrodomestico
from client import Client
from findID import FindID
from order import Order

class Store:
    sc = input
    def __init__(self):
        self.makeups = []
        self.cleaningProducts = []
        self.electrodomesticos = []
        self.foods = []
        self.products = []
        self.clients = []
        self.orders = []

    def getClients(self):
        return self.clients

    def registerProduct(self):
        types = "comidaelectrodomesticomaquillajelimpieza"
        print("\nIngrese el nombre del producto: ")
        name = input()

        print("\nIngrese el precio: ")
        price = float(input())

        print("\nCual sera el stock inicial: ")
        stock = int(input())

        print("\nQue dia se importo el producto: ")
        importDate = input()

        print("\nQue tipo de producto sera: (Comida / Electrodomestico / Limpieza / Maquillaje)")
        type = input()

        while type.lower() not in types:
            print("\nTipo no reconocido por el sistema, ingrese uno valido: ")
            type = input()

        if type.lower() == "comida":
            print("\nCuales son las calorias del producto: ")
            calories = int(input())
            food = Food(name, importDate, price, stock, calories)
            self.foods.append(food)
            self.products.append(food)
        elif type.lower() == "electrodomestico":
            print("\nIngrese la energia que gasta: (En Watts)")
            energyUsed = float(input())
            electrodomestico = Electrodomestico(name, importDate, price, stock, energyUsed)
            self.electrodomesticos.append(electrodomestico)
            self.products.append(electrodomestico)
        elif type.lower() == "limpieza":
            print("\nQue aroma tiene el producto: ")
            aroma = input()
            cleaning = Cleaning(name, importDate, price, stock, aroma)
            self.cleaningProducts.append(cleaning)
            self.products.append(cleaning)
        elif type.lower() == "maquillaje":
            print("\nDe que color es el maquillaje: ")
            color = input()
            makeup = Makeup(name, importDate, price, stock, color)
            self.makeups.append(makeup)
            self.products.append(makeup)
        print("\n== SE HA REGISTRADO EL PRODUCTO CORRECTAMENTE ==")

    def registerClient(self):
        print("Ingrese el nombre del cliente: ")
        name = input()

        print("Ingrese el apellido del cliente: ")
        lastName = input()

        print("Ingrese la edad del cliente: ")
        age = int(input())

        print("Ingrese la direccion del cliente: ")
        address = input()

        print("Cual es el saldo del cliente: ")
        wallet = float(input())

        client = Client(name, lastName, address, age, wallet)
        self.clients.append(client)
        print("\n== SE HA REGISTRADO EL CLIENTE CORRECTAMENTE ==")

    def printMakeup(self):
        if not self.makeups:
            print("\n== NO HAY PRODUCTOS EN EL SISTEMA ==")
            return
        print("\n== LISTA DE PRODUCTOS DE MAQUILLAJE ==")
        for makeup in self.makeups:
            print(f"=== PRODUCTO {makeup.getSeriesNumber()}: ===")
            print(f"\tNombre: {makeup.getName()} Precio: {makeup.getPrice()} Fecha Importe: {makeup.getImportDate()}")
            print(f"\tStock: {makeup.getStock()} Color: {makeup.getColor()}")

    def printFood(self):
        if not self.foods:
            print("\n== NO HAY PRODUCTOS EN EL SISTEMA ==")
            return
        print("\n== LISTA DE PRODUCTOS DE COMIDA ==")
        for food in self.foods:
            print(f"=== PRODUCTO {food.getSeriesNumber()}: ===")
            print(f"\tNombre: {food.getName()} Precio: {food.getPrice()} Fecha Importe: {food.getImportDate()}")
            print(f"\tStock: {food.getStock()} Calorias: {food.getCalories()}")

    def printCleaning(self):
        if not self.cleaningProducts:
            print("\n== NO HAY PRODUCTOS EN EL SISTEMA ==")
            return
        print("\n== LISTA DE PRODUCTOS DE LIMPIEZA ==")
        for cleaning in self.cleaningProducts:
            print(f"=== PRODUCTO {cleaning.getSeriesNumber()}: ===")
            print(f"\tNombre: {cleaning.getName()} Precio: {cleaning.getPrice()} Fecha Importe: {cleaning.getImportDate()}")
            print(f"\tStock: {cleaning.getStock()} Aroma: {cleaning.getAroma()}")

    def printElectrodomestico(self):
        if not self.electrodomesticos:
            print("\n== NO HAY PRODUCTOS EN EL SISTEMA ==")
            return
        print("\n== LISTA DE PRODUCTOS ELECTRODOMESTICOS ==")
        for electrodomestico in self.electrodomesticos:
            print(f"=== PRODUCTO {electrodomestico.getSeriesNumber()}: ===")
            print(f"\tNombre: {electrodomestico.getName()} Precio: {electrodomestico.getPrice()} Fecha Importe: {electrodomestico.getImportDate()}")
            print(f"\tStock: {electrodomestico.getStock()} Watts: {electrodomestico.getEnergyUsed()}")

    def printClients(self):
        if not self.clients:
            print("\n== NO HAY CLIENTES EN EL SISTEMA ==")
            return
        print("\n== LISTA DE CLIENTES ==")
        for client in self.clients:
            print(f"=== CLIENTE {client.getId()}: ===")
            print(f"\tNombre: {client.getName()} {client.getLastName()} Edad: {client.getAge()} Direccion: {client.getAddress()} Compras Totales: {client.getTimesBought()} Saldo: {client.getWallet()}")

    def printOrder(self):
        if not self.orders:
            print("\n== NO HAY COMPRAS EN EL SISTEMA ==")
            return
        print("\n== LISTA DE COMPRAS ==")
        for order in self.orders:
            print(f"Cliente: {order.getName()} Precio Total: {order.getTotalPrice()} Fecha: {order.getDate()}")
            order.printProducts()

    def buyOrder(self):
        productNames = []
        totalPrice = 0

        if not self.clients:
            print("\n== NO HAY CLIENTES EN EL SISTEMA ==")
            return

        if not self.electrodomesticos and not self.makeups and not self.cleaningProducts and not self.foods:
            print("\n== NO HAY PRODUCTOS EN EL SISTEMA ==")
            return

        self.printClients()
        print("Quien va a realizar la compra: (Ingrese su ID)")
        id = input()

        while not FindID.clientExists(self.clients, id):
            print("\nID NO RECONOCIDO, INGRESE OTRO: ")
            id = input()
        client = FindID.findClient(self.clients, id)
        clientName = f"{FindID.findClient(self.clients, id).getName()} {FindID.findClient(self.clients, id).getLastName()}"

        if self.cleaningProducts:
            self.printCleaning()
        if self.electrodomesticos:
            self.printElectrodomestico()
        if self.foods:
            self.printFood()
        if self.makeups:
            self.printMakeup()

        while True:
            price = 0
            print("Ingrese el numero de serie de los productos que compro el cliente: (fin para salir)")
            seriesNumber = input()

            if seriesNumber.lower() == "fin":
                break
            if FindID.productExists(self.products, seriesNumber) and client.getWallet() >= FindID.findProduct(self.products, seriesNumber).getPrice():
                price = FindID.findProduct(self.products, seriesNumber).getPrice()
                productName = FindID.findProduct(self.products, seriesNumber).getName()
                FindID.findProduct(self.products, seriesNumber).reduceStock(1)
                productNames.append(productName)
                totalPrice += price
                client.reduceWallet(price)
                print("SE AGREGO EL PRODUCTO CORRECTAMENTE\n")
            elif client.getWallet() < FindID.findProduct(self.products, seriesNumber).getPrice():
                print("\nEL CLIENTE NO TIENE SUFICIENTES FONDOS PARA HACER LA COMPRA\n")
        if not productNames:
            print("\nNO SE PUDO REGISTRAR LA COMPRA, DEBIDO A QUE NO HAY PRODUCTOS")
            return
        date = datetime.date.today().strftime("%Y-%m-%d")
        order = Order(clientName, productNames, totalPrice, date)
        self.orders.append(order)
        print("\n== SE HA REGISTRADO LA COMPRA CORRECTAMENTE ==")

    def modifyProduct(self):
        if self.cleaningProducts:
            self.printCleaning()
        if self.electrodomesticos:
            self.printElectrodomestico()
        if self.foods:
            self.printFood()
        if self.makeups:
            self.printMakeup()

        print("Ingrese el numero de serie del producto a modificar: ")
        seriesNumber = input()

        while not FindID.productExists(self.products, seriesNumber):
            print("Ingrese el numero de serie del producto a modificar: ")
            seriesNumber = input()

        flag = True
        product = FindID.findProduct(self.products, seriesNumber)

        while flag:
            print("\nQue desea modificar: ")
            print("1. Nombre")
            print("2. Precio")
            print("3. Stock")
            print("4. Salir")

            opt = int(input())

            if opt == 1:
                product.setName()
            elif opt == 2:
                product.setPrice()
            elif opt == 3:
                product.changeStock()
            elif opt == 4:
                flag = False
            else:
                print("\nOpcion ingresada incorrecta!")

    def modifyClient(self):
        self.printClients()

        print("Ingrese el ID del cliente a modificar: ")
        id = input()

        while not FindID.clientExists(self.clients, id):
            print("\nIngrese el ID del cliente a modificar: ")
            id = input()

        flag = True
        client = FindID.findClient(self.clients, id)

        while flag:
            print("\nQue desea modificar: ")
            print("1. Nombre")
            print("2. Saldo")
            print("3. Numero de Compras")
            print("4. Salir")

            opt = int(input())

            if opt == 1:
                client.setName()
            elif opt == 2:
                client.setWallet()
            elif opt == 3:
                client.setTimesBought()
            elif opt == 4:
                flag = False
            else:
                print("\nOpcion ingresada incorrecta!")

    def deleteClient(self):
        self.printClients()

        print("Ingrese el ID del cliente a eliminar: ")
        id = input()

        while not FindID.clientExists(self.clients, id):
            print("\nIngrese el ID del cliente a eliminar: ")
            id = input()
        client = FindID.findClient(self.clients, id)
        print(f"\n== SE HA ELIMINADO A {client.getName().upper()} CORRECTAMENTE ==")
        self.clients.remove(client)

    def deleteProduct(self):
        types = "comidaelectrodomesticomaquillajelimpieza"

        print("\nQue tipo de producto desea eliminar: ")
        type = input()

        while type.lower() not in types:
            print("\nTIPO INCORRECTO, INGRESE OTRO")
            print("\nQue tipo de producto desea eliminar: ")
            type = input()

        if type.lower() == "comida":
            self.deleteFood()
        elif type.lower() == "electrodomestico":
            self.deleteElectrodomestico()
        elif type.lower() == "maquillaje":
            self.deleteMakeup()
        elif type.lower() == "limpieza":
            self.deleteCleaning()

    def deleteFood(self):
        self.printFood()
        print("Ingrese el numero de serie del producto a modificar: ")
        seriesNumber = input()

        while not FindID.productExists(self.products, seriesNumber):
            print("\nNUMERO INCORRECTO")
            print("\nIngrese el numero de serie del producto a modificar: ")
            seriesNumber = input()

        product = FindID.findProduct(self.products, seriesNumber)
        self.products.remove(product)
        self.foods.remove(product)
        print("\n== SE HA ELIMINADO CORRECTAMENTE EL PRODUCTO ==")

    def deleteCleaning(self):
        self.printCleaning()
        print("Ingrese el numero de serie del producto a modificar: ")
        seriesNumber = input()

        while not FindID.productExists(self.products, seriesNumber):
            print("\nNUMERO INCORRECTO")
            print("\nIngrese el numero de serie del producto a modificar: ")
            seriesNumber = input()

        product = FindID.findProduct(self.products, seriesNumber)
        self.products.remove(product)
        self.cleaningProducts.remove(product)
        print("\n== SE HA ELIMINADO CORRECTAMENTE EL PRODUCTO ==")

    def deleteElectrodomestico(self):
        self.printElectrodomestico()
        print("Ingrese el numero de serie del producto a modificar: ")
        seriesNumber = input()

        while not FindID.productExists(self.products, seriesNumber):
            print("\nNUMERO INCORRECTO")
            print("\nIngrese el numero de serie del producto a modificar: ")
            seriesNumber = input()

        product = FindID.findProduct(self.products, seriesNumber)
        self.products.remove(product)
        self.electrodomesticos.remove(product)
        print("\n== SE HA ELIMINADO CORRECTAMENTE EL PRODUCTO ==")

    def deleteMakeup(self):
        self.printMakeup()
        print("Ingrese el numero de serie del producto a modificar: ")
        seriesNumber = input()

        while not FindID.productExists(self.products, seriesNumber):
            print("\nNUMERO INCORRECTO")
            print("\nIngrese el numero de serie del producto a modificar: ")
            seriesNumber = input()

        product = FindID.findProduct(self.products, seriesNumber)
        self.products.remove(product)
        self.makeups.remove(product)
        print("\n== SE HA ELIMINADO CORRECTAMENTE EL PRODUCTO ==")

    def getMakeups(self):
        return self.makeups

    def getCleaningProducts(self):
        return self.cleaningProducts

    def getElectrodomesticos(self):
        return self.electrodomesticos

    def getFoods(self):
        return self.foods

    def getProducts(self):
        return self.products


