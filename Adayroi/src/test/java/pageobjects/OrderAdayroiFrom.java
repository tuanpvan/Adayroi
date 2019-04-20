package pageobjects;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderAdayroiFrom {

	WebDriver driver;
	By txtalert = By.cssSelector("");

	public OrderAdayroiFrom(WebDriver driver) {
		this.driver = driver;
	}

	public void OrderAdayroiHome() {
		this.driver.get("https://www.adayroi.com/");
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// login
		this.driver.findElement(By.cssSelector(
				"#sticky-wrapper > nav > div > div > div.nav__right.col-xs-6.col-sm-1.col-md-4.hidden-xs > ul > li.liOffcanvas.header--user-group > div > a > div:nth-child(2) > span"))
				.click();
		this.driver.findElement(By.cssSelector("#j_username")).sendKeys("hoanghai@wbuom.com");
		this.driver.findElement(By.cssSelector("#j_password")).sendKeys("123Adayroi");
		this.driver
				.findElement(
						By.cssSelector("#sign-in__popup > div > div > div > div.auth-wrapper > div > form > button"))
				.click();

	}

	public void additemtoCart() {
		this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		// select Deal hot moi ngay
		this.driver.findElement(By.cssSelector(
				"#content > div.home__section.home__banner-section.section--shortcut.section-0 > div > div > div > div.content.comp_0000HXU0 > div > div > div:nth-child(1)"))
				.click();
		// select item
		this.driver
				.findElement((By.cssSelector(
						"#productGroupContainercomuid_COMP_PRGRP228933 > div:nth-child(1) > div.product-item > div")))
				.click();

		// add item to cart
		this.driver.findElement(By.cssSelector("#addToCartButton")).click();

		// see cart
		this.driver.findElement(By.cssSelector(
				"#page > header > nav.navigation.navigation--middle.js-navigation--middle > div > div > div.nav__right.col-xs-6.col-sm-1.col-md-4.hidden-xs > ul > li:nth-child(4) > div > a > div"))
				.click();
		// cart submit
		this.driver
				.findElement(By.cssSelector(
						"#sidebar-cart-total > div > div.js-cart-total--container > div > div > div.cart-submit"))
				.click();

		// fill info
		this.driver.findElement(By.cssSelector("#fullName")).sendKeys("Nguyen Van A");
		this.driver.findElement(By.cssSelector("#phone")).sendKeys("0986888888");
		this.driver.findElement(By.cssSelector("#detailedAddress")).sendKeys("86 Tran Hung Dao");
		// choose payment method
		this.driver.findElement(By.cssSelector("#checkoutAddressSubmit")).click();

		// submit
		this.driver.findElement(By.cssSelector(
				"#page > div.page-checkout > div.section__checkout > div > div > div.col-sm-7.col-md-8.checkout-main.d-checkout > div > div > div > div.col-sm-8.col-xs-12.text-right > div.col-sm-7.col-xs-12.pull-right > button"));

	}

	public void orderCompleted(String message) {
		WebDriverWait wait = new WebDriverWait(this.driver, 5);
		WebElement ordercomplete = wait.until(ExpectedConditions.presenceOfElementLocated(txtalert));
		Assert.assertEquals(message, ordercomplete.getAttribute("Đặt hàng thành công"));
	}

}
