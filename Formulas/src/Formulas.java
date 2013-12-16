import java.util.*;

public class Formulas {
	
	public static String AVERAGE(String in)
	{
		ArrayList<Cell> range = debrij(in);
		double getal = 0;
		String s;
		try
		{
			int c = 0;
			for(int i = 0; i < range.size(); i++)
			{
				getal = getal + Double.parseDouble(range.get(0).getContent());
				c++;
			}
			getal = getal / c;
		}
		catch(NumberFormatException e)
		{
			System.out.println("De ingegeven String is geen getal.");
		}
		s = getal + " ";
		return s;
	}
	
	public String INT(String in)
	{
		ArrayList<Cell> range = debrij(in);
		if(range.size() != 1){
			System.out.println("Geef 1 Cell in!");	
		}
		int i = 0;
		try 
		{    
			Scanner sc = new Scanner(range.get(0).getContent()).useDelimiter(",");
			i = sc.nextInt();
		}
		catch(NumberFormatException e)
		{
			return "De ingegeven waarde is geen getal";
		}
		String s = i + " ";
		return s;
	}
	
	public String ISNUMBER(String in)
	{
		ArrayList<Cell> range = debrij(in);
		if(range.size() != 1)
		{
			return "false";			
		}
		try 
		{
			double getal = Double.parseDouble(range.get(0).getContent());       
		}
		catch(NumberFormatException e)
		{
			return "false";
		}
		return "true";
	}
	
	public String ISEVEN(String in)
	{
		ArrayList<Cell> range = debrij(in);
		if(range.size() != 1)
		{
			return "false";			
		}
		try 
		{
			double getal = Double.parseDouble(range.get(0).getContent());
			if(getal%2 == 1){
				return "false";
			}
		}
		catch(NumberFormatException e)
		{
			System.out.println("# VALUE");
		}
		return "true";
	}

	public String ISLOGICAL(String in)
	{
		ArrayList<Cell> range = debrij(in);
		if(range.size() != 1){
			return "false";			
		}
		if(range.get(0).getContent() == "true" || range.get(0).getContent() == "false"){
				return "true";
		}
		else{
				return "false";
		}
	}
	
	public String max(String in)
	{
		ArrayList<Cell> range = debrij(in);
		double max = Double.MIN_VALUE;
		double contestor = 0;
		if(range.size() == 0) return "null";
		try{
			max = Double.parseDouble(range.get(1).getContent());
		} catch(Exception e){
			return "#VALUE";
		}
		for(Cell c : range){
			try{
			contestor = Double.parseDouble(c.getContent());
			} catch (Exception e){
				return "#VALUE";
			}
			if (contestor > max) {
				max = contestor;
			}
		}
		return Double.toString(max);
	}
	
	//returns the cell containing the largest number
		public String MAX(String in) throws Exception{
			ArrayList<Cell> cl = debrij(in);
			Cell maxCell = cl.get(0);
			for(int i = 0; i < cl.size(); i++){
				//check if cell contains only a number
				if(!cl.get(i).getContent().matches("\\d+")){
					throw new Exception("Error: can only compare numbers");
				}
				//check if cell is greater than current biggest cell, if so, make cell current biggest cell
				if(Double.parseDouble(cl.get(i).getContent()) > Double.parseDouble(maxCell.getContent())){
					maxCell = cl.get(i);
				}
			}
			return maxCell.getContent();
		}
		
		//returns the cell containing the smallest number
		public String MIN(String in) throws Exception{
			ArrayList<Cell> cl = debrij(in);
			Cell minCell = cl.get(0);
			for(int i = 0; i < cl.size(); i++){
				//check if cell contains only a number
				if(!cl.get(i).getContent().matches("\\d+")){
					throw new Exception("Error: can only compare numbers");
				}
				//check if cell is smaller than current smallest cell, if so, make cell current smallest cell
				if(Double.parseDouble(cl.get(i).getContent()) < Double.parseDouble(minCell.getContent())){
					minCell = cl.get(i);
				}
			}
			return minCell.getContent();
		}
		
