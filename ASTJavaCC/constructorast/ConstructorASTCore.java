/* ConstructorASTCore.java */
/* Generated By:JavaCC: Do not edit this line. ConstructorASTCore.java */
package constructorast;

import ast.*;

public class ConstructorASTCore implements ConstructorASTCoreConstants {
   private ASCore as = new ASCore();
   private final static int MAS=0;
   private final static int MENOS=1;
   private final static int POR=2;
   private final static int DIV=3;
   private final static int AND=4;
   private final static int OR=5;
   private final static int EQ=6;
   private final static int NE=7;
   private final static int GT=8;
   private final static int GE=9;
   private final static int LT=10;
   private final static int LE=11;
   public E mkexp(int op, E opnd1, E opnd2){
     switch(op) {
      case MAS: return as.suma(opnd1,opnd2);
      case MENOS: return as.resta(opnd1,opnd2);
      case POR: return as.mul(opnd1,opnd2);
      case DIV: return as.div(opnd1,opnd2);
      case AND: return as.and(opnd1,opnd2);
      case OR: return as.or(opnd1,opnd2);
      case EQ: return as.eq(opnd1,opnd2);
      case NE: return as.ne(opnd1,opnd2);
      case GT: return as.gt(opnd1,opnd2);
      case GE: return as.ge(opnd1,opnd2);
      case LT: return as.lt(opnd1,opnd2);
      case LE: return as.le(opnd1,opnd2);
      default: return null;
     }
   }

  final public Prog Sp() throws ParseException {Prog ast;
    ast = Programa();
    jj_consume_token(0);
System.out.println(ast.toString()); {if ("" != null) return ast;}
    throw new Error("Missing return statement in function");
  }

  final public Prog Programa() throws ParseException {LDs aDeLDs; LIs aDeLIs;
    aDeLDs = LDec();
    jj_consume_token(Separador);
    aDeLIs = LInst();
{if ("" != null) return as.programa(aDeLDs, aDeLIs);}
    throw new Error("Missing return statement in function");
  }

  final public LDs LDec() throws ParseException {Dec aDeDec; LDs aDeRLDs;
    aDeDec = D();
    aDeRLDs = RLDs(as.dSimple(aDeDec));
{if ("" != null) return aDeRLDs;}
    throw new Error("Missing return statement in function");
  }

