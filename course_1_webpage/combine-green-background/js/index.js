var fimg = null;
var bimg = null;
var fcanvas;
var bcanvas;

// load two pictures, both front and background image.
function uploadf(){
  fcanvas = document.getElementById("canft");
  var fileinput = document.getElementById("finput");
  fimg = new SimpleImage(fileinput);
  fimg.drawTo(fcanvas);
}

function uploadb(){
  bcanvas = document.getElementById("canbg");
  var fileinput = document.getElementById("binput");
  bimg = new SimpleImage(fileinput);
  bimg.drawTo(bcanvas);
}

// example function
function createComposite() {
  // this function creates a new image with the dimensions of the foreground image and returns the composite green screen image
  var output = new SimpleImage(fimg.getWidth(),fimg.getHeight());
  var greenThreshold = 240;
  for (var pixel of fimg.values()) {
    var x = pixel.getX();
    var y = pixel.getY();
    if (pixel.getGreen() > greenThreshold) {
      //pixel is green, use background
      var bgPixel = bimg.getPixel(x,y);
      output.setPixel(x,y,bgPixel);
    } else {
      //pixel is not green, use foreground
      output.setPixel(x,y,pixel);
    }
  }
  output.drawTo(fcanvas);
}

//Can not use (pixel.getRed() + pixel.getBlue()) for evaluation here not know why.
function merge() {
  var newImg = new SimpleImage(fimg.getWidth(),fimg.getHeight());
  for (var pixel of fimg.values()){
    // If front is green
    var x = pixel.getX();
    var y = pixel.getY();
    if (pixel.getGreen() > 240){
       //the new image takes bgImg pixel
       var bgPixel = bimg.getPixel(x, y);
       newImg.setPixel(x,y,bgPixel);
    } else {
        // the new image takes ftImg pixel
        newImg.setPixel(x,y,pixel);
    }
  }
  newImg.drawTo(fcanvas);
}


// A do clear function is used to clear all current content in the canvas
function doClear(canvas) {
  var context = canvas.getContext("2d");
  context.clearRect(0,0,canvas.width,canvas.height);
}
// clear images in the file and reset the page.
function reset(){
  doClear(fcanvas);
  doClear(bcanvas);
}