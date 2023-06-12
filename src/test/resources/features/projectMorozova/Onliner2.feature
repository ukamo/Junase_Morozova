 #author Julia Morozova
 @web @test
 Feature: Check Profile of Author of the most popular forum topic on Onliner
   As a user
   I want to check Profile of Author of the most popular forum topic on Onliner
   So that the page is successfully opened


   Scenario Outline: Check Profile of Author of the most popular forum topic on Onliner
     Given I am on screen Onlíner in application Onliner
     When I click Поиск search on screen Onliner in application Onliner
     Then I assert I am on Поиск search on screen Onliner in application Onliner
     When I set Форум in search Поиск on screen Onliner in application Onliner
     Then I assert I am on tab в каталоге on screen Onliner in application Onliner
     When I switch to tab на форуме on iframe on screen Onliner in application Onliner
     Then I assert I am on tab на форуме on screen Onliner in application Onliner
     When I click on hyperlink <hyperlinkName> on screen Onliner in application Onliner
     Then I assert I am on screen <hyperlinkName> in application Onliner




     Examples:

       | hyperlinkName |
       | Жилая недвижимость. Общие тенденции (9)  |
