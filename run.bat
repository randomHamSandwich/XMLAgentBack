cd ad
call mvnw package
cd ..
cd aut-s
call mvnw package 
cd ..
cd Zuul
call mvnw package 
cd ..
start /wait docker-compose build --force-rm --no-cache 
start /wait docker-compose up --detach

