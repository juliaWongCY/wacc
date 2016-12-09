package optimisation;

import ast.ASTNode;
import ast.BinaryOpr;
import ast.FunctionNode;
import ast.ProgramNode;
import ast.assignLeft.AssignLeftNode;
import ast.assignLeft.IdentAsLNode;
import ast.assignRight.*;
import ast.expression.*;
import ast.statement.*;

import java.util.ArrayList;
import java.util.List;

import static ast.BinaryOpr.DIV;

public class OptimisingVisitor {

    private static SymbolTable symbolTable;
    private static int level = 0;

    ///////////////////////////// Start of Assign Left ////////////////////////////////

//    public static ASTNode visitAssignLeftNode(ASTNode node) {
//        if (node instanceof ArrayElemAsLNode) {
//            return visitArrayElemAsLNode(node);
//        }
//        if (node instanceof IdentAsLNode) {
//            return visitIdentAsLNode(node);
//        }
//        if (node instanceof PairElemAsLNode) {
//            return visitPairElemAsLNode(node);
//        }
//        System.err.println("unrecognised assign left node");
//        return null;
//    }
//
//    public static ASTNode visitArrayElemAsLNode(ASTNode node) {
//        return null;
//    }
//
//    public static ASTNode visitIdentAsLNode(ASTNode node) {
//        return null;
//    }
//
//    public static ASTNode visitPairElemAsLNode(ASTNode node) {
//        return null;
//    }

    ///////////////////////////// End of Assign Left ////////////////////////////////

    ///////////////////////////// Start of Assign Right ////////////////////////////////

//    public static ASTNode visitAssignRightNode(ASTNode node) {
//        if (node instanceof ArgListNode) {
//            return visitArgListNode(node);
//        }
//        if (node instanceof ArrayLiterAsRNode) {
//            return visitArrayLiterAsRNode(node);
//        }
//        if (node instanceof CallAsRNode) {
//            return visitCallAsRNode(node);
//        }
//        if (node instanceof ExprAsRNode) {
//            return visitExprAsRNode(node);
//        }
//        if (node instanceof NewPairAsRNode) {
//            return visitNewPairAsRNode(node);
//        }
//        if (node instanceof PairElemAsRNode) {
//            return visitPairElemAsRNode(node);
//        }
//        System.err.println("unrecognised assign right node");
//        return null;
//    }

//    public static ASTNode visitArgListNode(ASTNode node) {
//        return null;
//    }
//
//    public static ASTNode visitArrayLiterAsRNode(ASTNode node) {
//        return null;
//    }
//
//    public static ASTNode visitCallAsRNode(ASTNode node) {
//        return null;
//    }
//
//    public static ASTNode visitExprAsRNode(ASTNode node) {
//        return visitExpressionNode(((ExprAsRNode) node).getExpr());
//    }
//
//    public static ASTNode visitNewPairAsRNode(ASTNode node) {
//        return null;
//    }
//
//    public static ASTNode visitPairElemAsRNode(ASTNode node) {
//        return null;
//    }

    ///////////////////////////// End of Assign Right ////////////////////////////////

    ///////////////////////////// Start of Expression Node ////////////////////////////////

    public static ASTNode visitExpressionNode(ASTNode node) {
        if (node instanceof ArrayElemNode) {
//            return visitArrayElemNode(node);
            return node;
        }
        if (node instanceof BinaryOprNode) {
            return visitBinaryOprNode(node);
        }
        if (node instanceof BoolLiterNode) {
//            return visitBoolLiterNode(node);
            return node;
        }
        if (node instanceof CharLiterNode) {
//            return visitCharLiterNode(node);
            return node;
        }
        if (node instanceof IdentNode) {
//            return visitIdentNode(node);
            return node;
        }
        if (node instanceof IntLiterNode) {
//            return visitIntLiterNode(node);
            return node;
        }
        if (node instanceof PairElemNode) {
//            return visitPairElemNode(node);
            return node;
        }
        if (node instanceof PairLiterNode) {
//            return visitPairLiterNode(node);
            return node;
        }
        if (node instanceof StringLiterNode) {
//            return visitStringLiterNode(node);
            return node;
        }
        if (node instanceof UnaryOprNode) {
//            return visitUnaryOprNode(node);
            return node;
        }

        System.err.println("unrecognised expression node");
        return null;
    }

//    public static ASTNode visitArrayElemNode(ASTNode node) {
//        //No change to the node
//        return node;
//    }

