package com.huayu.constant;

public class ProjectConst {
	public enum RoleType{
		SPONSOR((byte)1) , PARTICIPANT((byte)2) , PATRONAGE((byte)3);
		
		private Byte value;
		
		private RoleType(Byte value){
			this.value = value.byteValue();
		}
		
		public Byte getValue(){
			return value;
		}
	}
	
	public enum ApplyerStatus{
		APPLYING((byte)1) ,PARTICIPATING((byte)2) , COMPLETED((byte)3) , REFUSED((byte)4) ;
		
		private Byte value;
		
		private ApplyerStatus(Byte value){
			this.value = value.byteValue();
		}
		
		public Byte getValue(){
			return value;
		}
	}
	
	public enum ProcessStatus{
		WAITING((byte)1) ,NOT_PASS((byte)2), STARTUP((byte)4) ,PROGRESSING((byte)5) , COMPLETED((byte)6)  ;
		
		private Byte value;
		
		private ProcessStatus(Byte value){
			this.value = value.byteValue();
		}
		
		public Byte getValue(){
			return value;
		}
	}
	
} 
