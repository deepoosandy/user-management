
INSERT INTO roles (id, role_name, role_descriptions) VALUES (1, 'REST_ADMIN','Admin has all the rights');
INSERT INTO roles (id, role_name,role_descriptions) VALUES (2, 'REST_MANGER','Manger have some specific rights');
INSERT INTO roles (id, role_name,role_descriptions) VALUES (3, 'REST_USER','User have only limited right.');



INSERT INTO authorities (id, authority, authority_description) VALUES (1, 'VIEW','For view');
INSERT INTO authorities (id, authority,authority_description) VALUES (2, 'EDIT','For edit');
INSERT INTO authorities (id, authority,authority_description) VALUES (3, 'DELETE','For deleting.');
INSERT INTO authorities (id, authority,authority_description) VALUES (4, 'CREATE','For creating.');


INSERT INTO role_authority_mapping ( role_id, authority_id) VALUES (1,1);
INSERT INTO role_authority_mapping ( role_id,authority_id) VALUES (1,2);
INSERT INTO role_authority_mapping ( role_id,authority_id) VALUES (1,3);
INSERT INTO role_authority_mapping ( role_id,authority_id) VALUES (1,4);