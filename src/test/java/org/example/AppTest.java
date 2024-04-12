package org.example;


import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public Object[] getDataFromExcelUsingFillo() {
        try {
            Fillo fillo = new Fillo();
            Object[] object = null;
            Connection connection = fillo.getConnection("./src/test/resources/ExcelFile.xlsx");
            Recordset recordset = connection.executeQuery("SELECT * FROM Sheet1");
            int numberOfRows = recordset.getCount();
            System.out.println("Size: " + numberOfRows);
            int i = 0;
            object = new Object[numberOfRows];
            while (recordset.next()) {
                object[i] = recordset.getField("Username");
                System.out.println(object[i]);
                i++;
            }
            recordset.close();
            connection.close();
            return object;
        } catch (FilloException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