		//returns the cell containing the median of all input cells
		public String MEDIAN(String in) throws Exception{
			ArrayList<Cell> cl = debrij(in);
			int halfOfCells = 0;
			
			//check if all input cells are valid numbers
			for(int i = 0; i < cl.size(); i++){
				if(!cl.get(i).getContent().matches("\\d+")){
					throw new Exception("Error: can only use numbers");
				}
			}
			//check if even or odd number of cells,
			//if even, take mean of middle two values
			if(cl.size() % 2 == 0){
				halfOfCells = (int)Math.floor(cl.size() / 2);
				int leftCellValue = Integer.parseInt(cl.get(halfOfCells).getContent());
				int rightCellValue = Integer.parseInt(cl.get(halfOfCells + 1).getContent());
				int mean = (leftCellValue + rightCellValue) / 2;
				String retString = "" + mean;
				return retString;
			}
			//if odd, return middle value
			if(cl.size() % 2 != 0){
				halfOfCells = (int)Math.ceil(cl.size() / 2);
				return cl.get(halfOfCells).getContent();
			}
			return null;
		}
	
	public String NOT(String in)
	{
		ArrayList<Cell> range = debrij(in);
		if(range.size() != 1){
			System.out.println("Geef 1 Cell in!");;			
		}
		if(range.get(0).getContent() == "true" || range.get(0).getContent() == "false"){
				return "true";
		}
		else{
				return "false";
		}
	}
	
	public String COUNT(String in)
	{
		ArrayList<Cell> range = debrij(in);
		String result = "";
		int c = 0;
		for(int i = 0; i < range.size(); i++)
		{
		    for (int j = 0; j < 10; j++) 
		    {
		    	if(range.get(i).getContent().charAt(j)+"" == "\\d+")
		    		c++;
		    }
		}
		result = c + " ";
	    return result;
	}
	
	public String COUNTA(String in)
	{
		ArrayList<Cell> range = debrij(in);
		String result = "";
		int c = 0;
		for(int i = 0; i < range.size(); i++)
		{
			Scanner sc = new Scanner(range.get(i).getContent());
			if(sc.hasNext())
				c++;
		}
		result = c + " ";
	    return result;
	}
	
	public String COUNTIF(String in)
	{
		ArrayList<Cell> range = debrij(in);
		String result = "";
		int c = 0;
		for(int i = 0; i < range.size(); i++)
		{
			Scanner sc = new Scanner(range.get(i).getContent());
			if(sc.hasNext())
				c++;
		}
		result = c + " ";
	    return result;
	}
	
	public String PROPER(String in)
	{
		ArrayList<Cell> range = debrij(in);
		String result = "";
		for(int i = 0; i < range.size(); i++){
			
			String[] words = range.get(i).getContent().split(" ");

		    for (int j = 0; j < words.length; j++) 
		    {
		        result = result + words[j].replace(words[j].charAt(0)+"", Character.toUpperCase(words[j].charAt(0))+"") + " ";
		    }
		}
	    return result;
	}
	
	public String SIGN(String in)
	{
		ArrayList<Cell> range = debrij(in);
		int k = 0;
		String result = "";
		for(int i = 0; i < range.size(); i++){
			if(Double.parseDouble(range.get(i).getContent()) > 0);
			k = 1;
			if(Double.parseDouble(range.get(i).getContent()) < 0);
			k = -1;
			if(Double.parseDouble(range.get(i).getContent()) == 0);
			k = 0;
		}
		result = k + " ";
	    return result;
	}
	
	public String IF(String in)
	{
		ArrayList<Cell> range = debrij(in);
		if(range.size() != 1){
			return "false";			
		}
		if(range.get(0).getContent() == "true" || range.get(0).getContent() == "false"){
				return "true";
		}
		else{
				return "false";
		}
	}
	
