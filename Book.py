class book:
    def __init__(self, name, author):
        self.name = name
        self.author = author
        self.isRented = False
        self.user = None

    def getName(self):
        return self.name

    def getAuthor(self):
        return self.author

    def setRented(self, rented):
        self.isRented = rented

    def setUser(self, user):
        self.user = user

    def isRented(self):
        return self.isRented

    def getUser(self):
        return self.user


