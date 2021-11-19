# Project Two - Coffee Shop Application



## Project Description:

Coffee shop is a full-stack web application that allows a customer to order the different items. Customer can login with their ID to process the order or new customer can create a new user ID. Customar can also see their previous order. Store manager can track the order and process the order status accordingly.

## Technologies Used:
* Frontend
  * HTML, CSS, TypeScript, Angular CLI
* Frontend Test
  * Selenium, Cucumber

* Backend
  * Java 8, Maven, Spring Boot, Spring Data JPA, Spring MVC, Node.js
* Backend Test
  * Spring Test, JUnit, Mockito, Postman

* DataBase and Other Tools
  * PostgreSQL
  * IntelliJ, VSCode, DBeaver, GitLab, Trello

## Features:
* Customer can login before the order. If custoemr forget the password, can create a new password using required information. New customer can create a new login ID.
* Customer can oreder different items, add the ingredients if needed and also modify the order. Manu has all items with daily special item. Customer can also see the order history.
* Customer can see the cart with total price before they make the payment.
* Store Manager will be able to see all oders status with the order time and can process the order status from preparaiton to ready state.
* In the about page customer can learn about our coffee shop and contact page has different stores contact details.

To-Do list:
* Add more payment options, such as credit card, paypal.
* Third-Party delivery system.
* Images hosting on a Simple Storage Service.

## Roles/Responsiblities:
* Thomas Latham
  * Group Leader
  * Created backend and frontend for the Menu Feature
  * Performed full API, JUnit, and Cucumber testing through assigned Feature
  * Collaborated with Tutan on the Cart Feature
  * Established Git workflow for group version control for code
* Michael Than
  * Created backend and frontend for the Order Management Feature
  * Performed full API, JUnit, and Cucumber testing through assigned Feature
  * Created and tested functional navbar 
  * Created a landing page with functional carousel
* Chris Wang
  * Created backend and frontend for the login and create account Features
  * Performed full API, JUnit, and Cucumber testing through assigned Feature
  * Created forgot password feature; an implemented stretch goal
* Tutan Abegaz
  * Created backend and frontend for the cart feature
  * Performed full API, Junit, and Cucumber testing through assigned Feature
* Shamim Rahman
  * Created backend and frontend for the about us and contact us Features
  * Performed full API, Junit, and Cucumber testing through assigned Feature


## Getting Started
Clone this Repository to your local computer

```
git clone https://github.com/HuangyingruiWang/Coffee-shop-Order-Management-System.git

```

## Pre-Installed 
* [JDK](<https://www.oracle.com/java/technologies/downloads/#java8>)
  * Install the correct version of Java 8 for your computer system

* [DBeaver](<https://dbeaver.io/>)
  * Install the latest version of DBeaver.
  * Connect to Your AWS PostgreSQL Database.
  * Run my Backend/Project2.sql to generate all data entities and data.

* [IntelliJ](<https://www.jetbrains.com/idea/download/#section=windows>) + [Maven](https://maven.apache.org/download.cgi)
  * Install the latest version of IntelliJ and Maven. 
  * Extract Maven folder to your C drive.
  * Open the Backend/CoffeeShopApp folder on IntelliJ IDE, then right click on the project name -> Maven -> reload project. Then run the CoffeeShopAppApplication.

* [VSCode](<https://code.visualstudio.com/download>)
  * Install the latest version of VSCode.
  * Open the Frontend/CoffeeShopNG folder on VSCode, then on the VSCode Command Prompt type: 
```
npm install
ng serve
```

## Usage
1. Set Environment Variables for DB_URL, DB_USERNAME, DB_PASSWORD, DRIVE_PATH(for test purpose, the path of chromedriver.exe)
   * In Windows 10: click the start button on your keyboard or at the bottom left corner of your screen, type environment variables.
   * Click on the Edit the system environment variables. On the System Properties Window, click on the Environment Variables button. 
   * Under System variables, create new variables with the correct variable names from above, and variable values as your database-connection information.
   * You may also need to add those system environment variables into IntelliJ environment variables if you can not run the Java Application.
    * In your IntelliJ, under Run tag ->  Edit Configuration -> add those enviroment variables.
2. Run Sql on DBeaver.
3. Run backend Application on IntelliJ, and frontend application on VSCode.
4. Go to http://localhost:4200/ on your browser and start to log in.
5. You can find a user stories file at frontend/UserStories.rtf
## Data Entities

Name  | Description
------------- | -------------
User_Roles  |  Holds users roles information
Users  | Holds users personal information, and one reference to user_roles
User_Addresses  | Holds users addresses information, and a reference to users
Shops | Holds information of shops, like shop address
Item_Categories | Holds information about different item categories, for now there only drink and food
Menu_ Items | Holds all item information that will be display on the menu, and two reference to item_category and item_pic
Daily_Specials  | Holds daily specials information, and one reference to menu item
Ingredients | Holds ingredients information, like the ingredients name and cost
Pictures  |  Holds pictures of all items
Order_Statuses  | Holds order statuses information
Payment_Types  | Holds payment information
Orders  | Holds order information, like ordered time, and three references to order_statuses, users, payment_types
Order_items  | junction table between menu_items and orders
menu_item_ingredients  | junction table between menu_items and ingredients
Ingredient_Order_Items  | junction table between ingredients and order_items

## RESTful End Points
* Login Validation<br />
GET : `/login`
* Request the user information for the current login account<br />
GET : `/users`
* Request the existing username information from the database<br />
PUT : `/users`
* Request the update of password for an existing customer account<br />
POST : `/users`
* Request to create a new customer account<br />
POST : `/userAddresses`
* Request to create a new user address for an existing customer account<br />


## Contributors

> [![](https://avatars.githubusercontent.com/u/93598022?s=50&u=286e38d31512e4b5a6db46263ec2db7b7f17c01b&v=4)](https://github.com/HuangyingruiWang)
> [![](https://avatars.githubusercontent.com/u/66039997?s=50&v=4)](https://github.com/Tutanabg)
> [![](https://avatars.githubusercontent.com/u/60087485?s=50&v=4)](https://github.com/michaelthan24)
> [![](https://avatars.githubusercontent.com/u/32628434?s=50&v=4)](https://github.com/ThomasLatham)
> [![](https://avatars.githubusercontent.com/u/91092523?v=4&s=50)](https://github.com/shamimRevature)
