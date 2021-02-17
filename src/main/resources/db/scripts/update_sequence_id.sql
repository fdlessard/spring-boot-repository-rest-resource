SELECT setval('public.customer_group_id_seq', (SELECT MAX(id) + 100 from public.customer_group));
