grammar DroneTwo;

program: (statement NEWLINE?)* EOF;

statement
    : figureDeclaration
    | variableDeclaration
    | command
    ;

figureDeclaration
    : 'figure' ID '{' (statement NEWLINE?)* '}' ('requires' droneCapabilities)?
    ;

droneCapabilities
    : capability (',' capability)*
    ;

capability
    : 'LED'
    | 'ROTATION'
    | 'TRANSLATION'
    | 'HOVER'
    ;

variableDeclaration
    : type ID '=' expression ';'
    ;

command
    : takeoff
    | land
    | movePoint
    | moveVector
    | movePath
    | moveCircleAngle
    | moveCircleDuration
    | hoover
    | lightsOn
    | lightsOff
    | waitCommand
    | environmentCheck
    ;

takeoff            : 'takeOff' '(' FLOAT ',' FLOAT ')' ('when' condition)? ';';
land               : 'land' '(' FLOAT ')' ('when' condition)? ';';
movePoint          : 'move' '(' point ',' FLOAT ')' ('when' condition)? ';';
moveVector         : 'move' '(' vector ',' FLOAT ',' INT ')' ('when' condition)? ';';
movePath           : 'movePath' '(' pointArray ',' FLOAT ')' ('when' condition)? ';';
moveCircleAngle    : 'moveCircle' '(' point ',' FLOAT ',' FLOAT ')' ('when' condition)? ';';
moveCircleDuration : 'moveCircle' '(' point ',' INT ',' FLOAT ')' ('when' condition)? ';';
hoover             : 'hoover' '(' INT ')' ('when' condition)? ';';
lightsOn           : 'lightsOn' '(' color ')' ('when' condition)? ';';
lightsOff          : 'lightsOff' '(' ')' ('when' condition)? ';';
waitCommand        : 'wait' '(' INT ')' ';';
environmentCheck   : 'checkWind' '(' FLOAT ',' FLOAT ',' FLOAT ')' ';';

condition
    : environmentCondition
    | timeCondition
    | positionCondition
    ;

environmentCondition
    : 'wind' comparison FLOAT
    ;

timeCondition
    : 'time' comparison INT
    ;

positionCondition
    : 'position' comparison point
    ;

comparison
    : '<'
    | '>'
    | '=='
    | '<='
    | '>='
    ;

expression
    : value (('-'|'+') value)*
    ;

value
    : point
    | vector
    | FLOAT
    | INT
    | ID
    | 'PI'
    ;

point       : '(' FLOAT ',' FLOAT ',' FLOAT ')';
vector      : '(' FLOAT ',' FLOAT ',' FLOAT ')';
pointArray  : '(' point (',' point)* ')';
color       : ID;

type: 'Point' | 'Vector' | 'LinearVelocity' | 'AngularVelocity' | 'Distance' | 'Time';

ID    : [a-zA-Z_][a-zA-Z_0-9]*;
INT   : [0-9]+;
FLOAT : [0-9]+ '.' [0-9]+;

NEWLINE : [\r\n]+;
WS : [ \t]+ -> skip;
COMMENT : '//' ~[\r\n]* -> skip;
