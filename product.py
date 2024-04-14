import random

class Product:
    def __init__(self, name, import_date, price, stock):
        self.name = name
        self.importDate = import_date
        self.seriesNumber = '{:06d}'.format(random.randint(1, 999999))
        self.price = price
        self.stock = stock

    def getName(self):
        return self.name

    def setName(self):
        new_name = input("Cual sera el nuevo nombre del producto: ")
        self.name = new_name
        print("\n= SE HA MODIFICADO CORRECTAMENTE EL NOMBRE =")

    def getImportDate(self):
        return self.importDate

    def getSeriesNumber(self):
        return self.seriesNumber

    def getPrice(self):
        return self.price

    def setPrice(self):
        new_price = float(input("Cual sera el nuevo precio del producto: "))
        self.price = new_price
        print("\n= SE HA MODIFICADO CORRECTAMENTE EL PRECIO =")

    def getStock(self):
        return self.stock


    def changeStock(self):
        opt = input("\n|| Desea aumentar o disminuir el stock: ||").lower()

        while opt not in ['aumentar', 'disminuir']:
            print("\n||No ingreso una opcion correcta ingrese (aumentar) o (disminuir)! ||")
            opt = input().lower()

        if opt == "aumentar":
            stock_increase = int(input("\n|| Cuanto stock desea aumentar: ||"))
            while stock_increase <= 0:
                print("|| Cantidad menor o igual a 0, favor de ingresar una cantidad congruente! ||")
                stock_increase = int(input())
            self.stock += stock_increase
            print("\n=== SE HA AUMENTADO EL STOCK CON EXITO! ===")
        else:
            stock_decrease = int(input("\n|| Cuanto stock desea disminuir: ||"))
            while stock_decrease > self.stock:
                print("||Cantidad demasiado alta para disminuir, ingrese una menor cantidad: ||")
                stock_decrease = int(input())
            self.stock -= stock_decrease
            print("\n=== SE HA DISMINUIDO EL STOCK CON EXITO! ===")

    def reduceStock(self, amount):
        self.stock -= amount