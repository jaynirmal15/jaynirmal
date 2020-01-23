var mongoose = require('mongoose');

//Generate the schema

var txSchema = mongoose.Schema({
    borrower_id: {
        type: String
    },
    lender_id: {
        type: String
    },
    amount: {
        type: Number
    },
    //ID value of User used as a reference to link two collections
    status: {
        type: String
    },
    transactionDate:{
        type: Date
    }
},{collection:'Transaction'});

var Transaction = module.exports = mongoose.model('Transaction',txSchema);
