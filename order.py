class Order:
    def __init__(self, name, products, totalPrice, date):
        self.name = name
        self.products = products
        self.totalPrice = totalPrice
        self.date = date

    def printProducts(self):
        for product in self.products:
            print("\t" + product)

    def getName(self):
        return self.name

    def getProducts(self):
        return self.products

    def getTotalPrice(self):
        return self.totalPrice

    def getDate(self):
        return self.date