# Documentation für die Repositroys 
**Sakiladatenbankschema Bild**

![Sakiladatenbankschema](https://www.jooq.org/img/sakila.png)
## Meine abgebildeten Usecases

### Usecases
1. Kunde fragt den aktuell ausleihbaren (also nicht bereits verliehenen) Bestand in in seinem lokalen Store ab - in einer Paging Query, Sortierkriterien (Attribut und aufsteigend/absteigend) als Input-Parameter abfragen, z.B. Erscheinungsjahr DESC, Anzahl vorheriger Ausleihen DESC, Länge ASC

2. Ein neues Genre (Name? ;-) ) wird eingeführt, worunter alle Filme aus den Bereichen Horror, Thriller und Komödien fallen. Das neue Genre wird zusätzlich zu den bestehenden hinzugefügt (alle Filme behalten die bisherigen Genres und ein neues kommt potentiell hinzu).
### SQL

> <code>Select
> 
> film.film_id,
> film.title,
> film_category.film_id,
> film_category.category_id,
> category.category_id,
> category.name
> 
> FROM Film
> INNER JOIN
> Film_category
> ON Film.film_id = Film_category.film_id
> 
> INNER Join Category
> ON film_category.category_id = category.category_id
> 
> Where
>    Category.name = 'Horror'
> OR Category.name = 'Sci-Fi'
> OR Category.name = 'Action '</code>
### Relationale Algebra






##UseCases die abgebildet werden sollen
StoryId | Beschreibung | Implementor | definiert von
| -------- | -------- | -------- | --------|
|  3  | Ein Store legt einen neuen Kunden an (erster Request) und bucht dann dessen erste Ausleihe: (z.B.) drei über Film-ID angegebene Filme im Inventar auf diesen Kunden. | Benedikt | selbst |
|  4  | Das Erscheinungsjahr eines Films verschiebt sich auf das Folgejahr. | Benedikt | selbst|
|  5  | Liste mit Anzahl gemeinsamer Filme für beliebige Kombinationen von Regisseur und Schauspieler, absteigend sortiert nach dieser Anzahl, als Paging Query und zusätzlich für jede Kombi die Titel der chronologisch letzten (max.) drei gemeinsamen Filme | Benedikt | PO |
|  6  | Der Kunde kann Suchkriterien für Schauspieler (z.B. Teile des Vor/Nachnamens) und Filmkategorie angeben. Es werden dann in einer Paging Query jeweils alle Filme, wo die entsprechenden Schauspieler mitgespielt haben, plus jeweils zu jedem Film Titel, Erscheinungsjahr, Kategorie und die Schauspieler in den 2 oder 3 Hauptrollen (neben dem über den gesucht wurde) zurückgegeben. | Christoph | selbst |
|  7  | Ein Mitarbeiter wird entlassen und muss aus der DB entfernt werden. | Christoph | selbst |
|  8  | Gegeben die DVD mit einer gewissen Film-ID (die der unschlüssige Kunde an der Kasse in der Hand hält) als Inputparameter: Welche anderen Filme mit dem Hauptdarsteller dieses Films sind in der Filiale vorrätig (ohne Paging, da Listenlänge zu klein...)? | Christoph | PO |
|  9  | Kunde fragt den aktuell ausleihbaren (also nicht bereits verliehenen) Bestand in in seinem lokalen Store ab - in einer Paging Query, Sortierkriterien (Attribut und aufsteigend/absteigend) als Input-Parameter abfragen, z.B. Erscheinungsjahr DESC, Anzahl vorheriger Ausleihen DESC, Länge ASC | Enrico | selbst |
|  10  | Ein neues Genre (Name? ;-) ) wird eingeführt, worunter alle Filme aus den Bereichen Horror, Thriller und Komödien fallen. Das neue Genre wird zusätzlich zu den bestehenden hinzugefügt (alle Filme behalten die bisherigen Genres und ein neues kommt potentiell hinzu). | Enrico | selbst |
|  11  | Ein Film - gegeben als Film-ID - wird "auf den Index gesetzt", also verboten, und darf nicht mehr verliehen werden. Alte Ausleihen sind davon nicht betroffen, aber die aktuelle Ausleihe wird abgebrochen, der Kunde muss die DVD zurückbringen und erhält im Gegenzug das Geld für die Ausleihe zurückgebucht (neue negative Gegenbuchung) | Enrico | PO |
|  12  | Im Zuge des Untergangs der Videotheken muss eine Filiale schließen. Das Inventar dieser Filiale wird auf die anderen Filialen verteilt, wobei Filialen, die einen bestimmten Film bislang nicht im Inventar geführt haben, gegenüber solchen, in denen der Film sonst mehrfach vorhanden wäre, bevorzugt werden. Die Daten zu Kunden und Ausleihvorgängen müssen aus buchhalterischen Erfordernissen in der Datenbank erhalten bleiben. | Erik | selbst |
|  13  | Ein Kunde zieht um und ändert seine Adresse. (Achtung: Die alte Adresse darf nicht geupdated werden, da sie wegen 1:n Beziehung Beziehung zu anderen Kunden oder Stores stehen könnte, sondern eine neue muss angelegt werden!) | Erik | selbst |
|  14  | Für die Eingabeparameter Beginn und Ende eines Zeitraums und ggf. Filiale/Store die Liste (inkl. Paging) der umsatzstärksten Filme während dieses Zeitraums, gruppiert nach Genres (und falls in den Suchkriterien angegeben) Filiale | Erik | PO |



> Dummerweise war die Spalte **ACTIVE** in den originalen Saklia-Images der jOOQ sowohl immerhalb des Schemas in den Tabellen **CUSTOMER** und **STAFF** als auch zwischen den beiden RDBMS aktuell unterschiedlich und vor allem inkonsistent umgesetzt:
> 
> * **PostgreSQL**: CUSTOMER: gleich zwei Spalten - <del>activebool</del> BOOLEAN, active INTEGER, sowie auf Tabelle STAFF: active BOOLEAN
> * **Oracle**: CUSTOMER: active CHAR(1) und STAFF: active SMALLINT
> 
> Wir vereinheitlichen diese Spalten auf jeweils eine Spalte **ACTIVE** vom Typ **BOOLEAN** (für PostgreSQL) bzw. **NUMBER(1)** (für Oracle). Entsprechend angepasste Sakila-Docker-Images für PostgreSQL und Oracle stehen ab sofort zur Verfügung:
> * [link to postres Db container](https://gitlab.cs.hs-rm.de/graalvm-wp-ws20_21/docker-images/-/tree/master/databases/postgresql/12.5/sakila)
> * [link to Oracle Db container](https://gitlab.cs.hs-rm.de/graalvm-wp-ws20_21/docker-images/-/tree/master/databases/oracle/19.9/sakila)
> 
> Zudem hat auch die Tabelle **INVENTORY** eine Spalte **ACTIVE** vom Typ **BOOLEAN** (PostgreSQL) bzw. **NUMBER(1)** für Oracle hinzubekommen (so wie STAFF und CUSTOMER), damit man auch abbilden kann, ob ein Film aktuell aktiv ausleihbar ist oder nicht (z.B. DVD beschädigt, oder Film aus dem Programm genommen) - sonst lassen sich einige Use Cases nicht sinnvoll durchführen/abbilden.
