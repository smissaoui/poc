# README

Ce projet permet de lire un fichier fournit en entrée et le filtrer selon un ou plusieurs filtres fournits en paramètre du programme.
Le programme peut etre lancé de la manière suivante :

java -jar poc-0.0.1-SNAPSHOT.jar [chemin fichier entrée] [filtre1] [filtre2]...[filtre n]

Le programme attend au moins deux arguments en entrée, sinon il lancera une Exception de type InputParametersException.

