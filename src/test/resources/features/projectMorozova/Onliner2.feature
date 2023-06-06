 #author Julia Morozova
 @web @test
 Feature: Check Profile of Author of the most popular forum topic on Onliner
   As a user
   I want to check Profile of Author of the most popular forum topic on Onliner
   So that the page is successfully opened


   Scenario Outline: Check Profile of Author of the most popular forum topic on Onliner
     Given I am on screen Onlíner in application Onliner
     When I navigate to Поиск search on screen Onliner in application Onliner
     Then I assert I am on Поиск search on screen Onliner in application Onliner
     When I type Форум in search Поиск on screen Onliner in application Onliner
     When I switch to iframe on screen Onliner in application Onliner
     Then I assert I typed Форум on screen Onliner in application Onliner
     When I navigate на форуме section on iframe on screen Onliner in application Onliner
     Then I assert I am on на форуме section on screen Onliner in application Onliner
     When I get name on 1 topic on screen Onliner in application Onliner
     And I navigate on 1 topic on screen Onliner in application Onliner
     Then I assert I am on 1 topic on screen Topic theme in application Onliner
     When I get Id to the 1 message of Автор темы on screen Topic theme in application Onliner
     And I navigate to the 1 message of Автор темы on screen Topic theme in application Onliner
     Then I assert I am on screen Профиль in application Onliner
     And I assert ID on screen Профиль in application Onliner
     And I assert Ник and Подпись на Форуме on screen Профиль in application Onliner



     Examples:

       |  |
       |   |
