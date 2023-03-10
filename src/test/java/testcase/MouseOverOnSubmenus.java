package testcase;

import org.testng.annotations.Test;

import core.Browser;
import pages.HomePage;
import pages.LoginPopup;

public class MouseOverOnSubmenus {
@Test
	public static void gettingSubmenus() {
		Browser.lanch();
		Browser.getUrl();
		Browser.windowMaximize();
		LoginPopup.clickCloseButton();
		HomePage.clickOnBanner();
		HomePage.getListOfSubmenus();
		Browser.browserClose();
	}

}
