package processing;

public class GetConditions 
{
	private static String[] GetConditions(String conditions) {
		int ii = 1;
		String[] lineList = conditions.split("\n");
		int nrOfConditions = Integer.valueOf(lineList[0].split(" ")[1]);
		
		for(int i = 0; i < nrOfConditions; i++)
		{
			String nextLine = lineList[ii];
			while(nextLine.toLowerCase().contains("condition_" + i))
			{
				
				
				nextLine = lineList[ii++];
			}
		}
		
		return null;
	}
}
