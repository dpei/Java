// This function changed the class in CSS to change the background color
function changeBlue(){
  var d1 = document.getElementById("can1");
  var d2 = document.getElementById("can2");
  d1.className = "blueback";
  d2.className = "blueback";
}


// This function directly changed the background color
function changeRed(){
  var can1 = document.getElementById("can1");
  can1.style.backgroundColor = "red";
  // A new context within can1 and draw 2d pictures
  var context = can1.getContext("2d");
  // Seperately fill two rectangles and one text
  context.fillStyle = "yellow";
  context.fillRect(10,10,60,60);
  context.fillRect(80,10,60,60);
  context.fillStyle = "black";
  context.font = "15pt Arial";
  context.fillText("Good",15,45);
}

function doColor(){
  var canvas = document.getElementById("can2");
  var colorinput = document.getElementById("color")
  canvas.style.backgroundColor = colorinput.value;
}

function doSquare(){
// get variable from canvas "can2"
  var canvas = document.getElementById("can2")
// get variable from slider named "slider"
  var slider = document.getElementById("slider");
// get the values from the HTML slider
  var len = slider.value;
  var context = canvas.getContext("2d")
// clear rectangle
  context.clearRect(0,0,canvas.width,canvas.height);
// draw rectangle
  context.fillStyle = "yellow";
  context.fillRect(10,10,len,len);
}