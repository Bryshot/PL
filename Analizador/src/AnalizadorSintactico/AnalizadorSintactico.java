package AnalizadorSintactico;

import AnalizadorLexico.UnidadLexica;
import AnalizadorLexico.AnalizadorLexicoCore;
import AnalizadorLexico.ClaseLexica;
import GestionDeErrores.gestionDeErrores;
import java.io.IOException;
import java.io.Reader;

public class AnalizadorSintactico {
   private UnidadLexica anticipo;
   private AnalizadorLexicoCore alex;
   private gestionDeErrores errores;
   
   public AnalizadorSintactico(Reader input) throws IOException
   {
      errores = new gestionDeErrores();
      alex = new AnalizadorLexicoCore(input);
     // alex.fijaGestionErrores(errores);
      sigToken();
   }
   
   public void Sp() 
   {
      Prog();
      empareja(ClaseLexica.EOF);
   }
   
   private void Prog() 
   {   
     switch(anticipo.clase()) 
     {
         case TINT: case TREAL: case TBOOL:          
             SeccionDesc();
             empareja(ClaseLexica.SEPARADOR);
             SeccionInst();
              break;
         default: 
        	 ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.TREAL,ClaseLexica.TINT, ClaseLexica.TBOOL};
        	 errores.errorSintactico(anticipo.fila(),anticipo.clase(),clasesLexicasPosibles);                                            
     }
   }
   
   private void SeccionDesc() 
   {
      switch(anticipo.clase()) 
      {
      	  case TINT: case TREAL: case TBOOL:
              Descs();
              break;
          default:
        	  ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.TREAL,ClaseLexica.TINT, ClaseLexica.TBOOL};
        	  errores.errorSintactico(anticipo.fila(),anticipo.clase(),clasesLexicasPosibles);                                       
      } 
   }

   private void Descs() 
   {
      switch(anticipo.clase())
      {
       case TREAL:    case TINT: case TBOOL:
    	   Desc();
    	   ReDescs();
           break;
       default:
    	   ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.TREAL,ClaseLexica.TINT, ClaseLexica.TBOOL};
      	   errores.errorSintactico(anticipo.fila(),anticipo.clase(),clasesLexicasPosibles);                                            
      }
   }    
   
   private void ReDescs() 
   {
      switch(anticipo.clase())
      {
       case PCOMA:
    	   empareja(ClaseLexica.PCOMA);
    	   Desc();
    	   ReDescs();
           break;
       case EOF:break;
       default:
    	   ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.PCOMA,ClaseLexica.EOF};
      	   errores.errorSintactico(anticipo.fila(),anticipo.clase(),clasesLexicasPosibles);                                            
      }
   }
   
   private void Desc()
   {
	   switch(anticipo.clase())
	   {
	    case TINT: case TREAL: case TBOOL:
	   		NombreTipo();
	   		empareja(ClaseLexica.IDEN);
	   		break;
	   	default:
	   	 ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.TREAL,ClaseLexica.TINT, ClaseLexica.TBOOL};
    	 errores.errorSintactico(anticipo.fila(),anticipo.clase(),clasesLexicasPosibles);     
	   }
   }
   
   private void NombreTipo()
   {
	   switch(anticipo.clase())
	   {
	   	case TREAL:	empareja(ClaseLexica.TREAL); break;
	   	case TINT: empareja(ClaseLexica.TINT);break;
	   	case TBOOL: empareja(ClaseLexica.TBOOL);break;
	   	default:
	   		ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.TREAL,ClaseLexica.TINT, ClaseLexica.TBOOL};
	   		errores.errorSintactico(anticipo.fila(), anticipo.clase(), clasesLexicasPosibles);
	   }
   }
   
   private void SeccionInst() 
   {
      switch(anticipo.clase()) 
      {
       case IDEN:  
           Insts();
           break;
         
       default:  
    	   ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.IDEN};
      	   errores.errorSintactico(anticipo.fila(),anticipo.clase(),clasesLexicasPosibles);                                    
      }          
   }   
   
   private void Insts() 
   {
     switch(anticipo.clase()) 
     {       
       case IDEN:   
	      Inst();
	      ReInsts();
	      break;
       default:
    	   ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.IDEN};
    	   errores.errorSintactico(anticipo.fila(),anticipo.clase(),clasesLexicasPosibles);                                             
     }
   }
   
   private void ReInsts() 
   {
     switch(anticipo.clase()) 
     {       
       case PCOMA:   
    	  empareja(ClaseLexica.PCOMA);
	      Inst();
	      ReInsts();
	      break;
       case EOF: break;
       default:
    	   ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.PCOMA};
    	   errores.errorSintactico(anticipo.fila(),anticipo.clase(),clasesLexicasPosibles);                                             
     }
   }
   
   private void Inst() 
   {
     switch(anticipo.clase()) 
     {       
       case IDEN:   
        empareja(ClaseLexica.IDEN);
        empareja(ClaseLexica.ASIGNACION);
        E0();
        break;
       default:
    	   ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.IDEN};
      	   errores.errorSintactico(anticipo.fila(),anticipo.clase(),clasesLexicasPosibles);                                            
     }
   }
   
   private void E0()
   {
     switch(anticipo.clase()) 
     {
         case IDEN: case ENT: case REAL: case PAP: case MENOS: case NOT: case TRUE: case FALSE: //Comprobar que son los directores
             E1();
             RE0();
             break;
         default:  
        	 ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.IDEN,ClaseLexica.ENT,
        	 ClaseLexica.REAL, ClaseLexica.PAP,ClaseLexica.MENOS,ClaseLexica.NOT, ClaseLexica.TRUE, ClaseLexica.FALSE}; //Comprobar que son los directores	
        	 errores.errorSintactico(anticipo.fila(),anticipo.clase(),  clasesLexicasPosibles);                                               
     }  
   }
   
   private void RE0() 
   {
      switch(anticipo.clase()) 
      {
          case MAS: case MENOS: 
            Op0();
            E0();
            break;
          case EOF: break;
          default:    
        	  ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.MAS,ClaseLexica.MENOS,ClaseLexica.EOF};
              errores.errorSintactico(anticipo.fila(),anticipo.clase(), clasesLexicasPosibles);                                              
      } 
   }
 
   private void E1() 
   {
     switch(anticipo.clase()) 
     {
     	case IDEN: case ENT: case REAL: case PAP: case MENOS: case NOT: case TRUE: case FALSE: //Comprobar que son los directores
             E2();
             RE1();
             break;
         default:
        	 ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.IDEN,ClaseLexica.ENT,
                	 ClaseLexica.REAL, ClaseLexica.PAP,ClaseLexica.MENOS,ClaseLexica.NOT, ClaseLexica.TRUE, ClaseLexica.FALSE}; //Comprobar que son los directores	
        	 errores.errorSintactico(anticipo.fila(),anticipo.clase(),  clasesLexicasPosibles);                                    
     }  
   }
  
   private void RE1() 
   {
      switch(anticipo.clase())
      {
          case AND: case OR: 
             Op1();
             E2();
             RE1();
             break;
          case EOF:  break;
          default:    
        	  ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.AND,ClaseLexica.OR,ClaseLexica.EOF};
         	 errores.errorSintactico(anticipo.fila(),anticipo.clase(),  clasesLexicasPosibles);                                                    
      } 
   }
   
   private void E2() 
   {
      switch(anticipo.clase()) 
      {
      	  case IDEN: case ENT: case REAL: case PAP: case MENOS: case NOT: case TRUE: case FALSE: //Comprobar que son los directores
        	  E3();
        	  RE2();
          default:     
        	  ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.IDEN,ClaseLexica.ENT,
                 	 ClaseLexica.REAL, ClaseLexica.PAP,ClaseLexica.MENOS,ClaseLexica.NOT, ClaseLexica.TRUE, ClaseLexica.FALSE}; //Comprobar que son los directores	
         	  errores.errorSintactico(anticipo.fila(),anticipo.clase(),  clasesLexicasPosibles);
      }   
   }
   
   private void RE2()
   {
	  switch(anticipo.clase()) 
	  {
       case IGUAL: case NEQ: case GT: case GE: case LE: case LT: 
    	   Op2();
    	   E3();
	       RE2();
       case EOF: break;
	   default:     
		   ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.IGUAL,ClaseLexica.NEQ, ClaseLexica.GT, ClaseLexica.GE,ClaseLexica.LE,ClaseLexica.LT,ClaseLexica.EOF};
		   errores.errorSintactico(anticipo.fila(),anticipo.clase(),  clasesLexicasPosibles); 
	   }  
   }
   
   private void E3() 
   {
      switch(anticipo.clase()) 
      {
      	  case IDEN: case ENT: case REAL: case PAP: case MENOS: case NOT: case TRUE: case FALSE: //Comprobar que son los directores
        	  E4();
        	  RE3();
          default:     
        	  ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.IDEN,ClaseLexica.ENT,
                  	 ClaseLexica.REAL, ClaseLexica.PAP,ClaseLexica.MENOS,ClaseLexica.NOT, ClaseLexica.TRUE, ClaseLexica.FALSE}; //Comprobar que son los directores	
         	  errores.errorSintactico(anticipo.fila(),anticipo.clase(),  clasesLexicasPosibles);
      }   
   }
   
   private void RE3()
   {
	  switch(anticipo.clase()) 
	  {
       case POR: case DIV: 
    	   Op3();
    	   E4();
       case EOF: break;
	   default:     
		   ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.POR,ClaseLexica.DIV,ClaseLexica.EOF};
		   errores.errorSintactico(anticipo.fila(),anticipo.clase(),  clasesLexicasPosibles); 
	   }  
   }
   
   private void E4() 
   {
      switch(anticipo.clase()) 
      {
      	  case IDEN: case ENT: case REAL: case PAP: case MENOS: case NOT: case TRUE: case FALSE: case EOF:
        	  Op4();
        	  E5();
          default:     
        	  ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.IDEN,ClaseLexica.ENT,
                   	 ClaseLexica.REAL, ClaseLexica.PAP,ClaseLexica.MENOS,ClaseLexica.NOT, ClaseLexica.TRUE, ClaseLexica.FALSE};
         	 errores.errorSintactico(anticipo.fila(),anticipo.clase(),  clasesLexicasPosibles);
      }   
   }
   
   private void E5() 
   {
      switch(anticipo.clase()) 
      {
          case IDEN:empareja(ClaseLexica.IDEN); break;
          case TRUE:empareja(ClaseLexica.TRUE); break;
          case FALSE:empareja(ClaseLexica.FALSE); break;
          case ENT:empareja(ClaseLexica.ENT); break;
          case REAL:empareja(ClaseLexica.REAL); break;
          case PAP:
        	  	empareja(ClaseLexica.PAP);
        	  	E0();
        	  	empareja(ClaseLexica.PCIERRE);
        	  	break;
          default:     
        	  ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.IDEN,ClaseLexica.ENT, ClaseLexica.REAL, ClaseLexica.PAP,ClaseLexica.TRUE, ClaseLexica.FALSE};
         	 errores.errorSintactico(anticipo.fila(),anticipo.clase(),  clasesLexicasPosibles);
      }   
   }
   
   private void Op0() 
   {
     switch(anticipo.clase())
     {
         case MAS: empareja(ClaseLexica.MAS); break;  
         case MENOS: empareja(ClaseLexica.MENOS); break;  
         default:    
        	 ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.MAS,ClaseLexica.MENOS};
        	 errores.errorSintactico(anticipo.fila(),anticipo.clase(),clasesLexicasPosibles);
     }  
   }
   
   private void Op1() 
   {
     switch(anticipo.clase()) 
     {
         case AND: empareja(ClaseLexica.AND); break;  
         case OR: empareja(ClaseLexica.OR); break;  
         default:    
        	 ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.AND,ClaseLexica.OR};
        	 errores.errorSintactico(anticipo.fila(),anticipo.clase(),clasesLexicasPosibles);
     }  
   }
   
   private void Op2() 
   {
     switch(anticipo.clase()) 
     {
         case IGUAL: empareja(ClaseLexica.POR); break;  
         case NEQ: empareja(ClaseLexica.DIV); break;  
         case GT: empareja(ClaseLexica.GT); break;  
         case GE: empareja(ClaseLexica.GE); break;  
         case LE: empareja(ClaseLexica.LE); break;  
         case LT: empareja(ClaseLexica.LT); break;  
         default:    
        	 ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.POR,ClaseLexica.DIV, ClaseLexica.GT,ClaseLexica.GE,ClaseLexica.LE, ClaseLexica.LT};
        	 errores.errorSintactico(anticipo.fila(),anticipo.clase(),clasesLexicasPosibles);
     }  
   }
  
   private void Op3() 
   {
     switch(anticipo.clase()) 
     {
         case POR: empareja(ClaseLexica.POR); break;  
         case DIV: empareja(ClaseLexica.DIV); break;  
         default:    
        	 ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.POR,ClaseLexica.DIV};
        	 errores.errorSintactico(anticipo.fila(),anticipo.clase(),clasesLexicasPosibles);
     }  
   }
   
   private void Op4() 
   {
     switch(anticipo.clase()) 
     {
         case MENOS: empareja(ClaseLexica.MENOS); break;  
         case NOT: empareja(ClaseLexica.NOT); break; 
         case EOF: break;
         default:    
        	 ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.MENOS,ClaseLexica.NOT,ClaseLexica.EOF};
        	 errores.errorSintactico(anticipo.fila(),anticipo.clase(),clasesLexicasPosibles);
     }  
   }
   
   private void empareja(ClaseLexica claseEsperada) 
   {
      if (anticipo.clase() == claseEsperada) sigToken();
      else
      {	  
    	  ClaseLexica[] clase= {claseEsperada};
    	  errores.errorSintactico(anticipo.fila(),anticipo.clase(),clase);
      }
   }
   private void sigToken() {
      try {
        anticipo = alex.sigToken();//yylex no se que coño es
      }
      catch(IOException e) {
        errores.errorFatal(e);
      }
   }
   
}

