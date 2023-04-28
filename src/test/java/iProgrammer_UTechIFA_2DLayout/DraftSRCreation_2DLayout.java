package iProgrammer_UTechIFA_2DLayout;

import java.io.IOException;
import java.util.List;

import org.apache.commons.mail.EmailException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import iProgrammer_UTechIFA_Utility.Mylibrary;

public class DraftSRCreation_2DLayout extends ParentClass_2DLayout {

    public static ExtentTest twodlayout;

    @BeforeTest
    public void checkTestCase() throws Exception {

    }

    @Test(dataProvider = "positiveData", description = "Aytipical and Non-aytipical", enabled = true)
    public void positiveData(String SRNO, String descriptions, String PersonaType, String MobileNumber, String RequestFor, String IHBType, String IHBName, String IHBNumber, String RequestType, String SubRequestType, String ProjectName, String PlotShape, String PlotArea, String PlotWidth, String Purpose, String FreshConstruction, String Rent, String StageOfConstruction, String NumberOfFloors, String PlotAddress, String Landmark, String Pincode, String Expected) throws Exception {

        Boolean numbernotfound = false;
        Boolean draftSrnotcreated = false;
        loggs.info("*************** " + SRNO + " ***************");
        loggs.info(descriptions + "_" + SRNO);
        twodlayout = extent.createTest(SRNO + "_" + "2D Layout", descriptions);
        Mylibrary.loaderdisplay(twodlayout);
        driver.get(sitedata.getProperty("URL"));
        loggs.info("URL is loading");
        Mylibrary.loaderdisplay(twodlayout);
        try {
            loggs.info("2D Request raised for " + PersonaType);
            if (PersonaType.equalsIgnoreCase("IHB")) {
                Mylibrary.createSRIHB(MobileNumber, RequestType, SubRequestType, twodlayout);
            } else {
                Mylibrary.createSRPartner(MobileNumber, RequestType, SubRequestType, RequestFor, IHBType, IHBName, IHBNumber, twodlayout);
            }
            twodlayout.info("Test Data: " + SRNO + " | " + " ProjectName: " + ProjectName + " | " + "PlotShape: " + PlotShape + " | " + "PlotArea: " + PlotArea + " | " + " PlotWidth: " + PlotWidth + " | " + "Purpose: " + Purpose + " | " + "FreshConstruction: " + FreshConstruction + " | " + " Rent: " + Rent + " | " + " StageOfConstruction: " + StageOfConstruction + " | " + " NumberOfFloors: " + NumberOfFloors + " | " + "PlotAddress: " + PlotAddress + " | " + "Landmark: " + Landmark + " | " + "Pincode: " + Pincode);
            Mylibrary.loaderdisplay(twodlayout);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("ip_srcreate_projectname_xpath", objectstorage2d)));
            loggs.info("2D request initiated for the user");
            // 2D SR creation flow
            loggs.info("Mandatory field collation flow start");
            isElementPresent("ip_srcreate_projectname_xpath", objectstorage2d).sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.DELETE));
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("ip_srcreate_projectname_xpath", objectstorage2d)));
            loggs.info("Clear the Project Name field");
            isElementPresent("ip_srcreate_projectname_xpath", objectstorage2d).sendKeys(ProjectName);
            loggs.info("Enter the Project Name: " + ProjectName);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("dd_srcreate_plotshap_xpath", objectstorage2d)));
            isElementPresent("dd_srcreate_plotshap_xpath", objectstorage2d).click();
            loggs.info("Click on the plot shape field. Drop-down will be open");
            Mylibrary.selectvalue(objectstorage2d, "tb_srcreate_plotshap_list_xpath", PlotShape);
            loggs.info("Plot shap is selected from dropdown. plotshape: " + PlotShape);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("ip_srcreate_plotarea_xpath", objectstorage2d)));
            isElementPresent("ip_srcreate_plotarea_xpath", objectstorage2d).sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.DELETE));
            loggs.info("Clear the plot area field");
            isElementPresent("ip_srcreate_plotarea_xpath", objectstorage2d).sendKeys(PlotArea);
            loggs.info("Enter the plot area: " + PlotArea);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("ip_srcreate_plotwidth_xpath", objectstorage2d)));
            isElementPresent("ip_srcreate_plotwidth_xpath", objectstorage2d).sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.DELETE));
            loggs.info("Clear the plotwidth field");
            isElementPresent("ip_srcreate_plotwidth_xpath", objectstorage2d).sendKeys(PlotWidth);
            loggs.info("Enter the Plot Width: " + PlotWidth);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("dd_srcreate_purposeofhomebuilding_xpath", objectstorage2d)));
            isElementPresent("dd_srcreate_purposeofhomebuilding_xpath", objectstorage2d).click();
            loggs.info("Click on the purpose of home building field. Drop-down will be opened.");
            Mylibrary.selectvalue(objectstorage2d, "tb_srcreate_purposeofhomebuilding_list_xpath", Purpose);
            loggs.info("Purpose of home building selected from the list. Purpose of Home building: " + Purpose);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("dd_srcreate_isyourhousefrashconstruction_xpath", objectstorage2d)));
            isElementPresent("dd_srcreate_isyourhousefrashconstruction_xpath", objectstorage2d).click();
            loggs.info("Click on the 'is your hose frash construction' field. Drop-down will be opened");
            Mylibrary.selectvalue(objectstorage2d, "tb_srcreate_isyourhousefrashconstruction_list_xpath", FreshConstruction);
            loggs.info("Value is selected from the drop-down for the 'Is your house frash construction' field. Value: " + FreshConstruction);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("dd_srcreate_wanttorant_xpath", objectstorage2d)));
            isElementPresent("dd_srcreate_wanttorant_xpath", objectstorage2d).click();
            loggs.info("Click on the want to rant the house field. Drop-down will be opened");
            Mylibrary.selectvalue(objectstorage2d, "tb_srcreate_iwanttorant_list_xpath", Rent);
            loggs.info("Value is selected from dropdown for 'want to rant house' field. Value: " + Rent);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("dd_srcreate_stageofconstruction_xpath", objectstorage2d)));
            isElementPresent("dd_srcreate_stageofconstruction_xpath", objectstorage2d).click();
            loggs.info("Click on the stage of construction field. Drop-down will be opened");
            Mylibrary.selectvalue(objectstorage2d, "tb_srcreate_stageofconstruction_list_xpath", StageOfConstruction);
            loggs.info("Value is selected from the drop-down of the 'stage of the construction' field. Value: " + StageOfConstruction);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("dd_srcreate_numberoffloors_xpath", objectstorage2d)));
            isElementPresent("dd_srcreate_numberoffloors_xpath", objectstorage2d).click();
            loggs.info("Click on the number of floors filed. Drop-down sill be opened");
            Mylibrary.selectvalue(objectstorage2d, "tb_srcreate_numberoffloors_list_xpath", NumberOfFloors);
            loggs.info("Value is selected from the drop-down. Value: " + NumberOfFloors);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("ip_srcreate_plotaddress_xpath", objectstorage2d)));
            isElementPresent("ip_srcreate_plotaddress_xpath", objectstorage2d).sendKeys(Keys.COMMAND, "a", Keys.DELETE);
            loggs.info("Cleared the plot address field.");
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("ip_srcreate_plotaddress_xpath", objectstorage2d)));
            isElementPresent("ip_srcreate_plotaddress_xpath", objectstorage2d).sendKeys(PlotAddress);
            loggs.info("Enter the plot address: " + PlotAddress);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("ip_srcreate_landmark_xpath", objectstorage2d)));
            isElementPresent("ip_srcreate_landmark_xpath", objectstorage2d).sendKeys(Keys.COMMAND, "a", Keys.DELETE);
            loggs.info("Clear the landmark field.");
            isElementPresent("ip_srcreate_landmark_xpath", objectstorage2d).sendKeys(Landmark);
            loggs.info("Enter the landmark: " + Landmark);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("ip_srcreate_pincode_xpath", objectstorage2d)));
            isElementPresent("ip_srcreate_pincode_xpath", objectstorage2d).sendKeys(Keys.COMMAND, "a", Keys.DELETE);
            loggs.info("Clear the pincode field");
            isElementPresent("ip_srcreate_pincode_xpath", objectstorage2d).sendKeys(Pincode);
            loggs.info("Enter the pincode: " + Pincode);
            selectAddOn();
            selectPartner();
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("btn_srcreate_getpaymentdetails_xpath", objectstorage2d)));
            isElementPresent("btn_srcreate_getpaymentdetails_xpath", objectstorage2d).click();
            loggs.info("Click on the get payment details button");
            Mylibrary.loaderdisplay(twodlayout);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("btn_srcreate_createrequestandcollection_xpath", objectstorage2d)));
            isElementPresent("btn_srcreate_createrequestandcollection_xpath", objectstorage2d).click();
            loggs.info("Click on the create request and collection button");
            isElementPresent("btn_srcreate_createrequestandcollection_confirm_xpath", objectstorage2d).click();
            loggs.info("Click on confirm button of the dialog");
            Mylibrary.loaderdisplay(twodlayout);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("btn_srcreate_payment_sucess_link_confirm_xpath", objectstorage2d)));
            loggs.info("Payment link goining to be genrated");
            isElementPresent("btn_srcreate_payment_sucess_link_confirm_xpath", objectstorage2d).click();
            loggs.info("Click on the confirm button of the payment link dialog");
            driver.navigate().refresh();
            loggs.info("Page is refreshed");
            Mylibrary.loaderdisplay(twodlayout);
            loggs.info("SR is created and now verifying the created SR");
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("tab_sidebar_servicerequest_xpath", objectstorage)));
            isElementPresent("tab_sidebar_servicerequest_xpath", objectstorage).click();
            loggs.info("Click on the service request option from the side bar");
            isElementPresent("tab_sidebar_servicerequest_draftsrtracker_xpath", objectstorage).click();
            loggs.info("Click on the draft sr tracker option which is under servicerequest option");
            Mylibrary.loaderdisplay(twodlayout);
            Mylibrary.getScreenShot(SRNO + "_" + PersonaType + "_" + MobileNumber + "_Draft Sr List",driver,"2dlayout");
            List<WebElement> usernumberlist = driver.findElements(By.xpath(objectstorage.getProperty("tb_srtrackerlist_usernumberlist_xpath")));
            loggs.info("Get all the user number list from the SR list. List: " + usernumberlist.size());
            List<WebElement> usersrlist = driver.findElements(By.xpath(objectstorage.getProperty("tb_srtrackerlist_usersrlist_xpath")));
            loggs.info("Get all the SR name list from the SR listList: " + usersrlist.size());
            List<WebElement> usersrstatuslist = driver.findElements(By.xpath(objectstorage.getProperty("tb_srtrackerlist_usersrstatuslist_xpath")));
            loggs.info("Get all the SR status from the SR listList: " + usersrstatuslist.size());
            loggs.info("Find the created SR from the list");
            for (int i = 0; i < usernumberlist.size(); i++) {
                if (MobileNumber.equalsIgnoreCase(usernumberlist.get(i).getText())) {
                    loggs.info("Mobile mobile matched");
                    if (RequestType.equalsIgnoreCase(usersrlist.get(i).getText())) {
                        loggs.info("Reuestfor: " + RequestType);
                        if ("Draft".equalsIgnoreCase(usersrstatuslist.get(i).getText())) {
                            usernumberlist.get(i).click();
                            Mylibrary.loaderdisplay(twodlayout);
                            Mylibrary.getScreenShot(SRNO + "_" + PersonaType + "_" + MobileNumber + "_Sr created scussessfully", driver, "2dlayout");
                            Mylibrary.loaderdisplay(twodlayout);
                            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("lt_servicetracker_caseinfo_requesttype_xpath", objectstorage)));
                            loggs.info("Created SR is found and clicked on the SR");
                            loggs.info("SR details page is opened");
                            twodlayout.info("Expected Result: " + Expected);
                            twodlayout.info("Actual Result: " + isElementPresent("lt_servicetracker_caseinfo_requesttype_xpath", objectstorage).getText());
                            if (Expected.equalsIgnoreCase(isElementPresent("lt_servicetracker_caseinfo_requesttype_xpath", objectstorage).getText())) {
                                twodlayout.pass("Test Pass", MediaEntityBuilder.createScreenCaptureFromPath("../2dlayout/2dlayout_Screenshots/" + SRNO + "_" + PersonaType + "_" + MobileNumber + "_Sr created scussessfully" + ".png").build());
                            } else {
                                twodlayout.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath("../2dlayout/2dlayout_Screenshots/" + SRNO + "_" + PersonaType + "_" + MobileNumber + "_Draft Sr List" + ".png").build());
                            }
                            Mylibrary.srcancllation("Draft",isElementPresent("lt_servicetracker_caseinfo_requesttype_xpath", objectstorage).getText(),twodlayout);
                            numbernotfound = false;
                            draftSrnotcreated = false;
                            break;
                        } else {
                            loggs.info(SRNO + "SR status is not drafer or SR is not found in the list");
                            twodlayout.fail("Draft SR Is not created");
                        }
                    } else {
                        draftSrnotcreated = true;
                    }
                } else {
                    numbernotfound = true;
                }

            }
            if (numbernotfound) {
                loggs.info(SRNO + "SR is not found in the list");
                twodlayout.fail("Draft SR is not created and displayed in Draft SR page");
            }
            if (draftSrnotcreated) {
                loggs.info(SRNO + "SR is not found in the list");
                twodlayout.fail("Draft SR is not created");
            }
            Mylibrary.browserlogs(twodlayout);
        } catch (Exception e) {
            // TODO: handle exception
            Mylibrary.getScreenShot(SRNO + "_" + PersonaType + "_" + MobileNumber + "_Error", driver, "2dlayout");
            twodlayout.info("details", MediaEntityBuilder.createScreenCaptureFromPath("../2dlayout/2dlayout_Screenshots/" + SRNO + "_" + PersonaType + "_" + MobileNumber + "_Error" + ".png").build());
            twodlayout.skip(e);
            loggs.debug("An error occured", e);
            //loggs.info(e);
            Mylibrary.browserlogs(twodlayout);

        }

    }

    @Test(dataProvider = "negativeData", enabled = true)
    public void negativeData(String SRNO, String descriptions, String PersonaType, String MobileNumber, String RequestFor, String IHBType, String IHBName, String IHBNumber, String RequestType, String SubRequestType, String ProjectName, String PlotShape, String PlotArea, String PlotWidth, String Purpose, String FreshConstruction, String Rent, String StageOfConstruction, String NumberOfFloors, String PlotAddress, String Landmark, String Pincode, String Expected) throws Exception{

        loggs.info("*************** " + SRNO + " ***************");
        loggs.info(descriptions + "_" + SRNO);
        twodlayout = extent.createTest(SRNO + "_" + "2D Layout", descriptions);
        Mylibrary.loaderdisplay(twodlayout);
        driver.get(sitedata.getProperty("URL"));
        loggs.info("URL is loading");
        Mylibrary.loaderdisplay(twodlayout);
        try {
            loggs.info("2D Request raised for " + PersonaType);
            if (PersonaType.equalsIgnoreCase("IHB")) {
                Mylibrary.createSRIHB(MobileNumber, RequestType, SubRequestType, twodlayout);
            } else {
                Mylibrary.createSRPartner(MobileNumber, RequestType, SubRequestType, RequestFor, IHBType, IHBName, IHBNumber, twodlayout);
            }
            twodlayout.info("Test Data: " + SRNO + " | " + " ProjectName: " + ProjectName + " | " + "PlotShape: " + PlotShape + " | " + "PlotArea: " + PlotArea + " | " + " PlotWidth: " + PlotWidth + " | " + "Purpose: " + Purpose + " | " + "FreshConstruction: " + FreshConstruction + " | " + " Rent: " + Rent + " | " + " StageOfConstruction: " + StageOfConstruction + " | " + " NumberOfFloors: " + NumberOfFloors + " | " + "PlotAddress: " + PlotAddress + " | " + "Landmark: " + Landmark + " | " + "Pincode: " + Pincode);
            Mylibrary.loaderdisplay(twodlayout);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("ip_srcreate_projectname_xpath", objectstorage2d)));
            loggs.info("2D request inisiated for the user");
            // 2D SR creation flow
            loggs.info("Mandatory field collation flow start");
            isElementPresent("ip_srcreate_projectname_xpath", objectstorage2d).sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.DELETE));
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("ip_srcreate_projectname_xpath", objectstorage2d)));
            loggs.info("Clear the Project Name field");
            isElementPresent("ip_srcreate_projectname_xpath", objectstorage2d).sendKeys(ProjectName);
            loggs.info("Enter the Project Name: " + ProjectName);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("dd_srcreate_plotshap_xpath", objectstorage2d)));
            isElementPresent("dd_srcreate_plotshap_xpath", objectstorage2d).click();
            loggs.info("Click on the plot shape field. Drop-down will be open");
            Mylibrary.selectvalue(objectstorage2d, "tb_srcreate_plotshap_list_xpath", PlotShape);
            loggs.info("Plot shap is selected from dropdown. plotshape: " + PlotShape);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("ip_srcreate_plotarea_xpath", objectstorage2d)));
            isElementPresent("ip_srcreate_plotarea_xpath", objectstorage2d).sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.DELETE));
            loggs.info("Clear the plot area field");
            isElementPresent("ip_srcreate_plotarea_xpath", objectstorage2d).sendKeys(PlotArea);
            loggs.info("Enter the plot area: " + PlotArea);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("ip_srcreate_plotwidth_xpath", objectstorage2d)));
            isElementPresent("ip_srcreate_plotwidth_xpath", objectstorage2d).sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.DELETE));
            loggs.info("Clear the plotwidth field");
            isElementPresent("ip_srcreate_plotwidth_xpath", objectstorage2d).sendKeys(PlotWidth);
            loggs.info("Enter the Plot Width: " + PlotWidth);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("dd_srcreate_purposeofhomebuilding_xpath", objectstorage2d)));
            isElementPresent("dd_srcreate_purposeofhomebuilding_xpath", objectstorage2d).click();
            loggs.info("Click on the purpose of home building field. Drop-down will be opened.");
            Mylibrary.selectvalue(objectstorage2d, "tb_srcreate_purposeofhomebuilding_list_xpath", Purpose);
            loggs.info("Purpose of home building selected from the list. Purpose of Home building: " + Purpose);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("dd_srcreate_isyourhousefrashconstruction_xpath", objectstorage2d)));
            isElementPresent("dd_srcreate_isyourhousefrashconstruction_xpath", objectstorage2d).click();
            loggs.info("Click on the 'is your hose frash construction' field. Drop-down will be opened");
            Mylibrary.selectvalue(objectstorage2d, "tb_srcreate_isyourhousefrashconstruction_list_xpath", FreshConstruction);
            loggs.info("Value is selected from the drop-down for the 'Is your house frash construction' field. Value: " + FreshConstruction);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("dd_srcreate_wanttorant_xpath", objectstorage2d)));
            isElementPresent("dd_srcreate_wanttorant_xpath", objectstorage2d).click();
            loggs.info("Click on the want to rant the house field. Drop-down will be opened");
            Mylibrary.selectvalue(objectstorage2d, "tb_srcreate_iwanttorant_list_xpath", Rent);
            loggs.info("Value is selected from dropdown for 'want to rant house' field. Value: " + Rent);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("dd_srcreate_stageofconstruction_xpath", objectstorage2d)));
            isElementPresent("dd_srcreate_stageofconstruction_xpath", objectstorage2d).click();
            loggs.info("Click on the stage of construction field. Drop-down will be opened");
            Mylibrary.selectvalue(objectstorage2d, "tb_srcreate_stageofconstruction_list_xpath", StageOfConstruction);
            loggs.info("Value is selected from the drop-down of the 'stage of the construction' field. Value: " + StageOfConstruction);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("dd_srcreate_numberoffloors_xpath", objectstorage2d)));
            isElementPresent("dd_srcreate_numberoffloors_xpath", objectstorage2d).click();
            loggs.info("Click on the number of floors filed. Drop-down sill be opened");
            Mylibrary.selectvalue(objectstorage2d, "tb_srcreate_numberoffloors_list_xpath", NumberOfFloors);
            loggs.info("Value is selected from the drop-down. Value: " + NumberOfFloors);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("ip_srcreate_plotaddress_xpath", objectstorage2d)));
            isElementPresent("ip_srcreate_plotaddress_xpath", objectstorage2d).sendKeys(Keys.COMMAND, "a", Keys.DELETE);
            loggs.info("Cleared the plot address field.");
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("ip_srcreate_plotaddress_xpath", objectstorage2d)));
            isElementPresent("ip_srcreate_plotaddress_xpath", objectstorage2d).sendKeys(PlotAddress);
            loggs.info("Enter the plot address: " + PlotAddress);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("ip_srcreate_landmark_xpath", objectstorage2d)));
            isElementPresent("ip_srcreate_landmark_xpath", objectstorage2d).sendKeys(Keys.COMMAND, "a", Keys.DELETE);
            loggs.info("Clear the landmark field.");
            isElementPresent("ip_srcreate_landmark_xpath", objectstorage2d).sendKeys(Landmark);
            loggs.info("Enter the landmark: " + Landmark);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("ip_srcreate_pincode_xpath", objectstorage2d)));
            isElementPresent("ip_srcreate_pincode_xpath", objectstorage2d).sendKeys(Keys.COMMAND, "a", Keys.DELETE);
            loggs.info("Clear the pincode field");
            isElementPresent("ip_srcreate_pincode_xpath", objectstorage2d).sendKeys(Pincode);
            loggs.info("Enter the pincode: " + Pincode);
            selectAddOn();
            if (Expected.equalsIgnoreCase(Mylibrary.getalaertmessage())) {
                Mylibrary.getScreenShot(SRNO + "_" + PersonaType + "_" + MobileNumber + "_SR is not created", driver, "2dlayout");
                twodlayout.pass("Test Pass", MediaEntityBuilder.createScreenCaptureFromPath("../2dlayout/2dlayout_Screenshots/" + SRNO + "_" + PersonaType + "_" + MobileNumber + "_SR is not created" + ".png").build());
            } else {
                Mylibrary.getScreenShot(SRNO + "_" + PersonaType + "_" + MobileNumber + "_SR is created with invalid data", driver, "2dlayout");
                twodlayout.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath("../2dlayout/2dlayout_Screenshots/" + SRNO + "_" + PersonaType + "_" + MobileNumber + "_SR is created with invalid data" + ".png").build();
            }
        } catch (Exception e) {
            // TODO: handle exception
            Mylibrary.getScreenShot(SRNO + "_" + PersonaType + "_" + MobileNumber + "_Error", driver, "2dlayout");
            twodlayout.info("details", MediaEntityBuilder.createScreenCaptureFromPath("../2dlayout/2dlayout_Screenshots/" + SRNO + "_" + PersonaType + "_" + MobileNumber + "_Error" + ".png").build());
            twodlayout.skip(e);
            loggs.debug("An error occured", e);
            Mylibrary.browserlogs(twodlayout);

        }
    }

    @Test(dataProvider = "serviceAvailabilityCheck", enabled = true)
    public void serviceAvailabilityCheck(String SRNO, String descriptions, String PersonaType, String MobileNumber, String RequestFor, String IHBType, String IHBName, String IHBNumber, String RequestType, String SubRequestType, String ProjectName, String PlotShape, String PlotArea, String PlotWidth, String Purpose, String FreshConstruction, String Rent, String StageOfConstruction, String NumberOfFloors, String PlotAddress, String Landmark, String Pincode, String Expected)throws Exception{
        loggs.info("*************** " + SRNO + " ***************");
        loggs.info(descriptions + "_" + SRNO);
        twodlayout = extent.createTest(SRNO + "_" + "2D Layout", descriptions);
        Mylibrary.loaderdisplay(twodlayout);
        driver.get(sitedata.getProperty("URL"));
        loggs.info("URL is loading");
        Mylibrary.loaderdisplay(twodlayout);

        try {

            loggs.info("2D Request raised for " + PersonaType);
            if (PersonaType.equalsIgnoreCase("IHB")) {
                Mylibrary.createSRIHB(MobileNumber, RequestType, SubRequestType, twodlayout);
            } else {
                Mylibrary.createSRPartner(MobileNumber, RequestType, SubRequestType, RequestFor, IHBType, IHBName, IHBNumber, twodlayout);
            }
            twodlayout.info("Test Data: " + SRNO + " | " + " ProjectName: " + ProjectName + " | " + "PlotShape: " + PlotShape + " | " + "PlotArea: " + PlotArea + " | " + " PlotWidth: " + PlotWidth + " | " + "Purpose: " + Purpose + " | " + "FreshConstruction: " + FreshConstruction + " | " + " Rent: " + Rent + " | " + " StageOfConstruction: " + StageOfConstruction + " | " + " NumberOfFloors: " + NumberOfFloors + " | " + "PlotAddress: " + PlotAddress + " | " + "Landmark: " + Landmark + " | " + "Pincode: " + Pincode);
            Mylibrary.loaderdisplay(twodlayout);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("ip_srcreate_projectname_xpath", objectstorage2d)));
            loggs.info("2D request inisiated for the user");

            // 2D SR creation flow
            loggs.info("Mandatory field collation flow start");
            isElementPresent("ip_srcreate_projectname_xpath", objectstorage2d).sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.DELETE));
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("ip_srcreate_projectname_xpath", objectstorage2d)));
            loggs.info("Clear the Project Name field");
            isElementPresent("ip_srcreate_projectname_xpath", objectstorage2d).sendKeys(ProjectName);
            loggs.info("Enter the Project Name: " + ProjectName);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("dd_srcreate_plotshap_xpath", objectstorage2d)));
            isElementPresent("dd_srcreate_plotshap_xpath", objectstorage2d).click();
            loggs.info("Click on the plot shape field. Drop-down will be open");
            Mylibrary.selectvalue(objectstorage2d, "tb_srcreate_plotshap_list_xpath", PlotShape);
            loggs.info("Plot shap is selected from dropdown. plotshape: " + PlotShape);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("ip_srcreate_plotarea_xpath", objectstorage2d)));
            isElementPresent("ip_srcreate_plotarea_xpath", objectstorage2d).sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.DELETE));
            loggs.info("Clear the plot area field");
            isElementPresent("ip_srcreate_plotarea_xpath", objectstorage2d).sendKeys(PlotArea);
            loggs.info("Enter the plot area: " + PlotArea);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("ip_srcreate_plotwidth_xpath", objectstorage2d)));
            isElementPresent("ip_srcreate_plotwidth_xpath", objectstorage2d).sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.DELETE));
            loggs.info("Clear the plotwidth field");
            isElementPresent("ip_srcreate_plotwidth_xpath", objectstorage2d).sendKeys(PlotWidth);
            loggs.info("Enter the Plot Width: " + PlotWidth);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("dd_srcreate_purposeofhomebuilding_xpath", objectstorage2d)));
            isElementPresent("dd_srcreate_purposeofhomebuilding_xpath", objectstorage2d).click();
            loggs.info("Click on the purpose of home building field. Drop-down will be opened.");
            Mylibrary.selectvalue(objectstorage2d, "tb_srcreate_purposeofhomebuilding_list_xpath", Purpose);
            loggs.info("Purpose of home building selected from the list. Purpose of Home building: " + Purpose);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("dd_srcreate_isyourhousefrashconstruction_xpath", objectstorage2d)));
            isElementPresent("dd_srcreate_isyourhousefrashconstruction_xpath", objectstorage2d).click();
            loggs.info("Click on the 'is your hose frash construction' field. Drop-down will be opened");
            Mylibrary.selectvalue(objectstorage2d, "tb_srcreate_isyourhousefrashconstruction_list_xpath", FreshConstruction);
            loggs.info("Value is selected from the drop-down for the 'Is your house frash construction' field. Value: " + FreshConstruction);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("dd_srcreate_wanttorant_xpath", objectstorage2d)));
            isElementPresent("dd_srcreate_wanttorant_xpath", objectstorage2d).click();
            loggs.info("Click on the want to rant the house field. Drop-down will be opened");
            Mylibrary.selectvalue(objectstorage2d, "tb_srcreate_iwanttorant_list_xpath", Rent);
            loggs.info("Value is selected from dropdown for 'want to rant house' field. Value: " + Rent);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("dd_srcreate_stageofconstruction_xpath", objectstorage2d)));
            isElementPresent("dd_srcreate_stageofconstruction_xpath", objectstorage2d).click();
            loggs.info("Click on the stage of construction field. Drop-down will be opened");
            Mylibrary.selectvalue(objectstorage2d, "tb_srcreate_stageofconstruction_list_xpath", StageOfConstruction);
            loggs.info("Value is selected from the drop-down of the 'stage of the construction' field. Value: " + StageOfConstruction);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("dd_srcreate_numberoffloors_xpath", objectstorage2d)));
            isElementPresent("dd_srcreate_numberoffloors_xpath", objectstorage2d).click();
            loggs.info("Click on the number of floors filed. Drop-down sill be opened");
            Mylibrary.selectvalue(objectstorage2d, "tb_srcreate_numberoffloors_list_xpath", NumberOfFloors);
            loggs.info("Value is selected from the drop-down. Value: " + NumberOfFloors);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("ip_srcreate_plotaddress_xpath", objectstorage2d)));
            isElementPresent("ip_srcreate_plotaddress_xpath", objectstorage2d).sendKeys(Keys.COMMAND, "a", Keys.DELETE);
            loggs.info("Cleared the plot address field.");
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("ip_srcreate_plotaddress_xpath", objectstorage2d)));
            isElementPresent("ip_srcreate_plotaddress_xpath", objectstorage2d).sendKeys(PlotAddress);
            loggs.info("Enter the plot address: " + PlotAddress);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("ip_srcreate_landmark_xpath", objectstorage2d)));
            isElementPresent("ip_srcreate_landmark_xpath", objectstorage2d).sendKeys(Keys.COMMAND, "a", Keys.DELETE);
            loggs.info("Clear the landmark field.");
            isElementPresent("ip_srcreate_landmark_xpath", objectstorage2d).sendKeys(Landmark);
            loggs.info("Enter the landmark: " + Landmark);
            wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("ip_srcreate_pincode_xpath", objectstorage2d)));
            isElementPresent("ip_srcreate_pincode_xpath", objectstorage2d).sendKeys(Keys.COMMAND, "a", Keys.DELETE);
            loggs.info("Clear the pincode field");
            isElementPresent("ip_srcreate_pincode_xpath", objectstorage2d).sendKeys(Pincode);
            loggs.info("Enter the pincode: " + Pincode);
            Mylibrary.loaderdisplay(twodlayout);
            selectAddOn();
            if (Expected.equalsIgnoreCase(Mylibrary.getalaertmessage())) {
                Mylibrary.getScreenShot(SRNO + "_" + PersonaType + "_" + MobileNumber + "_SR is not created if service is not available for entered pin code", driver, "2dlayout");
                twodlayout.pass("Test Pass", MediaEntityBuilder.createScreenCaptureFromPath("../2dlayout/2dlayout_Screenshots/" + SRNO + "_" + PersonaType + "_" + MobileNumber + "_SR is not created if service is not available for entered pin code" + ".png").build());
            } else {
                Mylibrary.getScreenShot(SRNO + "_" + PersonaType + "_" + MobileNumber + "_SR is created if service is not available for entered pin code", driver, "2dlayout");
                twodlayout.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath("../2dlayout/2dlayout_Screenshots/" + SRNO + "_" + PersonaType + "_" + MobileNumber + "_SR is not created if service is not available for entered pin code" + ".png").build());
            }
        } catch (Exception e) {
            // TODO: handle exception
            Mylibrary.getScreenShot(SRNO + "_" + PersonaType + "_" + MobileNumber + "_Error", driver, "2dlayout");
            twodlayout.info("details", MediaEntityBuilder.createScreenCaptureFromPath("../2dlayout/2dlayout_Screenshots/" + SRNO + "_" + PersonaType + "_" + MobileNumber + "_Error" + ".png").build());
            twodlayout.skip(e);
            loggs.debug("An error occured", e);
            Mylibrary.browserlogs(twodlayout);

        }

    }

    @AfterTest
    public void completedtestcase() throws InterruptedException, EmailException, IOException {

        Thread.sleep(5000);
        extent.flush();

    }

    // Get the data from excel for 2D SR
    @DataProvider
    public Object[][] positiveData() {

        loggs.info("Get the data from the following excel sheets. " + sr2dlayout + " : positiveData");
        return Mylibrary.getTestDataFromXLSX(sr2dlayout, "positiveData");
    }

    @DataProvider
    public Object[][] negativeData() {

        loggs.info("Get the data from the following excel sheets. " + sr2dlayout + " : negativeData");
        return Mylibrary.getTestDataFromXLSX(sr2dlayout, "negativeData");
    }

    @DataProvider
    public Object[][] serviceAvailabilityCheck() {

        loggs.info("Get the data from the following excel sheets. " + sr2dlayout + " : serviceAvailabilityCheck");
        return Mylibrary.getTestDataFromXLSX(sr2dlayout, "serviceAvailabilityCheck");
    }

    // Click on the next button of all the 2D layout pages
    public static void nextbutton() throws Exception {

        Thread.sleep(4000);
        try {
            isElementPresent("btn_2dlayout_detailspages_next_xpath", objectstorage2d).click();

        } catch (Exception e) {
            // TODO: handle exception
            isElementPresent("btn_2dlayout_detailspages_next_xpath", objectstorage2d).click();
        }
    }

    public static void selectAddOn() throws Exception {
        List<WebElement> element = driver.findElements(By.xpath(objectstorage.getProperty("lt_createSR_addons_no_xpath")));
        if (element.size() == 0) {
            List<WebElement> AddOn = driver.findElements(By.xpath(objectstorage.getProperty("tb_createSR_addons_list_xpath")));
            AddOn.get(0).click();
        }
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(objectstorage.getProperty("btn_createSR_addons_getPartnerDetails_xpath")))));
        isElementPresent("btn_createSR_addons_getPartnerDetails_xpath",objectstorage).click();
    }

    public static void selectPartner() throws Exception{
        Mylibrary.loaderdisplay(twodlayout);
        List<WebElement> partnerlist = driver.findElements(By.xpath(objectstorage.getProperty("tb_createSR_partner_list_xpath")));
        partnerlist.get(0).click();
    }
}
