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
  "name": "I am on screen Onliner in application Onliner",
  "keyword": "Given "
});
formatter.step({
  "name": "I navigate to Каталог on screen Onliner in application Onliner",
  "keyword": "When "
});
formatter.step({
  "name": "I assert I am on screen Каталог Onlíner in application Onliner",
  "keyword": "Then "
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
  "name": "I am on screen Onliner in application Onliner",
  "keyword": "Given "
});
formatter.match({
  "location": "web.steps.NavigationsStepsOnliner.assertScreenInApplication(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to Каталог on screen Onliner in application Onliner",
  "keyword": "When "
});
formatter.match({
  "location": "web.steps.NavigationsStepsOnliner.navigateSection(java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I assert I am on screen Каталог Onlíner in application Onliner",
  "keyword": "Then "
});
formatter.match({
  "location": "web.steps.NavigationsStepsOnliner.assertSection(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png", null);
formatter.after({
  "status": "passed"
});
});