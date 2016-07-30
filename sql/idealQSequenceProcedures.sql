
CREATE procedure xxidq_ideas_header_s(out sequence_number bigint)
begin
START TRANSACTION;
insert into xxidq_ideas_header_seq values(0);
set sequence_number = (select last_insert_id());
rollback;
end;
/



CREATE procedure xxidq_activity_domains_s(out sequence_number bigint)
begin
START TRANSACTION;
insert into xxidq_activity_domains_seq values(0);
set sequence_number = (select last_insert_id());
rollback;
end;
/

CREATE procedure xxidq_idea_key_words_s(out sequence_number bigint)
begin
START TRANSACTION;
insert into xxidq_idea_key_words_seq values(0);
set sequence_number = (select last_insert_id());
rollback;
end;
/

CREATE procedure xxidq_idea_details_s(out sequence_number bigint)
begin
START TRANSACTION;
insert into xxidq_idea_details_seq values(0);
set sequence_number = (select last_insert_id());
rollback;
end;
/


CREATE procedure xxidq_clients_s(out sequence_number bigint)
begin
START TRANSACTION;
insert into xxidq_clients_seq values(0);
set sequence_number = (select last_insert_id());
rollback;
end;
/


CREATE procedure xxidq_client_categories_s(out sequence_number bigint)
begin
START TRANSACTION;
insert into xxidq_client_categories_seq values(0);
set sequence_number = (select last_insert_id());
rollback;
end;
/


CREATE procedure xxidq_client_categories_tl_s(out sequence_number bigint)
begin
START TRANSACTION;
insert into xxidq_client_categories_tl_seq values(0);
set sequence_number = (select last_insert_id());
rollback;
end;
/


CREATE procedure xxidq_languages_s(out sequence_number bigint)
begin
START TRANSACTION;
insert into xxidq_languages_seq values(0);
set sequence_number = (select last_insert_id());
rollback;
end;
/

CREATE procedure xxidq_client_credentials_s(out sequence_number bigint)
begin
START TRANSACTION;
insert into xxidq_client_credentials_seq values(0);
set sequence_number = (select last_insert_id());
rollback;
end;
/
