grammar HaskelMath;

code returns [StringBuilder value]: {
     $value = new StringBuilder();
     } (gs=globalStatement { $value.append("\n" + $gs.value);})+ EOF;

globalStatement returns [StringBuilder value]:
    fd=functionDefinition {
        $value = $fd.value;
    }
    | localStatement {
        $value = new StringBuilder($localStatement.text);
    };


functionDefinition returns [StringBuilder value]:
    {
        $value = new StringBuilder();
    }
    (fh=functionHeader {
     if ($fh.argTypes.size() > 1) {
            $value.append($fh.value);
        }
     })
    (fb=functionBody {
        if ($fh.argTypes.size() > 1) {
            $value.append("{\n  ");
            for (int i = $fh.argTypes.size() - 1; i > 0; i--) {
                $value.append($fh.argTypes.get($fh.argTypes.size() - i - 1) + " " + $fb.argsNames.get(i - 1) + " = a" + ($fh.argTypes.size() - i) + ";\n  ");
            }
            $value.append("if ( ");

            for (int j = 0; j < $fb.argsConiditions.size(); j++) {
                $value.append("(" + $fb.argsConiditions.get(j) + ")" + (j != $fb.argsConiditions.size() - 1 ? " && " : " )"));
            }

            $value.append(" {\n    return " + $fb.body + ";\n  }\n}\n");
        } else {
            $value.append($fh.argTypes.get(0) + " " + $fb.argsNames.get(0) + " = " + $fb.body);
        }
    })+
    {
        $value.append("\n return 0;\n}\n");
    };

functionHeader returns [String value, ArrayList<String> argTypes]:
    WORD DOUBLECOLON type {
        $argTypes = $type.value;
        $value = $argTypes.get(0) + ' ' + $WORD.text + "(";
        for (int i = $argTypes.size() - 1; i > 0; i--) {
            $value += $argTypes.get(i) + " a" + i + (i == 1 ? ") {\n" : ", ");
        }
    };


functionBody returns [String body, ArrayList<String> argsNames, ArrayList<String> argsConiditions]:
    WORD ad=argsDefinition EQ localStatement {
    $body = $localStatement.text;
    $argsNames = $ad.argsNames;
    $argsConiditions = $ad.argsConiditions;
};

argsDefinition returns [ArrayList<String> argsNames, ArrayList<String> argsConiditions]:
    oneArgument COMMA ad=argsDefinition {
        $argsNames = $ad.argsNames;
        $argsNames.add($oneArgument.argName);

        $argsConiditions = $ad.argsConiditions;
        if ($oneArgument.argCondition != null)
            $argsConiditions.add($oneArgument.argCondition);
    }
    | oneArgument {
        $argsNames = new ArrayList<String>();
        $argsNames.add($oneArgument.argName);

        $argsConiditions = new ArrayList<String>();
        if ($oneArgument.argCondition != null)
            $argsConiditions.add($oneArgument.argCondition);
    }
    | {
        $argsNames = null;
        $argsConiditions = null;
    };

oneArgument returns [String argName, String argCondition] :
    LB oa=oneArgument RB {
     $argName = $oa.argName; $argCondition = $oa.argCondition;
     }
    | WORD STICK condition {
     $argName = $WORD.text; $argCondition = $condition.text;
     }
    | WORD {
     $argName = $WORD.text; $argCondition = "true";
    };


callFunction : WORD LB (expr (COMMA expr)*)? RB;

type returns [ArrayList<String> value]:
    TYPE                 {
        $value = new ArrayList<String>();
         if ($TYPE.text.equals("Integer")) {
           $value.add("int");
         } else if ($TYPE.text.equals("Double")) {
           $value.add("double");
         } else {
           $value.add($TYPE.text);
         }
    }
    | TYPE '->' tp=type  {
        $value = $tp.value;
         if ($TYPE.text.equals("Integer")) {
                   $value.add("int");
                 } else if ($TYPE.text.equals("Double")) {
                   $value.add("double");
                 } else {
                   $value.add($TYPE.text);
                 }
    };

data : INTEGER | DOUBLE | BOOLEAN | WORD | callFunction;

localStatement : data EQ expr | expr;

expr :
    data PLUS expr |
    data MINUS expr |
    data DIV expr |
    data MUL expr |
    data MOD expr |
    data;

condition :
    expr LESS condition |
    expr GREATER condition |
    expr AND condition |
    expr OR condition |
    expr DEQ condition |
    expr;

TYPE : 'Integer' | 'Double';
INTEGER   : '-'?[0-9]+;
DOUBLE  : INTEGER '.' [0-9]*;
BOOLEAN : 'True' | 'False';
WORD : [a-zA-Z] [a-zA-Z0-9]*;

WS : [ \t\r\n]+ -> skip;

COMMA  : ',';
LB     : '(';
RB     : ')';
COLON  : ':';
DOUBLECOLON : '::';
SEMICOLON : ';';
EQ     : '=';
STICK  : '|';
ARROW  : '->';

PLUS  : '+';
MINUS : '-';
DIV   : '/';
MUL   : '*';
MOD   : '%';

OR : '||';
AND : '&&';
LESS : '<';
GREATER : '>';
DEQ : '==';

