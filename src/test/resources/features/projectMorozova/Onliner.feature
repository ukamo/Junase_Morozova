 #Author Julia Morozova
 #@web

 Feature: Add some product in Cart in application Onliner
   As a user
   I want to add a product in Cart in application Onliner
   So that the product is successfully added

   Scenario Outline: Add some product in Cart in application Onliner
     Given I am on screen Onlíner in application Onliner
     When I navigate Каталог on screen Onliner in application Onliner
     Then I assert I am on screen Каталог Onlíner in application Onliner
     When I navigate Электроника -> Аудиотехника -> Наушники on screen Kaталог Onliner in application Onliner
     Then I assert I am on screen Наушники купить в Минске in application Onliner
     When I click button Сравнение предложений for <product name> on screen Наушники Купить в Минске in application Onliner
     Then I assert I am on screen <product name> купить в рассрочку онлайн in application Onliner
     And I assert popover <popover name> is displayed on screen <product name> in application Onliner
     When I click button Да, верно on popover <popover name> on screen <product name> in application Onliner
     Then I store price of item 1 on screen <product name> in application Onliner
     When I click button В корзину for item 1 on screen <product name> in application Onliner
     Then I assert sidebar is opened on screen <product name> in application Onliner
     And I assert header Товар добавлен в корзину is present on sidebar on screen <product name> in application Onliner
     And I assert item price on screen <product name> in application Onliner
     When I click button Перейти в корзину on screen <product name> in application Onliner
     Then I assert I am on screen Корзина заказов in application Onliner
     And I assert <product name> is present on screen Корзина заказов in application Onliner

     Examples:
       | product name                                               | popover name         |
       | HONOR Choice Moecen Earbuds X3 Lite (международная версия) | Ваш населенный пункт |