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
        while True:
            index = int(input("Ingrese el id del libro que desea rentar: ")) - 1
            if library[index].isRented:
                print("El libro ya esta rentado")
            else: break    
        library[index].setRented(True)
        library[index].setUser(self.name)
        self.booksRented.append(library[index])
        self.hasRented = True
        print(f"{self.name} ha rentado: {library[index].getName()} correctamente")

    def returnBook(self, library):
        i = 1
        if not self.booksRented:
            print("No cuenta con libros para devolver")
            return
        for book in self.booksRented:
            print("ID: ",i," Libro: ",book.name)
            i += 1
        ID = int(input("Ingrese el ID del libro que quiere devolver"))
        library[ID-1].setRented(False)
        library[ID-1].setUser("")
        self.booksRented.remove(self.booksRented[ID-1])
        if not self.booksRented:
            self.hasRented = False
        print("Ha devolvido correctamente el libro: ",library[ID-1].name)    

    def getName(self):
        return self.name

    def getLastName(self):
        return self.lastName

    def isHasRented(self):
        return self.hasRented

    def getBooksRented(self):
        return self.booksRented
