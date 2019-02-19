#Spring Boot App with H2 DB
	H2 is an open-source lightweight Java database. It can be embedded in Java applications or run in
	the client-server mode. Generally used for POC's,as it is embedded DB, hence it is not used for 
	production env.
	
#To enable the UI console for H2 DB
	spring.h2.console.enabled=true
	URL: http://<IP>:<port>/h2-console
	
	JDBC URL: jdbc:h2:mem:testdb

#Defining the schema and set up data
	The schema and set up/initial data could be defined with the help
	of sql files in the resources folder.
	Samples added: schema.sql &, data.sql

#To check the above
	Implement the run() method from CommandLineRunner in the main boot class:
	@Override
	public void run(String ...args) throws Exception {
        LOGGER.log(Level.INFO, () -> "Student id 10001 -> {}" + repository.findById(10001L));
        }
        
        Output: Student id 10001 -> {}Student [id=10001, name=ABC XYZ, passport=E1234567]
        Sample data created during start from the SQL files.
        
#Build and Run
	clean: gradle clean
	build: gradle build
	run app: gradle bootrun

  