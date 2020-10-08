const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const clientesSchema = new Schema({

    nombre: {
        type: String,
        required: true
    },
    apellidopaterno: {
        type: String,
        required: true
    },

    apellidomaterno: {
        type: String,
        required: true
    },

    fechanacimiento:{
        type: Date,
        required: true
    },

    sexo: {
        type: String,
        required: true
    },

    segmento: {
        type: Int,
        required: true
    },

    nacionalidad: {
        type: String,
        required: true
    },

    rfc: {
        type: String,
        required: true
    },

    tipoid: {
        type: String,
        required: true
    },

    numeroid: {
        type: String,
        required: true
    },

    cuenta: {
        type: String,
        required: true
    },

    correo: {
        type: String,
        required: true
    },

});

module.exports = mongoose.model('Clientes', clientesSchema);