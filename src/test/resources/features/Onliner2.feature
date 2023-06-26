 #Author Julia Morozova
 @web

 Feature:
   Check Navigation to forum page
   As a user
   I want to validate navigation to forum page
   So that the corresponding forum page is successfully opened

   Scenario Outline: Check Navigation to forum page
     Given I am on screen Onlíner in application Onliner
     When I set Поиск в Каталоге "Форум" on screen Onliner in application Onliner
     Then I assert dialog Search is opened on screen Onliner in application Onliner
     And I assert I am on tab в каталоге on dialog Search on screen Onliner in application Onliner
     When I switch to tab на форуме on screen Onliner in application Onliner
     Then I assert I am on tab на форуме on dialog Search on screen Onliner in application Onliner
     When I click hyperlink <hyperlinkName> on screen Onliner in application Onliner
     Then I assert I am on screen <hyperlinkName> in application Onliner

     Examples:
       | hyperlinkName                           |
       | Жилая недвижимость. Общие тенденции (9) |