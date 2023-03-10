package pages;

import core.Browser;

public class LoginPopup {
	public static void clickCloseButton()
	{
		try {
		Browser.clickToControl("loginPopup", "closeButton");
		}
		catch(Exception e)
		{
			
		}
	}

}
