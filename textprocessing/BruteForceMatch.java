package textprocessing;

/***************************************************************
*
*  Compilation:  javac Brtue.java
*  Execution:    java Brute pattern text
*
*  Reads in two strings, the pattern and the input text, and
*  searches for the pattern in the input text using brute force.
*
*  % java Brute abracadabra abacadabrabracabracadabrabrabracad
*  text:    abacadabrabracabracadabrabrabracad 
*  pattern:               abracadabra          
*
*  % java Brute rab abacadabrabracabracadabrabrabracad
*  text:    abacadabrabracabracadabrabrabracad 
*  pattern:         rab                         
* 
*  % java Brute rabrabracad abacadabrabracabracadabrabrabracad
*  text:    abacadabrabracabracadabrabrabracad
*  pattern:                        rabrabracad

*
*  % java Brute bcara abacadabrabracabracadabrabrabracad
*  text:    abacadabrabracabracadabrabrabracad 
*  pattern:                                   bcara
* 
*  % java Brute abacad abacadabrabracabracadabrabrabracad
*  text:    abacadabrabracabracadabrabrabracad
*  pattern: abacad
*
***************************************************************/

public class BruteForceMatch {

  /***************************************************************************
   *  String versions
   ***************************************************************************/

   // return offset of first match or N if no match
   public static int search1(String pat, String txt) {
       int M = pat.length();
       int N = txt.length();

       for (int i = 0; i <= N - M; i++) {
           int j;
           for (j = 0; j < M; j++) {
               if (txt.charAt(i+j) != pat.charAt(j))
                   break;
           }
           if (j == M) return i;            // found at offset i
       }
       return N;                            // not found
   }

   // return offset of first match or N if no match
   public static int search2(String pat, String txt) {
       int M = pat.length();
       int N = txt.length();
       int i, j;
       for (i = 0, j = 0; i < N && j < M; i++) {
           if (txt.charAt(i) == pat.charAt(j)) j++;
           else { i -= j; j = 0;  }
       }
       if (j == M) return i - M;    // found
       else        return N;        // not found
   }


  /***************************************************************************
   *  char[] array versions
   ***************************************************************************/

   // return offset of first match or N if no match
   public static int search1(char[] pattern, char[] text) {
       int M = pattern.length;
       int N = text.length;

       for (int i = 0; i <= N - M; i++) {
           int j;
           for (j = 0; j < M; j++) {
               if (text[i+j] != pattern[j])
                   break;
           }
           if (j == M) return i;            // found at offset i
       }
       return N;                            // not found
   }

   // return offset of first match or N if no match
   public static int search2(char[] pattern, char[] text) { 
       int M = pattern.length;
       int N = text.length;
       int i, j;
       for (i = 0, j = 0; i < N && j < M; i++) {
           if (text[i] == pattern[j]) j++;
           else { i -= j; j = 0;  }
       }
       if (j == M) return i - M;    // found
       else        return N;        // not found
   } 


   // test client
   public static void main(String[] args) {
       //String pat = args[0];
       //String txt = args[1];
	   
       // There are two implmentations of search
	   // one is with String and the other is an array of chars
	   
	   In fileIn = new In("Hard disk.txt");
   	
   	
       String text = new String();
       
       while (fileIn.hasNextLine())
		{
			text += fileIn.readLine();
			
		}

       String[] pat = {"hard", "disk", "hard disk", "hard drive", "hard dist", "xltpru"};

       
       
       //System.out.println(pat);
       
       for (int i = 0; i < pat.length; i++)
		{
    	   //BoyerMoore boyermoore1 = new BoyerMoore(pat[i]);
			int offset1 = search1(pat[i], text);
			System.out.println("The offset for " + pat[i] + " is " + offset1);
		}
       
   }
}