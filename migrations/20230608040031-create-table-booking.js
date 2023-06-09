'use strict';

/** @type {import('sequelize-cli').Migration} */
module.exports = {
  async up (queryInterface, Sequelize) {
    await queryInterface.createTable('tb_booking', {
      id_booking: {
        type: Sequelize.STRING,
        primaryKey: true,
        allowNull: false,
      },
      quantity: {
        type: Sequelize.INTEGER,
        allowNull: false,
      },
      climbing_date: {
        type: Sequelize.STRING,
        allowNull: false
      },
      customer_name: {
        type: Sequelize.STRING,
        allowNull: false
      },
      climber_name: {
        type: Sequelize.STRING,
        allowNull: false,
      },
      payment_method: {
        type: Sequelize.ENUM,
        values: ["Bank BCA","Bank BNI","Bank BNI Syariah","Bank Mandiri"]
      },
      total_pay: {
        type: Sequelize.INTEGER,
        allowNull: false
      },
      id_user: {
        type: Sequelize.STRING,
        allowNull: true,
        references: {
          model: 'tb_users',
          key: 'id_user'
        },
        onUpdate: 'CASCADE',
        onDelete: 'SET NULL',
      },
      id_climb: {
        type: Sequelize.INTEGER,
        allowNull: true,
        references: {
          model: 'tb_pendakian_gunung',
          key: 'id_climb'
        },
        onUpdate: 'CASCADE',
        onDelete: 'SET NULL',
      },
      id_customer: {
        type: Sequelize.STRING,
        allowNull: true,
        references: {
          model: 'tb_customer',
          key: 'id_customer'
        },
        onUpdate: 'CASCADE',
        onDelete: 'SET NULL',
      },
    },{
      createdAt: false,
      updatedAt: false
    });


  },

  async down (queryInterface, Sequelize) {
    await queryInterface.dropTable('tb_booking');
  }
};
