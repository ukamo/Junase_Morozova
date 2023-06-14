 #author Julia Morozova
 @web @test
 Feature: Check Profile of Author of the most popular forum topic on Onliner
   As a user
   I want to check Profile of Author of the most popular forum topic on Onliner
   So that the page is successfully opened


   Scenario Outline: Check Profile of Author of the most popular forum topic on Onliner
     Given I am on screen Onlíner in application Onliner
     When I navigate search Поиск on screen Onliner in application Onliner
     Then I assert I am on search Поиск on screen Onliner in application Onliner
     When I set Форум on search Поиск on screen Onliner in application Onliner
     Then I assert I am on tab в каталоге on screen Onliner in application Onliner
     When I switch to на форуме tab on screen Onliner in application Onliner
     Then I assert I am on на форуме tab on screen Onliner in application Onliner
     When I click on hyperlink <hyperlinkName> on screen Onliner in application Onliner
     Then I assert I am on screen <hyperlinkName> in application Onliner




     Examples:

       | hyperlinkName |
       | Жилая недвижимость. Общие тенденции (9)  |
