package no.esito.genova.io.tmpl

import org.antlr.runtime.tree.CommonTree
import no.esito.genova.io.tmpl.EXPSTATE

import static no.esito.genova.io.antlr.TmplParser.*

class Tmpl2Xtend extends no.esito.genova.io.tmpl.AbstractTmpl2Xtend {
	def what(){
		'''
		<«node.token.text»>
			«walk»
		</«node.token.text»«bp»>
		'''
	}
	
    override _stat() {
    	switch node.token.type {
    	    case SUB:{
    	    	var text="«"+expr(EXPSTATE::String,1)+"»";
	        	'''«text.toString»'''
    	    }
            case MACRO:
	        	'''
	        	«"«"»macro("«txt(1)»")«"»"»
	        	'''
            case TYPED:
	        	'''
	        	«"«"»typed("«txt(1)»")«"»"»
	        	'''
	        case PROG:
	        	'''
				import GenovaBase
				
				class «clazzname» extends GenovaBase{ 
					override call(){
					 	«walk»«close»
					 	«"'''«context.toString»'''"»
					 }
				}'''
            case ITERATE:{
        		''''''
            }
            
            case REM:
	        	cmt
	        case OUT:
	        	'''
	        	«out»
	        	'''  
            case IF_:
	        	'''
	        	if(«expr(EXPSTATE::Boolean,1)»){
	        		«walk(2)»«close»
	        	}«walk2(3)»
	        	'''
            case ELSEIF_:
	        	''' 
	        	else if(«expr(EXPSTATE::Boolean,1)»){
	        		«walk(2)»«close»
	        	}
	        	'''
            case ELSE_:
	        	''' 
	        	else {
	        		«walk»«close»
	        	}
	        	'''
            case IFCONTEXT:
	        	'''
	        	if(isContext("«txt(1)»")){
	        		«walk(2)»«close»
	        	}«walk2(3)»
	        	'''
            case CONTEXT:
	        	'''
	        	setContext("«txt(1)»")
	        	'''
            case ENDCONTEXT:
	        	'''
	        	endContext
	        	'''
            case SET:
	        	'''
	        	«expr(EXPSTATE::String,1)» = «expr(EXPSTATE::String,2)»
	        	'''
            case TYPES_MODE:
	        	walk
            case TYPE:
	        	'''
	        	typedef("«typedef1»",[c|{«walk»«close»}])
	        	'''
            case TYPEDEF:
	        	'''
	        	typedef("«typedef2»",[c|{«walk(1)»«close»}])
	        	'''
            case LOOP:
	        	'''
	        	loop(«expr(EXPSTATE::String,1)»,[c|«walk(2)»«close»])
	        	'''
            case CONTINUE:
	        	'''
	        	continueLoop
	        	'''
            case BREAK:
	        	'''
	        	breakLoop
	        	'''
            case LINE:
	        	'''
	        	line
	        	'''
            case ENDLINE:
	        	'''
	        	endline
	        	'''
            case INDENT:
	        	'''
	        	indentBegin
	        	'''
            case INDENT2:
	        	'''
	        	indent(«txt(1)»)
	        	'''
            case ENDINDENT:
	        	'''
	        	indentEnd
	        	'''
            case STR:
	        	'''
	        	str("«txt(1)»")
	        	'''
            case ENDSTR:
	        	'''
	        	strEnd
	        	'''
            case FILE:
	        	'''
	        	file(«file(1)»)
	        	'''
            case NEWFILE:
	        	'''
	        	newfile(«file(1)»)
	        	'''
            case IGNOREFILE:
	        	'''
	        	ignorefile(«file(1)»)
	        	'''
            case POPFILE:
	        	'''
	        	popfile
	        	'''
            case PUSHFILE:
	        	'''
	        	pushfile(«file(1)»)
	        	'''
            case COPYFILE:
	        	'''
	        	copyfile(«file(1)»,«file(2)»)
	        	'''
            case ENDFILE:
	        	'''
	        	endfile
	        	'''
            case INCLUDE:
	        	'''
	        	include(«file(1)»)
	        	'''
            case ERROR:
	        	'''
	        	error(«expr(EXPSTATE::String,1)»)
	        	'''
            case INFO:
	        	'''
	        	info(«expr(EXPSTATE::String,1)»)
	        	'''
            case WARNING:
	        	'''
	        	warning(«expr(EXPSTATE::String,1)»)
	        	'''
            case DEBUG:
	        	'''
	        	debug(«expr(EXPSTATE::String,1)»)
	        	'''
            default:
	        	'''<STAT?>«what»'''
            }
    }
    
