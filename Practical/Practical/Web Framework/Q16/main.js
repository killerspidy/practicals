//slip 16: Create a js file named main.js for event-driven application. There should be 
//a main loop that listens for events, and then triggers a callback function when one of those events is detected. 

// node main.js

// Define an event emitter class
class EventEmitter {
    constructor() {
        this.events = {};
    }

    // Method to subscribe to an event
    on(eventName, callback) {
        if (!this.events[eventName]) {
            this.events[eventName] = [];
        }
        this.events[eventName].push(callback);
    }

    // Method to emit an event
    emit(eventName, data) {
        const eventCallbacks = this.events[eventName];
        if (eventCallbacks) {
            eventCallbacks.forEach((callback) => {
                callback(data);
            });
        }
    }
}

// Create an instance of the event emitter
const eventEmitter = new EventEmitter();

// Subscribe to an event
eventEmitter.on('exampleEvent', (data) => {
    console.log(`Event received with data: ${data}`);
});

// Simulate an event being emitted (in a real application, this could be triggered by external factors)
setInterval(() => {
    const randomData = Math.random();
    eventEmitter.emit('exampleEvent', randomData);
}, 1000);
