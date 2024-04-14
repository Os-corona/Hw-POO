from food import Food
from makeup import Makeup
from electrodomestico import Electrodomestico
from cleaning import Cleaning
from client import Client

class Init:
    @staticmethod
    def init(store):
        food = Food("Pizza", "12-04-2024", 129.99, 5, 1050)
        store.getFoods().append(food)
        store.getProducts().append(food)

        makeup = Makeup("Labial", "11-03-2024", 30, 2, "Rojo")
        store.getMakeups().append(makeup)
        store.getProducts().append(makeup)

        electrodomestico = Electrodomestico("Microondas", "09-12-2023", 1600, 1, 35)
        store.getElectrodomesticos().append(electrodomestico)
        store.getProducts().append(electrodomestico)

        cleaning = Cleaning("Detergente", "05-02-2024", 40, 18, "Limon")
        store.getCleaningProducts().append(cleaning)
        store.getProducts().append(cleaning)

        client = Client("Oscar", "Corona", "Morelia, Michoacan", 18, 2999.99)
        store.getClients().append(client)

        client2 = Client("Samuel", "Villegas", "Tarimbaro, Michoacan", 18, 450)
        store.getClients().append(client2)