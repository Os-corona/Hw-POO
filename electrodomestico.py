from product import Product

class Electrodomestico(Product):
    def __init__(self, name, import_date, price, stock, energy_used):
        super().__init__(name, import_date, price, stock)
        self.energyUsed = energy_used

    def getEnergyUsed(self):
        return self.energyUsed