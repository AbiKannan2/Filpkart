package pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import core.Browser;

public class HomePage {
	public static void clickOnBanner() {
		Browser.waitForElementClickable(Browser.getElement("homePage", "bannerImage"));
		Browser.clickToControl("homePage", "bannerImage");
	}

	public static void moveOnElectronics() {
		Browser.delayWithMilliseconds(3000);
		Browser.moveToElement("homePage", "electronics");
		Browser.delayWithMilliseconds(1000);
	}

	/*public static void moveOntvsAndAppliances() {
		Browser.delayWithMilliseconds(3000);
		Browser.moveToElement("HomePage", "tvsAndAppliances");
		Browser.delayWithMilliseconds(1000);
	}

	public static void moveOnMen() {
		Browser.delayWithMilliseconds(3000);
		Browser.moveToElement("HomePage", "men");
		Browser.delayWithMilliseconds(1000);
	}

	public static void moveOnWomen() {
		Browser.delayWithMilliseconds(3000);
		Browser.moveToElement("HomePage", "women");
		Browser.delayWithMilliseconds(1000);
	}

	public static void moveOnBabyAndKids() {
		Browser.delayWithMilliseconds(3000);
		Browser.moveToElement("HomePage", "babyAndKids");
		Browser.delayWithMilliseconds(1000);
	}

	public static void moveOnHomeAndFurniture() {
		Browser.delayWithMilliseconds(3000);
		Browser.moveToElement("HomePage", "homeAndFurniture");
		Browser.delayWithMilliseconds(1000);
	}

	public static void moveOnSportsBooksAndMore() {
		Browser.delayWithMilliseconds(3000);
		Browser.moveToElement("HomePage", "sportsBooksAndMore");
		Browser.delayWithMilliseconds(1000);
	}
*/
	public static void checkMainMenuVisible() {
		if (Browser.getElement("homePage", "menus").isDisplayed()) {
		} else {
			Browser.browserBack();
			clickOnBanner();
		}
	}

	public static void getListOfSubmenus() {
		moveOnElectronics();
		checkMainMenuVisible();
		int serialNum = 0;
		List<WebElement> mainMenu = Browser.getElements("homePage", "menus");
		for (int k = 0; k < mainMenu.size(); k++) {
			Browser.moveToElement(mainMenu.get(k));
			System.out.println("\n");
			System.out.println("\033[1m" + mainMenu.get(k).getText() + "\033[0m");
			List<WebElement> title = Browser.getElements("homePage", "titles");
			List<WebElement> subMenu = Browser.getElements("homePage", "subMenus");
			for (int j = 0; j < subMenu.size(); j++) {
				WebElement sMenu = subMenu.get(j);
				if (title.contains(sMenu)) {
					System.out.println(sMenu.getText());
					serialNum = 0;
				} else {
					serialNum++;
					System.out.println(serialNum + " " + sMenu.getText());
				}
			}

		}
	}

	public static void getList() {
		checkMainMenuVisible();
		int serialNum = 0;
		List<WebElement> mainMenu = Browser.getElements("homePage", "menus");
		for (int k = 0; k < mainMenu.size(); k++) {
			Browser.moveToElement(mainMenu.get(k));
			System.out.println("\n");
			System.out.println("\033[1m" + mainMenu.get(k).getText() + "\033[0m");
			List<WebElement> title = Browser.getElements("homePage", "titles");
			List<WebElement> subMenu = Browser.getElements("homePage", "subMenus");
			for(int i=0;i<subMenu.size();i++)
			{
				if(subMenu.get(i).getText().contains(title.get(i).getText()))
				{
					System.out.println(subMenu.get(i).getText());
					serialNum=0;
				}else
				{
					serialNum++;
					System.out.println(serialNum+ "."+subMenu.get(i).getText());
				}
			}
		}
	}
/*
	public static void subMenus() {
		moveOnElectronics();
		getListOfSubmenus();
		moveOntvsAndAppliances();
		getListOfSubmenus();
		moveOnMen();
		getListOfSubmenus();
		moveOnWomen();
		getListOfSubmenus();
		moveOnBabyAndKids();
		getListOfSubmenus();
		moveOnHomeAndFurniture();
		getListOfSubmenus();
		moveOnSportsBooksAndMore();
		getListOfSubmenus();
	} */
}
