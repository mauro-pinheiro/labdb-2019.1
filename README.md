# Lab-BD
Projetos de Lab BD

- Lab04 é um projeto de um sistema de frete, que calcula o valor de frete para diferentes cidades do Brasil
  - O objetivo desse laboratorio é avaliar a capacidade de dessenvolver uma aplicacão com java e jdbc
  - Usando Java, JavaFX, MySQL e JDBC
  - Possui duas versões do projeto (Usando Maven ou Gradle)
  - Pacote dao contem as classes que possibilitam intereção com o banco de dados
  - Pacote entidades contem as classes que abstraem as entidade (tabelas) usadas no projeto.
  - Pacote gui.fx contem a implementação da interface grafica do projeto usando javafx.
  - Pacote infra contem uma classe que cuidada da conexão com o banco de dados.
- Lab 05 é um projeto do lado servidor de uma locadora de veiculos
  - Usa Java, Mysql e JPA/Hibernate
  - O objetivo desse laboratório é avaliar a capacidade de desevolver uma aplicaço usando java e jpa/hibernate usando a metodologia test driver development.
  - Projeto: XYZRental Cars
  - Diretorio src/main contem todos os codigos do aplicativo
  - Pacote app contem o entry point do projeto
  - Pacote exceptons contem exceções customizadas
  - Pacote modelo contem as entidades do projeto
  - Racote relatorio contem classes que proporcionam geração de relatórios.
  - Pacote repositorio contem as classes que genenciam a intereção com o banco de dados pelo modelo de repositorio
  - Pacote util contem classes uteis para a execulção as tarefas da aplicação
  - Diretorio src/test contem os testes das funcionalidades do sistema
  - Diretorio mysql fora do projeto contem a modelagem do banco de dados geraada pelo hibernate para validação.
