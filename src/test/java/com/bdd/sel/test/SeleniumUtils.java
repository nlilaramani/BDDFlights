/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bdd.sel.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Owner
 */
public class SeleniumUtils {
    public static WebDriver getChromeDriver(){
        System.setProperty("webdriver.chrome.driver","c:\\qa\\drivers\\chromedriver.exe");
        return new ChromeDriver();
    }
    
    public static void main(String[] args){
        getChromeDriver().get("http://www.itexps.net");
    }
}
