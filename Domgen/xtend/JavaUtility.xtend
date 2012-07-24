import GenovaBase

class JavaUtility extends GenovaBase{ 
	XDomain domain
	override call(){
	 	// ----------------------------------------------------
	 	// Copyright (c) 2005-11 Esito AS. All rights reserved.
	 	// Version: 9.0.7-SNAPSHOT. September 23, 2011.
	 	// ----------------------------------------------------
	 	//-----------------------------------------------
	 	// Setting of template variables defining common java properties,
	 	// ie. sub directory structures for Java generation
	 	//-----------------------------------------------
	 	topparent.JavaDirectory = if (!(_EXISTS(domain.JavaDirectory))) "java/" else if (domain.JavaDirectory == "") "" else domain.JavaDirectory + "/"
	 	topparent.TransportDirectory = if (!(_EXISTS(domain.TransportDirectory))) "java/" else if (domain.TransportDirectory == "") "" else domain.TransportDirectory + "/"
	 	topparent.ConverterDirectory = if (!(_EXISTS(domain.ConverterDirectory))) "java/" else if (domain.ConverterDirectory == "") "" else domain.ConverterDirectory + "/"
	 	topparent.CastorMappingDirectory = if (!(_EXISTS(domain.CastorMappingDirectory))) "resources/" else if (domain.CastorMappingDirectory == "") "" else domain.CastorMappingDirectory + "/"
	 	topparent.MappingDirectory = if (!(_EXISTS(domain.MappingDirectory))) "java/" else if (domain.MappingDirectory == "") "" else domain.MappingDirectory + "/"
	 	topparent.WebDirectory = if (!(_EXISTS(domain.WebDirectory))) "webapp/" else if (domain.WebDirectory == "") "" else domain.WebDirectory + "/"
	 	topparent.ConfigDirectory = if (!(_EXISTS(domain.ConfigDirectory))) "config/" else if (domain.ConfigDirectory == "") "" else domain.ConfigDirectory + "/"
	 	topparent.PrintDirectory = if (!(_EXISTS(domain.PrintDirectory))) "print/" else if (domain.PrintDirectory == "") "" else domain.PrintDirectory + "/"
	 	topparent.GeneratedPackage = if (!(_EXISTS(domain.GeneratedPackage))) "generated." else if (domain.GeneratedPackage == "") "" else domain.GeneratedPackage + "."
	 	topparent.SuppressAllWarnings = if (_EXISTS(domain.SuppressAllWarnings)) domain.SuppressAllWarnings else "True"
	 	topparent.GenerateSingleClass = if (_EXISTS(domain.GenerateSingleClass)) domain.GenerateSingleClass else "True"
	 	topparent.GeneratePublicSetGet = if (_EXISTS(domain.GeneratePublicSetGet)) domain.GeneratePublicSetGet else "True"
	 	typedef("suppressAllWarnings",[c|{if(topparent.SuppressAllWarnings == "True"){
	 		'''@SuppressWarnings("all")
	 		'''
	 	}
	 	}])
	 	'''«context.toString»'''
	 }
}