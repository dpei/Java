var img;

function upload(){
  var orgimgcanvas = document.getElementById("can1");
  var fileinput = document.getElementById("finput");
  img = new SimpleImage(fileinput);
  img.drawTo(orgimgcanvas);
}

function makeGray(){  
  for (var pixel of img.values()){
    var avg = (pixel.getRed()+
               pixel.getGreen()+
               pixel.getBlue())/3;
    pixel.setRed(avg);
    pixel.setBlue(avg);
    pixel.setGreen(avg);
  }
  var newcanvas = document.getElementById("can2");
  img.drawTo(newcanvas);
}