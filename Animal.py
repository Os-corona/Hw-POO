import datetime

class Animal:
    cont=1
    birthday="default"
    animal_Type="default"
    weight=0
    feeding_schedule="default"
    food_type="default"
    is_vaccinated=True
    diseases=[]
    ID=0

    def __init__(self, animal_Type, birthday, weight, disease, food_type, is_vaccinated, feeding_schedule):
        self.ID= str(Animal.cont).zfill(3)
        Animal.cont+=1
        self.animal_Type = animal_Type
        self.birthday = birthday
        self.weight =weight
        self.feeding_schedule=feeding_schedule
        self.food_type=food_type
        self.is_vaccinated= is_vaccinated
        self.Arrival_day= datetime.date.today().isoformat()
        self.diseases.append(disease)

    def print_diseases(self):
        print("Lista de Enfermedades: ")
        for disease in self.diseases:
                print (disease)

    def is_Vaccinated(self):
        print("Animal vacunado?: ",self.is_vaccinated)

    def getID(self):
        print("ID: ", self.ID)

    def Data(self):
        print("ID del animal: ",self.ID)
        print("Cumple: ",self.birthday)
        print("Tipo: ",self.animal_Type)
        print("Peso: ",self.weight)
        print("Comida: ",self.feeding_schedule)
        print("Vacuando: ",self.is_vaccinated)
        print("Tipo de comida: ",self.food_type)
        print("Dia de llegada: ",self.Arrival_day)

    def anm_id(self):
        self.ID