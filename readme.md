> For this project, you will build an application using everything you’ve learned so far. You’ll start from scratch and finish with a working API of your own. This is your chance to showcase your skills to potential employers and teammates!

>We’ve provided the high-level tasks to complete this project, which includes a few new techniques you may have to research on your own. If you’d like to challenge yourself even further, keep building! This project can be extended in a variety of ways as you learn more Spring concepts.

#### Project Objectives:
---
* Construct a RESTful web API with data persistence using Spring and Spring Data JPA
* Use Spring Initializr to generate the initial Java project
Configure application properties for certain dependencies, including the H2 embedded database
* Define the entities that comprise this application scenario
*  Define the repositories that enable creating, updating, and querying these different entities
* Define the API contracts that will enable this application scenario
* Leverage the convenience of Lombok
* Use POSTMAN to test your API scenarios

**Prerequisites:**

1. [Java](https://www.java.com/es/)
2. [Spring](https://www.spring.io)
3. [curl](https://curl.se)

 > [***Spring Doc***](https://docs.spring.io/spring-framework/reference/overview.html "Spring Doc")

 > [***Spring initializr***](https://start.spring.io "Spring initializr")

***

# Define the data repositories
At this point, you should have defined your various entities that comprise our restaurant dining review app scenario. For this task, let’s provide you with more details about the different scenarios. This will help you identify the kind of queries you may need to make.

## 1. User entity-related scenarios:

* > As an unregistered user, I want to create my user profile using a display name that’s unique only to me.

* > As a registered user, I want to update my user profile. I cannot modify my unique display name.

* > As an application experience, I want to fetch the user profile belonging to a given display name.

* > As part of the backend process that validates a user-submitted dining review, I want to verify that the user exists, based on the user display name *associated with the dining review.

## 2. Dining review entity-related scenarios:

* > As a registered user, I want to submit a dining review.

* > As an admin, I want to get the list of all dining reviews that are pending approval.

* > As an admin, I want to approve or reject a given dining review.

* > As part of the backend process that updates a restaurant’s set of scores, I want to fetch the set of all approved dining reviews belonging to this restaurant.

## 3. Restaurant entity-related scenarios:

* > As an application experience, I want to submit a new restaurant entry. Should a restaurant with the same name and with the same zip code already exist, I will see a failure.

* > As an application experience, I want to fetch the details of a restaurant, given its unique Id.

* > As an application experience, I want to fetch restaurants that match a given zip code and that also have at least one user-submitted score for a given allergy. I want to see them sorted in descending order.

