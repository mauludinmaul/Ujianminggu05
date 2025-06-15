package com.juaracoding.ujianminggu05.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {
        "src/test/java/resources/features"
}, plugin = { "pretty:target/pretty.txt",
        "html:target/cucumber-reports/index.html",
        "json:target/cucumber-reports/index.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
}, glue = {
        "com.juaracoding.ujianminggu05.hooks",
        "com.juaracoding.ujianminggu05.steps",
})
public class Runner extends AbstractTestNGCucumberTests {

}