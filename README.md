**Spring Boot Book CRUD API**
_Overview_
This project is a Spring Boot REST API that manages a collection of books. It demonstrates the use of various HTTP methods (GET, POST, PUT, DELETE) to perform CRUD operations. The API is built with Spring Boot, using ResponseEntity for handling HTTP responses and Jackson for JSON serialization and deserialization.

_Features_
CRUD Operations: Create, Read, Update, Delete books.
Exception Handling: Proper handling of cases where books are not found or operations fail.
HTTP Status Codes: Returns appropriate HTTP status codes for different API outcomes.

_Technologies Used_
Spring Boot: For creating the REST API.
Spring Web: To handle web requests and RESTful web services.
H2 Database: An in-memory database used for testing purposes.
Jackson: For converting Java objects to JSON and vice versa.

Key Components
_ResponseEntity_
ResponseEntity is used to represent the entire HTTP response, including the status code, headers, and body.
It allows for full control over the HTTP response, making it easy to return appropriate status codes and handle errors gracefully.

_Examples:_
ResponseEntity.status(HttpStatus.CREATED).body(list);
ResponseEntity.status(HttpStatus.NOT_FOUND).build();
ResponseEntity.ok().body(book);

_JSON Annotations_
@JsonManagedReference: Used to handle the parent side of a bi-directional relationship in a JSON serialization. It prevents infinite recursion by marking the parent as the forward reference.

@JsonBackReference: Used on the child side of the relationship to indicate the back reference. This also prevents infinite recursion by omitting the child reference in the serialized JSON.

_API_ _Endpoints_
GET /books: Retrieve a list of all books.
GET /books/{id}: Retrieve a single book by its ID.
POST /books: Add a new book.
PUT /books/{id}: Update an existing book by its ID.
DELETE /books/{id}: Delete a book by its ID.
