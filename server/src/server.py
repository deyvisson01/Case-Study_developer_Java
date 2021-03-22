import socket
import json
import threading
import sys
# ------------------------> Global Variables <--------------------------------
listpersonSeller = list()
listbo = list()
listmsg = list()
dictRelationBO = dict()
dictRelationMsg = dict()
# ------------------------> Functions <--------------------------------

def StrToJson(msg):
    return json.loads(msg)

def setAll(msg):
    msgjson = StrToJson(msg)
    personSeller = PersonSeller()
    bo = OccurrenceBoletin()
    msgRequest = Message()
    personSeller.setPersonSeller(JSON_MSG=msgjson)
    bo.setOccurrenceBoletin(JSON_MSG=msgjson)
    msgRequest.setMessage(JSON_MSG=msgjson)
    return (msgRequest,bo,personSeller)

def MountMsg(Msg,BO,PersonSeller):
    print(BO.StatusCase)
    Newvic = PersonSeller()
    Newob = OccurrenceBoletin()
    NewMsg = Message()

    Newob = BO
    NewMsg = Msg
    Newvic = PersonSeller

    Newob.Person_Seller = Newvic
    NewMsg.boletin = Newob

    return NewMsg.ConvertObjectMessageToJSON()
# ------------------------> Class <------------------------------------


class SocketServer:
    def __init__(self,serverPort=2000,serverHost="127.0.0.1"):
        self.PortServer = serverPort
        self.HostServer = serverHost
        self.socket = socket.socket()
        self.socket.bind((self.HostServer,self.PortServer))
        self.socket.listen(5)
        pass

    def read(self,conn):
        msg=str()
        length_of_message = int.from_bytes(conn.recv(2), byteorder='big')
        msg = conn.recv(length_of_message).decode("UTF-8")
        return msg

    def send(self,msg,conn):
        conn.send(len(str(msg).encode("UTF-8")).to_bytes(2, byteorder='big'))
        conn.send(str(msg).encode("UTF-8"))


class PersonSeller:
    def __init__(self):
        self.Code = None
        self.Name = None
        self.CPF = None
        
        pass

    def setPersonSeller(self,JSON_MSG):
        self.Code = JSON_MSG["boletin"]["Person_Seller"]["Code"]
        self.Name = JSON_MSG["boletin"]["Person_Seller"]["Name"]
        self.CPF = JSON_MSG["boletin"]["Person_Seller"]["CPF"]
        pass

    def ConvertObjectPersonSellerToJSON(self):
        return json.dumps({"Code":self.Code,"Name":self.Name,"CPF":self.CPF})

class OccurrenceBoletin:
    def __init__(self):
        self.code_sale = None
        self.Person_Seller = None
        self.code_product = None
        self.cliente = None
        self.date_Of_Sale = None
        self.quantidade = None
        self.valor_Final = None
        pass

    def setOccurrenceBoletin(self,JSON_MSG):
        self.code_sale = JSON_MSG["boletin"]["code_sale"]
        self.Person_Seller = JSON_MSG["boletin"]["Person_Seller"]
        self.code_product = JSON_MSG["boletin"]["code_product"]
        self.cliente = JSON_MSG["boletin"]["cliente"]
        self.date_Of_Sale = JSON_MSG["boletin"]["date_Of_Sale"]
        self.quantidade = JSON_MSG["boletin"]["quantidade"]
        self.valor_Final = JSON_MSG["boletin"]["valor_Final"]
        pass

    def ConvertObjectOccurrenceBoletinToJSON(self):
        perseller = PersonSeller()
        perseller = self.Person_Seller

        return json.dumps({"code_sale":self.code_sale,"Person_Seller":perseller.ConvertObjectPersonSellerToJSON(),"code_product":self.code_product,"cliente":self.cliente,"date_Of_Sale":self.date_Of_Sale,"quantidade":self.quantidade,"valor_Final":self.valor_Final})


class Message:
    def __init__(self):
        self.MessageType = None
        self.requestId = None
        self.MethodReference = None
        self.MethodId = None
        self.arguments = None
        self.boletin = None
        pass

    def setMessage(self,JSON_MSG):
        self.MessageType = JSON_MSG["MessageType"]
        self.requestId = JSON_MSG["requestId"]
        self.MethodReference = JSON_MSG["MethodReference"]
        self.MethodId = JSON_MSG["MethodId"]
        self.arguments = JSON_MSG["arguments"]
        self.boletin = JSON_MSG["boletin"]
        pass

    def ConvertObjectMessageToJSON(self):
        bo = OccurrenceBoletin()
        bo = self.boletin
        return json.dumps({"MessageType":self.MessageType,"requestId":self.requestId,"MethodReference":self.MethodReference,"MethodId":self.MethodId,"arguments":self.arguments,"boletin":bo.ConvertObjectOccurrenceBoletinToJSON()})

# ------------------------> Functions Server <--------------------------------

def addPersonSeller(person):
    aux = True
    for vic in listpersonSeller:
        if(vic.Name==person.Name):
            aux=False
    if(aux):
        listpersonSeller.append(person)
    pass


def addBO(bo):
    listbo.append(bo)
    pass


def addMsg(msg):
    listmsg.append(msg)
    pass

def listPersonSeller():
    print("   >>   " + "Vitimas"+"   <<   ")
    for vic in listpersonSeller:
        print("    > "+str(vic.Name))
    pass


def listBO():
    print("   >>   " + "Vítimas <-> Acusados -> Nome do responsável pelo caso" + "   <<   ")
    for (key,value) in dictRelationBO.items():
        print("    >",str(value[0].Name)," <-> ",str(value[1].Name)," -> ",str(key.valor_Final))
    pass


def listMSG():
    print("   >>   " + "(Tipo da mensagem, ID da mensagem, Referência do método)" + "   <<   ")
    for msg in listmsg:
        print("    >",(msg.MessageType,msg.requestId,msg.MethodReference))
    pass


def listen():
    sc = SocketServer(serverPort=2008, serverHost="127.0.0.1")
    print("[SERVER OK]")
    while(True):
        (conn, addr) = sc.socket.accept()
        msg = sc.read(conn=conn)
        (mensagem, bo, pessoa_seller) = setAll(msg)
        addPersonSeller(pessoa_seller)
        addPersonAcc(pessoaAcc)
        addBO(bo)
        addMsg(mensagem)
        dictRelationBO[bo]= (pessoa_seller)
        dictRelationMsg[mensagem] = bo
        #sc.send(str(MountMsg(mensagem, bo, pessoa_seller, pessoaAcc)), conn=conn)
        conn.close()
    pass
# ------------------------> Switch Functions <--------------------------------
mapFuncServer = dict({1 : "BuscarBOVitima",2 : "BuscarBOVitima"})
def selectFunc(Msg):
    valmsg = Message()
    valmsg = Msg
    try:
        print(mapFuncServer[valmsg.requestId])
    except KeyError:
        print("Função não encontrada")
    pass

# ------------------------> Main <--------------------------------------------
thr = threading.Thread(target=listen)
thr.start()
print("[MENU OK]")
while(True):
    print("TESTE LISTENER SERVER")
    op = input("Digite: ")
    if(op=="1"):
        listPersonSeller()
    if (op == "2"):
        listPersonAcc()
    if(op=="3"):
        listBO()
    if(op=="4"):
        listMSG()
    if(op=="6"):
        listMSG()
