// npm install express
// create hello.txt in this folder as similar to express.js
// node express.js

// slip 17: Write node js application that transfer a file as an attachment on web and enables browser to prompt the user to download file using express js. 

var express = require('express');
var app = express();
var PORT = 8080;
app.get('/', function(req, res){
res.download('hello.txt');
});
app.listen(PORT, function(err){
if (err) console.log(err);
console.log("Server listening on PORT", PORT);
});