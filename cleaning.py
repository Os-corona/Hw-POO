from product import Product

class Cleaning(Product):
    def __init__(self, name, import_date, price, stock, aroma):
        super().__init__(name, import_date, price, stock)
        self.aroma = aroma

    def getAroma(self):
        return self.aroma