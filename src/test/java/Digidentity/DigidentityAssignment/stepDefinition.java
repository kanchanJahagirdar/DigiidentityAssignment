package Digidentity.DigidentityAssignment;


import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.DdySmallAppPages.Confirmation;
import com.DdySmallAppPages.LoginPage;
import com.DdySmallAppPages.NewAccountPage;
import com.DdySmallAppPages.NewAddress;
import com.DdySmallAppPages.NewProfile;

public class stepDefinition {

    public static WebDriver obj;
    public static String systemPath;
    
    @Given("^Open Browser and Application$")
	   public void url_opened(DataTable UrlLauch) {
		   List<List<String>> Browserdata = UrlLauch.raw();
		   //Here we decide which browser should be selected for execution
			  systemPath=Browserdata.get(0).get(0);
			  String browser = Browserdata.get(0).get(1);
			 if(browser.equals("chrome")){
				  	System.setProperty("webdriver.chrome.driver", systemPath+"\\chromedriver.exe");
				  	obj=new ChromeDriver();
				  	obj.manage().window().maximize();
					obj.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
					obj.get("http://localhost:3000/sign_in");
					
				}
				else{
					obj= new FirefoxDriver();
					obj.manage().window().maximize();
					obj.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
					obj.get("http://localhost:3000/sign_in");
				}		   		  	      	      
	   }
	   
	   		    
	   @Then("^enter userid and password$")
	   public void enter_userid_and_password(DataTable credentials) throws Throwable {
		  
		  LoginPage login = new LoginPage(obj);  
		  List<List<String>> Logindata = credentials.raw();	   
		  String email =Logindata.get(0).get(0);
		  String password = Logindata.get(0).get(1);
		  login.SignToDdy(email,password);
		
	   }
	    
	@When("^Click Register$")
	public void click_Register() throws InterruptedException {
		LoginPage login = new LoginPage(obj); 
		login.RegisterToDdy();
	    Thread.sleep(1000);
	}
	
	@When("^Enter New Account details$")
	public void enter_New_Account_details(DataTable AccDetails) throws InterruptedException {
		NewAccountPage accnt = new NewAccountPage(obj);	
		List<List<String>> Accountdata = AccDetails.raw();	
		accnt.NewAccountDetails(Accountdata.get(0).get(0), Accountdata.get(0).get(1));
	}
	
	@When("^Enter New Account details for registration$")
	public void enter_New_Account_details_for_registration(DataTable AccDetails) throws InterruptedException {
		NewAccountPage accnt = new NewAccountPage(obj);
		
		List<List<String>> Accountdata = AccDetails.raw();
		//Logic to generated unique mail id each time
		
		String userName = ""+(int)(Math.random()*Integer.MAX_VALUE);
		String mailID = Accountdata.get(0).get(0)+userName+"@abc.com";
		System.out.println(mailID);
		accnt.NewAccountDetails(mailID, Accountdata.get(0).get(1));
		
	}
	
	@Then("^Verify New Profile page$")
	public void verify_New_Profile_page() throws Throwable {
	
		String pageVal = obj.findElement(By.tagName("h1")).getText();
		if(pageVal.equalsIgnoreCase("New Profile"))
		{
			System.out.println("Naviagted successfully to profile page");
		}
		else {
			System.out.println("Navigation to New Profile page failed");
		}
	}
	
	@When("^Enter Profile details Name Surname and DOB$")
	public void enter_Profile_details_Name_Surname_and_DOB(DataTable ProfileDetails) throws Throwable {
		NewProfile profile = new NewProfile(obj);
		List<List<String>> Profiledata = ProfileDetails.raw();
		profile.NewProfiledetails((Profiledata.get(0).get(0)), (Profiledata.get(0).get(1)));
		profile.BirthDaydetails((Profiledata.get(0).get(2)), (Profiledata.get(0).get(3)), (Profiledata.get(0).get(4)));
		
	}
	
	@Then("^Verify New address page$")
	public void verify_New_address_page() throws Throwable {
	    
		String pageVal = obj.findElement(By.tagName("h1")).getText();
		if(pageVal.equalsIgnoreCase("New Address"))
		{
			System.out.println("Naviagted successfully to address page");
		}
		else {
			System.out.println("New Address Creation failed");
		}
	}
	
	@When("^Enter Address Street HouseNo and Postcode$")
	public void enter_Address_Street_HouseNo_and_Postcode(DataTable AddressDetails) throws InterruptedException {
		List<List<String>> Addressdata = AddressDetails.raw();
		 NewAddress address = new NewAddress(obj);
		address.Addressdetails((Addressdata.get(0).get(0)), (Addressdata.get(0).get(1)), (Addressdata.get(0).get(2)));
		
	}
	
	@Then("^Verify confirmation page$")
	public void verify_confirmation_page() throws Throwable {
			 
		int Btn_confirmsize = obj.findElements(By.xpath("//input[@value='Confirm']")).size();
		 if (Btn_confirmsize > 0)
		 {System.out.println("Navigated successfully to confirmation page");		 
		 }
		 else
		 {
			 System.out.println("Navigation to confirmation page failed");
		 }
	}
	
	@When("^User click on Confirm$")
	public void user_click_on_Confirm() throws InterruptedException {
		 Confirmation cnf =new Confirmation(obj);
		cnf.ClickConfirmBtn();
			    
	}
	
	@Then("^Verify Successfully registered message$")
	public void verify_Successfully_registered_message() throws Throwable {
	
		String Message= obj.findElement(By.id("notice")).getText();
		if(Message.equalsIgnoreCase("Successfully registered"))
		{
			obj.findElement(By.xpath("//a[@href='/sign_out']")).click();
			Thread.sleep(1000);
		}
		else {
			System.out.println("Final page confirmation failed");
		}
	}
	  
	
	   @Then("^It should successfully navigate to next page$")
	   public void verification() {
		   System.out.println(obj.getTitle());
	   }
	   
	   @Then("^Verify Account creation prohibited$")
	   public void NegativeTest() {
		   String Error = obj.findElement(By.tagName("h2")).getText();
		   System.out.println(Error);
		   String ExpectedMsg = "1 error prohibited this account from being saved:";
		   if (Error.equalsIgnoreCase(ExpectedMsg)) {
			   System.out.println("Negative testing successfull");
		   }
	   }
	
	   @Then("^Verify Error Message$")
	   public void ErrorVerification() {
		   String Error = obj.findElement(By.xpath("//div[@id='error_explanation']/ul/li")).getText();
		   System.out.println(Error);
		   String ExpectedMsg = "Password can't be blank";
		   if (Error.equalsIgnoreCase(ExpectedMsg)) {
			   System.out.println("Negative testing successfull");
		   }
	   }
	   
	   @Then("^CloseBrowser$")
	   public void CloseBrowser() 
	   {
	
		   obj.close();
	   }
}