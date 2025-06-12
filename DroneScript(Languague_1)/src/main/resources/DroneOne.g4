grammar DroneOne;

program: (statement NEWLINE?)* EOF;

statement
    : variableDeclaration
    | figure
    ;

figure
    : 'figure' ID 'requires' capabilities '{' (command NEWLINE?)* '}' ';'
    ;

capabilities
    : capability (',' capability)*
    ;

capability
    : 'TRANSLATION'
    | 'ROTATION'
    | 'HOVER'
    | 'LED'
    ;

variableDeclaration
    : type ID '=' expression ';'
    ;

command
    : takeoff
    | land
    | movePosition
    | moveVector
    | movePath
    | hoover
    | lightsOn
    | lightsOff
    | blink
    ;

takeoff       : 'takeOff' '(' FLOAT ',' FLOAT ')' ';';
land          : 'land' '(' FLOAT ')' ';';
movePosition  : 'move' '(' position ',' FLOAT ')' ';';
moveVector    : 'move' '(' vector ',' FLOAT ',' INT ')' ';';
movePath      : 'movePath' '(' positionArray ',' FLOAT ')' ';';
hoover        : 'hoover' '(' INT ')' ';';
lightsOn      : 'lightsOn' '(' ')' ';';
lightsOff     : 'lightsOff' '(' ')' ';';
blink         : 'blink' '(' INT ')' ';';

expression
    : value (('-'|'+') value)*
    ;

value
    : position
    | vector
    | FLOAT
    | INT
    | ID
    | 'PI'
    ;

position      : '(' FLOAT ',' FLOAT ',' FLOAT ')';
vector        : '(' FLOAT ',' FLOAT ',' FLOAT ')';
positionArray : '(' position (',' position)* ')';

type: 'Position' | 'Vector' | 'LinearVelocity' | 'AngularVelocity' | 'Distance' | 'Time';

ID    : [a-zA-Z_][a-zA-Z_0-9]*;
FLOAT : [0-9]+ ('.' [0-9]+)?;
INT   : [0-9]+;

NEWLINE : [\r\n]+;
WS : [ \t]+ -> skip;
