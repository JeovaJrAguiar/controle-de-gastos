## Preparando o ambiente
Para montar o container com docker, execute na raiz do projeto: ```docker-compose up```

Entre em http://localhost:8081/phpmyadmin/ 

No sql execute ```GRANT ALL ON *.* TO 'root'@'%' identified by 'root'; FLUSH PRIVILEGES;```

No sql crie o esquema com o comando ```CREATE SCHEMA web;```

## Executando o projeto 
Entre em back. Execute.

Entre em front. Execute estando dentro do diretorio front: ```ng serve --open```

## Padrão
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
US003
```
