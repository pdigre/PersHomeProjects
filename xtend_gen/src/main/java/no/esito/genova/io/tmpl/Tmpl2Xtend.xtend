package no.esito.genova.io.tmpl

import org.antlr.runtime.tree.CommonTree
import no.esito.genova.io.convert.EXPSTATE

import static no.esito.genova.io.antlr.TmplParser.*

class Tmpl2Xtend extends AbstractTmpl2Xtend { 
	def what(){
		'''
		<«node.token.text»> 
			«walk»
		</«node.token.text»«bp»> 
		'''
	}
	
    override _stat() {
    	switch node.token.type {
    	    case DOLLAR:{
    	    	var text="«"+expr(EXPSTATE::String,1)+"»";
	        	'''«text.toString»'''
    	    }
            case ALFA:{
    	    	var text="«"+txt(1)+"»";
	        	'''«text.toString»'''
    	    }
            case BOOL_START:{
    	    	var text="«"+expr(EXPSTATE::String,1)+"»";
	        	'''«text.toString»'''
    	    }
	        case PROG:
	        	'''
				import GenovaBase
				class «clazzname» extends GenovaBase{ 
					override call(){
						«walk(1)»«close»
					 	«walk(2)»«close»
					 	«"'''«context.toString»'''"»
					 }
				}'''
				
            case BEGIN:{
        		'''begin()'''
            }
            
            case SECTIONS:{
        		'''«walk(1)»'''
            }
            
            case BLOCK:{
        		'''«walk(1)»'''
            }
            
            case SECTION:{
        		'''
        		section(«file(1)»«optionalFile(",",2)»,[|
        			«walk(3)»«close»
        		])
        		'''
            }
            
            case CREATESECTION:{
        		'''
        		createSection(«file(1)»«close»,«file(2)»«close»)
        		'''
            }
            
            case REM:
	        	'''
	        	«txt(1)»
	        	'''
            case COMMENT:
	        	'''
	        	// «txt(1)»
	        	'''
	        case OUT:
	        	'''
	        	«out»'''  
            case IF_:
	        	'''
	        	if(«expr(EXPSTATE::Boolean,1)»){
	        		«walk(2)»«close»
	        	}
	        	'''
            default:
	        	'''<STAT?«node.token.type»>«what»'''
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
            case ALFA:
        		'''alfa("«txt(1)»")'''
            case DOLLAR:
        		'''dollar("«txt(1)»")'''
            case BOOL_START:
        		'''bool("«txt(1)»")'''
            case LITERAL:
        		'''«txt»'''
            case INT:
        		'''«txt»'''
            case LPARAN:
        		'''(«expr(EXPSTATE::String,1)»)'''
            case ID:
        		'''«txt»'''
            case EXPR:
        		'''<EXPR>«expr»</EXPR>'''
    		default:
	        	'''<EXPR?>«what»</EXPR?>'''
            }
    }
    
    override _file() {
        switch node.token.type {
            case LITERAL:
        		'''"«fileliteral»"'''
            case PATH:
        		'''"«file(1)»"'''
            case ALFA:
        		'''«txt(1)»'''
            case ID:
        		'''"«txt»"'''
    		default:
	        	'''??«txt»??'''
            }
    }
    

}