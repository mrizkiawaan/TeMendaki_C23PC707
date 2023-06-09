module.exports = (sequelize, DataTypes) => {
    const Booking = sequelize.define('tb_booking',{
      id_booking: {
        type: DataTypes.STRING,
        primaryKey: true,
        allowNull: false,
      },
      quantity: {
        type: DataTypes.INTEGER,
        allowNull: false,
      },
      climbing_date: {
        type: DataTypes.STRING,
        allowNull: false
      },
      customer_name: {
        type: DataTypes.STRING,
        allowNull: false
      },
      climber_name: {
        type: DataTypes.STRING,
        allowNull: false,
      },
      payment_method: {
        type: DataTypes.ENUM,
        values: ["Bank BCA","Bank BNI","Bank BNI Syariah","Bank Mandiri"]
      },
      total_pay: {
        type: DataTypes.INTEGER,
        allowNull: false
      },
      id_user: {
        type: DataTypes.STRING,
        allowNull: true,
        references: {
          model: 'tb_users',
          key: 'id_user'
        },
        onUpdate: 'CASCADE',
        onDelete: 'SET NULL',
      },
      id_climb: {
        type: DataTypes.INTEGER,
        allowNull: true,
        references: {
          model: 'tb_pendakian_gunung',
          key: 'id_climb'
        },
        onUpdate: 'CASCADE',
        onDelete: 'SET NULL',
      },
      id_customer: {
        type: DataTypes.STRING,
        allowNull: true,
        references: {
          model: 'tb_customer',
          key: 'id_customer'
        },
        onUpdate: 'CASCADE',
        onDelete: 'SET NULL',
      },
    },{
      tableName: 'tb_booking',
      createdAt: false,
      updatedAt: false
    });

    Booking.associate = (models) => {
      Booking.belongsTo(models.Users, { foreignKey: 'id_user' });
      Booking.hasMany(models.Users, {foreignKey: 'id_user'})
      Booking.belongsTo(models.PendakianGunung, { foreignKey: 'id_climb' });
      Booking.hasOne(models.PendakianGunung, { foreignKey: 'id_climb' });
      Booking.belongsTo(models.Customers, { foreignKey: 'id_customer' });
      Booking.hasMany(models.Customers, { foreignKey: 'id_customer' });
    };

    return Booking;
}