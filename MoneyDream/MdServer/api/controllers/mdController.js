/**
 * Controller for sticky endpoints.
 */

'use strict';
//import sticky service.
const mdService = require('../services/mdService');
/**
 * Returns a list of stickies in JSON based on the
 * search parameters.
 *
 * @param {request} {HTTP request object}
 * @param {response} {HTTP response object}
 */
exports.getUser = function (request, response)
{
    console.log("Inside user function");
    let callback = function (data) {
        response.status(200);
        response.json(data);
    };
    mdService.getUser({}, callback);
};

/**
 * Creates a new sticky with the request JSON and
 * returns sticky JSON object.
 *
 * @param {request} {HTTP request object}
 * @param {response} {HTTP response object}
 */
exports.getLogin = function (request, response) {
    let param = request.body;
    let callback = function (data) {
            response.status(200);
            response.json(data);
        };
    mdService.getLoginDetails(param, callback);
};


exports.getTransaction = function (request, response) {
    let callback = function (data) {
        response.status(200);
        response.json(data);
    };
    mdService.getTransactionDetails({}, callback);
};
exports.validateUser = function (request, response) {
    console.log("Authentication Service called " + request.body.username + "  " + request.body.password);
    let params = request.body,
        callback = function (data) {
        response.status(200);
        console.log("Response at server side is:" + data);
        response.json(data);
    };
    mdService.validateUserCredentials(params, callback);
};

exports.getUserById = function (request, response) {
    //console.log(request.body);
    let params = request.body,
        callback = function (data) {
            response.status(200);
            response.json(data);
        };
    mdService.getUserById(params, callback);
};

exports.getTransactionsForUser = function (request, response) {
    //console.log(request.body);
    let params = request.body,
        callback = function (data) {
            response.status(200);
            response.json(data);
        };
    mdService.getTransactionHistory(params, callback);
};

exports.doUserRegistration = function (request, response) {
    //console.log(JSON.stringify(request.body));
    let params = request.body,
        callback = function (data) {
            response.status(200);
            response.json(data);
        };
    mdService.registerUser(params, callback);
};

exports.createTransaction = function (request, response) {
    //console.log(request.body);
    let params = request.body,
        callback = function (data) {
            response.status(200);
            response.json(data);
        };
    mdService.createTransaction(params, callback);
};

exports.getWallet = function (request, response)
{
  //  console.log("Inside controller" + request.body);
    let params = request.body,
    callback = function (data) {
        response.status(200);
        response.json(data);
    };
    mdService.getWallet(params, callback);
};
exports.addToWallet = function (request, response)
{
    console.log("Inside add wallet controller" + request.body);
    let params = request.body,
    callback = function (data) {
        response.status(200);
        response.json(data);
    };
    mdService.addMoney(params, callback);
};

exports.createNewUserWallet = function (request, response) {
    //console.log(request.body);
    let params = request.body,
        callback = function (data) {
            response.status(200);
            response.json(data);
        };
    mdService.createNewUserWallet(params, callback);
};

exports.createNewUserLogin = function (request, response) {
    //console.log(request.body);
    let params = request.body,
        callback = function (data) {
            response.status(200);
            response.json(data);
        };
    console.log(params);
    mdService.createNewUserLogin(params, callback);
};

exports.searchUsers = function (request, response) {
    let params = request.body;
    let callback = function (data) {
        response.status(200);
        response.json(data);
    };
    mdService.searchUsers(params, callback);
};