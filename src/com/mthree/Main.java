package com.mthree;

import com.mthree.controllers.TradeController;
import com.mthree.models.Symbols;
import com.mthree.services.TradeService;
import com.mthree.ui.*;

import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {
         final  DecimalFormat df2 = new DecimalFormat("#.##");

        TradeController tradeController = new TradeController(new TradeService());
        Menu menu = new Menu();
        int[] a;
        double result;

        do{
            try {
                a = menu.menuLogic();
            } catch (InputDataIsInvalidException e) {
                e.printStackTrace();
                Menu.clear();
                continue;
            } catch (EndingTheCodeException e) {
                break;
            }
            result = tradeController.selectFromMenu(a[0],tradeController.getTradeDAO().getTrades(), Symbols.valueOf(a[1]));
            System.out.println(df2.format(result)+"$");
            Menu.clear();
       }while(true);
    }
}
