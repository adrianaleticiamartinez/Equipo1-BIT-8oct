const jwt = require('jsonwebtoken');

module.exports = (req, res, next) => {
    const authHeader = req.get('Authorization'); // get Auuthorization metadata in request
    if(!authHeader) {
        const error = new Error('No authenticated. Empty Headers');
        error.statusCode = 401;
        throw error;
    }
    const token = authHeader.split(' ')[1];
    let decodedToken;
    try {
        decodedToken = jwt.verify(token, 'token-serial:2020.10');
    } catch(err) {
        err.statusCode = 500;
        throw err;
    }
    if(!decodedToken) {
        const error = new Error('No authenticated. Verification token failed');
        error.statusCode = 404;
        throw error;
    }
    req.userId = decodedToken.userId;
    next();
};