import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;

public class ExcelReaderUtil {

    public static String FILE_PATH = "C:\\workspace\\ExcelandJSONReaderTest\\src\\main\\resources\\TestData.xlsx";
    static Workbook book;
    static Sheet sheet;

    String sheetName = "contacts";

    public static Object[][] getData(String sheetName) throws Exception {

        //Access the Excel Sheet
        FileInputStream file = new FileInputStream(FILE_PATH);
        book = WorkbookFactory.create(file);
        sheet = book.getSheet(sheetName);

        int rows = sheet.getLastRowNum();
        int columns = sheet.getRow(0).getLastCellNum();
        //initialise 2D Object array
        Object[][] data = new Object[rows][columns];

        //Fetch the data from the sheet
        for (int i = 0; i < rows; i++) {
            for (int k = 0; k < columns; k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
            }
        }
        return data;
    }

    @DataProvider
    public Object[][] getExcelData() throws Exception {
        Object[][] data = ExcelReaderUtil.getData(sheetName);
        return data;
    }
}