## Informações base
- O **banco de dados** opera dentro de um container Docker. Sendo um servidor xammp-web,
  Apache/2.4.56 (Unix),
  OpenSSL/1.1.1t,
  PHP/8.2.4 mod_perl/2.0.12 Perl/v5.34.1,
  Database client version: libmysql - mysqlnd 8.2.4,
  PHP extension: mysqli Documentation curl Documentation mbstring Documentation,
  PHP version: 8.2.4
- O **back-end** é uma aplicação REST SpringBoot com AJAX. Desenvolvida com Java17, Maven.
- **Front-end** é uma SPA, construida com Angular17.

## Preparando o ambiente
Para montar o container com docker, execute na raiz do projeto: ```docker-compose up```

Entre em *http://localhost:8081/phpmyadmin/* , no sql do servidor execute ```GRANT ALL ON *.* TO 'root'@'%' identified by 'root'; FLUSH PRIVILEGES;``` , no sql defina o esquema com o comando ```CREATE SCHEMA web;```

## Executando o projeto 
Entre em back. Execute.

Entre em front. Execute estando dentro do diretorio front: ```ng serve --open```

## Padrão Git
- **Branch**: quando criar a branch, usar o nome da issue. Ex:  US0003
- **Commit**:
  - docs: apenas mudanças de documentação;
  - feat: uma nova funcionalidade;
  - fix: a correção de um bug;
  - perf: mudança de código focada em melhorar performance;
  - refactor: mudança de código que não adiciona uma funcionalidade e também não corrigi um bug;
  - style: mudanças no código que não afetam seu significado (espaço em branco, formatação, ponto e vírgula, etc);
  - test: adicionar ou corrigir testes.

Exemplo commit
```
feat(header): criacao de funcionalidade de novo usario.
no botão 'user', ao clicar chamar o modal 'userModal'
US0003
```
