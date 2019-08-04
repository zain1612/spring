Lava Java, a coffee company wants to start a loyalty program. Called Lava Java Friends.

Friends database stored on a server and accessed via REST APIs.

API needs to do register new friend, find one or more friends, changed a friend, delete a friend.

Lesson 1: CRUD operations

We will follow Model View Controller design:

Model:
Friend

View:
Not building but we will use Postman

Controller:
Friend Controller with REST APIs

We will need a service too to work with the database
Service:
FriendService 

Lesson 2: Expand with search methods 
Implement byID
Implement firstName
Implement LastName

Lesson 3: JSON

Will be adding JSON properties to the friend model
Adding adress to the friend list
Then multiple addresses to a friend

Lesson 4: Error Handling

Added error handling on the update (PUT) method for friend
if friend exists -> update
else return bad request message

Addding error handling to the create (POST) method 
Using excpetionHandler annotation will stop creating empty friend and creating an error message class 
Move this to a controller exception handler class 
*if we get time -> validating a Java bean with the standard framework – JSR 380, also known as Bean Validation 2.0.

Final Unit -> Testing!!! 

Was going to do this first but we need to know spring first! TDD -> write test, implement till green, refatctor

Pyramid of testing. Units tests then Service Tests and then UI

JUnit: our test runner
Mockito: for mocking dependencies


Unit Tests: basic blocks 
FriendController 
Integeration test -> Controller - create and read friend
JPA test -> Service 


 

