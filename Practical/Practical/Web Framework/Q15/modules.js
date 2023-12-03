// modules.js

// Function to return today's date and time
function getCurrentDateTime() {
    const currentDate = new Date();
    return currentDate.toISOString();
}

// Export the function to make it available externally
module.exports = {
    getCurrentDateTime,
};
