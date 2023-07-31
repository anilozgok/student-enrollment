## Student Enrollment System

### Requirements
* Docker: for installation
* Java 17+: for development

### Installation

You can directly run the project using docker-compose

```bash
docker compose up
```

### Databae Diagram

![db-diagram.png](img%2Fdb-diagram.png)

# API Endpoints

## Course Endpoints

### Save Course
- **URL:** `/api/course/save`
- **Method:** `POST`
- **Request Body:**

  | Field  | Type   | Description      |
    |--------|--------|------------------|
  | name   | string | Course Name      |
  | code   | string | Course Code      |
  | credit | int    | Course Credit    |

### Get All Courses
- **URL:** `/api/course/list`
- **Method:** `GET`

### Get Course By Code
- **URL:** `/api/course/by-code?code=COURSE01`
- **Method:** `GET`

### Update Course
- **URL:** `/api/course/update`
- **Method:** `POST`
- **Request Body:**

  | Field  | Type   | Description           |
    |--------|--------|-----------------------|
  | id     | long   | Course ID to update   |
  | name   | string | Updated Course Name   |
  | code   | string | Updated Course Code   |
  | credit | int    | Updated Course Credit |

### Delete Course
- **URL:** `/api/course/delete/{id}`
- **Method:** `POST`

## Enrollment Endpoints

### Enroll Student
- **URL:** `/api/enrollment/enroll`
- **Method:** `POST`
- **Request Body:**

  | Field      | Type | Description         |
    |------------|------|---------------------|
  | studentId  | long | Student ID          |
  | courseId   | long | Course ID to enroll |

### Get All Enrollments
- **URL:** `/api/enrollment/list`
- **Method:** `GET`

### Delete Enrollment
- **URL:** `/api/enrollment/delete/{id}`
- **Method:** `POST`

## Student Endpoints

### Register Student
- **URL:** `/register`
- **Method:** `POST`
- **Request Body:**

  | Field     | Type   | Description      |
    |-----------|--------|------------------|
  | username  | string | Student Username |
  | password  | string | Student Password |
  | email     | string | Student Email    |

### Login Student
- **URL:** `/login`
- **Method:** `POST`
- **Request Body:**

  | Field     | Type   | Description      |
    |-----------|--------|------------------|
  | username  | string | Student Username |
  | password  | string | Student Password |

### Create Student Profile
- **URL:** `/api/student/profile`
- **Method:** `POST`
- **Request Body:**

  | Field      | Type   | Description       |
    |------------|--------|-------------------|
  | studentId  | long   | Student ID        |
  | fullName   | string | Student Full Name |
  | address    | string | Student Address   |
  | age        | int    | Student Age       |

### Get All Students
- **URL:** `/api/student/list`
- **Method:** `GET`


