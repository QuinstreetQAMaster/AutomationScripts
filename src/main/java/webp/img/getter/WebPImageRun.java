package webp.img.getter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
//import java.util.stream.Stream;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebPImageRun {

	public void getWebPIMGDetails(List<String> inputURLS, String outputPath, WebDriver driver, String attrSrcset, String atrrSrc, String attrHref, JavascriptExecutor jsScroller) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WEpbgetData  getdata = new WEpbgetData();
		  ResultGenrate result = new ResultGenrate();
		  List<String> allWEbPattrbuteData = new ArrayList<String>();
		int f =1;
		for(String link : inputURLS)
		{
			
			driver.get(link);
			jsScroller.executeScript("window.scrollBy(0,1500)");
			Thread.sleep(2000);
			System.out.println(f+" ) "+link);
		  List<WebElement> TypeWebp = driver.findElements(By.xpath("//*[@type='image/webp']"));
	      List<WebElement> SrcWebP = driver.findElements(By.xpath("//*[contains(@src,'webp')]"));
	      List<WebElement> HrefWebP = driver.findElements(By.xpath("//*[contains(@href,'webp')]"));
	      
	      int TypeWebpCount = TypeWebp.size();
	      int SrcWebPCount = SrcWebP.size();
	      int HrefWebPCount = HrefWebP.size();
	      
	      
	      //Type WEBP
	   List<String>  TypeWEBPList =   getdata.getWEbPData(TypeWebp,TypeWebpCount,attrSrcset);
	      
	      //SRC WEBP
	   List<String>  SRCWEBPList =      getdata.getWEbPData(SrcWebP,SrcWebPCount,atrrSrc);
	      
	      //Href WEBP
	   List<String>  HrefWEBPList =   getdata.getWEbPData(HrefWebP,HrefWebPCount,attrHref);
	   
	 
	 //  allWEbPattrbuteData =  Stream.concat(TypeWEBPList.stream(), SRCWEBPList.stream(),HrefWEBPList.stream().collect(Collectors.toList()));
	   
	   allWEbPattrbuteData.addAll(TypeWEBPList);
	   allWEbPattrbuteData.addAll(SRCWEBPList);
	   allWEbPattrbuteData.addAll(HrefWEBPList);
	   
	   
	   
	   if(allWEbPattrbuteData.size()>0)
	   {
	   result.getResult(allWEbPattrbuteData,outputPath,link);
	   }
	   
	   TypeWEBPList.clear();
	   SRCWEBPList.clear();
	   HrefWEBPList.clear();
	   allWEbPattrbuteData.clear();
	   
			f++;
		}
		
	
		
	}

}
