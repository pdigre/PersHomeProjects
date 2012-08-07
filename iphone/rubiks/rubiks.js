// JavaScript file for Rubiks cube solver



// Screen logic
var sides1="ULFRBDUL";   // 0, 9, 18, 27, 36, 45
var sides2=["Up","Left","Front","Right","Back","Down"];

// Up=> Front+Back, Front=> Left+Right, Right=>Up+Down, None
var moves1=["F1","F2","F3","B1","B2","B3",  "L1","L2","L3","R1","R2","R3",  "U1","U2","U3","D1","D2","D3", "U","L"];
var moves2=[8   ,7   ,6   ,0   ,1   ,2   ,  24  ,21  ,18  ,20  ,23  ,26  ,  27  ,28  ,29  ,35  ,34  ,33  , 4, 13 ];
// ULF ULB URF URB,                          DLF DLB DRF DRB
var corners=[[6,11,18],[0,9,38],[8,20,27],[2,29,36] , [17,24,45],[15,44,51],[26,33,47],[35,42,53]];
// UL UF UR UB , LF LB RF RB , DL DF DR DB 
var centers=[[3,10],[7,19],[5,28],[1,37] , [14,21],[12,41],[23,30],[32,39] , [16,48],[25,46],[34,50],[43,52]];
var short=new Object();
var color1=["White","yellow","Blue","Green","Orange","Red"];
var clean="uuuuuuuuulllllllllfffffffffrrrrrrrrrbbbbbbbbbddddddddd";
var R=[clean];
var cur=clean;
var color='U';

//configure short moves
function prepare(){
  var move=[ // U             L 9                     F 18                     R 27                     B 36                     D 45
  [2,4,6,-2,,2,-6,-4,-2    ,27,27,27,,,,,,         ,-9,-9,-9,,,,,,          ,-9,-9,-9,,,,,,          ,-9,-9,-9,,,,,,          ,,,,,,,,,]
 ,[18,,,18,,,18,,          ,2,4,6,-2,,2,-6,-4,-2   ,27,,,27,,,27,,          ,,,,,,,,,                ,,,-32,,,-38,,,-44       ,-1,,,-7,,,-13,,]
 ,[,,,,,,21 ,23 ,25        ,,,-3,,,-7,,,-11        ,2,4,6,-2,,2,-6,-4,-2    ,20,,,16,,,12,,          ,,,,,,,,,                ,-34,-32,-30,,,,,,]
 ,[,,40,,,34,,,28          ,,,,,,,,,               ,,,-18,,,-18,,,-18       ,2,4,6,-2,,2,-6,-4,-2    ,17,,,11,,,5,,           ,,,-27,,,-27,,,-27]
 ,[15,11,7,,,,,,           ,42,,,40,,,38,,         ,,,,,,,,,                ,,,-29,,,-31,,,-33       ,2,4,6,-2,,2,-6,-4,-2    ,,,,,,,-16,-20,-24]
 ,[,,,,,,,,                ,,,,,,,9,9,9            ,,,,,,,9,9,9             ,,,,,,,9,9,9             ,,,,,,,-27,-27,-27       ,2,4,6,-2,,2,-6,-4,-2]
 ,[18,18,18,18,18,18,18,18,18  ,,,,,,,,,       ,27,27,27,27,27,27,27,27,27      ,,,,,,,,,            ,-36,-36,-36,-36,-36,-36,-36,-36,-36       ,-9,-9,-9,-9,-9,-9,-9,-9,-9]
 ,[,,,,,,,,                ,9,9,9,9,9,9,9,9,9      ,9,9,9,9,9,9,9,9,9       ,9,9,9,9,9,9,9,9,9       ,-27,-27,-27,-27,-27,-27,-27,-27,-27       ,,, ,,, ,,,]
  ];
	for(var i=0;i<8;i++){
	  var m=move[i], a=new Object(), d=sides1[i];
	  for(var j=0;j<54;j++)  // to pos <- from pos
	    if(m[j]) a[j+m[j]]=j;  
    if(i<6){
      var b=new Object(), c=new Object()
	    for(var e in a){
	      b[e]=a[a[e]];
	      c[e]=a[a[a[e]]];
	    }
	    short[d+"1"]=a;
	    short[d+"2"]=b;
	    short[d+"3"]=c;
	  } else {
      short[d]=a;
	  }
	}
	/*
	
	for(var i=0;i<18;i++){
	  var d=moves1[i];
    cur=clean;	  
	  var one=mv(d);
  	R[R.length]=cur+d;
	  for(var j=0;j<18;j++){
	    cur=one;
	    var e=moves1[j];
	    if(e[0]!=d[0]){
	      var two=mv(e);
	      R[R.length]=two+d+e;
        cur=two;
		    for(var k=0;k<18;k++){
		      var f=moves1[k];
		      if(e[0]!=f[0]) R[R.length]=mv(f)+d+e+f;
		    } 
		  }
	  } 
  }	
  */
  cur=clean;
}

