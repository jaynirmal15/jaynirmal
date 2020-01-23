var mongoose = require('mongoose');

//Generate the schema

var userSchema = mongoose.Schema({
        firstName:{
            type: String
        },
        lastName:{
            type: String
        },
        emailAddress:{
            type: String
        },
        address:{
            street:{
                type: String
            },
            aptNo:{
                type: String
            },
            state:{
                type: String
            },
            zipcode:{
                type: String
            },
            city:{
                type: String
            },
            country:{
                type: String
            }
        }
    },{collection:'User'});

var User = module.exports = mongoose.model('User',userSchema);

//Get User
// module.exports.getUsers = function (callback, limit) {
//     console.log("inside module log");
//     User.find(callback).limit(limit);
//     console.log();
// };

