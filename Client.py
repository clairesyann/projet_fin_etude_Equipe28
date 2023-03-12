import socket
 
def client_program():
    host = "172.16.104.95"
    port = 80  # socket server port number
    FILE_PATH = '/home/prj/projet_fin_etude_python/calcul.py'
 
    client_socket = socket.socket()  # instantiate
    client_socket.connect((host, port))  # connect to the server
 
    #message = input(" -> ")  # take input
 
    #while message.lower().strip() != 'bye':
    #    client_socket.send(message.encode())  # send message calcul.py
    #    data = client_socket.recv(1024).decode()  # receive response
    #    print('Received from server: ' + data)  # show in terminal
    #    message = input(" -> ")  # again take input
 
    filename = FILE_PATH.split('/')[-1]
    print(filename)
    #client_socket.send(filename.encode('utf-8'))
    client_socket.sendall((filename + '\n').encode('utf-8'))
 
    # Ouverture du fichier à envoyer en mode lecture binaire
    with open(FILE_PATH, 'rb') as f:
        #Lecture des données par morceaux de 1024 octets
        data = f.read(1024)
        while data:
            # Envoi des données au serveur
            client_socket.sendall(data)
            # Lecture du prochain morceau de données
            data = f.read(1024)
        print('Received file')
    client_socket.close() # close the connection
 
 
if __name__ == '__main__': client_program()

