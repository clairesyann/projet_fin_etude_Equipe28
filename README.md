![GitHub Language count](https://img.shields.io/github/languages/count/clairesyann/projet_fin_etude_Equipe28?color=green)
![GitHub language count](https://img.shields.io/static/v1?label=Licence&message=Apache&color=<blueviolet>?style=flat)
# Projet fin d'études

## Apache Web Server <img src="https://s1.qwant.com/thumbr/0x380/8/c/3f469124b8839c4325057de17950250c241700552d43d87fca433e5da4082f/apache-logo-3.png?u=https%3A%2F%2Flogodownload.org%2Fwp-content%2Fuploads%2F2018%2F03%2Fapache-logo-3.png&q=0&b=1&p=0&a=0" width="30" height="30">

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

```
http://server_ip
```

### Etape 4: Configuration de l'hôte Virtuel

Création d'une structure de repertoires

```
sudo mkdir /var/www/your_domain
```

Attribution de la propriété du répertoire 

```
sudo chown -R $USER:$USER /var/www/your_domain
```

Permission du propriétaire de lire, d'écrire et d'exécuter les fichiers, tout en n'accordant que des autorisations de lecture et d'exécution aux groupes et aux autres personnes.

```
sudo chmod -R 755 /var/www/your_domain
```

Création de la page index.html 

```
sudo nano /var/www/your_domain/index.html
```

Création du fichier de l'hôte virtuel

```
sudo nano /etc/apache2/sites-available/your_domain.conf
```

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

```
sudo a2ensite your_domain.conf
```

Désactiver le site par défaut défini dans 000-default.conf

```
sudo a2dissite 000-default.conf
```

Tester la configuration

```
sudo apache2ctl configtest
```

Redémarrer le serveur Apache

```
sudo systemctl restart apache2
```

## Installation de Python <img src="https://s2.qwant.com/thumbr/0x380/4/f/14e362337fd8418d4d017885110500c542b96203f0162148d92209aa4a2ec9/1200px-Python-logo-notext.svg.png?u=https%3A%2F%2Fimage.librewiki.net%2Fthumb%2Fc%2Fc3%2FPython-logo-notext.svg%2F1200px-Python-logo-notext.svg.png&q=0&b=1&p=0&a=0" width="30" height="30">

Mise à jour des paquets
```
sudo apt update
sudo apt -y upgrade
```
Vérification de la version de Python
```
python3 -V
```

## Installation de Java <img src="https://s2.qwant.com/thumbr/0x380/c/5/824ffc855e4b1882d9e05fc37196a3ed9d6a6f361f0037f540f7e8f3b797ed/java-14-logo-png-transparent.png?u=https%3A%2F%2Fcdn.freebiesupply.com%2Flogos%2Flarge%2F2x%2Fjava-14-logo-png-transparent.png&q=0&b=1&p=0&a=0" width="20" height="30">

### Installation du JRE et du JDK par défaut

Mise à jour des paquets
```
sudo apt update
```
Installation de l’environnement d’exécution Java par défaut (JRE)
```
sudo apt install default-jre
```

Vérification de la version de java
```
java -version
```

Installation du kit de développement Java (JDK) 
```
sudo apt install default-jdk
```
Vérification de la version du compilateur
```
javac -version
```

