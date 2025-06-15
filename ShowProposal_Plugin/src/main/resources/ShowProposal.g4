grammar ShowProposal;

document: header body attachments EOF;

header: salutation recipient_block reference_number_date proposal_title?;
body: (paragraph)+ closing;
closing: paragraph paragraph paragraph paragraph;
attachments: page_break attachment_section;

recipient_block: recipient_name? company_name address_block vat_number additional_recipient_info?;
recipient_name: TEXT NEWLINE;
company_name: TEXT NEWLINE;
address_block: TEXT NEWLINE;
vat_number: TEXT NEWLINE+;
reference_number_date: TEXT NEWLINE;
additional_recipient_info: TEXT NEWLINE;

salutation: TEXT NEWLINE;
proposal_title: TEXT NEWLINE NEWLINE?;

paragraph: TEXT NEWLINE NEWLINE?;
location: TEXT NEWLINE+;
date: TEXT NEWLINE+;
time: TEXT NEWLINE+;
duration: TEXT NEWLINE+;
list_drones: title list_drone_items NEWLINE+;
list_figures: title list_figure_items;
list_drone_items: (TEXT NEWLINE)+ DOTS NEWLINE?;
list_figure_items: (TEXT NEWLINE)+ DOTS NEWLINE?;
title: TEXT NEWLINE+;

page_break: PAGE_BREAK NEWLINE+ | SEPARATOR_LINE NEWLINE+ | NEWLINE+;
attachment_section: attachment_title location date time duration list_drones list_figures;
attachment_title: TEXT NEWLINE+;

DATE_SEPARATOR: '/' | '-' | '.';
PAGE_BREAK: '[page break]' NEWLINE?;
SEPARATOR_LINE: '---' | '***';
DOTS: '...';
NUMBER: [0-9]+;

TEXT: ~[\r\n]+;
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;