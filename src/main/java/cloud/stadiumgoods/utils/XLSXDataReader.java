package cloud.stadiumgoods.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class XLSXDataReader {
    private File myFile = new File("src/test/resources/data/TestDataQAChallenge.xlsx");

    public String getUsername(int userCount) throws IOException {
        FileInputStream fis = new FileInputStream(myFile);
        XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
        XSSFSheet mySheet = myWorkBook.getSheetAt(0);
        Iterator<Row> rowIterator = mySheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if (cell.getColumnIndex() == 0 && cell.getRowIndex() == userCount) {
                    myWorkBook.close();
                    fis.close();
                    return cell.toString();
                }
            }
            System.out.println("");
        }
        myWorkBook.close();
        fis.close();
        return null;
    }

    public String getPassword(int userCount) throws IOException {
        FileInputStream fis = new FileInputStream(myFile);
        XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
        XSSFSheet mySheet = myWorkBook.getSheetAt(0);
        Iterator<Row> rowIterator = mySheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if (cell.getColumnIndex() == 1 && cell.getRowIndex() == userCount) {
                    myWorkBook.close();
                    fis.close();
                    return cell.toString();
                }
            }
            System.out.println("");
        }
        myWorkBook.close();
        fis.close();
        return null;
    }

}
