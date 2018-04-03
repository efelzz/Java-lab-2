import java.util.Properties;

public class Automata {
    private String status = "off";
    private int funds = 0;
    private static int companyEarned = 0;
    private Properties[] menu = new Properties[5];
    //methods
    public String on(){
        if (this.status == "off"){
            this.status = "on";
            return "Switched on";
        }
        else
            return "Switch on failed: The machine is currently in " + this.status + " state.";
    }

    public String off(){
        if (this.status == "on"){
            this.status = "off";
            return "Switched off";
        }
        else
            return "Switch off failed: The machine is currently in " + this.status + " state.";
    }

    public String coin(int coins){
        this.status = "accept";
        this.funds += coins;
        return "Your balance is now " + this.funds + "RUB";
    }

    private boolean check(int cost){
        this.status = "check";
        if (cost <= this.funds)
            return true;
        else
            return false;
    }

    private String cook(){
        this.status = "cook";
        //Thread.sleep(1000);
        return finish();
    }

    public String choice(int selection){
        for (int i = 0; i < this.menu.length; i++){
            int intMenuNumber = Integer.parseInt(this.menu[i].getProperty("menuNumber"));
            int intItemCost = Integer.parseInt(this.menu[i].getProperty("cost"));
            if (intMenuNumber == selection){
                if (check(intItemCost)){
                    companyEarned += intItemCost;
                    this.funds -= intItemCost;
                    return cook();
                }
                else
                    return "Nor enough funds. Please add " + (intItemCost - this.funds) + " RUB";
            }
            else if (i == (menu.length - 1))
                return "Menu item with " + selection + " number is not found.";
        }
        return "Something went wrong.";
    }

    private String finish(){
        this.status = "wait";
        return "Thank you for the purchase! Please don't forget your change.";
    }

    private String change(){
        int returnValue = this.funds;
        this.funds = 0;
        return "Thank you for the purchase! Please don't forget your " + returnValue + " RUB change.";
    }

    public String cancel(){
        this.status = "wait";
        return change();
    }

    public void getMenu(){
        for (int i = 0; i < this.menu.length; i++){
            System.out.println("Name: " + this.menu[i].getProperty("name") + " Cost: " + this.menu[i].getProperty("cost") + " Menu Number: " + this.menu[i].getProperty("menuNumber"));
        }
    }

    public Automata(){
        menu[0] = new Properties();
        menu[0].setProperty("cost","20");
        menu[0].setProperty("name","black");
        menu[0].setProperty("menuNumber","1");

        menu[1] = new Properties();
        menu[1].setProperty("cost","25");
        menu[1].setProperty("name","chocolate");
        menu[1].setProperty("menuNumber","2");

        menu[2] = new Properties();
        menu[2].setProperty("cost","28");
        menu[2].setProperty("name","latte");
        menu[2].setProperty("menuNumber","3");

        menu[3] = new Properties();
        menu[3].setProperty("cost","30");
        menu[3].setProperty("name","cappuccino");
        menu[3].setProperty("menuNumber","4");

        menu[4] = new Properties();
        menu[4].setProperty("cost","15");
        menu[4].setProperty("name","soup");
        menu[4].setProperty("menuNumber","5");
    }
}