prepare();

function drawScreen(){
  for(var i=0;i<6;i++){
    var h=[];
    for(var y=0;y<3;y++){
      h[h.length]='<tr>';
      for(var x=0;x<3;x++){
        var j=x+3*y;
        h[h.length]='<td id="q'+(i*9+j)+'"></td>';
      }
      h[h.length]='</tr>';
    }
    document.getElementById(sides1[i]).innerHTML=h.join('');
  }  
  modeRotate();
}

function modeRotate(){
  clearLabels();
  for(var i=0;i<18;i++){
    document.getElementById('q'+moves2[i]).innerHTML=moves1[i];
  }
  colorize();
}

function colorize(){
  for(var i=0;i<54;i++)
    document.getElementById('q'+i).className=cur[i]; 
}

function clearLabels(){
  for(var i=0;i<54;i++){
    document.getElementById('q'+i).innerHTML=''; 
  }
  for(var i=0;i<6;i++){
    document.getElementById('q'+(i*9+4)).innerHTML=sides1[i]; 
  }
}

function locate(){
  clearLabels();
  for(var i=0;i<8;i++){
    var color='';
    for(var j=0;j<3;j++){
      color+=document.getElementById('q'+corners[i][j]).className;
    }
    for(var j=0;j<3;j++){
      document.getElementById('q'+corners[i][j]).innerHTML=color;    // "C"+i;
    }
  }
  for(var i=0;i<12;i++){
    for(var j=0;j<2;j++){
      document.getElementById('q'+centers[i][j]).innerHTML=i;
    }
  }
}


function mv(m){
  var a=short[m];
  var nxt=cur.split('');  
  for(var i in a) nxt[i]=cur[a[i]];
  return nxt.join('');
}

function mv2(c){
  var a=move[sides1.indexOf(c[0])];
  for(var j=0;j<c[1];j++){  
	  var nxt=cur.split('');  
	  for(var i=0;i<54;i++){
	    if(a[i]) nxt[i+a[i]]=cur[i];
	  }  
	  cur=nxt.join('');
	}
}

function click(e){
  var src=(document.all?window.event.srcElement:e.target);
  if(src.nodeName!='TD') src=src.parentNode;
  if(src.nodeName!='TD') return false;
  var c=src.innerHTML;
  if(mode=="assign"){
    if(c) color=(src.className).toLowerCase();
    else {
      cur=cur.split('');
      cur[(src.id).substr(1)]=color;
      cur=cur.join('');
      colorize();
    }
  } else {
    // rotate
//  alert(c);
    if(!c) return;
    cur=mv(c);
    colorize();
  }
}

function solve(){
  alert(search())
}

function search(){
  for(var i=0;i<R.length;i++)
    if(R[i].substr(0,54)==cur) return "Found:" + R[i].substr(54);
  return "Not found!"+cur.length+":"+cur;
}

var mode=document.getElementById("mode");
function setMode(c){
  switch(c){
    case "id":
      locate();
      break;
    case "assign":
      clearLabels();
      break;
    case "rotate":    
      modeRotate();
      break;        
    case "solve":    
      modeRotate();
      break;        
  }
  mode=c;
}


