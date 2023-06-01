var express = require('express');
var router = express.Router();
var Validator = require('fastest-validator');

const {PendakianGunung,DetailPendakian} = require('../models');

const v = new Validator();

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
router.get('/search/:name', async (req, res) => {
    const searchName = req.params.name;

    try {
        const gunung = await PendakianGunung.findAll({
            where: {
                name: searchName
            }
        });
        res.json(gunung)
    } catch (error) {
        console.error(error);
    }
})

//menampilkan data berdasarkan kota
router.get('/search/city/:city', async (req, res) => {
    const searchCity = req.params.city;

    try {
        const gunung = await PendakianGunung.findAll({
            where: {
                city: searchCity
            }
        });
        res.json(gunung)
    } catch (error) {
        console.error(error);
    }
})

//menampilkan data berdasarkan provinsi
router.get('/search/province/:province', async (req, res) => {
    const searchProvince = req.params.province;

    try {
        const gunung = await PendakianGunung.findAll({
            where: {
                province: searchProvince
            }
        });
        res.json(gunung)
    } catch (error) {
        console.error(error);
    }
})


module.exports = router;