grammar Figure;

program: dslVersion declarations statements EOF;

dslVersion: 'DSL' 'version' VERSION ';';
declarations: declaration*;
declaration: droneTypeDeclaration | positionDeclaration | velocityDeclaration | distanceDeclaration | figureDeclaration;
droneTypeDeclaration: 'DroneType' ID ';';
positionDeclaration: 'Position' ID '=' COORDINATE ';';

velocityDeclaration: 'Velocity' ID '=' velocityExpr ';';
velocityExpr: NUMBER | DECIMAL_LIT | PI_DIV_EXPR | ID;
distanceDeclaration: 'Distance' ID '=' (NUMBER | ID) ';';

figureDeclaration
    : 'Line' ID LPAREN ID ',' figureParam ',' ID RPAREN ';'
    | 'Rectangle' ID LPAREN ID ',' figureParam ',' figureParam ',' ID RPAREN ';'
    | 'Circle' ID LPAREN ID ',' figureParam ',' ID RPAREN ';'
    | 'Circumference' ID LPAREN ID ',' figureParam ',' ID RPAREN ';'
    ;

figureParam: expression | ID | NUMBER;

expression
    : NUMBER                      # NumberExpr
    | ID                          # IdExpr
    | PI                          # PiExpr
    | '-' NUMBER                  # NegativeNumberExpr
    | '-' ID                      # NegativeIdExpr
    | expression '*' expression   # MultiplyExpr
    | expression '/' expression   # DivideExpr
    | expression '+' expression   # AddExpr
    | expression '-' expression   # SubtractExpr
    | NUMBER '*' PI               # NumberPiExpr
    | ID '*' PI                   # IdPiExpr
    | LPAREN expression RPAREN    # ParenExpr
    ;

statements: statement*;

statement
    : beforeBlock
    | afterBlock
    | groupBlock
    | PAUSE_STATEMENT
    | singleAction
    ;

beforeBlock: 'before' blockContent 'endbefore';
afterBlock: 'after' blockContent 'endafter';
groupBlock: 'group' blockContent 'endgroup';

blockContent: (singleAction | groupBlock)*;

singleAction: figureAction;

figureAction
    : ID '.' 'lightsOn' LPAREN colorValue RPAREN ';'                                  # LightsOnAction
    | ID '.' 'lightsOff' ';'                                                          # LightsOffAction
    | ID '.' 'move' LPAREN COORDINATE ',' distanceValue ',' velocityValue RPAREN ';'  # MoveAction
    | ID '.' 'movePos' LPAREN ID ',' velocityValue RPAREN ';'                         # MovePosAction
    | ID '.' 'rotate' LPAREN ID ',' ID ',' rotationValue ',' velocityValue RPAREN ';' # RotateAction
    ;

distanceValue: NUMBER | ID;
velocityValue: ID;
rotationValue
    : NUMBER '*' PI
    | '-' NUMBER '*' PI
    | ID
    | expression
    ;
colorValue: RED | GREEN | BLUE | YELLOW;

PAUSE_STATEMENT: 'pause' '(' [0-9]+ ')' ';';

RED: 'RED';
GREEN: 'GREEN';
BLUE: 'BLUE';
YELLOW: 'YELLOW';
PI: 'PI';

PI_DIV_EXPR: 'PI/10' | 'PI/20' | 'PI/' [0-9]+ | 'PI / 10' | 'PI / ' [0-9]+;
DECIMAL_LIT: [0-9]+ '.' [0-9]+;

COORDINATE: '(' [-]?[0-9]+ (',' [ ]* [-]?[0-9]+)* ')';

LPAREN: '(';
RPAREN: ')';
SEMICOLON: ';';
COMMA: ',';

NUMBER: [0-9]+;
VERSION: [0-9]+ ('.' [0-9]+)*;
ID: [a-zA-Z][a-zA-Z0-9_]*;

WHITESPACE: [ \t\r\n]+ -> skip;
COMMENT: '//' ~[\r\n]* -> skip;
