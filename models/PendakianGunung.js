module.exports = (sequelize, DataTypes) => {
    const PendakianGunung = sequelize.define('PendakianGunung',{
      id_climb: {
        type: DataTypes.INTEGER,
        primaryKey: true,
        allowNull: false,
      },
      climb_name: {
        type: DataTypes.STRING,
        allowNull: false,
      },
      height: {
        type: DataTypes.INTEGER,
        allowNull: false
      },
      city: {
        type: DataTypes.STRING,
        allowNull: false
      },
      province: {
        type: DataTypes.STRING,
        allowNull: false
      },
      link_image: {
        type: DataTypes.STRING,
        allowNull: false
      },
      description: {
        type: DataTypes.TEXT,
        allowNull: false
      },
      price: {
        type: DataTypes.INTEGER,
        allowNull: false,
      },
      stock_tickets: {
        type: DataTypes.INTEGER,
        allowNull: false
      },
      sold_tickets: {
        type: DataTypes.STRING,
        allowNull: false
      },
      duration: {
        type: DataTypes.STRING,
        allowNull: false
      },
      rating: {
        type: DataTypes.STRING,
        allowNull: false
      }
    },{
      tableName: 'tb_pendakian_gunung',
      createdAt: false,
      updatedAt: false
    });

    return PendakianGunung;
}