# gerenciadorRestaurante

Esta aplicação foi desenvolvida utilizando o Java 18 como base de desenvolvimento e spring boot.
Para iniciar a utilização deve estar configurado uma base de dados MySQL 8.16 local ou em um servidor de sua escolha. Sendo assim o arquivo property da API deve ser alterado. Conforme as suas necessidades.
Foram utilizados estes Scripts para a criação da base de dados:
CREATE DATABASE maida;
CREATE USER 'maida’@’%’ IDENTIFIED BY ‘maida’;
GRANT ALL PRIVILEGES ON maida . * TO ‘maida’@’%’;
FLUSH PRIVILEGES;
Foi utilizado o spring security e jwt para garantir a segurança da API: ela contém dois endpoints livres de autenticação são eles:
**Restaurante/user/create :** para criar os usuários para acesso. Podendo ser do tipo CLIENTE ou GESTOR.
Obedecendo as seguintes regras:
- Poderá ser cadastrado apenas um usuário GESTOR na aplicação.
- os usuários do tipo cliente terão apenas um usuário por email.
- Para a perfeita execução do modulo de pedidos, deve estar devidamente cadastrado o usuario gestor e os produtos que serão vendidos.

**restaurante/user/login :** para obter o token de acesso para as demais funcionalidades 

O usuário cliente terão as seguintes funcionalidades disponíveis.
- **adição de informações pessoais -** Para se tornar um cliente.
- **gerenciar endereços –** podendo adicionar mais de um endereço. Terá as seguintes ações habilitadas. Incluir, alterar, excluir, pesquisar e carregar
- **criar pedidos –** podendo selecionar os produtos desejados. E assim abrir o pedido para o estabelecimento. Se o pedido estiver em espera o cliente pode cancelar. Poderá carregar os pedidos relacionados ao seu usuário, assim podendo acompanhar o andamento do Mesmo

Já o usuário do tipo GESTOR terá as seguintes funcionalidades:
- **Gerenciar produtos -** disponíveis, podendo realizar as seguintes ações: incluir, alterar, excluir, pesquisar e carregar.
- **Gerenciar os pedidos -** podendo atender ou cancelar o pedido. Podendo realizar as seguintes ações: alterar status do pedido, pesquisar, carregar e excluir
- **gerenciar os clientes -** podendo pesquisar, alterar, carregar e excluir se assim desejar. Assim, também acontecera com os usuários

Foi criado uma documentação swagger com o apidoc 
Que fica no [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

As credenciais dos usuários são geradas através do jwt. Fornecendo um token de acesso. Para acesso das funcionalidades do sistema. Com tempo de expiração de 10 minutos.
Para acessar deve fornecer o email cadastrado e senha de acesso.

criado por Bruno Alves carneiro 