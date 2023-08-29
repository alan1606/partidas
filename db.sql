drop database if exists partidas;

create database if not exists partidas CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

use partidas;

create table portafolios(
	id bigint unsigned not null auto_increment,
    nombre varchar(60) not null,
    constraint pk_id primary key(id)
);

create table socios(
	id bigint unsigned not null auto_increment,
    nombre varchar(150) not null,
    constraint pk_id primary key(id)
);

create table proyectos(
	id bigint unsigned not null auto_increment,
    inicio date not null,
    fin date not null,
    portafolio_id bigint unsigned not null,
    constraint pk_id primary key(id),
    constraint fk_proyecto_portafolio foreign key(portafolio_id) references portafolios(id)
);

create table materiales(
	id bigint unsigned not null auto_increment,
    nombre varchar(250) not null,
    unidad varchar(20) not null,
    constraint pk_id primary key(id)
);

create table actividades(
	id bigint unsigned not null auto_increment,
    proyecto_id bigint unsigned not null,
    nombre varchar(254) not null,
    inicio date not null,
    fin date not null,
    constraint pk_id primary key(id),
    constraint fk_actividades_proyecto foreign key(proyecto_id) references proyectos(id)
);

create table actividades_socios(
	id bigint unsigned not null auto_increment,
    actividad_id bigint unsigned not null,
    socio_id bigint unsigned not null,
    constraint pk_id primary key(id),
    constraint fk_actividades_socios_actividades foreign key(actividad_id) references actividades(id),
    constraint fk_actividades_socios_socio foreign key(socio_id) references socios(id)
);

create table actividades_materiales(
	id bigint unsigned not null auto_increment,
    actividad_id bigint unsigned not null,
    material_id bigint unsigned not null,
    cantidad int not null,
    descripcion text not null,
    cotizar boolean not null,
    constraint pk_id primary key(id),
    constraint fk_actividades_materiales_actividad foreign key(actividad_id) references actividades(id),
    constraint fk_actividades_materiales_material foreign key(material_id) references materiales(id)
);