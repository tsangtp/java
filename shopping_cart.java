import java.util.ArrayList;
import java.util.Scanner;
class main {
   public static Double city() {
        Double tax_rates = 0.0;
        Scanner city = new Scanner(System.in);
        String Location = "";
        while(true){
            System.out.printf("Enter Location:");
            Location = city.nextLine();
            if (Location.equals("CA") || Location.equals("ca")){
                tax_rates = 0.0975;
                break;
                }
            else if (Location.equals("NY") || Location.equals("ny")){
                tax_rates = 0.08875;
                break;
                }
            else{
                System.out.println("Error!Please try again.");
            }
        }
        return (tax_rates);
    }

    public static void main(String[] args) {
        Double tax_rates =city();
        String name;
        Double price;
        int qty;
        Double total = 0.0;
        Double tax = 0.0;
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<Double> prices = new ArrayList<Double>();
        ArrayList<Integer> qtys = new ArrayList<Integer>();
        String[] food = {"potatochips"};
        String[] clothes ={"shirt"};
        while(true){
            System.out.println("Enter the Item name,price and quantity.");
            Scanner item = new Scanner(System.in);
            System.out.printf("Item Name:");
            name = item.nextLine();
            System.out.printf("Item Price:");
            price = item.nextDouble();
            System.out.printf("Item Quantity:");
            qty = item.nextInt();
            names.add(name);
            prices.add(price);
            qtys.add(qty);
            System.out.println("Do you have any Item ?(If not, please input 0.If have,please input other.)");
            Scanner choice = new Scanner(System.in);
            int i = choice.nextInt();
            if (i == 0){
                break;
            }
        }

        System.out.println("item \t\t price \t\t qty");
        for(int i = 0; i < names.size();i++){
        System.out.println(names.get(i) + " \t\t " + prices.get(i) + "\t\t " + qtys.get(i));
        }
        for (int i = 0; i < prices.size();i++){
            total += prices.get(i) * qtys.get(i);
        }
        double Total = Math.round(total*100.0)/100.0;
        System.out.println("subtotal:\t\t\t" + Total);
        for (int i = 0; i < prices.size();i++){
            for (int j = 0;j < food.length;j++){
                if(tax_rates == 0.0975){
                    if(!names.get(i).equals(food[j]) && !names.get(i).equals(clothes[j])){
                        tax += tax_rates * prices.get(i) * qtys.get(i);
                    }
                }
                else if(tax_rates == 0.08875){
                    if(!names.get(i).equals(food[j]) && !names.get(i).equals(clothes[j])){
                        tax += tax_rates * prices.get(i) * qtys.get(i);
                    }
                }
            }
        }
        double Tax_rate =Math.ceil(tax / 0.05) * 0.05;
        System.out.println(Tax_rate);
        System.out.println("tax:\t\t\t\t" + Tax_rate);
        Total = Total + Tax_rate;
        Total = Math.round(Total*100.0)/100.0;
        System.out.println("total:\t\t\t\t" + Total);
    }

}