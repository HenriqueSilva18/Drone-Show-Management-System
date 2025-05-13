grammar ShowProposal;

document
    : header
      body
      closing
      (attachments)?
      EOF
    ;

header
    : salutation?
      recipient_block
      reference_block?
      proposal_title?
    ;

recipient_block
    : (recipient_name)?
      (company_name)?
      (address_block)?
      (vat_number)?
      (additional_recipient_info)*
    ;

body
    : (paragraph | bullet_list | numbered_list | section_header)+
    ;

// Closing section
closing
    : (closing_remarks)?
      (signature_block)?
    ;

attachments
    : page_break
      (attachment_section)+
      EOF
    ;

salutation
    : TEXT NEWLINE
    ;

recipient_name
    : TEXT NEWLINE
    ;

company_name
    : TEXT NEWLINE
    ;

address_block
    : TEXT NEWLINE
      (TEXT NEWLINE)*
    ;

vat_number
    : TEXT NEWLINE
    ;

additional_recipient_info
    : TEXT NEWLINE
    ;

reference_block
    : (REFERENCE_LABEL | TEXT) (COLON | DASH)? TEXT (DATE_SEPARATOR TEXT)? NEWLINE
    ;

proposal_title
    : TEXT NEWLINE NEWLINE?
    ;

paragraph
    : TEXT NEWLINE NEWLINE?
    ;

bullet_list
    : bullet_item+ end_item?
    ;

bullet_item
    : (BULLET | ASTERISK | DASH) TEXT NEWLINE
    ;

end_item
    : (BULLET | ASTERISK | DASH) DOTS NEWLINE
    ;

numbered_list
    : numbered_item+ end_numbered_item?
    ;

numbered_item
    : NUMBER (DOT | RPAREN) TEXT NEWLINE
    ;

end_numbered_item
    : NUMBER (DOT | RPAREN) DOTS NEWLINE
    ;

section_header
    : (HASH+ | NUMBER DOT | NEWLINE)? TEXT NEWLINE*
    ;

closing_remarks
    : paragraph
    ;

signature_block
    : TEXT NEWLINE
      (TEXT NEWLINE)*
      NEWLINE*
    ;

page_break
    : PAGE_BREAK NEWLINE NEWLINE*
    | SEPARATOR_LINE NEWLINE NEWLINE*
    | NEWLINE+
    ;

attachment_section
    : section_header
      (paragraph | bullet_list | numbered_list | key_value_pair | table | NEWLINE)+ DOTS NEWLINE? EOF?
    ;

key_value_pair
    : TEXT (COLON | DASH) TEXT NEWLINE NEWLINE*
    ;

table
    : (table_row)+ NEWLINE*
    ;

table_row
    : (table_cell)+ NEWLINE
    ;

table_cell
    : TEXT (COMMA | PIPE)?
    ;

BULLET : '•' | '·' | '○' | '▪' | '▫' | '◦' ;
ASTERISK : '*' ;
DASH : '-' | '—' | '–' ;
HASH : '#' ;
NUMBER : [0-9]+ ;
DOT : '.' ;
COLON : ':' ;
RPAREN : ')' ;
COMMA : ',' ;
PIPE : '|' ;
DATE_SEPARATOR : '/' | '-' | '.' ;
REFERENCE_LABEL : 'Referência' | 'Reference' ;
PAGE_BREAK : '[page break]' ;
SEPARATOR_LINE : '---' | '***' ;
DOTS : '...' ;

TEXT : ~[\r\n]+ ;
NEWLINE : '\r'? '\n' ;
WS : [ \t]+ -> skip ;