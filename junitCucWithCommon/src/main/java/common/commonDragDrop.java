package common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import PageObjects.PomGmailHomePage;


public  class commonDragDrop extends SharedMethod{

	@Override
	public void dragDrop() throws InterruptedException {
		PomGmailHomePage homePage=new PomGmailHomePage(driver);
		
		
		Actions action = new Actions(driver);
		action.moveToElement(homePage.lefttab);
		
			Thread.sleep(2000);
	
		//// scroll
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("arguments[0].scrollIntoView();", homePage.dragTo);
		
		 action.dragAndDrop(row,homePage.dragTo).build().perform();
		 // System.out.println("done");
		
		
	} 
	
}
