// database.js
var mysql = require('mysql');

var connection = mysql.createConnection({
  host: 'localhost',
  port: 3306,
  user: 'team2',
  password: '123456',
  database: 'javadb2'
});

connection.connect(function(err) {
  if (err) {
    console.error('MySQL 연결 실패: ', err.stack);
    return;
  }
  console.log('MySQL에 연결되었습니다.');
});

module.exports = connection;
