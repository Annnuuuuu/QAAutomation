package runners;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.Driver;
import utils.PropertyFileReader;


@CucumberOptions
(
		 plugin = { "pretty",
				 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				 "html:Reports/HtmlReport/cucumber-reports.html"},
features={"src/test/resources/features"},
glue={"stepDefinitions"},

tags="@iCapEquity_AddFund",


dryRun = false
)

public class ICapRunner extends AbstractTestNGCucumberTests {
	
	
    public static String environment="Stage";
    
	
	@BeforeClass
	public void setup() throws InterruptedException 
	{
		PropertyFileReader.loadData(environment);
		Driver.driveSetup();
	}
	
	@Test
	public void testclass()
	{
		
	}
	
	@AfterTest
	public void reportBkp() throws IOException {
	
		String pdfReport =System.getProperty("user.dir")+"\\Reports\\PDFReport\\Result.pdf";
		String pdfReportBkp = System.getProperty("user.dir")+"\\Reports\\PDFReport_Bkp\\Result_"+new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(new Date())+".pdf";
	        File pdf_Src = new File(pdfReport);
	        File pdf_Des = new File(pdfReportBkp);
	        Files.copy(pdf_Src.toPath(), pdf_Des.toPath());
	}
	
//	@AfterClass
//	public void tearDown()
//	{
//		//driver.quit();
//	}

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
