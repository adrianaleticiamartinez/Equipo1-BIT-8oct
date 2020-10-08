const express = require('express');
const router = express.Router();
const { body } = require('express-validator');
const authController = require('../controllers/auth');

router.put('/signup', [ body('username').trim().notEmpty(), body('password').trim()], authController.signUp);
router.post('/login', authController.login);

module.exports = router;