var express = require('express');
var router = express.Router();
var Validator = require('fastest-validator');
const { nanoid } = require('nanoid');

const {PendakianGunung,Customers,Booking,Users} = require('../models');

const v = new Validator();

//menampilkan semua data
router.get('/', async(req,res) => {
    const gunung = await PendakianGunung.findAll();
    res.json(gunung);
})

//menampilkan data berdasarkan id
router.get('/:id_climb', async(req, res) => {
    const id_climb = req.params.id_climb;

    const gunung = await PendakianGunung.findByPk(id_climb)

    res.json(gunung)
})

//menampilkan data berdasarkan nama pendakian
router.get('/search/climb_name', async (req, res) => {
    const climb_name = req.query.climb_name;

    try {
        const gunung = await PendakianGunung.findOne({
            where: {
                climb_name: climb_name
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

//booking

/*
router.post('/:id_climb/booking/:id_user', async (req, res) => {

    try {
        const id_customer = nanoid(16);
        const id_booking = nanoid(16);

        const {customer_name,quantity,climbing_date,climber_name,payment_method} = req.body;
        const {id_climb,id_user} = req.params;

        const gunung = await PendakianGunung.findByPk(id_climb);
        const user = await Users.findByPk(id_user);

        const schemaCustomer = {
            customer_name: 'string'
        }

        const validateCustomer = v.validate(req.body, schemaCustomer);
        if(validateCustomer.length){
            return res.status(400).json(validateCustomer);
        }

        const dataCustomer = {
            id_customer,
            customer_name
        }

        const customer = await Customers.create(dataCustomer);

        //data booking
        const schemaBooking = {
            quantity: 'number',
            climbing_date: 'string',
            climber_name: 'string',
            payment_method: 'string',
        }

        const validateBooking = v.validate(req.body, schemaBooking);
        if(validateBooking.length){
            return res.status(400).json(validateBooking);
        }

        const dataBooking = {
            id_booking,
            ...req.body,
            total_pay: quantity * gunung.price,
            ...req.params,
            id_customer
        }

        const booking = await Booking.create(dataBooking);

        res.json(customer,booking);
    } catch (error) {
        console.log("errornya adalah = ",error)
    }
})
*/

module.exports = router;