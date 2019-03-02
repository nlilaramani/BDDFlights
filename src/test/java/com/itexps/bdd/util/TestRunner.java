/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itexps.bdd.util;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 *
 * @author 212616565
 */
@RunWith(Cucumber.class)
@CucumberOptions(
    features="./src/test/java/features", // feature file path
    glue="StepDefs", // path for step definitions
    plugin = {"pretty", "html:target/cucumber"},
    dryRun=false, // if true, checks for steps 
    monochrome=true, // readable output
    strict=true)
public class TestRunner {
    
    
}
