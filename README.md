## dropbox-springboot

### MySQL
Execute the following queries in the MySQL database:
1. create table users(firstName varchar(25), lastName varchar(25), email varchar(25), pass varchar(25));

2. create table sharedFolders(id varchar(25), folderName varchar(50), email varchar(50), isStarred boolean, isDeleted boolean);

3. Change the password of the database in the mysql file of nodelogin routes to your password so that it will successfully connect to the database at runtime.


### Spring Boot
1. Open the project 'back-end' in the IDE
2. Configure the db settings with the local MySQL DB user
3. Build the project
4. Run the project


### Front-end
Go to 'front-end' folder in command prompt and execute following command:
1. npm install
2. npm start
