alter table users add constraint unique_username unique(username);
alter table users add constraint unique_email unique(email);
