//slip 7: Create a Node.js file that writes an HTML form, with an upload field. 
// create folder name temp
// run node server.js
// upload html file it will be saved to temp folder
// Import required modules
const http = require('http');
const formidable = require('formidable');
const fs = require('fs');
const path = require('path');

// Create an HTTP server
http.createServer(function (req, res) {
    // Check if the URL is for file upload
    if (req.url === '/fileupload' && req.method.toLowerCase() === 'post') {
        // Create a new Formidable form
        const form = new formidable.IncomingForm();

        // Set the temporary folder for file uploads
        form.uploadDir = path.join(__dirname, 'temp');

        // Parse the form data, including the uploaded file
        form.parse(req, function (err, fields, files) {
            if (err) throw err;

            // Get the temporary path of the uploaded file
            const tempFilePath = files.filetoupload.path;

            // Define the destination path for the uploaded file
            const destinationPath = path.join(__dirname, 'temp', files.filetoupload.name);

            // Move the file to the destination folder
            fs.rename(tempFilePath, destinationPath, function (err) {
                if (err) throw err;
                console.log('File uploaded and moved successfully!');
            });

            // Respond to the client
            res.writeHead(200, { 'Content-Type': 'text/html' });
            res.write('File uploaded and placed in temporary folder.');
            res.end();
        });
        return;
    }

    // If the URL is not for file upload, serve the HTML form
    res.writeHead(200, { 'Content-Type': 'text/html' });
    res.write('<form action="/fileupload" method="post" enctype="multipart/form-data">');
    res.write('<input type="file" name="filetoupload"><br>');
    res.write('<input type="submit">');
    res.write('</form>');
    res.end();
}).listen(8080);

console.log('Server listening on port 8080');
