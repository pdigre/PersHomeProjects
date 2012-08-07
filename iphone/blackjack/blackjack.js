// Blackjack screen logic
var cmds=["stand","hit","double","split","surrender","break","are choosing","have BlackJack!"];
var cmdss=["stands","hits","doubles","splits","surrenders","breaks","is choosing","has BlackJack!"];
var minbet=100;

function Player(num,pr,name,ess,pos,betm){
  this.hand;
  this.hval;
  this.engine=engine;    
  this.processor=pr;
  this.betmaker=betm;
  this.state;
  this.play=play;
  this.num=num;
  this.name=name;
  this.pos=pos;
  this.html;
  this.betsize=1;
  this.money=0;
  this.ess=ess;

  function play(){
    var b='';
    if(this.hval==21){
      b='j';
      this.win(2.5);
    }
    if(this.hval>21) b='b';
    if(!b) b=this.processor(this);  
    if(b!='w') p_log(cmds["shdpxbwj".indexOf(b)],cmdss["shdpxbwj".indexOf(b)]);
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
  }

  this.init=init;
  this.clear=clear;
  this.bet=bet;
  this.makebet=makebet;
  this.win=win;
  this.deal=deal;
  this.addCard=addCard;
  this.refreshMoney=refreshMoney;

  function deal(){
    this.addCard();
    this.addCard();
  }
  function init(){
    this.clear();
    this.state='bet';
  }
  function clear(){
    this.html.innerHTML='';
    this.hval=0;
    this.hand='';
  }
  function win(m){
    this.money+=this.betsize*minbet*m;    
    this.refreshMoney();
  }
  function bet(){
    this.betmaker();
  }
  function makebet(m){
    this.betsize=m;
    this.money-=m*minbet;
    p_log('bet $'+(m*minbet),'bets $'+(m*minbet));
    
    this.refreshMoney();
  }
  function addCard(){
    this.html.innerHTML+=drawCard(this.num);
    showCards();
  }
  function refreshMoney(){
    if(this==dlr) return;
    document.getElementById('money'+this.num).innerHTML='$'+this.money;   // Show current cash
  }
}

function Engine(){
  this.status;
  this.play=play;
  this.shuffle=shuffle;
  this.popCard=popCard;
  this.prepare=prepare;  
  this.handValue=handValue;    
  this.basicStrategy=basicStrategy;
  this.hiddenCard;
	var cards="a234567890jqk";
	var values=[1,2,3,4,5,6,7,8,9,10,10,10,10];
	var onedeck;   // one deck of 52 cards
	var deck;      // current deck - Array
	var numdecks=6;

	
	function prepare(){
	  var a=[];
	  for(var i=0;i<4;i++){ 
	    for(var j=0;j<13;j++){
	      a[a.length]="cdhs"[i]+cards[j]; 
	    }
	  }
	  onedeck=a.join('');
	}
  	
	function shuffle(){
	  var c='';
	  deck=[];
	  for(var i=0;i<numdecks;i++) c+=onedeck;    
	  for(var i=0;i<c.length;) deck[deck.length]=Math.floor(Math.random()*9999)+'|'+c[i++]+c[i++];  
	  deck.sort();
	  for(var i=0;i<deck.length;i++) deck[i]=deck[i].split('|')[1]; 
	}

	function popCard(h){ 
	  var curr;
	  if(h==-1){
	    curr="xx";
	    this.hiddenCard=deck.pop();
	    h=0;
	  } else
	    curr=deck.pop(); 
    player=players[h];
	  player.hand+=curr[1];
	  player.hval=this.handValue(player.hand);
	  return curr;
	}  
	
	function handValue(hnd){
	  var val=0;
	  var a=0; // number of aces
	  for(var i=0;i<hnd.length;i++){
	    switch(hnd[i]){
	      case '0':
	      case 'j':
	      case 'q':
	      case 'k':
	        val+=10;
	        break;
	      case 'a':
	        val+=11;
	        a++;
	        break;
	      case 'x':
	        break;
	      default:
	        val+=hnd[i]*1.0;
	    }
	    if(a && val>21){
	      a--;
	      val-=10;
	    }
	  }
	  return val;
	}

	var bs1=[
	// 234567890a
	  "pppppphhhh",  // pair 2
	  "hhhhhhhhhh",  // 5
	  "hhhhhhhhhh",
	  "hhhhhhhhhh",
	  "hhhhhhhhhh",
	  "hddddhhhhh",  // 9
	  "ddddddddhh",  // 10 = double if you can
	  "dddddddddh",  // 11
	  "hhssshhhhh",  // 12
	  "ssssshhhhh",  // 13
	  "ssssshhhhh",  // 14
	  "ssssshhhxh",  // 15
	  "ssssshhxxx",  // 16
	  "ssssssssss",  // +17 = stand
	  "ssssssssss",
	  "ssssssssss",
	  "ssssssssss",
	  "ssssssssss",
	];
	
	var bs2=[     // aces
	// 234567890a
	  "hhhddhhhhh",  // A2
	  "hhhddhhhhh",  // A3
	  "hhdddhhhhh",  // A4
	  "hhdddhhhhh",  // A5
	  "hddddhhhhh",  // A6
	  "sddddsshhh",  // A7
	  "ssssssssss",  // A8
	  "ssssssssss",  // A9
	  "ssssssssss"   // BJ
	];
	

	function basicStrategy(plr){ // d-dealer c-cards
	  var d=dlr.hval;
	  var c=plr.hand;
	  var p=plr.hval;
	  var b=bs1[p-4][d-2];   // basic table
	  if(c.indexOf('a')>=0){ // aces table
	    b=bs2[p-13][d-2];      
	    if(b=='d' && c.length>2 && p>17) b='s';  
	  }
	
	  if(c.length==2 &&c[0]==c[1]){ // pairs
	    switch(c[0]){
	      case '4': if(d<5)  return b;
	      case '6': if(d==7) return b;
	      case '2':
	      case '3':
	      case '7': if(d>7)  return b;
	      case 'a':
	      case '8':          return 'p';
	      case '9':
	        if(d==7 || d>9) return b;
	        return 'p';
	    }
	  }
	  if(c.length>2){
	    if(b=='x') return (p==16&&d==10?'s':'h');    // surrender alternatives
	    if(b=='d') return 'h';                       // double or hit     
	  }
	  return b;
	}
}

  