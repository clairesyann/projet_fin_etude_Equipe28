# Projet fin d'études

## Apache Web Server 

### Etape 1 : Installation d'Apache

Mis à jour des paquets


```
sudo apt update
```

Installation du paquet apache2

```
sudo apt install apache2
```

### Etape 2 : Réglage du Pare-feu

Autoriser le traffic sur le port 80

```
sudo ufw allow 'Apache'
```

### Etape 3: Serveur Web

Accès au serveur web via le navigateur

```http://server_ip```

### Etape 4: Configuration de l'hôte Virtuel

Création d'une structure de repertoires

```
sudo mkdir /var/www/your_domain
```

Attribution de la propriété du répertoire 

```sudo chown -R $USER:$USER /var/www/your_domain```

Permission du propriétaire de lire, d'écrire et d'exécuter les fichiers, tout en n'accordant que des autorisations de lecture et d'exécution aux groupes et aux autres personnes.

```sudo chmod -R 755 /var/www/your_domain```

Création de la page index.html 

```sudo nano /var/www/your_domain/index.html```

Création du fichier de l'hôte virtuel

```sudo nano /etc/apache2/sites-available/your_domain.conf```

Configuration du fichier 

```
/etc/apache2/sites-available/your_domain.conf
<VirtualHost *:80>
    ServerAdmin webmaster@localhost
    ServerName your_domain
    ServerAlias www.your_domain
    DocumentRoot /var/www/your_domain
    ErrorLog ${APACHE_LOG_DIR}/error.log
    CustomLog ${APACHE_LOG_DIR}/access.log combined
</VirtualHost>
```
Activer le fichier

```sudo a2ensite your_domain.conf```

Désactive le site par défaut défini dans 000-default.conf

```sudo a2dissite 000-default.conf```

Tester la configuration

```sudo apache2ctl configtest```

Redémarrer le serveur Apache

```sudo systemctl restart apache2```

## Installation de Python 

```
sudo apt update
sudo apt -y upgrade
```
Vérification de la version
```
python3 -V
```