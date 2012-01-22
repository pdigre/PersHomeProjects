var minbet=100;

window.engine={
	cards:"a234567890jqk",
	values:[1,2,3,4,5,6,7,8,9,10,10,10,10],
	numdecks:6,
  // 234567890a
  bs1:[
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
  ],
  // 234567890a
  bs2:[     // aces
    "hhhddhhhhh",  // A2
    "hhhddhhhhh",  // A3
    "hhdddhhhhh",  // A4
    "hhdddhhhhh",  // A5
    "hddddhhhhh",  // A6
    "sddddsshhh",  // A7
    "ssssssssss",  // A8
    "ssssssssss",  // A9
    "ssssssssss"   // BJ
  ],
  

	prepare:function (){
	  var a=[];
	  for(var i=0;i<4;i++) 
	    for(var j=0;j<13;j++)
	      a[a.length]="cdhs"[i]+this.cards[j]; 
	  this.onedeck=a.join('');
	},
  	
	shuffle:function(){
    this.deck=[];
    var d=this.deck;
	  var c='';
	  for(var i=0;i<this.numdecks;i++) 
	    c+=this.onedeck;    
	  this.cardstotal=c.length;  
	  for(var i=0;i<c.length;) 
	    d[d.length]=Math.floor(Math.random()*9999)+'|'+c[i++]+c[i++];  
	  d.sort();
	  for(var i=0;i<d.length;i++) d[i]=d[i].split('|')[1]; 
	  this.count=[0,0,0,0,0,0,0,0,0,0,0,0,0];  //cards,1,2,3,4,5,6,7,8,9,10
	},

	popCard:function(h){ 
	  var curr;
	  if(h==-1){
	    curr="xx";
	    this.hiddenCard=this.deck.pop();
	    h=0;
	  } else{
	    curr=this.deck.pop(); 
    }
    this.cardCount(curr[1]);
    player=players[h];
	  player.hand+=curr[1];
	  player.hval=this.handValue(player.hand);
	  return curr;
	},  
	
	handValue:function(hnd){
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
	},

	basicStrategy:function(){ // d-dealer c-cards
	  var d=dlr.hval;
	  var c=player.hand;
	  var p=player.hval;
	  var b=(this.bs1[p-4])[d-2];   // basic table
	  if(c.indexOf('a')>=0){ // aces table
	    b=(this.bs2[p-13])[d-2];      
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
	},
  mensaStrategy:function(){
    var basic=this.basicStrategy();
    return basic;
  },
  cardCount:function(a){
    this.count[0]++;   //cards,1,2,3,4,5,6,7,8,9,10
    if(a=='x') return;
    var v=this.values[this.cards.indexOf(a)];
    this.count[v]++;
  },
  hiddenCount:function(){
    this.count[0]--;   //cards,1,2,3,4,5,6,7,8,9,10
    this.cardCount(this.hiddenCard[1]);
  },
  printCount:function(){
     this.simple=this.count[2]+this.count[3]+this.count[4]+this.count[5]+this.count[6]
               -this.count[1]-this.count[10];
     this.half  =this.count[2]*.5+this.count[3]+this.count[4]+this.count[5]*1.5+this.count[6]+this.count[7]*.5
               -this.count[1]-this.count[10]-this.count[9]*.5;
     this.real  =52/(this.cardstotal-this.count[0])           
     return "Cnt:"+this.count[0]+"/"+this.cardstotal
      + "<br>H/L:"+this.simple+"="+(Math.floor(this.simple*this.real*10)/10)
      + "<br>Adv:"+(Math.floor(this.half*10)/10)+"="+(Math.floor(this.half*this.real*10)/10);          
  },
  printBet:function(){
     var b=this.simple*this.real;
     m=1;
     if(b>1) m=2;
     if(b>2) m=5;
     if(b>4) m=10;
     if(b>6) m=20;
     if(b>8) m=50;
     if(b>9) m=100;
     return "Bet:$"+m*minbet;          
  },
  printHint:function(){
     var basic=this.basicStrategy();
     var mensa=this.mensaStrategy();
     return "Basic:"+basic
       +"<br>Mensa:"+mensa;          
  },
	
}

  