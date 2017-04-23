//pop up a notice
function dochange(){
  alert('JavaScript warning: submit function currently down')
}

// Change the color of two classes when click button
function changeColor() {
  var dd1 = document.getElementById("d2");
  var dd2 = document.getElementById("d3");
  // className is a component that can be changed through JavaScript
  dd1.className = "blueback";
  dd2.className = "redback";
}

// Change the text of two classes when click button
// Do not use translate () as the function name. Don't know why yet
function txt() {
  var dd1 = document.getElementById("d2");
  var dd2 = document.getElementById("d3");
  // className is a component that can be changed through JavaScript
  dd1.innerHTML = "en contacto conmigo";
  dd2.innerHTML = "five seven five";
}