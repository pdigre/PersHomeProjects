package no.pdigre.droidchess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ChessEngine {
	void ChessEngine() {

	}

	public static int Bt = 1999;
	public static int Al = -1999;
	/**
	 * BoardSize
	 */
	public static int BE = 120;

	/**
	 * Relative values of pieces
	 */
	public static int[] j = new int[] { 0, 1, 5, 3, 3, 9, 63, 0 };
	/**
	 * Pieces printed name
	 */
	public static String[] pieces = new String[] { "Pawn", "Rook", "Knight",
			"Bishop", "Queen", "King" };

	/**
	 * Allowed moves
	 */
	public static int[][] MV = new int[][] { new int[] {}, new int[] {},
			new int[] { 1, 10 }, // Castling
			new int[] { 21, 19, 12, 8 }, // Knight
											// (FW-Right,FW-Left,Side-Right,Side-Left)
			new int[] { 11, 9 }, // Bishop and pawn capture (FW-Right,FW-Left)
			new int[] { 1, 10, 11, 9 }, // Queen (same as King)
			new int[] { 1, 10, 11, 9 }, // King (Left,FW,FW-Right,FW-Left)
			new int[] {} };

	/**
	 * Chess Board 12*10 includes illegal borders g-border, 0-Empty, 9/1-pawn,
	 * A/2-Rook, B/3-Knight, C/4-Bishop, D/5-Queen, E/6-King
	 */
	String b = "gggggggggg" + "gggggggggg" + "g23456432g" + "g11111111g"
			+ "g00000000g" + "g00000000g" + "g00000000g" + "g00000000g"
			+ "g99999999g" + "gABCDECBAg" + "gggggggggg" + "gggggggggg";

	/**
	 * Relative weighing of position strength
	 */
	String w = "g00000000g" + "g00000000g" + "g00000000g" + "0001111000"
			+ "0012332100" + "0123553210";

	String a = "000012346900";

	int[] Rh = null;
	int[][][] G = null;
	int[] R = null;
	int[] Y = null;
	int[] PY = null;
	int[] bY = null;
	int[] kY = null;
	int[][] pY = null;
	int[] KL = new int[] { 3, 3 };
	int[] Ds = new int[] { 10, -10 };
	int J = 0; // Player's turn = 0, Mate = 2
	int M = 0; // Turn
	int N = 0;
	int K = 0;
	int y = 0;
	int k=0;

	// public void init(){
	// // Initilize global variables

	// var startPos=0, endPos=0, liftPiece=0; // Piece move handling
	// R[BE]=0;
	// for(var z=0;z<8;){
	// j[z+8]=j[z]<<=4;
	// var m=MV[z++];
	// if(m){
	// var s=m.length;
	// for(var x=0;x<s;) m[s+x]=-m[x++];
	// }
	// }
	//
	//
	// for(var y=0;y<12;y++) for(var x=0;x<10;x++){ // Row by Col
	// var z=(y*10)+x;
	// PY[z]=parseInt(a.charAt(y));
	// bY[z]=parseInt(w.charAt((z<60)?z:119-z),35)&7;
	// R[z]=parseInt(b.charAt(z),35)
	// }
	// // Restart board
	// chequered();
	// reset();
	// setPlayer(0); // White
	// }

	
	  public void reset(){
		    int z=99;
		    int Q=0;
		    int s0=(N<32?4-(N>>3):(N>64));
		    G[0]=null; 
		    G[8]=null; 
		    kY=null; 
		    pY=null;
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


	  public int mate(boolean c,String m){
		    m+=c?"checkmate! You "+(J!=0?"loose.":"win."):"stalemate!";
		    J=2; // no more moves allowed
		    return 0;
		  }
		  
		 
	
	
	public int[] think(int c,int U,int C,int s,int e,int A,int B,int K){
		    int z=-1;
		    C=-C;
		    int V=8-U;
		    int b=Al;
		    int[] r=R;
		    int S=0;
		    int E=r[e];
		    int g=0;
		    int d=0;
		    if(C<-400) 
		    	return new int[]{C,s,e};
		    S=r[s];
		    r[e]=S;
		    r[s]=0;
		    if(S!=0) 
		    	G[V][G[V].length]=new int[]{S,e};
		    if(S-U==1 && r[e+Ds[U>>3]]>15) 
		    	r[e]+=4;
		    if(S-U==6&&(s-e==2||e-s==2)){
		      g=s-4+(s<e?7:0);
		      d=(s+e)>>1;
		      r[g]=0;
		      r[d]=U+2;
		    }
		  
		    int[][] L=findMoves(U,K,C);
		    int N=L.length;
		    int[] n=null;
		    if(N!=0){
		      if(c!=0){
		        Arrays.sort(L,new Comparator<int[]>() {

					@Override
					public int compare(int[] lhs, int[] rhs) {
						return rhs[0]-lhs[0];
					}
				});
		        c--;
		        int[] i=L[0];
		        int j=i[1];
		        int k=i[2];
		        int t=0;
		        b=-think(c,V,i[0],j,k,-B,-A,i[3])[0];
		        for(z=1;z<N;z++){
		          if(b>A) A=b;
		          n=L[z];
		          t=-think(c,V,n[0],n[1],n[2],-A-1,-A,n[3])[0];
		          if((t>A)&&(t<B)) t=-think(c,V,n[0],n[1],n[2],-B,-t,n[3])[0];
		          if(t>b){
		            b=t;
		            j=n[1];
		            k=n[2];
		            if(t>A) A=t;
		            if(b>B) break;
		          }
		        }
		      } else {
		        b=Al;
		        while(--N!=0 && B>b) if(L[N][0]>b) b=L[N][0];
		      }
		    } else mate(false,"");
		    if(g!=0) r[g]=U+2;
		    r[d]=0;
		    r[s]=S;
		    r[e]=E;
		    G[V].length--;
		    return new int[]{b,J,k};
		  }

	public int evaluate(int c, int[] U, int s, int e, int K) {
		int E = R[e];
		R[e] = R[s];
		int S = R[e];
		R[s] = 0;
		reset();
		U = think(c, U[0], 0, BE, BE, Al, Bt, K);
		R[s] = S;
		R[e] = E;
		return U[0];
	}

	public int[][] findMoves(int U, int K, int b) {
		int W = 0;
		int X = 0;
		int h = 0;
		int E = 0;
		int a = 0;
		int v = 0;
		ArrayList<int[]> moves = new ArrayList<int[]>();
		int[] n = null;
		int u = U >> 3;
		int V = U ^ 8;
		int D = Ds[u];
		int m = 0;
		int T = 0;
		int[] p = pY[u];
		int[] H = null;
		int d = KL[u];
		int z = 0;
		boolean c = false;
		int g = 0;
		int[][] e = G[U];
		int f = e.length;
		int[] B = R;
		int[] J = j;
		for (z = 0; z < f; z++) {
			W = e[z][1];
			a = B[W];
			if (e[z][0] == a) {
				a &= 7;
				if (a > 1) {
					c = a == 6;
					H = c ? kY : Y;
					T = b - H[W];
					n = MV[a]; // Array of legal moves
					if (a == 3 || c) {
						for (v = 0; v < 8;) {
							X = W + n[v++];
							E = B[X];
							if (E == 0 || (E & 24) == V)
								moves.add(new int[] { T + J[E] + H[X], W, X });
						}
						if (c && d != 0) {
							if ((d & 1) > 0
									&& B[W - 1] + B[W - 2] + B[W - 3] == 0
									&& CH(W - 2, V, D, -1))
								moves.add(new int[] { T + 11, W, W - 2 });
							if ((d & 2) > 0 && B[W + 1] + B[W + 2] == 0
									&& CH(W, V, D, 1))
								moves.add(new int[] { T + 12, W, W + 2 });
						}
					} else {
						g = n.length;
						for (v = 0; v < g;) {
							E = 0;
							m = n[v++];
							X = W;
							while (E == 0) {
								X += m;
								E = B[X];
								if (E == 0 || (E & 24) == V)
									moves.add(new int[] { T + J[E] + H[X], W, X });
							}
						}
					}
				} else { // Repetitive moves, ie Rook, Bishop, Queen
					T = b - p[W];
					X = W + D;
					if (B[X] == 0) {
						moves.add(new int[] { T + p[X], W, X });
						if (p[W] == 0 && (B[X + D] == 0))
							moves.add(new int[] { T + p[X + D], W, X + D, X });
					}
					if (K != 0 && (K == X + 1 || K == X - 1))
						moves.add(new int[] { T + p[X], W, K });
					for (h = X - 1; h < X + 2; h += 2) {
						E = B[h] + U;
						if ((E & 7) > 0 && (E & 8) > 0)
							moves.add(new int[] { T + J[E] + p[h], W, h });
					}
				}
			}
		}
		return moves.toArray(new int[moves.size()][]);
	}

	// Tests for Check situations, ie not Castling through Check positions
	public boolean CH(int W, int V, int D, int T) {
		int X = 0;
		int E = 0;
		int z = 0;
		int m = 0;
		int S = W + 3;
		int a = D + 2;
		int[] k = MV[3];
		int[] B = R;

		for (; W < S; W++) {
			for (m = D - 2; ++m < a;) {
				E = B[W + m];
				if (E != 0 && (E & 8) == V && ((E & 8) == 1 || (E & 7) == 6))
					return false;
				E = 0;
				X = W;
				while (E == 0) {
					X += m;
					E = B[X];
					if ((E == V + 2 + (m != D ? 2 : 0)) || E == V + 5)
						return false;
				}
			}
			for (z = 0; z < 8;)
				if (B[W + k[z++]] - V == 3)
					return false;
		}
		E = 0;
		W -= 3;
		while (E != 0) {
			W -= T;
			E = B[W];
			if (E == V + 2 || E == V + 5)
				return false;
		}
		return true;
	}

}
