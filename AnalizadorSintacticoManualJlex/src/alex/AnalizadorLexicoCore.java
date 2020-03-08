package alex;


public class AnalizadorLexicoCore {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 65536;
	private final int YY_EOF = 65537;

  private ALexOperations ops;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private int yyline;
	private boolean yy_at_bol;
	private int yy_lexical_state;

	public AnalizadorLexicoCore (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	AnalizadorLexicoCore (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private AnalizadorLexicoCore () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yyline = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;

  ops = new ALexOperations(this);
	}

	private boolean yy_eof_done = false;
	private final int YYINITIAL = 0;
	private final int yy_state_dtrans[] = {
		0
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
		    '\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
		    '\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		int i;
		for (i = yy_buffer_start; i < yy_buffer_index; ++i) {
			if ('\n' == yy_buffer[i] && !yy_last_was_cr) {
				++yyline;
			}
			if ('\r' == yy_buffer[i]) {
				++yyline;
				yy_last_was_cr=true;
			} else yy_last_was_cr=false;
		}
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
		            ('\r' == yy_buffer[yy_buffer_end-1] ||
		             '\n' == yy_buffer[yy_buffer_end-1] ||
		             2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
		             2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NOT_ACCEPT,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NO_ANCHOR,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NO_ANCHOR,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NO_ANCHOR,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NO_ANCHOR,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NOT_ACCEPT,
		/* 30 */ YY_NO_ANCHOR,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NOT_ACCEPT,
		/* 34 */ YY_NO_ANCHOR,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_NOT_ACCEPT,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NOT_ACCEPT,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NOT_ACCEPT,
		/* 41 */ YY_NO_ANCHOR,
		/* 42 */ YY_NOT_ACCEPT,
		/* 43 */ YY_NO_ANCHOR,
		/* 44 */ YY_NO_ANCHOR,
		/* 45 */ YY_NO_ANCHOR,
		/* 46 */ YY_NO_ANCHOR,
		/* 47 */ YY_NO_ANCHOR,
		/* 48 */ YY_NO_ANCHOR,
		/* 49 */ YY_NO_ANCHOR,
		/* 50 */ YY_NO_ANCHOR,
		/* 51 */ YY_NO_ANCHOR,
		/* 52 */ YY_NO_ANCHOR,
		/* 53 */ YY_NO_ANCHOR,
		/* 54 */ YY_NO_ANCHOR,
		/* 55 */ YY_NO_ANCHOR,
		/* 56 */ YY_NO_ANCHOR,
		/* 57 */ YY_NO_ANCHOR,
		/* 58 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,65538,
"0:8,24:3,0:2,24,0:18,24,33,0:4,30,0,27,28,26,1,6,2,5,34,3,4:9,0,25,31,29,32" +
",0:2,21:4,22,21:21,0:4,23,0,12,14,20,19,11,17,20:2,7,20:2,13,20,8,15,20:2,1" +
"0,18,9,16,20:5,0:65413,35:2")[0];

	private int yy_rmap[] = unpackFromString(1,59,
"0,1:2,2,3,4:5,5,6,7,4:2,8,4:5,9,8:7,10,11,12,4,13,14,15,16,8,17,18,19,20,17" +
",21,22,23,24,25,26,27,28,29,30,31,32,8,33,34,35")[0];

	private int yy_nxt[][] = unpackFromString(36,36,
"-1,1,2,3,30,-1:2,4,52,53,54,55,56,55,57,31,55,58,55:5,-1,5,6,7,8,9,10,29,11" +
",12,33,13,14,-1:3,3,30,-1:36,36,38,-1:4,38,-1:10,38,-1:16,55:2,-1:2,55,34,5" +
"5:12,37:3,-1:77,16,-1:35,18,-1:35,19,-1:9,55:2,-1:2,55:14,37:3,-1:15,36,21," +
"-1,42,-1:4,42,-1:10,42,-1:43,17,-1:8,30:2,36,38,-1:4,38,-1:10,38,-1:16,55:2" +
",-1:2,55:3,15,55:10,37:3,-1:41,20,-1:9,55:2,-1:2,55:2,22,55:11,37:3,-1:15,3" +
"5:2,-1:34,36,21,-1:32,40:2,32,35,-1:34,55:2,-1:2,55:2,23,55:11,37:3,-1:15,3" +
"2,35,-1:34,55:2,-1:2,55:9,47,55:4,37:3,-1:15,55:2,-1:2,55:5,48,55:8,37:3,-1" +
":15,55:2,-1:2,55:12,24,55,37:3,-1:15,55:2,-1:2,55:8,49,55:5,37:3,-1:15,55:2" +
",-1:2,55:6,50,55:7,37:3,-1:15,55:2,-1:2,55:4,25,55:9,37:3,-1:15,55:2,-1:2,5" +
"5:6,26,55:7,37:3,-1:15,55:2,-1:2,55:6,27,55:7,37:3,-1:15,55:2,-1:2,55:11,51" +
",55:2,37:3,-1:15,55:2,-1:2,55:4,28,55:9,37:3,-1:15,55:2,-1:2,55:8,39,55:5,3" +
"7:3,-1:15,55:2,-1:2,55:3,41,55:10,37:3,-1:15,55:2,-1:2,55:4,43,55:9,37:3,-1" +
":15,55:2,-1:2,55,44,55:12,37:3,-1:15,55:2,-1:2,55:8,45,55:5,37:3,-1:15,55:2" +
",-1:2,55:5,46,55:8,37:3,-1:12");

	public UnidadLexica yylex ()
		throws java.io.IOException {
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {

  return ops.unidadEof();
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					case 1:
						{return ops.unidadMas();}
					case -2:
						break;
					case 2:
						{return ops.unidadMenos();}
					case -3:
						break;
					case 3:
						{return ops.unidadEnt();}
					case -4:
						break;
					case 4:
						{return ops.unidadId();}
					case -5:
						break;
					case 5:
						{}
					case -6:
						break;
					case 6:
						{return ops.unidadPComa();}
					case -7:
						break;
					case 7:
						{return ops.unidadPor();}
					case -8:
						break;
					case 8:
						{return ops.unidadPAper();}
					case -9:
						break;
					case 9:
						{return ops.unidadPCie();}
					case -10:
						break;
					case 10:
						{return ops.unidadAsignacion();}
					case -11:
						break;
					case 11:
						{return ops.unidadLT();}
					case -12:
						break;
					case 12:
						{return ops.unidadGT();}
					case -13:
						break;
					case 13:
						{return ops.unidadDIV();}
					case -14:
						break;
					case 14:
						
					case -15:
						break;
					case 15:
						{return ops.unidadOr();}
					case -16:
						break;
					case 16:
						{return ops.unidadIgual();}
					case -17:
						break;
					case 17:
						{return ops.unidadSeparador();}
					case -18:
						break;
					case 18:
						{return ops.unidadLE();}
					case -19:
						break;
					case 19:
						{return ops.unidadGE();}
					case -20:
						break;
					case 20:
						{return ops.unidadNEQ();}
					case -21:
						break;
					case 21:
						{return ops.unidadReal();}
					case -22:
						break;
					case 22:
						{return ops.unidadTEnt();}
					case -23:
						break;
					case 23:
						{return ops.unidadNot();}
					case -24:
						break;
					case 24:
						{return ops.unidadAnd();}
					case -25:
						break;
					case 25:
						{return ops.unidadTrue();}
					case -26:
						break;
					case 26:
						{return ops.unidadTReal();}
					case -27:
						break;
					case 27:
						{return ops.unidadTBool();}
					case -28:
						break;
					case 28:
						{return ops.unidadFalse();}
					case -29:
						break;
					case 30:
						{return ops.unidadEnt();}
					case -30:
						break;
					case 31:
						{return ops.unidadId();}
					case -31:
						break;
					case 32:
						{return ops.unidadReal();}
					case -32:
						break;
					case 34:
						{return ops.unidadId();}
					case -33:
						break;
					case 35:
						{return ops.unidadReal();}
					case -34:
						break;
					case 37:
						{return ops.unidadId();}
					case -35:
						break;
					case 39:
						{return ops.unidadId();}
					case -36:
						break;
					case 41:
						{return ops.unidadId();}
					case -37:
						break;
					case 43:
						{return ops.unidadId();}
					case -38:
						break;
					case 44:
						{return ops.unidadId();}
					case -39:
						break;
					case 45:
						{return ops.unidadId();}
					case -40:
						break;
					case 46:
						{return ops.unidadId();}
					case -41:
						break;
					case 47:
						{return ops.unidadId();}
					case -42:
						break;
					case 48:
						{return ops.unidadId();}
					case -43:
						break;
					case 49:
						{return ops.unidadId();}
					case -44:
						break;
					case 50:
						{return ops.unidadId();}
					case -45:
						break;
					case 51:
						{return ops.unidadId();}
					case -46:
						break;
					case 52:
						{return ops.unidadId();}
					case -47:
						break;
					case 53:
						{return ops.unidadId();}
					case -48:
						break;
					case 54:
						{return ops.unidadId();}
					case -49:
						break;
					case 55:
						{return ops.unidadId();}
					case -50:
						break;
					case 56:
						{return ops.unidadId();}
					case -51:
						break;
					case 57:
						{return ops.unidadId();}
					case -52:
						break;
					case 58:
						{return ops.unidadId();}
					case -53:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}
