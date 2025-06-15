grammar ShowDescription;

show       : 'show' STRING '{' figure+ '}';
figure     : 'figure' STRING '{' droneAction+ '}';
droneAction: 'drone' ID ':' action ';';
action     : holdAction | rotateAction | moveAction;

holdAction    : 'hold' duration;
rotateAction  : 'rotate' angle 'around' axis;
moveAction    : 'move' 'to' position;

duration   : INT 's';
angle      : ('-'? INT);
axis       : 'X' | 'Y' | 'Z';
position   : '(' INT ',' INT ',' INT ')';

ID         : [a-zA-Z_][a-zA-Z0-9_]*;
INT        : [0-9]+;
STRING     : '"' (~["\r\n])* '"';
WS         : [ \t\r\n]+ -> skip;
