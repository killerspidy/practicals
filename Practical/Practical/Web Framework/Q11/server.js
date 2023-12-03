// Not working
// slip 11: Create a node.js file that Select all records from the "customers" table, and delete the specified record.

// Import necessary modules
const mysql = require('mysql');

// Create a MySQL connection
const connection = mysql.createConnection({
  host: 'localhost',  // Replace with your MySQL server host
  user: 'root',       // Replace with your MySQL username
  password: 'password', // Replace with your MySQL password
  database: 'your_database', // Replace with your database name
});

// Connect to MySQL server
connection.connect((err) => {
  if (err) {
    console.error('Error connecting to MySQL server:', err);
    return;
  }
  console.log('Connected to MySQL server');

  // Step 1: Select all records from the "customers" table
  connection.query('SELECT * FROM customers', (err, results) => {
    if (err) throw err;
    console.log('All records from "customers" table:', results);

    // Step 2: Specify the record to delete (replace 1 with the desired record ID)
    const recordIdToDelete = 1;

    // Step 3: Delete the specified record
    connection.query('DELETE FROM customers WHERE id = ?', [recordIdToDelete], (err) => {
      if (err) throw err;
      console.log(`Record with ID ${recordIdToDelete} deleted`);

      // Close the MySQL connection
      connection.end((err) => {
        if (err) console.error('Error closing connection:', err);
        console.log('MySQL connection closed');
      });
    });
  });
});
