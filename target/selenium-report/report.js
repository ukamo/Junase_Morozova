$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/projectMorozova/Onliner.feature");
formatter.feature({
  "name": "Add some product in Cart in application Onliner",
  "description": "   As a user\n   I want to add a product in Cart in application Onliner\n   So that the product is successfully added",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@web"
    },
    {
      "name": "@test"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Add some product in Cart in application Onliner",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I am on screen Onlíner in application Onliner",
  "keyword": "Given "
});
formatter.step({
  "name": "I navigate to Каталог section on screen Onliner in application Onliner",
  "keyword": "When "
});
formatter.step({
  "name": "I assert I am on screen Каталог Onlíner in application Onliner",
  "keyword": "Then "
});
formatter.step({
  "name": "I navigate 3 sections Электроника -\u003e Аудиотехника -\u003e Наушники on screen Kaталог Onliner in application Onliner",
  "keyword": "When "
});
formatter.step({
  "name": "I assert I am on screen Наушники купить в Минске in application Onliner",
  "keyword": "Then "
});
formatter.step({
  "name": "I click on button Сравнение предложений for HONOR Choice Moecen Earbuds X3 Lite (международная версия) on screen Наушники Купить в Минске in application Onliner",
  "keyword": "When "
});
formatter.step({
  "name": "I assert I am on screen HONOR Choice Moecen Earbuds X3 Lite (международная версия) купить в рассрочку онлайн in application Onliner",
  "keyword": "Then "
});
formatter.step({
  "name": "I click on expanding window on screen Наушники купить в Минске in application Onliner",
  "keyword": "When "
});
formatter.step({
  "name": "I gather price of item 1 on screen Наушники HONOR Choice Moecen Earbuds in application Onliner",
  "keyword": "And "
});
formatter.step({
  "name": "I click on button with name В корзину by item number 1 on screen Наушники HONOR Choice Moecen Earbuds in application Onliner",
  "keyword": "And "
});
formatter.step({
  "name": "I assert Товар добавлен в корзину is presented on screen Наушники HONOR Choice Moecen Earbuds in application Onliner",
  "keyword": "Then "
});
formatter.step({
  "name": "I assert item price on screen Наушники HONOR Choice Moecen Earbuds in application Onliner",
  "keyword": "And "
});
formatter.step({
  "name": "I click button Перейти в корзину on screen Наушники HONOR Choice Moecen Earbuds in application Onliner",
  "keyword": "When "
});
formatter.step({
  "name": "I assert I am on screen Корзина заказов in application Onliner",
  "keyword": "Then "
});
formatter.step({
  "name": "I assert label Наушники HONOR Choice Moecen Earbuds X3 Lite (международная версия) is present on screen Корзина заказов in application Onliner",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        ""
      ]
    },
    {
      "cells": [
        ""
      ]
    }
  ]
});
formatter.scenario({
  "name": "Add some product in Cart in application Onliner",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@web"
    },
    {
      "name": "@test"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on screen Onlíner in application Onliner",
  "keyword": "Given "
});
formatter.match({
  "location": "web.steps.NavigationSteps.assertScreenInApplication(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to Каталог section on screen Onliner in application Onliner",
  "keyword": "When "
});
formatter.match({
  "location": "web.steps.NavigationSteps.navigateSection(java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I assert I am on screen Каталог Onlíner in application Onliner",
  "keyword": "Then "
});
formatter.match({
  "location": "web.steps.NavigationSteps.assertScreenInApplication(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate 3 sections Электроника -\u003e Аудиотехника -\u003e Наушники on screen Kaталог Onliner in application Onliner",
  "keyword": "When "
});
formatter.match({
  "location": "web.steps.NavigationSteps.navigateTabs(java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I assert I am on screen Наушники купить в Минске in application Onliner",
  "keyword": "Then "
});
formatter.match({
  "location": "web.steps.NavigationSteps.assertScreenInApplication(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on button Сравнение предложений for HONOR Choice Moecen Earbuds X3 Lite (международная версия) on screen Наушники Купить в Минске in application Onliner",
  "keyword": "When "
});
formatter.match({
  "location": "web.steps.BuyProductSteps.clickCompareOrdersByProductName(java.lang.String,java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I assert I am on screen HONOR Choice Moecen Earbuds X3 Lite (международная версия) купить в рассрочку онлайн in application Onliner",
  "keyword": "Then "
});
formatter.match({
  "location": "web.steps.NavigationSteps.assertScreenInApplication(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on expanding window on screen Наушники купить в Минске in application Onliner",
  "keyword": "When "
});
formatter.match({
  "location": "web.steps.BuyProductSteps.clickExpandingWindow(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I gather price of item 1 on screen Наушники HONOR Choice Moecen Earbuds in application Onliner",
  "keyword": "And "
});
formatter.match({
  "location": "web.steps.BuyProductSteps.gatherPriceByNumber(int,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on button with name В корзину by item number 1 on screen Наушники HONOR Choice Moecen Earbuds in application Onliner",
  "keyword": "And "
});
formatter.match({
  "location": "web.steps.BuyProductSteps.clickInBasketByPriceNumber(java.lang.String,int,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I assert Товар добавлен в корзину is presented on screen Наушники HONOR Choice Moecen Earbuds in application Onliner",
  "keyword": "Then "
});
formatter.match({
  "location": "web.steps.BuyProductSteps.assertMessageTextOnScreen(java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I assert item price on screen Наушники HONOR Choice Moecen Earbuds in application Onliner",
  "keyword": "And "
});
formatter.match({
  "location": "web.steps.BuyProductSteps.assertPriceOnScreen(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click button Перейти в корзину on screen Наушники HONOR Choice Moecen Earbuds in application Onliner",
  "keyword": "When "
});
formatter.match({
  "location": "web.steps.BuyProductSteps.clickButtonOnBasket(java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I assert I am on screen Корзина заказов in application Onliner",
  "keyword": "Then "
});
formatter.match({
  "location": "web.steps.NavigationSteps.assertScreenInApplication(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I assert label Наушники HONOR Choice Moecen Earbuds X3 Lite (международная версия) is present on screen Корзина заказов in application Onliner",
  "keyword": "And "
});
formatter.match({
  "location": "web.steps.BuyProductSteps.assertLabelInBasket(java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png", null);
formatter.after({
  "status": "passed"
});
});