    public static ASTNode visitBinaryOprNode(ASTNode node) {

        BinaryOprNode binaryOprNode = (BinaryOprNode) node;
        ExpressionNode exprLNode = binaryOprNode.getExprL();
        ExpressionNode exprRNode = binaryOprNode.getExprR();
        BinaryOpr binaryOpr = binaryOprNode.getBinaryOpr();

        ExpressionNode newExprLNode = exprLNode;
        ExpressionNode newExprRNode = exprRNode;


        if (exprLNode instanceof BinaryOprNode) {
            newExprLNode = (ExpressionNode) visitBinaryOprNode(exprLNode);
        }
        ExprLIdentNodeChecker:
        if (exprLNode instanceof IdentNode) {
            IdentNode iNode = (IdentNode) exprLNode;
            OptimiseProperty property = symbolTable.getVariable(iNode.getId());
            if (!(property == null)) {
//                newExprLNode = property.getExpressionNode();
                if (property.getValue() instanceof ExpressionNode) {
                    newExprLNode = (ExpressionNode) property.getValue();
                } else {
                    break ExprLIdentNodeChecker;
                }

            }

        }
        //Not sure if we have to do UnaryOprNode

        if (exprRNode instanceof BinaryOprNode) {
            newExprRNode = (ExpressionNode) visitBinaryOprNode(exprRNode);
        }
        ExprRIdentNodeChecker:
        if (exprRNode instanceof IdentNode) {
            IdentNode iNode = (IdentNode) exprRNode;
            OptimiseProperty property = symbolTable.getVariable(iNode.getId());
            if (!(property == null)) {
//                newExprRNode = property.getExpressionNode();
                if (property.getValue() instanceof ExpressionNode) {
                    newExprRNode = (ExpressionNode) property.getValue();
                } else {
                    break ExprRIdentNodeChecker;
                }
            }

        }
        //Not sure if we have to do UnaryOprNode

        int exprLInt, exprRInt;
        int constant;
        boolean exprLBool, exprRBool, resultBool;

        if (!(newExprLNode instanceof IdentNode) && !(newExprRNode instanceof IdentNode)
                && !(newExprLNode instanceof BinaryOprNode) && !(newExprRNode instanceof BinaryOprNode)) {
            switch (binaryOpr) {
                //ARITHMETIC - BOTH EXPRESSION HAS TO BE INTEGER
                case PLUS:
                case MINUS:
                case MULT:
                    exprLInt = ((IntLiterNode) newExprLNode).getValue();
                    exprRInt = ((IntLiterNode) newExprRNode).getValue();
                    if (binaryOpr == BinaryOpr.PLUS) {
                        constant = exprLInt + exprRInt;
                        if (((exprLInt ^ constant) & (exprRInt ^ constant)) < 0) {
                            return node;
                        }
                    } else if (binaryOpr == BinaryOpr.MINUS) {
                        constant = exprLInt - exprRInt;
                        if (((exprLInt ^ exprRInt) & (exprLInt ^ constant)) < 0) {
                            return node;
                        }
                    } else {
                        long res = (long)exprLInt * (long)exprRInt;
                        if ((int)res != res) {
                            return node;
                        } else {
                            return new IntLiterNode((int) res);
                        }
                    }

                    return new IntLiterNode(constant);
                case DIV:
                case MOD:
                    exprLInt = ((IntLiterNode) newExprLNode).getValue();
                    exprRInt = ((IntLiterNode) newExprRNode).getValue();
                    if (exprRInt != 0) {
                        if (binaryOpr == DIV) {
                            constant = exprLInt / exprRInt;
                        } else {
                            constant = exprLInt % exprRInt;
                        }
                        return new IntLiterNode(constant);
                    } else {
                        return node;
                    }

                    //COMPARING - GTE/GT/LTE/LT ALL HAS TO BE INTEGER/CHAR
                case GTE:
                case GT:
                case LTE:
                case LT:
                    if (newExprLNode instanceof IntLiterNode) {
                        exprLInt = ((IntLiterNode) newExprLNode).getValue();
                        exprRInt = ((IntLiterNode) newExprRNode).getValue();
                        if (binaryOpr == BinaryOpr.GTE) {
                            resultBool = exprLInt >= exprRInt;
                        } else if (binaryOpr == BinaryOpr.GT) {
                            resultBool = exprLInt > exprRInt;
                        } else if (binaryOpr == BinaryOpr.LTE) {
                            resultBool = exprLInt <= exprRInt;
                        } else {
                            resultBool = exprLInt < exprRInt;
                        }
                        return new BoolLiterNode(resultBool);
                    } else {
                        exprLInt = ((CharLiterNode) newExprLNode).getValue();
                        exprRInt = ((CharLiterNode) newExprRNode).getValue();
                        if (binaryOpr == BinaryOpr.GTE) {
                            resultBool = exprLInt >= exprRInt;
                        } else if (binaryOpr == BinaryOpr.GT) {
                            resultBool = exprLInt > exprRInt;
                        } else if (binaryOpr == BinaryOpr.LTE) {
                            resultBool = exprLInt <= exprRInt;
                        } else {
                            resultBool = exprLInt < exprRInt;
                        }
                        return new BoolLiterNode(resultBool);
                    }


                    //COMPARING - EQ/NEQ: EVERYTYPE
                case EQ:
                case NEQ:
                    if (newExprLNode instanceof IntLiterNode && newExprRNode instanceof IntLiterNode) {
                        exprLInt = ((IntLiterNode) newExprLNode).getValue();
                        exprRInt = ((IntLiterNode) newExprRNode).getValue();
                        if (binaryOpr == BinaryOpr.EQ) {
                            resultBool = exprLInt == exprRInt;
                        } else {
                            resultBool = exprLInt != exprRInt;
                        }
                        return new BoolLiterNode(resultBool);
                    } else if (newExprLNode instanceof CharLiterNode && newExprRNode instanceof CharLiterNode) {
                        exprLInt = ((CharLiterNode) newExprLNode).getValue();
                        exprRInt = ((CharLiterNode) newExprRNode).getValue();
                        if (binaryOpr == BinaryOpr.EQ) {
                            resultBool = exprLInt == exprRInt;
                        } else {
                            resultBool = exprLInt != exprRInt;
                        }
                        return new BoolLiterNode(resultBool);
                    } else if (newExprLNode instanceof BoolLiterNode && newExprRNode instanceof BoolLiterNode) {
                        exprLBool = ((BoolLiterNode) newExprLNode).getValue();
                        exprRBool = ((BoolLiterNode) newExprRNode).getValue();
                        if (binaryOpr == BinaryOpr.EQ) {
                            resultBool = exprLBool == exprRBool;
                        } else {
                            resultBool = exprLBool != exprRBool;
                        }
                        return new BoolLiterNode(resultBool);
                    } else {
                        return node;
                    }


                    //LOGICAL - BOTH EXPRESSION HAS TO BE BOOLEAN
                case AND:
                case OR:
                    exprLBool = ((BoolLiterNode) newExprLNode).getValue();
                    exprRBool = ((BoolLiterNode) newExprRNode).getValue();
                    if (binaryOpr == BinaryOpr.AND) {
                        resultBool = exprLBool && exprRBool;
                    } else {
                        resultBool = exprLBool || exprRBool;
                    }
                    return new BoolLiterNode(resultBool);
            }
        }

        return node;
    }

//    public static ASTNode visitBoolLiterNode(ASTNode node) {
//        //No change to the node
//        return node;
//    }
//
//    public static ASTNode visitCharLiterNode(ASTNode node) {
//        //No change to the node
//        return node;
//    }

//    public static ASTNode visitIdentNode(ASTNode node) {
//        //No change to the node
//        return node;
//    }
//
//    public static ASTNode visitIntLiterNode(ASTNode node) {
//        //No change to the node
//        return node;
//    }

//    public static ASTNode visitPairElemNode(ASTNode node) {
//        //No change to the node
//        return node;
//    }
//
//    public static ASTNode visitPairLiterNode(ASTNode node) {
//        //No change to the node
//        return node;
//    }
//
//    public static ASTNode visitStringLiterNode(ASTNode node) {
//        //No change to the node
//        return node;
//    }

//    public static ASTNode visitUnaryOprNode(ASTNode node) {
//        //No change to the node
//        return node;
//    }

