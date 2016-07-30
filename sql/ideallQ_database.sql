  
  /*drop table xxidq_ideas_header;
drop table xxidq_activity_domains;
drop table xxidq_idea_key_words;
drop table xxidq_idea_details;*/

CREATE TABLE xxidq_ideas_header
  (
    idea_id            bigint auto_increment ,
    primary key (idea_id),
    raw_description    VARCHAR(2000),
    status             VARCHAR(50),
    client_id          bigint,
    opening_date       DATE,
    closing_date       DATE,
    activity_domain_id bigint ,
    creation_date      DATE,
    created_by         VARCHAR(100),
    last_update_date   DATE,
    last_updated_by    VARCHAR(100)
  );
  
CREATE TABLE xxidq_activity_domains
  (
    id               bigint  auto_increment ,
     primary key(id),
    code             VARCHAR(100),
    description      VARCHAR(250),
    data_in          DATE,
    data_out         DATE,
    creation_date    DATE,
    created_by       VARCHAR(100),
    last_update_date DATE,
    last_updated_by  VARCHAR(100)
  );
  
create table xxidq_idea_key_words  (
    id               bigint auto_increment  ,
    primary key(id),
    code             VARCHAR(100),
    description      VARCHAR(250),
    data_in          DATE,
    data_out         DATE,
    creation_date    DATE,
    created_by       VARCHAR(100),
    last_update_date DATE,
    last_updated_by  VARCHAR(100)
);

CREATE TABLE xxidq_idea_details
  (
    id               bigint  auto_increment  ,
    primary key(id),
    idea_id          bigint,
    key_word_id      bigint,
    creation_date    DATE,
    created_by       VARCHAR(100),
    last_update_date DATE,
    last_updated_by  VARCHAR(100)
  );
  
  
  --create table table_test (id bigint auto_increment, primary key(id));
  
 create table xxidq_clients
 (client_id bigint auto_increment,
     primary key(client_id),
  denumire	varchar(250),
  categorie	bigint,
  creation_date date,
  created_by varchar(100),
  last_update_date date,
  last_updated_by varchar(100));

 create table xxidq_client_categories
 (id bigint auto_increment,
     primary key(id),
  category_code varchar(50),
      data_in          DATE,
    data_out         DATE,
  creation_date date,
  created_by varchar(100),
  last_update_date date,
  last_updated_by varchar(100)
  );
  
  create table xxidq_client_categories_tl
  (id bigint auto_increment,
     primary key(id),
  category_code varchar(50),
  language varchar(50),
  description varchar(200),
  creation_date date,
  created_by varchar(100),
  last_update_date date,
  last_updated_by varchar(100));
  
    create table xxidq_languages
  (id bigint auto_increment,
     primary key(id),
  language_code varchar(50),
  language_name varchar(50),
  creation_date date,
  created_by varchar(100),
  last_update_date date,
  last_updated_by varchar(100));
  
  create table xxidq_individual_clients
  (client_id bigint,
       primary key(client_id),
   nume varchar(200),
   prenume varchar(250),
   cnp varchar(15),
   birth_date date,
  creation_date date,
  created_by varchar(100),
  last_update_date date,
  last_updated_by varchar(100)
   );
   
   
   create table xxidq_client_credentials
 (id bigint auto_increment,
 primary key(id),
 client_id bigint,
  user_name	varchar(250),
  encr_password	varchar(4000),
  social_media_account varchar(2000),
      data_in          DATE,
    data_out         DATE,
  creation_date date,
  created_by varchar(100),
  last_update_date date,
  last_updated_by varchar(100));