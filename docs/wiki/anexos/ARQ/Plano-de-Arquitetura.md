Plano de Arquitetura
=================================

<small>Sumário</small>
======================

<!-- MDTOC maxdepth:2 firsth1:0 numbering:0 flatten:0 bullets:1 updateOnSave:1 -->

- [1. Introdução](#1-introdução)
   - [1.1. Finalidade](#11-finalidade)
   - [1.2. Escopo](#12-escopo)
   - [1.3. Definições, Acrônimos e Abreviações](#11-definições-acrônimos-e-abreviações)
   - [1.4. Referências](#12-referências)
- [2. Visões do Sistema](#2-visões-do-sistema)
   - [2.1. Visão de Projeto](#21-visão-de-projeto)
   - [2.2. Visão de Processo](#22-visão-de-processo)
   - [2.3. Visão de Implementação](#21-visão-de-implementação)

<!-- /MDTOC -->


## 1. Introdução

### 1.1. Finalidade
Este documento oferece uma visão macro e arquitetural do sistema SempreUFG. Neste documento será possível verificar os 
padrões arquiteturais e de projeto adotados, o sistema como um todo em diferentes visões e aspectos. O objetivo do 
documento é servidor como a base arquitetural para todo o desenvolvimento e implementação dos requisitos para o software em si.

### 1.2. Escopo
O Documento de Arquitetura de Software influencia diretamente a implementação dos requisitos não-funcionais. Para atender as 
necessidades apresentadas no documento de requisitos, este documento irá prover todas as 
informações da arquitetura que satisfará os requisitos levantados.

### 1.3. Definições, Acrônimos e Abreviações
| Termo | Significado |
|------:|-------------|
| **DOM (Document Object Model)** | Organização multi-plataforma das marcações HTML para a codificação no navegador. |
| **AJAX** | Requisição assíncrona HTTP feita pelo JavaScript para atualizar dados sem a necessidade de sair ou recarregar a página. |
| **CRUD** | São as operações básicas de um banco de dados: Criar, ler, atualizar e deletar dados. |
| **JSON** | Modo de notação de objetos baseado nos Objetos de JavaScript. |


### 1.4. Referências

-	Java Servlet [http://java.sun.com/products/servlet/]
-	Java Server Pages [http://java.sun.com/products/jsp/]
-	jQuery [http://api.jquery.com]
-	AJAX [http://api.jquery.com/jquery.ajax/] 

## 2. Visões do Sistema

### 2.1. Visão de Projeto

### 2.1. Visão de Processo
Será utilizado um container de aplicações para o deploy da aplicação (Apache Tomcat 8), que irá disponibilizar e servir as páginas JSP. Os dados serão armazenados em um banco local, podendo ser tanto o PostgreSQL, quanto o MariaDB (Utilizando o framework Hibernate). Algumas requisições dinamicas da página podem ser solicitadas por requisições AJAX do jQuery. Qualquer requisição deve ser respondida pelo servidor utilizando Servlets.

### 2.1. Visão de Implementação
A implementação da arquitetura segue o padrão de projeto MVCS, que é divido em três módulos: Visão, Controle, Serviço e Modelo.

-	**Visão** – Camada responsável pela apresentação da interface da aplicação ao usuário. As páginas implementadas utilizam Java Server Pages (JSP), Java Server Tag Lib (JSTL), HTML, JavaScript, jQuery e CSS. Para a estilização e criação das telas JSP/HTML, será utilizado o framework Bootstrap 3, e é recomendado a utilização do mesmo ao invés de estilização própria. É proibido a utilização de Scriptlets, visando a leitura e manutenibilidade do código. Utilize tags JSTL para utilizar código java nos arquivos JSP.

-	**Controle** – Camada responsável pela comunicação entre as camadas de visão e serviço. A visão pode solitar requisições assíncronas para o controle utilizando AJAX do jQuery. Para os controladores do servidor, a tecnologia Java Servlet será utilizada na implementação das classes.

-	**Serviço** – Camada responsável pela comunicação entre as camadas de controle e modelo que também implementa as regras de negócio pertinentes a requisitos funcionais. A utilizção da camada de modelo pela camada de serviço não é obrigatória, mas todas as utilizações da camada de modelo devem ser chamadas pela camada de serviço.

-  **Modelo** – Camada responsável pelo acesso a base de dados. O padrão de projeto DAO (Data Access Object) é o selecionado para a implementação das classes de interface com o banco de dados, sendo que estes por sua vez se comunicam com os bancos por meio do Hibernate.

