import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Teste {

	public static void main(String[] args) throws IOException {
		InputStream stream = new FileInputStream("teste.txt");
		ANTLRInputStream input = new ANTLRInputStream(stream);
		GLexer lexer = new GLexer(input);
		CommonTokenStream token = new CommonTokenStream(lexer);
		GParser parser = new GParser(token);
		ParseTree tree = parser.prog();
		Calc visit = new Calc();
		visit.visit(tree);
		
	}
}
