// npm init -y
// npm install express express-session body-parser
// create app.js and login.html
// run node app.js  visit localhost:3000

// slip 13: Using node js create a User Login System. 

const express = require('express');
const session = require('express-session');
const bodyParser = require('body-parser');

const app = express();

// Middleware setup
app.use(session({ secret: 'your-secret-key', resave: true, saveUninitialized: true }));
app.use(bodyParser.urlencoded({ extended: true }));

// In-memory user database (Replace this with a real database)
const users = [
  { id: 1, username: 'user1', password: 'password1' },
  { id: 2, username: 'user2', password: 'password2' },
];

// Routes
app.get('/', (req, res) => {
  res.send('Welcome to the login page');
});

app.get('/login', (req, res) => {
  res.sendFile(__dirname + '/login.html');
});

app.post('/login', (req, res) => {
  const { username, password } = req.body;

  const user = users.find(u => u.username === username && u.password === password);

  if (user) {
    req.session.user = user;
    res.redirect('/dashboard');
  } else {
    res.send('Invalid credentials. <a href="/login">Go back to login</a>');
  }
});

app.get('/dashboard', (req, res) => {
  if (req.session.user) {
    res.send(`Welcome, ${req.session.user.username}! <a href="/logout">Logout</a>`);
  } else {
    res.redirect('/login');
  }
});

app.get('/logout', (req, res) => {
  req.session.destroy(() => {
    res.redirect('/');
  });
});

// Start the server
const PORT = 3000;
app.listen(PORT, () => {
  console.log(`Server is running at http://localhost:${PORT}`);
});
