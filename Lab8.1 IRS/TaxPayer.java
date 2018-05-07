
public class TaxPayer
{
    private String status;
    private double income;

    private final double ST1 = 0;
    private final double ST2 = 4057.50;
    private final double ST3 = 14645;
    private final double ST4 = 36361;
    private final double ST5 = 93374;

    private final double MT1 = 0;
    private final double MT2 = 6780;
    private final double MT3 = 24393.75;
    private final double MT4 = 41855;
    private final double MT5 = 88306;

    public TaxPayer(double income, String status){
        this.status=status;
        this.income=income;
    }

    public double getIncome(double income){
        return income;
    }

    public String getStatus(String status){
        return status;
    }

    public double calculateTax(){
        if(status.equalsIgnoreCase("Single")){
            return singleTax(income);
        }
        else if(status.equalsIgnoreCase("Married")){
            return marriedTax(income);
        }   
        return 0.0;
    }
        private double singleTax(double income){
        if(income >= 297350){
            return ST5  + (.391) * (income - 297350);
        }   
        else if(income < 297350 && income >= 136750){
            return ST4  + (.355) * (income - 136750);
        }
        else if(income < 136750 && income >=65550){
            return ST3 + (.305) * (income - 65550);
        }
        else if(income < 65550 && income >= 27050){
            return ST2 + (.275) * (income - 27050);
        }
        else
            return ST1 + (.15) * income;
    }

    private double marriedTax(double income){
        if(income >= 297350){
            return MT5 + (.391) * (income - 297350);
        }   
        else if(income < 297350 && income >= 166500){
            return MT4 + (.355) * (income - 166500);
        }
        else if(income < 166500 && income >=109250){
            return MT3 + (.305) * (income - 109250);
        }
        else if(income < 109250 && income >= 45200){
            return MT2 + (.275) * (income - 45200);
        }
        else
            return MT1 + (.15) * income;
    }
}