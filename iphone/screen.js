// Screen functionality for chess program

// Interface functions to chess engine
function log(x){document.getElementById("logarea").value+='\n '+x;document.getElementById("text").innerHTML=x;};
function nextPiece(){return document.getElementById("nextPiece").selectedIndex};
function level(){return document.getElementById("level").selectedIndex+1};


// Draw the chess board
function drawBoard(){
  var h=[];
  for(var y=90;y>10;y-=10){
    h[h.length]='<tr>';
    for(var x=0;x<10;x++) if(x&&x<9) h[h.length]=('<td id="'+(y+x)+'"></td>');
    h[h.length]='</tr>';
  }
  return h.join('');;
}

function chequered(){
  for(var i=0;i<120;i++){
    var e=document.getElementById(i);
    if(e) e.className=((i-Math.floor(i/10))%2?'b':'w');
  }
}

// Start the chess program
function initHTML(){
  document.getElementById('brd').innerHTML=drawBoard();
  Engine.prototype.log=log;
  Engine.prototype.nextPiece=nextPiece;
  Engine.prototype.level=level;
  newGame();
}

var engine;

function newGame(){
  document.getElementById("logarea").value='<-- New Game -->';
  document.getElementById("side").setAttribute("toggled",true);
  engine=new Engine();
}




