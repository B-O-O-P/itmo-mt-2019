// Generated from D:/GitHub/B-O-O-P/itmo-mt-2019/04-parser-generator/src/main/java/ru/itmo/chizhikov/antlr\Grammar.g4 by ANTLR 4.7.2
package antlr.ru.itmo.chizhikov.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(GrammarParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(GrammarParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(GrammarParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(GrammarParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#pckg}.
	 * @param ctx the parse tree
	 */
	void enterPckg(GrammarParser.PckgContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#pckg}.
	 * @param ctx the parse tree
	 */
	void exitPckg(GrammarParser.PckgContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#rulee}.
	 * @param ctx the parse tree
	 */
	void enterRulee(GrammarParser.RuleeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#rulee}.
	 * @param ctx the parse tree
	 */
	void exitRulee(GrammarParser.RuleeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#parserRulee}.
	 * @param ctx the parse tree
	 */
	void enterParserRulee(GrammarParser.ParserRuleeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#parserRulee}.
	 * @param ctx the parse tree
	 */
	void exitParserRulee(GrammarParser.ParserRuleeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#inAttrs}.
	 * @param ctx the parse tree
	 */
	void enterInAttrs(GrammarParser.InAttrsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#inAttrs}.
	 * @param ctx the parse tree
	 */
	void exitInAttrs(GrammarParser.InAttrsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(GrammarParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(GrammarParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#paramType}.
	 * @param ctx the parse tree
	 */
	void enterParamType(GrammarParser.ParamTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#paramType}.
	 * @param ctx the parse tree
	 */
	void exitParamType(GrammarParser.ParamTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#paramName}.
	 * @param ctx the parse tree
	 */
	void enterParamName(GrammarParser.ParamNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#paramName}.
	 * @param ctx the parse tree
	 */
	void exitParamName(GrammarParser.ParamNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#outAttr}.
	 * @param ctx the parse tree
	 */
	void enterOutAttr(GrammarParser.OutAttrContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#outAttr}.
	 * @param ctx the parse tree
	 */
	void exitOutAttr(GrammarParser.OutAttrContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#prods}.
	 * @param ctx the parse tree
	 */
	void enterProds(GrammarParser.ProdsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#prods}.
	 * @param ctx the parse tree
	 */
	void exitProds(GrammarParser.ProdsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#prod}.
	 * @param ctx the parse tree
	 */
	void enterProd(GrammarParser.ProdContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#prod}.
	 * @param ctx the parse tree
	 */
	void exitProd(GrammarParser.ProdContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(GrammarParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(GrammarParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(GrammarParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(GrammarParser.ArgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tokenRule}
	 * labeled alternative in {@link GrammarParser#lexerRulee}.
	 * @param ctx the parse tree
	 */
	void enterTokenRule(GrammarParser.TokenRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tokenRule}
	 * labeled alternative in {@link GrammarParser#lexerRulee}.
	 * @param ctx the parse tree
	 */
	void exitTokenRule(GrammarParser.TokenRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code skipRule}
	 * labeled alternative in {@link GrammarParser#lexerRulee}.
	 * @param ctx the parse tree
	 */
	void enterSkipRule(GrammarParser.SkipRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code skipRule}
	 * labeled alternative in {@link GrammarParser#lexerRulee}.
	 * @param ctx the parse tree
	 */
	void exitSkipRule(GrammarParser.SkipRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#term_value}.
	 * @param ctx the parse tree
	 */
	void enterTerm_value(GrammarParser.Term_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#term_value}.
	 * @param ctx the parse tree
	 */
	void exitTerm_value(GrammarParser.Term_valueContext ctx);
}