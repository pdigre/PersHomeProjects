import no.esito.genova.model.core.QObject;
import no.esito.genova.model.dialogmodel.QAbstractBlock;
import no.esito.genova.model.dialogmodel.QButtonControl;
import no.esito.genova.model.dialogmodel.QDialogModelRoot;
import no.esito.genova.model.dialogmodel.QVarField;
import no.esito.genova.model.dialogmodel.QVarField.VarFieldType;
import no.esito.genova.model.dialogmodel.QWindowBlock;
import no.esito.genova.model.project.QDialogModelFile;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class Android extends AndroidBase {
  public CharSequence call() {
    CharSequence _xblockexpression = null;
    {
      QDialogModelFile _dialogModelRef = this.getDialogModelRef();
      String _operator_plus = StringExtensions.operator_plus(_dialogModelRef.name, ".droid");
      QDialogModelRoot _dialogModelRoot = this.getDialogModelRoot();
      CharSequence _visit = this.visit(_dialogModelRoot);
      this.saveFile(_operator_plus, _visit);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Generated dialog : ");
      QDialogModelFile _dialogModelRef_1 = this.getDialogModelRef();
      _builder.append(_dialogModelRef_1.name, "");
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  public CharSequence visit(final QObject go) {
    CharSequence _switchResult = null;
    boolean matched = false;
    if (!matched) {
      if (go instanceof QDialogModelRoot) {
        final QDialogModelRoot _qDialogModelRoot = (QDialogModelRoot)go;
        if (true) {
          matched=true;
          CharSequence _walk = this.walk(_qDialogModelRoot);
          _switchResult = _walk;
        }
      }
    }
    if (!matched) {
      if (go instanceof QWindowBlock) {
        final QWindowBlock _qWindowBlock = (QWindowBlock)go;
        if (true) {
          matched=true;
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("<WINDOW name=\"");
          String _label = _qWindowBlock.getLabel();
          _builder.append(_label, "");
          _builder.append("\">");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          CharSequence _walk = this.walk(_qWindowBlock);
          _builder.append(_walk, "	");
          _builder.newLineIfNotEmpty();
          _builder.append("</WINDOW>");
          _builder.newLine();
          _switchResult = _builder;
        }
      }
    }
    if (!matched) {
      if (go instanceof QAbstractBlock) {
        final QAbstractBlock _qAbstractBlock = (QAbstractBlock)go;
        if (true) {
          matched=true;
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("<BLOCK name=\"");
          String _label = _qAbstractBlock.getLabel();
          _builder.append(_label, "");
          _builder.append("\">");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          CharSequence _walk = this.walk(_qAbstractBlock);
          _builder.append(_walk, "	");
          _builder.newLineIfNotEmpty();
          _builder.append("</BLOCK>");
          _builder.newLine();
          _switchResult = _builder;
        }
      }
    }
    if (!matched) {
      if (go instanceof QButtonControl) {
        final QButtonControl _qButtonControl = (QButtonControl)go;
        if (true) {
          matched=true;
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("<Button/>");
          _builder.newLine();
          _switchResult = _builder;
        }
      }
    }
    if (!matched) {
      if (go instanceof QVarField) {
        final QVarField _qVarField = (QVarField)go;
        VarFieldType _varFieldType = _qVarField.getVarFieldType();
        boolean _operator_equals = ObjectExtensions.operator_equals(_varFieldType, VarFieldType.TEXT);
        if (_operator_equals) {
          matched=true;
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("<TEXT name=\"");
          String _label = _qVarField.getLabel();
          _builder.append(_label, "");
          _builder.append("\"/>");
          _builder.newLineIfNotEmpty();
          _switchResult = _builder;
        }
      }
    }
    if (!matched) {
      if (go instanceof QVarField) {
        final QVarField _qVarField = (QVarField)go;
        VarFieldType _varFieldType = _qVarField.getVarFieldType();
        boolean _operator_equals = ObjectExtensions.operator_equals(_varFieldType, VarFieldType.COMBOBOX);
        if (_operator_equals) {
          matched=true;
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("<COMBO name=\"");
          String _label = _qVarField.getLabel();
          _builder.append(_label, "");
          _builder.append("\"/>");
          _builder.newLineIfNotEmpty();
          _switchResult = _builder;
        }
      }
    }
    if (!matched) {
      if (go instanceof QVarField) {
        final QVarField _qVarField = (QVarField)go;
        VarFieldType _varFieldType = _qVarField.getVarFieldType();
        boolean _operator_equals = ObjectExtensions.operator_equals(_varFieldType, VarFieldType.CHECKBUTTON);
        if (_operator_equals) {
          matched=true;
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("<CHECKBOX name=\"");
          String _label = _qVarField.getLabel();
          _builder.append(_label, "");
          _builder.append("\"/>");
          _builder.newLineIfNotEmpty();
          _switchResult = _builder;
        }
      }
    }
    if (!matched) {
      if (go instanceof QVarField) {
        final QVarField _qVarField = (QVarField)go;
        VarFieldType _varFieldType = _qVarField.getVarFieldType();
        boolean _operator_equals = ObjectExtensions.operator_equals(_varFieldType, VarFieldType.RADIOGROUP);
        if (_operator_equals) {
          matched=true;
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("<RADIO name=\"");
          String _label = _qVarField.getLabel();
          _builder.append(_label, "");
          _builder.append("\"/> ");
          _builder.newLineIfNotEmpty();
          _switchResult = _builder;
        }
      }
    }
    if (!matched) {
      StringConcatenation _builder = new StringConcatenation();
      _switchResult = _builder;
    }
    return _switchResult;
  }
}
