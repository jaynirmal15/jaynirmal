export class Wallet {
  balance: Number;
  user_id: string;
  lendingInterest: Number;
  lendingLimit: Number;
  constructor(balance: Number,user_id: string, lendingInterest: Number, lendingLimit: Number) {
    this.balance = balance;
    this.user_id = user_id;
    this.lendingInterest = lendingInterest;
    this.lendingLimit = lendingLimit;
  }
}

