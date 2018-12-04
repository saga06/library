Projet Java EE de création d'un site web pour une bibliothèque. Ce projet a pour but de valider la formation openclassrooms expert JAVA EE

ATTENTION: ce projet ne contient pas de WS, il est seulement basé sur struts et spring. Pour accéder à "la suite de ce projet", merci de vous rendre sur le repo projet4-WS, qui lui intègre la SOA

Cloner le projet (git clone https://github.com/saga06/library.git)

Pré-requis : Liste des éléments nécessaire au projet :

JDK 8
PostgreSQL (des problèmes peuvent être rencontrés avec les versions anciennes, merci de télécharger la dernière version)
Maven
Tomcat Server
Création de la bdd :
Sous PGadmin, créer une bdd nommée p4
utiliser le backup présent à la racine du projet pour restaurer la structure et les données (il est aussi possible d'utiliser le bdd.sql présent, il n'y a qu'à lancer le script)
Configuration interne à l'application :

Configuration de l'accès à la bdd : modifier les identifiants présents dans le fichier : library\src\main\webapp\META-INF\context.xml
Démarrer l'application : il faut bien entendu au préalable faire un mvn package 
