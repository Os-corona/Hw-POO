class user:
    def __init__(self, name, lastName):
        self.name = name
        self.lastName = lastName
        self.booksRented = []
        self.hasRented = False

    def rentBook(self, library):
        print("\t=====LISTA DE LIBROS======")
        for i, book in enumerate(library, start=1):
            print(f"{i}. Libro: {book.getName()} Autor: {book.getAuthor()}")
        index = int(input("Ingrese el id del libro que desea rentar: ")) - 1
        library[index].setRented(True)
        library[index].setUser(self.name)
        self.booksRented.append(library[index])
        self.hasRented = True
        print(f"{self.name} ha rentado: {library[index].getName()} correctamente")

    def getName(self):
        return self.name

    def getLastName(self):
        return self.lastName

    def isHasRented(self):
        return self.hasRented

    def getBooksRented(self):
        return self.booksRented
