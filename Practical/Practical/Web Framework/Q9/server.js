// Not working

// slip 9: Create a node.js file that Select all records from the "customers" table, and display the result object on console.

// Import mysql module
let mysql = require('mysql');
// Setup database connection parameter
let connection = mysql.createConnection({
host: 'localhost',
user: 'root',
password: '',
database: 'mydb2'
});
// Connect with the database
connection.connect(function(e) {
if (e) {
// Show error messaage on failure
return console.error('error: ' + e.message);
}
// Show success message if connected
console.log('\nConnected to the MySQL server...\n');
});
// Set the query message
$query = 'SELECT * from customer1';
// Execute the database query
connection.query($query, function(e, rows) {
if(e){
// Show the error message
console.log("Error ocurred in executing the query.");
return;
}
/* Display the formatted data retrieved from 'customer' table
using for loop */
console.log("The records of customer table:\n");
console.log("name \t\n");
for(let row of rows) {
console.log(row['name'],"\t");
}
});
// Close the database connection
connection.end(function(){
console.log('\nConnection closed.\n');
});