# MovieBucket
MovieBucket is a JavaFX application integrated with SQLite to store favourite movies from user and display the list of stored movies when required. This project is done for Internship Screening Test for NJC Labs Ltd.  

---

# Installation Process

1. Download MovieBucket.zip from the repository.
2. Extract the ZIP File Downloaded.
3. Execute Command Prompt/Terminal from the extracted folder.
4. Run command `/bin/java -jar moviebucket-1.0-SNAPSHOT-jar-with-dependencies.jar`
5. Application will get started.

---

# Application Usage Demo
Checkout the MovieBucketScreenRecording.mp4 video in the github repository.

# Tools Used to build project
## 1. NetBeans IDE
## 2. Maven
## 3. JavaFX 
JavaFX is used as an alternative to Swing and it is easier to create GUI with the help of SceneBuilder and Layout XML Files (i.e) FXML files. Controller classes are created in accordance with the FXML files created and these Controllers handle events, make calls to Database Object for fetchinf/updating data.

## 4. SQLite Database
SQLite Database is the local database which is similar to local file inside Client's system.

---

# MVC Architecture
## Model
Model Classes of the Application are SQLiteDatabase.java and Movie.java. Movie.java is used to model the details of the movie as an object and this object is used as message envelope to pass data between SQLiteDatabase Object and other Controllers of the App. SQLiteDatabase plays vital role in SQLite Connection, executing queries on behalf of controller classes and this class is singleton as database access is an expensive process.

## View
There are three views in this Application and they are Primary.FXML, AddMovie.FXML and ListMovie.FXML. 
---
<img width="374" alt="Screenshot 2021-08-27 124244" src="https://user-images.githubusercontent.com/50790272/131127693-343a543b-8c60-4ed7-8f39-28d5cdb386a0.png">
Primary.FXML

---
<img width="375" alt="Screenshot 2021-08-27 124320" src="https://user-images.githubusercontent.com/50790272/131127729-0005fc1b-bcf6-481c-8f25-ecf7dd5c9e6c.png">
AddMovie.FXML

---
<img width="374" alt="Screenshot 2021-08-27 124420" src="https://user-images.githubusercontent.com/50790272/131127764-6772291c-763f-484f-8656-1cd0eadd0d69.png">
ListMovie.FXML

## Controller
Controller classes of the Application are App.java, PrimaryController.java, AddMovieController.java, ListMovieController.java. App.java is crucial as it handles navigation between different scenes and it manages the creation of other scenes and controller objects. ListMovieController.java handles search query and helps in filling up the table. AddMovieController.java validates the input from user with the help of Movie Object and it sends the form details when submit button is clicked.
