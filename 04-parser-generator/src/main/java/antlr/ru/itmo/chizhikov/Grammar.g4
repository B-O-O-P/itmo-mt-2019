grammar Grammar;

file : pckg? (start rulee+)? EOF;

start: '|>' NON_TERM;
pckg : '+package' PCKG_NAME;

rulee
	: parserRulee ';'
	| lexerRulee ';'
	;

parserRulee : NON_TERM inAttrs? (':' outAttr)? ':=' prods ('|' prods)*;

inAttrs : '<' param (',' param)* '>';
param : paramName ':' paramType;
paramType : TERM;
paramName : NON_TERM;
outAttr: TERM;

prods: prod*;
prod: NON_TERM args? | TERM | CODE;
args: '(' arg (',' arg)* ')';
arg : NON_TERM | TERM | CODE;

lexerRulee
	: TERM '=' term_value # tokenRule
	| TERM '=>' term_value # skipRule
	;

term_value
	: REGEX
	| STRING
	;

NON_TERM : [a-z][a-zA-Z0-9]*;
TERM : [A-Z][a-zA-Z0-9]*;

REGEX : '\'' (~('\''|'\r' | '\n') | '\\\'')* '\'';
STRING : '"' (~('"') | '\\"')* '"';

CODE : '{' (~[{}]+ CODE?)* '}' ;
PCKG_NAME : ([a-z0-9] | '.')+;

WS  : [ \t\r\n]+ -> skip ;