 #author Julia Morozova
 Feature: Add some product in Cart in application Onliner
   As a user
   I want to add a product in Cart in application Onliner
   So that the product is successfully added

   Scenario Outline: Add some product in Cart in application Onliner
     Given I am on screen Onliner in application Onliner
     When I navigate to Kaталог on screen Onliner in application Onliner
     Then I assert I am on screen Kaталог Onliner in application Onliner
     When I navigate to Электроника -> Аудиотехника -> Наушники on screen Kaталог Onliner in application Onliner
     Then I assert I am on screen Наушники Купить в Минске in application Onliner
     When I click button Сравнение Предложений for Наушники HONOR Choice Moecen Earbuds on screen Наушники Купить в Минске in application Onliner
     Then I assert I am on screen Наушники HONOR Choice Moecen Earbuds in application Onliner
     When I gather price of item 1 on screen Наушники HONOR Choice Moecen Earbuds in application Onliner
     And I click button В корзину for item 1 on screen Наушники HONOR Choice Moecen Earbuds in application Onliner
     Then I assert Товар добавлен в корзину is presented on screen Наушники HONOR Choice Moecen Earbuds in application Onliner
     And I assert item price on screen Наушники HONOR Choice Moecen Earbuds in application Onliner
     When I click button Перейти в корзину on screen Наушники HONOR Choice Moecen Earbuds in application Onliner
     Then I assert I am on screen Корзина заказов in application Onliner
     And I assert label Наушники HONOR Choice Moecen Earbuds  is present on screen Корзина заказов in application Onliner
    Examples:
     |  |