package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders
{
    //DataProvider 1

    @DataProvider(name = "Logindata")
    public String [][] getData() throws IOException
    {
        String path=".\\testData\\Opencart_LoginData.xlsx"; // taking xl file from testData

        ExcelUtility xlutil=new ExcelUtility(path); // Creating an object of XLUtility

        int totalrows=xlutil.getRowCount("Sheet1");
        int totalcols=xlutil.getCellCount("Sheet1",1);

        String logindata[][]=new String[totalrows][totalcols]; // Created 2-dimensional array

        for(int i=1;i<=totalrows;i++)
        {
            for (int j=0;j<totalcols;j++)
            {
                logindata[i-1][j]=xlutil.getCellData("Sheet1",i,j);
            }
        }

        return logindata;
    }
}
