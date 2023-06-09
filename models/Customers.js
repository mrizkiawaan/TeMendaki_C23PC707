module.exports = (sequelize, DataTypes) => {
    const Customers = sequelize.define('Customers',{
        id_customer: {
            type: DataTypes.STRING,
            primaryKey: true,
            allowNull: false,
        },
        customer_name: {
            type: DataTypes.STRING,
            allowNull: false,
        }
    },{
      tableName: 'tb_customer',
      createdAt: false,
      updatedAt: false
    });


    return Customers;
}