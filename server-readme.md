
#Funktion und Installation der Datenbanken auf einem Windows 10 sublinux WSL2 via Docker
##Startet den Dockercontainer mit der Datenbank sakilia

Zuerst müssen wir in den folder moven mit dem command <code>cd </code>um den docker container 
für jeweils Oracle und Posqresql zu laden.<br>
*$container*       = bsp.: syntegris_sakila-oracle-19.9.tar.xz

<code>xzcat $container name | docker load</code>

Mit docker run starten wir den Container dies können wir im linux subsystem machen oder im windows terminal.

**Postgresql:**     <code> docker run -p 5432:5432 syntegris/sakila-postgresql:12.5</code>

**Oracle:**      <code>docker run -p 1512:1512 -p 5500:5500 syntegris/sakila-oracle:19.9</code>
>TCP/IP Port-Mapping aus dem Container: Der Port 5432 auf der IP-Adresse des Containers wird Dir auf Deine IP-Adresse 
des Hosts (Windows) gemappt "-p <local>:<container>" also "-p 5432:5432"
für Oracle ist der Port 1521 für JDBC wichtig, auf Port 5500 ist ein HTTP(S) Interface für einen "Enterprise Manager" light

###Docker commands für spielereien
Command | Benutzung
------------ | -------------
`docker ps` | gibt  die vorhanden Docker container zurück
`-d` | startet den container in Detached mode ("Das Terminal ist dann nach ausführung nicht mehr blockier")<br>Detached mode, shown by the option --detach or -d, means that a Docker container runs in the background of your terminal. It does not receive input or display output.
`docker run -d IMAGE`| führt ein docker image aus 
`docker stop container "id"`| beendet einen container


###Verbindung

Name|Daten
------------ | -------------
Logindaten| name sakila, benutztername<br> sakila pw sakila
Hostname| localhost oder auch eigene lokale Computer  Ip
Datenbank schema name|SID hsrm

* Unterschied zwischen Oracle sql datenbank tool und Postgresql SQL PLUS
    * Sind die Datenbankentools der jeweiligen Hersteller.
    * funktionieren nur unter dem jeweiligen Sql Datenbanken. 
