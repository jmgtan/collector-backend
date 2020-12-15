insert into users(id, username, password)
    values ('4b844302-1c8b-4255-9ca4-6ffa93d15319', 'jmgtan', 'd47284017a0e7d5ad865ca5b40aab2f94a4aece129b285e1f00f54767621586b'),
        ('7849fdba-dbe5-42b2-8981-76dea1333b2e', 'rosanna', 'd47284017a0e7d5ad865ca5b40aab2f94a4aece129b285e1f00f54767621586b'),
        ('eb68b4a9-2711-4042-9768-578d29b9fd2d', 'testuser', 'd47284017a0e7d5ad865ca5b40aab2f94a4aece129b285e1f00f54767621586b');

insert into users_roles(user_id, role_id)
    values
    ('4b844302-1c8b-4255-9ca4-6ffa93d15319', '4f365eb9-e219-4453-a251-caa4402da8ee'),
    ('4b844302-1c8b-4255-9ca4-6ffa93d15319', 'ac8d50c6-ea42-48e7-9ea7-69f9d3ae6ebe'),
    ('4b844302-1c8b-4255-9ca4-6ffa93d15319', '1af9ba3a-9f70-421e-ac7a-c0422baa436a'),
    ('7849fdba-dbe5-42b2-8981-76dea1333b2e', '4f365eb9-e219-4453-a251-caa4402da8ee'),
    ('7849fdba-dbe5-42b2-8981-76dea1333b2e', 'ac8d50c6-ea42-48e7-9ea7-69f9d3ae6ebe'),
    ('7849fdba-dbe5-42b2-8981-76dea1333b2e', '1af9ba3a-9f70-421e-ac7a-c0422baa436a'),
    ('eb68b4a9-2711-4042-9768-578d29b9fd2d', '4f365eb9-e219-4453-a251-caa4402da8ee'),
    ('eb68b4a9-2711-4042-9768-578d29b9fd2d', 'ac8d50c6-ea42-48e7-9ea7-69f9d3ae6ebe'),
    ('eb68b4a9-2711-4042-9768-578d29b9fd2d', '1af9ba3a-9f70-421e-ac7a-c0422baa436a');
