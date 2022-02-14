 SafetyNet_Alerts-P5-OC
 
SafetyNet_Alerts  est une application Java backend qui donne des informations essentielles aux services d’urgence via une API RESTfull.

Par exemple, SafetyNet_Alerts peut fournir :
•Une liste des personnes dans un secteur couvert par une caserne de pompier lors d’un incendie
•Une liste de numéros de téléphone dans le secteur d'une caserne pour les alerter d'un événement climatique
•Fournir une liste des antécédents médicaux des personnes vivant aux adresses desservies par les services d’urgence du secteur

Exécution de l’application en local:
Il existe plusieurs façons d’exécuter l’application sur votre ordinateur en local: 
Une façon consiste à exécuter l'application à partir de votre IDE.
En ligne de command avec  Spring Boot Maven: mvn spring-boot:run

Accès et endpoints:
Après le démarrage de l’application, vous pouvez accéder à tous les points de terminaison de l’API REST avec l’URL :  
https://localhost:8080/{+ url choisi}                                                                         
Depuis votre navigateur ou un programme tel que Postman.

Vous trouverez ci-dessous la liste de tous les points de terminaison avec leurs descriptions et leurs utilisations:
Pour une meilleure organisation des Endpoints, ils se regroupent en deux sections : «Gestion de données »  et  «Urgences ».

Consultation de ces Endpoints avec GET:

http://localhost:8080/persons 

http://localhost:8080/firestations 

http://localhost:8080/medicalRecords 


Gestion de données: 
Pour gérer tous les endpoints avec (Post, Put, Delete) relatifs aux entités (Person, FireStation, MedicalRecord).

http://localhost:8080/person

Cet endpoint permet d’effectuer les actions suivantes via Post/Put/Delete avec HTTP :
● ajouter une nouvelle personne POST ;
● mettre à jour une personne existante: PUT /person/PrénomNom ;
● supprimer une personne DELETE /person/PrénomNom ;

http://localhost:8080/firestation 

Cet endpoint permet d’effectuer les actions suivantes via Post/Put/Delete avec HTTP :
● Ajout d'un mapping caserne/adresse ;
● Mettre à jour le numéro de la caserne de pompiers d'une adresse ;
● Supprimer le mapping d'une caserne ou d'une adresse.

http://localhost:8080/medicalRecord 

Cet endpoint permettra d’effectuer les actions suivantes via Post/Put/Delete HTTP :
● Ajouter un dossier médical ;
● Mettre à jour un dossier médical existant PUT /medicalRecord/PrénomNom ;
● Supprimer un dossier médical DELETE /medicalRecord/PrénomNom 

Urgences : pour consulter les endpoints relatifs aux URLs:

http://localhost:8080/firestation?stationNumber=<station_number> 

Cette url retourne une liste des personnes couvertes par la caserne de pompiers correspondante.
 Prénom, nom, adresse, numéro de téléphone, décompte du nombre d'adultes et du nombre d'enfants 
 
http://localhost:8080/childAlert?address=<address> 
Cette url retourne une liste d'enfants habitant à cette adresse.
Prénom, nom de famille de chaque enfant, son âge et une liste des autres membres du foyer.
  
http://localhost:8080/phoneAlert?firestation=<firestation_number> 
	
Cette url retourne une liste des numéros de téléphone des résidents desservis par la caserne de pompiers. 
  
http://localhost:8080/fire?address=<address> 
Cette url retourne la liste des habitants vivant à l’adresse donnée ainsi que le numéro de la caserne de pompiers la desservant. Nom, le numéro de téléphone, l'âge et les antécédents médicaux (médicaments, posologie et allergies) de chaque personne.
  
http://localhost:8080/flood/stations?stations= <a list of station_numbers>     
Cette url retourne une liste de tous les foyers desservis par la caserne. 							         
Nom, le numéro de téléphone et l'âge des habitants, antécédents médicaux.
  
http://localhost:8080/personInfo?firstName=<firstName>&lastName=<lastName> 
	
Cette url retourne le nom, l'adresse, l'âge, l'adresse mail et les antécédents médicaux (médicaments, posologie, allergies) de chaque habitant. 
  
http://localhost:8080/communityEmail?city=<city> 
	
Cette url retourne les adresses mail de tous les habitants de la ville.
	
  
SafetyNet_Alerts est développé avec la Stack Technique suivante :
	
● Sring Boot 2.6.2 ;
	Avec les dépendances: 
- Lombok : permet d’optimiser certaines classes ;
- Spring Web : pour exposer les endpoints ;
 		- Spring Data JPA : pour faire de la persistance de données
- Actuator : fournit plusieurs points de terminaison qui peuvent être utiles pour surveiller l'application.
	
● Maven ; 
	
● code versionné sur un repo Git ; 
	
● Des tests unitaires avec JUnit ;
	
● Une couverture de code mesurée avec la librairie JaCoCo ; 
	
  
Rapports :
	
Dans « target/site » Il y a « index.html »  en l’ouvrant dans le navigateur on peut consulter les rapports générer avec Maven et JUnit :
	
•	Rapport Surefire pour tous les tests unitaires.
	
•	Rapport JaCoCo pour couverture dans JUnit Tests.
