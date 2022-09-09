package webp.img.getter;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WEBP_Image_Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		
		WebDriver driver =	WebDriverManager.chromedriver().create();
		JavascriptExecutor jsScroller = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		String inputURLFile ="D:\\Work\\Site Data\\CIC\\CIC_WP_Migration\\WEBPIMAGES\\CIC_URLS.txt";
		String outputPath ="D:\\Work\\Site Data\\CIC\\CIC_WP_Migration\\WEBPIMAGES\\CIC_output_webpe.csv";
		String attrSrcset ="srcset";
        String atrrSrc ="src";		
        String attrHref ="href";
        
        FileWriter csvWriter = new FileWriter(outputPath, true);
		String finalBuilt = "URL,WEBIMAges" ;

		csvWriter.append(finalBuilt);
		csvWriter.append("\n");
		csvWriter.flush();
		csvWriter.close();
		finalBuilt = "";
        
        
        
		List<String> inputURLS = Files.readAllLines(Paths.get(inputURLFile));
		
		
		WebPImageRun checkWebpimg = new WebPImageRun();
		checkWebpimg.getWebPIMGDetails(inputURLS,outputPath,driver,attrSrcset,atrrSrc,attrHref,jsScroller);
		
		
		
		driver.close();
		driver.quit();
		
	}

}
