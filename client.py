class Client:
    cont = 1

    def __init__(self, name, lastName, address, age, wallet):
        self.name = name
        self.lastName = lastName
        self.address = address
        self.age = age
        self.wallet = wallet
        self.timesBought = 0
        self.id = "{:03d}".format(Client.cont)
        Client.cont += 1

    def getId(self):
        return self.id

    def getName(self):
        return self.name

    def setName(self):
        name = input("Ingrese el nuevo nombre del cliente: ")
        lastName = input("Ingrese el nuevo apellido del cliente: ")
        self.name = name
        self.lastName = lastName
        print("\n= SE HA MODIFICADO EL NOMBRE CORRECTAMENTE =")

    def getLastName(self):
        return self.lastName

    def setLastName(self, lastName):
        self.lastName = lastName

    def getAddress(self):
        return self.address

    def setAddress(self, address):
        self.address = address

    def getAge(self):
        return self.age

    def setAge(self, age):
        self.age = age

    def getTimesBought(self):
        return self.timesBought

    def setTimesBought(self):
        buys = int(input("Ingrese el numero de compras del cliente: "))
        self.timesBought = buys
        print("\n= SE HAN MODIFICADO LAS COMPRAS CORRECTAMENTE =")

    def getWallet(self):
        return self.wallet

    def setWallet(self):
        wallet = float(input("Ingrese el nuevo saldo del cliente: "))
        self.wallet = wallet
        print("\n= SE HA MODIFICADO EL SALDO CORRECTAMENTE =")

    def reduceWallet(self, wallet):
        self.wallet -= wallet