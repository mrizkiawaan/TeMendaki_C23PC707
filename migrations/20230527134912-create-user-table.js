'use strict';


/** @type {import('sequelize-cli').Migration} */
module.exports = {
  async up (queryInterface, Sequelize) {
    await queryInterface.createTable('users', {
      id: {
        type: Sequelize.STRING,
        primaryKey: true,
        autoIncrement: false,
        allowNull: false
      },
      name: {
        type: Sequelize.STRING,
        allowNull: false,
      },
      email: {
        type: Sequelize.STRING,
        allowNull: false
      },
      province: {
        type: Sequelize.ENUM,
        values: ["Nanggroe Aceh Darussalam","Sumatera Utara","Sumatera Selatan","Sumatera Barat","Bengkulu","Riau","Kepulauan Riau","Jambi","Lampung","Bangka Belitung","Kalimantan Barat","Kalimantan Timur","Kalimantan Selatan","Kalimantan Tengah","Kalimantan Utara","Banten","DKI Jakarta","Jawa Barat","Jawa Tengah","Daerah Istimewa Yogyakarta","Jawa Timur","Bali","Nusa Tenggara Timur","Nusa Tenggara Barat","Gorontalo","Sulawesi Barat","Sulawesi Tengah","Sulawesi Utara","Sulawesi Tenggara","Sulawesi Selatan","Maluku Utara","Maluku","Papua Barat","Papua","Papua Tengah","Papua Pegunungan","Papua Selatan","Papua Barat Daya"]
      },
      experience_level: {
        type: Sequelize.ENUM,
        values: ["1","2","3"]
      },
      password: {
        type: Sequelize.STRING,
        allowNull: false
      },
      confirm_password:{
        type: Sequelize.STRING,
        allowNull: false
      }
    },{
      createdAt: false,
      updatedAt: false
    })
  },

  async down (queryInterface, Sequelize) {
    await queryInterface.dropTable('users');
  }
};
