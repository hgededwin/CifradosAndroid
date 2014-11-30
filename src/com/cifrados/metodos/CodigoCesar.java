package com.cifrados.metodos;

public class CodigoCesar {
	
	 Alfabeto alfabeto = new Alfabeto();
	    
	    public char[] Cifrado(char []a){
	        int[] C= new int[a.length];
	        char[] resulcesar=a;
	        String r;
	        int c=-666; 
	        for (int i = 0; i < resulcesar.length; i++) {
	            C[i]=alfabeto.numero(String.valueOf(resulcesar[i]));
	            if(C[i]==-666){
	            	resulcesar[i]=resulcesar[i];
	            }else{
	                if (C[i]==-555) {
	                    c=-555;
	                }else{
	                    c=(C[i]+3)%26;
	                }
	                r=alfabeto.letra(c);
	                resulcesar[i]=r.charAt(0); 
	            }
	        
	        }
	 
	        return resulcesar;
	    }
	    
	    public char[] Descifrado(char []a){
	        int[] C= new int[a.length];
	        char[] resul=a;
	        String r;
	        int c=-666; 
	        for (int i = 0; i < resul.length; i++) {
	            C[i]=alfabeto.numero(String.valueOf(resul[i]));
	            if(C[i]==-666){
	                resul[i]=resul[i];
	            }else{
	                if (C[i]==-555) {
	                    c=-555;
	                }else{
	                    c=(C[i]-3)%26;
	                    if (c<0) {
	                         c=26+c;
	                    }
	                }
	                r=alfabeto.letra(c);
	                resul[i]=r.charAt(0);
	            }
	        }
	 
	        return resul;
	    }
	    

}
