package webp.img.getter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ResultGenrate {

	public void getResult(List<String> attributeWEBPList, String outputPath, String link) throws IOException {
		// TODO Auto-generated method stub
		
		
		for(int i=0;i<attributeWEBPList.size();i++)
		{
			
			
			
			if(i==0)
			{
		FileWriter csvWriter = new FileWriter(outputPath, true);
		String finalBuilt = link + ","+attributeWEBPList.get(i) ;

		csvWriter.append(finalBuilt);
		csvWriter.append("\n");
		csvWriter.flush();
		csvWriter.close();
		finalBuilt = "";
			}
			else
			{
				link="";
				FileWriter csvWriter = new FileWriter(outputPath, true);
				String finalBuilt = link + ","+attributeWEBPList.get(i) ;

				csvWriter.append(finalBuilt);
				csvWriter.append("\n");
				csvWriter.flush();
				csvWriter.close();
				finalBuilt = "";
			}
		
		
		}
		
		
	}

}
