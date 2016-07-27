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