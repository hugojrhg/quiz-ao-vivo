# MANUAL DO SISTEMA
### Este é o manual para fazer o sistema rodar...

#### Primeiro rode o comando a baixo para instalar todas dependencias necessarias
``` bash

mvn clean install -DskipTests

```
#### Segundo rodar o comando abaixo pra criar todo esquema do banco

``` bash

mvn flyway:migrate

```