class Visit:
    cont=1
    visitors=[]
    def __init__(self,employee_in_charge,visitor,total_price,adults,children):
        self.employee_in_charge= employee_in_charge
        self.visitors.append(visitor)
        self.total_price= total_price
        self.adults=adults
        self.children =children
        self.ID=str(Visit.cont).zfill(3)
        Visit.cont+=1

    def visits_info(self):
        print("ID de la visita: ", self.ID)
        print("Empleado a cargo: ",self.employee_in_charge)
        print("Visitantes: ",self.visitors)
        print("Precio total de la visita: ", self.total_price)
        print("Adultos en la visita: ", self.adults)
        print("Niños en la visita: ",self.children)

    def print_visitors(self):
        print("Lista de visitantes:")
        for visitor in self.visitors:
            print(visitor)

    def visit_id(self):
        print("Id de la visita: ", self.ID )
    