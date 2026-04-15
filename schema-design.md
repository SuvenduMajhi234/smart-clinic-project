# Smart Clinic Management System - Database Design

## MySQL Database Schema

This document outlines the database structure for the Smart Clinic Management System.

### 1. Doctors Table
Stores information about the healthcare providers.
- `id` (INT, Primary Key, Auto Increment)
- `name` (VARCHAR)
- `specialization` (VARCHAR)
- `email` (VARCHAR, Unique)
- `available_times` (TEXT)

### 2. Patients Table
Stores information about the registered patients.
- `id` (INT, Primary Key, Auto Increment)
- `name` (VARCHAR)
- `email` (VARCHAR, Unique)
- `phone` (VARCHAR)

### 3. Appointments Table
Connects doctors and patients for scheduled visits.
- `id` (INT, Primary Key, Auto Increment)
- `doctor_id` (INT, Foreign Key referencing Doctors.id)
- `patient_id` (INT, Foreign Key referencing Patients.id)
- `appointment_time` (DATETIME)

### 4. Prescriptions Table
Stores treatment notes provided by doctors.
- `id` (INT, Primary Key, Auto Increment)
- `appointment_id` (INT, Foreign Key referencing Appointments.id)
- `medication` (TEXT)
- `instructions` (TEXT)

## Entity Relationship Diagram (ERD) Logic
- **Doctor to Appointment:** One-to-Many (One doctor has many appointments)
- **Patient to Appointment:** One-to-Many (One patient has many appointments)
- **Appointment to Prescription:** One-to-One (One appointment has one prescription)
