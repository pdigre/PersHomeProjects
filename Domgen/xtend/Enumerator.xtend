import GenovaBase

class Enumerator extends GenovaBase{ 
	XEnumerator enumerator
	override call(){
	 	// ----------------------------------------------------
	 	// Copyright (c) 2005-11 Esito AS. All rights reserved.
	 	// Version: 9.0.7-SNAPSHOT. September 23, 2011.
	 	// ----------------------------------------------------
	 	// This file generates java code for one enumeration class.
	 	// If the template parameter GenerateOldStyleEnums is set, an old-style 
	 	// enumeration (java 1.4) is generated. Or else we get a java enum.
	 	file(macro("DomainDirectory") + "/" + enumerator.Name + ".java")
	 	if(_DEFINED(enumerator.CommentFile)){
	 		include(enumerator.CommentFile)
	 	}else {
	 		'''
	 		  // 
	 		«enumerator.GeneratedWith»'''
	 	}
	 	'''
	 	
	 	package 
	 	«_SLASH_TO_DOT(_LOWER(enumerator.PackageName))»;
	 	'''
	 	// Now we need to know if we are generating a java Enum, or an instance of GenovaEnumerator
	 	if(_DEFINED(enumerator.GenerateJavaStyleEnums)){
	 		// This branch generates java enum
	 		'''  /**
	 		'''
	 		// Note: Intended space at the end of next line (SUP-209 workaround)
	 		if(enumerator.HasDescription.toBool){
	 			'''«macro("JavaDocDesc")»
	 			'''
	 		}
	 		indent(1)
	 		'''
	 		   */
	 		'''
	 		indent(1)
	 		'''«macro("suppressAllWarnings")»
	 		 
	 		  public enum 
	 		«enumerator.Name» {
	 		'''
	 		indent(4)
	 		// The variable #lastAssignedOrdinal is used to assign ordinal values to 
	 		// enum values without an explicit ordinal.
	 		enumerator.lastAssignedOrdinal = 0
	 		for(enumvalue:enumerator.iterateEnumValue){
	 			if(enumvalue.HasDescription.toBool){
	 				'''
	 				        /** 
	 				«enumvalue.Description» */
	 				'''
	 			}else {
	 				'''
	 				        /** The 
	 				«enumvalue.Name» constant */
	 				'''
	 			}
	 			if(enumvalue.OrdinalNumber == ""){
	 				parent.lastAssignedOrdinal = parent.lastAssignedOrdinal + 1
	 			}else {
	 				parent.lastAssignedOrdinal = enumvalue.OrdinalNumber
	 			}
	 			'''«enumvalue.Name»(
	 			«parent.lastAssignedOrdinal», "
	 			«enumvalue.DisplayText»")
	 			«if (enumvalue.IsLast.toBool) ";" else ","»'''
	 		}
	 		'''
	 		    
	 		    private final int ordinalValue;
	 		    private final String title;
	 		
	 		    /* 
	 		'''
	 		indent(1)
	 		'''
	 		     * Creates an enum with the given title and ordinal value
	 		     */
	 		'''
	 		indent(1)
	 		'''
	 		    private 
	 		«enumerator.Name»(final int ordinalValue, final String title) {
	 		'''
	 		indent(4)
	 		'''
	 		        this.ordinalValue = ordinalValue;
	 		        this.title = title;
	 		'''
	 		indent(4)
	 		'''
	 		    }
	 		
	 		    /** 
	 		'''
	 		indent(1)
	 		'''
	 		     * Returns the title value of this enum.
	 		     *
	 		     * @return the title value of this enum
	 		     */
	 		'''
	 		indent(1)
	 		'''
	 		    public final String getTitle() {
	 		'''
	 		indent(4)
	 		'''
	 		        return title;
	 		'''
	 		indent(4)
	 		'''
	 		    }
	 		
	 		    /** 
	 		'''
	 		indent(1)
	 		'''
	 		     * Returns the ordinal value of this enum.
	 		     *
	 		     * @return the ordinal value of this enum
	 		     */
	 		'''
	 		indent(1)
	 		'''
	 		    public final int getOrdinalValue() {
	 		'''
	 		indent(4)
	 		'''
	 		        return ordinalValue;
	 		'''
	 		indent(4)
	 		'''
	 		    }
	 		
	 		    /**
	 		'''
	 		indent(1)
	 		'''
	 		     * Returns the enum value corresponding to the given title.
	 		     *
	 		     * @param title the title to look up
	 		     * @return the enum value corresponding to the given title
	 		     */
	 		'''
	 		indent(1)
	 		'''
	 		    public static final 
	 		«enumerator.Name» titleToEnum(final String title) {
	 		'''
	 		indent(4)
	 		'''
	 		        for (
	 		«enumerator.Name» some
	 		«enumerator.Name» : values()) {
	 		'''
	 		indent(4)
	 		'''
	 		            if (some
	 		«enumerator.Name».title.equals(title)) {
	 		'''
	 		indent(4)
	 		'''
	 		                return some
	 		«enumerator.Name»;
	 		'''
	 		indent(4)
	 		'''
	 		            }
	 		'''
	 		indent(4)
	 		'''
	 		        }
	 		        throw new IllegalArgumentException("No such title: " + title);
	 		'''
	 		indent(4)
	 		'''
	 		    }
	 		
	 		    /**
	 		'''
	 		indent(1)
	 		'''
	 		     * Returns the enum value corresponding to the given ordinal value.
	 		     *
	 		     * @param ordinalValue the ordinal value to look up
	 		     * @return the enum value corresponding to the given ordinal value
	 		     */
	 		'''
	 		indent(1)
	 		'''
	 		    public static final 
	 		«enumerator.Name» ordinalToEnum(final int ordinalValue) {
	 		'''
	 		indent(4)
	 		'''
	 		        for (
	 		«enumerator.Name» some
	 		«enumerator.Name» : values()) {
	 		'''
	 		indent(4)
	 		'''
	 		            if (some
	 		«enumerator.Name».ordinalValue == ordinalValue) {
	 		'''
	 		indent(4)
	 		'''
	 		                return some
	 		«enumerator.Name»;
	 		'''
	 		indent(4)
	 		'''
	 		            }
	 		'''
	 		indent(4)
	 		'''
	 		        }
	 		        throw new IllegalArgumentException("No such ordinal: " + ordinalValue);
	 		'''
	 		indent(4)
	 		'''
	 		    }
	 		
	 		    @Override
	 		    public String toString() {
	 		'''
	 		indent(4)
	 		'''
	 		        return getTitle();
	 		'''
	 		indent(4)
	 		'''
	 		    }
	 		
	 		'''
	 		indent(4)
	 		'''
	 		  }
	 		'''
	 	}else {
	 		// This branch generates "old-style" enumerations, subclasses of GenovaEnumerator
	 		'''  import no.genova.support.GenovaEnumerator;
	 		  import no.genova.domain.GenovaEnums;
	 		  import java.util.LinkedList;
	 		  import java.util.List;
	 		
	 		  /**
	 		'''
	 		// Note: Intended space at the end of next line (SUP-209 workaround)
	 		if(enumerator.HasDescription.toBool){
	 			'''«macro("JavaDocDesc")»
	 			'''
	 		}
	 		indent(1)
	 		'''
	 		   */
	 		'''
	 		indent(1)
	 		'''«macro("suppressAllWarnings")»
	 		 
	 		  public class 
	 		«enumerator.Name» extends GenovaEnumerator {
	 		'''
	 		indent(4)
	 		// The variable #lastAssignedOrdinal is used to assign ordinal values to 
	 		// enum values without an explicit ordinal.
	 		enumerator.lastAssignedOrdinal = 0
	 		for(enumvalue:enumerator.iterateEnumValue){
	 			if(enumvalue.OrdinalNumber == ""){
	 				parent.lastAssignedOrdinal = parent.lastAssignedOrdinal + 1
	 			}else {
	 				parent.lastAssignedOrdinal = enumvalue.OrdinalNumber
	 			}
	 			if(enumvalue.HasDescription.toBool){
	 				'''
	 				        /** 
	 				«enumvalue.Description» */
	 				'''
	 			}else {
	 				'''
	 				        /** The 
	 				«enumvalue.Name» constant */
	 				'''
	 			}
	 			'''
	 			      public static final int 
	 			«enumvalue.Name» = 
	 			«parent.lastAssignedOrdinal»;
	 			'''
	 		}
	 		'''
	 		 
	 		    /**
	 		'''
	 		indent(1)
	 		'''
	 		     * Default constructor
	 		     */
	 		'''
	 		indent(1)
	 		'''
	 		    public 
	 		«enumerator.Name»() {
	 		'''
	 		indent(4)
	 		'''
	 		      super();
	 		'''
	 		indent(4)
	 		'''
	 		    }
	 		
	 		    /**
	 		'''
	 		indent(1)
	 		'''
	 		     * Constructs a new 
	 		«enumerator.Name»
	 		     *
	 		     * @param ordinalValue the int value of the enumeration
	 		     */
	 		'''
	 		indent(1)
	 		'''
	 		    public 
	 		«enumerator.Name»(int ordinalValue) {
	 		'''
	 		indent(4)
	 		'''
	 		      currentValue = ordinalValue;
	 		'''
	 		indent(4)
	 		'''
	 		    }
	 		
	 		    /**
	 		'''
	 		indent(1)
	 		'''
	 		     * Returns the int (ordinal) value for an enumeration with the given title.
	 		     * This method may be called by generated code.
	 		     *
	 		     * @param title The title of the enum to convert.
	 		     * @return The int value (currentValue) of the enumerator.
	 		     */
	 		'''
	 		indent(1)
	 		'''
	 		    public static int toValue(String title) {
	 		'''
	 		indent(4)
	 		'''
	 		      if (title == null) {
	 		'''
	 		indent(4)
	 		'''
	 		          return GenovaEnums.NO_VALUE;
	 		'''
	 		indent(4)
	 		'''
	 		      }
	 		'''
	 		for(enumvalue:enumerator.iterateEnumValue){
	 			'''
	 			        if (title.equals("
	 			«enumvalue.DisplayText»")) {
	 			'''
	 			indent(4)
	 			'''
	 			            return 
	 			«enumvalue.OrdinalNumber»;
	 			'''
	 			indent(4)
	 			'''
	 			        }
	 			'''
	 		}
	 		//EnumValue
	 		'''
	 		      return GenovaEnums.NO_VALUE;
	 		'''
	 		indent(4)
	 		'''
	 		    }
	 		
	 		    /**
	 		'''
	 		indent(1)
	 		'''
	 		     * Converts the ordinal value of an enumeration to its corresponding title.
	 		     * This method may be called by generated code.
	 		     *
	 		     * @param value The ordinal value of the enumeration.
	 		     * @return The title of the enumeration.
	 		     */
	 		'''
	 		indent(1)
	 		'''
	 		    public static String toTitle(int value) {
	 		'''
	 		indent(4)
	 		'''
	 		      switch (value) {
	 		'''
	 		for(enumvalue:enumerator.iterateEnumValue){
	 			'''
	 			        case 
	 			«enumvalue.OrdinalNumber»: return "
	 			«enumvalue.DisplayText»";
	 			'''
	 		}
	 		//EnumValue
	 		'''
	 		      default: return "";
	 		      }
	 		'''
	 		indent(4)
	 		'''
	 		    }
	 		
	 		    /**
	 		'''
	 		indent(1)
	 		'''
	 		     * Returns a list of all enumeration objects for this enumeration.
	 		     *
	 		     * @return A list of all enumeration objects for this enumeration.
	 		     */
	 		'''
	 		indent(1)
	 		'''
	 		    public static List<
	 		«enumerator.Name»> allEnums() {
	 		'''
	 		indent(4)
	 		'''
	 		      LinkedList<
	 		«enumerator.Name»> all = new LinkedList<
	 		«enumerator.Name»>();
	 		'''
	 		for(enumvalue:enumerator.iterateEnumValue){
	 			'''
	 			        all.add(new 
	 			«parent.Name»(
	 			«enumvalue.OrdinalNumber»));
	 			'''
	 		}
	 		//EnumValue
	 		'''
	 		      return all;
	 		'''
	 		indent(4)
	 		'''
	 		    }
	 		
	 		    /**
	 		'''
	 		indent(1)
	 		'''
	 		     * Returns The title of this enumeration.
	 		     *
	 		     * @return The title of this enumeration.
	 		     */
	 		'''
	 		indent(1)
	 		'''
	 		    @Override
	 		    public String toString() {
	 		'''
	 		indent(4)
	 		'''
	 		      return toTitle(currentValue);
	 		'''
	 		indent(4)
	 		'''
	 		    }
	 		'''
	 		indent(4)
	 		'''
	 		  }
	 		'''
	 	}
	 	endfile
	 	'''«context.toString»'''
	 }
}