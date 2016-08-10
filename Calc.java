import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.misc.NotNull;

public class Calc extends GBaseVisitor {	          
	    @Override
	    public Double visitPrintExpr(GParser.PrintExprContext ctx) {
	        Double value = (Double) visit(ctx.expr());
	        System.out.println(value);
	        return 0.;
	    }
	     
	    @Override
	    public Double visitInt(GParser.IntContext ctx) {
	        return Double.valueOf(ctx.INT().getText());
	    }
	          
	    @Override
	    public Double visitMulDiv(GParser.MulDivContext ctx) {
	        double left = (Double) visit(ctx.expr(0));
	        double right = (Double) visit(ctx.expr(1));
	        if ( ctx.op.getType() == GParser.MUL ) return left * right;
	        return left / right;
	    }
	 
	    @Override
	    public Double visitAddSub(GParser.AddSubContext ctx) {
	        double left = (Double) visit(ctx.expr(0));
	        double right = (Double) visit(ctx.expr(1));
	        if ( ctx.op.getType() == GParser.ADD ) return left + right;
	        return left - right;
	    }
	     
	    @Override
	    public Double visitParens(GParser.ParensContext ctx) {
	        return (Double) visit(ctx.expr());
	    }
}
