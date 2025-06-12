package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Main {
   public static WebDriver driver;
   // snapinsta moved
   String snapinstaUrl = "https://snapinsta.app/";
   String dummyUrl = "https://www.instagram.com/p/C_h0PcJy9Vz/";






   @Test
   public void test() throws InterruptedException {
      ArrayList<String> urlsToDownload = new ArrayList<>();
      urlsToDownload.add("https://www.instagram.com/p/C93rXxEi5j4/");
      urlsToDownload.add("https://www.instagram.com/p/C9v92g3J-Ge/");
      urlsToDownload.add("https://www.instagram.com/p/C9p8-79Ipdl/");
      urlsToDownload.add("https://www.instagram.com/p/C7rVCYtiRBH/");
      urlsToDownload.add("https://www.instagram.com/p/C71XLsyMSb5/");
      urlsToDownload.add("https://www.instagram.com/p/C8EyjneNCRs/");
      urlsToDownload.add("https://www.instagram.com/p/C76nO5MNU7z/");
      urlsToDownload.add("https://www.instagram.com/p/C66V89kMKsG/");
      urlsToDownload.add("https://www.instagram.com/p/C4lR3nIi67O/");
      urlsToDownload.add("https://www.instagram.com/p/C610DUTiwpx/");
      urlsToDownload.add("https://www.instagram.com/p/C8h2vD1sdry/");
      urlsToDownload.add("https://www.instagram.com/p/C8cs7rJCHFf/");
      urlsToDownload.add("https://www.instagram.com/p/C7LkgcXufjn/");
      urlsToDownload.add("https://www.instagram.com/p/C7Fzdh2RdPD/");
      urlsToDownload.add("https://www.instagram.com/p/C8j0UhaikXO/");
      urlsToDownload.add("https://www.instagram.com/p/C8h2vD1sdry/");
      urlsToDownload.add("https://www.instagram.com/p/C8jEFmau2qg/");
      urlsToDownload.add("https://www.instagram.com/p/C8hD4BaA9h2/");
      urlsToDownload.add("https://www.instagram.com/p/C7q_x5woNUT/");
      urlsToDownload.add("https://www.instagram.com/p/C8IguqHRfEE/");
      urlsToDownload.add("https://www.instagram.com/p/C8aJgm7CGo9/");
      urlsToDownload.add("https://www.instagram.com/p/C8PVK12ItfB/");
      //Comment for me tomorrow missing 3 videos every 5-6 vids check :)

      driver.get(snapinstaUrl);
      driver.findElement(By.id("url")).sendKeys(dummyUrl);
      driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
      driver.findElement(By.id("btn-submit")).click();
      Thread.sleep(6000);
      driver.findElement(By.id("close-modal")).click();
      driver.findElement(By.xpath("//*[@id=\"download\"]/div[1]/div/div/div[2]/div/a")).click();
      Thread.sleep(2000);
      driver.findElement(By.xpath("//*[@id=\"download\"]/div[2]/a[2]"));

      for (String url : urlsToDownload){
         driver.get(snapinstaUrl);
         driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
         driver.findElement(By.id("url")).sendKeys(url);
         driver.findElement(By.id("btn-submit")).click();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  // Wait up to 10 seconds
         Thread.sleep(6000);
         driver.findElement(By.id("close-modal")).click();
         Thread.sleep(3000);
         driver.findElement(By.xpath("//*[@id=\"download\"]/div[1]/div/div/div[2]/div/a")).click();
         Thread.sleep(2000);
         driver.findElement(By.xpath("//*[@id=\"download\"]/div[2]/a[2]"));
         }
   }
   public static void setupDriver(){
      WebDriverManager.chromedriver().setup();
   }

   @BeforeClass
   public static void setUp(){
      setupDriver();

      ChromeOptions options = new ChromeOptions();
      options.addArguments("--disable-popup-blocking");
      HashMap<String, Object> chromePreferences = new HashMap<>();
      chromePreferences.put("download.default_directory", "Users/user/Downloads/InstagramVideoDownloadTool");
      chromePreferences.put("download.prompt_for_download", false);
      chromePreferences.put("profile.default_content_settings.popups", 0);

      options.setExperimentalOption("prefs", chromePreferences);
      driver = new ChromeDriver(options);


   }
   @AfterClass
   public static void tearDown(){driver.quit();}


}