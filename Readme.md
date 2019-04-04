## Processamento Assíncrono:

Ao contrário de um processamento síncrono, onde o processo é bloqueado até que a operação seja concluída. O processamento assíncrono não bloqueia o "chamador" da operação, dessa forma, o "chamador" deve utilizar de outros mecanismos para saber quando a operação for concluída, como uma mensageria, ou até mesmo uma função de callback.

Não implemententei nenhum por falta de tempo.


## Database: 
Para facilitar, fiz uso do SGBD H2, onde os dados estão sendo armazenados em memória, ao subir a aplicação, a base é recriada. Tenho conhecimento em banco de dados no nível intermediários, criação de Query aninhadas e com joins, criação de FK, procedures, triggers, indexes.


## Docker:
utiliza o conceito de contêiner, onde a ideia é o desenvolvedor conseguir empacotar toda sua aplicação, incluindo dependência de bibliotecas externas. 
Dessa forma, tem-se a garantia que a aplicação irá ser executada nas mesmas condições, independente das configurações do host que está hospendando o contêiner docker.

Trabalhei por um período de 4 meses com docker no Banco Central do Brasil, conheço o conceito de imagens e criação de imagens, bem como importação para uso e criar uma imagem a partir de uma coleção de outras imagens.

Ao sair do Banco Central, estava em um curso de Kubernets, ofertado pelo próprio Bacen, pois a equipe de analistas da unidade Recife estão criando um ambiente orquestrado com essa ferramenta.


## AWS: 
Dispõe de serviços cloud computer, desde de servidores virtuais para deploy de aplicações a ambientes específicos para armazenamento de arquivos, e outros tipos de dados. Pode garantir escabilidade, elasticidade, disponibilidade, para aplicativos distribuídos.


## Security: 

A camada de segurança é indispensável para garantir um bom funcionamento da aplicação, não deixando-a com acesso irrestrito. É possível criar regras de acesso, de acordo com logins, senha, tokens, por exemplo.

Atualmente um dos frameworks bastantes utilizados para criar uma camada de segurança em aplicação Java, é o SpringSecutiry. 
Não tive tempo para implentâ-lo no projeto teste, mas seria minha primeira opção, se necessário.


## Swagger : 
Fazendo uso da especificação OpenAPI, o Swagger  consome de uma aplicação RestFull um JSON ou YAML que fornece de forma detalhada, os recursos (endpoints) que aplicação dispôe. Dessa forma, o Swagger pode gerar uma documentação para a API, bem como gerar bibliotecas clientes para a API, essas bibliotecas como podem geradas para diversar linguagens, de forma automatizada.

Utilizei o sweegar no projeto, mas não tive tempo de configurá-lo por completo, mas está funcional. 
Caso queira rodar local: http://localhost:8080/swagger-ui.html


##Clean Code:

Para considerar um código limpo, ma literatura, os autores tem coceitos diferentes entre si, mas no final o que todos procuram é mostrar como escrever códogo fáceis de entender/Ler e alterar.

O código simples de entender seria aquela que se é possível, sem muitas dificuldades o fluxo de um aplicativo, bem como se dá o relacionamento e coloboração entre as diferentes entidades do aplicativo.

Então, fazer uso de polimorfismo, herança, as próprias convenções utilzadas pela comunidade, nome de variáveis, classes, métodos, tudo contribui para ter um código limpo, fácil de entender e alterar.