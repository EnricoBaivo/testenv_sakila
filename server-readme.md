

Startet den Dockercontainer mit der Datenbank sakilia 
old
docker run -p 5432:5432 syntegris/sakila-postgresql:12.4
new
docker run -p
5432:5432 syntegris/sakila-postgresql:12.5


Port auf 5432

gibt  die vorhanden Docker container zurück

'docker ps'

syntegris/sakilia-postgresql:12.4 ist die nr---> 1e60255cb3a0

'docker exec -it syntegris/sakilia-postgresql:12.4 /bin/bash'

Detached mode, shown by the option --detach or -d, means that a Docker container runs in the background of your terminal. It does not receive input or display output.

'docker run -d IMAGE'

beeendet einen container
'docker stop container "id"'

keine ahung ? Messich ssh 
'psql -d hsrm -U postgre'

Start oracle container
'docker run -p 1512:1512 -p 5500:5500 syntegris/sakila-oracle:19.9'

Sqlplus starten um direkte Sql abfragen in der COnsole machen.
'sqlplus sakila/sakila@//localhost:1521/hsrm'


SQldeveloper  oracle datenbanken abfrage gui ?! 
Verbindung 

benutztername sakila
pw sakila
name sakila
Hostname localhost
Rolle Standard
port 1521
SID hsrm

Unterschied zwischen Oracle sql datenbank tool und Postgresql SQL PLUS
    - Sind die Datenbankentools der jeweiligen Hersteller.  
    - funktionieren nur unter dem jeweiligen Sql Datenbanken.


Ziel ist eigentlich ein Datenbankverbindung herzustellen über die jeweilge IDE
