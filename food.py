from product import Product

class Food(Product):
    def __init__(self, name, importDate, price, stock, calories):
        super().__init__(name, importDate, price, stock)
        self.calories = calories

    def getCalories(self):
        return self.calories