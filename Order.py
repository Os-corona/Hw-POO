import datetime


class Order:
 def __init__(self,employee,animal_ID,process,observations):
     self.employee = employee
     self.animal_ID= animal_ID
     self.process= process
     self.observations= observations
     self.date = datetime.date.today().isoformat()

 def orders_info(self):
    print("Empleado que la ejecuta: ", self.employee)
    print("ID del animal atendido: ", self.animal_ID)
    print("Proceso: ",self.process)
    print("Dia de ejecucion: ", self.date)
    