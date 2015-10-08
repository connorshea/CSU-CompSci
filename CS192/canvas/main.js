// Get the first canvas and give it a 2D context.
var canvas = document.getElementById("canvas");
var context = canvas.getContext("2d");

// Set the canvas' height and width to that of the browser window.
var body = document.body;
canvas.height = body.clientHeight;
canvas.width  = body.clientWidth;

// Background.
context.fillStyle = "#aaaab2";
context.fillRect(0, 0, canvas.width, canvas.height);

// Get the second canvas and give it a 2D context.
var canvas2 = document.getElementById("canvas2");
var context2 = canvas2.getContext("2d");

canvas2.height = body.clientHeight;
canvas2.width  = body.clientWidth;

// canvasText object for rendering the "Canvas" text.
var canvasText = {
  x: canvas.width / 2,
  y: canvas.height / 2,
  draw: function(x, y) {
    context2.fillStyle = "#fff";
    context2.font = "90px sans-serif";
    context2.fillText("Canvas", x, y);
    context2.fill();
  }
}

// "clears" the canvas element by overlaying a 0.4 opacity element on every version of the context, this causes the "trailing" effect.
function clear() {
  context2.fillStyle = 'rgba(170,170,178,0.4)';
  context2.fillRect(0, 0, canvas.width, canvas.height);
}

// By default make the Canvas text appear in the center of the canvas.
function draw() {
  canvasText.draw(canvas.width / 2, canvas.height / 2);

  window.requestAnimationFrame(draw);
}

// Get the third canvas and give it a 2D context.
var canvas3 = document.getElementById("canvas3");
var context3 = canvas3.getContext("2d");

canvas3.height = body.clientHeight;
canvas3.width  = body.clientWidth;

// "Canvas below here" text.
context3.font = "18px sans-serif";
context3.fillStyle = "#fff";
context3.textAlign = "center";
context3.fillText("Here is the body of the HTML document. We will add the Canvas below here.", canvas.width / 2, 150);

// On mousemove, the canvasText element is moved to follow along with the cursor.
canvas3.addEventListener('mousemove', function(e) {
  canvasText.draw(e.clientX, e.clientY);
  clear();
});
