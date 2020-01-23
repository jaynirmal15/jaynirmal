'use strict';
module.exports = function (app) {
    //Initialize models
    let loginModel = require('./models/login');
    let transactionModel = require('./models/transaction');
    let userModel = require('./models/user');
    let walletModel = require('./models/wallet');

    //Initialize routes
    let mdRoutes = require('./routes/mdRoute');
    mdRoutes(app);
};