  final public LDs RLDs(LDs ahDeRLDs0) throws ParseException {Dec aDeDec; LDs aDeRLDs1;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case PComa:{
      jj_consume_token(PComa);
      aDeDec = D();
      aDeRLDs1 = RLDs(as.dCompuesta(ahDeRLDs0, aDeDec));
{if ("" != null) return aDeRLDs1;}
      break;
      }
    default:
      jj_la1[0] = jj_gen;

{if ("" != null) return ahDeRLDs0;}
    }
    throw new Error("Missing return statement in function");
  }

  final public Dec D() throws ParseException {Token tipo; Token id;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case TReal:{
      tipo = jj_consume_token(TReal);
      id = jj_consume_token(NombreVariable);
{if ("" != null) return as.decReal(id.image);}
      break;
      }
    case TEnt:{
      tipo = jj_consume_token(TEnt);
      id = jj_consume_token(NombreVariable);
{if ("" != null) return as.decInt(id.image);}
      break;
      }
    case TBool:{
      tipo = jj_consume_token(TBool);
      id = jj_consume_token(NombreVariable);
{if ("" != null) return as.decBool(id.image);}
      break;
      }
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public LIs LInst() throws ParseException {Inst aDeInst; LIs aDeRLIs;
    aDeInst = I();
    aDeRLIs = RLIs(as.lSimple(aDeInst));
{if ("" != null) return aDeRLIs;}
    throw new Error("Missing return statement in function");
  }

  final public LIs RLIs(LIs ahDeRLIs0) throws ParseException {Inst aDeInst; LIs aDeRLIs1;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case PComa:{
      jj_consume_token(PComa);
      aDeInst = I();
      aDeRLIs1 = RLIs(as.lCompuesta(ahDeRLIs0, aDeInst));
{if ("" != null) return aDeRLIs1;}
      break;
      }
    default:
      jj_la1[2] = jj_gen;

{if ("" != null) return ahDeRLIs0;}
    }
    throw new Error("Missing return statement in function");
  }

  final public Inst I() throws ParseException {Token id; E aDeE0;
    id = jj_consume_token(NombreVariable);
    jj_consume_token(Asig);
    aDeE0 = E0();
{if ("" != null) return as.asig(id.image, aDeE0);}
    throw new Error("Missing return statement in function");
  }

  final public E E0() throws ParseException {E aDeE1; E aDeRE0;
    aDeE1 = E1();
    aDeRE0 = RE0(aDeE1);
{if ("" != null) return aDeRE0;}
    throw new Error("Missing return statement in function");
  }

  final public E RE0(E ahDeRE0) throws ParseException {E aDeE;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case Mas:{
      jj_consume_token(Mas);
      aDeE = E0();
{if ("" != null) return mkexp(MAS, ahDeRE0, aDeE);}
      break;
      }
    case Menos:{
      jj_consume_token(Menos);
      aDeE = E1();
{if ("" != null) return mkexp(MENOS, ahDeRE0, aDeE);}
      break;
      }
    default:
      jj_la1[3] = jj_gen;

{if ("" != null) return ahDeRE0;}
    }
    throw new Error("Missing return statement in function");
  }

  final public E E1() throws ParseException {E aDeE2; E aDeRE1;
    aDeE2 = E2();
    aDeRE1 = RE1(aDeE2);
{if ("" != null) return aDeRE1;}
    throw new Error("Missing return statement in function");
  }

  final public E RE1(E ahDeRE1) throws ParseException {int op1; E aDeE2; E aDeRE1;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case And:
    case Or:{
      op1 = OP1();
      aDeE2 = E2();
      aDeRE1 = RE1(mkexp(op1, ahDeRE1, aDeE2));
{if ("" != null) return aDeRE1;}
      break;
      }
    default:
      jj_la1[4] = jj_gen;

{if ("" != null) return ahDeRE1;}
    }
    throw new Error("Missing return statement in function");
  }

  final public E E2() throws ParseException {E aDeE3; E aDeRE2;
    aDeE3 = E3();
    aDeRE2 = RE2(aDeE3);
{if ("" != null) return aDeRE2;}
    throw new Error("Missing return statement in function");
  }

  final public E RE2(E ahDeRE2) throws ParseException {int op2; E aDeE3; E aDeRE2;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case EQ:
    case LT:
    case GT:
    case GE:
    case LE:
    case NE:{
      op2 = OP2();
      aDeE3 = E3();
      aDeRE2 = RE2(mkexp(op2, ahDeRE2, aDeE3));
{if ("" != null) return aDeRE2;}
      break;
      }
    default:
      jj_la1[5] = jj_gen;

{if ("" != null) return ahDeRE2;}
    }
    throw new Error("Missing return statement in function");
  }

  final public E E3() throws ParseException {E aDeE4; E aDeRE3;
    aDeE4 = E4();
    aDeRE3 = RE3(aDeE4);
{if ("" != null) return aDeRE3;}
    throw new Error("Missing return statement in function");
  }

  final public E RE3(E ahDeRE3) throws ParseException {int op3; E aDeE4;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case Div:
    case Por:{
      op3 = OP3();
      aDeE4 = E4();
{if ("" != null) return mkexp(op3, ahDeRE3, aDeE4);}
      break;
      }
    default:
      jj_la1[6] = jj_gen;

{if ("" != null) return ahDeRE3;}
    }
    throw new Error("Missing return statement in function");
  }

  final public E E4() throws ParseException {E aDeE;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case Menos:{
      jj_consume_token(Menos);
      aDeE = E5();
{if ("" != null) return as.negacion(aDeE);}
      break;
      }
    case Not:{
      jj_consume_token(Not);
      aDeE = E4();
{if ("" != null) return as.not(aDeE);}
      break;
      }
    case True:
    case False:
    case PAper:
    case NombreVariable:
    case NumEnt:
    case NumReal:{
      aDeE = E5();
{if ("" != null) return aDeE;}
      break;
      }
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public E E5() throws ParseException {Token t; E aDeE0;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case NumEnt:{
      t = jj_consume_token(NumEnt);
{if ("" != null) return as.entero(t.image);}
      break;
      }
    case NumReal:{
      t = jj_consume_token(NumReal);
{if ("" != null) return as.real(t.image);}
      break;
      }
    case True:{
      t = jj_consume_token(True);
{if ("" != null) return as.trueFalse(t.image);}
      break;
      }
    case False:{
      t = jj_consume_token(False);
{if ("" != null) return as.trueFalse(t.image);}
      break;
      }
    case NombreVariable:{
      t = jj_consume_token(NombreVariable);
{if ("" != null) return as.var(t.image);}
      break;
      }
    case PAper:{
      jj_consume_token(PAper);
      aDeE0 = E0();
      jj_consume_token(PCie);
{if ("" != null) return aDeE0;}
      break;
      }
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public int OP1() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case And:{
      jj_consume_token(And);
{if ("" != null) return AND;}
      break;
      }
    case Or:{
      jj_consume_token(Or);
{if ("" != null) return OR;}
      break;
      }
    default:
      jj_la1[9] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public int OP2() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case EQ:{
      jj_consume_token(EQ);
{if ("" != null) return EQ;}
      break;
      }
    case NE:{
      jj_consume_token(NE);
{if ("" != null) return NE;}
      break;
      }
    case GT:{
      jj_consume_token(GT);
{if ("" != null) return GT;}
      break;
      }
    case GE:{
      jj_consume_token(GE);
{if ("" != null) return GE;}
      break;
      }
    case LT:{
      jj_consume_token(LT);
{if ("" != null) return LT;}
      break;
      }
    case LE:{
      jj_consume_token(LE);
{if ("" != null) return LE;}
      break;
      }
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public int OP3() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case Por:{
      jj_consume_token(Por);
{if ("" != null) return POR;}
      break;
      }
    case Div:{
      jj_consume_token(Div);
{if ("" != null) return DIV;}
      break;
      }
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  /** Generated Token Manager. */
  public ConstructorASTCoreTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[12];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x10000000,0x7000,0x10000000,0xc0000000,0x28000,0xfc00000,0x0,0x801d0000,0x1c0000,0x28000,0xfc00000,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x3,0x38,0x38,0x0,0x0,0x3,};
   }

  /** Constructor with InputStream. */
  public ConstructorASTCore(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public ConstructorASTCore(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ConstructorASTCoreTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public ConstructorASTCore(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ConstructorASTCoreTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public ConstructorASTCore(ConstructorASTCoreTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ConstructorASTCoreTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk_f() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[38];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 12; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 38; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
