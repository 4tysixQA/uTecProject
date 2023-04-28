package iProgrammer_UTechIFA_Utility;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.ExtentTest;
import iProgrammer_UTechIFA_BasePackage.BaseInit;
import iProgrammer_UTechIFA_Utility.ExcelFileReader;
import org.testng.SkipException;

public class Mylibrary extends BaseInit {

    // Login to Admin
    // All field data is coming from the site data property files
    public static void logIN() throws InterruptedException {

        loggs.info("Admin login process started");
        isElementPresent("ip_email_xpath", objectstorage).sendKeys(sitedata.getProperty("email"));
        loggs.info("Enter the Email ID: " + sitedata.getProperty("email"));
        isElementPresent("ip_password_xpath", objectstorage).sendKeys(sitedata.getProperty("adminpassword"));
        loggs.info("Enter the Password: " + sitedata.getProperty(sitedata.getProperty("adminpassword")));
        isElementPresent("btn_signin_xpath", objectstorage).click();
        loggs.info("Click on the sign in button after entering the email and passowrd");
        //Thread.sleep(30000);
        isElementPresent("ip_otp_verification_xpath", objectstorage).sendKeys(sitedata.getProperty("otp"));
        loggs.info("Enter the OTP: " + sitedata.getProperty("otp"));
        isElementPresent("btn_signin_xpath", objectstorage).click();
        loggs.info("Click on the sign in button after entring the OTP");

    }

    // The payU (Payment gateway)
    // All the values are set static.
    public static void payment() throws Exception {

        loggs.info("Payment process started");
        isElementPresent("ip_patment_cardnumber_id", objectstorage).sendKeys("5123");
        loggs.info("First four digit entered: 5123");
        Thread.sleep(1000);
        isElementPresent("ip_patment_cardnumber_id", objectstorage).sendKeys("4567");
        loggs.info("Second four digit entered: 4567");
        Thread.sleep(1000);
        isElementPresent("ip_patment_cardnumber_id", objectstorage).sendKeys("8901");
        loggs.info("Thired four digit entered: 8901");
        Thread.sleep(1000);
        isElementPresent("ip_patment_cardnumber_id", objectstorage).sendKeys("2346");
        loggs.info("Fourth four digit entered: 2346");
        isElementPresent("ip_patment_cardname_id", objectstorage).sendKeys(sitedata.getProperty("cardname"));
        loggs.info("Card name entered: " + sitedata.getProperty("cardname"));
        isElementPresent("ip_patment_cvvnumber_id", objectstorage).sendKeys(sitedata.getProperty("cvvnumber"));
        loggs.info("CVV number entered: " + sitedata.getProperty("cvvnumber"));
        WebElement months = isElementPresent("dd_payment_month_id", objectstorage);
        List<WebElement> monthsvalue = months.findElements(By.tagName("option"));
        monthsvalue.get(4).click();
        loggs.info("Select the expiry month: ");
        WebElement years = isElementPresent("dd_payment_year_id", objectstorage);
        List<WebElement> yearsvalue = years.findElements(By.tagName("option"));
        yearsvalue.get(4).click();
        loggs.info("Select the expiry year: ");
        isElementPresent("btn_payment_paynow_id", objectstorage).click();
        loggs.info("Click on the pay now button after entering all the details");
        isElementPresent("ip_payment_password_id", objectstorage).sendKeys(sitedata.getProperty("password"));
        loggs.info("Enter the Password(OTP): " + sitedata.getProperty("password"));
        isElementPresent("btn_payment_pay_id", objectstorage).click();
        loggs.info("Click on the pay button after entering the Password(OTP)");
        Thread.sleep(2000);
    }

    // Get data from the excel sheet
    public static Object[][] getTestDataFromXLSX(ExcelFileReader data, String sheetName) {

        loggs.info("Going to get the data from the sheet: " + sheetName);
        int rows = data.totalRow(sheetName);
        loggs.info("Total row counted: " + rows);
        int cols = data.totalColumn(sheetName);
        loggs.info("Total Column counted: " + cols);

        Object[][] myData = new Object[rows - 1][cols];

        for (int row = 1; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                myData[row - 1][col] = data.getData(sheetName, row, col);

            }
        }
        loggs.info("Got all the data from the sheet: " + sheetName);

