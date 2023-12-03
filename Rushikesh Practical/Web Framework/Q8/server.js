// Not working

// slip 8: Create a Node.js file that demonstrates create database and table in MySQL.

// Import necessary modules
const mysql = require('mysql');

// Create a MySQL connection
const connection = mysql.createConnection({
  host: 'localhost',  // Replace with your MySQL server host
  user: 'root',       // Replace with your MySQL username
  password: 'password', // Replace with your MySQL password
});

// Connect to MySQL server
connection.connect((err) => {
  if (err) {
    console.error('Error connecting to MySQL server:', err);
    return;
  }
  console.log('Connected to MySQL server');

  // Step 1: Create a MySQL database
  connection.query('CREATE DATABASE IF NOT EXISTS mydatabase', (err) => {
    if (err) throw err;
    console.log('Database "mydatabase" created');

    // Step 2: Use the created database
    connection.query('USE mydatabase', (err) => {
      if (err) throw err;

      // Step 3: Create a table
      const createTableQuery = `
        CREATE TABLE IF NOT EXISTS users (
          id INT AUTO_INCREMENT PRIMARY KEY,
          username VARCHAR(255) NOT NULL,
          email VARCHAR(255) NOT NULL
        )
      `;
      connection.query(createTableQuery, (err) => {
        if (err) throw err;
        console.log('Table "users" created');

        // Close the MySQL connection
        connection.end((err) => {
          if (err) console.error('Error closing connection:', err);
          console.log('MySQL connection closed');
        });
      });
    });
  });
});
