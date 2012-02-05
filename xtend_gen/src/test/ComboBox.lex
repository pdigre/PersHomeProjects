OUT               
REM @rem
REM  ------------------------------------------------------  
REM @rem
REM   Copyright (c) M4_CopyrightYear, M4_CopyrightComp. All rights reserved.  
REM @rem
REM   Version: M4_Version. M4_BuildDate.  
REM @rem
REM  ------------------------------------------------------  
OUT       
SECTION @section
WS  
ID ConstRole
ALFA @@
ID NodeName
ALFA @@
NEWLINE   
COMMENT @//
REM   
OUT         /** The 
ALFA @@
ID Name
ALFA @@
OUT  data field */                  String 
DOLLAR $$
ID hasParameter
WS  
ID DialogConstUppercase
QUESTION ?
ALFA @@
ID NameUpper
ALFA @@
COLON :
ALFA @@
ID Name
ALFA @@
DOLLAR $$
OUT  = "
ALFA @@
ID LogicalName
ALFA @@
OUT ";      
IF_ @if
WS  
BOOL_START @(
ID hasParameter
WS  
ID UseInnerComboboxClass
BOOL_END )@
NEWLINE   
OUT   
CREATESECTION @createSection
WS  
ALFA @@
ID NodeName
ALFA @@
ID _
ALFA @@
ID Name
ALFA @@
ID ComboBoxCollectionClassEnd
WS  
ID MethodDeclaration
NEWLINE   
OUT   
CREATESECTION @createSection
WS  
ALFA @@
ID NodeName
ALFA @@
ID _
ALFA @@
ID Name
ALFA @@
ID ComboBoxCollectionClass
WS  
ALFA @@
ID NodeName
ALFA @@
ID _
ALFA @@
ID Name
ALFA @@
ID ComboBoxCollectionClassEnd
NEWLINE   
OUT     
CREATESECTION @createSection
WS  
ALFA @@
ID NodeName
ALFA @@
ID _
ALFA @@
ID Name
ALFA @@
ID ComboBoxOldEnd
WS  
ALFA @@
ID NodeName
ALFA @@
ID _
ALFA @@
ID Name
ALFA @@
ID ComboBoxCollectionClassEnd
NEWLINE   
OUT   
CREATESECTION @createSection
WS  
ALFA @@
ID NodeName
ALFA @@
ID _
ALFA @@
ID Name
ALFA @@
ID ComboBoxOld
WS  
ALFA @@
ID NodeName
ALFA @@
ID _
ALFA @@
ID Name
ALFA @@
ID ComboBoxOldEnd
NEWLINE   
OUT     
CREATESECTION @createSection
WS  
ALFA @@
ID NodeName
ALFA @@
ID _
ALFA @@
ID Name
ALFA @@
ID Methods
WS   
ALFA @@
ID NodeName
ALFA @@
ID _
ALFA @@
ID Name
ALFA @@
ID ComboBoxCollectionClassEnd
NEWLINE   
ENDIF @endif  
NEWLINE   
SECTION @section
WS  
ID Declaration
NEWLINE   
OUT     
COMMENT @//
REM   
OUT     /* Her kommer generert kode for ComboBox:Declaration*/      
COMMENT @//
REM   
OUT       GenovaComboBox 
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT  = new GenovaComboBox();      Object objectVersionOf
ALFA @@
ID NodeName
ALFA @@
ALFA @@
ID Name
ALFA @@
OUT  = 
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT ;      
SECTION @section
WS  
ID SetupInit
ALFA @@
ID ParentName
ALFA @@
ID Start
NEWLINE   
OUT         init
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT ();    
SECTION @section
WS  
ID SetupInit
NEWLINE   
OUT       
BEGIN @begin
NEWLINE   
OUT     private void init
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT () {          
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT                   .setRenderer(new no.genova.client.component.ComboBoxRenderer( 
DOLLAR $$
ID GenovaDataType
DOLLAR $$
OUT , // data type                                  
BOOL_START @(
ID isUpperCase
QUESTION ?
INT 1
COLON :
BOOL_START @(
ID isLowerCase
QUESTION ?
MINUS -
INT 1
COLON :
INT 0
BOOL_END )@
BOOL_END )@
OUT , // case                                  controller.getApplication().getEnums(
BOOL_START @(
ID GenovaDataType
EQUAL ==
INT 10
QUESTION ?
ALFA @@
ID EnumerationName
ALFA @@
DOT .
ID class
COLON :
ID null
BOOL_END )@
OUT ,                                  FormatHelper.getDisplayrule(                 
DOLLAR $$
ID GenovaDataType
DOLLAR $$
OUT , // data type                                          "
ALFA @@
ID DisplayRule
ALFA @@
OUT ", // display rule                                          
ALFA @@
ID LengthInput
ALFA @@
OUT , // length input                                          
ALFA @@
ID LengthStored
ALFA @@
OUT , // length stored                                          
ALFA @@
ID Decimals
ALFA @@
OUT ), // decimals                                  
ALFA @@
ID LengthInput
ALFA @@
OUT , // length input                                  
ALFA @@
ID blankWhenZero
QUESTION ?
ID true
COLON :
ID false
ALFA @@
OUT  // blank when zero                          )                    , 
BOOL_START @(
ID OutputJustification
EQUAL ==
ID Left
QUESTION ?
ID JTextField
DOT .
ID LEFT
COLON :
BOOL_START @(
ID OutputJustification
EQUAL ==
ID Right
QUESTION ?
ID JTextField
DOT .
ID RIGHT
COLON :
ID JTextField
DOT .
ID CENTER
BOOL_END )@
BOOL_END )@
OUT ) {                      
COMMENT @//
REM   
OUT                     protected Object getDisplayValue(Object domainObject) {  
IF_ @if
WS  
BOOL_START @(
ID GenovaDataType
EQUAL ==
INT 10
BOOL_END )@
NEWLINE   
OUT                         return domainObject;  
ENDIF @endif  
IF_ @if
WS  
BOOL_START @(
NOT !
ID GenovaDataType
EQUAL ==
INT 10
BOOL_END )@
NEWLINE   
OUT                         if (domainObject instanceof 
ALFA @@
ID ClassName
ALFA @@
OUT ) {                              return TypeTool.toObject(((
ALFA @@
ID ClassName
ALFA @@
OUT ) domainObject)                                      .
DOLLAR $$
ID hasParameter
WS  
ID UseAccessorMethods
QUESTION ?
ALFA @@
ID GetName
ALFA @@
COLON :
ALFA @@
ID Name
ALFA @@
DOLLAR $$
OUT );                          } else {                              return domainO
ENDIF @endif  
WS                     
RBRACK }
NEWLINE   
OUT                 });          
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .setName("
ALFA @@
ID LogicalName
ALFA @@
OUT ");          controller.tabListFromNodeName
ALFA @@
ID ParentName
ALFA @@
OUT .put("
ALFA @@
ID LogicalName
ALFA @@
OUT ", 
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT );          controller.tabListFromComponent
ALFA @@
ID ParentName
ALFA @@
OUT .put(
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT , "
ALFA @@
ID LogicalName
ALFA @@
OUT ");                   
COMMENT @//
REM   
IF_ @if
WS  
BOOL_START @(
NOT !
ID hasListHiddenEditFields
BOOL_END )@
NEWLINE   
OUT         
ALFA @@
ID ParentName
ALFA @@
OUT .add(
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT );          
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .setLocation(
ALFA @@
ID XPos
ALFA @@
OUT +
ALFA @@
ID ParentLeftFrameWidth
ALFA @@
OUT ,
ALFA @@
ID YPos
ALFA @@
OUT +
ALFA @@
ID ParentTopFrameHeight
ALFA @@
OUT );          { // limit scope of width and height declarations.              int 
ALFA @@
ID Width
ALFA @@
OUT ;              int height = 
ALFA @@
ID Height
ALFA @@
OUT ;              
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .setSize(width, height);              if (width == 0 && height == 0) {          
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .setFocusable(false);              }          } // end limit scope  
ENDIF @endif  
WS         
BOOL_START @(
ID NumberOfLines
EQUAL ==
INT 0
QUESTION ?
COLON :
ALFA @@
ID NodeName
ALFA @@
ID _
ALFA @@
ID Name
ALFA @@
DOT .
ID setMaximumRowCount
LPARAN (
ALFA @@
ID NumberOfLines
ALFA @@
RPARAN )
SEMICOLON ;
BOOL_END )@
NEWLINE   
OUT           
COMMENT @//
REM   
OUT         
IF_ @if
WS  
BOOL_START @(
ID isSearchable
BOOL_END )@
NEWLINE   
OUT         // Combo is searchable          { // limit scope, set up editor, needed 
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .getEditor().getEditorComponent();              gtf.setDocument(                
DOLLAR $$
ID GenovaDataType
DOLLAR $$
OUT , // data type                                  
BOOL_START @(
ID isUpperCase
QUESTION ?
INT 1
COLON :
BOOL_START @(
ID isLowerCase
QUESTION ?
MINUS -
INT 1
COLON :
INT 0
BOOL_END )@
BOOL_END )@
OUT , // case                                  controller.getApplication().getEnums(
BOOL_START @(
ID GenovaDataType
EQUAL ==
INT 10
QUESTION ?
ALFA @@
ID EnumerationName
ALFA @@
DOT .
ID class
COLON :
ID null
BOOL_END )@
OUT ,                                  FormatHelper.getDisplayrule(                 
DOLLAR $$
ID GenovaDataType
DOLLAR $$
OUT , // data type                                          "
ALFA @@
ID DisplayRule
ALFA @@
OUT ", // display rule                                          
ALFA @@
ID LengthInput
ALFA @@
OUT , // length input                                          
ALFA @@
ID LengthStored
ALFA @@
OUT , // length stored                                          
ALFA @@
ID Decimals
ALFA @@
OUT ), // decimals                                  
ALFA @@
ID LengthInput
ALFA @@
OUT , // length input                                  
ALFA @@
ID blankWhenZero
QUESTION ?
ID true
COLON :
ID false
ALFA @@
OUT  // blank when zero                          )  );          }          
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .setSearchable(true);  
ENDIF @endif  
NEWLINE   
OUT               
IF_ @if
WS  
BOOL_START @(
ID isEditable
BOOL_END )@
NEWLINE   
OUT         // Combo is editable  
IF_ @if
WS  
BOOL_START @(
NOT !
ID isSearchable
BOOL_END )@
NEWLINE   
OUT         { // set up editor, limit scope              GenovaTextField gtf = (Geno
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .getEditor().getEditorComponent();              gtf.setDocument(                
DOLLAR $$
ID GenovaDataType
DOLLAR $$
OUT , // data type                                  
BOOL_START @(
ID isUpperCase
QUESTION ?
INT 1
COLON :
BOOL_START @(
ID isLowerCase
QUESTION ?
MINUS -
INT 1
COLON :
INT 0
BOOL_END )@
BOOL_END )@
OUT , // case                                  controller.getApplication().getEnums(
BOOL_START @(
ID GenovaDataType
EQUAL ==
INT 10
QUESTION ?
ALFA @@
ID EnumerationName
ALFA @@
DOT .
ID class
COLON :
ID null
BOOL_END )@
OUT ,                                  FormatHelper.getDisplayrule(                 
DOLLAR $$
ID GenovaDataType
DOLLAR $$
OUT , // data type                                          "
ALFA @@
ID DisplayRule
ALFA @@
OUT ", // display rule                                          
ALFA @@
ID LengthInput
ALFA @@
OUT , // length input                                          
ALFA @@
ID LengthStored
ALFA @@
OUT , // length stored                                          
ALFA @@
ID Decimals
ALFA @@
OUT ), // decimals                                  
ALFA @@
ID LengthInput
ALFA @@
OUT , // length input                                  
ALFA @@
ID blankWhenZero
QUESTION ?
ID true
COLON :
ID false
ALFA @@
OUT  // blank when zero                          )  );          }  
ENDIF @endif  
WS         
ALFA @@
ID NodeName
ALFA @@
ID _
ALFA @@
ID Name
ALFA @@
DOT .
ID setEditable
LPARAN (
ID true
RPARAN )
SEMICOLON ;
NEWLINE   
OUT           
ENDIF @endif  
WS         
ALFA @@
ID NodeName
ALFA @@
ID _
ALFA @@
ID Name
ALFA @@
DOT .
ID setSelectAllOnFocus
LPARAN (
BOOL_START @(
ID selectAllOnFocus
QUESTION ?
ID true
COLON :
ID false
BOOL_END )@
RPARAN )
SEMICOLON ;
NEWLINE   
OUT         
DOLLAR $$
ID isSorted
QUESTION ?
ALFA @@
ID NodeName
ALFA @@
ID _
ALFA @@
ID Name
ALFA @@
DOT .
ID setSorted
LPARAN (
ID true
RPARAN )
SEMICOLON ;
COLON :
DOLLAR $$
OUT                    
BOOL_START @(
ID hasBackgroundColor
QUESTION ?
ID RepositoryProxy
DOT .
ID setBackgroundColor
LPARAN (
ALFA @@
ID NodeName
ALFA @@
ID _
ALFA @@
ID Name
ALFA @@
COMMA ,
LITERAL "@@StyleBackgroundColor@@"
RPARAN )
SEMICOLON ;
COLON :
BOOL_END )@
OUT           
BOOL_START @(
ID hasForegroundColor
QUESTION ?
ID RepositoryProxy
DOT .
ID setForegroundColor
LPARAN (
ALFA @@
ID NodeName
ALFA @@
ID _
ALFA @@
ID Name
ALFA @@
COMMA ,
LITERAL "@@StyleForegroundColor@@"
RPARAN )
SEMICOLON ;
COLON :
BOOL_END )@
OUT                   
BOOL_START @(
ID hasFont
QUESTION ?
ID RepositoryProxy
DOT .
ID setFont
LPARAN (
ALFA @@
ID NodeName
ALFA @@
ID _
ALFA @@
ID Name
ALFA @@
COMMA ,
LITERAL "@@FontName@@"
RPARAN )
SEMICOLON ;
COLON :
BOOL_END )@
OUT              if (
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .isEditable()) {              JComponent editor = (JComponent) 
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .getEditor()                      .getEditorComponent();              
BOOL_START @(
ID hasBackgroundColor
QUESTION ?
ID RepositoryProxy
DOT .
ID setBackgroundColor
LPARAN (
ID editor
COMMA ,
LITERAL "@@StyleBackgroundColor@@"
RPARAN )
SEMICOLON ;
COLON :
BOOL_END )@
OUT               
BOOL_START @(
ID hasForegroundColor
QUESTION ?
ID RepositoryProxy
DOT .
ID setForegroundColor
LPARAN (
ID editor
COMMA ,
LITERAL "@@StyleForegroundColor@@"
RPARAN )
SEMICOLON ;
COLON :
BOOL_END )@
OUT               
BOOL_START @(
ID hasFont
QUESTION ?
ID RepositoryProxy
DOT .
ID setFont
LPARAN (
ID editor
COMMA ,
LITERAL "@@FontName@@"
RPARAN )
SEMICOLON ;
COLON :
BOOL_END )@
OUT           }            
COMMENT @//
REM   
OUT         
COMMENT @//
REM   
OUT           
IF_ @if
WS  
BOOL_START @(
NOT !
ID isVisible
BOOL_END )@
NEWLINE   
OUT         
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .setVisible(false);   
ENDIF @endif  
IF_ @if
BOOL_START @(
NOT !
ID isEnabled
BOOL_END )@
NEWLINE   
OUT         
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .setEnabled(false);           disabledComponents.add(
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT );  
ENDIF @endif  
WS         
BOOL_START @(
ID hasTooltip
QUESTION ?
ALFA @@
ID NodeName
ALFA @@
ID _
ALFA @@
ID Name
ALFA @@
DOT .
ID setToolTipText
LPARAN (
LITERAL "@@Tooltip@@"
RPARAN )
SEMICOLON ;
COLON :
BOOL_END )@
NEWLINE   
OUT                       
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .setInputJustification(
BOOL_START @(
ID InputJustification
EQUAL ==
ID Left
QUESTION ?
ID JTextField
DOT .
ID LEFT
COLON :
BOOL_START @(
ID InputJustification
EQUAL ==
ID Right
QUESTION ?
ID JTextField
DOT .
ID RIGHT
COLON :
ID JTextField
DOT .
ID CENTER
BOOL_END )@
BOOL_END )@
OUT );          
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .setOutputJustification(
BOOL_START @(
ID OutputJustification
EQUAL ==
ID Left
QUESTION ?
ID JTextField
DOT .
ID LEFT
COLON :
BOOL_START @(
ID OutputJustification
EQUAL ==
ID Right
QUESTION ?
ID JTextField
DOT .
ID RIGHT
COLON :
ID JTextField
DOT .
ID CENTER
BOOL_END )@
BOOL_END )@
OUT );          
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .setHorizontalAlignment(
BOOL_START @(
ID OutputJustification
EQUAL ==
ID Left
QUESTION ?
ID JTextField
DOT .
ID LEFT
COLON :
BOOL_START @(
ID OutputJustification
EQUAL ==
ID Right
QUESTION ?
ID JTextField
DOT .
ID RIGHT
COLON :
ID JTextField
DOT .
ID CENTER
BOOL_END )@
BOOL_END )@
OUT );          
SECTION @section
WS  
ID SetupInit
NEWLINE   
ID end
OUT     
IF_ @if
WS  
BOOL_START @(
ID hasEvent
WS  
ID Selected
BOOL_END )@
NEWLINE   
OUT         
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .addGenovaSelectionListener(new GenovaSelectionListener() {              public 
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT , e);              }          });  
ENDIF @endif  
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID hasEvent
WS  
ID Dropped
WS  
ID Down
BOOL_END )@
NEWLINE   
OUT         
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .addPopupMenuListener(new PopupMenuListener() {              public void popupMe
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT , e);              }  
COMMENT @//
REM   
OUT             public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {        
COMMENT @//
REM   
OUT             public void popupMenuCanceled(PopupMenuEvent e) {                  /
ENDIF @endif  
NEWLINE   
OUT   
IF_ @if
WS  
BOOL_START @(
ID hasKeyEvent
BOOL_END )@
NEWLINE   
OUT         
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .getEditor().getEditorComponent().addKeyListener(keyProc);  
ENDIF @endif  
NEWLINE   
OUT   
IF_ @if
WS  
BOOL_START @(
ID hasPopupMenu
BOOL_END )@
NEWLINE   
OUT         
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .addMouseListener(mouseProc);  
ENDIF @endif  
WS     
RBRACK }
NEWLINE   
OUT   
SECTION @section
WS  
ID Expression
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID hasExpression
BOOL_END )@
NEWLINE   
COMMENT @//
REM   
OUT         // Generated expressions-code          ComponentLink.link(
ALFA @@
ID ExpressionAsProgramName
ALFA @@
OUT , 
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT                   , "
ALFA @@
ID Name
ALFA @@
OUT ", controller, "
ALFA @@
ID NodeName
ALFA @@
OUT ");  
ENDIF @endif  
IF_ @if
WS  
BOOL_START @(
NOT !
ID hasExpression
BOOL_END )@
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID hasNextEquivalentName
BOOL_END )@
NEWLINE   
OUT         // Generated expressions-code for linked data items.          ComponentL
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT , 
ALFA @@
ID NextEquivalentName
ALFA @@
OUT                   , "
ALFA @@
ID Name
ALFA @@
OUT ", controller, "
ALFA @@
ID NodeName
ALFA @@
OUT ");    
ENDIF @endif  
ENDIF @endif  
NEWLINE   
OUT     
SECTION @section
WS  
ID NodeInfo
ALFA @@
ID NodeName
ALFA @@
ID GetChangedKeyFields
NEWLINE   
OUT         if (isPartOfKey("
ALFA @@
ID Name
ALFA @@
OUT ")) {              component = controller.view.fromNameToComponent("
ALFA @@
ID LogicalName
ALFA @@
OUT ");              if (component instanceof GenovaValueState) {                  i
ALFA @@
ID Name
ALFA @@
OUT ");                  }              }          }    
SECTION @section
WS  
ID NodeInfo
ALFA @@
ID NodeName
ALFA @@
ID GetChangedFields
NEWLINE   
OUT         component = controller.view.fromNameToComponent("
ALFA @@
ID LogicalName
ALFA @@
OUT ");          if (component instanceof GenovaValueState) {              if (((Gen
ALFA @@
ID Name
ALFA @@
OUT ");              }          }  
SECTION @section
WS  
ID NodeInfo
ALFA @@
ID NodeName
ALFA @@
ID ResetFields
NEWLINE   
OUT         component = controller.view.fromNameToComponent("
ALFA @@
ID LogicalName
ALFA @@
OUT ");          if (component instanceof GenovaValueState) {              ((GenovaV
SECTION @section
WS  
ID PopupTrigger
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID hasPopupMenu
BOOL_END )@
NEWLINE   
OUT         if (e.getSource() == 
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT ) {              
ALFA @@
ID PopupMenuName
ALFA @@
OUT _popup.show(e.getComponent(),e.getX(),e.getY());          }  
ENDIF @endif  
NEWLINE   
OUT     
SECTION @section
WS  
ID controllerdecl
NEWLINE   
OUT     List 
ALFA @@
ID NodeName
ALFA @@
ALFA @@
ID Name
ALFA @@
OUT links;    
SECTION @section
WS  
ID linkFields
NEWLINE   
OUT     if("
ALFA @@
ID LogicalName
ALFA @@
OUT ".equals(obj1)) {          if(
ALFA @@
ID NodeName
ALFA @@
ALFA @@
ID Name
ALFA @@
OUT links == null) {              
ALFA @@
ID NodeName
ALFA @@
ALFA @@
ID Name
ALFA @@
OUT links = new LinkedList();          }                    if(!
ALFA @@
ID NodeName
ALFA @@
ALFA @@
ID Name
ALFA @@
OUT links.contains(link)) {              
ALFA @@
ID NodeName
ALFA @@
ALFA @@
ID Name
ALFA @@
OUT links.add(link);          }            link.setComponent1(obj1, view.
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT , obj1list);      }      if("
ALFA @@
ID LogicalName
ALFA @@
OUT ".equals(obj2)) {          if(
ALFA @@
ID NodeName
ALFA @@
ALFA @@
ID Name
ALFA @@
OUT links == null) {              
ALFA @@
ID NodeName
ALFA @@
ALFA @@
ID Name
ALFA @@
OUT links = new LinkedList();          }          if(!
ALFA @@
ID NodeName
ALFA @@
ALFA @@
ID Name
ALFA @@
OUT links.contains(link)) {              
ALFA @@
ID NodeName
ALFA @@
ALFA @@
ID Name
ALFA @@
OUT links.add(link);          }          link.setComponent2(obj2, view.
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT , obj2list);      }    
SECTION @section
WS  
ID ClearBlockStart
ALFA @@
ID ParentName
ALFA @@
ALFA @@
ID DialogName
ALFA @@
NEWLINE   
OUT         
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .reset();    
SECTION @section
WS  
ID ObtainDataString
ALFA @@
ID NodeName
ALFA @@
WS  
ID rt
NEWLINE   
BEGIN @begin
NEWLINE   
OUT         if(attr.equals("
ALFA @@
ID Name
ALFA @@
OUT ")) {              if(view.
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .isEditable()) {                   Object item = view.
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .getEditor().getItem();                  return view.
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .format(item);              } else {                  return view.
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .getSelectedItemAsString();              }          }    
SECTION @section
WS  
ID ObtainData
ALFA @@
ID NodeName
ALFA @@
WS  
ID rt
NEWLINE   
BEGIN @begin
NEWLINE   
OUT       
COMMENT @//
REM               
OUT         /* Her kommer generert kode for ComboBox:ObtainData*/          objectPro
ALFA @@
ID Name
ALFA @@
OUT ", view.
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .getValue());      
SECTION @section
WS  
ID setUpNameComponentMapping
NEWLINE   
OUT         nameToComponent.put("
ALFA @@
ID LogicalName
ALFA @@
OUT ", 
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT );          componentToName.put(
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT , "
ALFA @@
ID LogicalName
ALFA @@
OUT ");                    
SECTION @section
WS  
ID DisplayData
ALFA @@
ID NodeName
ALFA @@
WS  
ID rt
NEWLINE   
BEGIN @begin
NEWLINE   
OUT         display("
ALFA @@
ID Name
ALFA @@
OUT ", TypeTool.toObject(tmp
ALFA @@
ID NodeName
ALFA @@
OUT .
DOLLAR $$
ID hasParameter
WS  
ID UseAccessorMethods
QUESTION ?
ALFA @@
ID GetName
ALFA @@
COLON :
ALFA @@
ID Name
ALFA @@
DOLLAR $$
OUT ), resetState);      
SECTION @section
WS  
ID setShowZeroFieldDecl
ALFA @@
ID NodeName
ALFA @@
WS  
ID rt
NEWLINE   
OUT     boolean zero
ALFA @@
ID NodeName
ALFA @@
ALFA @@
ID Name
ALFA @@
OUT  = false;      
SECTION @section
WS  
ID DisplayDataField
ALFA @@
ID NodeName
ALFA @@
WS  
ID rt
NEWLINE   
BEGIN @begin
NEWLINE   
OUT             if (attributeName.equals("
ALFA @@
ID Name
ALFA @@
OUT ")) {                  value = TypeTool.toObject(tmp
ALFA @@
ID NodeName
ALFA @@
OUT .
DOLLAR $$
ID hasParameter
WS  
ID UseAccessorMethods
QUESTION ?
ALFA @@
ID GetName
ALFA @@
COLON :
ALFA @@
ID Name
ALFA @@
DOLLAR $$
OUT );              }    
SECTION @section
WS  
ID DisplayDataString
ALFA @@
ID NodeName
ALFA @@
NEWLINE   
OUT             if ("
ALFA @@
ID Name
ALFA @@
OUT ".equals(attributeName)) {                  Object valueObject = null;          
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT                               .parse((String) value);                  } else { 
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .setInitialValue(valueObject);                  }                  view.
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .display(valueObject);              }    
SECTION @section
WS  
ID ClearData
ALFA @@
ID NodeName
ALFA @@
WS  
ID rt
NEWLINE   
BEGIN @begin
NEWLINE   
OUT         view.
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .reset();            
SECTION @section
WS  
ID ClearDataField
ALFA @@
ID NodeName
ALFA @@
WS  
ID rt
NEWLINE   
BEGIN @begin
NEWLINE   
SECTION @section
WS  
ID ClearDataField
ALFA @@
ID NodeName
ALFA @@
WS  
ID rt
NEWLINE   
OUT         if ("
ALFA @@
ID Name
ALFA @@
OUT ".equals(s)) {              view.
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .reset();          }    
SECTION @section
WS  
ID setEnabled
ALFA @@
ID NodeName
ALFA @@
WS  
ID rt
NEWLINE   
BEGIN @begin
NEWLINE   
OUT     view.
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .setEnabled(b);    
SECTION @section
WS  
ID setEnabledField
ALFA @@
ID NodeName
ALFA @@
WS  
ID rt
NEWLINE   
BEGIN @begin
NEWLINE   
OUT         if (s.equals("
ALFA @@
ID Name
ALFA @@
OUT ")) {              view.
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .setEnabled(b);          }    
SECTION @section
WS  
ID setShown
ALFA @@
ID NodeName
ALFA @@
WS  
ID rt
NEWLINE   
BEGIN @begin
NEWLINE   
OUT     view.
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .setVisible(b);    
SECTION @section
WS  
ID setShownField
ALFA @@
ID NodeName
ALFA @@
WS  
ID rt
NEWLINE   
BEGIN @begin
NEWLINE   
OUT         if (s.equals("
ALFA @@
ID Name
ALFA @@
OUT ")) {                  view.
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .setVisible(b);          }    
SECTION @section
WS  
ID setFocusField
ALFA @@
ID NodeName
ALFA @@
WS  
ID rt
NEWLINE   
BEGIN @begin
NEWLINE   
OUT         if (s.equals("
ALFA @@
ID Name
ALFA @@
OUT ")) {              view.
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .requestFocusInWindow();          }    
SECTION @section
WS  
ID isEnabled
ALFA @@
ID NodeName
ALFA @@
WS  
ID rt
NEWLINE   
BEGIN @begin
NEWLINE   
OUT     if (view.
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .isEnabled()) b=true;    
SECTION @section
WS  
ID isEnabledField
ALFA @@
ID NodeName
ALFA @@
WS  
ID rt
NEWLINE   
BEGIN @begin
NEWLINE   
OUT         if (s.equals("
ALFA @@
ID Name
ALFA @@
OUT ")) {                  if (view.
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .isEnabled()) b=true;          }    
SECTION @section
WS  
ID isShown
ALFA @@
ID NodeName
ALFA @@
WS  
ID rt
NEWLINE   
BEGIN @begin
NEWLINE   
OUT     if (view.
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .isEnabled()) b=true;    
SECTION @section
WS  
ID isShownField
ALFA @@
ID NodeName
ALFA @@
WS  
ID rt
NEWLINE   
BEGIN @begin
NEWLINE   
OUT         if (s.equals("
ALFA @@
ID Name
ALFA @@
OUT ")) {                  if (view.
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .hasFocus()) b=true;          }    
SECTION @section
WS  
ID hasFocusField
ALFA @@
ID NodeName
ALFA @@
WS  
ID rt
NEWLINE   
BEGIN @begin
NEWLINE   
OUT     if (view.
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .hasFocus()) b=true;      
SECTION @section
WS  
ID isConsistant
ALFA @@
ID NodeName
ALFA @@
WS  
ID rt
NEWLINE   
OUT     if(!TypeTool.isConsistant(view.
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .getEditor().getItem().toString(), old
ALFA @@
ID NodeName
ALFA @@
OUT .
ALFA @@
ID GetName
ALFA @@
OUT )) {              return false;      }    
SECTION @section
WS  
ID hasOneValue
ALFA @@
ID NodeName
ALFA @@
WS  
ID rt
NEWLINE   
OUT     if(view.
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .isEditable()) {              if(view.
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .getEditor().getItem() != null && view.
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .getEditor().getItem().toString().length() > 0) {                  return true; 
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .getSelectedItemAsString().trim().length() > 0) {                  return true; 
SECTION @section
WS  
ID hasValue
ALFA @@
ID NodeName
ALFA @@
WS  
ID rt
NEWLINE   
OUT     if(view.
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .getEditor().getItem() == null || view.
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .getEditor().getItem().toString().length() == 0) {              return false;   
SECTION @section
WS  
ID hasValueField
ALFA @@
ID NodeName
ALFA @@
WS  
ID rt
NEWLINE   
OUT     if(field.equals("
ALFA @@
ID Name
ALFA @@
OUT ") && (view.
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .getEditor().getItem() == null || view.
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .getEditor().getItem().toString().length() == 0)) {              return false;  
IF_ @if
WS  
BOOL_START @(
ID hasFocusEvent
BOOL_END )@
NEWLINE   
OUT   
IF_ @if
WS  
BOOL_START @(
ID isSearchable
BOOL_END )@
NEWLINE   
OUT         
CREATESECTION @createSection
WS  
ID EndFocusGained
ALFA @@
ID LogicalName
ALFA @@
WS  
ID FocusActions
NEWLINE   
CREATESECTION @createSection
WS  
ID StartFocusGained
ALFA @@
ID LogicalName
ALFA @@
WS  
ID EndFocusGained
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
OUT   
SECTION @section
WS  
ID StartFocusGained
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID hasEvent
WS  
ID Got
WS  
ID Focus
BOOL_END )@
NEWLINE   
OUT         
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .getEditor().getEditorComponent().addFocusListener(new FocusAdapter() {         
ENDIF @endif  
NEWLINE   
SECTION @section
WS  
ID EndFocusGained
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID hasEvent
WS  
ID Got
WS  
ID Focus
BOOL_END )@
NEWLINE   
OUT             }          });  
ENDIF @endif  
NEWLINE   
CREATESECTION @createSection
WS  
ID EndFocusLost
ALFA @@
ID LogicalName
ALFA @@
WS  
ID FocusActions
NEWLINE   
CREATESECTION @createSection
WS  
ID StartFocusLost
ALFA @@
ID LogicalName
ALFA @@
WS  
ID EndFocusLost
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
OUT   
SECTION @section
WS  
ID StartFocusLost
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID hasEvent
WS  
ID Lost
WS  
ID Focus
BOOL_END )@
NEWLINE   
OUT         
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .getEditor().getEditorComponent().addFocusListener(new FocusAdapter() {         
ENDIF @endif  
NEWLINE   
OUT   
SECTION @section
WS  
ID EndFocusLost
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID hasEvent
WS  
ID Lost
WS  
ID Focus
BOOL_END )@
NEWLINE   
OUT             }          });  
ENDIF @endif  
NEWLINE   
OUT   
ENDIF @endif  
WS   
IF_ @if
WS  
BOOL_START @(
ID isEditable
BOOL_END )@
NEWLINE   
OUT       
IF_ @if
WS  
BOOL_START @(
NOT !
ID isSearchable
BOOL_END )@
NEWLINE   
OUT         
CREATESECTION @createSection
WS  
ID EndFocusGained
ALFA @@
ID LogicalName
ALFA @@
WS  
ID FocusActions
NEWLINE   
CREATESECTION @createSection
WS  
ID StartFocusGained
ALFA @@
ID LogicalName
ALFA @@
WS  
ID EndFocusGained
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
OUT   
SECTION @section
WS  
ID StartFocusGained
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID hasEvent
WS  
ID Got
WS  
ID Focus
BOOL_END )@
NEWLINE   
OUT         
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .getEditor().getEditorComponent().addFocusListener(new FocusAdapter() {         
ENDIF @endif  
NEWLINE   
SECTION @section
WS  
ID EndFocusGained
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID hasEvent
WS  
ID Got
WS  
ID Focus
BOOL_END )@
NEWLINE   
OUT             }          });  
ENDIF @endif  
NEWLINE   
CREATESECTION @createSection
WS  
ID EndFocusLost
ALFA @@
ID LogicalName
ALFA @@
WS  
ID FocusActions
NEWLINE   
CREATESECTION @createSection
WS  
ID StartFocusLost
ALFA @@
ID LogicalName
ALFA @@
WS  
ID EndFocusLost
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
OUT   
SECTION @section
WS  
ID StartFocusLost
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID hasEvent
WS  
ID Lost
WS  
ID Focus
BOOL_END )@
NEWLINE   
OUT         
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .getEditor().getEditorComponent().addFocusListener(new FocusAdapter() {         
ENDIF @endif  
NEWLINE   
OUT   
SECTION @section
WS  
ID EndFocusLost
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID hasEvent
WS  
ID Lost
WS  
ID Focus
BOOL_END )@
NEWLINE   
OUT             }          });  
ENDIF @endif  
NEWLINE   
OUT       
ENDIF @endif  
WS   
ENDIF @endif  
WS   
IF_ @if
WS  
BOOL_START @(
NOT !
ID isEditable
BOOL_END )@
NEWLINE   
OUT       
IF_ @if
WS  
BOOL_START @(
NOT !
ID isSearchable
BOOL_END )@
NEWLINE   
OUT         
CREATESECTION @createSection
WS  
ID EndFocusGained
ALFA @@
ID LogicalName
ALFA @@
WS  
ID FocusActions
NEWLINE   
CREATESECTION @createSection
WS  
ID StartFocusGained
ALFA @@
ID LogicalName
ALFA @@
WS  
ID EndFocusGained
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
OUT   
SECTION @section
WS  
ID StartFocusGained
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID hasEvent
WS  
ID Got
WS  
ID Focus
BOOL_END )@
NEWLINE   
OUT         
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .addFocusListener(new FocusAdapter() {              public void focusGained(Focu
ENDIF @endif  
NEWLINE   
SECTION @section
WS  
ID EndFocusGained
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID hasEvent
WS  
ID Got
WS  
ID Focus
BOOL_END )@
NEWLINE   
OUT             }          });  
ENDIF @endif  
NEWLINE   
CREATESECTION @createSection
WS  
ID EndFocusLost
ALFA @@
ID LogicalName
ALFA @@
WS  
ID FocusActions
NEWLINE   
CREATESECTION @createSection
WS  
ID StartFocusLost
ALFA @@
ID LogicalName
ALFA @@
WS  
ID EndFocusLost
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
OUT   
SECTION @section
WS  
ID StartFocusLost
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID hasEvent
WS  
ID Lost
WS  
ID Focus
BOOL_END )@
NEWLINE   
OUT         
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .addFocusListener(new FocusAdapter() {              public void focusLost(FocusE
ENDIF @endif  
NEWLINE   
OUT   
SECTION @section
WS  
ID EndFocusLost
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID hasEvent
WS  
ID Lost
WS  
ID Focus
BOOL_END )@
NEWLINE   
OUT             }          });  
ENDIF @endif  
NEWLINE   
OUT       
ENDIF @endif  
WS   
ENDIF @endif  
ENDIF @endif  
NEWLINE   
OUT       
CREATESECTION @createSection
WS  
ID EndcomboboxDroppedDown
ALFA @@
ID LogicalName
ALFA @@
WS  
ID comboboxDroppedDown
NEWLINE   
CREATESECTION @createSection
WS  
ID StartcomboboxDroppedDown
ALFA @@
ID LogicalName
ALFA @@
WS  
ID EndcomboboxDroppedDown
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
OUT   
SECTION @section
WS  
ID StartcomboboxDroppedDown
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID hasEvent
WS  
ID Dropped
WS  
ID Down
BOOL_END )@
NEWLINE   
OUT     
COMMENT @//
REM   
OUT         if(theBox == 
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT ) {  
ENDIF @endif  
SECTION @section
WS  
ID EndcomboboxDroppedDown
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID hasEvent
WS  
ID Dropped
WS  
ID Down
BOOL_END )@
NEWLINE   
OUT         }   
ENDIF @endif  
NEWLINE   
OUT         
CREATESECTION @createSection
WS  
ID EndValueChangedTest
ALFA @@
ID LogicalName
ALFA @@
WS  
ID ValueChanged
NEWLINE   
CREATESECTION @createSection
WS  
ID StartValueChangedTest
ALFA @@
ID LogicalName
ALFA @@
WS  
ID EndValueChangedTest
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
OUT   
SECTION @section
WS  
ID StartValueChangedTest
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID hasEvent
WS  
ID Value
WS  
ID Changed
BOOL_END )@
NEWLINE   
OUT         
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .addValueChangedListener(new GenovaValueChangedListener() {              public 
ENDIF @endif  
WS           
NEWLINE   
SECTION @section
WS  
ID EndValueChangedTest
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID hasEvent
WS  
ID Value
WS  
ID Changed
BOOL_END )@
NEWLINE   
OUT             }          });       
ENDIF @endif  
NEWLINE   
OUT     
CREATESECTION @createSection
WS  
ID EndKeyTyped
ALFA @@
ID LogicalName
ALFA @@
WS  
ID KeyTyped
NEWLINE   
OUT   
CREATESECTION @createSection
WS  
ID StartKeyTyped
ALFA @@
ID LogicalName
ALFA @@
WS  
ID EndKeyTyped
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
OUT     
SECTION @section
WS  
ID StartKeyTyped
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID hasEvent
WS  
ID Character
WS  
ID Changed
BOOL_END )@
NEWLINE   
OUT             if (e.getSource() == 
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .getEditor().getEditorComponent()) {  
ENDIF @endif  
NEWLINE   
OUT   
SECTION @section
WS  
ID EndKeyTyped
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID hasEvent
WS  
ID Character
WS  
ID Changed
BOOL_END )@
NEWLINE   
OUT             }  
ENDIF @endif  
NEWLINE   
OUT       
CREATESECTION @createSection
WS  
ID EndSelected
ALFA @@
ID LogicalName
ALFA @@
WS  
ID selectedInCombobox
NEWLINE   
CREATESECTION @createSection
WS  
ID StartSelected
ALFA @@
ID LogicalName
ALFA @@
WS  
ID EndSelected
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
OUT   
SECTION @section
WS  
ID StartSelected
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID hasEvent
WS  
ID Selected
BOOL_END )@
NEWLINE   
OUT             if(source == 
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT                        && source.getSelectedIndex() >= 0) {    
ENDIF @endif  
NEWLINE   
SECTION @section
WS  
ID EndSelected
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID hasEvent
WS  
ID Selected
BOOL_END )@
NEWLINE   
OUT             }  
ENDIF @endif  
NEWLINE   
OUT     
SECTION @section
WS  
ID ComboSelectionManager
NEWLINE   
OUT         
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .setKeySelectionManager(
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT .new SelectionManager());            
EVENT @event
WS  
ID Character
WS  
ID Changed
NEWLINE   
SECTION @section
WS  
ID StartKeyTyped
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID hasMethodName
BOOL_END )@
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID isFirstInMethod
BOOL_END )@
NEWLINE   
OUT                 controller.
ALFA @@
ID MethodName
ALFA @@
OUT (new GenovaKeyEventHolder(e));  
ENDIF @endif  
ENDIF @endif  
NEWLINE   
OUT           
EVENT @event
WS  
ID Got
WS  
ID Focus
NEWLINE   
SECTION @section
WS  
ID StartFocusGained
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID hasMethodName
BOOL_END )@
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID isFirstInMethod
BOOL_END )@
NEWLINE   
OUT                 controller.
ALFA @@
ID MethodName
ALFA @@
OUT (new GenovaFocusEventHolder(e));  
ENDIF @endif  
ENDIF @endif  
NEWLINE   
EVENT @event
WS  
ID Lost
WS  
ID Focus
NEWLINE   
SECTION @section
WS  
ID StartFocusLost
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID hasMethodName
BOOL_END )@
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID isFirstInMethod
BOOL_END )@
NEWLINE   
OUT                 controller.
ALFA @@
ID MethodName
ALFA @@
OUT (new GenovaFocusEventHolder(e));  
ENDIF @endif  
ENDIF @endif  
NEWLINE   
OUT   
EVENT @event
WS  
ID Dropped
WS  
ID Down
NEWLINE   
SECTION @section
WS  
ID StartcomboboxDroppedDown
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID hasMethodName
BOOL_END )@
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID isFirstInMethod
BOOL_END )@
NEWLINE   
OUT             controller.
ALFA @@
ID MethodName
ALFA @@
OUT (new GenovaDroppedDownEvent(
ALFA @@
ID NodeName
ALFA @@
OUT _
ALFA @@
ID Name
ALFA @@
OUT , null));  
ENDIF @endif  
ENDIF @endif  
NEWLINE   
EVENT @event
WS  
ID Value
WS  
ID Changed
NEWLINE   
SECTION @section
WS  
ID StartValueChangedTest
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID hasMethodName
BOOL_END )@
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID isFirstInMethod
BOOL_END )@
NEWLINE   
OUT                 controller.
ALFA @@
ID MethodName
ALFA @@
OUT (e);  
ENDIF @endif  
ENDIF @endif  
NEWLINE   
EVENT @event
WS  
ID Selected
NEWLINE   
SECTION @section
WS  
ID StartSelected
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID hasMethodName
BOOL_END )@
NEWLINE   
IF_ @if
WS  
BOOL_START @(
ID isFirstInMethod
BOOL_END )@
NEWLINE   
OUT                 controller.
ALFA @@
ID MethodName
ALFA @@
OUT (event);   
ENDIF @endif  
ENDIF @endif  
NEWLINE   
