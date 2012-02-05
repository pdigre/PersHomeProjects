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
ID Declaration
NEWLINE   
OUT     
COMMENT @//
REM   
OUT     /* Her kommer generert kode for Button:Declaration*/      
COMMENT @//
REM       
OUT     JButton 
ALFA @@
ID Name
ALFA @@
OUT ;      
COMMENT @//
REM   
OUT   
SECTION @section
ID SetupInit
ALFA @@
ID ParentName
ALFA @@
ID Start
NEWLINE   
OUT         init
ALFA @@
ID Name
ALFA @@
OUT ();      
SECTION @section
ID SetupInit
NEWLINE   
OUT     
COMMENT @//
REM   
OUT     /** Initializes the 
ALFA @@
ID Name
ALFA @@
OUT  button */      private void init
ALFA @@
ID Name
ALFA @@
OUT () {          
COMMENT @//
REM   
OUT         /* Her kommer generert kode for Button:Setup*/          
COMMENT @//
REM   
OUT         ImageIcon image
ALFA @@
ID Name
ALFA @@
OUT  = null;          
DOLLAR $$
ID useImage
QUESTION ?
ID image
ALFA @@
ID Name
ALFA @@
ASSIGN =
ID RepositoryProxy
DOT .
ID getImageField
LPARAN (
LITERAL "@@ImageName@@"
RPARAN )
SEMICOLON ;
COLON :
DOLLAR $$
OUT           if (image
ALFA @@
ID Name
ALFA @@
OUT  != null) {              
ALFA @@
ID Name
ALFA @@
OUT  = new GenovaButton(image
ALFA @@
ID Name
ALFA @@
OUT );          }          else {              
ALFA @@
ID Name
ALFA @@
OUT  = new GenovaButton("
ALFA @@
ID Title
ALFA @@
OUT ");          }          
ALFA @@
ID ParentName
ALFA @@
OUT .add(
ALFA @@
ID Name
ALFA @@
OUT );          
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
OUT );          
ALFA @@
ID Name
ALFA @@
OUT .setSize(
ALFA @@
ID Width
ALFA @@
OUT , 
ALFA @@
ID Height
ALFA @@
OUT );          
ALFA @@
ID Name
ALFA @@
OUT .setMargin(new Insets(0,0,0,0));            
IF_ @if
BOOL_START @(
NOT !
ID isVisible
BOOL_END )@
NEWLINE   
OUT         
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
ID Name
ALFA @@
OUT .setEnabled(false);           disabledComponents.add(
ALFA @@
ID Name
ALFA @@
OUT );  
ENDIF @endif  
BOOL_START @(
ID hasTooltip
QUESTION ?
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
IF_ @if
BOOL_START @(
ID hasMnemonic
BOOL_END )@
NEWLINE   
OUT         
ALFA @@
ID Name
ALFA @@
OUT .setMnemonic('
ALFA @@
ID Mnemonic
ALFA @@
OUT ');          registerMnemonic(
ALFA @@
ID Name
ALFA @@
OUT .getMnemonic());          addToMnemonicButtons(
ALFA @@
ID Name
ALFA @@
OUT );  
ENDIF @endif  
BOOL_START @(
ID hasBackgroundColor
QUESTION ?
ID RepositoryProxy
DOT .
ID setBackgroundColor
LPARAN (
ALFA @@
ID Name
ALFA @@
COMMA ,
LITERAL "@@StyleBackgroundColor@@"
RPARAN )
SEMICOLON ;
COLON :
BOOL_END )@
NEWLINE   
OUT         
BOOL_START @(
ID hasForegroundColor
QUESTION ?
ID RepositoryProxy
DOT .
ID setForegroundColor
LPARAN (
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
ID Name
ALFA @@
COMMA ,
LITERAL "@@FontName@@"
RPARAN )
SEMICOLON ;
COLON :
BOOL_END )@
OUT           
BOOL_START @(
ID useImage
QUESTION ?
ID RepositoryProxy
DOT .
ID setImage
LPARAN (
ALFA @@
ID Name
ALFA @@
COMMA ,
BOOL_START @(
ID hasImage
QUESTION ?
LITERAL "@@ImageName@@"
COLON :
LITERAL "NO_IMAGE"
BOOL_END )@
RPARAN )
SEMICOLON ;
COLON :
BOOL_END )@
OUT           
BOOL_START @(
ID hasActionEvent
QUESTION ?
ALFA @@
ID Name
ALFA @@
DOT .
ID addActionListener
LPARAN (
ID actionProc
RPARAN )
SEMICOLON ;
COLON :
BOOL_END )@
OUT           
COMMENT @//
REM   
OUT         controller.tabListFromNodeName
ALFA @@
ID ParentName
ALFA @@
OUT .put("
ALFA @@
ID Name
ALFA @@
OUT ", 
ALFA @@
ID Name
ALFA @@
OUT );          controller.tabListFromComponent
ALFA @@
ID ParentName
ALFA @@
OUT .put(
ALFA @@
ID Name
ALFA @@
OUT , "
ALFA @@
ID Name
ALFA @@
OUT ");      }      
SECTION @section
ID ConstCompButton
NEWLINE   
COMMENT @//
REM   
OUT         /** The Button 
ALFA @@
ID Name
ALFA @@
OUT  component */          String 
DOLLAR $$
ID hasParameter
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
ID Name
ALFA @@
OUT ";      
SECTION @section
ID setUpNameComponentMapping
NEWLINE   
OUT         nameToComponent.put("
ALFA @@
ID Name
ALFA @@
OUT ", 
ALFA @@
ID Name
ALFA @@
OUT );          componentToName.put(
ALFA @@
ID Name
ALFA @@
OUT , "
ALFA @@
ID Name
ALFA @@
OUT ");    
SECTION @section
ID MethodDeclaration
NEWLINE   
BEGIN @begin
NEWLINE   
OUT     
COMMENT @//
REM   
OUT     /* Her kommer generert kode for Button:MethodDeclaration*/      
COMMENT @//
REM   
OUT     /** Set enable/disable for button 
ALFA @@
ID Name
ALFA @@
OUT         * 
ID param
OUT  b true for enabled, false for not        */      public void setEnabled
ALFA @@
ID Name
ALFA @@
OUT (boolean b) {          view.
ALFA @@
ID Name
ALFA @@
OUT .setEnabled(b);      }      
COMMENT @//
REM   
OUT     /**       * Shows or hides 
ALFA @@
ID Name
ALFA @@
OUT  depending on the parameter.       * 
ID param
OUT  b <code>true</code> to show, <code>false</code> to hide.       */      public v
ALFA @@
ID Name
ALFA @@
OUT (boolean b) {          view.
ALFA @@
ID Name
ALFA @@
OUT .setVisible(b);      }      
COMMENT @//
REM   
OUT       /**       * Attemts to transfer input focus to 
ALFA @@
ID Name
ALFA @@
OUT        */      public void setFocus
ALFA @@
ID Name
ALFA @@
OUT () {          view.
ALFA @@
ID Name
ALFA @@
OUT .requestFocusInWindow();      }      
COMMENT @//
REM   
OUT     /**       * Check if 
ALFA @@
ID Name
ALFA @@
OUT  is enabled.       * 
ID return
OUT  <code>true</code> if 
ALFA @@
ID Name
ALFA @@
OUT  is enabled.       */      public boolean isEnabled
ALFA @@
ID Name
ALFA @@
OUT () {          return view.
ALFA @@
ID Name
ALFA @@
OUT .isEnabled();      }      
COMMENT @//
REM   
OUT     /**       * Check if 
ALFA @@
ID Name
ALFA @@
OUT  is the focus owner.       * 
ID return
OUT  <code>true</code> if 
ALFA @@
ID Name
ALFA @@
OUT  is the focus owner.       */      public boolean hasFocus
ALFA @@
ID Name
ALFA @@
OUT () {          return view.
ALFA @@
ID Name
ALFA @@
OUT .isFocusOwner();      }      
COMMENT @//
REM   
OUT     /**       * Check if 
ALFA @@
ID Name
ALFA @@
OUT  is visible. Note that this does        * not imply that 
ALFA @@
ID Name
ALFA @@
OUT  is actually showing, only that it can be        * drawn on the screen.       * 
ID return
OUT  <code>true</code> if 
ALFA @@
ID Name
ALFA @@
OUT  is visible.       */      public boolean isShown
ALFA @@
ID Name
ALFA @@
OUT () {          return view.
ALFA @@
ID Name
ALFA @@
OUT .isVisible();      }    
CREATESECTION @createSection
ID EndFocusGained
ALFA @@
ID LogicalName
ALFA @@
ID FocusActions
NEWLINE   
CREATESECTION @createSection
ID StartFocusGained
ALFA @@
ID LogicalName
ALFA @@
ID EndFocusGained
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
OUT   
SECTION @section
ID StartFocusGained
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
BOOL_START @(
ID hasEvent
ID Got
ID Focus
BOOL_END )@
NEWLINE   
OUT         
ALFA @@
ID Name
ALFA @@
OUT .addFocusListener(new FocusAdapter() {              public void focusGained(Focu
ENDIF @endif  
NEWLINE   
SECTION @section
ID EndFocusGained
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
BOOL_START @(
ID hasEvent
ID Got
ID Focus
BOOL_END )@
NEWLINE   
OUT             }          });  
ENDIF @endif  
NEWLINE   
CREATESECTION @createSection
ID EndFocusLost
ALFA @@
ID LogicalName
ALFA @@
ID FocusActions
NEWLINE   
CREATESECTION @createSection
ID StartFocusLost
ALFA @@
ID LogicalName
ALFA @@
ID EndFocusLost
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
OUT   
SECTION @section
ID StartFocusLost
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
BOOL_START @(
ID hasEvent
ID Lost
ID Focus
BOOL_END )@
NEWLINE   
OUT         
ALFA @@
ID Name
ALFA @@
OUT .addFocusListener(new FocusAdapter() {              public void focusLost(FocusE
ENDIF @endif  
NEWLINE   
OUT   
SECTION @section
ID EndFocusLost
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
BOOL_START @(
ID hasEvent
ID Lost
ID Focus
BOOL_END )@
NEWLINE   
OUT             }          });  
ENDIF @endif  
NEWLINE   
OUT   
CREATESECTION @createSection
ID EndActionPerformed
ALFA @@
ID LogicalName
ALFA @@
ID ActionPerformed
NEWLINE   
CREATESECTION @createSection
ID StartActionPerformed
ALFA @@
ID LogicalName
ALFA @@
ID EndActionPerformed
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
SECTION @section
ID StartActionPerformed
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
BOOL_START @(
ID hasEvent
ID Clicked
BOOL_END )@
NEWLINE   
OUT                     
COMMENT @//
REM   
OUT                     /* Her kommer generert kode for Button ActionPerformed*/    
COMMENT @//
REM   
OUT                     if (e.getSource() == 
ALFA @@
ID Name
ALFA @@
OUT ) {    
ENDIF @endif  
NEWLINE   
SECTION @section
ID EndActionPerformed
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
BOOL_START @(
ID hasEvent
ID Clicked
BOOL_END )@
NEWLINE   
OUT                     }  
ENDIF @endif  
NEWLINE   
EVENT @event
ID Got
ID Focus
NEWLINE   
SECTION @section
ID StartFocusGained
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
BOOL_START @(
ID hasMethodName
BOOL_END )@
NEWLINE   
IF_ @if
BOOL_START @(
ID isFirstInMethod
BOOL_END )@
NEWLINE   
OUT                 controller.
DOLLAR $$
ID MethodName
DOLLAR $$
OUT (new GenovaFocusEventHolder(e));  
ENDIF @endif  
ENDIF @endif  
NEWLINE   
EVENT @event
ID Lost
ID Focus
NEWLINE   
SECTION @section
ID StartFocusLost
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
BOOL_START @(
ID hasMethodName
BOOL_END )@
NEWLINE   
IF_ @if
BOOL_START @(
ID isFirstInMethod
BOOL_END )@
NEWLINE   
OUT                 controller.
DOLLAR $$
ID MethodName
DOLLAR $$
OUT (new GenovaFocusEventHolder(e));  
ENDIF @endif  
ENDIF @endif  
NEWLINE   
EVENT @event
ID Clicked
NEWLINE   
SECTION @section
ID StartActionPerformed
ALFA @@
ID LogicalName
ALFA @@
NEWLINE   
IF_ @if
BOOL_START @(
ID hasMethodName
BOOL_END )@
NEWLINE   
IF_ @if
BOOL_START @(
ID isFirstInMethod
BOOL_END )@
NEWLINE   
OUT                         controller.
DOLLAR $$
ID MethodName
DOLLAR $$
OUT (new GenovaActionEventHolder(e));  
ENDIF @endif  
ENDIF @endif  
