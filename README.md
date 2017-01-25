== README

About challenge:

    Java Web REST api: Implement single api REST to validate and process commands. 
                       The commands will order a robot over a limited cartesian space.

* Java version

    1.8.0
* Maven version
	
	3.3.9
* Dependencies

	JBoss and Wildfly
* Configuration

	nothing
* How compile and deploy

	mvn clean package test wildfly:deploy
	
* Services

	REST POST:
	
		http://.../RESTCCSenior/mars/{commands}
		
		   commands: M -> move
                   R -> rotate right
                   L -> rotate left
			         
		ex: http://localhost:8080/RESTCCSenior/mars/MMMLR



