/**
 * MoneyDream Server endpoint route definitions.
 */

'use strict';
module.exports = function (app) {
    const mdController = require('../controllers/mdController');
    // Sticky Routes for search and create.
    app.route('/user')
        .get(mdController.getUser);

    app.route('/login')
        .post(mdController.getLogin);
    app.route('/getTransactionsHistory')
        .post(mdController.getTransactionsForUser);
    app.route('/validateUser')
        .post(mdController.validateUser);
    app.route('/getUserById')
        .post(mdController.getUserById);
    app.route('/doUserRegistration')
        .post(mdController.doUserRegistration)
    app.route('/createTransaction')
        .post(mdController.createTransaction);
    app.route('/addMoneyToWallet')
        .post(mdController.addToWallet);
    app.route('/getWalletAmount')
        .post(mdController.getWallet);
    // app.route('/addtoWallet')
    //     .post(mdController.addToWallet);
    // app.route('/getWalletAmount')
    //     .get(mdController.getWallet);
    app.route('/createNewUserWallet')
        .post(mdController.createNewUserWallet);
    app.route('/createNewUserLogin')
        .post(mdController.createNewUserLogin);
    app.route('/searchUsers')
        .post(mdController.searchUsers);

};




























