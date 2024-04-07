import Client
import Employee
import Animal
import Visit
import Order
import Zoo

class Init:
    def __init__(self,zoo):
        diseases=[]
        visitants=[]

        visitants.append("Oscar Corona")
        visitants.append("Samuel Villegas")

    client1=Client.Client("Oscar","Corona","28-09-2005","AICO050928HMNLRRSA4",18)
    Zoo.Zoologic.clients.append(client1)

    client2=Client.Client("Samuel","Villegas","26-10-2005","   VICS051026HMNLRMA9",18)
    Zoo.Zoologic.clients.append(client2)

    client3=Client.Client("Natanael","Cano","25-03-2000","CTNC000225HMNLRMA5",23)
    Zoo.Zoologic.clients.append(client3)

    em1=Employee.Employee("Diego","Garcia","11-01-1991","A142TEDF34","GOLM910111HNMRTQE5",3500.00,"14:00-20:00","Veterinario")
    Zoo.Zoologic.employees.append(em1)

    em2=Employee.Employee("Alan","Perez","15-05-2000","P233PEDF45","PEAL000515HMNLRME6",2000.00,"12:00-20:00","Guia")
    Zoo.Zoologic.employees.append(em2)

    em3=Employee.Employee("Ricardo","Lopez","30-06-2002","R343GARY56","LORI020630HMNLRMA3",1000.00,"10:00-20:00","Mantenimiento")
    Zoo.Zoologic.employees.append(em3)
    
    em4=Employee.Employee("Luisa","Ruiz","02-11-1990","L344LURI87","RULIMMNLRMA2",1500.00,"11:00-17:00","Adminsitracion")
    Zoo.Zoologic.employees.append(em4)

    an1=Animal.Animal("Panda","22-12-2020",108.3,"Moquillo","Herbivoro",True,8)
    Zoo.Zoologic.animals.append(an1)

    an2=Animal.Animal("Camello","14-08-2019",130.6,"Ninguna","Herbivoro",True,12)
    Zoo.Zoologic.animals.append(an2)

    an3=Animal.Animal("Leon","01-01-2021",500.2,"Moquillo","Carnivoro",True,9)
    Zoo.Zoologic.animals.append(an3)

    v1= Visit.Visit("Ricardo Lopez",Visit.Visit.visitors,150,3,0)
    Zoo.Zoologic.visits.append(v1)

    v2= Visit.Visit("Oscar Maydon",Visit.Visit.visitors,200,3,2)
    Zoo.Zoologic.visits.append(v2)

    o1=Order.Order("Diego Garcia","001","veterinario","Se le dio medicina al animal")
    Zoo.Zoologic.orders.append(o1)
    