const express = require('express');
const http = require('http');
const socketIo = require('socket.io');
const app = express();
const server = http.createServer(app);
const io = socketIo(server);

let cheerMessages = [];

io.on('connection', (socket) => {
  console.log('a user connected');

  // 현재 메시지 전송
  socket.emit('init', cheerMessages);

  // 새로운 메시지 처리
  socket.on('newMessage', (message) => {
    cheerMessages.push(message);
    io.emit('updateMessages', cheerMessages);
  });

  socket.on('disconnect', () => {
    console.log('user disconnected');
  });
});

server.listen(3000, () => {
  console.log('listening on *:3000');
});
