package readwrite;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ReadExcelFile {

    public static void main(String args[]) throws IOException {
        excelRead();
    }
        public static Object excelRead() {
            try {
                File file = new File("src/test/resources/Countries.xlsx");
                FileInputStream fileInputStream = new FileInputStream(file);
                XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
                XSSFSheet sheet = workbook.getSheetAt(0);
                Iterator<Row> rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_STRING:    //field that represents string cell type
                                System.out.print(cell.getStringCellValue() + "\t");
                                break;
                            case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type
                                System.out.print(cell.getNumericCellValue() + "\t");
                                break;
                            default:
                        }
                    }
                }
            }
            catch (Exception e) {
            e.printStackTrace();
        }
            return null;
        }
}