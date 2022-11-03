package Scan;




import AST.Program;
import Scan.Checker;
import Scan.ParserAST;
import Scan.Scanner;
import Scan.SourceFile;

import javax.swing.*;


public class Compiler
{
  private static final String EXAMPLES_DIR = "c:\\usr\\undervisning\\CMC\\IntLang\\examples";


  public static void main( String args[] )
  {
    JFileChooser fc = new JFileChooser( EXAMPLES_DIR );

    if( fc.showOpenDialog( null ) == fc.APPROVE_OPTION ) {
      String sourceName = fc.getSelectedFile().getAbsolutePath();

      SourceFile in = new SourceFile( sourceName );
      Scanner s = new Scanner( in );
      ParserAST p = new ParserAST( s );
      Checker c = new Checker();
      Encoder e = new Encoder();

      Program program = (Program) p.parseProgram();
      c.check( program );
      e.encode( program );

      String targetName;
      if( sourceName.endsWith( ".txt" ) )
        targetName = sourceName.substring( 0, sourceName.length() - 4 ) + ".tam";
      else
        targetName = sourceName + ".tam";

      e.saveTargetProgram( targetName );
    }
  }
}