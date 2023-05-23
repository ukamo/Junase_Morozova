$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/projectMorozova/OnlinerExample.feature");
formatter.feature({
  "name": "As an user",
  "description": "  I want to get ability to add any good in basket",
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
  "name": "Add good in basket",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "the user opens Onliner website",
  "keyword": "Given "
});
formatter.step({
  "name": "the user asserts Oniner website",
  "keyword": "Then "
});
formatter.step({
  "name": "the user clicks on Catalog section \"Каталог\"",
  "keyword": "When "
});
formatter.step({
  "name": "the user asserts Catalog section",
  "keyword": "Then "
});
formatter.step({
  "name": "the user clicks on Catalog Classifier \"Электроника\"",
  "keyword": "When "
});
formatter.step({
  "name": "the user asserts Catalog Classifier \"Электроника\"",
  "keyword": "Then "
});
formatter.step({
  "name": "the user clicks on Section Item Catalog \"Аудиотехника\"",
  "keyword": "When "
});
formatter.step({
  "name": "the user asserts on Section Item Catalog",
  "keyword": "Then "
});
formatter.step({
  "name": "the user clicks on Product Link \"Наушники\"",
  "keyword": "When "
});
formatter.step({
  "name": "the user asserts on Product Link \"Наушники\"",
  "keyword": "Then "
});
formatter.step({
  "name": "the user clicks on Price Item Offer \"AirPods 2 в зарядном футляре\"",
  "keyword": "When "
});
formatter.step({
  "name": "the user asserts on Price Item Offer \"AirPods 2 в зарядном футляре\"",
  "keyword": "Then "
});
formatter.step({
  "name": "the user clicks on Add in Basket by First 1 Price",
  "keyword": "When "
});
formatter.step({
  "name": "the user asserts on Price",
  "keyword": "Then "
});
formatter.step({
  "name": "the user clicks on Basket button",
  "keyword": "When "
});
formatter.step({
  "name": "the user asserts on Basket page",
  "keyword": "Then "
});
formatter.step({
  "name": "the user asserts that the product is in Basket \"Наушники Apple AirPods 2 в зарядном футляре\"",
  "keyword": "When "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "username",
        "ap name",
        "ap group id",
        "ap artifact id",
        "ap version id"
      ]
    },
    {
      "cells": [
        "admin",
        "TEST Automation Process",
        "com.iba.samples.ap",
        "kanclerrpa-invoiceplane-ap",
        "2.6.0-SNAPSHOT"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Add good in basket",
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
  "name": "the user opens Onliner website",
  "keyword": "Given "
});
formatter.match({
  "location": "web.steps.OnlinerExampleSteps.assertScreens()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user asserts Oniner website",
  "keyword": "Then "
});
formatter.match({
  "location": "web.steps.OnlinerExampleSteps.theUserAssertsOninerWebsite()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on Catalog section \"Каталог\"",
  "keyword": "When "
});
formatter.match({
  "location": "web.steps.OnlinerExampleSteps.theUserClicksOnCatalogSection(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user asserts Catalog section",
  "keyword": "Then "
});
formatter.match({
  "location": "web.steps.OnlinerExampleSteps.assertsCatalogSection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on Catalog Classifier \"Электроника\"",
  "keyword": "When "
});
formatter.match({
  "location": "web.steps.OnlinerExampleSteps.clicksOnCatalogClassifier(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user asserts Catalog Classifier \"Электроника\"",
  "keyword": "Then "
});
formatter.match({
  "location": "web.steps.OnlinerExampleSteps.theUserAssertsCatalogClassifier(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on Section Item Catalog \"Аудиотехника\"",
  "keyword": "When "
});
formatter.match({
  "location": "web.steps.OnlinerExampleSteps.clicksOnSectionItemCatalog(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user asserts on Section Item Catalog",
  "keyword": "Then "
});
formatter.match({
  "location": "web.steps.OnlinerExampleSteps.assertOnSectionItemCatalog()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on Product Link \"Наушники\"",
  "keyword": "When "
});
formatter.match({
  "location": "web.steps.OnlinerExampleSteps.clickOnProductLink(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user asserts on Product Link \"Наушники\"",
  "keyword": "Then "
});
formatter.match({
  "location": "web.steps.OnlinerExampleSteps.assertOnProductLink(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on Price Item Offer \"AirPods 2 в зарядном футляре\"",
  "keyword": "When "
});
formatter.match({
  "location": "web.steps.OnlinerExampleSteps.clickOnPriceItemOffer(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user asserts on Price Item Offer \"AirPods 2 в зарядном футляре\"",
  "keyword": "Then "
});
formatter.match({
  "location": "web.steps.OnlinerExampleSteps.assertOnPriceItemOffer(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on Add in Basket by First 1 Price",
  "keyword": "When "
});
formatter.match({
  "location": "web.steps.OnlinerExampleSteps.clickOnnPriceByCount(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user asserts on Price",
  "keyword": "Then "
});
formatter.match({
  "location": "web.steps.OnlinerExampleSteps.assertPrice()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on Basket button",
  "keyword": "When "
});
formatter.match({
  "location": "web.steps.OnlinerExampleSteps.theUserClicksOnBasketButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user asserts on Basket page",
  "keyword": "Then "
});
formatter.match({
  "location": "web.steps.OnlinerExampleSteps.assertBasketPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user asserts that the product is in Basket \"Наушники Apple AirPods 2 в зарядном футляре\"",
  "keyword": "When "
});
formatter.match({
  "location": "web.steps.OnlinerExampleSteps.assertsProductInBasket(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png", null);
formatter.after({
  "status": "passed"
});
});