package bank;

public class Account {

		private int accontNo;
		private double accountBalance;
		private String accountPass;
		private static final String bankName = "BDBL";
		
		public Account() {
			// TODO Auto-generated constructor stub
		}
		
		public Account(int accontNo, double accountBalance, String accountPass) {
			super();
			this.accontNo = accontNo;
			this.accountBalance = accountBalance;
			this.accountPass = accountPass;
		}
		public int getAccontNo() {
			return accontNo;
		}
		public void setAccontNo(int accontNo) {
			this.accontNo = accontNo;
		}
		public double getAccountBalance() {
			return accountBalance;
		}
		public void setAccountBalance(double accountBalance) {
			this.accountBalance = accountBalance;
		}
		public String getAccountPass() {
			return accountPass;
		}
		public void setAccountPass(String accountPass) {
			this.accountPass = accountPass;
		}
		public static String getBankname() {
			return bankName;
		}
		
		
		public void displayAccount(Account account) {
			System.out.println("Bank Name : "+Account.getBankname()+"\nAccount Number : "
					+account.getAccontNo()+"\nAccount Balance : "+account.getAccountBalance()
					+"\nAccount Password : "+account.getAccountPass());
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Account a = new Account(94475,4000,"password");
			a.displayAccount(a);
		}

	}