        return myData;
    }

    // Take screen shots method
    public static String getScreenShot(String imageName, WebDriver driver, String foldername) {

//        // Execute JavaScript to get the total height of the page
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        long totalHeight = (long) js.executeScript("return document.body.scrollHeight");
//
//        // Set the size of the browser window to the total height of the page
//        driver.manage().window().setSize(new Dimension(1920, (int) totalHeight));

        loggs.info("Screenshot will be taken");
        TakesScreenshot ts = (TakesScreenshot) driver;

        File scrFile = ts.getScreenshotAs(OutputType.FILE);

        String path = System.getProperty("user.dir") +File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"iProgrammer_UTechIFA_Reports"+File.separator + foldername + File.separator + foldername + "_Screenshots"+File.separator + imageName + ".png";

        // System.out.println(path);
        File destination = new File(path);
        loggs.info("Screenshot stored in path");
        try {

            FileHandler.copy(scrFile, destination);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return path;
    }

    // Create SR for the IHB Persona
    public static void createSRIHB(String MobileNumber, String RequestType, String SubRequestType,ExtentTest report) throws Exception {

        report.info("Create SR for IHB");
        report.info("Account Number " + MobileNumber);
        loaderdisplay(report);
        loggs.info("SR will be goining to create for IHB: " + MobileNumber);
        wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("tab_sidebar_servicerequest_xpath", objectstorage)));
        isElementPresent("tab_sidebar_servicerequest_xpath", objectstorage).click();
        loggs.info("Click on the service request option from the side bar");
        wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("tab_sidebar_servicerequest_srtracker_xpath", objectstorage)));
        isElementPresent("tab_sidebar_servicerequest_srtracker_xpath", objectstorage).click();
        loggs.info("Click on the sr tracker option which is under servicerequest option");
        loaderdisplay(report);
        wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("btn_servicerequest_tracker_createsr_xpath", objectstorage)));
        isElementPresent("btn_servicerequest_tracker_createsr_xpath", objectstorage).click();
        loggs.info("Click on the create SR button");
        isElementPresent("ip_servicerequest_srtracker_mobilenumber_xpath", objectstorage).sendKeys(MobileNumber);
        loggs.info("Enter the account number in search field. Mobile Number: " + MobileNumber);
        isElementPresent("btn_servicerequest_tracker_search_xpath", objectstorage).click();
        loggs.info("Click on the search button");
        loaderdisplay(report);
        wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("dd_srcreate_requesttype_xpath", objectstorage)));
        isElementPresent("dd_srcreate_requesttype_xpath", objectstorage).click();
        loggs.info("Click on the request type field. Dropdown will open");
        selectvalue(objectstorage, "tb_srcreate_requesttype_list_xpath", RequestType);
        loggs.info("request type is selected from the dropdown. Request type: " + RequestType);
        if ("Construction Advisory".equalsIgnoreCase(RequestType)) {
            isElementPresent("dd_srcreate_requesttype_subrequesttype_xpath", objectstorage).click();
            loggs.info("Click on the sub request type field. Dropdown will open");
            selectvalue(objectstorage, "tb_srcreate_requesttype_subrequesttype_list_xpath", SubRequestType);
            loggs.info("Sub request type is selected from the dropdown. Sub Request type: " + SubRequestType);
        }
        isElementPresent("btn_srcreate_proceed_xpath", objectstorage).click();
        loggs.info("Click on the proceed button");
        loaderdisplay(report);

    }

    // Create SR for the Partner Persona
    // Partner raising the SR for self
    // Partner raising the SR for existing customer
    // Partner raising the SR for new customer
    public static void createSRPartner(String MobileNumber, String RequestType, String SubRequestType, String RequestFor, String IHBType, String IHBName, String IHBNumber, ExtentTest report) throws Exception {

        report.info("Create SR for Partner");
        report.info("Account Number " + MobileNumber);
        report.info("Request For: " + RequestFor);
        report.info("Customer Type: " + IHBType);
        report.info("Customer Name: " + IHBName);
        report.info("Customer Number: " + IHBNumber);
        loaderdisplay(report);
        loggs.info("SR will be goining to create for Partner: " + MobileNumber);
        isElementPresent("tab_sidebar_servicerequest_xpath", objectstorage).click();
        loggs.info("Click on the service request option from the side bar");
        isElementPresent("tab_sidebar_servicerequest_srtracker_xpath", objectstorage).click();
        loggs.info("Click on the sr tracker option which is under servicerequest option");
        loaderdisplay(report);
        wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("btn_servicerequest_tracker_createsr_xpath", objectstorage)));
        isElementPresent("btn_servicerequest_tracker_createsr_xpath", objectstorage).click();
        loggs.info("Click on the create SR button");
        isElementPresent("ip_servicerequest_srtracker_mobilenumber_xpath", objectstorage).sendKeys(MobileNumber);
        loggs.info("Enter the account number in search field. Mobile Number: " + MobileNumber);
        isElementPresent("btn_servicerequest_tracker_search_xpath", objectstorage).click();
        loggs.info("Click on the search button");
        isElementPresent("dd_srcreate_creatingrequestfor_xpath", objectstorage).click();
        loggs.info("Click on the create request for field. Drop-down will be open");
        selectvalue(objectstorage, "tb_srcreate_creatingrequestfor_list_xpath", RequestFor);
        loggs.info("Select the reqest for value from the drop-down. Request For: " + RequestFor);

        if (RequestFor.equalsIgnoreCase("IHB")) {

            loggs.info("Partner raising request for IHB");
            isElementPresent("dd_srcreate_ihbtype_xpath", objectstorage).click();
            loggs.info("Click on the IHB type field");
            selectvalue(objectstorage, "tb_srcreate_ihbtype_list_xpath", IHBType);
            loggs.info("Select the IHB type from the drop-down. IHB: " + IHBType);
            if (IHBType.equalsIgnoreCase("Existing")) {
                loggs.info("Partner raising the request for the existing customer");
                isElementPresent("dd_srcreate_ihbnumber_xpath", objectstorage).click();
                loggs.info("Click on the IHB number field");
                selectvalue(objectstorage, "tb_srcreate_ihbnumber_list_xpath", IHBNumber);
                loggs.info("Select the IHB number: " + IHBNumber);

            } else {
                loggs.info("Partner raising the request for new customer");
                isElementPresent("ip_createsr_ihbnumber_xpath", objectstorage).sendKeys(IHBNumber);
                loggs.info("Enter the IHB Number: " + IHBNumber);
                isElementPresent("ip_createsr_ihbname_xpath", objectstorage).sendKeys(IHBName);
                loggs.info("Enter the IHB Name: " + IHBName);

            }

        }
        isElementPresent("dd_srcreate_requesttype_xpath", objectstorage).click();
        loggs.info("Click on the request type field. Dropdown will open");
        selectvalue(objectstorage, "tb_srcreate_requesttype_list_xpath", RequestType);
        loggs.info("request type is selected from the dropdown. Request type: " + RequestType);
        if ("Construction Advisory".equalsIgnoreCase(RequestType)) {
            isElementPresent("dd_srcreate_requesttype_subrequesttype_xpath", objectstorage).click();
            loggs.info("Click on the sub request type field. Dropdown will open");
            selectvalue(objectstorage, "tb_srcreate_requesttype_subrequesttype_list_xpath", SubRequestType);
            loggs.info("Sub request type is selected from the dropdown. Sub Request type: " + SubRequestType);
        }
        isElementPresent("btn_srcreate_proceed_xpath", objectstorage).click();
        loggs.info("Click on the proceed button");
        loaderdisplay(report);

    }

    // Select value from the drop-down
    // Passing the value and it will select from the list of the drop-down.
    public static void selectvalue(Properties propfilename, String path, String namevalue) {
        List<WebElement> value = driver.findElements(By.xpath(propfilename.getProperty(path)));
        for (WebElement val : value) {

            // String requestname = value.get(i).getText();
            // System.out.println(val.getText());

            if (val.getText().equalsIgnoreCase(namevalue)) {

                val.click();
                break;
            }

        }

    }

    // Get the browser console logs.
    // SUCCESS: 200,
    // BAD_REQUEST: 400,
    // UNAUTHORISED: 401,
    // FORBIDDEN: 403,
    // NOT_FOUND: 404,
    // REQUEST_TIMEOUT: 408,
    // INTERNAL_SERVER_ERROR: 500,
    // BAD_GATEWAY: 502,
    // SERVICE_UNAVAILABLE: 503,
    // INSUFFICIENT_STORAGE: 507,
    // FAILURE: 520,
    // DUPLICATE: 422
    public static void browserlogs(ExtentTest Report) throws EmailException, Exception {

        Thread.sleep(30000);
        loggs.info("Logs are goining to genrate");
        LogEntries logentries = driver.manage().logs().get("browser");

        for (LogEntry logEntry : logentries) {

            String errorlogType = logEntry.getLevel().toString();
            String errorlog = logEntry.getMessage().toString();

            if (errorlog.contains("400")) {
                System.out.println("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                loggs.info("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                Report.warning("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                emailconfigration();
                email.setMsg("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                email.send();

            }
            if (errorlog.contains("401")) {
                System.out.println("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                loggs.info("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                Report.warning("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                emailconfigration();
                email.setMsg("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                email.send();
            }
            if (errorlog.contains("403")) {
                System.out.println("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                loggs.info("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                Report.warning("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                emailconfigration();
                email.setMsg("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                email.send();
            }
            if (errorlog.contains("404")) {
                System.out.println("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                loggs.info("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                Report.warning("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                emailconfigration();
                email.setMsg("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                email.send();
            }
            if (errorlog.contains("408")) {
                System.out.println("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                loggs.info("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                Report.warning("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                emailconfigration();
                email.setMsg("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                email.send();
            }
            if (errorlog.contains("422")) {
                System.out.println("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                loggs.info("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                Report.warning("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                emailconfigration();
                email.setMsg("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                email.send();
            }
            if (errorlog.contains("500")) {
                System.out.println("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                loggs.info("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                Report.warning("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                emailconfigration();
                email.setMsg("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                email.send();
            }
            if (errorlog.contains("502")) {
                System.out.println("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                loggs.info("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                Report.warning("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                emailconfigration();
                email.setMsg("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                email.send();
            }
            if (errorlog.contains("503")) {
                System.out.println("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                loggs.info("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                Report.warning("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                emailconfigration();
                email.setMsg("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                email.send();
            }
            if (errorlog.contains("507")) {
                System.out.println("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                loggs.info("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                Report.warning("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                emailconfigration();
                email.setMsg("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                email.send();
            }
            if (errorlog.contains("520")) {
                System.out.println("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                loggs.info("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                Report.warning("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                emailconfigration();
                email.setMsg("Error LogType: " + errorlogType + "Error log Message: " + errorlog);
                email.send();
            }

        }

    }

    public static void emailconfigration() throws EmailException {
        loggs.info("Email setting going to be configure");
        email = new MultiPartEmail();

        if (sitedata.getProperty("accountplatform").equalsIgnoreCase("Microsoft")) {
            loggs.info("Email setting is goining to be configured for Microsoft account");
            email.setHostName(sitedata.getProperty("microsofthostname"));
            email.setSmtpPort(Integer.valueOf(sitedata.getProperty("smtpport")));
            email.setAuthenticator(new DefaultAuthenticator(sitedata.getProperty("accountemail"), sitedata.getProperty("accountpassowrd")));
            email.setStartTLSEnabled(true);
            loggs.info("Email setting configured for the Microoosoft account");

        } else {
            loggs.info("Email setting is goining to be configured for Gmail account");
            email.setHostName(sitedata.getProperty("gmailhostname"));
            email.setSmtpPort(Integer.valueOf(sitedata.getProperty("smtpport")));
            email.setAuthenticator(new DefaultAuthenticator(sitedata.getProperty("accountemail"), sitedata.getProperty("accountpassowrd")));
            email.setSSLOnConnect(true);
            loggs.info("Email setting configured for the Gmail account");
        }

        // Add all the email data.
        // Add To accounts.
        // Add Cc accounts.
        // Add Bcc accounts.
        // Add From accounts.
        // Add Email Subject.
        // Add Email description.
        email.addTo(sitedata.getProperty("addto"));
        loggs.info("Email To: " + sitedata.getProperty("addto"));
        //email.addTo("gopalkh@iprogrammer.co");
        email.addCc(sitedata.getProperty("addcc"));
        loggs.info("Email Cc: " + sitedata.getProperty("addcc"));
        // email.addBcc(sitedata.getProperty("addbcc"));
        // loggs.info("Email Bcc: "+sitedata.getProperty("addbcc"));
        email.setFrom(sitedata.getProperty("accountemail"));
        loggs.info("Email From: " + sitedata.getProperty("accountemail"));
        email.setSubject(sitedata.getProperty("subject"));
        loggs.info("Email Subject: " + sitedata.getProperty("subject"));
        // email.setMsg(sitedata.getProperty("discription"));
        // loggs.info("Email Message: " + sitedata.getProperty("discription"));
    }

    public static void srcancllation(String requestStatus,String requestType, ExtentTest report) throws Exception {

        loggs.info("SR cancllation process start");
        if (requestStatus.equalsIgnoreCase("Draft")) {
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("dd_srdetails_caseinfo_currentstatus_xpath", objectstorage)));
            isElementPresent("dd_srdetails_caseinfo_currentstatus_xpath", objectstorage).click();
            loggs.info("Click on the current status field");
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("tb_srdetails_caseinfo_currentstatus_xpath", objectstorage)));
            List<WebElement> currentstatus = driver.findElements(By.xpath(objectstorage.getProperty("tb_srdetails_caseinfo_currentstatus_xpath")));
            loggs.info("Current status going to be selected");
            for (WebElement currentstatusselection : currentstatus) {
                if ("Draft Cancelled".equalsIgnoreCase(currentstatusselection.getText())) {
                    currentstatusselection.click();
                    loggs.info("Draft Cancled selected");
                    break;
                }
            }
            Mylibrary.loaderdisplay(report);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("dd_srdetails_caseinfo_cancellationreason_xpath", objectstorage)));
            isElementPresent("dd_srdetails_caseinfo_cancellationreason_xpath", objectstorage).click();
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("tb_srdetails_caseinfo_cancellationreason_xpath", objectstorage)));
            List<WebElement> cancellation = driver.findElements(By.xpath(objectstorage.getProperty("tb_srdetails_caseinfo_cancellationreason_xpath")));
            for (WebElement cancellationreason : cancellation) {
                if ("Customer Not Contactable - Contact Center".equalsIgnoreCase(cancellationreason.getText())) {
                    cancellationreason.click();
                    break;
                }

            }

        } else {
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("dd_srdetails_caseinfo_currentstatus_xpath", objectstorage)));
            isElementPresent("dd_srdetails_caseinfo_currentstatus_xpath", objectstorage).click();
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("tb_srdetails_caseinfo_currentstatus_xpath", objectstorage)));
            List<WebElement> currentstatus = driver.findElements(By.xpath(objectstorage.getProperty("tb_srdetails_caseinfo_currentstatus_xpath")));
            for (WebElement currentstatusselection : currentstatus) {
                if ("Cancelled".equalsIgnoreCase(currentstatusselection.getText())) {
                    currentstatusselection.click();
                    break;
                }

            }
            Mylibrary.loaderdisplay(report);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("dd_srdetails_caseinfo_cancellationreason_xpath", objectstorage)));
            isElementPresent("dd_srdetails_caseinfo_cancellationreason_xpath", objectstorage).click();
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("tb_srdetails_caseinfo_cancellationreason_xpath", objectstorage)));
            List<WebElement> cancellation = driver.findElements(By.xpath(objectstorage.getProperty("tb_srdetails_caseinfo_cancellationreason_xpath")));
            for (WebElement cancellationreason : cancellation) {
                if ("Test/Mock Service Request".equalsIgnoreCase(cancellationreason.getText())) {
                    cancellationreason.click();
                    break;
                }

            }
        }
        driver.findElement(By.xpath("//button[@type='button' and text()='assign to me']")).click();
        if (requestType.equalsIgnoreCase("Aytipical")){
            isElementPresent("btn_srdetiales_caseinfo_action_xpath", objectstorage).click();
            List<WebElement> action = driver.findElements(By.xpath(objectstorage.getProperty("tb_srdetiales_caseinfo_action_xpath")));
            for (WebElement actionvalue : action) {
                if ("Update".equalsIgnoreCase(actionvalue.getText())) {
                    actionvalue.click();
                    break;

                }
            }

        }else {
            isElementPresent("btn_srdetiales_caseinfo_update_xpath", objectstorage).click();
        }
        isElementPresent("btn_srdetiales_caseinfo_action_update_confirmation_xpath", objectstorage).click();

    }

    public static void openmcl(){
        isElementPresent("tab_sidebar_mcl_xpath",objectstorage).click();
    }

    public static String getalaertmessage(){
        String alerttext;
        Boolean alert = false;
        while(alert==false){
            alert = elementPrecent(objectstorage,"lt_alert_xpath");
            //alert = driver.findElement(By.xpath("//div[@Class='alert-with-icon animated fadeInDown alert alert-warning alert-dismissible fade show']//div[@Class='alert-text']//span[@data-notify='message']")).isDisplayed();
        }
        alerttext = driver.findElement(By.xpath("//div[@Class='alert-with-icon animated fadeInDown alert alert-warning alert-dismissible fade show']//div[@Class='alert-text']//span[@data-notify='message']")).getText();
        return alerttext;

    }

    public static boolean elementPrecent(Properties propertiFilename, String elemetValue){
        List<WebElement> element = driver.findElements(By.xpath(propertiFilename.getProperty(elemetValue)));
        if (element.size() == 0){
            return false;
        }else {
            return true;
        }


    }

    public static void loaderdisplay(ExtentTest report) throws Exception {
        try{
            waitFluent.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(objectstorage.getProperty("ld_loaderdisplay_yes_xpath"))));
        }catch (Exception e){

            loggs.debug("An error occured", e);
            browserlogs(report);
            report.skip("Test Case is skipped due to falling exception: "+e);
            throw new SkipException("Test Case is skipped due to falling exception: "+e);
        }
    }
}
