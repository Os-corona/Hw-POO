from Book import book
from Library import library
from User import user

libreria = library()
u1 = user("Oscar", "Corona")
libreria.users.append(u1)
b1 = book("IT", "Stephen King")
libreria.books.append(b1)
b2 = book("Don Quijote", "Miguel de Cervantes")
libreria.books.append(b2)
flag1 = True
flag = True
print("\tBIENVENIDO AL MENU DE LA BIBLIOTECA!!\n")
while flag1:
    print("=========================================")
    print("  Ingrese la opcion que desea realizar: ")
    print("\t1. Registrar Usuario")
    print("\t2. Registrar Libro")
    print("\t3. Iniciar Sesion")
    print("\t4. Listas")
    print("\t5. Cerrar programa")
    print("=========================================\n")
    opt = int(input())
    if opt == 1:
        print("Ingrese el nombre del nuevo usuario: ")
        name = input()
        print("Ingrese el apellido del nuevo usuario: ")
        lastName = input()
        user = user(name, lastName)
        libreria.users.append(user)
        print("Usuario "+name+" "+lastName+" ha sido agregado al sistema")
    elif opt == 2:
        print("Ingrese el nombre del libro: ")
        bname = input()
        print("Ingrese el autor del libro: ")
        author = input()
        newBook = book(bname, author)
        libreria.books.append(newBook)
    elif opt == 3:
        libreria.printUsers()
        print("Ingrese su ID para iniciar sesion: ")
        logIn = int(input())
        print("Bienvenido "+libreria.users[logIn-1].getName()+"!")
        flag = True
        while flag:
            print("============================")
            print("  Que desea realizar: ")
            print("\t1. Ver sus libros rentados")
            print("\t2. Rentar un libro")
            print("\t3. Devolver Libro")
            print("\t4. Cerrar sesion")
            print("============================")
            opt2 = int(input())
            if opt2 == 1:
                print("===== LIBROS RENTADOS POR: "+libreria.users[logIn-1].getName()+" =====")
                for books in libreria.users[logIn-1].getBooksRented():
                    print("Libro: " + books.getName() + " Autor: " + books.getAuthor())
                print()
            elif opt2 == 2:
                libreria.users[logIn-1].rentBook(libreria.books)
            elif opt2 == 3:
                libreria.users[logIn-1].returnBook(libreria.books)
            elif opt2 == 4:
                flag = False    
            else:
                print("Ingrese una opcion listada")
    elif opt == 4:
        print("Que lista desea ver: ")
        print("1. Lista de libros")
        print("2. Lista de usuarios")
        print("3. Lista de libros rentados")
        print("4. Lista de usuarios que han rentado")
        opt2 = int(input())
        if opt2 == 1:
            libreria.printBooks()
        elif opt2 == 2:
            libreria.printUsers()
        elif opt2 == 3:
            libreria.printRentedBooks()
        elif opt2 == 4:
            libreria.printUsersWithBooks()
        else:
            print("Ingreso una opcion incorrecta, intente de nuevo")
    elif opt == 5:
        print("Gracias por utilizar el sistema, Adios!")
        flag1 = False
    else:
        print("Ingrese una opcion correcta!")
        print()        