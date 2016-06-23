package ReadExcelData;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static String[][] ReadExcel(String Path,int Sheetno) throws Exception 
	{
		XSSFWorkbook wb = null;
		String[][]CellData=null;
		try {
		
			File src=new File(Path);
			FileInputStream fis= new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
			 XSSFSheet Sheet1=wb.getSheetAt(Sheetno);
			
			int rowcount=Sheet1.getPhysicalNumberOfRows();
			System.out.println("Row Count="+rowcount);
			int Cellcount=0;
			
			for(int i=0;i<rowcount;i++)
			{
				System.out.println(i);
				Cellcount=Sheet1.getRow(i).getPhysicalNumberOfCells();
				System.out.println(Cellcount);
				for(int j=0;j<Cellcount;j++)
				{
					System.out.println(j);
					CellData=new String[rowcount][Cellcount];
					CellData[i][j]=Sheet1.getRow(i).getCell(j).getStringCellValue();
					System.out.println(CellData[i][j]);
				}
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wb.close();
		return CellData;
		}
	
	

	public static void main(String[] args) throws Exception {
		
		String ExcelData[][]=ReadExcel("C:\\Users\\TATA-OMNI\\workspace\\TestData\\TestData.xlsx", 0);
		System.out.println(ExcelData[0][0]);
		
		
		
		

}
}
