var express = require('express');
var router = express.Router();
var Validator = require('fastest-validator');
const { sequelize } = require('../models');

const {PendakianGunung} = require('../models');

//menampilkan semua data
router.get('/', async(req,res) => {
    const gunung = await PendakianGunung.findAll();
    res.json(gunung);
})

//menampilkan data berdasarkan id
router.get('/:id', async(req, res) => {
    const id = req.params.id;

    const gunung = await PendakianGunung.findOne({
        where: {
            id: id
        }
    });

    res.json(gunung)
})

//menampilkan data berdasarkan nama pendakian
router.get('/search/name', async (req, res) => {
    const nama = req.query.name;

    try {
        const gunung = await PendakianGunung.findOne({
            where: {
                name: nama
            }
        });
        res.json(gunung)
    } catch (error) {
        console.error(error);
    }
})

//menampilkan data berdasarkan kota
router.get('/search/city', async (req, res) => {
    const city = req.query.city;

    try {
        const gunung = await PendakianGunung.findAll({
            where: {
                city: city
            }
        });
        res.json(gunung)
    } catch (error) {
        console.error(error);
    }
})

//menampilkan data berdasarkan provinsi
router.get('/search/province', async (req, res) => {
    const province = req.query.province;

    try {
        const gunung = await PendakianGunung.findAll({
            where: {
                province: province
            }
        });
        res.json(gunung)
    } catch (error) {
        console.error(error);
    }
})


module.exports = router;