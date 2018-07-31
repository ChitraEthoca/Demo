package tests.Encryption;

import org.testng.annotations.Test;

import BaseClasses.BasePage;
import pages.Encryption.IE_CustomerContactPage_731_732_764_S1;

public class IE_CustomerContactPage_731_732_764_S1_Test extends BasePage {

	@Test()
	public void checkCustomerContact() throws Exception {
		try {

			IE_CustomerContactPage_731_732_764_S1 contactPage_S1 = new IE_CustomerContactPage_731_732_764_S1();

			contactPage_S1.loginIntoApplication();

			contactPage_S1.navigateToWI_AddContact();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			// super.tearDown();
		}

	}
}
