package com.epam.cleartrip.suitbase;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features ="features",
								 glue="src/test/java/com.epam.cleartrip.steps",
								 monochrome=true,
								 format="pretty")
public class TestRunner {

}
