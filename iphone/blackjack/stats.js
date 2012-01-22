function dealerOdds(){
  var c=[];
  c[0]="<table><tr><th>Card</th><th>Break</th><th>21</th><th>20</th><th>19</th><th>18</th><th>17</th></tr>";
  for(var i=0;i<10;i++){
    var  odds=getOdds(i);
     c[c.length]="<tr><td>"+cardface[i]
                     +"</td><td>"+printOdds(odds[5])
                     +"</td><td>"+printOdds(odds[4])
                     +"</td><td>"+printOdds(odds[3])
                     +"</td><td>"+printOdds(odds[2])
                     +"</td><td>"+printOdds(odds[1])
                     +"</td><td>"+printOdds(odds[0])
                     + "</td></tr>";
  }
   c[c.length]="</table>";

  document.getElementById("chart").innerHTML=c.join("");
}

function printOdds(i){
  return (i*100+"").substr(0,5);  
}

function getOdds(num){
  var nodd=new Array(6);
  for(var i=0;i<6;i++){
    nodd[i]=0.0;
  }
  dealer(cardface[num], nodd);    
  return nodd;
}


function dealer(a,odd){
  var i=hand(a); 
  if(i<17){
    for(var j=0;j<13;j++){
      dealer(a+cardface[j],odd);
    }
  } else if(i>21) {
    odd[5]+=1/chance(a)
  } else {
      odd[i-17]+=1/chance(a);
  }
}

function chance(a){
  switch(a.length){
    case 2: return 13;
    case 3: return 169;
    case 4: return 169*13;
    case 5: return 169*169;
    case 6: return 169*169*13;
    case 7: return 169*169*169;
    case 8: return 169*169*169*13;
    case 9: return 169*169*169*169;
    case 10: return 169*169*169*169*13;
    case 11: return 169*169*169*169*169;
    case 12: return 169*169*169*169*169*13;;
    case 13: return 169*169*169*169*169*169;
  }
  alert(a);
  return 9999999999991;
}

