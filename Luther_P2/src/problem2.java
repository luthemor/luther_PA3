
    class SavingsAccount{
         private static double annualInterestRate = 0.0;
            private double savingsBalance;

        public SavingsAccount(double money){
            this.savingsBalance = money;
        }
        public  void calculateMonthlyInterest(){
            double i;
            i = (this.savingsBalance * (annualInterestRate/100))/12;
            this.savingsBalance += i;
        }
        public void printAmount(){
            System.out.printf("$%.2f", this.savingsBalance);
        }
        public static void modifyInterestRate(double rate2){
            annualInterestRate = rate2;
        }
    }

     class MainClass{
        public static void main(String[] args){
            SavingsAccount saver1 = new SavingsAccount(2000.0);
            SavingsAccount saver2 = new SavingsAccount(3000.0);
            SavingsAccount.modifyInterestRate(4.0);
            System.out.println("Month \t\t Saver1 \t Saver2");

            for(int i=1; i<=12; i++){
                saver1.calculateMonthlyInterest();
                saver2.calculateMonthlyInterest();
                System.out.print("Month " + i + ": \t");
                saver1.printAmount();
                System.out.print("\t");
                saver2.printAmount();
                System.out.println();
            }
            System.out.println();
            System.out.println("The interest rate is now 5.0%\n");

            SavingsAccount.modifyInterestRate(5.0);
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();

            System.out.print("Month 13: \t");
            saver1.printAmount();
            System.out.print("\t");
            saver2.printAmount();
            System.out.println();
        }
    }


