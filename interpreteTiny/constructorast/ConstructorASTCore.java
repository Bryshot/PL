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
   private E mkexp(int op, E opnd1, E opnd2){
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
{if ("" != null) return ast;}
    throw new Error("Missing return statement in function");
  }

  final public Prog Programa() throws ParseException {LDs aOfLDs;LIs aOfLIs;
    aOfLDs = LDec();
    jj_consume_token(15);
    aOfLIs = LInst();
{if ("" != null) return as.Programa(aOfLDs,aOfLIs);}
    throw new Error("Missing return statement in function");
  }

  final public LIs LInst() throws ParseException {Inst d; LIs aOfRLIs;
    d = I();
    aOfRLIs = RLIs(as.LSimple(d));
{if ("" != null) return aOfRLIs;}
    throw new Error("Missing return statement in function");
  }

  final public LIs RLIs(LIs ahOfRLIs0) throws ParseException {Inst d; LIs aOfRLIs1;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 16:{
      jj_consume_token(16);
      d = I();
      aOfRLIs1 = RLIs(as.LCompuesta(ahOfRLIs0,d));
{if ("" != null) return aOfRLIs1;}
      break;
      }
    default:
      jj_la1[0] = jj_gen;
{if ("" != null) return ahOfRLIs0;}
    }
    throw new Error("Missing return statement in function");
  }

  final public Inst I() throws ParseException {Token id;
    id = jj_consume_token(identificador);
    jj_consume_token(17);
    aOfE0 = E0();
{if ("" != null) return as.asig(id.image,aOfE0);}
    throw new Error("Missing return statement in function");
  }

  final public LDs LDec() throws ParseException {Dec d; LDs aOfRLDs;
    d = D();
    aOfRLDs = RLDs(as.cSimple(d));
{if ("" != null) return aOfRLDs;}
    throw new Error("Missing return statement in function");
  }

  final public LDs RLDs(LDs ahOfRLDs0) throws ParseException {Dec d; LDs aOfRLDs1;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 16:{
      jj_consume_token(16);
      d = D();
      aOfRLDs1 = RLDs(as.cCompuesta(ahOfRLDs0,d));
{if ("" != null) return aOfRLDs1;}
      break;
      }
    default:
      jj_la1[1] = jj_gen;
{if ("" != null) return ahOfRLDs0;}
    }
    throw new Error("Missing return statement in function");
  }

  final public Dec D() throws ParseException {Token id;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case Real:{
      id = jj_consume_token(Real);
      aOfE0 = E0();
{if ("" != null) return as.decReal(aOfE0);}
      break;
      }
    case Int:{
      id = jj_consume_token(Int);
      aOfE0 = E0();
{if ("" != null) return as.decInt(aOfE0);}
      break;
      }
    case Boolean:{
      id = jj_consume_token(Boolean);
      aOfE0 = E0();
{if ("" != null) return  as.decBool(aOfE0);}
      break;
      }
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public E E0() throws ParseException {E aOfE1,aOfRE0;
    aOfE1 = E1();
    aOfRE0 = RE0(aOfE1);
{if ("" != null) return aOfRE0;}
    throw new Error("Missing return statement in function");
  }

  final public E RE0(E ahOfRE0) throws ParseException {E aOfRE0;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 18:{
      jj_consume_token(18);
      aOfE0 = E0();
{if ("" != null) return mkexp(MAS,ahOfRE0,aOfE0) ;}
      break;
      }
    case 19:{
      jj_consume_token(19);
      aOfE0 = E1();
{if ("" != null) return mkexp(MENOS,ahOfRE0,aOfE0);}
      break;
      }
    default:
      jj_la1[3] = jj_gen;
{if ("" != null) return ahOfRE0;}
    }
    throw new Error("Missing return statement in function");
  }

  final public E E1() throws ParseException {E aOfE2,aOfRE1;
    aOfE2 = E2();
    aOfRE1 = RE1(aOfE2);
{if ("" != null) return aOfRE1;}
    throw new Error("Missing return statement in function");
  }

  final public E RE1(E ahOfRE1) throws ParseException {int op1; E aOfE2; E aOfRE1;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 23:
    case 24:{
      op1 = OP1();
      aOfE2 = E2();
      aOfRE1 = RE1(mkexp(op1,ahOfRE1,aOfE2));
{if ("" != null) return aOfRE1;}
      break;
      }
    default:
      jj_la1[4] = jj_gen;
{if ("" != null) return ahOfRE1;}
    }
    throw new Error("Missing return statement in function");
  }

  final public E E2() throws ParseException {E aOfE3,aOfRE2;
    aOfE3 = E3();
    aOfRE2 = RE2(aOfE1);
{if ("" != null) return aOfRE2;}
    throw new Error("Missing return statement in function");
  }

  final public E RE2(E ahOfRE2) throws ParseException {int op2; E aOfE3; E aOfRE2;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 25:
    case 26:
    case 27:
    case 28:
    case 29:
    case 30:{
      op2 = OP2();
      aOfE3 = E3();
      aOfRE2 = RE2(mkexp(op2,ahOfRE2,aOfE3));
{if ("" != null) return aOfRE3;}
      break;
      }
    default:
      jj_la1[5] = jj_gen;
{if ("" != null) return ahOfRE3;}
    }
    throw new Error("Missing return statement in function");
  }

  final public E E3() throws ParseException {E aOfE4,aOfRE3;
    aOfE4 = E4();
    aOfRE3 = RE3(aOfE4);
{if ("" != null) return aOfRE3;}
    throw new Error("Missing return statement in function");
  }

  final public E RE3(E ahOfRE3) throws ParseException {int op3; E aOfE4;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 31:
    case 32:{
      op3 = OP3();
      aOfE4 = E4();
mkexp(op0,ahOfRE3,aOfE4) ;
      break;
      }
    default:
      jj_la1[6] = jj_gen;
{if ("" != null) return ahOfRE3;}
    }
    throw new Error("Missing return statement in function");
  }

  final public E E4() throws ParseException {E aOfE5;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 19:{
      jj_consume_token(19);
      aOfE5 = E5();
{if ("" != null) return as.negacion(aOfE5);}
      break;
      }
    case 20:{
      jj_consume_token(20);
      aOfE5 = E5();
{if ("" != null) return as.not(aOfE5);}
      break;
      }
    default:
      jj_la1[7] = jj_gen;
{if ("" != null) return E5();}
    }
    throw new Error("Missing return statement in function");
  }

  final public E E5() throws ParseException {Token t; E aOfE0;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case numeroEntero:{
      t = jj_consume_token(numeroEntero);
{if ("" != null) return as.entero(t.image);}
      break;
      }
    case numeroReal:{
      t = jj_consume_token(numeroReal);
{if ("" != null) return as.real(t.image);}
      break;
      }
    case identificador:{
      t = jj_consume_token(identificador);
{if ("" != null) return as.var(t.image);}
      break;
      }
    case trueFalse:{
      t = jj_consume_token(trueFalse);
{if ("" != null) return as.trueFalse(t.image);}
      break;
      }
    case 21:{
      jj_consume_token(21);
      aOfE0 = E0();
      jj_consume_token(22);
{if ("" != null) return aOfE0;}
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
    case 23:{
      jj_consume_token(23);
{if ("" != null) return AND;}
      break;
      }
    case 24:{
      jj_consume_token(24);
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
    case 25:{
      jj_consume_token(25);
{if ("" != null) return EQ;}
      break;
      }
    case 26:{
      jj_consume_token(26);
{if ("" != null) return NE;}
      break;
      }
    case 27:{
      jj_consume_token(27);
{if ("" != null) return GT;}
      break;
      }
    case 28:{
      jj_consume_token(28);
{if ("" != null) return GE;}
      break;
      }
    case 29:{
      jj_consume_token(29);
{if ("" != null) return LT;}
      break;
      }
    case 30:{
      jj_consume_token(30);
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
    case 31:{
      jj_consume_token(31);
{if ("" != null) return POR;}
      break;
      }
    case 32:{
      jj_consume_token(32);
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
      jj_la1_0 = new int[] {0x10000,0x10000,0xe00,0xc0000,0x1800000,0x7e000000,0x80000000,0x180000,0x207100,0x1800000,0x7e000000,0x80000000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x1,0x0,0x0,0x0,0x0,0x1,};
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
    boolean[] la1tokens = new boolean[33];
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
    for (int i = 0; i < 33; i++) {
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
