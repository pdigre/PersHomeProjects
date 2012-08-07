// Blackjack screen logic
var players=[];
var rotation;
var player;

function load(){
  engine.log=log;
  dlr.html=document.getElementById('dlrcards');
  players[players.length]=dlr;
  players[players.length]=hum;
  players[players.length]=cmp;
  var e=document.getElementById('plrcards');
  for(var i=1;i<players.length;i++) 
    e.innerHTML+='<span></span>';
  for(var i=1;i<players.length;i++)
    players[i].html=e.childNodes[i-1];
  startDeck();  
}

function drawCard(h){ 
  var curr=engine.popCard(h);
  return '<img class="card" src="images/'+curr[1]+'_of_'+curr[0]+'.gif"/>';
}  

function startDeck(){
  engine.prepare();
  engine.shuffle();
  startRound();
}

function startRound(){
  for(var i=0;i<players.length;i++)
    players[i].init();
  showCards();
  rotation=players.length-1;
  player=players[rotation];
  log('Place your bets!');
  setTimeout('playNext()', 1000);
}

function playNext(){
  if(player.hval>21){
    player.clear();
    player.state='stand';
  }
  switch(player.state){
    case'deal':
      if(player!=dlr) player.deal();
      rotate('start');
      return setTimeout('playNext()', 1000);
    case 'bet':
      if(player==dlr){
        document.getElementById('dlrcards').innerHTML=drawCard(-1)+drawCard(0);
        rotate('deal');
        return playNext();
      }
      return player.bet();
    case 'double':
      player.makebet(player.betsize);
      player.betsize*=2;
      player.addCard();
      player.state='stand';
      return setTimeout('playNext()', 1000);
    case 'more':
      player.addCard();
    case 'start':
      player.play();
      return setTimeout('playNext()', 1000);
    case 'end':
      player.clear();    // player breaks or wins - remove cards
    case 'stand':
      showCards();
      if(rotation==0){
        rotation=players.length-1;
        return setTimeout('dlrFinish()', 1000);
      }
      rotate('stand');
      playNext();   
    case 'wait':
      break;   
  }
}

function rotate(c){
  player.state=c;
  rotation--;
  if(rotation<0) rotation=players.length-1;
  player=players[rotation];
}

function dlrFinish(){
  player=players[rotation];
  player.finish();
  rotation--;
  player=players[rotation];
  if(rotation<1) return setTimeout('startRound()', 2000);
  setTimeout('dlrFinish()', 1000);
}

function log(c){
  var e=document.getElementById('commands');
  e.innerHTML='<b class="msg">'+c+'</b>';
  e.style.textAlign=(!player||!player.pos?'center':player.pos);
}

function showCards(){
  var e=document.getElementsByTagName('IMG');
  var x=0; // image counter
  var w=300;
  var hands=players.length;
  var dw=w/(hands-1)/2;      
  for(var i=0;i<hands;i++){
    var c=players[i].hand;
    for(var j=0;j<c.length;j++)
      e[x++].style.left=((i?dw*(2*i-1):w/2)-10*c.length+20*j-20)+'px';
  }
  document.getElementById('count').innerHTML=engine.printCount();
}


