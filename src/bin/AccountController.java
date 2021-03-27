package bin;

abstract public class AccountController extends Account{

    public void deposit(double sum){
            if(sum > 0) {
                double currBalance = this.getBalance();
                this.setBalance(currBalance + sum);
            }
        }
}


