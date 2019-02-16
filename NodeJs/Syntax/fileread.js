var fs = require('fs')

fs.readFile('smaple.txt', 'utf8', function(err, data) {
  console.log(data);
});
