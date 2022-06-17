1.    PROJECT DESCRIPTION
=========================

Walk Walk! is an application designed to facilitate the interaction between dog owners and people who do not have dogs but have the time and desire to spend time with them.

One of the aims of the project was to make the interaction very intuitive in order to be usable for most of ranges of age. The dog owner only has to create an activity for its dog such as walking or running in a specific location and date. Then, another person can choose it if it is interesting for him/her and he/she accepts the date and time of the activity. Finally, they have the contact number of the other user in order to define the exact location and to have a conversation before the activity.

2.    TECHONOLOGIES USED
========================

The technologies used in this project for the backend are: Java, MySQL and Spring Boot Security.

3.    MODELS
============

\-          User: The model user is used for authentication and to save the user data.

\-          Activity: It is used to store activity data.

\-          Dogs: It is used to store dog data.

4.    SERVER ROUTES TABLE
=========================

\-          ACTIVITY

| **METHOD** | **ROUTE**                          | **DESCRIPTION**                                                   |
| ---------- | ---------------------------------- | ----------------------------------------------------------------- |
| **GET**    | /api/activities/{id}               | Get an activity found by id.                                      |
| **GET**    | /api/activities                    | Get all the activities.                                           |
| **GET**    | /api/myactivities/{creatorId}      | Get all the activities created by one user find by id.            |
| **GET**    | /api/chosenactivities/{assignedId} | Get all the activities assigned to a user find by id.             |
| **POST**   | /api/activities                    | Create one activity with a ResquesBody of ActivityDTO.            |
| **PUT**    | /api/activities/{id}               | Update one activity with a ResquesBody of ActivityWithoutDogsDTO. |
| **DELETE** | /api/activities/{id}               | Delete an activity found by id.                                   |

\-          DOG

| **METHOD** | **ROUTE**            | **DESCRIPTION**                              |
| ---------- | -------------------- | -------------------------------------------- |
| **GET**    | /api/dogs/{id}       | Get a dog found by id.                       |
| **GET**    | /api/dogs            | Get all the dogs.                            |
| **GET**    | /api/mydogs/{userId} | Get all the dogs from one user find by id.   |
| **POST**   | /api/dogs            | Create one dog with a ResquesBody of DogDTO. |
| **PUT**    | /api/dogs/{id}       | Update one dog with a ResquesBody of DogDTO. |
| **DELETE** | /api/ dogs /{id}     | Delete an dog found by id.                   |

\-          USER

| **METHOD** | **ROUTE**    | **DESCRIPTION**                                          |
| ---------- | ------------ | -------------------------------------------------------- |
| **POST**   | /auth/signup | Create a new user.                                       |
| **GET**    | /auth/verify | Authentication of the user by email using userVerifyDTO. |

5.    FUTURE WORK
=================

As future work the app could be further developed by creating a chat for greater interaction between owners and volunteers to walk dogs.

Another thing to implement would be a rating to evaluate the activities.

Finally, it would also be interesting if users could visit the profiles of other users. Showing the dogs that the user have, and all the information related with activities.

6.    RESOURCES
===============

Some of the resources used to improve the application have been:

\-          Trello: [https://trello.com/b/VWVadwtS/walk-walk-final-project](https://trello.com/b/VWVadwtS/walk-walk-final-project)

\-          The material provided in the classes.

\-          Other pages to find information:

o   [https://stackoverflow.com/](https://stackoverflow.com/)

o   [https://www.w3schools.com/](https://www.w3schools.com/)