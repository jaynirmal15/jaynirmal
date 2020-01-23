export class Transaction {
    lender_id: string;
    borrower_id: string;
    amount: number;
    status: string;
    transactionDate: Date;
    constructor(borrower_id: string,lender_id: string, amount: number, status: string, transactionDate: Date) {
        this.lender_id = lender_id;
        this.borrower_id = borrower_id;
        this.amount = amount;
        this.status = status;
        this.transactionDate = transactionDate;
    }
}