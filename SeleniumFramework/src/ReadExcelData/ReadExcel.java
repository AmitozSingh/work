package ReadExcelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File src=new File("C:\\Users\\TATA-OMNI\\workspace\\TestData\\TestData.xlsx");
		FileInputStream fis= new FileInputStream(src);
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		 XSSFSheet Sheet1=wb.getSheetAt(0);
		String value=Sheet1.getRow(0).getCell(0).getStringCellValue();
		int rowcount=Sheet1.getLastRowNum();
		System.out.println(rowcount);
		int Cellcount=0;
		String[][]CellData=null;
		for(int i=0;i<=rowcount;i++)
		{
			System.out.println(i);
			Cellcount=Sheet1.getRow(i).getLastCellNum();
			for(int j=0;j<Cellcount;j++)
			{
				System.out.println(j);
				CellData=new String[rowcount][Cellcount];
				System.out.println(Sheet1.getRow(i).getCell(j).getStringCellValue());
				CellData[i][j]=Sheet1.getRow(i).getCell(j).getStringCellValue();
				System.out.println(CellData[i][j]);
			}
			
		}
		
		wb.close();
	}
	

}