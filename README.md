#### Executando o projeto
Execute na raiz do projeto: ```docker-compose up```

Entre em http://localhost:8081/phpmyadmin/ 

No sql execute ```GRANT ALL ON *.* TO 'root'@'%' identified by 'root'; FLUSH PRIVILEGES;```

No sql crie o esquema com o comando ```CREATE SCHEMA web;```


