Feature: Accout Page Feature
Background: 
      Given user has already logged into the application
      | username | password|
      |rajeevkumar.achari@gmail.com |KasiAppu003|

Scenario: Accout page title
        Given user is on the Accounts page
        When user gets the title of the page
        Then page title should be "My account - My Store"
@Skip
Scenario: Account section count
        Given user is on the Accounts page
        Then user gets account section
        |ORDER HISTORY AND DETAILS|
        |MY CREDIT SLIPS|
        |MY ADDRESSES|
        |MY PERSONAL INFORMATION|
        |MY WISHLISTS|
        |Home|
        And accounts section count should be 6
        
