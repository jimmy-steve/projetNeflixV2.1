select * from netflix;


select * from netflix_titles;

-- Les plus récent show canadiens
select * from netflix 
where country like 'Canada' and type like 'TV Show' and release_year >= 2020;


-- la liste pour les film kids
select * from netflix where listed_in like '%Kids%';

-- la liste pour Sci-Fi
select * from netflix where listed_in like '%Sci-Fi%';

-- la liste pour Thrillers
select * from netflix where listed_in like '%Thrillers%';