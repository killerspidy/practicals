// slip 5: Using nodejs create a web page to read two file names from user and append contents of first file into second file. 
const http = require('http');
const readline = require('readline');
const fs = require('fs');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

// Function to append contents of the first file into the second file
function appendFiles(firstFileName, secondFileName) {
    fs.readFile(firstFileName, 'utf8', (err, data) => {
        if (err) {
            console.error(`Error reading ${firstFileName}:`, err);
            rl.close();
        } else {
            fs.appendFile(secondFileName, data, (err) => {
                if (err) {
                    console.error(`Error appending to ${secondFileName}:`, err);
                } else {
                    console.log(`Contents of ${firstFileName} appended to ${secondFileName}`);
                }
                rl.close();
            });
        }
    });
}

// Create a simple HTTP server
const server = http.createServer((req, res) => {
    res.writeHead(200, { 'Content-Type': 'text/plain' });
    res.end('Node.js Server\n');
});

// Listen on port 3000
const PORT = 3000;
server.listen(PORT, () => {
    console.log(`Server running at http://localhost:${PORT}/`);
    // Prompt the user for file names after the server starts
    getUserInput();
});

// Function to get file names from the user
function getUserInput() {
    rl.question('Enter the name of the first file: ', (firstFileName) => {
        rl.question('Enter the name of the second file: ', (secondFileName) => {
            appendFiles(firstFileName, secondFileName);
        });
    });
}
