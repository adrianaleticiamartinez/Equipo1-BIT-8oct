
const { validationResult } = require('express-validator');
const bcrypt = require('bcryptjs');
const User = require('../models/user');
const jwt = require('jsonwebtoken');

exports.signUp = async (req, res, next) => {
    try {
        // Finds the validation errors in this request and wraps them in an object with handy functions
        const errors = validationResult(req);
        if(!errors.isEmpty()) {
            const error = new Error('Validation failed, entered data is incorrect');
            error.statusCode = 422;
            error.data = errors.array();
            throw error;
        }
        const username = req.body.username;
        const password = req.body.password;
        const hashedPassword = await bcrypt.hash(password, 12);
        const user = await User({
            username: username,
            password: hashedPassword
        });
        const status = await user.save();
        res.status(200).json({
            message: `User ${username} created`,
            userId: status._id
        });     
    } catch(err) {
        next(err)
    }
};

exports.login = async (req, res, next) => {
    const username = req.body.username;
    const password = req.body.password;
    try {
        const user = await User.findOne({username: username});
        if(!user) {
            const error = new Error('User not found');
            error.statusCode = 401;
            throw error;
        }
        const isEqual = await bcrypt.compare(password, user.password);
        if(!isEqual) {
            const error = new Error('Wrong password');
            error.statusCode = 401;
            throw error;
        } 
        const token = jwt.sign({
            username: user.username,
            userId: user._id.toString()
        }, 
        'token-serial:2020.10', {
            expiresIn: '1h'
        });
        res.status(200).json({
            token: token,
            userId: user._id.toString()
        });
    } catch(err) {
        if(!err.statusCode) {
            err.statusCode = 500;
        }
        next(err);
    }
};