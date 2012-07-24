package no.esito.genova.io.xtend;

import no.esito.genova.io.antlr.GParser;
import no.esito.genova.io.xtend.AbstractPtm2Xtend;
import no.esito.genova.io.xtend.EXPSTATE;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class Ptm2Xtend extends AbstractPtm2Xtend {
  public CharSequence what() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<");
    String _text = this.node.token.getText();
    _builder.append(_text, "");
    _builder.append(">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _walk = this.walk();
    _builder.append(_walk, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("</");
    String _text_1 = this.node.token.getText();
    _builder.append(_text_1, "");
    CharSequence _bp = this.bp();
    _builder.append(_bp, "");
    _builder.append(">");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence _stat() {
    CharSequence _switchResult = null;
    int _type = this.node.token.getType();
    final int __valOfSwitchOver = _type;
    boolean matched = false;
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.SUB)) {
        matched=true;
        CharSequence _xblockexpression = null;
        {
          CharSequence _expr = this.expr(EXPSTATE.String, 1);
          String _operator_plus = StringExtensions.operator_plus("\u00AB", _expr);
          String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "\u00BB");
          String text = _operator_plus_1;
          StringConcatenation _builder = new StringConcatenation();
          String _string = text.toString();
          _builder.append(_string, "");
          _xblockexpression = (_builder);
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.MACRO)) {
        matched=true;
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("\u00AB", "");
        _builder_1.append("macro(\"");
        CharSequence _txt = this.txt(1);
        _builder_1.append(_txt, "");
        _builder_1.append("\")");
        _builder_1.append("\u00BB", "");
        _builder_1.newLineIfNotEmpty();
        _switchResult = _builder_1;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.TYPED)) {
        matched=true;
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("\u00AB", "");
        _builder_2.append("typed(\"");
        CharSequence _txt_1 = this.txt(1);
        _builder_2.append(_txt_1, "");
        _builder_2.append("\")");
        _builder_2.append("\u00BB", "");
        _builder_2.newLineIfNotEmpty();
        _switchResult = _builder_2;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.PROG)) {
        matched=true;
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("import GenovaBase");
        _builder_3.newLine();
        _builder_3.newLine();
        _builder_3.append("class ");
        _builder_3.append(this.clazzname, "");
        _builder_3.append(" extends GenovaBase{ ");
        _builder_3.newLineIfNotEmpty();
        _builder_3.append("\t");
        _builder_3.append("X");
        String _root = this.getRoot();
        _builder_3.append(_root, "	");
        _builder_3.append(" ");
        String _root_1 = this.getRoot();
        String _lowerCase = _root_1.toLowerCase();
        String _fixName = this.fixName(_lowerCase);
        _builder_3.append(_fixName, "	");
        _builder_3.newLineIfNotEmpty();
        _builder_3.append("\t");
        _builder_3.append("override call(){");
        _builder_3.newLine();
        _builder_3.append("\t \t");
        CharSequence _walk = this.walk();
        _builder_3.append(_walk, "	 	");
        String _close = this.close();
        _builder_3.append(_close, "	 	");
        _builder_3.newLineIfNotEmpty();
        _builder_3.append("\t \t");
        _builder_3.append("\'\'\'\u00ABcontext.toString\u00BB\'\'\'", "	 	");
        _builder_3.newLineIfNotEmpty();
        _builder_3.append("\t ");
        _builder_3.append("}");
        _builder_3.newLine();
        _builder_3.append("}");
        _switchResult = _builder_3;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.ITERATE)) {
        matched=true;
        CharSequence _xblockexpression_1 = null;
        {
          CharSequence _txt_2 = this.txt(1);
          String _string_1 = _txt_2.toString();
          String iterator = _string_1;
          StringConcatenation _builder_4 = new StringConcatenation();
          _builder_4.append("for(");
          String _lowerCase_1 = iterator.toLowerCase();
          String _fixName_1 = this.fixName(_lowerCase_1);
          _builder_4.append(_fixName_1, "");
          _builder_4.append(":");
          String _deduceParent = this.deduceParent(iterator);
          String _lowerCase_2 = _deduceParent.toLowerCase();
          String _fixName_2 = this.fixName(_lowerCase_2);
          _builder_4.append(_fixName_2, "");
          _builder_4.append(".iterate");
          _builder_4.append(iterator, "");
          _builder_4.append("){");
          _builder_4.newLineIfNotEmpty();
          _builder_4.append("\t");
          CharSequence _walk_1 = this.walk(1);
          _builder_4.append(_walk_1, "	");
          String _close_1 = this.close();
          _builder_4.append(_close_1, "	");
          _builder_4.newLineIfNotEmpty();
          _builder_4.append("}");
          _builder_4.newLine();
          _xblockexpression_1 = (_builder_4);
        }
        _switchResult = _xblockexpression_1;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.REM)) {
        matched=true;
        CharSequence _cmt = this.cmt();
        _switchResult = _cmt;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.OUT)) {
        matched=true;
        StringConcatenation _builder_5 = new StringConcatenation();
        CharSequence _out = this.out();
        _builder_5.append(_out, "");
        _builder_5.newLineIfNotEmpty();
        _switchResult = _builder_5;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.IF_)) {
        matched=true;
        StringConcatenation _builder_6 = new StringConcatenation();
        _builder_6.append("if(");
        CharSequence _expr_1 = this.expr(EXPSTATE.Boolean, 1);
        _builder_6.append(_expr_1, "");
        _builder_6.append("){");
        _builder_6.newLineIfNotEmpty();
        _builder_6.append("\t");
        CharSequence _walk_2 = this.walk(2);
        _builder_6.append(_walk_2, "	");
        String _close_2 = this.close();
        _builder_6.append(_close_2, "	");
        _builder_6.newLineIfNotEmpty();
        _builder_6.append("}");
        CharSequence _walk2 = this.walk2(3);
        _builder_6.append(_walk2, "");
        _builder_6.newLineIfNotEmpty();
        _switchResult = _builder_6;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.ELSEIF_)) {
        matched=true;
        StringConcatenation _builder_7 = new StringConcatenation();
        _builder_7.append("else if(");
        CharSequence _expr_2 = this.expr(EXPSTATE.Boolean, 1);
        _builder_7.append(_expr_2, "");
        _builder_7.append("){");
        _builder_7.newLineIfNotEmpty();
        _builder_7.append("\t");
        CharSequence _walk_3 = this.walk(2);
        _builder_7.append(_walk_3, "	");
        String _close_3 = this.close();
        _builder_7.append(_close_3, "	");
        _builder_7.newLineIfNotEmpty();
        _builder_7.append("}");
        _builder_7.newLine();
        _switchResult = _builder_7;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.ELSE_)) {
        matched=true;
        StringConcatenation _builder_8 = new StringConcatenation();
        _builder_8.append("else {");
        _builder_8.newLine();
        _builder_8.append("\t");
        CharSequence _walk_4 = this.walk();
        _builder_8.append(_walk_4, "	");
        String _close_4 = this.close();
        _builder_8.append(_close_4, "	");
        _builder_8.newLineIfNotEmpty();
        _builder_8.append("}");
        _builder_8.newLine();
        _switchResult = _builder_8;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.IFCONTEXT)) {
        matched=true;
        StringConcatenation _builder_9 = new StringConcatenation();
        _builder_9.append("if(isContext(\"");
        CharSequence _txt_3 = this.txt(1);
        _builder_9.append(_txt_3, "");
        _builder_9.append("\")){");
        _builder_9.newLineIfNotEmpty();
        _builder_9.append("\t");
        CharSequence _walk_5 = this.walk(2);
        _builder_9.append(_walk_5, "	");
        String _close_5 = this.close();
        _builder_9.append(_close_5, "	");
        _builder_9.newLineIfNotEmpty();
        _builder_9.append("}");
        CharSequence _walk2_1 = this.walk2(3);
        _builder_9.append(_walk2_1, "");
        _builder_9.newLineIfNotEmpty();
        _switchResult = _builder_9;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.CONTEXT)) {
        matched=true;
        StringConcatenation _builder_10 = new StringConcatenation();
        _builder_10.append("setContext(\"");
        CharSequence _txt_4 = this.txt(1);
        _builder_10.append(_txt_4, "");
        _builder_10.append("\")");
        _builder_10.newLineIfNotEmpty();
        _switchResult = _builder_10;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.ENDCONTEXT)) {
        matched=true;
        StringConcatenation _builder_11 = new StringConcatenation();
        _builder_11.append("endContext");
        _builder_11.newLine();
        _switchResult = _builder_11;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.SET)) {
        matched=true;
        StringConcatenation _builder_12 = new StringConcatenation();
        CharSequence _expr_3 = this.expr(EXPSTATE.String, 1);
        _builder_12.append(_expr_3, "");
        _builder_12.append(" = ");
        CharSequence _expr_4 = this.expr(EXPSTATE.String, 2);
        _builder_12.append(_expr_4, "");
        _builder_12.newLineIfNotEmpty();
        _switchResult = _builder_12;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.TYPES_MODE)) {
        matched=true;
        CharSequence _walk_6 = this.walk();
        _switchResult = _walk_6;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.TYPE)) {
        matched=true;
        StringConcatenation _builder_13 = new StringConcatenation();
        _builder_13.append("typedef(\"");
        CharSequence _typedef1 = this.typedef1();
        _builder_13.append(_typedef1, "");
        _builder_13.append("\",[c|{");
        CharSequence _walk_7 = this.walk();
        _builder_13.append(_walk_7, "");
        String _close_6 = this.close();
        _builder_13.append(_close_6, "");
        _builder_13.append("}])");
        _builder_13.newLineIfNotEmpty();
        _switchResult = _builder_13;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.TYPEDEF)) {
        matched=true;
        StringConcatenation _builder_14 = new StringConcatenation();
        _builder_14.append("typedef(\"");
        CharSequence _typedef2 = this.typedef2();
        _builder_14.append(_typedef2, "");
        _builder_14.append("\",[c|{");
        CharSequence _walk_8 = this.walk(1);
        _builder_14.append(_walk_8, "");
        String _close_7 = this.close();
        _builder_14.append(_close_7, "");
        _builder_14.append("}])");
        _builder_14.newLineIfNotEmpty();
        _switchResult = _builder_14;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.LOOP)) {
        matched=true;
        StringConcatenation _builder_15 = new StringConcatenation();
        _builder_15.append("loop(");
        CharSequence _expr_5 = this.expr(EXPSTATE.String, 1);
        _builder_15.append(_expr_5, "");
        _builder_15.append(",[c|");
        CharSequence _walk_9 = this.walk(2);
        _builder_15.append(_walk_9, "");
        String _close_8 = this.close();
        _builder_15.append(_close_8, "");
        _builder_15.append("])");
        _builder_15.newLineIfNotEmpty();
        _switchResult = _builder_15;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.CONTINUE)) {
        matched=true;
        StringConcatenation _builder_16 = new StringConcatenation();
        _builder_16.append("continueLoop");
        _builder_16.newLine();
        _switchResult = _builder_16;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.BREAK)) {
        matched=true;
        StringConcatenation _builder_17 = new StringConcatenation();
        _builder_17.append("breakLoop");
        _builder_17.newLine();
        _switchResult = _builder_17;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.LINE)) {
        matched=true;
        StringConcatenation _builder_18 = new StringConcatenation();
        _builder_18.append("line");
        _builder_18.newLine();
        _switchResult = _builder_18;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.ENDLINE)) {
        matched=true;
        StringConcatenation _builder_19 = new StringConcatenation();
        _builder_19.append("endline");
        _builder_19.newLine();
        _switchResult = _builder_19;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.INDENT)) {
        matched=true;
        StringConcatenation _builder_20 = new StringConcatenation();
        _builder_20.append("indentBegin");
        _builder_20.newLine();
        _switchResult = _builder_20;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.INDENT2)) {
        matched=true;
        StringConcatenation _builder_21 = new StringConcatenation();
        _builder_21.append("indent(");
        CharSequence _txt_5 = this.txt(1);
        _builder_21.append(_txt_5, "");
        _builder_21.append(")");
        _builder_21.newLineIfNotEmpty();
        _switchResult = _builder_21;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.ENDINDENT)) {
        matched=true;
        StringConcatenation _builder_22 = new StringConcatenation();
        _builder_22.append("indentEnd");
        _builder_22.newLine();
        _switchResult = _builder_22;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.STR)) {
        matched=true;
        StringConcatenation _builder_23 = new StringConcatenation();
        _builder_23.append("str(\"");
        CharSequence _txt_6 = this.txt(1);
        _builder_23.append(_txt_6, "");
        _builder_23.append("\")");
        _builder_23.newLineIfNotEmpty();
        _switchResult = _builder_23;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.ENDSTR)) {
        matched=true;
        StringConcatenation _builder_24 = new StringConcatenation();
        _builder_24.append("strEnd");
        _builder_24.newLine();
        _switchResult = _builder_24;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.FILE)) {
        matched=true;
        StringConcatenation _builder_25 = new StringConcatenation();
        _builder_25.append("file(");
        CharSequence _file = this.file(1);
        _builder_25.append(_file, "");
        _builder_25.append(")");
        _builder_25.newLineIfNotEmpty();
        _switchResult = _builder_25;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.NEWFILE)) {
        matched=true;
        StringConcatenation _builder_26 = new StringConcatenation();
        _builder_26.append("newfile(");
        CharSequence _file_1 = this.file(1);
        _builder_26.append(_file_1, "");
        _builder_26.append(")");
        _builder_26.newLineIfNotEmpty();
        _switchResult = _builder_26;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.IGNOREFILE)) {
        matched=true;
        StringConcatenation _builder_27 = new StringConcatenation();
        _builder_27.append("ignorefile(");
        CharSequence _file_2 = this.file(1);
        _builder_27.append(_file_2, "");
        _builder_27.append(")");
        _builder_27.newLineIfNotEmpty();
        _switchResult = _builder_27;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.POPFILE)) {
        matched=true;
        StringConcatenation _builder_28 = new StringConcatenation();
        _builder_28.append("popfile");
        _builder_28.newLine();
        _switchResult = _builder_28;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.PUSHFILE)) {
        matched=true;
        StringConcatenation _builder_29 = new StringConcatenation();
        _builder_29.append("pushfile(");
        CharSequence _file_3 = this.file(1);
        _builder_29.append(_file_3, "");
        _builder_29.append(")");
        _builder_29.newLineIfNotEmpty();
        _switchResult = _builder_29;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.COPYFILE)) {
        matched=true;
        StringConcatenation _builder_30 = new StringConcatenation();
        _builder_30.append("copyfile(");
        CharSequence _file_4 = this.file(1);
        _builder_30.append(_file_4, "");
        _builder_30.append(",");
        CharSequence _file_5 = this.file(2);
        _builder_30.append(_file_5, "");
        _builder_30.append(")");
        _builder_30.newLineIfNotEmpty();
        _switchResult = _builder_30;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.ENDFILE)) {
        matched=true;
        StringConcatenation _builder_31 = new StringConcatenation();
        _builder_31.append("endfile");
        _builder_31.newLine();
        _switchResult = _builder_31;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.INCLUDE)) {
        matched=true;
        StringConcatenation _builder_32 = new StringConcatenation();
        _builder_32.append("include(");
        CharSequence _file_6 = this.file(1);
        _builder_32.append(_file_6, "");
        _builder_32.append(")");
        _builder_32.newLineIfNotEmpty();
        _switchResult = _builder_32;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.ERROR)) {
        matched=true;
        StringConcatenation _builder_33 = new StringConcatenation();
        _builder_33.append("error(");
        CharSequence _expr_6 = this.expr(EXPSTATE.String, 1);
        _builder_33.append(_expr_6, "");
        _builder_33.append(")");
        _builder_33.newLineIfNotEmpty();
        _switchResult = _builder_33;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.INFO)) {
        matched=true;
        StringConcatenation _builder_34 = new StringConcatenation();
        _builder_34.append("info(");
        CharSequence _expr_7 = this.expr(EXPSTATE.String, 1);
        _builder_34.append(_expr_7, "");
        _builder_34.append(")");
        _builder_34.newLineIfNotEmpty();
        _switchResult = _builder_34;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.WARNING)) {
        matched=true;
        StringConcatenation _builder_35 = new StringConcatenation();
        _builder_35.append("warning(");
        CharSequence _expr_8 = this.expr(EXPSTATE.String, 1);
        _builder_35.append(_expr_8, "");
        _builder_35.append(")");
        _builder_35.newLineIfNotEmpty();
        _switchResult = _builder_35;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.DEBUG)) {
        matched=true;
        StringConcatenation _builder_36 = new StringConcatenation();
        _builder_36.append("debug(");
        CharSequence _expr_9 = this.expr(EXPSTATE.String, 1);
        _builder_36.append(_expr_9, "");
        _builder_36.append(")");
        _builder_36.newLineIfNotEmpty();
        _switchResult = _builder_36;
      }
    }
    if (!matched) {
      StringConcatenation _builder_37 = new StringConcatenation();
      _builder_37.append("<STAT?>");
      CharSequence _what = this.what();
      _builder_37.append(_what, "");
      _switchResult = _builder_37;
    }
    return _switchResult;
  }
  
  public CharSequence _expr() {
    CharSequence _switchResult = null;
    int _type = this.node.token.getType();
    final int __valOfSwitchOver = _type;
    boolean matched = false;
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.PLUS)) {
        matched=true;
        StringConcatenation _builder = new StringConcatenation();
        CharSequence _expr = this.expr(EXPSTATE.Integer, 1);
        _builder.append(_expr, "");
        _builder.append(" + ");
        CharSequence _expr_1 = this.expr(EXPSTATE.Integer, 2);
        _builder.append(_expr_1, "");
        _switchResult = _builder;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.MINUS)) {
        matched=true;
        StringConcatenation _builder_1 = new StringConcatenation();
        CharSequence _expr_2 = this.expr(EXPSTATE.Integer, 1);
        _builder_1.append(_expr_2, "");
        _builder_1.append(" - ");
        CharSequence _expr_3 = this.expr(EXPSTATE.Integer, 2);
        _builder_1.append(_expr_3, "");
        _switchResult = _builder_1;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.MULTIPLY)) {
        matched=true;
        StringConcatenation _builder_2 = new StringConcatenation();
        CharSequence _expr_4 = this.expr(EXPSTATE.Integer, 1);
        _builder_2.append(_expr_4, "");
        _builder_2.append(" * ");
        CharSequence _expr_5 = this.expr(EXPSTATE.Integer, 2);
        _builder_2.append(_expr_5, "");
        _switchResult = _builder_2;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.SLASH)) {
        matched=true;
        StringConcatenation _builder_3 = new StringConcatenation();
        CharSequence _expr_6 = this.expr(EXPSTATE.Integer, 1);
        _builder_3.append(_expr_6, "");
        _builder_3.append(" / ");
        CharSequence _expr_7 = this.expr(EXPSTATE.Integer, 2);
        _builder_3.append(_expr_7, "");
        _switchResult = _builder_3;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.HAT)) {
        matched=true;
        StringConcatenation _builder_4 = new StringConcatenation();
        _builder_4.append("exponent(");
        CharSequence _expr_8 = this.expr(EXPSTATE.Integer, 1);
        _builder_4.append(_expr_8, "");
        _builder_4.append(",");
        CharSequence _expr_9 = this.expr(EXPSTATE.Integer, 2);
        _builder_4.append(_expr_9, "");
        _builder_4.append(")");
        _switchResult = _builder_4;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.TILDE)) {
        matched=true;
        StringConcatenation _builder_5 = new StringConcatenation();
        _builder_5.append("tilde(");
        CharSequence _expr_10 = this.expr(EXPSTATE.String, 1);
        _builder_5.append(_expr_10, "");
        _builder_5.append(",");
        CharSequence _expr_11 = this.expr(EXPSTATE.String, 2);
        _builder_5.append(_expr_11, "");
        _builder_5.append(")");
        _switchResult = _builder_5;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.APPEND)) {
        matched=true;
        StringConcatenation _builder_6 = new StringConcatenation();
        CharSequence _expr_12 = this.expr(EXPSTATE.String, 1);
        _builder_6.append(_expr_12, "");
        _builder_6.append(" + ");
        CharSequence _expr_13 = this.expr(EXPSTATE.String, 2);
        _builder_6.append(_expr_13, "");
        _switchResult = _builder_6;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.OR)) {
        matched=true;
        StringConcatenation _builder_7 = new StringConcatenation();
        CharSequence _expr_14 = this.expr(EXPSTATE.Boolean, 1);
        _builder_7.append(_expr_14, "");
        _builder_7.append(" || ");
        CharSequence _expr_15 = this.expr(EXPSTATE.Boolean, 2);
        _builder_7.append(_expr_15, "");
        _switchResult = _builder_7;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.AND)) {
        matched=true;
        StringConcatenation _builder_8 = new StringConcatenation();
        CharSequence _expr_16 = this.expr(EXPSTATE.Boolean, 1);
        _builder_8.append(_expr_16, "");
        _builder_8.append(" && ");
        CharSequence _expr_17 = this.expr(EXPSTATE.Boolean, 2);
        _builder_8.append(_expr_17, "");
        _switchResult = _builder_8;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.EQUAL)) {
        matched=true;
        StringConcatenation _builder_9 = new StringConcatenation();
        CharSequence _expr_18 = this.expr(EXPSTATE.String, 1);
        _builder_9.append(_expr_18, "");
        _builder_9.append(" == ");
        CharSequence _expr_19 = this.expr(EXPSTATE.String, 2);
        _builder_9.append(_expr_19, "");
        _switchResult = _builder_9;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.NE)) {
        matched=true;
        StringConcatenation _builder_10 = new StringConcatenation();
        CharSequence _expr_20 = this.expr(EXPSTATE.String, 1);
        _builder_10.append(_expr_20, "");
        _builder_10.append(" != ");
        CharSequence _expr_21 = this.expr(EXPSTATE.String, 2);
        _builder_10.append(_expr_21, "");
        _switchResult = _builder_10;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.GT)) {
        matched=true;
        StringConcatenation _builder_11 = new StringConcatenation();
        CharSequence _expr_22 = this.expr(EXPSTATE.Integer, 1);
        _builder_11.append(_expr_22, "");
        _builder_11.append(" > ");
        CharSequence _expr_23 = this.expr(EXPSTATE.Integer, 2);
        _builder_11.append(_expr_23, "");
        _switchResult = _builder_11;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.GE)) {
        matched=true;
        StringConcatenation _builder_12 = new StringConcatenation();
        CharSequence _expr_24 = this.expr(EXPSTATE.Integer, 1);
        _builder_12.append(_expr_24, "");
        _builder_12.append(" >= ");
        CharSequence _expr_25 = this.expr(EXPSTATE.Integer, 2);
        _builder_12.append(_expr_25, "");
        _switchResult = _builder_12;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.LT)) {
        matched=true;
        StringConcatenation _builder_13 = new StringConcatenation();
        CharSequence _expr_26 = this.expr(EXPSTATE.Integer, 1);
        _builder_13.append(_expr_26, "");
        _builder_13.append(" < ");
        CharSequence _expr_27 = this.expr(EXPSTATE.Integer, 2);
        _builder_13.append(_expr_27, "");
        _switchResult = _builder_13;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.LE)) {
        matched=true;
        StringConcatenation _builder_14 = new StringConcatenation();
        CharSequence _expr_28 = this.expr(EXPSTATE.Integer, 1);
        _builder_14.append(_expr_28, "");
        _builder_14.append(" <= ");
        CharSequence _expr_29 = this.expr(EXPSTATE.Integer, 2);
        _builder_14.append(_expr_29, "");
        _switchResult = _builder_14;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.NOT)) {
        matched=true;
        StringConcatenation _builder_15 = new StringConcatenation();
        _builder_15.append("!(");
        CharSequence _expr_30 = this.expr(EXPSTATE.Boolean, 1);
        _builder_15.append(_expr_30, "");
        _builder_15.append(")");
        _switchResult = _builder_15;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.QUESTION)) {
        matched=true;
        StringConcatenation _builder_16 = new StringConcatenation();
        _builder_16.append("if (");
        CharSequence _expr_31 = this.expr(EXPSTATE.Boolean, 1);
        _builder_16.append(_expr_31, "");
        _builder_16.append(") ");
        CharSequence _expr_32 = this.expr(EXPSTATE.String, 2);
        _builder_16.append(_expr_32, "");
        _builder_16.append(" else ");
        CharSequence _expr_33 = this.expr(EXPSTATE.String, 3);
        _builder_16.append(_expr_33, "");
        _switchResult = _builder_16;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.VARIABLE)) {
        matched=true;
        CharSequence _xifexpression = null;
        boolean _operator_equals = ObjectExtensions.operator_equals(this.exprtype, EXPSTATE.Boolean);
        if (_operator_equals) {
          StringConcatenation _builder_17 = new StringConcatenation();
          CharSequence _txt = this.txt(1);
          CharSequence _vscope = this.vscope(_txt);
          _builder_17.append(_vscope, "");
          CharSequence _expr2 = this.expr2(2);
          _builder_17.append(_expr2, "");
          _xifexpression = _builder_17;
        } else {
          StringConcatenation _builder_18 = new StringConcatenation();
          CharSequence _txt_1 = this.txt(1);
          CharSequence _vscope_1 = this.vscope(_txt_1);
          _builder_18.append(_vscope_1, "");
          CharSequence _expr2_1 = this.expr2(2);
          _builder_18.append(_expr2_1, "");
          _xifexpression = _builder_18;
        }
        _switchResult = _xifexpression;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.VARIABLE2)) {
        matched=true;
        CharSequence _xifexpression_1 = null;
        boolean _operator_equals_1 = ObjectExtensions.operator_equals(this.exprtype, EXPSTATE.Boolean);
        if (_operator_equals_1) {
          StringConcatenation _builder_19 = new StringConcatenation();
          CharSequence _txt_2 = this.txt(1);
          CharSequence _txt_3 = this.txt(2);
          CharSequence _vscope_2 = this.vscope(_txt_2, _txt_3);
          _builder_19.append(_vscope_2, "");
          CharSequence _expr2_2 = this.expr2(3);
          _builder_19.append(_expr2_2, "");
          _builder_19.append(".toBool");
          _xifexpression_1 = _builder_19;
        } else {
          StringConcatenation _builder_20 = new StringConcatenation();
          CharSequence _txt_4 = this.txt(1);
          CharSequence _txt_5 = this.txt(2);
          CharSequence _vscope_3 = this.vscope(_txt_4, _txt_5);
          _builder_20.append(_vscope_3, "");
          CharSequence _expr2_3 = this.expr2(3);
          _builder_20.append(_expr2_3, "");
          _xifexpression_1 = _builder_20;
        }
        _switchResult = _xifexpression_1;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.ATTRIBUTE)) {
        matched=true;
        CharSequence _xifexpression_2 = null;
        boolean _operator_equals_2 = ObjectExtensions.operator_equals(this.exprtype, EXPSTATE.Boolean);
        if (_operator_equals_2) {
          StringConcatenation _builder_21 = new StringConcatenation();
          CharSequence _txt_6 = this.txt(1);
          CharSequence _scope = this.scope(_txt_6);
          _builder_21.append(_scope, "");
          _builder_21.append(".toBool");
          _xifexpression_2 = _builder_21;
        } else {
          CharSequence _xifexpression_3 = null;
          boolean _operator_equals_3 = ObjectExtensions.operator_equals(this.exprtype, EXPSTATE.Integer);
          if (_operator_equals_3) {
            StringConcatenation _builder_22 = new StringConcatenation();
            CharSequence _txt_7 = this.txt(1);
            CharSequence _scope_1 = this.scope(_txt_7);
            _builder_22.append(_scope_1, "");
            _builder_22.append(".toInt");
            _xifexpression_3 = _builder_22;
          } else {
            StringConcatenation _builder_23 = new StringConcatenation();
            CharSequence _txt_8 = this.txt(1);
            CharSequence _scope_2 = this.scope(_txt_8);
            _builder_23.append(_scope_2, "");
            _xifexpression_3 = _builder_23;
          }
          _xifexpression_2 = _xifexpression_3;
        }
        _switchResult = _xifexpression_2;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.ATTRIBUTE2)) {
        matched=true;
        CharSequence _xifexpression_4 = null;
        boolean _operator_equals_4 = ObjectExtensions.operator_equals(this.exprtype, EXPSTATE.Boolean);
        if (_operator_equals_4) {
          StringConcatenation _builder_24 = new StringConcatenation();
          CharSequence _txt_9 = this.txt(1);
          CharSequence _txt_10 = this.txt(2);
          CharSequence _scope_3 = this.scope(_txt_9, _txt_10);
          _builder_24.append(_scope_3, "");
          _builder_24.append(".toBool");
          _xifexpression_4 = _builder_24;
        } else {
          CharSequence _xifexpression_5 = null;
          boolean _operator_equals_5 = ObjectExtensions.operator_equals(this.exprtype, EXPSTATE.Integer);
          if (_operator_equals_5) {
            StringConcatenation _builder_25 = new StringConcatenation();
            CharSequence _txt_11 = this.txt(1);
            CharSequence _txt_12 = this.txt(2);
            CharSequence _scope_4 = this.scope(_txt_11, _txt_12);
            _builder_25.append(_scope_4, "");
            _builder_25.append(".toInt");
            _xifexpression_5 = _builder_25;
          } else {
            StringConcatenation _builder_26 = new StringConcatenation();
            CharSequence _txt_13 = this.txt(1);
            CharSequence _txt_14 = this.txt(2);
            CharSequence _scope_5 = this.scope(_txt_13, _txt_14);
            _builder_26.append(_scope_5, "");
            _xifexpression_5 = _builder_26;
          }
          _xifexpression_4 = _xifexpression_5;
        }
        _switchResult = _xifexpression_4;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.RESERVED)) {
        matched=true;
        StringConcatenation _builder_27 = new StringConcatenation();
        _builder_27.append("reserved(\"");
        CharSequence _txt_15 = this.txt(1);
        _builder_27.append(_txt_15, "");
        _builder_27.append("\")");
        _switchResult = _builder_27;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.TYPED)) {
        matched=true;
        StringConcatenation _builder_28 = new StringConcatenation();
        _builder_28.append("typed(");
        CharSequence _txt_16 = this.txt(1);
        _builder_28.append(_txt_16, "");
        _builder_28.append(")");
        _switchResult = _builder_28;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.LITERAL)) {
        matched=true;
        StringConcatenation _builder_29 = new StringConcatenation();
        CharSequence _txt_17 = this.txt();
        _builder_29.append(_txt_17, "");
        _switchResult = _builder_29;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.INT)) {
        matched=true;
        StringConcatenation _builder_30 = new StringConcatenation();
        CharSequence _txt_18 = this.txt();
        _builder_30.append(_txt_18, "");
        _switchResult = _builder_30;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.LPARAN)) {
        matched=true;
        StringConcatenation _builder_31 = new StringConcatenation();
        _builder_31.append("(");
        CharSequence _expr_34 = this.expr(EXPSTATE.String, 1);
        _builder_31.append(_expr_34, "");
        _builder_31.append(")");
        _switchResult = _builder_31;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.ID)) {
        matched=true;
        StringConcatenation _builder_32 = new StringConcatenation();
        _builder_32.append("<ID?>");
        CharSequence _txt_19 = this.txt();
        _builder_32.append(_txt_19, "");
        _switchResult = _builder_32;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.MACRO)) {
        matched=true;
        StringConcatenation _builder_33 = new StringConcatenation();
        _builder_33.append("macro(\"");
        CharSequence _txt_20 = this.txt(1);
        _builder_33.append(_txt_20, "");
        _builder_33.append("\")");
        _switchResult = _builder_33;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.ARRAY)) {
        matched=true;
        StringConcatenation _builder_34 = new StringConcatenation();
        _builder_34.append(",");
        CharSequence _expr_35 = this.expr(EXPSTATE.String, 1);
        _builder_34.append(_expr_35, "");
        _switchResult = _builder_34;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.FUNCTION)) {
        matched=true;
        StringConcatenation _builder_35 = new StringConcatenation();
        _builder_35.append("_");
        CharSequence _txt_21 = this.txt(1);
        _builder_35.append(_txt_21, "");
        _builder_35.append("(");
        CharSequence _expr_36 = this.expr(EXPSTATE.String, 2);
        _builder_35.append(_expr_36, "");
        _builder_35.append(")");
        _switchResult = _builder_35;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.EXPR)) {
        matched=true;
        StringConcatenation _builder_36 = new StringConcatenation();
        _builder_36.append("<EXPR>");
        CharSequence _expr_37 = this.expr();
        _builder_36.append(_expr_37, "");
        _builder_36.append("</EXPR>");
        _switchResult = _builder_36;
      }
    }
    if (!matched) {
      StringConcatenation _builder_37 = new StringConcatenation();
      _builder_37.append("<EXPR?>");
      CharSequence _what = this.what();
      _builder_37.append(_what, "");
      _builder_37.append("</EXPR?>");
      _switchResult = _builder_37;
    }
    return _switchResult;
  }
  
  public CharSequence _file() {
    CharSequence _switchResult = null;
    int _type = this.node.token.getType();
    final int __valOfSwitchOver = _type;
    boolean matched = false;
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.MACRO)) {
        matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("macro(\"");
        CharSequence _txt = this.txt(1);
        _builder.append(_txt, "");
        _builder.append("\")");
        _switchResult = _builder;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.SUB)) {
        matched=true;
        StringConcatenation _builder_1 = new StringConcatenation();
        CharSequence _expr = this.expr(EXPSTATE.String, 1);
        _builder_1.append(_expr, "");
        _switchResult = _builder_1;
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,GParser.LITERAL)) {
        matched=true;
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("\"");
        CharSequence _fileliteral = this.fileliteral();
        _builder_2.append(_fileliteral, "");
        _builder_2.append("\"");
        _switchResult = _builder_2;
      }
    }
    if (!matched) {
      StringConcatenation _builder_3 = new StringConcatenation();
      CharSequence _txt_1 = this.txt();
      _builder_3.append(_txt_1, "");
      _switchResult = _builder_3;
    }
    return _switchResult;
  }
}
