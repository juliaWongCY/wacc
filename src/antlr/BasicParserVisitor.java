// Generated from ./BasicParser.g4 by ANTLR 4.4
package antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BasicParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BasicParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BasicParser#argList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgList(@NotNull BasicParser.ArgListContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#arrayLiter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiter(@NotNull BasicParser.ArrayLiterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code string_liter}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_liter(@NotNull BasicParser.String_literContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#arrayElem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayElem(@NotNull BasicParser.ArrayElemContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#unaryOper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOper(@NotNull BasicParser.UnaryOperContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ident}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdent(@NotNull BasicParser.IdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull BasicParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exit_stat}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExit_stat(@NotNull BasicParser.Exit_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull BasicParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#binaryOper_IntLower}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOper_IntLower(@NotNull BasicParser.BinaryOper_IntLowerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declare_stat}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclare_stat(@NotNull BasicParser.Declare_statContext ctx);
	/**
	 * Visit a parse tree produced by the {@code while_stat}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stat(@NotNull BasicParser.While_statContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignl_id}
	 * labeled alternative in {@link BasicParser#assignLHS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignl_id(@NotNull BasicParser.Assignl_idContext ctx);
	/**
	 * Visit a parse tree produced by the {@code char_liter}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChar_liter(@NotNull BasicParser.Char_literContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(@NotNull BasicParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign_stat}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_stat(@NotNull BasicParser.Assign_statContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sequential_stat}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequential_stat(@NotNull BasicParser.Sequential_statContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bool_liter}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_liter(@NotNull BasicParser.Bool_literContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#binaryOper_CompareHigher}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOper_CompareHigher(@NotNull BasicParser.BinaryOper_CompareHigherContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignr_call}
	 * labeled alternative in {@link BasicParser#assignRHS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignr_call(@NotNull BasicParser.Assignr_callContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignr_pairelem}
	 * labeled alternative in {@link BasicParser#assignRHS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignr_pairelem(@NotNull BasicParser.Assignr_pairelemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unary_op}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_op(@NotNull BasicParser.Unary_opContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignr_arrayliter}
	 * labeled alternative in {@link BasicParser#assignRHS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignr_arrayliter(@NotNull BasicParser.Assignr_arrayliterContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#pairElemType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPairElemType(@NotNull BasicParser.PairElemTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binary_opCompareHigher}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary_opCompareHigher(@NotNull BasicParser.Binary_opCompareHigherContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binary_opAnd}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary_opAnd(@NotNull BasicParser.Binary_opAndContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(@NotNull BasicParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignl_pairelem}
	 * labeled alternative in {@link BasicParser#assignLHS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignl_pairelem(@NotNull BasicParser.Assignl_pairelemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignr_newpair}
	 * labeled alternative in {@link BasicParser#assignRHS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignr_newpair(@NotNull BasicParser.Assignr_newpairContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paren_expr}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParen_expr(@NotNull BasicParser.Paren_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayElem_expr}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayElem_expr(@NotNull BasicParser.ArrayElem_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#binaryOper_IntHigher}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOper_IntHigher(@NotNull BasicParser.BinaryOper_IntHigherContext ctx);
	/**
	 * Visit a parse tree produced by the {@code println_stat}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintln_stat(@NotNull BasicParser.Println_statContext ctx);
	/**
	 * Visit a parse tree produced by the {@code scope_stat}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScope_stat(@NotNull BasicParser.Scope_statContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignr_expr}
	 * labeled alternative in {@link BasicParser#assignRHS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignr_expr(@NotNull BasicParser.Assignr_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binary_opCompareLower}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary_opCompareLower(@NotNull BasicParser.Binary_opCompareLowerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignl_arrayelem}
	 * labeled alternative in {@link BasicParser#assignLHS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignl_arrayelem(@NotNull BasicParser.Assignl_arrayelemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binary_opIntLower}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary_opIntLower(@NotNull BasicParser.Binary_opIntLowerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code skip_stat}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkip_stat(@NotNull BasicParser.Skip_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#baseType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseType(@NotNull BasicParser.BaseTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code int_liter}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt_liter(@NotNull BasicParser.Int_literContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#binaryOper_CompareLower}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOper_CompareLower(@NotNull BasicParser.BinaryOper_CompareLowerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binary_opIntHigher}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary_opIntHigher(@NotNull BasicParser.Binary_opIntHigherContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(@NotNull BasicParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if_stat}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stat(@NotNull BasicParser.If_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#pairElem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPairElem(@NotNull BasicParser.PairElemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code print_stat}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint_stat(@NotNull BasicParser.Print_statContext ctx);
	/**
	 * Visit a parse tree produced by the {@code return_stat}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_stat(@NotNull BasicParser.Return_statContext ctx);
	/**
	 * Visit a parse tree produced by the {@code free_stat}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFree_stat(@NotNull BasicParser.Free_statContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pair_liter}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair_liter(@NotNull BasicParser.Pair_literContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#pairType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPairType(@NotNull BasicParser.PairTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(@NotNull BasicParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binary_opOr}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary_opOr(@NotNull BasicParser.Binary_opOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code read_stat}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead_stat(@NotNull BasicParser.Read_statContext ctx);
}