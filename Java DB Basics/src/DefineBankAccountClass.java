public class DefineBankAccountClass {

        private int id;
        private double balance;

        public  DefineBankAccountClass(int id, double balance){
            this.id = id;
            this.balance = balance;
        }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        if (balance < 0){
            return;
        }
        this.balance = balance;
    }

    public double deposit (double amount) {
            double result = -1;
            if (amount >0){
                this.balance += amount;
                result = amount;
            }
           return result;
    }

    public void withdrow (double amount){
            if (this.balance >=amount){
                this.balance -= amount;
            }
    }
    @Override
    public  String toString (){
        return "ID " + this.id;
    }

}
