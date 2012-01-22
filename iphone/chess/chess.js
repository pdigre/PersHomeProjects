// javascript chess engine
// adapted from the chess_6k.js engine

// ****************************************
// *******     Chess Engine    ************
// ****************************************

function Engine(){

  this.reset=reset;
  this.setPlayer=setPlayer;
  this.cmpMove=cmpMove;
  this.click=click;
  this.Undo=Undo;

  // Static variables
  var Bt=1999, Al=-1999;
  var j=[0,1,5,3,3,9,63,0];  // Relative values of pieces
  var pieces=['Pawn','Rook','Knight','Bishop','Queen','King'];
  var MV=[0,0,           // Allowed moves
          [1,10],        // Castling
          [21,19,12,8],  // Knight (FW-Right,FW-Left,Side-Right,Side-Left)
          [11,9],        // Bishop and pawn capture (FW-Right,FW-Left)
          [1,10,11,9],   // Queen (same as King)
          [1,10,11,9],   // King (Left,FW,FW-Right,FW-Left)
         0]; 
  var BE=120;  // BoardSize


  // Initilize global variables
  var Rh=[], G=[], R=[], KL=[3,3], Ds=[10,-10], Y=[], PY=[], bY=[];
  this.P=0;   // Player white = 0
  var J=0;    // Player's turn = 0, Mate = 2  
  var M=0;    // Turn
  var N=0;
  var K=0; 
  var y;
  var startPos=0, endPos=0, liftPiece=0;   // Piece move handling
  R[BE]=0; 
  for(var z=0;z<8;){
    j[z+8]=j[z]<<=4;
    var m=MV[z++];
    if(m){
      var s=m.length;
      for(var x=0;x<s;) m[s+x]=-m[x++];
    }
  }

  // Chess Board  12*10 includes illegal borders
  // g-border, 0-Empty, 9/1-pawn, A/2-Rook, B/3-Knight, C/4-Bishop, D/5-Queen, E/6-King   
  var b='gggggggggg'
       +'gggggggggg'
       +'g23456432g'
       +'g11111111g'
       +'g00000000g'
       +'g00000000g'
       +'g00000000g'
       +'g00000000g'
       +'g99999999g'
       +'gABCDECBAg'
       +'gggggggggg'
       +'gggggggggg';
  
  var w='g00000000g'
       +'g00000000g' 
       +'g00000000g' 
       +'0001111000' 
       +'0012332100' 
       +'0123553210';
  
  var a='000012346900';
  
  for(var y=0;y<12;y++) for(var x=0;x<10;x++){ // Row by Col
    var z=(y*10)+x;
    PY[z]=parseInt(a.charAt(y));
    bY[z]=parseInt(w.charAt((z<60)?z:119-z),35)&7;
    R[z]=parseInt(b.charAt(z),35)
  }
  // Restart board
  chequered();
  reset();
  setPlayer(0); // White


  // Handle click event
  function click(e){
    var src=(document.all?window.event.srcElement:e.target);
    if(src.nodeName=='IMG') src=src.parentNode;
    if(src.nodeName!='TD') return false;
    newPos=src.id 
    newPos=P?119-newPos:newPos;  // check black/white
    var a=R[newPos];
    if(J) return;

    // Return to start position
    if(startPos==newPos&&liftPiece){
      setImage(startPos,liftPiece);
      setColor(startPos,false);
      setImage('PI',liftPiece=0);
      chequered();
      document.onmousemove=null;
      return false;
    }
    // Pickup the piece
    if(a&&M==(a&8)){
      setImage(startPos=newPos,0);
      setImage('PI',liftPiece=a);
      setColor(startPos,'r');
      document.onmousemove=dragEvent;
      dragEvent(e);
      reset();
      var p=findMoves(M,K,0);    // Color the allowable moves for this piece
      for(var z=0;z<p.length;z++) if(startPos==p[z][1]) setColor(p[z][2],'p');
      return false;
    }
    // Drop the piece
    if(liftPiece && move(startPos,newPos,nextPiece(),y)){
      setImage('PI',liftPiece=0);
      chequered();
      setColor(startPos,false);
      document.onmousemove=null;
      computerMove();
    }
    return false;
  }
  
  function computerMove(){
    if(J<2) setTimeout('engine.cmpMove()', 100);
  }
 
  // Set the image
  function setImage(pos,piece){
    if(pos!='PI') pos=""+(P?119-pos:pos);
    document.getElementById(pos).innerHTML=(piece=='0'?'':'<img src="images/'+piece+'.gif">');
  }

  // Set the color
  function setColor(z,mark){
    document.getElementById(P?119-z:z).className=mark?mark:((z-Math.floor(z/10))%2?'b':'w');
  }

  
  function movePiece(from,to){
    var a=R[from];
    R[to]=a, R[from]=0;
    setImage(from,0);
    setImage(to,a)
  }
  
  // Position the piece
  function dragEvent(e){
    e=e||event;
    dragPiece(e.clientX+1,e.clientY-4);
  }
  
  function dragPiece(x,y){
    var mouse=document.getElementById("PI").firstChild.style;
    mouse.left=x+'px';
    mouse.top=y+'px';
  }
    
  function setPlayer(a){
    P=a;
    for(var z=0;z<BE;z++) if(R[z]<16) setImage(z,R[z]);
    if(P!=M) computerMove()
  }
  
  
  function Undo(){
    if(!N) return;
    N-=2;
    var b=Rh[N];
    R=eval("["+b[0]+"]");
    KL=eval("["+b[1]+"]");
    log(' --undo--');
    K=b[2], M=N%2;
    setPlayer(M);
    reset();
  }
  
/*
  Chess AI engine - functions
  reset()     - reset variables with new game/move
  cmpMove()   - finds the next move from computer
  findMoves() - finds all legal moves - based on how to move (not checked against check/mate situations)
  think()     - recurses a number of levels the best moves from each iteration
  evaluate()  - evaluates the new board from a move if it's favourable
  move()      - performs the move and checks special moves if valid, like castling and en'passent
*/  
  
  function cmpMove(){
    var t=think(level(),M,0,BE,BE,Al,Bt,K);
    move(t[1],t[2],0);
    chequered();
    setColor(t[1],'r');
    setColor(t[2],'r');
  }


  function reset(){
    var z=99,Q;
    s0=(N<32)?4-(N>>3):(N>64);
    G[0]=[], G[8]=[], kY=[], pY=[[],[]];
    for(;z>20;z--){
      a=R[z];
      if(a&7) G[a&8][G[a&8].length]=[a,z];
      Y[z]=bY[z]*s0;
      kY[z]=(N>40)||(10-2*bY[z])*s0;
      Q=pY[1][119-z]=pY[0][z]=PY[z];
      if(N<7 && z>40){
        pY[0][z]=pY[1][119-z]=Q+(Math.random()*Y[z])|1;
        Y[24]=Y[94]=29;
      }
    }
  }


  function mate(c,m){
    m+=c?'checkmate! You '+(J?'loose.':'win.'):'stalemate!';
    log(m);
    J=2; // no more moves allowed
    return 0;
  }
  
 
  function sortFunc(a,b){
    return b[0]-a[0]; 
  }
  
  function think(c,U,C,s,e,A,B,K){
    var z=-1, C=-C, V=8-U, b=Al, r=R, S, E=r[e], g, d;
    if(C<-400) return [C,s,e];
    r[e]=S=r[s], r[s]=0;
    if(S) G[V][G[V].length]=[S,e];
    if(S-U==1 && r[e+Ds[U>>3]]>15) r[e]+=4
    if(S-U==6&&(s-e==2||e-s==2)){
      g=s-4+(s<e)*7;
      d=(s+e)>>1;
      r[g]=0, r[d]=U+2;
    }
  
    var L=findMoves(U,K,C), N=L.length,n;
    if(N){
      if(c){
        L.sort(sortFunc);
        c--;
        var i=L[0], j=i[1], k=i[2], t;
        b=-think(c,V,i[0],j,k,-B,-A,i[3])[0];
        for(z=1;z<N;z++){
          if(b>A) A=b;
          n=L[z];
          t=-think(c,V,n[0],n[1],n[2],-A-1,-A,n[3])[0];
          if((t>A)&&(t<B)) t=-think(c,V,n[0],n[1],n[2],-B,-t,n[3])[0];
          if(t>b){
            b=t, j=n[1], k=n[2];
            if(t>A) A=t;
            if(b>B) break
          }
        }
      } else {
        b=Al;
        while(--N&&B>b) if(L[N][0]>b) b=L[N][0];
      }
    } else mate(0,'');
    if(g) r[g]=U+2, r[d]=0;
    r[s]=S, r[e]=E;
    G[V].length--;
    return[b,j,k];
  }
  
  
  function evaluate(c,U,s,e,K){
    var E=R[e], S=R[e]=R[s];
    R[s]=0;
    reset();
    U=think(c,U,0,BE,BE,Al,Bt,K);
    R[s]=S, R[e]=E;
    return U[0]
  }
  
  
  function move(s,e,b){
    var E=R[e], S=R[s], a=S&7, u=M>>3, c=0, t=0, z=0, p;
    s=s*1.0, e=e*1.0; // Make sure it's a number now
    if(M==P){
      reset();
      p=findMoves(M,K,0);
      for(;z<p.length;z++) t=t||(s==p[z][1]&&e==p[z][2])
      if(!t) return 0;
      if(evaluate(0,8-M,s,e,K)>400) return 0;
    }
    if(evaluate(0,M,s,e,K)>400) c=1;
    var x=s%10, g=e-s, D=Ds[u], t=e%10, n=1+(N>>1), l="abcdefgh";
    var m=(M?'     ':(n<10?" ":"")+n+".  ")+l.charAt(x-1)+((s-x)/10-1)+(E?'x':'-')+l.charAt(t-1)+((e-t)/10-1)+(c?'+':' '); 
    if(evaluate(1,8-M,s,e,K)<-400) return mate(c,m);
    if((E&7)==6) return mate(1,m);
    Rh[N]=[R.toString(),KL.toString(),K];
    K=0;
    if(a==1){
      if(R[e+D]>15) R[s]+=4-b;
      if(g==2*D&&(R[e-1]&1||R[e+1]&1)) K=s+D;
      if(!E&&g%10) movePiece(e,e-D);
    }
    if(s==21+u*70||s==28+u*70) KL[u]&=(x<5)+1;
    if(e==21+u*70||e==28+u*70) KL[!u]&=(x<5)+1;
    if(a==6){
      if(g*g==4) movePiece(s-4+(s<e)*7,s+g/2);
      m+=' castling';
      KL[u]=0;
    }
    movePiece(s,e);
    reset();
    N++;
    M=8-M;
    log(m);
    return 1;
  }
  
  
  function findMoves(U,K,b){
    var W, X, h, E, a, v, n, k=-1, u=U>>3, V=U^8, D=Ds[u], w=[], m, T, p=pY[u], H, d=KL[u], z, c, g, e=G[U], f=e.length, B=R, J=j;
    for (z=0;z<f;z++){
      W=e[z][1], a=B[W];
      if (e[z][0]==a){
        a&=7;
        if(a>1){
          c=a==6, H=c?kY:Y;
          T=b-H[W], n=MV[a];   // Array of legal moves
          if(a==3||c){
            for(v=0;v<8;){
              X=W+n[v++], E=B[X];
              if(!E||(E&24)==V) w[++k]=[T+J[E]+H[X],W,X];
            }
            if(c&&d){
              if(d&1&&!(B[W-1]+B[W-2]+B[W-3])&&CH(W-2,V,D,-1))w[++k]=[T+11,W,W-2];
              if(d&2&&!(B[W+1]+B[W+2])&&CH(W,V,D,1))w[++k]=[T+12,W,W+2]
            }
          } else {
            g=n.length;
            for(v=0;v<g;){
              E=0, m=n[v++], X=W;
              while(!E){
                X+=m, E=B[X];
                if(!E||(E&24)==V) w[++k]=[T+J[E]+H[X],W,X];
              }
            }
          }
        } else {   // Repetetive moves, ie Rook, Bishop, Queen
          T=b-p[W], X=W+D;
          if(!B[X]){
            w[++k]=[T+p[X],W,X];
            if(!p[W]&&(!B[X+D])) w[++k]=[T+p[X+D],W,X+D,X];
          }
          if(K&&(K==X+1||K==X-1)) w[++k]=[T+p[X],W,K];
          for(h=X-1;h<X+2;h+=2){
            E=B[h]+U;
            if(E&7&&E&8) w[++k]=[T+J[E]+p[h],W,h];
          }
        }
      }
    }
    return w;
  }
  
  // Tests for Check situations, ie not Castling through Check positions
  function CH(W,V,D,T){
    var X, E, x, z, m, S=W+3, a=D+2, k=MV[3], B=R;
    for(;W<S;W++){
      for(m=D-2;++m<a;){
        E=B[W+m];
        if(E&&(E&8)==V&&((E&8)==1||(E&7)==6)) return 0;
        E=0, X=W;
        while(!E){
          X+=m, E=B[X];
          if((E==V+2+(m!=D)*2)||E==V+5) return 0;
        }
      }
      for(z=0;z<8;) if(B[W+k[z++]]-V==3) return 0;
    }
    E=0, W-=3;
    while(!E){
      W-=T, E=B[W];
      if(E==V+2||E==V+5) return 0;
    }
    return 1;
  }
}




