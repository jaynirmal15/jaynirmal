var mongoose = require('mongoose');

//Generate the schema

var loginSchema = mongoose.Schema({
    userName: {
        type: String
    },
    password: {
        type: String
    },
    displayName: {
        type: String
    },
    //ID value of User used as a reference to link two collections
    user_id: {
        type: String
    }
},{collection:'Login'});

var Login = module.exports = mongoose.model('Login',loginSchema);

//Get User
// module.exports.getLoginDetails = function (callback, limit) {
//     console.log("inside login Module");
//     Login.find(callback).limit(limit);
// };