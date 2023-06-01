'use strict';

/** @type {import('sequelize-cli').Migration} */
module.exports = {
  async up (queryInterface, Sequelize) {
    await queryInterface.createTable('pendakian_gunung', {
      id: {
        type: Sequelize.INTEGER,
        primaryKey: true,
        allowNull: false,
      },
      name: {
        type: Sequelize.STRING,
        allowNull: false,
      },
      height: {
        type: Sequelize.INTEGER,
        allowNull: false
      },
      city: {
        type: Sequelize.STRING,
        allowNull: false
      },
      province: {
        type: Sequelize.STRING,
        allowNull: false
      },
      description: {
        type: Sequelize.TEXT,
        allowNull: false
      },
      price: {
        type: Sequelize.INTEGER,
        allowNull: false,
      },
      stock_ticket: {
        type: Sequelize.INTEGER,
        allowNull: false
      },
      avaibility: {
        type: Sequelize.STRING,
        allowNull: false
      },
      duration: {
        type: Sequelize.STRING,
        allowNull: false
      },
      rating: {
        type: Sequelize.STRING,
        allowNull: false
      }
    },{
      createdAt: false,
      updatedAt: false
    })
  },

  async down (queryInterface, Sequelize) {
    await queryInterface.dropTable('pendakian_gunung');
  }
};
