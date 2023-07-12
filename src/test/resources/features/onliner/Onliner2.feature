 #Author Julia Morozova
 @onliner

 Feature: Validate Navigation to Forum
   As a user
   I want to navigate to the forum page
   So that the corresponding forum page is successfully opened

   Scenario Outline: Validate Navigation to Forum
     Given I am on screen Onlíner in application Onliner
     When I set Поиск в Каталоге "Форум" on screen Onlíner in application Onliner
     Then I assert dialog Search is opened on screen Onlíner in application Onliner
     And I assert I am on tab в каталоге on dialog Search on screen Onlíner in application Onliner
     When I switch to tab на форуме on dialog Search on screen Onlíner in application Onliner
     Then I assert I am on tab на форуме on dialog Search on screen Onlíner in application Onliner
     When I click hyperlink <hyperlinkName> on dialog Search on screen Onlíner in application Onliner
     Then I assert I am on screen <hyperlinkName> in application Onliner

     Examples:
       | hyperlinkName                           |
       | Жилая недвижимость. Общие тенденции (9) |