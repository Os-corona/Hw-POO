import datetime

class Client:
 cont = 1

 def __init__(self,name,Last_name,curp,birthday,age):
        self.name=name
        self.Last_name=Last_name
        self.curp = curp
        self.birthday= birthday
        self.age =age
        self.ID= str(Client.cont).zfill(3)
        Client.cont+=1
        self.Registration_date= datetime.date.today().isoformat()
        self.visits = 0

 def RegistrationDate(self):
    print("Dia de registro: ",self.Registration_date)

 def add_visit(self):
     self.visits+=1

 def getID(self):
    print("ID del cliente: ",self.ID)

 def Client_Info(self):
     print("ID del cliente: ",self.ID)
     print("Nombre: ", self.name)
     print("Apellido: ", self.Last_name)
     print("Edad: ", self.age)
     print("Curp: ", self.curp)
     print("Cumpleaños: ",self.birthday)
     print("Visitas: ", self.visits)
   
 def client_name(self):
     print("Nombre: ",self.name)
     print("Apellido: ",self.Last_name)
   
 def age_client(self):
     print("Edad del cliente: ",self.age)
   
 def visit_client(self):
     print("Visitas del cliente: ",self.visits)
 
 def client_visits(self):
     return self.visits

 def clnt_id(self):
     return self.ID
 
 def clnt_age(self):
     return self.age