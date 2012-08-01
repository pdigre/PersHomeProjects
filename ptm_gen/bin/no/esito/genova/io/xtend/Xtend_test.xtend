package no.esito.genova.io.xtend

class Xtend_test {
	
	def operator_plus(Per i1,Per i2){
		new Per(i1.i+i2.i);
	}
	
	def operator_add(Per i1,Per i2){
		i1.i=i1.i+i2.i;
	}
	
	def public static void main(String[] args){
		new Xtend_test().test;
	}
	
	def test(){
		var p1=new Per(1);
		var p2=new Per(2);
		var p3=p1;
		p2+=p1
		System::out.println('''Hello world«p2»''')
		
	}
}