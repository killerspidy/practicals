// slip 14: Write node js script to interact with the filesystem, and serve a web page from a file .

// create public name folder in same directory as this file 
// In public folder write simple html code 'index.html'
// to run this file type :
// node server.js
// localhost:8080

// If code is not working install this module
// npm init -y
//npm install http fs

// Import required modules
const http = require('http');
const fs = require('fs');
const path = require('path');

// Create an HTTP server
const server = http.createServer((req, res) => {
    // Get the requested URL
    const requestedUrl = req.url === '/' ? '/index.html' : req.url;

    // Construct the file path based on the requested URL
    const filePath = path.join(__dirname, 'public', requestedUrl);

    // Check if the file exists
    fs.exists(filePath, (exists) => {
        if (exists) {
            // Read the file content
            fs.readFile(filePath, (err, data) => {
                if (err) {
                    // Handle file read error
                    res.writeHead(500, { 'Content-Type': 'text/plain' });
                    res.end('Internal Server Error');
                } else {
                    // Serve the file content
                    res.writeHead(200, { 'Content-Type': 'text/html' });
                    res.end(data);
                }
            });
        } else {
            // Handle file not found
            res.writeHead(404, { 'Content-Type': 'text/plain' });
            res.end('Not Found');
        }
    });
});

// Listen on port 8080
const PORT = 8080;
server.listen(PORT, () => {
    console.log(`Server running at http://localhost:${PORT}`);
});
