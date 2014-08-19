package com.example.androidbinsearch;

import android.annotation.TargetApi;


@TargetApi(9)
public class DetectError {
	private static String result ="" ;

/**
 * check input values legal 
 * @param inputs
 * @return
 */
    public int [] InputValueCheck(String[] inputs){
    	int size = inputs.length;
		if (size<8 || size>12){
			result ="Input values size is out of bound [8,12].";
			return null;
		} 
		
    	int [] inputIntValue = new int[size];
    	try{
	    	for (int i = 0; i<size;i++){
				inputIntValue[i] = Integer.parseInt(inputs[i]);
				if(0<inputIntValue[i]&inputIntValue[i]<101){
					;
				}else{
					 result ="Inputs values set is out of bound [1,100]!";
					 return null;
				}
			}
    	}
    	catch (Exception e){
    		result ="Please enter integers!";
    		return null;
    	}    	
    	
    	for(int i = 0;i<size;i++){
    		for(int j = 0;j<size;j++){
    			if(i!=j){
	    			if(inputIntValue[i]==inputIntValue[j]){
	    				result ="Input values" +inputIntValue[i]+"is duplicated!";
	    				return null;
	    			}
    			}
    		}
    	}
    	return inputIntValue;
    }    
    /**
     * detect keyValue  error
     * @param keyValue
     * @return
     */
    public boolean keyValueCheck(String keyValue){

    	if(keyValue.equals("0")){
			result = "This program ends!";
			return false;
		}
    	try{
			int keyIntValue = Integer.valueOf(keyValue);
			if(0>keyIntValue || keyIntValue>101){
				 result ="Inputs values set is out of bound [1,100]!";
				 return false;
			}
		
    	}
    	catch (Exception e){
    		result ="Please enter an integer!";
    		return false;
    	}    	
    	return true;
    }   
    /**
     * bubble sort input values
     * @param inputs
     * @return
     */
    public int[] arraySort(int[] inputs){
    	int temp;
    	for(int i=0;i<inputs.length;i++){
    		for(int j = 0;j<inputs.length-i-1;j++){
    			if(inputs[j]>inputs[j+1]){
    				temp = inputs[j];
    				inputs[j]=inputs[j+1];
    				inputs[j+1]=temp;
    			}
    		}
    	}
    	return inputs;
    }

    
    /**
     * binary search
     * @param inputs
     * @param inputsNoSort
     * @param keyValue
     * @return
     */
    public int binSearch(int[] inputs,int[] inputsNoSort, int keyValue)
    {	

      int size = inputs.length;
      int last = inputs.length - 1;
      int first = 0 , middle;
      // while there are still elements to search through
      while (first <= last)
      {
        middle = (first + last) / 2;
        // if current middle value is the search target
        if (inputs[middle] == keyValue)
        {
           // locateTargetIndex(inputsNoSort,keyValue);
        	for(int i = 0;i<size;i++){
    	    		if(inputsNoSort[i]==keyValue){
    	    				result ="Found number "+keyValue+" at index "+i;
    	    			//	return null;
    	    		}
        	}
        	return middle;
        }
        // if current middle value is less than the search target
        else if (inputs[middle] < keyValue)
        {
          first = middle + 1;
        }
        // if current middle value is larger than the search target
        else
        {
          last = middle - 1;
        }
      }
      result ="Not Found!";
      
      // return -1 if search target not found
      return -1;
    }
    /**
     * return search result
     * @return
     */
    public String getResult(){
    	return result;
    }
}
