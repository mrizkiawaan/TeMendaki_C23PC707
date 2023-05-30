var express = require('express');
var router = express.Router();
var Validator = require('fastest-validator');

const {Gunung} = require('../models');

const v = new Validator();

//menampilkan semua data
router.get('/', async(req,res) => {
    const gunung = await Gunung.findAll();

    res.json(gunung);
})

//menambah data gunung
router.post('/',async (req, res) => {
    const schema = {
        name: 'string',
        height: 'number',
        city: 'string',
        province: 'string',
        description: 'string',
        price: 'number'
    }

    const validate = v.validate(req.body, schema);
    

    if(validate.length){
        return res.status(400).json(validate);
    }

    const gunung = await Gunung.create(req.body)

    res.json(gunung);

});

//edit data gunung

router.put('/:id', async (req,res) => {
    const id = req.params.id;

    const gunung = await Gunung.findByPk(id);

    if(!gunung){
        return res.json({message: 'data tidak ditemukan'})
    }

    res.send('ok')
})

module.exports = router;