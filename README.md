# SpringBoot_StudentManagementSystem

This project is a **Spring Boot** application for managing student information. The application includes functionalities for user registration, login, and CRUD operations on student data.

## Features

- **Register**: Users can register with a unique email ID.
- **Login**: Users can log in with their email and password.
- **Update Information**: Users can update their details.
- **Retrieve Information**: Users can fetch their details.
- **Validation**: Prevents duplicate accounts with the same email ID.

## Technologies Used

- **Spring Boot**: Backend framework
- **Spring Data JPA**: For database operations
- **Spring Security**: For authentication
- **H2 Database**: In-memory database for development
- **Maven**: Build automation tool
- **Jenkins**: CI/CD pipeline setup
- **AWS EC2**: Deployment environment

## Running the Application

1. Clone the repository:
```bash
git clone https://github.com/your-repo/student-management.git
```

2. Navigate to the project directory:
```bash
cd student-management
```

3. Build the application using Maven:
```bash
./mvnw clean package
```

4. Run the application:
```bash
java -jar target/student-management-0.0.1-SNAPSHOT.jar
```

5. Access the application at `http://localhost:8080`.

## API Endpoints

### User Management

- **Register**: `POST /api/students/register`
- **Login**: `POST /api/students/login`
- **Get Student Info**: `GET /api/students/{id}`
- **Update Student Info**: `PUT /api/students/{id}`

## Jenkins Deployment Pipeline

1. **Checkout Code**: Jenkins will fetch the latest code from the GitHub repository.
2. **Build Code**: Maven is used to build the project.
3. **Deploy to AWS**:
>4. Upload the JAR file to an EC2 instance.
>5. Start the application using `java -jar`.

### Jenkinsfile
The Jenkins pipeline script (`Jenkinsfile`) is included in the project.

## Future Enhancements

- Add user roles (e.g., admin, student).
- Integrate with a relational database like MySQL or PostgreSQL.
- Add unit and integration tests.

## Contributing

Feel free to fork this repository and create pull requests with your improvements.

## License

This project is licensed under the MIT License.
