# TP  -  Camel Twitter 

Travail avec l'IDE IntelliJ IDEA 13 - Projet Maven

## - Dépendances : pom.xml 

######Ajout de deux dépendances : 

- camel-twitter  : Support de base
- camel-stream : Support - [System.in, System.out, System.err] - Pour afficher dans la console

## - Classe principale : App.java

Remarque : Utilisation des clés du compte test 'cameltweet' dédiés aux tests.

- La classe extends de RouteBuilder
- Procédure configure() : On va configurer le composant Twitter, on lui attribuer les clés et ensuite on créer notre endpoint : 	 - Recherche : fromF("twitter://search?....,"mot-clé"") pour dire qu'on va rechercher dans twitter notre mot-clé
	 - Vers : .to("stream:out"); écrire dans la console


##### Documentations utiles : 

- Concernant les TwitterComponent(clé), les endpoints, URI options : http://camel.apache.org/twitter.html

Projet bien détaillé sur Github: 

- Concernant l'utilisation des clés et activation du main : 
https://github.com/apache/camel/blob/master/examples/camel-example-twitter-websocket/src/main/java/org/apache/camel/example/websocket/CamelTwitterWebSocketMain.java

- Concernant l'utilisation des endpoints - Twitter :
https://github.com/apache/camel/blob/master/examples/camel-example-twitter-websocket/src/main/java/org/apache/camel/example/websocket/TwitterWebSocketRoute.java
