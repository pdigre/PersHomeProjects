REM %REM
REM : ----------------------------------------------------  
REM %REM
REM : Copyright (c) 2007-09 Esito AS. All rights reserved.  
REM %REM
REM : Version: 8.4.0.Alpha. August 13, 2009.  
REM %REM
REM : ----------------------------------------------------  
REM %REM
REM : ================================================= %
OUT   
REM %REM
REM : Expected macro definitions defined by target are: %
OUT   
REM %REM
REM : * targetMethodRunner - the class used to run      %
OUT   
REM %REM
REM :     actions.                                      %
OUT   
REM %REM
REM :  * targetMessageInteractor - the message          %
OUT   
REM %REM
REM :     interactor                                    %
OUT   
REM %REM
REM :  * targetMessageCentral                           %
OUT   
REM %REM
REM :  * targetMessageCallback                          %
OUT   
REM %REM
REM : ================================================= %
OUT   
FILE %FILE%
MACRO %MACRO:
ID javaClientGenDir
DLM %
SLASH /
MACRO %MACRO:
ID diaDefaultController
DLM %
DOT .
ID java
NEWLINE   
OUT /*   * 
DLM %
ID GeneratedWith
DLM %
OUT    */  package 
MACRO %MACRO:
ID javaClientGenPackage
DLM %
OUT ;    import no.genova.client.core.controller.ApplicationController;  import no.g
DLM %
ID Name
DLM %
OUT  application controller.    * <Strong>   * Do not edit this class since it will 
MACRO %MACRO:
ID suppressAllWarnings
DLM %
OUT     public class 
MACRO %MACRO:
ID diaDefaultController
DLM %
OUT  extends ApplicationController {        /**       * Constructs a new Application
DLM %
ID Name
DLM %
OUT  application       */      public 
MACRO %MACRO:
ID diaDefaultController
DLM %
OUT () {          super("
DLM %
ID Name
DLM %
OUT ");      }            @Override      public <T extends DialogConstant> T getAppl
ITERATE %ITERATE:
ID DialogModelRef
DLM %
OUT   
IF_ %IF:
ID IsApplicationWindow
DLM %
OUT           return getDialogConst("
MACRO %MACRO:
ID internalName
DLM %
OUT ");  
ENDIF %ENDIF
REM %
OUT           
ENDITERATE %ENDITERATE
REM %
OUT               }    }  
ENDFILE %ENDFILE%
OUT   
NEWFILE %NEWFILE%
MACRO %MACRO:
ID javaClientDir
DLM %
SLASH /
MACRO %MACRO:
ID diaController
DLM %
DOT .
ID java
NEWLINE   
OUT /*   * 
DLM %
ID GeneratedWith
DLM %
OUT    */  package 
DLM %
ID ClientPackage
DLM %
OUT ;    import 
MACRO %MACRO:
ID javaClientGenPackage
DLM %
OUT .
MACRO %MACRO:
ID diaDefaultController
DLM %
OUT ;    /**   * The customizable application controller.   * This class will not be
MACRO %MACRO:
ID diaController
DLM %
OUT  extends 
MACRO %MACRO:
ID diaDefaultController
DLM %
OUT  {      // Empty class  }  
ENDFILE %ENDFILE%
OUT   
FILE %FILE%
MACRO %MACRO:
ID ctrlConfigDir
DLM %
MACRO %MACRO:
ID appBeansXML
DLM %
NEWLINE   
OUT <?xml version="1.0" encoding="UTF-8"?>    <!--      
DLM %
ID GeneratedWith
DLM %
OUT             This is the spring beans used by the application.            The bea
REM %REM
REM : %
OUT   
REM %REM
REM : Hack - fixes classloader problem during initialization of message replies. %
OUT   
REM %REM
REM : %
OUT       <!--           OBS: The following bean resolves a class loader problem dur
REM %REM
REM : %
OUT   
REM %REM
REM : Hack - ENDED%
OUT   
REM %REM
REM : %
OUT           <bean id="genova_internal_msg_fix"          class="no.genova.message.M
MACRO %MACRO:
ID targetMethodRunner
DLM %
OUT "          scope="prototype">      </bean>            <!-- The message interacto
MACRO %MACRO:
ID targetMessageInteractor
DLM %
OUT "          scope="prototype">      </bean>            <!-- The message handler -
MACRO %MACRO:
ID targetMessageCentral
DLM %
OUT "          lazy-init="true"          scope="prototype">          <property name=
MACRO %MACRO:
ID targetMessageCallback
DLM %
OUT "          scope="prototype">      </bean>		            <!-- The target specific
MACRO %MACRO:
ID targetHookInvoker
DLM %
OUT "          scope="prototype">      </bean>      
ITERATE %ITERATE:
ID DialogModelRef
DLM %
OUT         <!-- The 
DLM %
ID Name
DLM %
OUT  dialog controller -->      <bean id="
MACRO %MACRO:
ID internalName
DLM %
OUT "             class="
MACRO %MACRO:
ID ctJavaDiaRefPackage
DLM %
OUT .
MACRO %MACRO:
ID diaController
DLM %
OUT "            scope="prototype"             lazy-init="true">      </bean>  
ENDITERATE %ENDITERATE
REM %
OUT     </beans>  
ENDFILE %ENDFILE%
OUT     
