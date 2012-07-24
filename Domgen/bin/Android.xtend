

import AndroidBase
import no.esito.genova.model.core.QObject
import no.esito.genova.model.dialogmodel.QAbstractBlock
import no.esito.genova.model.dialogmodel.QButtonControl
import no.esito.genova.model.dialogmodel.QDialogModelRoot
import no.esito.genova.model.dialogmodel.QVarField
import no.esito.genova.model.dialogmodel.QVarField$VarFieldType
import no.esito.genova.model.dialogmodel.QWindowBlock

class Android extends AndroidBase{ 
	override call(){    
			saveFile(dialogModelRef.name+".droid",visit(dialogModelRoot))
			'''Generated dialog : «dialogModelRef.name»'''
 	}
 	
 	override visit(QObject go){ 
 		switch(go){  
 			QDialogModelRoot case true:
 			walk(go)
 			
 			QWindowBlock case true:
 			'''
 			<WINDOW name="«go.label»">
 				«walk(go)»
 			</WINDOW>
 			'''
 			
 			QAbstractBlock case true:
 			'''
 			<BLOCK name="«go.label»">
 				«walk(go)»
 			</BLOCK>
 			'''
 			
 			QButtonControl case true:
 			'''
 			<Button/>
 			'''
 			
 			QVarField case go.varFieldType==VarFieldType::TEXT:
 			'''
 			<TEXT name="«go.label»"/>
 			'''
 			
 			QVarField case go.varFieldType==VarFieldType::COMBOBOX:
 			'''
 			<COMBO name="«go.label»"/>
 			'''
 			
 			QVarField case go.varFieldType==VarFieldType::CHECKBUTTON:
 			'''
 			<CHECKBOX name="«go.label»"/>
 			'''
 			
 			QVarField case go.varFieldType==VarFieldType::RADIOGROUP:
 			'''
 			<RADIO name="«go.label»"/> 
 			'''
 			
 			default:
 			''''''
 		}
 	}
}