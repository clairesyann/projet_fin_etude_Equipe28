import socket
import subprocess
import sys
 
def server_program():
    server_socket = socket.socket()  # get instance
    server_socket.bind(('', 80))  # bind host address and port together
 
    # Attente de connexion avec un client
    server_socket.listen(2)
    print("En attente de connexion...")
    conn, address = server_socket.accept()  # accept new connection
    print("Connexion établie avec: " + str(address))
 
 
    while True:
        # receive data stream. it won't accept data packet greater than 1024 bytes
        data = conn.recv(1024).decode('utf-8')
 
        # Réception du nom de fichier à exécuter
        filename = data.split('\n')[0]
        print("Fichier à exécuter :", filename)
 
        # Ouverture du fichier en mode écriture binaire
        with open(filename, 'wb') as f:
        # Réception des données par morceaux de 1024 octets
            data = conn.recv(1024)
            while data:
                # Écriture des données dans le fichier
                f.write(data)
                # Réception du prochain morceau de données
                data = conn.recv(1024)
 
            f.close()
 
            print("Exécution du fichier...")
            result = subprocess.run(['python3', filename], capture_output=True)
            print("************************************************************************")
            print(filename)
            print("*************************************************************************")
            print(result.stdout.decode())
 
 
 
            if not data:
            # if data is not received break
                break
            #print("from connected user: " + str(data))
            #data = input(' -> ')
            #conn.send(data.encode())  # send data to the client
 
 
        conn.close()  # close the connection
 
if __name__ == '__main__':
    server_program()
