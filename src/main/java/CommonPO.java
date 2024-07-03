import org.openqa.selenium.By;

public class CommonPO {

//    ########################################## first scenario ################################################
    //    1st page
    public static By loginEmailField = By.xpath("//*[@text='Enter your email']");
    public static By passwordField = By.xpath("//*[@text='Password']");
    public static By loginCTA = By.xpath("//*[@text='Login']");
    //    2nd page
    public static By plus =By.xpath ("(//*[@class='android.widget.ImageView'])[4]");
    //    3d page
    public static By createServReq = By.xpath("//*[@text='Create Service Request']");
    //    4th page
    public static By selectComm = By.xpath("//*[@text='Select community']");
    public static By TT_Residential =By.xpath("//*[@text='TT Residential']");
    public static By selectUnit = By.xpath("//*[@text='Select unit']");
    public static By unit =By.xpath("//*[@text='110']");
    public static By selectTenant = By.xpath("//*[@text='Select tenant']");
    public static By anotherTenant =By.xpath("//*[@text='Another tenant']");
    //    5th page
    public static By fullNameField = By.xpath("//*[@text='Full name']");
    public static By emailField = By.xpath("//*[@text='Email']");
    public static By countryCodeField = By.xpath("//*[@text='Country Code']");
    public static By phoneField = By.xpath("//*[@text='Phone #']");
    public static By nextCTA = By.xpath("//*[@text='NEXT']");
    //    6th page
    public static By homeApplicances =By.xpath("//*[@text='Home Appliances']");
    //    7th page
    public static By provider = By.xpath("//*[@text='TenexFM']");
    //    8th page
    public static By item =By.xpath("//*[@text='Oven']");
    //    9th page
    public static By cameraIcon =By.xpath("(//*[@class='android.widget.ImageView'])[3]");
    public static By imageFromCamera = By.xpath("//*[@text='Image from Camera']");
    //    10th page
    public static By capturePhoto =By.id("com.sec.android.app.camera:id/shutter_area");
    public static By okCTA = By.xpath("//*[@text='OK']");
    //    11th page
    public static By capturedImage = By.xpath("(//*[@class='android.widget.ImageView'])[3]");
    //    12th page
    public static By micIcon = By.xpath("(//*[@class='android.widget.ImageView'])[3]");
    public static By textField = By.xpath("//*[@class='android.widget.EditText']");
    public static By XcloseRecord = By.xpath("//*[@class='android.widget.ImageView'])[5]");
    //    13th page
    public static By createServReqCTA = By.xpath("//*[@text='CREATE SERVICE REQUEST']");


    //    ########################################## second scenario ################################################
    //    1st page
    By filterIcon = By.xpath("//*[@text='Filters']");
    //    2nd page
    By activeTap = By.xpath("//*[@text='ACTIVE']");
    By acceptedStatus = By.xpath("//*[@text='Accepted']");
    By homeApplicancesServiceType =By.xpath("//*[@text='Home Appliances']");
    By applyFiltersCTA = By.xpath("//*[@text='APPLY FILTERS']");
    //    3rd page
    By searchBar = By.xpath("//*[@class='android.widget.EditText']");
    //    4th page
    By replyTextArea =By.xpath("//*[@text='Type your comment here...']");
    By sendIcon =By.xpath("(//*[@class='android.widget.ImageView'])[8]");
    By sendToClient = By.xpath("//*[@text='SEND TO CLIENT']");
    By addStandardRes = By.xpath("//*[@text='Add Standard Response...']");
    By firstResponse = By.xpath("//*[contains(@text,'Thank you Yogesh for sending this service request for apartment S-01.')]");
//    By firstResponse = By.xpath("//*[@text='Thank you Yogesh for sending this service request for apartment S-01.']");
    //    By firstResponse = By.xpath("(//*[@class='android.widget.TextView'])[1])")[1]...create string and save the value of the .text of this element
    By internalTeam =By.xpath("//*[@text='Internal Team']");
    By sendIconInternal =By.xpath("(//*[@class='android.widget.ImageView'])[9]");
    By sendToInternalTeam = By.xpath("//*[@text='SEND TO INTERNAL TEAM']");
    By acceptedStatusBadge =By.xpath("//*[@text='ACCEPTED']");
    By approvedStatus =By.xpath("//*[@text='Approved']");
    By saveCTA = By.xpath("//*[@text='Save']");
    By approvedStatusBadge = By.xpath("//*[@text='APPROVED']");

}
