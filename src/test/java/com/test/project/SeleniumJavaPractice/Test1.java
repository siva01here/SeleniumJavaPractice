package com.test.project.SeleniumJavaPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		System.out.println("Hello world");
		
		List<String> temp= new ArrayList<String>();
		temp.add("B");
		temp.add("A");
		
		System.out.println(temp.stream().sorted().collect(Collectors.toList()));
		

	}
	
	

}
