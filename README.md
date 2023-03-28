# Projet fin d'études

## Apache Web Server 

### Etape 1 : Installer Apache

Mis à jour des paquets
```sudo apt update```

Installation le paquet apache2
```sudo apt install apache2```

### Etape 2 : Réglage du Pare-feu

Autoriser le traffic sur le port 80
```sudo ufw allow 'Apache'```

### Etape 3: Serveur Web

Accès au serveur web via le navigateur
```http://server_ip```