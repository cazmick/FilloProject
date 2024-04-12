package org.example;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{


    public static void main( String[] args ) throws FilloException {



        Fillo fillo = new Fillo();
        Connection connection = fillo.getConnection("/Users/tn63dm2ylf/FilloProject/src/main/resources/ExcelFile.xlsx");
        Recordset recordset=connection.executeQuery("select  FLNG_NB from Sheet1");

//        while(recordset.get){
//            System.out.println(recordset.getFieldNames().);
//        }
        ArrayList<String> values = recordset.getFieldNames();




        recordset.close();
        connection.close();


    }
}

