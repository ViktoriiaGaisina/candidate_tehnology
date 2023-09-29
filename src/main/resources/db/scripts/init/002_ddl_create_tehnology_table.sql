create table if not exists tehnology(
    id serial primary key,
    name varchar,
    level int,
    fk_candidate_id int references tehnology(id)
)