    ///////////////////////////// End of Expression Node ////////////////////////////////

    ///////////////////////////// Start of Parameter ////////////////////////////////

    public static ASTNode visitParamListNode(ASTNode node) {
        return null;
    }

    public static ASTNode visitParamNode(ASTNode node) {
        return null;
    }

    ///////////////////////////// End of Parameter ////////////////////////////////

    ///////////////////////////// Start of Statement Node  ////////////////////////////////

    public static ASTNode visitStatListNode(ASTNode node) {

        StatListNode slNode = (StatListNode) node;
        List<StatementNode> sNodes = slNode.getStatList();
        List<StatementNode> newsNodes = new ArrayList<>();
        for (StatementNode sNode : sNodes) {
            ASTNode newsNode = visitStatementNode(sNode);
            newsNodes.add((StatementNode) newsNode);
        }

        return new StatListNode(newsNodes);

    }

    public static ASTNode visitStatementNode(ASTNode node) {
        if (node instanceof AssignStatNode) {
            return visitAssignStatNode(node);
        }
        if (node instanceof DeclareStatNode) {
            return visitDeclareStatNode(node);
        }
        if (node instanceof ExitStatNode) {
            return visitExitStatNode(node);
        }
        if (node instanceof FreeStatNode) {
            return visitFreeStatNode(node);
        }
        if (node instanceof IfStatNode) {
            return visitIfStatNode(node);
        }
        if (node instanceof PrintlnStatNode) {
            return visitPrintlnStatNode(node);
        }
        if (node instanceof PrintStatNode) {
            return visitPrintStatNode(node);
        }
        if (node instanceof ReadStatNode) {
            return visitReadStatNode(node);
        }
        if (node instanceof ReturnStatNode) {
            return visitReturnStatNode(node);
        }
        if (node instanceof ScopingStatNode) {
            return visitScopingStatNode(node);
        }
        if (node instanceof SideEffectNode) {
            return visitSideEffectNode(node);
        }
        if (node instanceof SkipStatNode) {
            return visitSkipEffectNode(node);
        }
        if (node instanceof StatListNode) {
            return visitStatListNode(node);
        }
        if (node instanceof WhileStatNode) {
            return visitWhileStatNode(node);
        }
        System.err.println("unrecognised statement node");
        return null;
    }

