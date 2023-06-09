module.exports = (sequelize, DataTypes) => {
    const Users = sequelize.define('Users',{
      id_user: {
        type: DataTypes.STRING,
        primaryKey: true,
        autoIncrement: false,
        allowNull: false
      },
      username: {
        type: DataTypes.STRING,
        allowNull: false,
      },
      email: {
        type: DataTypes.STRING,
        allowNull: false
      },
      province: {
        type: DataTypes.ENUM,
        values: ["Nanggroe Aceh Darussalam","Sumatera Utara","Sumatera Selatan","Sumatera Barat","Bengkulu","Riau","Kepulauan Riau","Jambi","Lampung","Bangka Belitung","Kalimantan Barat","Kalimantan Timur","Kalimantan Selatan","Kalimantan Tengah","Kalimantan Utara","Banten","DKI Jakarta","Jawa Barat","Jawa Tengah","Daerah Istimewa Yogyakarta","Jawa Timur","Bali","Nusa Tenggara Timur","Nusa Tenggara Barat","Gorontalo","Sulawesi Barat","Sulawesi Tengah","Sulawesi Utara","Sulawesi Tenggara","Sulawesi Selatan","Maluku Utara","Maluku","Papua Barat","Papua","Papua Tengah","Papua Pegunungan","Papua Selatan","Papua Barat Daya"]
      },
      experience_level: {
        type: DataTypes.ENUM,
        values: ["1","2","3"]
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
      tableName: 'tb_users',
      createdAt: false,
      updatedAt: false
    });

    return Users;
}