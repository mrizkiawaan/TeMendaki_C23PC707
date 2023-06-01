module.exports = (sequelize, DataTypes) => {
    const Users = sequelize.define('Users',{
        id: {
            type: DataTypes.STRING,
            primaryKey: true,
            autoIncrement: false,
            allowNull: false
          },
          name: {
            type: DataTypes.STRING,
            allowNull: false,
          },
          email: {
            type: DataTypes.STRING,
            allowNull: false
          },
          password: {
            type: DataTypes.STRING,
            allowNull: false
          },
          confirm_password:{
            type: DataTypes.STRING,
            allowNull: false
          }
    },{
      tableName: 'users',
      createdAt: false,
      updatedAt: false
    });

    return Users;
}