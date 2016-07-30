  
  /*drop table xxidq_ideas_header;
drop table xxidq_activity_domains;
drop table xxidq_idea_key_words;
drop table xxidq_idea_details;*/

CREATE TABLE xxidq_ideas_header_seq
  (
    id            bigint auto_increment ,
    primary key (id)
  );
  
CREATE TABLE xxidq_activity_domains_seq
  (
    id            bigint auto_increment ,
    primary key (id)
  );
  
create table xxidq_idea_key_words_seq  (
    id            bigint auto_increment ,
    primary key (id)
);

CREATE TABLE xxidq_idea_details_seq
  (
    id            bigint auto_increment ,
    primary key (id)
  );
  
  
  --create table table_test (id bigint auto_increment, primary key(id));
  
 create table xxidq_clients_seq
 (    id            bigint auto_increment ,
    primary key (id));

 create table xxidq_client_categories_seq
 (    id            bigint auto_increment ,
    primary key (id)
  );
  
  create table xxidq_client_categories_tl_seq
  (    id            bigint auto_increment ,
    primary key (id));
  
    create table xxidq_languages_seq
  (    id            bigint auto_increment ,
    primary key (id));

   
   
   create table xxidq_client_credentials_seq
 (    id            bigint auto_increment ,
    primary key (id));