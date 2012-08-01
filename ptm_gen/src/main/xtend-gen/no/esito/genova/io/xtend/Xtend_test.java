package no.esito.genova.io.xtend;

import no.esito.genova.io.xtend.Per;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;

@SuppressWarnings("all")
public class Xtend_test {
  public Per operator_plus(final Per i1, final Per i2) {
    int _operator_plus = IntegerExtensions.operator_plus(i1.i, i2.i);
    Per _per = new Per(_operator_plus);
    return _per;
  }
  
  public int operator_add(final Per i1, final Per i2) {
    int _operator_plus = IntegerExtensions.operator_plus(i1.i, i2.i);
    int _i = i1.i = _operator_plus;
    return _i;
  }
  
  public static void main(final String[] args) {
    Xtend_test _xtend_test = new Xtend_test();
    _xtend_test.test();
  }
  
  public void test() {
      Per _per = new Per(1);
      Per p1 = _per;
      Per _per_1 = new Per(2);
      Per p2 = _per_1;
      Per p3 = p1;
      this.operator_add(p2, p1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Hello world");
      _builder.append(p2, "");
      System.out.println(_builder);
  }
}
