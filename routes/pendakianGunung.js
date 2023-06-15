var express = require('express');
var router = express.Router();
var Validator = require('fastest-validator');
const { nanoid } = require('nanoid');

const {PendakianGunung,Customer,Booking,Users} = require('../models');

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
router.post('/:id_climb/booking/:id_user', async (req,res) => {

    try {
        const id_booking = nanoid(16);
        const id_customer = nanoid(16);

        const {id_climb, id_user} = req.params;
        const {quantity,climbing_date,customer_name,climber_name,total_pay,payment_method} = req.body;

        const status = false;
        const gunung = await PendakianGunung.findByPk(id_climb);
        const user = await Users.findByPk(id_user);

        //add data customer
        const schemaCustomer = {
            customer_name: 'string'
        }

        const validateCustomer = v.validate(req.body, schemaCustomer);
        if(validateCustomer.length){
        return res.status(400).json(validateCustomer);
        }

        const customerData = {
            id_customer:id_customer,
            ...req.body
        };
    
        const customer = await Customer.create(customerData);

        //add data booking

        const schemaBooking = {
            quantity: 'number',
            climbing_date: 'string',
            climber_name: 'string',
            payment_method: 'string'
        }

        const validateBooking = v.validate(req.body, schemaBooking);
        if(validateBooking.length){
        return res.status(400).json(validateBooking);
        }

        const bookingData = {
            id_booking: id_booking,
            quantity,
            climbing_date,
            customer_name: customer.customer_name,
            climber_name,
            total_pay: quantity * gunung.price,
            payment_method,
            status,
            id_user,
            id_climb: parseInt(id_climb),
            id_customer
        };

        const booking = await Booking.create(bookingData);

        console.log(booking)

        res.json({
            message: 'success',
            data: {customer,booking}
        })
    } catch (error) {
        console.log(error)
    }
})


module.exports = router;