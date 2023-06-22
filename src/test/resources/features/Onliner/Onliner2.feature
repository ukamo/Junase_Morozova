 #Author Julia Morozova
 #@web @test
 Feature: Check Profile of Author of the most popular forum topic on Onliner
   As a user
   I want to check Profile of Author of the most popular forum topic on Onliner
   So that the page is successfully opened


   Scenario Outline: Check Profile of Author of the most popular forum topic on Onliner
     Given I am on screen Onlíner in application Onliner
     When I set Поиск в Каталоге value Форум on screen Onliner in application Onliner
     Then I assert dialog Search on screen Onliner in application Onliner
     Then I assert I am on tab в каталоге on dialog Search on screen Onliner in application Onliner
     When I switch to tab на форуме on screen Onliner in application Onliner
     Then I assert I am on tab на форуме on dialog Search on screen Onliner in application Onliner
     When I click on hyperlink <hyperlinkName> on screen Onliner in application Onliner
     Then I assert I am on screen <hyperlinkName> in application Onliner

     Examples:

       | hyperlinkName                           |
       | Жилая недвижимость. Общие тенденции (9) |