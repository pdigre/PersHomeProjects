// Blackjack screen logic

window.dlr={
  num:0,
  name:'Dealer',
  pos:'center',
  ess:true,
  betsize:1,
  money:0,
  cmds:["stands","hits","doubles","splits","surrenders","breaks","is choosing","has BlackJack"],
  result:["loses","pushes","wins","bets $"],
  
  play:function(){
    var b='';
    if(this.hval==21){
      b='j';
      this.win(2.5);
    }
    if(this.hval>21) b='b';
    if(!b) b=this.choose(); 
    if(b!='w') this.log(this.cmds["shdpxbwj".indexOf(b)]+' on '+this.hval);
    switch(b){
      case 'w':
        this.state='wait';
        break;
      case 'd':
        this.state='double';
        break;
      case 'p':
      case 'h':
        this.state='more';
        break;      
      case 'x':
        this.win(0.5);
      case 'j':
      case 'b':
        this.state='end';
        break;
      case 's':
        this.state='stand';
        break;
      default:
        this.state='end';
    }
    return b;
  },

	choose:function(){
	  var l; 
	  for(var i=1;i<players.length;i++) if(players[i].hval>0) l=true;
	  if(!l) return 's';
	  if(this.hand[0]=='x'){
	    this.hand=engine.hiddenCard[1]+this.hand[1];
	    this.html.innerHTML=(this.html.innerHTML).replace(/x_of_x/,engine.hiddenCard[1]+'_of_'+engine.hiddenCard[0]);
	    this.hval=engine.handValue(this.hand);
	    engine.hiddenCount();
	  }
	  return this.hval<17 ? 'h':'s';
	},

  log:function(c){
    log(this.name+' '+c+'.');
  },
  deal:function(){
    this.addCard();
    this.addCard();
  },
  init:function(){
    this.clear();
    this.state='bet';
  },
  clear:function(){
    this.html.innerHTML='';
    this.hval=0;
    this.hand='';
    document.getElementById('hint').innerHTML='';
  },
  win:function(m){
    this.money+=this.betsize*minbet*m;    
    this.refreshMoney();
  },
  bet:function(){
    rotate('stand');
    setTimeout('playNext()', 1000);
  },
  makebet:function(m){
    this.betsize=m;
    this.money-=m*minbet;
    this.log(this.result[3]+(m*minbet));
    this.refreshMoney();
  },
  addCard:function(){
    this.html.innerHTML+=drawCard(this.num);
    showCards();
  },
  refreshMoney:function(){
    if(this==dlr) return;
    document.getElementById('money'+this.num).innerHTML='$'+this.money;   // Show current cash
  },
  finish:function(){
    if(!this.hval) return;
    this.log(this.result[0]);
    if(this.hval==dlr.hval){
      this.log(this.result[1]);
	    this.win(1);
	  }
	  if(this.hval>dlr.hval){
	    this.log(this.result[2]);
	    this.win(2);
	  }
  },
  playNext:function(m){
    this.log(m);
    setTimeout('playNext()', 1000);
  }  
}

window.cmp={
  num:2,
  name:'Comp1',
  pos:'right',
  ess:true,

  bet:function(){
    var m=1;
    var c='bets $'+(minbet*m);
    document.getElementById('bet'+player.num).innerHTML=c;
    player.makebet(m);
    rotate('deal');
    return this.playNext(c);
  },
  choose:function(){
    return engine.basicStrategy();
  }      
}

window.hum={
  num:1,
  name:'You',
  pos:'left',
  ess:false,
  cmds:["stand","hit","double","split","surrender","break","are choosing","have BlackJack!"],
  result:["lose","push","win","bet $"],

  bet:function(){
	  log('.');
	  document.getElementById('commands').innerHTML='<button>Bet</button>';
    document.getElementById('hint').innerHTML=engine.printBet();
  },
	choose:function(){
	  log('.');
	  var t=[];
	  var p=player.hand;
	  if(player.hval==21) return 's';  // Automatically stand
    t[t.length]='<button>Stand</button>';
    t[t.length]='<button>Hit</button>';
    if(p.length==2){
      t[t.length]='<button>Double</button>';
      t[t.length]='<button>Surrender</button>';
    }
	  if(p[0]==p[1])
	    t[t.length]='<button>Split</button>';
    if(p[1]=='a')
      t[t.length]='<button>Insurance</button>';
	  
	  document.getElementById('commands').innerHTML=t.join('');
	  document.getElementById('hint').innerHTML=engine.printHint();
	  return 'w';
	},
	button:function(e){
	  switch(e.target.innerHTML){ 
      case 'Insurance':
        return this.playNext('Insurance not yet supported');
      case 'Stand':
        player.state='stand';  
        return this.playNext('stand on '+this.hval);
      case 'Hit':
	      player.state='more';
        return this.playNext('hit on '+this.hval);
      case 'Double':
        player.state='double';
        return this.playNext('double on '+this.hval);
      case 'Split':
        alert('spl')
        return this.playNext('split on '+this.hval);
      case 'Surrender':
        this.win(0.5);
        player.clear();  
        player.state='end';  
        return this.playNext('surrender on '+this.hval);
      case 'Bet':  // bet
	      var e=document.getElementById('bet1');
	      var m=e.options[e.selectedIndex].value;
	      player.makebet(e.options[e.selectedIndex].value);
	      rotate('deal');
        return this.playNext('bet $'+(minbet*m));
	  }  
	}
}

inherit(hum,dlr);
inherit(cmp,dlr);

function inherit(a,b){for(var e in b) if(!a[e]) a[e]=b[e];}

/*
window.test={per:'per'};
function testing(){
  this.kari='kari';
}  

test2=new testing();
overload(test,test2);

for(e in test)
  alert(e+':'+test[e]);

*/  