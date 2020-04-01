Web App

Prerequisites:- npm node.js

----If you do not have node.js, run the following command in you ternimal :- $ npm install

Installation Install all dependencies in package.json file. This can be done by navigating to the root directory in the command line interface and running the following command:

$ npm install

$ npm install express --save

$ npm install nodemon -g --save


Following things to be done in order to connect the WebApp to MySql :- Open mysql and run the following command :-

ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'Hardik-2010'
CREATE DATABASE WebApp
user WebApp
CREATE TABLE login( username varchar(255), password varchar(255) PRIMARY KEY (username) );
To run the application executue following commands :-
CREATE TABLE transactions( id varchar(255),tran_description varchar(255),transaction_date varchar(255), amount varchar(255),merchant varhcar(255), category varchar(255),username varchar(255), PRIMARY KEY (id) , FOREIGN KEY (username) REFERENCES login(username));

# To execute the application run any of the following command:-

node index or
npm start or
nodemon (recommended as it automatically restarts the node application when file changes in the directory)
-- Access API at: http://localhost:3000 
