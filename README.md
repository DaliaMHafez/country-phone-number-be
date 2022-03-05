## to start the application, plz run:
1- mvn clean install
2- mvn spring-boot:run

## to start the application usinf Docker, plz run:
1- docker-compose up

## Notes:
1- when running the app without docker, to be able to add customer plz first adjust next_val in sample.db to be 41 to be the correct next value

2- when running the app with docker, a new DB is created inside the container and hence initially the customers list page is empty but you can add data using add customer page

