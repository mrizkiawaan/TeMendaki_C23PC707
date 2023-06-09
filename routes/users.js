var express = require('express');
var router = express.Router();
var Validator = require('fastest-validator');
const { nanoid } = require('nanoid');

const {Users} = require('../models');
const auth = require('../firebase')

const v = new Validator();

//add data user
router.post('/register', async (req,res) => {
  const {username,email,province,experience_level,password,confirm_password} = req.body;

  const id_user = nanoid(16);

  auth.createUserWithEmailAndPassword(email, password).then(async () => {
    const schema = {
      username: 'string',
      email: 'string',
      province: 'string',
      experience_level: 'string',
      password: 'string',
      confirm_password: 'string'
    }

    const validate = v.validate(req.body, schema);
    if(validate.length){
      return res.status(400).json(validate);
    }

    const userData = {
      id_user: id_user,
      ...req.body
    };
  
    const user = await Users.create(userData)
    res.json({
      message: 'Register Successfully',
      data: user
    });
  }).catch((error) => {
    console.log(error)
  })   
})


// Login
router.post('/login', async (req, res) => {
  const {email, password} = req.body;

  auth.signInWithEmailAndPassword(email, password)
    .then(async () => {
      const schema = {
        email: 'string',
        password: 'string',
      }
  
      const validate = v.validate(req.body, schema);
      if(validate.length){
        return res.status(400).json(validate);
      }

      const user = await Users.findOne({
        attributes: ['email','password'],
        where: {
          email: email
        }
      })
      res.json({
        message: 'Login Succesfully',
        data: user
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
router.get('/:id_user', async (req, res) => {
  const id_user = req.params.id_user;
  const user = await Users.findByPk(id_user);

  res.json(user)
})

//get user by name
router.get('/search/:username', async (req, res) => {
  const name = req.params.username;
  
  const user = await Users.findAll({
    where: {
      username: name
    }
  })

  res.json(user)
})
module.exports = router;
