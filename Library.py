from Book import book
class library:
    def __init__(self):
        self.users = []
        self.books = []

    def printUsers(self):
        i = 1
        has_rented = ""
        if not self.users:
            print("No hay usuarios registrados\n")
            return
        print("\t=====LISTA DE USUARIOS======")
        for user in self.users:
            has_rented = "Si" if user.hasRented else "No"
            print(f"ID: {i} | Nombre: {user.name} {user.lastName} | Ha rentado: {has_rented}")
            i += 1
        print()

    def printBooks(self):
        i = 1
        is_rented = ""
        if not self.books:
            print("No hay libros registrados\n")
            return
        print("\t=====LISTA DE LIBROS======")
        for book in self.books:
            is_rented = "Si" if book.isRented else "No"
            print(f"{i}. Libro: {book.name} | Autor: {book.author} | Esta rentado: {is_rented}")
            i += 1
        print()

    def printRentedBooks(self):
        i = 1
        if not self.books:
            print("No hay libros registrados\n")
            return
        print("\t=====LISTA DE LIBROS RENTADOS======")
        for book in self.books:
            if book.isRented:
                print(f"{i}. Libro: {book.name} | Autor: {book.author} | Lo rento: {book.user}")
                i += 1
        print()

    def printUsersWithBooks(self):
        i = 1
        if not self.users:
            print("No hay usuarios registrados\n")
            return
        print("\t=====LISTA DE USUARIOS QUE HAN RENTADO======")
        for user in self.users:
            if user.hasRented:
                print(f"{i}. Nombre: {user.name} {user.lastName}")
                print(f"\tLibros que ha rentado {user.name}: ")
                for book in user.booksRented:
                    print(f"\t\tLibro: {book.name} | Autor: {book.author}")
                i += 1
        print()
