var express = require('express');
var router = express.Router();
var Validator = require('fastest-validator');
const { nanoid } = require('nanoid');

const {Users} = require('../models');
const auth = require('../firebase')

const v = new Validator();

//add data user
router.post('/register', async (req,res) => {
  const email = req.body.email;
  const password = req.body.password;

  const id = nanoid(16);

  auth.createUserWithEmailAndPassword(email, password).then(async () => {
    const schema = {
      name: 'string',
      email: 'string',
      password: 'string',
      confirm_password: 'string'
    }

    const validate = v.validate(req.body, schema);
    if(validate.length){
      return res.status(400).json(validate);
    }

    const userData = {
      id: id,
      ...req.body
    };
  
    const user = await Users.create(userData)
    res.json({
      message: 'Register Successfully',
      data: userData
    });
  }).catch((error) => {
    console.log(error)
  })   
})


// Login
router.post('/login', async (req, res) => {
  const email = req.body.email;
  const password = req.body.password;

  auth.signInWithEmailAndPassword(email, password)
    .then(async () => {
      res.json({
        message: 'Login Succesfully'
      });
    })
    .catch((error) => {
      console.log(error);
      if (error.code === 'auth/user-not-found') {
        res.status(404).json({ error: 'User not found' });
      } else if (error.code === 'auth/wrong-password') {
        res.status(401).json({ error: 'Invalid email or password' });
      } else {
        res.status(500).json({ error: 'An error occurred' });
      }
    });
});

//get all users
router.get('/', async (req, res) => {
  const user = await Users.findAll();

  res.json(user);
});

//get user by id
router.get('/:id', async (req, res) => {
  const id = req.params.id;
  const user = await Users.findByPk(id);

  res.json(user)
})

//get user by name
router.get('/search/:name', async (req, res) => {
  const name = req.params.name;
  
  const user = await Users.findAll({
    where: {
      name: name
    }
  })

  res.json(user)
})
module.exports = router;
