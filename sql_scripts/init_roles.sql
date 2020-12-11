INSERT INTO public.roles(
    id, description, name)
VALUES (1, 'Allows the management of the overall application.', 'ADMIN'),
       (2, 'Read access to existing data and dashboard.', 'ANALYST'),
       (3, 'Allows write access to the data including reconciliation and batch uploading.', 'COLLECTOR');