    override _expr() {
        switch node.token.type {
            case PLUS:
        		'''«expr(EXPSTATE::Integer,1)» + «expr(EXPSTATE::Integer,2)»'''
            case MINUS:
        		'''«expr(EXPSTATE::Integer,1)» - «expr(EXPSTATE::Integer,2)»'''
            case MULTIPLY:
        		'''«expr(EXPSTATE::Integer,1)» * «expr(EXPSTATE::Integer,2)»'''
            case SLASH:
        		'''«expr(EXPSTATE::Integer,1)» / «expr(EXPSTATE::Integer,2)»'''
            case HAT:
 		       	'''exponent(«expr(EXPSTATE::Integer,1)»,«expr(EXPSTATE::Integer,2)»)'''
            case TILDE:
		        '''tilde(«expr(EXPSTATE::String,1)»,«expr(EXPSTATE::String,2)»)'''
            case APPEND:
        		'''«expr(EXPSTATE::String,1)» + «expr(EXPSTATE::String,2)»'''
            case OR:
        		'''«expr(EXPSTATE::Boolean,1)» || «expr(EXPSTATE::Boolean,2)»'''
            case AND:
        		'''«expr(EXPSTATE::Boolean,1)» && «expr(EXPSTATE::Boolean,2)»'''
            case EQUAL:
        		'''«expr(EXPSTATE::String,1)» == «expr(EXPSTATE::String,2)»'''
            case NE:
        		'''«expr(EXPSTATE::String,1)» != «expr(EXPSTATE::String,2)»'''
            case GT:
        		'''«expr(EXPSTATE::Integer,1)» > «expr(EXPSTATE::Integer,2)»'''
            case GE:
        		'''«expr(EXPSTATE::Integer,1)» >= «expr(EXPSTATE::Integer,2)»'''
            case LT:
        		'''«expr(EXPSTATE::Integer,1)» < «expr(EXPSTATE::Integer,2)»'''
            case LE:
        		'''«expr(EXPSTATE::Integer,1)» <= «expr(EXPSTATE::Integer,2)»'''
            case NOT:
        		'''!(«expr(EXPSTATE::Boolean,1)»)'''
            case QUESTION:
        		'''if («expr(EXPSTATE::Boolean,1)») «expr(EXPSTATE::String,2)» else «expr(EXPSTATE::String,3)»'''
            case VARIABLE:
        		''''''
            case VARIABLE2:
        		''''''
            case ATTRIBUTE:
        		''''''
            case ATTRIBUTE2:
        		''''''
            case RESERVED:
        		'''reserved("«txt(1)»")'''
            case TYPED:
        		'''typed(«txt(1)»)'''
            case LITERAL:
        		'''«txt»'''
            case INT:
        		'''«txt»'''
            case LPARAN:
        		'''(«expr(EXPSTATE::String,1)»)'''
            case ID:
        		'''<ID?>«txt»'''
            case MACRO:
	        	'''macro("«txt(1)»")'''
            case ARRAY:
        		''',«expr(EXPSTATE::String,1)»'''
            case FUNCTION:
        		'''_«txt(1)»(«expr(EXPSTATE::String,2)»)'''
            case EXPR:
        		'''<EXPR>«expr»</EXPR>'''
    		default:
	        	'''<EXPR?>«what»</EXPR?>'''
            }
    }
    
    override _file() {
        switch node.token.type {
            case MACRO:
	        	'''macro("«txt(1)»")'''
            case SUB:
	        	'''«expr(EXPSTATE::String,1)»'''
            case LITERAL:
        		'''"«fileliteral»"'''
    		default:
	        	'''«txt»'''
            }
    }
    

}