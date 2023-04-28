package iProgrammer_UTechIFA_2DLayout;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;

import org.apache.commons.mail.EmailAttachment;
import org.openqa.selenium.By;
import org.openqa.selenium.io.Zip;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import iProgrammer_UTechIFA_BasePackage.BaseInit;
import iProgrammer_UTechIFA_Utility.Mylibrary;

public class ParentClass_2DLayout extends BaseInit {

	@BeforeSuite
	public void checkTestSuite() throws Exception {

		reporter = new ExtentSparkReporter(System.getProperty("user.dir")
				+ "\\src\\test\\resources\\iProgrammer_UTechIFA_Reports\\2dlayout\\2dlayout.html");
		reporter.config().setReportName("2D Layout");	
		startUP();
		driver.get(sitedata.getProperty("URL"));
		Thread.sleep(8000);
		Boolean elementprasent = driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed();
		if (elementprasent) {
			String elementtext = driver.findElement(By.xpath("//button[@type='submit']")).getText();
			if (elementtext.equals("Sign In")) {
				Mylibrary.logIN();
			}
		}
	}

	@AfterSuite
	public void finishedTestSuite() throws Exception {

//		Mylibrary.emailconfigration();
//
//		loggs.info("Email configration done");
//
//		email.setMsg(sitedata.getProperty("discription"));
//		loggs.info("Email Message: " + sitedata.getProperty("discription"));
//
//		String file = Zip.zip(new File(
//				System.getProperty("user.dir") + "\\src\\test\\resources\\iProgrammer_UTechIFA_Reports\\2dlayout"));
//
//		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream("./2dlayout.zip"));
//
//		byte[] decode = Base64.getDecoder().decode(file);
//		stream.write(decode);
//		stream.close();
//
//		// Create the attachment
//		EmailAttachment attachment = new EmailAttachment();
//		attachment.setPath("./2dlayout.zip");
//		attachment.setDisposition(EmailAttachment.ATTACHMENT);
//		attachment.setDescription("Test Email");
//		attachment.setName("2dlayout.zip");
//
//		// add the attachment
//		email.attach(attachment);
//
//		// send the email
//		email.send();

	}
}
