// BlackJack screen logic

function pullCard(){
  var c=deck[cardnum++].split("|")[1];
  var e=document.getElementById("dlrcards");
  if(turn>-1)
     e=document.getElementById("plrcards").rows[0].cells[turn];
  e.innerHTML+='<img src="../images/'+c+"_of_"+("cdhs")[Math.floor(Math.random()*4)]+'.gif"/> ';
  return c;
}

function plrMsg(){
  return document.getElementById("plrcards").rows[1].cells[turn];
}

function refresh(){
  dlr_tot=hand(dlr_card);
  plr_tot=hand(plr_card);
  document.getElementById("dlrval").innerHTML=dlr_tot;
  plrMsg().innerHTML="You "+plr_tot;
  document.getElementById("cards").innerHTML=(cardtot - cardnum) + "/" + cardtot;
}

function f(name,val){
//  alert(document.getElementById(name).style)
  document.getElementById(name).style.visibility=(val?"visible":"hidden");
}

function isBad(name){
  return document.getElementById(name).style.visibility=="hidden";
}

function bet(x){
  if(isBad("bet")) return;
  document.getElementById("dlrcards").innerHTML='';
  document.getElementById("plrcards").innerHTML='<tr class="cards"><td width="400"></td><td width="400"></td></tr><tr class="vals"><td></td><td></td></tr>';
  for(var i=0;i<players;i++){
    turn=i;
    plr[i]=pullCard(i)+pullCard(i);   
  }
  dlr_draw=false;
  turn=-1;
  dlr_card=pullCard();
  nextPlayer();
}

function startPlayer(i){
  plr_card=plr[i];
  f("bet",0);
  f("stand",1);
  f("hit",1);
  f("split",plr_card[0]==plr_card[1]);
  f("double",1);
  f("surrender",1);
  refresh();
  if(plr_tot==21)  return  stand();
}

function hit(){
  if(isBad("hit")) return;
  plr_card+=pullCard(1);   
  refresh();
  if(plr_tot>20) return stand();
  f("split",plr_card[plr_card.length-2]==plr_card[plr_card.length-1]);
  f("double",0);
  f("surrender",0);
}

function double(){
  if(isBad("double")) return;
  hit();
  stand();
}

function surrender(){
  if(isBad("surrender")) return;
  stand();
}

function split(){
  if(isBad("split")) return;
  stand();
}

function stand(){
  if(isBad("stand")) return;
  f("bet",1);
  f("stand",0);
  f("hit",0);
  f("split",0);
  f("double",0);
  f("surrender",0);
  refresh();

  if(plr_tot>21){
    loose();
  } else  if(plr_tot==21){
     win();
  } else {
    dlr_draw=true;
  }
  
  nextPlayer();
}

function loose(){
  plrMsg().innerHTML+=" -Loose";
}

function win(){
  plrMsg().innerHTML+=" - WIN";
}

function draw(){
  plrMsg().innerHTML+=" -Draw";
}

function nextPlayer(){
  if(++turn<players){
     startPlayer(turn);
  } else {
    dealerTurn();
  }
}


function dealerTurn(){
  turn=-1;
  while(hand(dlr_card)<17)
    dlr_card+=pullCard();    
  if(!dlr_draw) return;  
  for(var i=0;i<players;i++){
    winloose(i);    
  }  
}

function winloose(i){
    turn=i;
    plr_card=plr[i];
    plr_tot=hand(plr_card);
    if(dlr_tot>21 || dlr_tot<plr_tot) return win();
    if(dlr_tot>plr_tot) return loose();
    return draw();
}

document.onkeydown = function ( evt ){
   if ( evt == null )
       evt = event;
   var key=window.createPopup?evt.keyCode:evt.which;    
   if ( key== 112  ) { //F1
       cancelKeyEvent( evt ); //don't allow default help popup by F1
       return false;
   }
   switch(key){
     case 48: // 10
       return bet(10);
     case 49: // 1
       return bet(1);
     case 50: // 2
       return bet(2);
     case 54: // 5
       return bet(5);
     case 83: // s
       return stand();
     case 72: // h
       return hit();
     case 68: // d
       return double();
     case 85: // u
       return surrender();
     case 80: // p
       return split();
     default:
       document.getElementById("chart").innerHTML="Key:"+key;
   }
}

function cancelKeyEvent( evt ){
   if ( window.createPopup )
       evt.keyCode = 0;
   else
   evt.preventDefault();
}


