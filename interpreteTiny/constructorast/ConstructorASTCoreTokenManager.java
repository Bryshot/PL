/* ConstructorASTCoreTokenManager.java */
/* Generated By:JavaCC: Do not edit this line. ConstructorASTCoreTokenManager.java */
package constructorast;
import ast.*;

/** Token Manager. */
@SuppressWarnings("unused")public class ConstructorASTCoreTokenManager implements ConstructorASTCoreConstants {

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0){
   switch (pos)
   {
      case 0:
         if ((active0 & 0x1900e00L) != 0L)
         {
            jjmatchedKind = 12;
            return 12;
         }
         if ((active0 & 0xc0000L) != 0L)
            return 14;
         return -1;
      case 1:
         if ((active0 & 0x1900e00L) != 0L)
         {
            jjmatchedKind = 12;
            jjmatchedPos = 1;
            return 12;
         }
         return -1;
      case 2:
         if ((active0 & 0x400L) != 0L)
            return 12;
         if ((active0 & 0x900a00L) != 0L)
         {
            jjmatchedKind = 12;
            jjmatchedPos = 2;
            return 12;
         }
         return -1;
      case 3:
         if ((active0 & 0x800L) != 0L)
            return 12;
         if ((active0 & 0x200L) != 0L)
         {
            jjmatchedKind = 12;
            jjmatchedPos = 3;
            return 12;
         }
         return -1;
      case 4:
         if ((active0 & 0x200L) != 0L)
         {
            jjmatchedKind = 12;
            jjmatchedPos = 4;
            return 12;
         }
         return -1;
      case 5:
         if ((active0 & 0x200L) != 0L)
         {
            jjmatchedKind = 12;
            jjmatchedPos = 5;
            return 12;
         }
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0){
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0(){
   switch(curChar)
   {
      case 33:
         return jjMoveStringLiteralDfa1_0(0x4000000L);
      case 38:
         return jjMoveStringLiteralDfa1_0(0x8000L);
      case 40:
         return jjStopAtPos(0, 21);
      case 41:
         return jjStopAtPos(0, 22);
      case 42:
         return jjStopAtPos(0, 31);
      case 43:
         return jjStartNfaWithStates_0(0, 18, 14);
      case 45:
         return jjStartNfaWithStates_0(0, 19, 14);
      case 47:
         return jjStopAtPos(0, 32);
      case 59:
         return jjStopAtPos(0, 16);
      case 60:
         jjmatchedKind = 29;
         return jjMoveStringLiteralDfa1_0(0x40000000L);
      case 61:
         jjmatchedKind = 17;
         return jjMoveStringLiteralDfa1_0(0x2000000L);
      case 62:
         jjmatchedKind = 27;
         return jjMoveStringLiteralDfa1_0(0x10000000L);
      case 66:
         return jjMoveStringLiteralDfa1_0(0x200L);
      case 73:
         return jjMoveStringLiteralDfa1_0(0x400L);
      case 78:
         return jjMoveStringLiteralDfa1_0(0x100000L);
      case 82:
         return jjMoveStringLiteralDfa1_0(0x800L);
      case 97:
         return jjMoveStringLiteralDfa1_0(0x800000L);
      case 111:
         return jjMoveStringLiteralDfa1_0(0x1000000L);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0){
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 38:
         if ((active0 & 0x8000L) != 0L)
            return jjStopAtPos(1, 15);
         break;
      case 61:
         if ((active0 & 0x2000000L) != 0L)
            return jjStopAtPos(1, 25);
         else if ((active0 & 0x4000000L) != 0L)
            return jjStopAtPos(1, 26);
         else if ((active0 & 0x10000000L) != 0L)
            return jjStopAtPos(1, 28);
         else if ((active0 & 0x40000000L) != 0L)
            return jjStopAtPos(1, 30);
         break;
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x800L);
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x800400L);
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x100200L);
      case 114:
         if ((active0 & 0x1000000L) != 0L)
            return jjStartNfaWithStates_0(1, 12, 12);
         break;
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
private int jjMoveStringLiteralDfa2_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x800L);
      case 100:
         if ((active0 & 0x800000L) != 0L)
            return jjStartNfaWithStates_0(2, 12, 12);
         break;
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x200L);
      case 116:
         if ((active0 & 0x400L) != 0L)
            return jjStartNfaWithStates_0(2, 10, 12);
         else if ((active0 & 0x100000L) != 0L)
            return jjStartNfaWithStates_0(2, 12, 12);
         break;
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
private int jjMoveStringLiteralDfa3_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 108:
         if ((active0 & 0x800L) != 0L)
            return jjStartNfaWithStates_0(3, 11, 12);
         return jjMoveStringLiteralDfa4_0(active0, 0x200L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
private int jjMoveStringLiteralDfa4_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 101:
         return jjMoveStringLiteralDfa5_0(active0, 0x200L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
private int jjMoveStringLiteralDfa5_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa6_0(active0, 0x200L);
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
private int jjMoveStringLiteralDfa6_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 110:
         if ((active0 & 0x200L) != 0L)
            return jjStartNfaWithStates_0(6, 9, 12);
         break;
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 25;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 14:
                  if ((0x3fe000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(18, 19); }
                  else if (curChar == 48)
                     { jjCheckNAdd(19); }
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 13)
                        kind = 13;
                     { jjCheckNAdd(15); }
                  }
                  else if (curChar == 48)
                  {
                     if (kind > 13)
                        kind = 13;
                  }
                  break;
               case 0:
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 13)
                        kind = 13;
                     { jjCheckNAddStates(0, 2); }
                  }
                  else if ((0x100002700L & l) != 0L)
                  {
                     if (kind > 6)
                        kind = 6;
                  }
                  else if ((0x280000000000L & l) != 0L)
                     { jjAddStates(3, 6); }
                  else if (curChar == 48)
                  {
                     if (kind > 13)
                        kind = 13;
                     { jjCheckNAdd(19); }
                  }
                  else if (curChar == 35)
                  {
                     if (kind > 7)
                        kind = 7;
                     { jjCheckNAdd(2); }
                  }
                  break;
               case 1:
                  if (curChar != 35)
                     break;
                  if (kind > 7)
                     kind = 7;
                  { jjCheckNAdd(2); }
                  break;
               case 2:
                  if ((0xfffffffffffffbffL & l) == 0L)
                     break;
                  if (kind > 7)
                     kind = 7;
                  { jjCheckNAdd(2); }
                  break;
               case 12:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 12)
                     kind = 12;
                  jjstateSet[jjnewStateCnt++] = 12;
                  break;
               case 13:
                  if ((0x280000000000L & l) != 0L)
                     { jjAddStates(3, 6); }
                  break;
               case 15:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 13)
                     kind = 13;
                  { jjCheckNAdd(15); }
                  break;
               case 16:
                  if (curChar == 48 && kind > 13)
                     kind = 13;
                  break;
               case 17:
                  if ((0x3fe000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(18, 19); }
                  break;
               case 18:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(18, 19); }
                  break;
               case 19:
                  if (curChar == 46)
                     { jjCheckNAddTwoStates(20, 21); }
                  break;
               case 20:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(20, 21); }
                  break;
               case 21:
                  if ((0x3fe000000000000L & l) != 0L && kind > 14)
                     kind = 14;
                  break;
               case 22:
                  if (curChar == 48)
                     { jjCheckNAdd(19); }
                  break;
               case 23:
                  if ((0x3fe000000000000L & l) == 0L)
                     break;
                  if (kind > 13)
                     kind = 13;
                  { jjCheckNAddStates(0, 2); }
                  break;
               case 24:
                  if (curChar != 48)
                     break;
                  if (kind > 13)
                     kind = 13;
                  { jjCheckNAdd(19); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x7fffffe07fffffeL & l) != 0L)
                  {
                     if (kind > 12)
                        kind = 12;
                     { jjCheckNAdd(12); }
                  }
                  if (curChar == 102)
                     jjstateSet[jjnewStateCnt++] = 9;
                  else if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 5;
                  break;
               case 2:
                  if (kind > 7)
                     kind = 7;
                  jjstateSet[jjnewStateCnt++] = 2;
                  break;
               case 3:
                  if (curChar == 101 && kind > 8)
                     kind = 8;
                  break;
               case 4:
                  if (curChar == 117)
                     { jjCheckNAdd(3); }
                  break;
               case 5:
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 4;
                  break;
               case 6:
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 5;
                  break;
               case 7:
                  if (curChar == 115)
                     { jjCheckNAdd(3); }
                  break;
               case 8:
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 7;
                  break;
               case 9:
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 8;
                  break;
               case 10:
                  if (curChar == 102)
                     jjstateSet[jjnewStateCnt++] = 9;
                  break;
               case 11:
               case 12:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 12)
                     kind = 12;
                  { jjCheckNAdd(12); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 2:
                  if ((jjbitVec0[i2] & l2) == 0L)
                     break;
                  if (kind > 7)
                     kind = 7;
                  jjstateSet[jjnewStateCnt++] = 2;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 25 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   15, 18, 19, 14, 16, 17, 22, 
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, 
"\102\157\157\154\145\141\156", "\111\156\164", "\122\145\141\154", null, null, null, "\46\46", "\73", "\75", 
"\53", "\55", "\116\157\164", "\50", "\51", "\141\156\144", "\157\162", "\75\75", 
"\41\75", "\76", "\76\75", "\74", "\74\75", "\52", "\57", };
protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      jjmatchedPos = -1;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

    /** Constructor. */
    public ConstructorASTCoreTokenManager(SimpleCharStream stream){

      if (SimpleCharStream.staticFlag)
            throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");

    input_stream = stream;
  }

  /** Constructor. */
  public ConstructorASTCoreTokenManager (SimpleCharStream stream, int lexState){
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Reinitialise parser. */
  public void ReInit(SimpleCharStream stream)
  {
    jjmatchedPos = jjnewStateCnt = 0;
    curLexState = defaultLexState;
    input_stream = stream;
    ReInitRounds();
  }

  private void ReInitRounds()
  {
    int i;
    jjround = 0x80000001;
    for (i = 25; i-- > 0;)
      jjrounds[i] = 0x80000000;
  }

  /** Reinitialise parser. */
  public void ReInit(SimpleCharStream stream, int lexState)
  {
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Switch to specified lex state. */
  public void SwitchTo(int lexState)
  {
    if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
    else
      curLexState = lexState;
  }

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};
static final long[] jjtoToken = {
   0x1ffffff01L, 
};
static final long[] jjtoSkip = {
   0xc0L, 
};
    protected SimpleCharStream  input_stream;

    private final int[] jjrounds = new int[25];
    private final int[] jjstateSet = new int[2 * 25];

    
    protected char curChar;
}
