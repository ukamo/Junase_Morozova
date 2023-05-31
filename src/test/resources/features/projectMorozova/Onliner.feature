 #author Julia Morozova
 #@web @test
 Feature: Add some product in Cart in application Onliner
   As a user
   I want to add a product in Cart in application Onliner
   So that the product is successfully added


   Scenario Outline: Add some product in Cart in application Onliner
     Given I am on screen Onlíner in application Onliner
     When I navigate to Каталог section on screen Onliner in application Onliner
     Then I assert I am on screen Каталог Onlíner in application Onliner
     When I navigate 3 sections Электроника -> Аудиотехника -> Наушники on screen Kaталог Onliner in application Onliner
     Then I assert I am on screen Наушники купить в Минске in application Onliner
     When I click on button Сравнение предложений for HONOR Choice Moecen Earbuds X3 Lite (международная версия) on screen Наушники Купить в Минске in application Onliner
     Then I assert I am on screen HONOR Choice Moecen Earbuds X3 Lite (международная версия) купить в рассрочку онлайн in application Onliner
     When I click on expanding window on screen Наушники купить в Минске in application Onliner
     And I gather price of item 1 on screen Наушники HONOR Choice Moecen Earbuds in application Onliner
     And I click on button with name В корзину by item number 1 on screen Наушники HONOR Choice Moecen Earbuds in application Onliner
     Then I assert Товар добавлен в корзину is presented on screen Наушники HONOR Choice Moecen Earbuds in application Onliner
     And I assert item price on screen Наушники HONOR Choice Moecen Earbuds in application Onliner
     When I click button Перейти в корзину on screen Наушники HONOR Choice Moecen Earbuds in application Onliner
     Then I assert I am on screen Корзина заказов in application Onliner
     And I assert label Наушники HONOR Choice Moecen Earbuds X3 Lite (международная версия) is present on screen Корзина заказов in application Onliner
     Examples:

       |  |
       |  |
