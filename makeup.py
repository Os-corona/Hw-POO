from product import Product

class Makeup(Product):
    def __init__(self, name, import_date, price, stock, color):
        super().__init__(name, import_date, price, stock)
        self.color = color

    def getColor(self):
        return self.color