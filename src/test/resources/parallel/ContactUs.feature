Feature: Contact Us feature

Scenario Outline: Contact us scenario with different set of data

Given User navigates to contact us page
When user fills the form from given "<SheetName>" and <RowNumber>
And user clicks on send button
Then It shows a successful message "Your message has been successfully sent to our team."

Examples:
|SheetName|RowNumber|
|ContactUs|0|
|ContactUs|1|
|ContactUs|2|
|ContactUs|3|
|ContactUs|4|
|ContactUs|5|
