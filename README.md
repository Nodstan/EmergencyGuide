# Routine Emergency Guide Service

# Overview

The Emergency Guide Service provides rapid guidelines for safety in various emergency situations, such as fire, flood, earthquake, and others.

It allows fetching and managing emergency response steps stored in MongoDB.

Setup Instructions (without Docker)

To run the service locally on your machine:

Make sure to have Java 21+ and Gradle installed and ensure MongoDB is running and accessible.

Then, in your project's root directory, run:

./gradlew bootRun


The application will start on:
 http://localhost:8091

# Docker Setup

Build the Docker Image

Run this in your terminal from the project root:

docker build -t emergencyguide-app .


Run the Container

docker run -p 8092:8091 emergencyguide-app


Note: If the port 8091 is already in use locally then map it to another one say 8092 as above.

Then visit:
http://localhost:8092/emergency/all

Overview of API Endpoints

GET /emergency/all — Retrieve all emergency situations

GET /emergency/{id} — Get specific emergency by ID

POST /emergency/add — Create a new emergency situation

PUT /emergency/update/{id} — Update an existing emergency

DELETE /emergency/delete/{id} — Delete an emergency situation

 MongoDB Collection
Collection Name: emergency_guide
Stores all emergency situation documents in the format:

{
"id": "6902cc423f58f945dd1d07d0",
"situation": "Fire",
"steps": 

[
"Call the emergency number (112 or 911)",
"Use fire extinguisher if it's safe",
"Evacuate the area immediately"
]
}