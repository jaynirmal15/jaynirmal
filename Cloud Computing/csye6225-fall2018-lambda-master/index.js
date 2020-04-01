// testing on supriya master
console.log('Loading function');
var aws = require('aws-sdk');
var ses = new aws.SES({
   region: 'us-east-1'
});
var ddb = new aws.DynamoDB();

exports.handler = function(event, context, callback) {
    var msgRaw = event.Records[0].Sns.Message;
    var msgArr=msgRaw.split("|");
    var useremail=msgArr[0];
    var Src=msgArr[1];
    var DdbTable=msgArr[2];
    var url=msgArr[3];
    var qParams = {
      TableName: DdbTable,
      Key: {
        'id' : {S: useremail}
      },
      ExpressionAttributeNames:{
        "#tt": "ttl"
      },
      ProjectionExpression: '#tt'
    };
    ddb.getItem(qParams,function(err,data){ 
      if (err) {
          console.log("Unable to query. Error:", JSON.stringify(err, null, 2));
      }else{
        if(Object.keys(data).length === 0 && data.constructor === Object){
          var ttl = Date.now() + 1000*60*20;
          console.log(ttl);
          var itemParams ={
            TableName: DdbTable,
            Item:{
              "id":{S:useremail},
              "ttl":{N:ttl.toString()}
            }
          };
          ddb.putItem(itemParams, function(err) {
              if(err) console.log(err);
              else{
                url=url+"/reset?email="+useremail+"&token="+ttl.toString(); 
                console.log(url);
                  var eParams = {
              Destination: {
                  ToAddresses: [useremail]
              },
              Message: {
                  Body: {
                      Html: {
                          Charset: 'UTF-8',
                          Data: '<html><body><b>Click Here:<a href=\"http://'+url+'\" target=\"_blank\">Reset Link</a></b></body></html>'
                      }
                  },
                  Subject: {
                      Data: "WebApp: Your reset password link is here!"
                  }
              },
              Source: Src
            };
            var email = ses.sendEmail(eParams, function(err, data){
                if(err) console.log(err);
                else {
                    context.succeed(event);
                }
            });
              }
          });
        }
        else{
          console.log("token already exists");
         var tkn_ttl = parseInt((JSON.stringify(data.Item.ttl.N)).replace('\"',''));
          if(Date.now() > tkn_ttl){
            var ttl = Date.now() + 1000*60*20;
            var itemParams ={
                TableName: DdbTable,
                Item:{
                  "id":{S:useremail},
                  "ttl":{N:ttl.toString()}
                }
              };
             ddb.putItem(itemParams, function(err) {
              if(err) console.log(err);
              else{
                 url=url+"/reset?email="+useremail+"&token="+ttl.toString();
                  var eParams = {
                    Destination: {
                        ToAddresses: [useremail]
                    },
                    Message: {
                        Body: {
                            Html: {
                                Charset: 'UTF-8',
                                Data: '<html><body><b>Click Here:<a href=\"http://'+url+'\" target=\"_blank\">Reset Link</a></b></body></html>'
                            }
                        },
                        Subject: {
                            Data: "WebApp: Your reset password link is here!"
                        }
                    },
                    Source: Src
                };
                var email = ses.sendEmail(eParams, function(err, data){
                    if(err) console.log(err);
                    else {
                        context.succeed(event);
                    }
                });
              }
            });  
          }
        }
      }
    });
};
