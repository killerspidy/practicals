// Import necessary modules
const http = require('http');
const fs = require('fs');
const path = require('path');

// Create an HTTP server
const server = http.createServer((req, res) => {
  // Extract the requested file path from the URL
  const filePath = '.' + req.url;

  // Read the file and return its content
  fs.readFile(filePath, (err, data) => {
    if (err) {
      // Handle 404 error if the file is not found
      res.writeHead(404, { 'Content-Type': 'text/plain' });
      res.end('404 Not Found');
    } else {
      // Set the appropriate content type based on file extension
      const extname = path.extname(filePath);
      const contentType = getContentType(extname);

      // Send the file content with the correct content type
      res.writeHead(200, { 'Content-Type': contentType });
      res.end(data);
    }
  });
});

// Specify the port number
const port = 3000;

// Start the server
server.listen(port, () => {
  console.log(`Server running at http://localhost:${port}/`);
});

// Function to determine content type based on file extension
function getContentType(ext) {
  switch (ext) {
    case '.html':
      return 'text/html';
    case '.css':
      return 'text/css';
    case '.js':
      return 'text/javascript';
    default:
      return 'text/plain';
  }
}