	public String LOWER(String in)
	{	
		ArrayList<Cell> range = debrij(in);
		String s = "";
		for(int i = 0; i < range.size(); i++){		
			 s = s + Character.toLowerCase(range.get(0).getContent().charAt(i));
		}
		return s;
	}
	
	public String ROUNDDOWN(String in)
	{
		ArrayList<Cell> range = debrij(in);
		if(range.size() != 1){
			System.out.println("Geef 1 Cell in!");	
		}
		int i = 0;
		try 
		{    
			Scanner sc = new Scanner(range.get(0).getContent()).useDelimiter(",");
			i = sc.nextInt();
		}
		catch(NumberFormatException e)
		{
			return "De ingegeven waarde is geen getal";
		}
		String s = i + " ";
		return s;
	}
	
	public String ROUNDUP(String in)
	{
		ArrayList<Cell> range = debrij(in);
		if(range.size() != 1){
			System.out.println("Geef 1 Cell in!");	
		}
		int i = 0;
		try 
		{    
			Scanner sc = new Scanner(range.get(0).getContent()).useDelimiter(",");
			i = sc.nextInt();
			i++;
		}
		catch(NumberFormatException e)
		{
			return "De ingegeven waarde is geen getal";
		}
		String s = i + " ";
		return s;
	}
	
	public String SQRT(String in)
	{
		double d = 0;
		String result = "";
		try{
			ArrayList<Cell> range = debrij(in);
			double getal = Double.parseDouble(range.get(0).getContent());
			d = Math.sqrt(getal);
		}
		catch(NumberFormatException e)
		{
			System.out.println("# VALUE");
		}
		result = d + " ";
		return result;
	}
	
	public String POWER(String in)
	{
		double d = 0;
		String result = "";
		try{
			ArrayList<Cell> range = debrij(in);
			double getal = Double.parseDouble(range.get(0).getContent());
			double macht = Double.parseDouble(range.get(1).getContent());
			d = Math.pow(getal, macht);
		}
		catch(NumberFormatException e)
		{
			System.out.println("# VALUE");
		}
		result = d + " ";
		return result;
	}
	
	public String MOD(String in)
	{
		double d = 0;
		String result = "";
		try{
			ArrayList<Cell> range = debrij(in);
			double getal = Double.parseDouble(range.get(0).getContent());
			double deler = Double.parseDouble(range.get(1).getContent());
			d = getal % deler;
		}
		catch(NumberFormatException e)
		{
			System.out.println("# VALUE");
		}
		result = d + " ";
		return result;
	}
	
	public String PRODUCT(String in)
	{
		ArrayList<Cell> range = debrij(in);
		String result = "";
		double getal = 1;
		for(int i = 0; i < range.size(); i++)
		{
			try{
				getal = getal * Double.parseDouble(range.get(0).getContent());
			}
			catch(NumberFormatException e)
			{
				System.out.println("# VALUE");
			}
		}
		result = getal + " ";
		return result;
	}
	
	public ArrayList<String> debrij(String in){
		Scanner sc = new Scanner(in);
		sc.useDelimiter(";");
		ArrayList<String> a1 = new ArrayList<String>();
		while (sc.hasNext())
		{
			a1.add(sc.next());
		}
		sc.close();
		ArrayList<String> allString = new ArrayList<String>();
		for (String a : a1){
			
			Scanner sc2 = new Scanner(a);
			sc2.useDelimiter(":");
			//TODO Zorgen dat het een vierkant wordt.
			while(sc2.hasNext()){
				allString.add(sc2.next());
			}
			sc2.close();
		}
		ArrayList<String> ret = new ArrayList<String>();
		for (String a : allString){
			Coordinates coor;
			try {
				coor = new Coordinates(a);
				String contents = Spreadsheet.getContents(coor.getRow(), coor.getColumn());
				ret.add(contents);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ret;
	}
}
