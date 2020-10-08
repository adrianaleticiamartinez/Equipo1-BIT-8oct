// --- REQUIRES
const express = require('express');

// --- INIT}
const app = express();

// --- CONFIGURATIONS
app.use(express.json()); // only looks at requests where the Content-Type: application/json

// Middleware: CORS
app.use((req, res, next) => {
    res.setHeader('Access-Control-Allow-Origin', '*');
    res.setHeader('Access-Control-Allow-Methods', 'GET, POST, PUT, PATCH, DELETE');
    res.setHeader('Access-Control-Allow-Headers', 'Content-Type, Authorization');
    next();
});

// Middleware: Root Point
app.use('/', (req, res, next) => {
    res.write('BBVA API');
    res.end();
});

// Middleware: Handling Errors
app.use((error, req, res, next) => {
    const statusCode = error.statusCode || 500;
    const message = error.message;
    const data = error.data;
    res.status(statusCode).json({
        message: message,
        data: data
    });
});

// --- SERVER
app.listen(3000, () => {
    console.log('[BBVA API] Listening on port 3000 ...')
});