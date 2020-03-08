package asin;

import alex.UnidadLexica;
import alex.AnalizadorLexicoCore;
import alex.ClaseLexica;
import errores.gestionDeErrores;
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
         case TENT: case TREAL: case TBOOL:          
             SeccionDec();
             empareja(ClaseLexica.SEPARADOR);
             SeccionInst();
              break;
         default: //TODO
        	 ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.TREAL,ClaseLexica.TENT, ClaseLexica.TBOOL};
        	 errores.errorSintactico(anticipo.fila(),anticipo.clase(),clasesLexicasPosibles);                                            
     }
   }
   
   private void SeccionDec() 
   {
      switch(anticipo.clase()) 
      {
      	  case TENT: case TREAL: case TBOOL:
              Decs();
              break;
          default: //TODO
        	  ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.TREAL,ClaseLexica.TENT, ClaseLexica.TBOOL};
        	  errores.errorSintactico(anticipo.fila(),anticipo.clase(),clasesLexicasPosibles);                                       
      } 
   }

   private void Decs() 
   {
      switch(anticipo.clase())
      {
       case TREAL:    case TENT: case TBOOL:
    	   Dec();
    	   ReDecs();
           break;
       default: //TODO
    	   ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.TREAL,ClaseLexica.TENT, ClaseLexica.TBOOL};
      	   errores.errorSintactico(anticipo.fila(),anticipo.clase(),clasesLexicasPosibles);                                            
      }
   }    
   
   private void ReDecs() 
   {
      switch(anticipo.clase())
      {
       case PCOMA:
    	   empareja(ClaseLexica.PCOMA);
    	   Dec();
    	   ReDecs();
           break;
       case SEPARADOR:break;
       default: //TODO
    	   ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.PCOMA,ClaseLexica.SEPARADOR};
      	   errores.errorSintactico(anticipo.fila(),anticipo.clase(),clasesLexicasPosibles);                                            
      }
   }
   
   private void Dec()
   {
	   switch(anticipo.clase())
	   {
	    case TENT: case TREAL: case TBOOL:
	   		NombreTipo();
	   		empareja(ClaseLexica.IDEN);
	   		break;
	   	default: //TODO
	   	 ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.TREAL,ClaseLexica.TENT, ClaseLexica.TBOOL};
    	 errores.errorSintactico(anticipo.fila(),anticipo.clase(),clasesLexicasPosibles);     
	   }
   }
   
   private void NombreTipo()
   {
	   switch(anticipo.clase())
	   {
	   	case TREAL:	empareja(ClaseLexica.TREAL); break;
	   	case TENT: empareja(ClaseLexica.TENT);break;
	   	case TBOOL: empareja(ClaseLexica.TBOOL);break;
	   	default: //TODO
	   		ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.TREAL,ClaseLexica.TENT, ClaseLexica.TBOOL};
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
         
       default: //TODO  
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
       default: //TODO
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
       default: //TODO
    	   ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.PCOMA,ClaseLexica.EOF};
    	   errores.errorSintactico(anticipo.fila(),anticipo.clase(),clasesLexicasPosibles);                                             
     }
   }
   
   private void Inst() 
   {
     switch(anticipo.clase()) 
     {       
       case IDEN:   
        empareja(ClaseLexica.IDEN);
        empareja(ClaseLexica.ASIG);
        E0();
        break;
       default: //TODO
    	   ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.IDEN};
      	   errores.errorSintactico(anticipo.fila(),anticipo.clase(),clasesLexicasPosibles);                                            
     }
   }
   
   private void E0()
   {
     switch(anticipo.clase()) 
     {
     	case MENOS: case IDEN: case NOT: case PAPER: case REAL: case TRUE: case ENT: case FALSE:
             E1();
             RE0();
             break;
         default: //TODO  
        	 ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.IDEN,ClaseLexica.ENT,
        	 ClaseLexica.REAL, ClaseLexica.PAPER,ClaseLexica.MENOS,ClaseLexica.NOT, ClaseLexica.TRUE, ClaseLexica.FALSE};	
        	 errores.errorSintactico(anticipo.fila(),anticipo.clase(),  clasesLexicasPosibles);                                               
     }  
   }
   
   private void RE0() 
   {
      switch(anticipo.clase()) 
      {
          case MAS:
        	empareja(ClaseLexica.MAS);
            E0();
            break;
          case MENOS:
        	empareja(ClaseLexica.MENOS);
            E1();
            break;
          case EOF: case PCIE: case PCOMA: break;
          default: //TODO    
        	  ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.MENOS,ClaseLexica.EOF,ClaseLexica.PCIE,ClaseLexica.PCOMA};
              errores.errorSintactico(anticipo.fila(),anticipo.clase(), clasesLexicasPosibles);                                              
      } 
   }
 
   private void E1() 
   {
     switch(anticipo.clase()) 
     {
     	case IDEN: case ENT: case REAL: case PAPER: case MENOS: case NOT: case TRUE: case FALSE:
             E2();
             RE1();
             break;
         default: //TODO
        	 ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.IDEN,ClaseLexica.ENT,
                	 ClaseLexica.REAL, ClaseLexica.PAPER,ClaseLexica.MENOS,ClaseLexica.NOT, ClaseLexica.TRUE, ClaseLexica.FALSE};	
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
          case EOF: case MENOS: case PCIE: case PCOMA: case MAS: break;
          default: //TODO    
        	  ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.AND,ClaseLexica.OR,ClaseLexica.EOF,ClaseLexica.MENOS,
        			  ClaseLexica.PCIE,ClaseLexica.PCOMA,ClaseLexica.MAS};
         	 errores.errorSintactico(anticipo.fila(),anticipo.clase(),  clasesLexicasPosibles);                                                    
      } 
   }
   
   private void E2() 
   {
      switch(anticipo.clase()) 
      {
      	  case IDEN: case ENT: case REAL: case PAPER: case MENOS: case NOT: case TRUE: case FALSE: 
        	  E3();
        	  RE2();
        	  break;
          default: //TODO     
        	  ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.IDEN,ClaseLexica.ENT,
                 	 ClaseLexica.REAL, ClaseLexica.PAPER,ClaseLexica.MENOS,ClaseLexica.NOT, ClaseLexica.TRUE, ClaseLexica.FALSE}; //Comprobar que son los directores	
         	  errores.errorSintactico(anticipo.fila(),anticipo.clase(),  clasesLexicasPosibles);
      }   
   }
   
   private void RE2()
   {
	  switch(anticipo.clase()) 
	  {
       case EQ: case NE: case GT: case GE: case LE: case LT: 
    	   Op2();
    	   E3();
	       RE2();
	       break;
       case EOF: case OR: case AND: case MENOS: case PCIE: case PCOMA: case MAS: break;
	   default: //TODO     
		   ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.EQ,ClaseLexica.NE,ClaseLexica.GT,ClaseLexica.GE,ClaseLexica.LE,
				   ClaseLexica.LT,ClaseLexica.EOF,ClaseLexica.OR,ClaseLexica.AND,ClaseLexica.MENOS,ClaseLexica.PCIE,
				   ClaseLexica.PCOMA,ClaseLexica.MAS};
		   errores.errorSintactico(anticipo.fila(),anticipo.clase(),  clasesLexicasPosibles); 
	   }  
   }
   
   private void E3() 
   {
      switch(anticipo.clase()) 
      {
      	  case IDEN: case ENT: case REAL: case PAPER: case MENOS: case NOT: case TRUE: case FALSE:
        	  E4();
        	  RE3();
        	  break;
          default: //TODO     
        	  ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.IDEN,ClaseLexica.ENT,
                  	 ClaseLexica.REAL, ClaseLexica.PAPER,ClaseLexica.MENOS,ClaseLexica.NOT, ClaseLexica.TRUE, ClaseLexica.FALSE};
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
    	   break;
       case EOF: case OR: case AND: case MENOS: case PCIE: case PCOMA: case MAS: case LT: case EQ: case GT: case NE: case LE: case GE: break;
	   default: //TODO     
		   ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.POR,ClaseLexica.DIV,ClaseLexica.EOF,ClaseLexica.OR,ClaseLexica.AND,
				   ClaseLexica.MENOS,ClaseLexica.PCIE,ClaseLexica.PCOMA,ClaseLexica.MAS,ClaseLexica.LT,ClaseLexica.EQ,ClaseLexica.GT,
				   ClaseLexica.NE,ClaseLexica.LE,ClaseLexica.GE};
		   errores.errorSintactico(anticipo.fila(),anticipo.clase(),  clasesLexicasPosibles); 
	   }  
   }
   
   private void E4() 
   {
      switch(anticipo.clase()) 
      {
      	  case MENOS:
      		  empareja(ClaseLexica.MENOS);
      		  E5();
      		  break;
      	  case NOT:
      		  empareja(ClaseLexica.NOT);
      		  E4();
      		  break;
      	  case IDEN: case ENT: case REAL: case PAPER: case TRUE: case FALSE:
        	  E5();
        	  break;
          default: //TODO     
        	  ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.IDEN,ClaseLexica.ENT,
                   	 ClaseLexica.REAL, ClaseLexica.PAPER,ClaseLexica.MENOS,ClaseLexica.NOT, ClaseLexica.TRUE, ClaseLexica.FALSE};
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
          case PAPER:
        	  	empareja(ClaseLexica.PAPER);
        	  	E0();
        	  	empareja(ClaseLexica.PCIE);
        	  	break;
          default: //TODO     
        	  ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.IDEN,ClaseLexica.ENT, ClaseLexica.REAL, ClaseLexica.PAPER,ClaseLexica.TRUE, ClaseLexica.FALSE};
         	 errores.errorSintactico(anticipo.fila(),anticipo.clase(),  clasesLexicasPosibles);
      }   
   }
   
   private void Op1() 
   {
     switch(anticipo.clase()) 
     {
         case AND: empareja(ClaseLexica.AND); break;  
         case OR: empareja(ClaseLexica.OR); break;  
         default: //TODO    
        	 ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.AND,ClaseLexica.OR};
        	 errores.errorSintactico(anticipo.fila(),anticipo.clase(),clasesLexicasPosibles);
     }  
   }
   
   private void Op2() 
   {
     switch(anticipo.clase()) 
     {
         case EQ: empareja(ClaseLexica.EQ); break;  
         case NE: empareja(ClaseLexica.NE); break;  
         case GT: empareja(ClaseLexica.GT); break;  
         case GE: empareja(ClaseLexica.GE); break;  
         case LE: empareja(ClaseLexica.LE); break;  
         case LT: empareja(ClaseLexica.LT); break;  
         default: //TODO    
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
         default: //TODO    
        	 ClaseLexica[] clasesLexicasPosibles = {ClaseLexica.POR,ClaseLexica.DIV};
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
        anticipo = alex.sigToken();
      }
      catch(IOException e) {
        errores.errorFatal(e);
      }
   }
   
}

