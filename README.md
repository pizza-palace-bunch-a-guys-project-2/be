# Pizza Palace

## Project Description
Pizza Palace is a Single Page Application designed to facilitate online pizza ordering. The first thing you'll see upon entering this SPA is a secure login portal, accompanied by a streamlined form for new users to utilize for account creation (with a confirmation email included upon completion of the form). Following successful login the user is taken to the menu, where they are greeted with an interactive set of items to build their ideal pizza-based meal. Users can view their selections in the cart, which conveniently pops out when a user clicks it's icon. When all is said and done and the User is happy with their order they can move to the checkout form asking for details to complete their order. After submitting the form the User will receive a confirmation email with their order information included inside.

## Technologies Used
* Java version 1.8
* Spring Boot version 2.5.6
* Spring Data version 2021.0.6
* PostgreSQL version 13
* AWS EC2
* AWS RDS
* Jenkins
* Log4j version 1.2.17
* JUnit version 5.7.0
* Mockito version 3.11.2

## Features
List of features ready:


## Getting Started
1. Prepare your database for work with back-end.
2. To upload this project you need to clone this repository using `git clone https://github.com/pizza-palace-bunch-a-guys-project-2/be.git`.
3. You need to add some environmental variables to your system:
    * name: `pizzadbURL`, value `jdbc:postgresql://{your DB URL}:{DB port}/{DB name}`.
    * name: `pizzadbUsername`, value `{DB user name}`.
    * name: `pizzadbPassword`, value `{DB user password}`.
    * name: `email_username`, value `{Gmail user name}`.
    * name: `email_password`, value `{Gmail user password}`.
4. The last two variables are responsible for the email sending feature and should use your Google email account. You need to allow [less secure app access](https://myaccount.google.com/lesssecureapps?pli=1&rapt=AEjHL4Okv_JjZPXs7s1zgmQQpxhfyZFLGFSf6SdfhbTqH94qPWX_UHjwCWMv1uk76Q7qoVpHIytCBOtv39nCyNDkP3Ewb_mepw) on your Gmail account.
5. Do not forget to reboot your machine after adding these variables.
6. Add this project to your Java IDE.
7. Update Maven dependencies in the project.
8. Run this project through Spring Boot.

## Usage
[The current project](http://menuitembucket.s3-website.us-east-2.amazonaws.com/) is running on the AWS S3 service.\
Don't forget to install [the application front end](https://github.com/pizza-palace-bunch-a-guys-project-2/fe).

## Contributors
* [Iaroslav Mokroguz](https://github.com/maustrauk)
* [James Jamison](https://github.com/Vapidjimbo)
* [MJ Jadeja](https://github.com/MJad98)
* [Eury Kim](https://github.com/EuryKim2)
* [Nick Parsley](https://github.com/nparsley)
* [Ray Roman](https://github.com/rainwater475)
## License
MIT License
