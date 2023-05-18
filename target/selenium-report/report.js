$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/projectMorozova/OnlinerExample.feature");
formatter.feature({
  "name": "Web Demo - Create and Delete Automation Process in Web Application",
  "description": "  As a user\n  I want to create Automation Process in Web Application, and then delete\n  So that the Automation Process is successfully created and deleted",
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
  "name": "Create and Delete Automation Process in Web Application",
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
  "name": "Create and Delete Automation Process in Web Application",
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
formatter.embedding("image/png", "embedded0.png", null);
formatter.after({
  "status": "passed"
});
});