grammar DroneTwo;

program: (statement NEWLINE?)* EOF;

statement
    : variableDeclaration
    | command
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
    ;

takeoff            : 'takeOff' '(' FLOAT ',' FLOAT ')' ';';
land               : 'land' '(' FLOAT ')' ';';
movePoint          : 'move' '(' point ',' FLOAT ')' ';';
moveVector         : 'move' '(' vector ',' FLOAT ',' INT ')' ';';
movePath           : 'movePath' '(' pointArray ',' FLOAT ')' ';';
moveCircleAngle    : 'moveCircle' '(' point ',' FLOAT ',' FLOAT ')' ';';
moveCircleDuration : 'moveCircle' '(' point ',' INT ',' FLOAT ')' ';';
hoover             : 'hoover' '(' INT ')' ';';
lightsOn           : 'lightsOn' '(' color ')' ';';
lightsOff          : 'lightsOff' '(' ')' ';';

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
FLOAT : [0-9]+ ('.' [0-9]+)?;
INT   : [0-9]+;

NEWLINE : [\r\n]+;
WS : [ \t]+ -> skip;
