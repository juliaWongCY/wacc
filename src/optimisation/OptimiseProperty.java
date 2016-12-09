package optimisation;

import ast.ASTNode;
import ast.expression.ExpressionNode;

import java.util.Stack;

public class OptimiseProperty {

//    private ExpressionNode expressionNode;
    private ASTNode value;
    private int initLevel;
    private Stack<Integer> assignLevels;
    private boolean canOptimise;

    public OptimiseProperty(ASTNode value, int initLevel) {
        this.value = value;
        this.initLevel = initLevel;
        this.assignLevels = new Stack<>();
        this.canOptimise = true;
    }

//    public OptimiseProperty(ExpressionNode expressionNode, int initLevel) {
//        this.expressionNode = expressionNode;
//        this.initLevel = initLevel;
//        this.assignLevels = new Stack<>();
//        this.canOptimise = true;
//    }

//    public ExpressionNode getExpressionNode() {
//        return expressionNode;
//    }

    public ASTNode getValue() {
        return value;
    }


//    public void setExpressionNode(ExpressionNode expressionNode) {
//        this.expressionNode = expressionNode;
//    }

    public void setValue(ASTNode value) {
        this.value = value;
    }

    public int getInitLevel() {
        return initLevel;
    }

    public Integer peekAssignLevels() {
        if (assignLevels.isEmpty()) {
            return null;
        } else {
            return assignLevels.peek();
        }
    }

    public Integer popAssignLevels() {
        if (assignLevels.isEmpty()) {
            return null;
        } else {
            return assignLevels.pop();
        }
    }

    public void pushAssignLevels(Integer integer) {
        assignLevels.push(integer);
    }

    public boolean isCanOptimise() {
        return canOptimise;
    }

    public void setCanOptimise(boolean canOptimise) {
        this.canOptimise = canOptimise;
    }
}
