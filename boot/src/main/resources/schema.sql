
drop sequence if exists operacion_seq;

drop index if exists OPERATION_PK;

drop table if exists OPERATION;

/*==============================================================*/
/* Table: OPERATION                                               */
/*==============================================================*/
create table OPERATION 
(
   CODIGO_OPERATION       numeric                        not null,
   CODIGO_TIPO_OPERATION  varchar(10)                        not null,
   constraint OPERATION_PK primary key (CODIGO_OPERATION)
);

comment on table OPERATION is 
'Informacion sobre Operaciones';

/*==============================================================*/
/* Index: OPERATION_PK                                            */
/*==============================================================*/
create unique index OPERATION_PK on OPERATION (
CODIGO_OPERATION ASC
);


CREATE SEQUENCE operacion_seq INCREMENT 1 MINVALUE 1 MAXVALUE 999999999999 START 1 CYCLE;

