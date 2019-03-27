package com.websystique.springbatch;

import org.springframework.batch.item.ItemProcessor;

import com.websystique.springbatch.model.ExamResult;

public class ExamResultItemProcessor implements ItemProcessor<ExamResult, ExamResult>{
       private String memberID;
       
	
	public String getMemberID() {
		return memberID;
	}


	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}


	public ExamResult process(ExamResult result) throws Exception {
		System.out.println("Processing result :"+result);
		System.out.println(getMemberID());
		
		/*
		 * Only return results which are more than 80%
		 * 
		 */
		if(result.getPercentage() < 80){
			return result;
		}
		
		return null;
	}

}