    public static ASTNode visitAssignStatNode(ASTNode node) {

        AssignStatNode aNode = (AssignStatNode) node;
        AssignLeftNode assignLNode = aNode.getAssignLHS();
        AssignRightNode assignRNode = aNode.getAssignRHS();

        IdentNode iNode;

        if (assignLNode instanceof IdentAsLNode && assignRNode instanceof ExprAsRNode) {
            iNode = ((IdentAsLNode) assignLNode).getIdnode();
            String id = iNode.getId();
            ExpressionNode newExprR = (ExpressionNode) visitExpressionNode(((ExprAsRNode) assignRNode).getExpr());
            symbolTable.modifyVariable(id, newExprR, level);
            AssignRightNode newAssignRNode = new ExprAsRNode(newExprR);
            return new AssignStatNode(newAssignRNode, assignLNode);
        }


        //No change to the node
        return node;

    }

    public static ASTNode visitDeclareStatNode(ASTNode node) {
        DeclareStatNode dNode = (DeclareStatNode) node;

        IdentNode identNode = dNode.getId();
        String id = identNode.getId();

        AssignRightNode assignRNode = dNode.getAssignRightNode();

        if (assignRNode instanceof ExprAsRNode) {
            //ExpressionNode expressionNode = (ExpressionNode) visitExprAsRNode(assignRNode);
            ExpressionNode expressionNode = (ExpressionNode)  visitExpressionNode(((ExprAsRNode) assignRNode).getExpr());
            OptimiseProperty property = new OptimiseProperty(expressionNode, level);
            symbolTable.addVariable(id, property);
            return new DeclareStatNode(dNode.getType(), identNode, new ExprAsRNode(expressionNode));
        } else if (assignRNode instanceof PairElemAsRNode) {
            OptimiseProperty property = new OptimiseProperty(((PairElemAsRNode) assignRNode).getPairElemNode(), level);
            symbolTable.addVariable(id, property);
        } else if (assignRNode instanceof NewPairAsRNode) {
            OptimiseProperty property = new OptimiseProperty((NewPairAsRNode) assignRNode, level);
            symbolTable.addVariable(id, property);
        }
        return node;
    }

    public static ASTNode visitExitStatNode(ASTNode node) {

        ExitStatNode eNode = (ExitStatNode) node;

        ExpressionNode exprNode = eNode.getExpr();
        ASTNode newExprNode = visitExpressionNode(exprNode);

        return new ExitStatNode((ExpressionNode) newExprNode);
    }

    public static ASTNode visitFreeStatNode(ASTNode node) {
        return node;
    }

