const firebase = require("firebase/app");
require('firebase/auth')

const firebaseConfig = {
  apiKey: "AIzaSyDD45dIH6elZvqj3Koqwj915T_Jzd8KcSc",
    authDomain: "temendaki-test.firebaseapp.com",
    projectId: "temendaki-test",
    storageBucket: "temendaki-test.appspot.com",
    messagingSenderId: "428629498007",
    appId: "1:428629498007:web:801e5e5f2b44ee6e4971d2",
    measurementId: "G-X4X3C2R5D9"
}
// Initialize Firebase
firebase.initializeApp(firebaseConfig);


// Initialize Firebase Authentication and get a reference to the service
const auth = firebase.auth();

module.exports = {auth}