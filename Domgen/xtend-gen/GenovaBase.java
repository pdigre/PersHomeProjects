import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

@SuppressWarnings("all")
public class GenovaBase extends GenovaBase2 {
  public CharSequence typedef(final String name, final Function1<? super Object,? extends Object> string) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("  ");
    return _builder;
  }
  
  public CharSequence call() {
    return null;
  }
}
