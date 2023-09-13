
TRUNCATE TABLE public.usuario;
INSERT INTO public.usuario(
	id, account_id, email, name, password, rol)
	VALUES ('1', '2003', 'estsan3@gmail.com', 'Esteban Santamarina', '$2a$10$3.9uXWm3/0aoh9QGO.aV8.RUOshXmymptNfnWuiOrC64saLYwiuoi', 'ADMIN');

INSERT INTO public.usuario(
	id, account_id, email, name, password, rol)
	VALUES ('2', '2003', 'anafran@gmail.com', 'Ana Santamarina', '$2a$10$3.9uXWm3/0aoh9QGO.aV8.RUOshXmymptNfnWuiOrC64saLYwiuoi', 'ADMIN');
