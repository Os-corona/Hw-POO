import datetime

class Employee:
    cont = 1

    def __init__(self,name,Last_name,curp,birthday,salary,hours,rol,rfc):
        self.name=name
        self.Last_name=Last_name
        self.curp = curp
        self.birthday= birthday
        self.salary=salary
        self.hours= hours
        self.rol=rol
        self.rfc=rfc
        self.ID= str(Employee.cont).zfill(3)
        Employee.cont+=1
        self.First_Day_As_Worker= datetime.date.today().isoformat()

    def Employee_Info(self):
        print("ID del empleado: ",self.ID)
        print("Nombre: ", self.name)
        print("Apellido: ", self.Last_name)
        print("Curp: ", self.curp)
        print("Cumpleaños: ",self.birthday)
        print("Salario: ", self.salary)
        print("Horas de trabajo: ", self.hours)
        print("Rol: ", self.rol)
        print("RFC: ",self.rfc)

    def getID(self):
        print("ID de empleado: ", self.ID)

    def Frstday(self):
        print("Primer dia de trabajo: ", self.First_Day_As_Worker)
    
    def emplo_names(self):
        print("Nombre: ",self.name)
        print("Apellido: ",self.Last_name)
    
    def emp_id(self):
        self.ID
    
    def emp_name(self):
        return self.name,self.Last_name