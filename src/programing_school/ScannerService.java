package programing_school;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class ScannerService {

    private  String readFile (String pathToFile)
    {
        try
        {
           File file = new File(pathToFile);
           Scanner scan = new Scanner(file);
           while(scan.hasNextLine())
           {
               String result = scan.nextLine();
           }
        }
        catch(NullPointerException | FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
        return "";
    }

    public static  int getInt (String errorMsg)
    {
        Scanner scan = new Scanner(System.in);
        while(!scan.hasNextInt())
        {
            System.out.println(errorMsg);
            scan.next();
        }
        return scan.nextInt();
    }
    public static  int getInt()
    {
        return getInt("wprowadź liczbę całkowitą");
    }

    public static String getString()
    {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public  static double getDouble(String errorMsg)
    {
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextDouble()){
            System.out.println(errorMsg);
            scan.next();
        }
        return scan.nextDouble();
    }
    public static  double getDouble()
    {
        return getDouble("Podaj liczbę zmiennoprzecinkową");
    }

}
