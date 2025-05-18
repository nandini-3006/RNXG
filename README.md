This project is a REST API developed using the Spring Boot framework, designed for robotics applications. 
It accepts requests in JSON format that include robot-related information along with starting and ending coordinates. 
The API processes these inputs using grid-based pathfinding algorithm to calculate the shortest path between the two points.
All request and response details, including the computed path, are stored in an in-memory H2 database. To ensure secure access, 
the API is protected using JWT (JSON Web Token) authentication, allowing only authorized and authenticated applications to access its endpoints. 
Each token is time-limited, enhancing the security by expiring after a predefined duration.
