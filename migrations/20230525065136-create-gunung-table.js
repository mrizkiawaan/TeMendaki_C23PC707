'use strict';

/** @type {import('sequelize-cli').Migration} */
module.exports = {
  async up (queryInterface, Sequelize) {
    await queryInterface.createTable('tb_pendakian_gunung', {
      id_climb: {
        type: Sequelize.INTEGER,
        primaryKey: true,
        allowNull: false,
      },
      climb_name: {
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
      link_image: {
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
      stock_tickets: {
        type: Sequelize.INTEGER,
        allowNull: false
      },
      sold_tickets: {
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
    await queryInterface.dropTable('tb_pendakian_gunung');
  }
};
