var mongoose = require('mongoose');

//Generate the schema

var walletSchema = mongoose.Schema({
    balance: {
        type: Number
    },
    user_id: {
        type: String
    },
    lendingInterest: {
        type: Number
    },
    lendingLimit: {
        type: Number
    }
    },{collection:'Wallet'});

var Wallet = module.exports = mongoose.model('Wallet',walletSchema);