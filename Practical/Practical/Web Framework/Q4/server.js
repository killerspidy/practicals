// slip 4 : Create a Node.js file that will convert the output "Hello World!" into upper-case letters. 

const express = require('express');
const app = express();
const port = 3000;

app.get('/', (req, res) => {
  const message = "World!";
  const upperCaseMessage = message.toUpperCase();
  res.send(`<h1>${upperCaseMessage}</h1>`);
});

app.listen(port, () => {
  console.log(`Server is running at http://localhost:${port}`);
});
