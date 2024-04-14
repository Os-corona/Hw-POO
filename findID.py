class FindID:
    @staticmethod
    def clientExists(clients, id):
        for client in clients:
            if client.get_id().lower() == id.lower():
                return True
        return False

    @staticmethod
    def findClient(clients, id):
        for client in clients:
            if client.get_id().lower() == id.lower():
                return client
        return None

    @staticmethod
    def productExists(products, series_number):
        for product in products:
            if product.get_series_number().lower() == series_number.lower():
                if product.get_stock() <= 0:
                    print("\nNO HAY STOCK DE ESE PRODUCTO")
                    return False
                return True
        print("\nNO EXISTE EL NUMERO DE SERIE INGRESADO")
        return False

    @staticmethod
    def findProduct(products, series_number):
        for product in products:
            if product.get_series_number().lower() == series_number.lower():
                return product
        return None