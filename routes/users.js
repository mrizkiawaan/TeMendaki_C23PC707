var express = require('express');
var router = express.Router();
var Validator = require('fastest-validator');

const {Users} = require('../models');
const {Auth} = require('../firebase');

const v = new Validator();

//get all users
router.get('/', async (req, res) => {
  const user = await Users.findAll();

    res.json(user);
});


//add data user
router.post('/register', async (req,res) => {
  const schema = {
    id : 'number',
    name: 'string',
    email: 'string',
    password: 'string'
  }

  const validate = v.validate(req.body, schema);
    

  if(validate.length){
    return res.status(400).json(validate);
  }

  const user = await Users.create(req.body)

  Auth.createUserWithEmailAndPassword(email,password).then((result) => {
    console.log(result)
  })

  res.json(user);
})
module.exports = router;
