--Entidades: usuario y token

CREATE TABLE public.user (
    id uuid DEFAULT gen_random_uuid() NOT NULL,
    email character varying NOT NULL,
    first_name character varying NOT NULL,
    last_name character varying NOT NULL,
    active boolean NOT NULL,
    password character varying
);

CREATE TABLE public.token (
    code uuid DEFAULT gen_random_uuid() NOT NULL,
    content character varying NOT NULL,
    active boolean DEFAULT true NOT NULL,
    "timestamp" timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    user_id uuid
);

ALTER TABLE ONLY public.user
    ADD CONSTRAINT user_pk PRIMARY KEY (id);
   

ALTER TABLE ONLY public.token
    ADD CONSTRAINT token_pk PRIMARY KEY (code);

  
ALTER TABLE ONLY public.token
    ADD CONSTRAINT token_fk FOREIGN KEY (user_id) REFERENCES public.user(id) ON UPDATE CASCADE ON DELETE CASCADE;
    
--Entidades: asignación de roles
   
CREATE TABLE public.role (
    id character varying NOT NULL,
    role character varying NOT NULL
);


CREATE TABLE public.userxrole (
    id uuid DEFAULT gen_random_uuid() NOT NULL,
    id_user uuid,
    id_role character varying,
    assignation_date timestamp without time zone NOT NULL,
    status boolean
);

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pk PRIMARY KEY (id);
    
   
ALTER TABLE ONLY public.userxrole
    ADD CONSTRAINT userxrole_pk PRIMARY KEY (id);
    
   
ALTER TABLE ONLY public.userxrole
    ADD CONSTRAINT userxrole_fk FOREIGN KEY (id_user) REFERENCES public.user(id) ON UPDATE CASCADE;


ALTER TABLE ONLY public.userxrole
    ADD CONSTRAINT userxrole_fk_role FOREIGN KEY (id_role) REFERENCES public.role(id) ON UPDATE CASCADE;
    
   
   
--Entidades: producto.
   
CREATE TABLE public.company (
    id uuid DEFAULT gen_random_uuid() NOT NULL,
    company character varying NOT null,
    taxid character varying not null
);
   
   
CREATE TABLE public.category (
    id character varying NOT NULL,
    role character varying NOT NULL
);

CREATE TABLE public.product (
    id uuid DEFAULT gen_random_uuid() NOT NULL,
    name character varying NOT NULL,
    image character varying NOT NULL,
    id_category character varying,
    description character varying,
    price double precision,
    id_company uuid
);

ALTER TABLE ONLY public.company
    ADD CONSTRAINT company_pk PRIMARY KEY (id);
   
ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pk PRIMARY KEY (id);
   
ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pk PRIMARY KEY (id);
   
ALTER TABLE ONLY public.product
    ADD CONSTRAINT company_fk FOREIGN KEY (id_company) REFERENCES public.company(id) ON UPDATE CASCADE;
   
ALTER TABLE ONLY public.product
    ADD CONSTRAINT category_fk FOREIGN KEY (id_category) REFERENCES public.category(id) ON UPDATE CASCADE;
   
--Entidades: cart y compra
   

CREATE TABLE public.cart (
    id uuid DEFAULT gen_random_uuid() NOT NULL,
    user_id uuid,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    active boolean DEFAULT true NOT NULL,
    CONSTRAINT cart_pk PRIMARY KEY (id),
    CONSTRAINT cart_fk_user FOREIGN KEY (user_id) REFERENCES public.user(id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE public.cart_item (
    id uuid DEFAULT gen_random_uuid() NOT NULL,
    cart_id uuid,
    product_id uuid,
    quantity integer NOT NULL,
    price double precision NOT NULL,
    CONSTRAINT cart_item_pk PRIMARY KEY (id),
    CONSTRAINT cart_item_fk_cart FOREIGN KEY (cart_id) REFERENCES public.cart(id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT cart_item_fk_product FOREIGN KEY (product_id) REFERENCES public.product(id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE public.order (
    id uuid DEFAULT gen_random_uuid() NOT NULL,
    user_id uuid,
    cart_id uuid,
    order_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    total_amount double precision NOT NULL,
    status character varying NOT NULL,
    payment_method character varying,  
    CONSTRAINT order_pk PRIMARY KEY (id),
    CONSTRAINT order_fk_user FOREIGN KEY (user_id) REFERENCES public.user(id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT order_fk_cart FOREIGN KEY (cart_id) REFERENCES public.cart(id) ON UPDATE CASCADE ON DELETE CASCADE
);