// --- REQUIRES
const express = require('express');

// --- INIT}
const app = express();

// --- CONFIGURATIONS
app.use('/', (req, res, next) => {
    res.write('BBVA API');
    res.end();
});

// --- SERVER
app.listen(3000, () => {
    console.log('[BBVA API] Listening on port 3000 ...')
});