    public static ASTNode visitIfStatNode(ASTNode node) {

        IfStatNode iNode = (IfStatNode) node;
        ExpressionNode condition = iNode.getCond();

        condition = (ExpressionNode) visitExpressionNode(condition);

        StatListNode thenBody = iNode.getStatThenBody();
        StatListNode elseBody = iNode.getStatElseBody();

        newSymbolTable();
        ++level;
        thenBody = (StatListNode) visitStatListNode(thenBody);
        --level;
        popSymbolTable();

        newSymbolTable();
        ++level;
        elseBody = (StatListNode) visitStatListNode(elseBody);
        --level;
        popSymbolTable();

        return new IfStatNode(condition, thenBody, elseBody);
    }

    public static ASTNode visitPrintlnStatNode(ASTNode node) {

        PrintlnStatNode pNode = (PrintlnStatNode) node;

        ExpressionNode newExprNode = (ExpressionNode) visitExpressionNode(pNode.getExpr());

        return new PrintlnStatNode(newExprNode);
    }

    public static ASTNode visitPrintStatNode(ASTNode node) {

        PrintStatNode pNode = (PrintStatNode) node;

        ASTNode newExprNode = visitExpressionNode(pNode.getExpr());

        return new PrintStatNode((ExpressionNode) newExprNode);
    }

    public static ASTNode visitReadStatNode(ASTNode node) {
        return node;
    }

    public static ASTNode visitReturnStatNode(ASTNode node) {

        ReturnStatNode rNode = (ReturnStatNode) node;

        ASTNode newExprNode = visitExpressionNode(rNode.getExpr());

        return new ReturnStatNode((ExpressionNode) newExprNode);

    }

    public static ASTNode visitScopingStatNode(ASTNode node) {
        ScopingStatNode sNode = (ScopingStatNode) node;
        StatListNode slNode = sNode.getBody();

        newSymbolTable();
        ++level;
        slNode = (StatListNode) visitStatListNode(slNode);
        --level;
        popSymbolTable();
        return new ScopingStatNode(slNode);
    }

    public static ASTNode visitSideEffectNode(ASTNode node) {

        //No change to the node
        return node;

    }

    public static ASTNode visitSkipEffectNode(ASTNode node) {

        //No change to the node
        return node;


    }

    public static ASTNode visitWhileStatNode(ASTNode node) {

//        WhileStatNode wNode = (WhileStatNode) node;
//        ExpressionNode condition = wNode.getCondition();
//        //TODO: Simplify the condition
//
//        StatListNode body = wNode.getBody();
//
//        newSymbolTable();
//        body = (StatListNode) visitStatListNode(body);
//        popSymbolTable();
//
//        return new WhileStatNode(condition, body);

        return node;
    }

    ///////////////////////////// End of Statement Node ////////////////////////////////

    ///////////////////////////// Start of Function and Program ////////////////////////////////

    public static ASTNode visitProgramNode(ASTNode node) {

        ProgramNode pNode = (ProgramNode) node;

        List<FunctionNode> fNodes = pNode.getFunctionNodes();
        List<FunctionNode> newfNodes = new ArrayList<>();
        for (FunctionNode fNode : fNodes) {
            ASTNode newfNode = visitFunctionNode(fNode);
            newfNodes.add((FunctionNode) newfNode);
        }

        symbolTable = new SymbolTable();

        StatListNode slNode = pNode.getStatListNode();
        ASTNode newslNode = visitStatListNode(slNode);

        return new ProgramNode(newfNodes, (StatListNode) newslNode);
    }

    public static ASTNode visitFunctionNode(ASTNode node) {

//        FunctionNode fNode = (FunctionNode) node;
//        StatListNode slNode = fNode.getStatement();
//
//        newSymbolTable();
//        slNode = (StatListNode) visitStatListNode(slNode);
//        popSymbolTable();
//
//        return new FunctionNode(fNode.getRetType(), fNode.getFuncitonNameInIdentNode(), fNode.getParamListNode(), slNode);

        return node;

    }

    ///////////////////////////// End of Function and Program ////////////////////////////////

    ///////////////////////////// Start of Helper Function ///////////////////////////////////

    private static void newSymbolTable() {
        SymbolTable st = new SymbolTable(symbolTable);
        symbolTable = st;
    }

    private static void popSymbolTable() {
        if (symbolTable.getParent() == null) {
            System.err.println("error in finding variable symbol table parent");
        } else {
            symbolTable = symbolTable.getParent();
        }
    }


}
