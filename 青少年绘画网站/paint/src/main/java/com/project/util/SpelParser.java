package com.project.util;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpelParser {
    private static ExpressionParser parser = new SpelExpressionParser();

    public static String getKey(String key,String[] paramName,Object[] args){
        //将字符串转换为spring的el表达式
        Expression exp = parser.parseExpression(key);
        //定义赋值上下文
        EvaluationContext context = new StandardEvaluationContext();
        if(args.length < 1){
            return null;
        }
        for(int i = 0;i<args.length;i++){
            //向赋值上下文传入参数名相对应的值
            context.setVariable(paramName[i], args[i]);
        }
        //表达式取值，通过赋值上下文
        return exp.getValue(context,String.class);
    }
}
