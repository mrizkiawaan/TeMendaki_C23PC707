module.exports = (sequelize, DataTypes) => {
    const Gunung = sequelize.define('Gunung',{
        id: {
            type: DataTypes.INTEGER,
            primaryKey: true,
            autoIncrement: true,
            allowNull: false
          },
          name: {
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
          description: {
            type: DataTypes.TEXT,
            allowNull: false
          },
          price: {
            type: DataTypes.INTEGER,
            allowNull: false
          }
    },{
        tableName: 'gunung'
    });

    return Gunung;
}