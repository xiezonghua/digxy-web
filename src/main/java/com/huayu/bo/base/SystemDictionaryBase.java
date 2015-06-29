package com.huayu.bo.base;


public class SystemDictionaryBase {
	/**
	*  KEY ID
	*/
	private Integer id ; 

	/**
	*  dict type id 
	*/
	private Byte typeId ; 

	/**
	*  dict type name
	*/
	private String typeName ; 

	/**
	*  business description
	*/
	private String typeDesc ; 

	/**
	*  some have parent 
	*/
	private Byte superiorId ; 

	/**
	*  what type in dictionary
	*/
	private Byte typeCode ; 


	public void setId(Integer id){
		this.id = id;
	} 

	public Integer getId(){
		return id;
	}  

	public void setTypeId(Byte typeId){
		this.typeId = typeId;
	} 

	public Byte getTypeId(){
		return typeId;
	}  

	public void setTypeName(String typeName){
		this.typeName = typeName;
	} 

	public String getTypeName(){
		return typeName;
	}  

	public void setTypeDesc(String typeDesc){
		this.typeDesc = typeDesc;
	} 

	public String getTypeDesc(){
		return typeDesc;
	}  

	public void setSuperiorId(Byte superiorId){
		this.superiorId = superiorId;
	} 

	public Byte getSuperiorId(){
		return superiorId;
	}  

	public void setTypeCode(Byte typeCode){
		this.typeCode = typeCode;
	} 

	public Byte getTypeCode(){
		return typeCode;
	}  

}