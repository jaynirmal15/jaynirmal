/**
 * Service for sticky operations.
 */

'use strict';
const mongoose = require('mongoose'),
    User = mongoose.model('User'),
    Login = mongoose.model('Login'),
    Transaction = mongoose.model('Transaction'),
    Wallet = mongoose.model('Wallet');

/**
 * Throws error if error object is present.
 *
 * @param {Object} error {Error object}
 */
let throwError = function (error) {
    if (error) {
        throw Error(error);
    }
};

/**
 * Returns an array of sticky object matching the search parameters.
 *
 * @param {Object} params {Search parameters}
 * @param {function} callback {Sucess callback function}
 */
exports.getUser = function (params, callback) {
    let resultCallback = function (err, data) {
        throwError(err);
        callback(data);
    };

    User.find(params, resultCallback);
};

exports.getLoginDetails = function (params, callback) {
    let id = params.userName;
    
    let resultCallback = function (err, data) {
        throwError(err);
        callback(data);
        console.log(data.userName);
    };
    Login.findOne({userName:id}, resultCallback);
};
exports.getTransactionDetails = function (params, callback) {
    let resultCallback = function (err, data) {
        throwError(err);
        callback(data);
    };
    Transaction.find(params, resultCallback);
};

//Authenticate User
exports.validateUserCredentials = function(params,callback){

    let userName = params.userName;
    let password = params.password;
    console.log("Inside Server Authentication service module: Input is: " + userName + "  " + password);
    let resultCallback = function (err,login ) {
        if (err){
            console.log('Username not found');
            throwError(err);
        }
        console.log("Inside Server Authentication service module output is: " + login);
       callback(login);
    }
    Login.findOne({ userName:userName ,password:password },resultCallback);

};

//get User for a given user ID

exports.getUserById = function(params,callback){

    let id = params.id;
    let resultCallback = function (err,user ) {
        if (err){
            console.log('Username not found');
            throwError(err);
        }

        callback(user);
        console.log(user);
    }
    User.findById({user_id: id}, resultCallback);


};

// get Transaction history for a given user id

exports.getTransactionHistory = function(params,callback){

    let id = params.id;
    // var ObjectId = require('mongoose').Types.ObjectId;
    // var objId = new ObjectId( (param.length < 12) ? "123456789012" : param );
    let resultCallback = function (err,transaction ) {
        if (err){
            console.log('Username not found');
            throwError(err);
        }
        callback(transaction);
    }
    Transaction.find( { $or:[ {borrower_id:id}, {lender_id:id} ]}, resultCallback);

};

// Service for saving the newly created User
exports.registerUser = function(params,callback){

    let user = new User(params.regObject);
    //console.log(user);
    let resultCallback = function (err,user ) {
        if (err){
            console.log('Saving User failed for Register User');
            throwError(err);
        }
        callback(user);
    }
    user.save(resultCallback);

};

//Create a new Transaction Document between lender and borrower
exports.createTransaction = function(params,callback){

    let transaction = new Transaction(params);
  //  console.log(transaction);
    let resultCallback = function (err,transaction ) {
        if (err){
            console.log('Creating Transaction Record failed');
            throwError(err);
        }
        callback(transaction);
    }
    transaction.save(resultCallback);
};

// exports.getWallet = function (userid, callback) {
//     // let resultCallback = function (err, data) {
//     //     throwError(err);
//     //     callback(data);
//     // };
//     Wallet.findOne({user_id: userid}, function(err, foundWaller) {
//         throwError(err);
//         callback(foundProduct);
//     });
//     //Wallet.find(params, resultCallback);
// };

exports.getWallet = function(params,callback){

    let id = params.id;
   
    let resultCallback = function (err,wallet) {
        if (err){
            console.log('Username not found');
            throwError(err);
        }
      //console.log("inside wallet server service" + wallet);
        callback(wallet);
    }
    Wallet.findOne({user_id: id}, resultCallback);

};

exports.addMoney = function(adding,callback)
{
    console.log("addiing money to " + adding.wallet);
    Wallet.findOne({user_id :adding.wallet.user_id},function(err,wall){
        if(wall !=null){
            wall.balance = Number(adding.amount) + wall.balance;
            
            console.log("added amount" + wall.balance);
            wall.save(function(err,adding)
        {
                if(err){
                    console.log('ERROR!');
                };
                callback(adding);
        });
        }
    });
}
exports.createNewUserWallet = function(params,callback){

    let wallet = new Wallet(params.userWallet);
    console.log(wallet);
    let resultCallback = function (err,data ) {
        if (err){
            console.log('Creating Wallet failed');
            throwError(err);
        }
        callback(data);
    }
    wallet.save(resultCallback);
};

exports.createNewUserLogin = function(params,callback){

    let login = new Login(params.login);
    console.log(login);
    let resultCallback = function (err,data ) {
        if (err){
            console.log('Creating New User Login Record failed');
            throwError(err);
        }
        callback(data);
    }
    login.save(resultCallback);
};

exports.searchUsers = function(params,callback){

    let searchParam = params.searchParam;
    console.log();
    let resultCallback = function (err,data ) {
        if (err){
            console.log('Creating New User Login Record failed');
            throwError(err);
        }
        callback(data);
    }
    User.find({$or:[{firstName: { $regex:new RegExp( '.*' + searchParam + '.*',"i") }},{lastName: { $regex:new RegExp('.*' + searchParam + '.*',"i")}}]},resultCallback);
    //User.find({firstName: { $regex: '.*' + searchParam + '.*' } }).limit(5)
};
