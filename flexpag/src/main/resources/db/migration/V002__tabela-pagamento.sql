create table pagamento (
id bigint not null auto_increment,
usuario_id bigint not null,
valorpagamento decimal(10,2) not null,
status varchar(20)not null,
datapagamento date not null,


primary key (id)

);
alter table pagamento add constraint fk_pagamento_usuario foreign key (usuario_id) references usuario (id)