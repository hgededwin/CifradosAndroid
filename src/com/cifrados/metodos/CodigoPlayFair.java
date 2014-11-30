package com.cifrados.metodos;

public class CodigoPlayFair {
	
	 ValidarClave validarK = new ValidarClave();
	    ValidarPatron validPat = new ValidarPatron();
	    Bloques addBloques = new Bloques();
	    
	    public char[] Cifrado(char []a, char []k){
	        
	        int tamResul=0, contK=1, tamK=k.length, contAlf=0, tamAlf=25, fin=0;
	        
	        char[] resulplayfair = new char[25];
	        String datos = "abcdefghiklmnopqrstuvwxyz";
	        String letra = "ji";
	        char[] clave1= new char[tamK];
	        char[] clave2= new char[tamK];
	        char[][] matriz= new char[5][5];
	        
	        /////////// CAMBAMOS LA J POR LA I ///////
	        System.out.print("\nClave (I/J): ");
	        for (int i = 0; i < tamK; i++) {
	            if (k[i]==letra.charAt(0)) {
	                clave1[i]=letra.charAt(1);
	            }else{
	                clave1[i]=k[i];
	            }
	            System.out.print(""+clave1[i]);
	        }
	        
	        /////////// VERIFICAMOS LA CLAVE //////
	        clave2=validarK.validarClave(clave1);
	        int error = validarK.error(clave1);

	        ////////// IDENTIFICAMOS LOS VALORES DE LA MATRIZ //////
	        for (int i = 0; i < 25; i++) {
	            if (tamResul==0) {
	            	resulplayfair[i]=clave2[0];
	                tamResul++;
	            }else if (contK<(tamK-error)) {
	                int j=0;
	                while(j < tamResul) {
	                    if(contK==(tamK-error)){
	                        j=tamResul;
	                        fin=1;
	                    }else if (resulplayfair[j]==clave2[contK]) {
	                        contK++;
	                        j=0;
	                    }else{
	                        j++;
	                    } 
	                }
	                if(fin==0){
	                	resulplayfair[i]=clave2[contK];
	                    contK++;
	                    tamResul++;
	                }else{
	                    i--;
	                }
	            }else if(contAlf<tamAlf){
	                int j=0;
	                while(j < tamResul) {
	                    if (resulplayfair[j]==(datos.charAt(contAlf))) {
	                        contAlf++;
	                        j=0;
	                    }else{
	                        j++;
	                    } 
	                }
	                resulplayfair[i]=datos.charAt(contAlf);
	                contAlf++;
	                tamResul++;
	            }
	        }
	        
	        System.out.println("\nMatriz:");
	        int band=0;
	        for (int i = 0; i < 5; i++) {
	            for (int j = 0; j < 5; j++) {
	                matriz[i][j]=resulplayfair[band];
	                band++;
	                System.out.print(""+matriz[i][j]+" ");
	            }
	            System.out.println("");
	        }
	        
	        ///////////////// OBTENER PATRON MODIFICADO /////////
	        System.out.print("El Patron es: ");
	        for (int i = 0; i < a.length; i++) {
	            System.out.print(""+a[i]);
	        }
	        int errorPI = validPat.error(a);
	        char[] patronInicial = new char[a.length];
	        patronInicial = validPat.validarPatron(a);
	        int tamPV = patronInicial.length-errorPI;
	        char[] patronvalidado = new char[tamPV];
	        
	        for (int i = 0; i < tamPV; i++) {
	            patronvalidado[i]=patronInicial[i];
	        }
	        
	        int tamPatron = addBloques.tamBloques(2, patronvalidado);
	        char[] patron = new char[tamPatron];
	        patron=addBloques.bloques(2, patronvalidado);
	        System.out.print("\nEl patron Modificado es:");
	        for (int i = 0; i < patron.length; i=i+2) {
	            System.out.print(" "+patron[i]+""+patron[i+1]);
	        }
	        
	        ///////////// PROPIEDADES DEL CIFRADO USANDO LA MATRIZ ///////////////
	        char[] resul2 = new char[patron.length];
	        int m=0, fila1=0, columna1=0, fila2=0, columna2=0;
	        
	        while (m<patron.length) {
	            for (int i1 = 0; i1 < 5; i1++) {
	                for (int j1 = 0; j1 < 5; j1++) {
	                    if (patron[m]==matriz[i1][j1]) {
	                        fila1=i1;
	                        columna1=j1;
	                        j1=5;
	                        i1=5;
	                    }
	                }
	            }
	            for (int i2 = 0; i2 < 5; i2++) {
	                for (int j2 = 0; j2 < 5; j2++) {
	                    if (patron[m+1]==matriz[i2][j2]) {
	                        fila2=i2;
	                        columna2=j2;
	                        j2=5;
	                        i2=5;
	                    }
	                }
	            }
	            if (fila1==fila2) {
	                resul2[m]=matriz[fila1][(columna1+1)%5];
	                resul2[m+1]=matriz[fila2][(columna2+1)%5];
	            }else if (columna1==columna2) {
	                resul2[m]=matriz[(fila1+1)%5][columna1];
	                resul2[m+1]=matriz[(fila2+1)%5][columna2];
	            }else{
	                resul2[m]=matriz[fila1][columna2];
	                resul2[m+1]=matriz[fila2][columna1];
	            }
	            m=m+2;
	        }
	        
	        System.out.print("\nEl patron con Cifrado es:");
	        for (int i = 0; i < resul2.length; i=i+2) {
	            System.out.print(" "+resul2[i]+""+resul2[i+1]);
	        }
	        System.out.println("");
	        
	        return resul2;
	    }
	    
	    
	    public char[] Descifrado(char []a, char []k){
	        
	        int tamResul=0, contK=1, tamK=k.length, contAlf=0, tamAlf=25, fin=0;
	        
	        char[] resul = new char[25];
	        String datos = "abcdefghiklmnopqrstuvwxyz";
	        String letra = "ji";
	        char[] clave1= new char[tamK];
	        char[] clave2= new char[tamK];
	        char[][] matriz= new char[5][5];
	        
	        /////////// CAMBAMOS LA J POR LA I ///////
	        System.out.print("\nClave (I/J): ");
	        for (int i = 0; i < tamK; i++) {
	            if (k[i]==letra.charAt(0)) {
	                clave1[i]=letra.charAt(1);
	            }else{
	                clave1[i]=k[i];
	            }
	            System.out.print(""+clave1[i]);
	        }
	        
	        /////////// VERIFICAMOS LA CLAVE //////
	        clave2=validarK.validarClave(clave1);
	        int error = validarK.error(clave1);

	        ////////// IDENTIFICAMOS LOS VALORES DE LA MATRIZ //////
	        for (int i = 0; i < 25; i++) {
	            if (tamResul==0) {
	                resul[i]=clave2[0];
	                tamResul++;
	            }else if (contK<(tamK-error)) {
	                int j=0;
	                while(j < tamResul) {
	                    if(contK==(tamK-error)){
	                        j=tamResul;
	                        fin=1;
	                    }else if (resul[j]==clave2[contK]) {
	                        contK++;
	                        j=0;
	                    }else{
	                        j++;
	                    } 
	                }
	                if(fin==0){
	                    resul[i]=clave2[contK];
	                    contK++;
	                    tamResul++;
	                }else{
	                    i--;
	                }
	            }else if(contAlf<tamAlf){
	                int j=0;
	                while(j < tamResul) {
	                    if (resul[j]==(datos.charAt(contAlf))) {
	                        contAlf++;
	                        j=0;
	                    }else{
	                        j++;
	                    } 
	                }
	                resul[i]=datos.charAt(contAlf);
	                contAlf++;
	                tamResul++;
	            }
	        }
	        
	        System.out.println("\nMatriz:");
	        int band=0;
	        for (int i = 0; i < 5; i++) {
	            for (int j = 0; j < 5; j++) {
	                matriz[i][j]=resul[band];
	                band++;
	                System.out.print(""+matriz[i][j]+" ");
	            }
	            System.out.println("");
	        }
	        
	        ///////////////// OBTENER PATRON MODIFICADO /////////
	        System.out.print("El Patron es: ");
	        for (int i = 0; i < a.length; i++) {
	            System.out.print(""+a[i]);
	        }
	        int errorPI = validPat.error(a);
	        if(errorPI%2!=0){
	            errorPI=errorPI-1;
	        }
	        char[] patronInicial = new char[a.length];
	        patronInicial = validPat.validarPatron(a);
	        int tamPV = patronInicial.length-(errorPI);
	        char[] patronvalidado = new char[tamPV];
	        
	        for (int i = 0; i < tamPV; i++) {
	            patronvalidado[i]=patronInicial[i];
	        }
	        
	        int tamPatron = addBloques.tamBloques(2, patronvalidado);
	        char[] patron = new char[tamPatron];
	        patron=addBloques.bloques(2, patronvalidado);
	        System.out.print("\nEl patron Modificado es:");
	        for (int i = 0; i < patron.length; i=i+2) {
	            System.out.print(" "+patron[i]+""+patron[i+1]);
	        }
	        
	        ///////////// PROPIEDADES DEL CIFRADO USANDO LA MATRIZ ///////////////
	        char[] resul2 = new char[patron.length];
	        int m=0, fila1=0, columna1=0, fila2=0, columna2=0, indice1=0, indice2=0;
	        
	        while (m<patron.length) {
	            for (int i1 = 0; i1 < 5; i1++) {
	                for (int j1 = 0; j1 < 5; j1++) {
	                    if (patron[m]==matriz[i1][j1]) {
	                        fila1=i1;
	                        columna1=j1;
	                        j1=5;
	                        i1=5;
	                    }
	                }
	            }
	            for (int i2 = 0; i2 < 5; i2++) {
	                for (int j2 = 0; j2 < 5; j2++) {
	                    if (patron[m+1]==matriz[i2][j2]) {
	                        fila2=i2;
	                        columna2=j2;
	                        j2=5;
	                        i2=5;
	                    }
	                }
	            }
	            if (fila1==fila2) {
	                if((columna1-1)<0){
	                    indice1=5+(columna1-1);
	                }
	                if ((columna2-1)<0) {
	                    indice2=5+(columna2-1);
	                }
	                if((columna1-1)>=0){
	                    indice1=columna1-1;
	                }
	                if((columna2-1)>=0){
	                    indice2=columna2-1;
	                }
	                resul2[m]=matriz[fila1][indice1%5];
	                resul2[m+1]=matriz[fila2][indice2%5];
	            }else if (columna1==columna2) {
	                if ((fila1-1)<0){
	                    indice1=5+(fila1-1);
	                }
	                if ((fila2-1)<0) {
	                    indice2=5+(fila2-1);
	                }
	                if ((fila1-1)>=0){
	                    indice1=fila1-1;
	                }
	                if ((fila2-1)>=0){
	                    indice2=fila2-1;
	                }
	                resul2[m]=matriz[indice1%5][columna1];
	                resul2[m+1]=matriz[indice2%5][columna2];
	            }else{
	                resul2[m]=matriz[fila1][columna2];
	                resul2[m+1]=matriz[fila2][columna1];
	            }
	            m=m+2;
	        }
	        
	        System.out.print("\nEl patron Descifrado es:");
	        for (int i = 0; i < resul2.length; i=i+2) {
	            System.out.print(" "+resul2[i]+""+resul2[i+1]);
	        }
	        System.out.println("");
	        
	        return resul2;
	    }
	 

}
