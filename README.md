# Healthcare Management Backend

A robust Spring Boot application designed to provide a secure and scalable infrastructure for healthcare providers. This system centralizes patient data management, document storage, and high performance scheduling through a modern cloud native architecture.

## Technical Stack

| Component | Technology | Rationale |
|-----------|------------|-----------|
| Framework | Spring Boot 3.4 | Provides a mature ecosystem for building production ready microservices with minimal configuration. |
| Language | Java 21 | Utilizes modern Java features including record types and improved performance for long running backend processes. |
| Security | Spring Security & OAuth2 | Implements industry standard authentication and authorization to protect sensitive medical records. |
| Database | MySQL (AWS RDS) | Offers a reliable relational storage solution with automated backups and high availability for patient records. |
| Caching | Redis | Implemented via the Cache Aside pattern to reduce database load and achieve sub 20ms retrieval for high traffic data. |
| File Storage | AWS S3 | Provides durable and scalable object storage with server side encryption for medical documents. |
| DevOps | Docker & GitHub Actions | Ensures consistent environment parity and automates CI CD pipelines for rapid deployment to Render. |

## API Endpoints

### Patient Management
- GET /api/patients: Retrieves a list of all patients (Cached).
- GET /api/patients/{id}: Retrieves details for a specific patient by ID (Cached).
- POST /api/patients: Registers a new patient record.
- PUT /api/patients: Updates an existing patient record.
- DELETE /api/patients/{id}: Removes a patient record from the system.

### S3 File Operations
- POST /s3/upload: Uploads a file to the configured S3 bucket with server side encryption.
- GET /s3/download/{fileName}: Securely retrieves a file from S3 as a downloadable resource.
- DELETE /s3/delete/{fileName}: Removes a file from the S3 storage.

## Environment Configuration

The application is configured to use environment variables for sensitive data and infrastructure endpoints. These should be set in the deployment environment or a local profile.

### Database Settings
- DB_HOST: The hostname of the MySQL RDS instance.
- DB_PORT: The port for the database connection (default 3306).
- DB_NAME: The name of the healthcare database.
- DB_USER: The database username.
- DB_PASSWORD: The database password.

### AWS Cloud Settings
- S3_BUCKET_NAME: The target AWS S3 bucket for document storage.
- AWS_REGION: The AWS region for S3 and other cloud services (e.g., us-east-1).
- AWS_ACCESS_KEY: Required if not using IAM roles.
- AWS_SECRET_KEY: Required if not using IAM roles.

### Redis Configuration
- REDIS_HOST: The endpoint for the Redis Cloud instance.
- REDIS_PORT: The port for Redis communication (default 6379).
- REDIS_PASSWORD: The authentication password for Redis.

### Security and Authentication
- GOOGLE_CLIENT_ID: The OAuth2 client identifier for Google authentication.
- GOOGLE_CLIENT_SECRET: The OAuth2 client secret for Google authentication.

## Execution

The system is designed to be built using Maven. The Dockerfile included in the root directory can be used to containerize the application for deployment.

```bash
mvn clean package
docker build -t healthcare-backend .
```
