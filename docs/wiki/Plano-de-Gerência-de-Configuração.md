Plano de Gerência de Configuração
=================================

<small>Sumário</small>
======================

<!-- MDTOC maxdepth:2 firsth1:0 numbering:0 flatten:0 bullets:1 updateOnSave:1 -->

- [1. Introdução](#1-introdução)   
   - [1.1. Definições, Acrônimos e Abreviações](#11-definições-acrônimos-e-abreviações)   
   - [1.2. Referências](#12-referências)   
- [2. Organização, Responsabilidades, e Interfaces](#2-organização-responsabilidades-e-interfaces)   
   - [2.1. Responsabilidades dos GCOs](#21-responsabilidades-dos-gcos)   
   - [2.2. Responsabilidades da equipe de desenvolvimento em relação à GCO](#22-responsabilidades-da-equipe-de-desenvolvimento-em-relação-à-gco)   
- [3. A Gerência de Configuração](#3-a-gerência-de-configuração)   
   - [3.1. Artefatos da Gerência de Configuração](#31-artefatos-da-gerência-de-configuração)   
   - [3.2. Ferramentas e Tecnologias](#32-ferramentas-e-tecnologias)   
   - [3.3. Identificação da Configuração](#33-identificação-da-configuração)   
   - [3.4. Commits](#34-commits)   
   - [3.5. Branches](#35-branches)   
   - [3.6. Estrutura do Repositório](#36-estrutura-do-repositório)   
   - [3.7. Controle de mudanças](#37-controle-de-mudanças)   
   - [3.8. Baselines](#38-baselines)   

<!-- /MDTOC -->

## 1. Introdução
Este **Plano de Gerência de Configuração** apresenta todas as tarefas do
Gerenciamento de Configuração e Mudanças neste projeto. Nesse documento detalha-se toda a infraestrutura
utilizada neste projeto e como contribuir no mesmo.

### 1.1. Definições, Acrônimos e Abreviações

| Termo | Significado |
|------:|-------------|
| [**Baseline/Tag**](https://en.wikipedia.org/wiki/Baseline_%28configuration_management%29) | **Linha de referência** / "etiqueta" marcando ponto no desenvolvimento de software em que seus artefatos estão supostamente estáveis. |
| [**Branch**](https://en.wikipedia.org/wiki/Branching_%28version_control%29) | **Ramificação** / contexto de trabalho paralelo no desenvolvimento de software. |
| [**CamelCase**](https://pt.wikipedia.org/wiki/CamelCase) | forma de representação **escrita** de palavras compostas ou frases iniciadas por maiúsculas e unidas sem espaços. |
| [**CI**](https://en.wikipedia.org/wiki/Continuous_integration) | **Integração Contínua** (do inglês *Continuous Integration*), prática de fundir e verificar funcionamento de partes de software, várias vezes ao dia. |
| [**Commit**](https://en.wikipedia.org/wiki/Commit_%28version_control%29) | **Revisão**, de (todo ou parte de) um código-fonte num VCS. |
| [**GCO / GCS**](https://pt.wikipedia.org/wiki/Ger%C3%AAncia_de_configura%C3%A7%C3%A3o_de_software) | **Gerência de Configuração de Software**, área da Engenharia de Software que fornece apoio para o desenvolvimento de software. |
| [**IDE**](https://pt.wikipedia.org/wiki/Ambiente_de_desenvolvimento_integrado) | **Ambiente de Desenvolvimento Integrado** (do inglês *Integrated Development Environment*), software que reúne ferramentas para auxiliar e agilizar o desenvolvimento de software. |
| [**Issue**](https://en.wikipedia.org/wiki/Project_management_software) | **Incidente** / *card* / atividade ou pacote de trabalho dentro de um Sistema de Gerenciamento de Projetos. |
| [**Markdown**](https://en.wikipedia.org/wiki/Markdown) | Linguagem de Marcação Leve ([LML](https://en.wikipedia.org/wiki/Lightweight_markup_language)) para **documentos**. |
| [**Merge**](https://pt.wikipedia.org/wiki/Fus%C3%A3o_%28controle_de_vers%C3%A3o%29) | Operação em VCS que funde / **mescla** várias revisões em uma só. |
| [**Milestone**](https://en.wikipedia.org/wiki/Milestone_%28project_management%29) | **Marco do projeto**, reúne *Issues* / *PR*s para futura entrega de um software (ou parte dele) para um cliente. |
| [**PR**](https://en.wikipedia.org/wiki/Distributed_version_control#Pull_requests) | *Pull Request*, **solicitação de mudança** que é feita para administradores de um repositório decidirem se uma contribuição pode fazer parte do código-fonte do mesmo. |
| [**Push**](https://en.wikipedia.org/wiki/Version_control#Common_vocabulary) | Comando em alguns VCS para **enviar mudanças** (*commits*) para um repositório remoto. |
| [**VCS**](https://pt.wikipedia.org/wiki/Sistema_de_controle_de_vers%C3%B5es) | **Sistema de Controle de Versões** (do inglês *Version Control System*), software usado para fazer Gerência de Configuração. |

### 1.2. Referências

###### i. SANTOS, Gustavo Moraes dos et al. Template de Plano de Gerenciamento de Configuração. Disponível em: <http://github.com/gabrielaimeeg/DroidMetronome/wiki/TEMPLATE-Plano-de-Gerenciamento-de-Configuração>. Acesso em: 28 mar. 2015.

###### ii. OLIVEIRA, J. L. Diretrizes para Membros da Equipe. Disponível em: <https://github.com/ES-INF-UFG-2016-2/Sempre-UFG/blob/develop/docs/wiki/extras/documentos-do-professor-juliano/diretrizes-para-membros-da-equipe.pdf>. Acesso em: 2 out. 2016.

###### iii. OLIVEIRA, J. L. Requisitos de Software - SempreUFG. Disponível em: <https://github.com/ES-INF-UFG-2016-2/Sempre-UFG/blob/develop/docs/wiki/extras/documentos-do-professor-juliano/requisitos-de-software-para-sempre-ufg-2016.pdf>. Acesso em: 2 out. 2016.

###### iv. WERNER, Tom Preston. Semantic versioning 2.0.0. Disponível em: <http://semver.org>. Acesso em: 28 mar. 2015.

## 2. Organização, Responsabilidades, e Interfaces
A gerência de configuração faz um papel fundamental para que o
desenvolvimento não seja prejudicado por informações inconsistentes.
Dessa forma, o gerente de configuração é responsável por controlar todas
as mudanças e disponibilizar a todos os envolvidos as versões e os itens
de configuração corretos e íntegros (artefatos de software) para que
inconsistências não atrapalhem a evolução do desenvolvimento (auditoria
das configurações) e permita uma melhor comunicação entre os membros da
equipe.

#### Gerentes de Configuração (GCOs)

| Grupo   | Gerente  de Configuração                     |
|---------|----------------------------------------------|
| Grupo 1 | **Gustavo Moraes dos Santos** @gustavosotnas |
| Grupo 2 | **Leonardo Freitas dos Santos** @leonardo-freitas-1995 |
| Grupo 3 |**Yuri Matheus Dias Pereira** @Yuri-M-Dias

### 2.1. Responsabilidades dos GCOs

* Supervisionar andamento das branches;
* Fazer e controlar as issues (pacotes de trabalho);
* Aprovar solicitações de merges (Pull Requests) sem "commits quebrados" – commits com código-fonte com erros de compilação / nos testes;
* Manter o padrão de diretórios dos repositórios (organização);

### 2.2. Responsabilidades da equipe de desenvolvimento em relação à GCO

* Usar as ferramentas sugeridas (seção [3.2](#32-ferramentas-e-tecnologias));
* Seguir os padrões de commit, da estrutura de repositórios e branches;
* Usar as issues para gerência de atividades, e comunicação e rastreabilidade entre requisitos e código-fonte.
* Fazer milestones para registrar os marcos do projeto;
* Fazer a baseline no final de cada iteração.

## 3. A Gerência de Configuração

### 3.1. Artefatos da Gerência de Configuração

A Gerência de Configuração trabalhará em alto nível sob os seguintes conjuntos de artefatos:

* [Código fonte](../../../../)
* [Documentação](../)
* [Quadro de atividades do projeto](https://trello.com/b/CH0jPQVT)
* [Requisições de Mudança (*Pull Requests*)](../../../../pulls)
* [Baselines](../../../../releases)

### 3.2. Ferramentas e Tecnologias

#### Ferramentas

| Tipo | Ferramenta | Versão* |
|-----:|:-----------|:-------:|
| VCS | [Git](http://git-scm.com) | 2.4.2 ou superior |
| Cliente em GUI para VCS | [SmartGit](http://www.syntevo.com/smartgit) | 7.1.4 ou superior |
| Sistema de Repositório | [GitHub](https://github.com) | – |
| Plataforma de programação | [Java (JDK)](http://www.oracle.com/technetwork/pt/java/javase/downloads/index.html) | 1.8 |
| IDE | [IntelliJ IDEA Community](https://www.jetbrains.com/idea) | 2016 ou superior |
| IDE | [NetBeans IDE](https://netbeans.org) | 8.0 ou superior |
| CI | [Travis CI](https://travis-ci.org) | – |
| Análise estática de código | [SonarQube](http://www.sonarqube.org) | 6.1 ou superior |
| Editor de texto *Markdown* | [Atom](http://atom.io) | 1.8.0 ou superior |
| Editor de diagramas | [Astah Community]() | 6.9.0 ou superior |
| Editor de protótipos | [prikhi Pencil](https://github.com/prikhi/pencil) <br> com *stencil collection* [*Bootstrap*](https://github.com/nathanielw/Bootstrap-Pencil-Stencils) | 2.0.18 ou superior |
| Editor de Imagens |[GIMP](http://www.gimp.org) | 2.8.0 ou superior |
| Editor de Desenho Vetorial |[Inkscape](https://inkscape.org) | 0.48.0 ou superior |
| Gerência de projeto | [Trello](https://trello.com) | – |
| Controle de mudanças | [GitHub Pull Requests](../../../../pulls) | – |
| *Bug Tracker* | [GitHub Issues](../../../../issues) | – |

\* "**–**" – *sistema Web, sempre será última versão.*

#### Tecnologias

| Tipo | Tecnologia | Versão |
|-----:|:-----------|:------:|
| Linguagem de Programação | [Java](http://www.oracle.com/technetwork/pt/java/javase/downloads/index.html) | 8 Update 91 |
| Gerenciamento / automação de *build* | [Apache Maven](https://maven.apache.org) | 3.0.4 ou superior |
| Contêiner de Desenvolvimento | [Apache Tomcat](http://tomcat.apache.org) | 7.33 ou superior |
| Framework Web | [Java Servlet](https://jcp.org/en/jsr/detail?id=315) | 3.0 ou superior  |
| Banco de Dados | [MariaDB](https://mariadb.org) | 5.5 ou superior |
| Banco de Dados | [PostgreSQL](https://www.postgresql.org) | 9.5 ou superior |
| Framework de persistência (ORM) | [Hibernate](http://hibernate.org) | 2.1 |
| Framework de Apresentação (Front-end) | [Java ServerFaces](https://javaserverfaces.java.net) | 2.3.0 ou superior |
| Linguagem de script para cliente Web (Front-end) | [JavaScript](https://developer.mozilla.org/pt-BR/docs/Web/JavaScript) | ECMAScript3 |
| Framework de Estilo (Front-end) | [Twitter Bootstrap](http://getbootstrap.com) | 3.3 ou superior |
| Framework de JavaScript (Front-end)| [JQuery](https://jquery.com) | 3.0 ou superior |

### 3.3. Identificação da Configuração

Todos os artefatos gerados no projeto – com exceção do código fonte no *repositório principal* – terão o seguinte método de identificação:

`<Tipo_do_artefato>_<Identificador>.<ext>`

| Identificador | Descrição |
|---------------|-----------|
| `<Tipo_do_artefato>` | Tipo do artefato. Ex.: *"Processo de...", "Diagrama de Classes", "Protótipo"*, etc.
| `<Identificador>` | Algum número, data ou frase que identifique unicamente o arquivo. Ex.: *"121", "18-02-2016", "Avaliação de Provas"*, etc.
| `<ext>` | A extensão do arquivo. Ex.: *png, ep, asta, bpm*, etc.

O código-fonte no *repositório principal* deve seguir os [convenções de código do Java](http://javascript.crockford.com/javacodeconventions.pdf) e os padrões da [Fábrica de Software do INF/UFG](http://fabrica.inf.ufg.br).

### 3.4. Commits

#### Padrão de mensagem de commit

* Mensagem **sucinta** e **objetiva** sobre o conteúdo do commit
* Tamanho: de 15 a 50 caracteres
* Verbo na 3º pessoa do presente simples + complemento (o que mudou no projeto)
	* Exemplos:
		* `Adiciona diagrama de classes`
		* `Refatora função X`
		* `Otimiza funcionalidade "Enviar email"`
		* `Conserta bug #13`

#### Frequência de commit

* Pelo menos **1x por dia** por tarefa delegada ao membro da equipe ou assim que uma parte signficativa da tarefa foi realizada e será continuada posteriormente (*commit* como um "[***checkpoint***](https://en.wikipedia.org/wiki/Application_checkpointing)", ponto "estável" que pode ser retornado – [*respawning*](https://en.wikipedia.org/wiki/Spawning_(video_gaming) –  em caso de falhas posteriores / erro humano / perda de dados).
* Os commits devem ser enviados ("*push*") ao repositório principal ***semanalmente***. **Não devem ser feitos commits apenas localmente** na máquina do integrante do grupo, mesmo que eles tenham sido feitos na frequência estipulada acima.

### 3.5. Branches

O repositório de código fonte deve ter no mínimo **três** branches:

| Branch | Descrição | Responsável (is) |
|--------|-----------|------------------|
| **`develop`** | branch de *desenvolvimento* de software dos grupos | [**@ES-INF-UFG-2016-2/GCOs**](https://github.com/orgs/ES-INF-UFG-2016-2/teams/GCOs) / [***@ES-INF-UFG-2016-2/grupo1***](https://github.com/orgs/ES-INF-UFG-2016-2/teams/grupo1) / [***@ES-INF-UFG-2016-2/grupo2***](https://github.com/orgs/ES-INF-UFG-2016-2/teams/grupo2) / [***@ES-INF-UFG-2016-2/grupo3***](https://github.com/orgs/ES-INF-UFG-2016-2/teams/grupo3)
| **`homolog`** | branch de *homologação* / V&V dos artefatos antes de serem colocados na branch **master**. | [**@julianolopes**](https://github.com/julianolopes) /  [**@ES-INF-UFG-2016-2/GCOs**](https://github.com/orgs/ES-INF-UFG-2016-2/teams/GCOs)
| **`master`**  | branch que contém a *versão estável* de todos os artefatos do projeto (branch padrão). | [**@julianolopes**](https://github.com/julianolopes)

#### Branches para os grupos

As branches `develop`, `homolog` e `master` são bloqueadas para a maioria dos integrantes fazerem *push*. Para enviar *commits* para essas branches é necessário fazer o seguinte procedimento:

1. O integrante que está em determinado grupo cria uma ***branch*** **temporária** para seu uso próprio a partir da branch **`develop`**; <br> A branch deve ter como nome:
	* *O prefixo de* ***nome do grupo +*** *o nome da tarefa / requisito / funcionalidade que será feito nela.*  
	Exemplos:
		* `G1-RF-ExecCons`
		* `G3-RD-AprovDivulgInfo`
2. Na nova branch, o integrante trabalha no projeto (faz *commits* na sua branch);
3. Quando terminar, o integrante faz um ***PR*** para a branch **`develop`** e aguarda os [**GCOs**](https://github.com/orgs/ES-INF-UFG-2016-2/teams/GCOs) fazerem auditoria de configuração (*review*):
	* Se o *PR* é **aprovado**, *commits* do integrante nessa branch vão para a branch `develop`;
	* Se ***reprovado***, o integrante deve corrigir (fazendo novos *commits* na branch do *PR*).

O fluxo de desenvolvimento de software na visão da GCS – com o esquema das três principais branches no repositório do **Sempre UFG** – está ilustrado abaixo:

![Politica-de-GCO](./anexos/GCO/politica-de-branches/Politica-de-GCO.png)

### 3.6. Estrutura do Repositório

> * ***anexos***
>    - ***Arquitetura***
>		+ *Arquivos de anexo para arquitetura (diagramas, planos)*
>    - ***Teste***
>		+ *Arquivos de anexo para testes*
> * ***db***
>    - ***ddl***
>		+ *Arquivos .sql de DDL*
>    - ***dml***
>		+ *Arquivos .sql de DML*
> * ***docs***
>    - ***wiki***
>		+ *Arquivos da wiki do repositório*
> * ***src***
>    - ***main***
>		+ ***resources***
>			* Recursos
>		+ ***java/br/ufg/inf/***
>			* ***abstratas***
>				* Classes abstratas
>			* ***config***
>				* Classes configurações
>			* ***dao***
>				* Classes de Data Access Object
>			* ***db***
>				* Classes de conexão ao banco
>			* ***enums***
>				* Classes de enum
>			* ***interfaces***
>				* Interfaces java
>			* ***modelo***
>				* Classes de entidade
>			* ***servico***
>				* Classes de serviço com regras de negócio
>			* ***servlet***
>				* Classes de comunicação HTTP
>			* ***utils***
>				* Classes utilitárias / ferramentas
>    - ***test***
>		+ ***resources***
>			* Recursos para testes
>		+ ***java/br/ufg/inf/***
>			* ***config***
>				* Classes que testam configurações configurações
>			* ***dao***
>				* Classes que testam persistência no banco
>			* ***db***
>				* Classes que testam conexão ao banco / scrips sql
>			* ***modelo***
>				* Classes que testam entidades
>			* ***servico***
>				* Classes que testam regras de negócio
>			* ***servlet***
>				* Classes que testam comunicação HTTP
>			* ***stubs***
>				* Stubs para testes

Qualquer alteração na estrutura de pastas (como por exemplo, uma necessidade de um novo pacote devido a uma classe não se encaixar a nenhuma categoria de pacote na estrutura atual) deve ser discutida diretamente com um membro da equipe de GCO. O pedido de alteração na estrutura pode ser feito diretamente por comentário no Pull Request da alteração desejada.

### 3.7. Controle de mudanças

* Gerenciamento de issues (também chamados de "**pacotes de trabalho**")
	* 4 principais tipos:
		* **Bug**
			* Tarefas para solicitar correção de defeitos no sistema detectados durante sua execução.
		* **Melhoria**
			* Tarefas que propõem uma manutenção de qualquer natureza no sistema.
		* **Nova funcionalidade**
			* Tarefas para implementar incrementos no escopo do sistema.
		* **Questionamento**
			* Issues para discutir questões relevantes sobre o negócio ou o projeto do sistema.
	* 4 situações:
		* Backlog (a fazer)
		* Em execução
			* Pode-se abrir questionamento (adiciona label e referencia usuário(s)).
		* Em homologação
			* Esperando análise de Pull Request.
		* Close
			* Implementada, validada e aprovada.
* Merges (Pull Requests)
	* Analisadas pelos GCO e ferramenta de Integração Contínua (CI).
		* GCOs usarão "Code Review" para relatar a análise

### 3.8. Baselines

Para que se dê a criação de uma baseline, é necessário que os GCOs tenham feito a análise das tarefas feitas na iteração do projeto, e as ferramentas de testes automatizados, análises estáticas de código e integração contínua (CI) tenham aprovado todo o código-fonte até aquele ponto do projeto previamente.

#### Tag

As baselines serão "etiquetadas" com o seguinte formato, a partir do número 0 (zero):

`<major>.<minor>.<patch>`

E serão construídas com as seguintes orientações:

* Quebra de compatibilidade com versões anteriores, avança o `<major>`.
* Adição de novas funcionalidades sem quebrar compatibilidade com versões anteriores, avança o `<minor>`.
* Correção de bugs e outras alterações, avança `<patch>`.

*Semântica de versionamento baseada no "Semantic Versioning 2.0.0". Para mais informações, visite o site do* ***semver*** *na Internet [[iii]](#iii-semantic-versioning-v20-semver-disponivel-em-httpsemverorg-acesso-em-28-mar-2015).*

#### Notas de release

Ao criar uma nova baseline no projeto no [GitHub](http://github.com), há opção de colocar notas de release e anexar um arquivo executável do projeto em questão. As notas de release deverão ser feitas em texto na linguagem *Markdown* no seguinte esqueleto:

```markdown
### Histórico de mudanças
* Novo: (...)
* Correção: (...)
* Melhoria: (...)
* Menor: (...)
```

O repositório será versionado com versão `1.0` quando o software for lançado.
