package webp.img.getter;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class WEpbgetData {

	public List<String> getWEbPData(List<WebElement> attrWebp, int WebPCount, String atrributename) {
		// TODO Auto-generated method stub
		
		List<String> atributedataList = new ArrayList<String>();
		
		if(WebPCount > 0)
		{
			
			for(WebElement attrbutename : attrWebp)
			{
			
				atributedataList.add(attrbutename.getAttribute(atrributename));
				
		    }
			return atributedataList;
		}
		else
		{
			return atributedataList;
		}
		
		
		
	}

}
