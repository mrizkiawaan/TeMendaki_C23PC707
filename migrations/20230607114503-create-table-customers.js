'use strict';

/** @type {import('sequelize-cli').Migration} */
module.exports = {
  async up (queryInterface, Sequelize) {
    await queryInterface.createTable('tb_customer', {
      id_customer: {
        type: Sequelize.STRING,
        primaryKey: true,
        allowNull: false,
      },
      customer_name: {
        type: Sequelize.STRING,
        allowNull: false,
      }
    },{
      createdAt: false,
      updatedAt: false
    });


  },

  async down (queryInterface, Sequelize) {
    await queryInterface.dropTable('tb_customer');
  }
};
